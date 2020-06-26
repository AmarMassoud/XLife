package me.amar.lifex.Listeners;

import java.util.ArrayList;
import java.util.List;

public class PlayerAmountOfHeartsOnDeathChat {
    public static List<String> amountOfHeartsOnDeath = new ArrayList<>();

    public static void addPlayerToAmountOfHeartsOnDeath(String p) {
        amountOfHeartsOnDeath.add(p);
    }

    public static void removePlayerFromAmountOfHeartsOnDeath(String p) {
        amountOfHeartsOnDeath.remove(p);
    }

    public static boolean isPlayerInAmountOfHeartsOnDeath(String p) {
        if(amountOfHeartsOnDeath.contains(p)) {
            return true;

        } else {
            return false;
        }
    }

}
