package pluzivog.pluzivog.shopItems;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import pluzivog.pluzivog.utils.ItemCreator;

public abstract class ShopItem {

    int price;
    ItemCreator itemCreator;

    public int getPrice() {
        return this.price;
    }

    public ItemCreator getItemCreator() {
        return this.itemCreator;
    }

    public ItemStack getItem() {
        return this.itemCreator.getItemStack();
    }


    public ItemStack getShopItem() {
        ItemCreator shopItemCreator = new ItemCreator(this.getItemCreator());
        shopItemCreator.addLore("");
        shopItemCreator.addLore("&9Prix : " + getPrice() + " diamants");
        return shopItemCreator.getItemStack();
    }

}
