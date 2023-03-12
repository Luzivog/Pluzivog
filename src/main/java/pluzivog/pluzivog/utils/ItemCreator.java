package pluzivog.pluzivog.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ItemCreator {

    private ItemStack itemStack;

    public ItemCreator(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemCreator(ItemCreator itemCreator) {
        this.itemStack = new ItemStack(itemCreator.getItemStack().getType());

        this.setName(itemCreator.getName());
        this.setLore(itemCreator.getLore());

        Map<Enchantment, Integer> enchantments = itemCreator.getItemStack().getEnchantments();

        if (enchantments != null) {
            for (Enchantment ench : enchantments.keySet()) {
                this.addEnchant(ench, enchantments.get(ench));
            }
        }
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public String getName() {
        ItemMeta meta = this.getItemStack().getItemMeta();
        return meta.getDisplayName();
    }

    public void setName(String name) {
        if (name == null) return;
        ItemMeta meta = this.getItemStack().getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
        this.getItemStack().setItemMeta(meta);
    }

    public List<String> getLore() {
        ItemMeta meta = this.getItemStack().getItemMeta();
        List<String> lores = meta.getLore();
        return lores;
    }

    public void clearLore() {
        ItemMeta meta = this.getItemStack().getItemMeta();
        meta.setLore(new ArrayList<>());
        this.getItemStack().setItemMeta(meta);
    }

    public void setLore(List<String> lores) {
        if (lores == null) return;
        this.clearLore();
        for (String lore : lores) {
            addLore(lore);
        }
    }
    public void setLore(String ... lores) {
        if (lores == null) return;
        this.clearLore();
        for (String lore : lores) {
            addLore(lore);
        }
    }

    public void addLore(String lore) {

        if (lore == null) return;

        ItemMeta meta = this.getItemStack().getItemMeta();

        if (meta != null) {
            List<String> lores = meta.getLore();
            if (lores == null) lores = new ArrayList<>();

            lores.add(ChatColor.translateAlternateColorCodes('&', lore));
            meta.setLore(lores);

            this.getItemStack().setItemMeta(meta);
        }
    }

    public void addEnchant(Enchantment enchant, int level) {
        this.getItemStack().addUnsafeEnchantment(enchant, level);
    }
}
