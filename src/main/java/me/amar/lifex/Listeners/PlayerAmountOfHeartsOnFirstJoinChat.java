package me.amar.lifex.Listeners;

import java.util.ArrayList;
import java.util.List;

public class PlayerAmountOfHeartsOnFirstJoinChat {
    public static List<String> amountOfHeartsOnFirstJoin = new ArrayList<>();

    public static void addPlayerToAmountOfHeartsOnJoin(String p) {
        amountOfHeartsOnFirstJoin.add(p);
    }

    public static void removePlayerFromAmountOfHeartsOnJoin(String p) {
        amountOfHeartsOnFirstJoin.remove(p);
    }

    public static boolean isPlayerInAmountOfHeartsOnJoin(String p) {
        if(amountOfHeartsOnFirstJoin.contains(p)) {
            return true;

        } else {
            return false;
        }
    }




}
