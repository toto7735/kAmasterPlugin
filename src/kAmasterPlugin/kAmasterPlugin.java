package kAmasterPlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class kAmasterPlugin extends JavaPlugin {

    String prefix = "§8[§ekAmster§bCraft§8] §7» ";
    public void onEnable() {
        System.out.println(prefix + "kAMasterPlugin by toto7735 Enabled!");
        new CommandSpy(this);
        new Kaboom(this);
    }
    public void onDisable() {
        System.out.println(prefix + "kAMasterPlugin by toto7735 Disabled!");
    }
}
