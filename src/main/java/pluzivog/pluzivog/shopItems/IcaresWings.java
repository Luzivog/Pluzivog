package pluzivog.pluzivog.shopItems;

import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import pluzivog.pluzivog.utils.ItemCreator;

import java.util.UUID;

public class IcaresWings extends ShopItem {

    public IcaresWings() {

        this.itemCreator = new ItemCreator(Material.ELYTRA);
        this.price = 20;

        this.itemCreator.setName("&eAiles d'Icares");
        this.itemCreator.setLore("&d&oAiles mythiques retombées sur", "&d&oTerre après la mort d'Icare...");

        this.itemCreator.addEnchant(Enchantment.DURABILITY, 3);
        this.itemCreator.addEnchant(Enchantment.MENDING, 1);
        this.itemCreator.addAttribute(Attribute.GENERIC_MAX_HEALTH, "generic.maxHealth", 8, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);

    }

}
