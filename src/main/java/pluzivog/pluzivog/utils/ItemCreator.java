package pluzivog.pluzivog.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class ItemCreator {

    private ItemStack itemStack;

    public ItemCreator(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemCreator(ItemCreator itemCreator) {
        this.itemStack = itemCreator.itemStack.clone();
    }

    public ItemCreator(ItemStack itemStack) {
        this.itemStack = itemStack.clone();
    }

    public ItemStack getItemStack() {
        return this.itemStack;
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

    public void addAttribute (Attribute attribute, String name, double amount, AttributeModifier.Operation operation, EquipmentSlot eqpmSlot) {
        ItemMeta meta = this.getItemStack().getItemMeta();
        meta.addAttributeModifier(attribute, new AttributeModifier(UUID.randomUUID(), name, amount, operation, eqpmSlot));
        this.getItemStack().setItemMeta(meta);
    }

    public void addPotionEffectType (PotionEffectType potionEffectType, int amplifier) {
        if (potionEffectType == null) return;
        ItemMeta meta = this.getItemStack().getItemMeta();
        meta.getPersistentDataContainer().set(potionEffectType.getKey(), PersistentDataType.INTEGER, amplifier);
        this.getItemStack().setItemMeta(meta);
    }

}
