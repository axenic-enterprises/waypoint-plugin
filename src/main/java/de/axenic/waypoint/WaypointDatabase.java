package de.axenic.waypoint;

import java.io.Serializable;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * A singleton that represents the collection of all in-game shared and personal waypoints.
 */
public final class WaypointDatabase implements Serializable {

    //region Singleton Pattern
    /**
     * The only instance of {@link WaypointDatabase} that will exist.
     */
    private static WaypointDatabase instance;

    /**
     * Returns the singleton instance of {@link WaypointDatabase}.
     * @return the singleton instance of {@link WaypointDatabase}
     */
    public static WaypointDatabase getDatabase() {
        return instance;
    }

    /**
     * Private constructor.
     */
    private WaypointDatabase() {}
    //endregion

    /**
     * A set containing all shared waypoints.
     */
    private Set<Waypoint> shared = new CopyOnWriteArraySet<>();

    /**
     * A map containing any player's personal waypoints mapped to their UUID.
     */
    private ConcurrentMap<UUID, Set<Waypoint>> personal = new ConcurrentHashMap<>();
}
