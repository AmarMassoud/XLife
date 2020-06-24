package me.amar.xlife.xlife.commands.SubCommands;

import me.amar.xlife.xlife.Events.QuitEvent;
import me.amar.xlife.xlife.XLife;
import me.amar.xlife.xlife.commands.Files.DataYml;
import me.amar.xlife.xlife.commands.SubCommand;
import org.apache.commons.lang.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.*;
import java.util.*;

public class ListCommand extends SubCommand {
    private final XLife plugin = XLife.getPlugin(XLife.class);
    @Override
    public String getName() {
        return "list";
    }

    @Override
    public String getDescription() {
        return "Sends the health of all online players.";
    }

    @Override
    public String getSyntax() {
        return "/xlife list";
    }

    @Override
    public void perform(CommandSender sender, String[] args){
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(plugin.getDataFolder() + "/data.yml");
        String configtext = read_file(DataYml.dataFile);
        String[] splitted =configtext.split("ABCZ");
        List<Double> about_to_split = new ArrayList<>();
        for (int i = 0; i < splitted.length; i++) {
            String about = splitted[i];
            about = about.replaceAll("\\D+","");
            about_to_split.add(Double.valueOf(about) / 10);
        }

        Collections.sort(about_to_split);

        for(int i = 0; i < about_to_split.size(); i++){
            sender.sendMessage(configtext.substring(i) + " - " + about_to_split.get(i));
        }
        for (int i = 0; i < splitted.length; i++) {
            sender.sendMessage(splitted[i]);
        }
    }
    public static String read_file(File f){
        String returning = "";
        try {
            File myObj = f;
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                returning = returning = data;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return returning;
    }
    public static String get_numbers_from_string(String s){
        String returning = "";
        for(int i = 0; i < s.length(); i++){
            if(s.substring(i,i).equals("") && s.substring(i,i) != null && StringUtils.isNumeric(s.substring(i,i))){
                returning = returning + s.substring(i,i);
            }
        }
        return returning;
    }
}

