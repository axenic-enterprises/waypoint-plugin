package de.axenic.waypoint;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.xml.soap.Text;

/**
 * The bukkit command executor for the /waypoint command.
 */
public final class WPCommandExecutor implements CommandExecutor {

    //region Singleton Pattern
    /**
     * The only instance of {@link WPCommandExecutor} that will exist.
     */
    private static WPCommandExecutor instance = new WPCommandExecutor();

    /**
     * Returns the singleton instance of {@link WPCommandExecutor}.
     *
     * @return the singleton instance of {@link WPCommandExecutor}
     */
    public static WPCommandExecutor getExecutor() {
        return instance;
    }

    /**
     * Private constructor.
     */
    private WPCommandExecutor() {
    }
    //endregion

    /**
     * Indicates that a valid command was entered.
     */
    private static final boolean CORRECT_USAGE = true;

    /**
     * Indicates that an invalid command was entered.
     */
    private static final boolean WRONG_USAGE = false;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length < 1 || args.length > 2) {
                return WRONG_USAGE;
            } else if (args.length == 1) {
                if (args[0].equals("get")) {
                    Iterable<Waypoint> waypoints = WPDatabase.getDatabase().getWaypoints(player.getUniqueId());
                    if (waypoints == null) {
                        WPMessenger.getMessenger().sendChatMessage(WPMessenger.MessageSeverity.WARNING, "You do not have any waypoints", player);
                    }
                    WPMessenger.getMessenger().sendChatMessage(WPMessenger.MessageSeverity.INFO, "Your waypoints: ", player);
                    for (Waypoint waypoint : waypoints) {
                        WPMessenger.getMessenger().sendChatMessage(WPMessenger.MessageSeverity.INFO, waypoint.toString(), player);
                    }
                }
                return CORRECT_USAGE;
            } else { //args.length = 2
                //...
                return CORRECT_USAGE;
            }
        } else {
            return WRONG_USAGE;
        }
    }
}
