package pluzivog.pluzivog.handlers;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import pluzivog.pluzivog.Pluzivog;

import java.util.Set;

public class SpecialItemHandler implements Listener {
    public SpecialItemHandler(Pluzivog plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onSpecialItemEquip(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();
        int slot = event.getSlot();

        if (event.getCurrentItem() == null) return;

        ItemMeta meta = event.getCurrentItem().getItemMeta();

        if (meta == null) return;

        PersistentDataContainer data = meta.getPersistentDataContainer();

        if (data == null) return;

        Set<NamespacedKey> keys = data.getKeys();

        if (keys == null) return;

        for (NamespacedKey namespacedKey : keys) {
            PotionEffectType potionEffectType = PotionEffectType.getByKey(namespacedKey);
            if (potionEffectType != null) {
                PotionEffect potionEffect = new PotionEffect(potionEffectType, Integer.MAX_VALUE, data.get(namespacedKey, PersistentDataType.INTEGER), true, false, true);
                player.addPotionEffect(potionEffect);
            }
        }


    }
}
