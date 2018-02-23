package us.greenzack.ChatLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyLeaveListener implements Listener {
	public static ChatLogger plugin;
	public MyLeaveListener(ChatLogger instance){
		plugin = instance;
        Bukkit.getServer().getPluginManager().registerEvents(this,instance);
	}
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event){
		String player = event.getPlayer().getName();
		String message = player + " Joined the game";
		if(plugin.getConfig().getBoolean("Enabled")){
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("plugins//ChatLogger//ChatAndJoinLog.txt", true));
				GregorianCalendar calendar = new GregorianCalendar();
				int day = calendar.get(5);
				int month = calendar.get(2) + 1;
				int year = calendar.get(1);
				String strDateFormat = "HH:mm:ss a";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				Date date = new Date();
				out.write(month + "/" + day + "/" + year + " - " + sdf.format(date) + " - " + message);
				out.newLine();
				out.close();
			}
			catch (IOException localIOException){
			}
			try {
				BufferedWriter out = new BufferedWriter(new FileWriter("plugins//ChatLogger//" + player + ".txt", true));
				GregorianCalendar calendar = new GregorianCalendar();
				int day = calendar.get(5);
				int month = calendar.get(2) + 1;
				int year = calendar.get(1);
				String strDateFormat = "HH:mm:ss a";
				SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
				Date date = new Date();
				out.write(month + "/" + day + "/" + year + " - " + sdf.format(date) + " - " + message);
				out.newLine();
				out.close();
			}
			catch (IOException localIOException){
			}
		}
	}
}