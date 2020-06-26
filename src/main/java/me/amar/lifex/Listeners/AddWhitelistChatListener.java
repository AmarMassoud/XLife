package me.amar.lifex.Listeners;

import java.util.ArrayList;
import java.util.List;

public class AddWhitelistChatListener {
    public static List<String> AddPlayerChatListener = new ArrayList<>();

    public static void addPlayerToWhitelistAddPlayerChatListener(String p) {
        AddPlayerChatListener.add(p);
    }

    public static void removePlayerFromWhitelistAddPlayerChatListener(String p) {
        AddPlayerChatListener.remove(p);
    }

    public static boolean isPlayerInWhitelistAddChatListener(String p) {
        if(AddPlayerChatListener.contains(p)) {
            return true;

        } else {
            return false;
        }
    }




}
