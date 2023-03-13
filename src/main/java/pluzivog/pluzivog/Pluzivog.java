package pluzivog.pluzivog;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pluzivog.pluzivog.commands.Shop;
import pluzivog.pluzivog.handlers.SpecialItemHandler;

public final class Pluzivog extends JavaPlugin {

    private static Pluzivog plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Pluzivog au rapport!");

        new SpecialItemHandler(this);

        this.getCommand("shop").setExecutor(new Shop(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        Bukkit.getLogger().info("Pluzivog s'endort!");
    }

    public static Pluzivog getPlugin() {
        return plugin;
    }
}
