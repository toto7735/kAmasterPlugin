package kAmasterPlugin;

import com.oracle.jrockit.jfr.EventDefinition;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.UUID;

public class CommandSpy implements CommandExecutor, Listener {

    private kAmasterPlugin plugin;
    public CommandSpy(kAmasterPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginCommand("commandSpy").setExecutor(this);
        Bukkit.getServer().getPluginManager().registerEvents(this, plugin);
    }
    String prefix = "§8[§ekAmster§bCraft§8] §7» ";
    HashMap<UUID, String> turn = new HashMap<>();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("commandspy")) {
            Player player = (Player) sender;
            if (!(player.hasPermission("Staff.CommandSpy"))) {
                player.sendMessage(prefix + "§cYou don't have permission to run this command! :(");
                return false;
            }
            if (!(turn.containsKey(player.getUniqueId()))) {
                player.sendMessage(prefix + "§aNow you are spying player's command! :)");
                turn.put(player.getUniqueId(), "on");
            } else {
                player.sendMessage(prefix + "§cNow you are not spying player's command! :)");
                turn.remove(player.getUniqueId());
            }
        }
    return false;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            if (turn.containsKey(players.getUniqueId())) {
                players.sendMessage(prefix + "§6" + e.getPlayer().getName() + "§e's command: " + "§a" + e.getMessage());
            }
        }
    }

}
