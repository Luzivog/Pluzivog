package pluzivog.pluzivog.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pluzivog.pluzivog.Pluzivog;
import pluzivog.pluzivog.shopItems.HermesBoots;
import pluzivog.pluzivog.shopItems.IcaresWings;
import pluzivog.pluzivog.shopItems.MidasPickaxe;
import pluzivog.pluzivog.shopItems.ShopItem;


import java.util.HashMap;
import java.util.Map;

public class Shop implements Listener, CommandExecutor {

    private String invName = "Shop";
    private HashMap<Integer, ShopItem> items = new HashMap<>();

    private ItemStack background = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);

    private int size = 27;


    public Shop(Pluzivog plugin) {

        this.items.put(11, new MidasPickaxe());
        this.items.put(13, new IcaresWings());
        this.items.put(15, new HermesBoots());

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(invName)) return;

        event.setCancelled(true);

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        ShopItem shopItem = this.items.get(slot);

        if (shopItem == null) return;

        int price = shopItem.getPrice();

        if (player.getInventory().contains(Material.DIAMOND, price)) {
            player.getInventory().removeItem(new ItemStack(Material.DIAMOND, price));
            player.getInventory().addItem(shopItem.getItem());
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can run this command.");
            return true;
        }

        Player player = (Player) sender;

        Inventory inv = Bukkit.createInventory(player, size, this.invName);

        for (int key : this.items.keySet()) {
            ShopItem shopItem = this.items.get(key);
            inv.setItem(key, shopItem.getShopItem());
        }

        for (int i = 0; i<size; i++)
            if (inv.getItem(i) == null)
                inv.setItem(i, background);

        player.openInventory(inv);

        return true;
    }

}
