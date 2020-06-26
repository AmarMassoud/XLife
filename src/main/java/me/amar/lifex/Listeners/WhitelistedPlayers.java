package me.amar.lifex.Listeners;

import me.amar.lifex.commands.Files.DataYml;

import java.util.ArrayList;
import java.util.List;

public class WhitelistedPlayers {
    public static void addPlayerToWhitelist(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("whitelisted-players"));
        copy.add(p);
        DataYml.getDataYml().set("whitelisted-players", copy);
        DataYml.saveDataYml();
    }

    public static void removePlayerFromWhitelist(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("whitelisted-players"));
        copy.remove(p);
        DataYml.getDataYml().set("whitelisted-players", copy);
        DataYml.saveDataYml();
    }

    public static boolean isPlayerInWhiteList(String p) {
        List<String> copy = new ArrayList<>(DataYml.getDataYml().getStringList("whitelisted-players"));
        if (copy.contains(p)) {
            return true;
        } else {
            return false;
        }
    }
}
