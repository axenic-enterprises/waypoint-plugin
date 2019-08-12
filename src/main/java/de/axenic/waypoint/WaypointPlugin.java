package de.axenic.waypoint;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * A singleton that represents the Waypoint plugin in code.
 */
public final class WaypointPlugin extends JavaPlugin {

    //region Singleton Pattern
    /**
     * The only instance of {@link WaypointPlugin} that will exist.
     */
    private static WaypointPlugin instance;

    /**
     * Returns the singleton instance of {@link WaypointPlugin}.
     * @return the singleton instance of {@link WaypointPlugin}
     */
    public static WaypointPlugin getPlugin() {
        return instance;
    }

    /**
     * <b>BUKKIT-ONLY CONSTRUCTOR!</b><br>
     * Do not use this constructor to instantiate {@link WaypointPlugin}.
     * Instead, obtain a singleton instance via {@link #getPlugin()}.
     */
    public WaypointPlugin() {
        instance = this;
    }
    //endregion

    /**
     * Called when the plugin is enabled by the server.
     */
    @Override
    public void onEnable() {

    }

    /**
     * Called when the plugin is disabled by the server.
     */
    @Override
    public void onDisable() {

    }

}
