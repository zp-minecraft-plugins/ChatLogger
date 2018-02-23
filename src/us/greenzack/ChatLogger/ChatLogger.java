package us.greenzack.ChatLogger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatLogger extends JavaPlugin{
	public final Logger logger = Logger.getLogger("Minecraft");
	
	public void onDisable() {
		this.logger.info("AntiGrief is now disabled.");
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("plugins//ChatLogger//logger.txt", true));
			GregorianCalendar calendar = new GregorianCalendar();
			int day = calendar.get(5);
			int month = calendar.get(2) + 1;
		  	int year = calendar.get(1);
		  	String strDateFormat = "HH:mm:ss a";
		  	SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		  	Date date = new Date();
		  	out.write(month + "/" + day + "/" + year + " - " + sdf.format(date) + " - AntiGrief Disabled");
		  	out.newLine();
		  	out.close();
			}
		catch (IOException localIOException){
		}
	}
	public void onEnable() {
		final FileConfiguration config = this.getConfig();
		new MyChatListener(this);
		new MyJoinListener(this);
		new MyKickListener(this);
		new MyLeaveListener(this);
		config.addDefault("Enabled", true);
        config.options().copyDefaults(true);
        saveConfig();
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter("plugins//ChatLogger//logger.txt", true));
			GregorianCalendar calendar = new GregorianCalendar();
			int day = calendar.get(5);
			int month = calendar.get(2) + 1;
		  	int year = calendar.get(1);
		  	String strDateFormat = "HH:mm:ss a";
		  	SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
		  	Date date = new Date();
		  	out.write(month + "/" + day + "/" + year + " - " + sdf.format(date) + " - AntiGrief Enabled");
		  	out.newLine();
		  	out.close();
			}
		catch (IOException localIOException){
		}
	}
}