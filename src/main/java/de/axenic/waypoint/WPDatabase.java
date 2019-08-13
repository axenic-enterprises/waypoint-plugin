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
public final class WPDatabase implements Serializable {

    //region Singleton Pattern
    /**
     * The only instance of {@link WPDatabase} that will exist.
     */
    private static WPDatabase instance;

    /**
     * Returns the singleton instance of {@link WPDatabase}.
     *
     * @return the singleton instance of {@link WPDatabase}
     */
    public static WPDatabase getDatabase() {
        return instance;
    }

    /**
     * Private constructor.
     */
    private WPDatabase() {
    }
    //endregion

    /**
     * A set containing all shared waypoints.
     */
    private Set<Waypoint> shared = new CopyOnWriteArraySet<>();

    /**
     * A map containing any player's personal waypoints mapped to their UUID.
     */
    private ConcurrentMap<UUID, Set<Waypoint>> personal = new ConcurrentHashMap<>();

    /**
     * Makes a waypoint publicly available to all players.
     *
     * @param waypoint the waypoint to be shared
     */
    public void shareWaypoint(Waypoint waypoint) {
        shared.add(waypoint);
    }

    /**
     * Stops sharing a waypoint.
     *
     * @param waypoint the waypoint to be not shared anymore
     * @return {@code true} if the specified waypoint was shared before, {@code false} otherwise
     */
    public boolean unshareWaypoint(Waypoint waypoint) {
        return shared.remove(waypoint);
    }

    /**
     * Adds a waypoint to a player's list of waypoints. Only if no waypoint with the name of the waypoint to be
     * newly added does not exist, the add process will be successful. In other words, a player cannot have to
     * waypoints of the same name.
     *
     * @param uuid the UUID of the player whose list should be added the waypoint
     * @param waypoint the waypoint to add
     * @return {@code true} if a waypoint with the specified waypoint's name did not exist before, {@code false} otherwise
     * @see Waypoint#getName()
     */
    public boolean addWaypoint(UUID uuid, Waypoint waypoint) {
        if (!personal.containsKey(uuid)) {
            personal.put(uuid, new CopyOnWriteArraySet<>());
        }
        for (Waypoint wp : personal.get(uuid)) {
            if (wp.getName().equals(waypoint.getName())) {
                return false;
            }
        }
        personal.get(uuid).add(waypoint);
        return true;
    }

    /**
     * Removes a waypoint to a player's list of waypoints.
     *
     * @param uuid the UUID of the player whose list should be removed the waypoint
     * @param waypoint the waypoint to remove
     * @return {@code true} if the specified waypoint was present before, {@code false} otherwise
     */
    public boolean removeWaypoint(UUID uuid, Waypoint waypoint) {
        if (!personal.containsKey(uuid)) {
            return false;
        }
        return personal.get(uuid).remove(waypoint);
    }

    /**
     * Gets a waypoint via its name.
     * @param uuid the UUID of the owner of the waypoint to get
     * @param name the name of the waypoint to get
     * @return the waypoint, if found, {@code null} otherwise
     */
    public Waypoint getWaypoint(UUID uuid, String name) {
        if (!personal.containsKey(uuid)) {
            return null;
        }
        for (Waypoint waypoint : personal.get(uuid)) {
            if (waypoint.getName().equals(name)) {
                return waypoint;
            }
        }
        return null;
    }
}
