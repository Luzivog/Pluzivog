package pluzivog.pluzivog.shopItems;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.potion.PotionEffectType;
import pluzivog.pluzivog.utils.ItemCreator;

public class HermesBoots extends ShopItem {

    public HermesBoots() {

        this.itemCreator = new ItemCreator(Material.DIAMOND_BOOTS);
        this.price = 20;

        this.itemCreator.setName("&eBottes d'Hermès");
        this.itemCreator.setLore("&d&oBottes ayant tranversée les cieux", "&d&oaux pieds d'Hermès...");

        this.itemCreator.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
        this.itemCreator.addEnchant(Enchantment.WATER_WORKER, 3);
        this.itemCreator.addEnchant(Enchantment.PROTECTION_FALL, 4);
        this.itemCreator.addEnchant(Enchantment.DURABILITY, 3);
        this.itemCreator.addEnchant(Enchantment.MENDING, 1);
        this.itemCreator.addAttribute(Attribute.GENERIC_MOVEMENT_SPEED, "generic.movementSpeed", 0.8, AttributeModifier.Operation.ADD_SCALAR, EquipmentSlot.FEET);

    }

}
