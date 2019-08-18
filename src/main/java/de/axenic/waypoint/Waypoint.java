package de.axenic.waypoint;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.io.IOException;
import java.io.Serializable;
import java.util.UUID;

/**
 * Represents a single waypoint.
 */
public class Waypoint implements Serializable {

    /**
     * This {@link Waypoint}'s location.
     */
    private Location location;

    /**
     * This {@link Waypoint}'s name.
     */
    private String name;

    /**
     * Creates a new {@link Waypoint} of a location and a name.
     * @param location the new waypoint's location
     * @param name the new waypoint's readable name
     */
    public Waypoint(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    /**
     * Returns this {@link Waypoint}'s location.
     * @return this {@link Waypoint}'s location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Sets this {@link Waypoint}'s location.
     * @param location the location to set
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Returns this {@link Waypoint}'s name.
     * @return this {@link Waypoint}'s name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets this {@link Waypoint}'s name.
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns a human-readable representation of this waypoint.
     * @return a human-readable representation of this waypoint
     */
    public String toString() {
        return name + " (in " + location.getWorld().getName() + "): " + location.getBlockX() + ' ' + location.getBlockY() + ' ' + location.getBlockZ();
    }

    //region Serialization
    /**
     * Serializes this {@link Waypoint} to an object output stream.
     * @param out the output stream to serialize to
     * @throws IOException
     */
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        out.writeUTF(name);
        out.writeObject(location.getWorld().getUID());
        out.writeDouble(location.getX());
        out.writeDouble(location.getY());
        out.writeDouble(location.getZ());
    }

    /**
     * Deserializes this {@link Waypoint} from an object input stream.
     * @param in the input stream to deserialize from
     * @throws IOException
     */
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        name = in.readUTF();
        location = new Location(
                Bukkit.getWorld((UUID) in.readObject()),
                in.readDouble(), //X
                in.readDouble(), //Y
                in.readDouble()  //Z
        );
    }
    //endregion
}
