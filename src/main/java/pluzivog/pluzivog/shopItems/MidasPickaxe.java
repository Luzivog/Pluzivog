package pluzivog.pluzivog.shopItems;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import pluzivog.pluzivog.utils.ItemCreator;

public class MidasPickaxe extends ShopItem {

    public MidasPickaxe() {

        this.itemCreator = new ItemCreator(Material.DIAMOND_PICKAXE);
        this.price = 20;

        this.itemCreator.setName("&ePioche de Midas");
        this.itemCreator.setLore("&d&oPioche mythique qui fut détenue par", "&d&ole roi Midas, fils de Gordias...");

        this.itemCreator.addEnchant(Enchantment.DIG_SPEED, 5);
        this.itemCreator.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 4);
        this.itemCreator.addEnchant(Enchantment.DURABILITY, 3);
        this.itemCreator.addEnchant(Enchantment.MENDING, 1);

    }

}
