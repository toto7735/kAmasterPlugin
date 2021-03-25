package kAmasterPlugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Kaboom implements CommandExecutor {

    private kAmasterPlugin plugin;
    public Kaboom(kAmasterPlugin plugin) {
        this.plugin = plugin;
        Bukkit.getPluginCommand("kaboom").setExecutor(this);
    }

    String prefix = "§8[§ekAmster§bCraft§8] §7» ";
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kaboom")) {
            Player player = (Player) sender;
            if (!(player.hasPermission("Staff.Kaboom"))) {
                player.sendMessage(prefix + "§cYou don't have permission to run this command! :(");
                return false;
            }
            sender.sendMessage(prefix + "§eCute!");
            for (Player p : Bukkit.getOnlinePlayers()) {
                p.sendTitle("§cKABOOM", "§6" + player.getName() + " §eKaboomed you!", 5, 60, 5);
                p.getWorld().strikeLightningEffect(p.getLocation());
                p.setVelocity(p.getLocation().getDirection().multiply(0).setY(3));
            }
        }
        return false;
    }
}
