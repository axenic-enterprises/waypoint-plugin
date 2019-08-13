package de.axenic.waypoint;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * A singleton that represents the Waypoint plugin in code.
 */
public final class WPPlugin extends JavaPlugin {

    //region Singleton Pattern
    /**
     * The only instance of {@link WPPlugin} that will exist.
     */
    private static WPPlugin instance;

    /**
     * Returns the singleton instance of {@link WPPlugin}.
     * @return the singleton instance of {@link WPPlugin}
     */
    public static WPPlugin getPlugin() {
        return instance;
    }

    /**
     * <b>BUKKIT-ONLY CONSTRUCTOR!</b><br>
     * Do not use this constructor to instantiate {@link WPPlugin}.
     * Instead, obtain a singleton instance via {@link #getPlugin()}.
     */
    public WPPlugin() {
        instance = this;
    }
    //endregion

    /**
     * Called when the plugin is enabled by the server.
     */
    @Override
    public void onEnable() {
        getServer().getPluginCommand("waypoint").setExecutor(WPCommandExecutor.getExecutor());
    }

    /**
     * Called when the plugin is disabled by the server.
     */
    @Override
    public void onDisable() {

    }

}
