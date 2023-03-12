package pluzivog.pluzivog.shopItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import pluzivog.pluzivog.utils.ItemCreator;

public class IcaresWings extends ShopItem {

    public IcaresWings() {

        this.itemCreator = new ItemCreator(Material.ELYTRA);
        this.price = 20;

        this.itemCreator.setName("&eAiles d'Icares");
        this.itemCreator.setLore("&d&oAiles mythiques retombées sur", "&d&oTerre après la mort d'Icare...");

        this.itemCreator.addEnchant(Enchantment.DURABILITY, 3);
        this.itemCreator.addEnchant(Enchantment.MENDING, 1);

    }

}
