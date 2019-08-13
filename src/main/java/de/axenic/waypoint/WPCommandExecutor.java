package de.axenic.waypoint;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

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
        if (args.length < 1 || args.length > 2) {
            return WRONG_USAGE;
        } else if (args.length == 1) {
            //...
            return CORRECT_USAGE;
        } else { //args.length = 2
            //...
            return CORRECT_USAGE;
        }
    }
}