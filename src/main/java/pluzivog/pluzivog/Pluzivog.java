package pluzivog.pluzivog;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pluzivog.pluzivog.commands.Shop;

public final class Pluzivog extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Pluzivog au rapport!");

        this.getCommand("shop").setExecutor(new Shop(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("Pluzivog s'endort!");
    }
}
