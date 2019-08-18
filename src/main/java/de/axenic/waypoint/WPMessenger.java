package de.axenic.waypoint;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Provides helper methods for sending and logging messages.
 */
public final class WPMessenger {

    //region Singleton
    /**
     * The only instance of {@link WPMessenger} that will exist.
     */
    private static WPMessenger instance = new WPMessenger();

    /**
     * Private constructor.
     */
    private WPMessenger() {
    }

    /**
     * Returns the singleton instance of {@link WPMessenger}.
     * @return the singleton instance of {@link WPMessenger}
     */
    public static WPMessenger getMessenger() {
        return instance;
    }

    //endregion

    /**
     * A prefix placed in front of all plugin-related messages in the chat.
     */
    private final String chatTemplate = ChatColor.DARK_RED + "[" + ChatColor.RED + WPPlugin.getPlugin().getName() + ChatColor.DARK_RED + "] ";

    /**
     * A template for creating plugin-related messages in the console.
     */
    private final String consoleTemplate = "[" + WPPlugin.getPlugin().getName() + "-%s] %s";

    /**
     * Sends a message to the console.
     * @param tag type of message
     * @param message message to send
     */
    public void sendConsoleMessage(MessageSeverity tag, String message) {
        Bukkit.getConsoleSender().sendMessage(String.format(consoleTemplate, tag.name(), message));
    }

    /**
     * Sends a message to a player.
     * @param tag type of message
     * @param message the message to send to the player
     * @param recipient the player to send the message to
     */
    public void sendChatMessage(MessageSeverity tag, String message, Player recipient) {
        recipient.sendMessage(chatTemplate + tag.getColor() + message);
    }

    /**
     * Represents different kinds of message severities.
     */
    public enum MessageSeverity {
        INFO(ChatColor.GREEN), LOG(ChatColor.GRAY), WARNING(ChatColor.YELLOW), ERROR(ChatColor.RED);

        /**
         * The color this type of message severity will be displayed as in the chat.
         */
        private final ChatColor color;

        /**
         * Returns the color this type of message severity will be displayed as in the chat.
         * @return the color this type of message severity will be displayed as in the chat
         */
        public ChatColor getColor() {
            return color;
        }

        /**
         * Enum constructor.
         */
        MessageSeverity(ChatColor color) {
            this.color = color;
        }
    }

}
