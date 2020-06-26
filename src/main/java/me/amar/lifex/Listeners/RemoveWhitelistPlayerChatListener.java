package me.amar.lifex.Listeners;

import java.util.ArrayList;
import java.util.List;

public class RemoveWhitelistPlayerChatListener {
    public static List<String> RemovePlayerChatListener = new ArrayList<>();

    public static void addPlayerToWhitelistRemoveChatListener(String p) {
        RemovePlayerChatListener.add(p);
    }

    public static void removePlayerFromWhitelistRemoveChatListener(String p) {
        RemovePlayerChatListener.remove(p);
    }

    public static boolean isPlayerInWhitelistRemoveChatListener(String p) {
        if (RemovePlayerChatListener.contains(p)) {
            return true;

        } else {
            return false;
        }
    }
}
