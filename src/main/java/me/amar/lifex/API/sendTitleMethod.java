package me.amar.lifex.API;

import me.amar.trollassistant.api.ReflectionUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class sendTitleMethod {
    private static final Class PacketPlayOutTitle = ReflectionUtil.getNMSClass("PacketPlayOutTitle");
    private static final Class CraftPlayer = ReflectionUtil.getOBCClass("entity.CraftPlayer");
    private static final Class EntityPlayer = ReflectionUtil.getNMSClass("EntityPlayer");
    private static final Class PlayerConnection = ReflectionUtil.getNMSClass("PlayerConnection");
    private static final Class Packet = ReflectionUtil.getNMSClass("Packet");
    private static final Class EnumTitleAction = ReflectionUtil.getNMSClass("PacketPlayOutTitle$EnumTitleAction");
    private static final Class IChatBaseComponent = ReflectionUtil.getNMSClass("IChatBaseComponent");
    private static final Class ChatMessage = ReflectionUtil.getNMSClass("ChatMessage");

    private static final Constructor packetPlayOutTitleConstruct = ReflectionUtil.getConstructor(PacketPlayOutTitle, int.class, int.class, int.class);

    private static final Method craftPlayerGetHandleMethod = ReflectionUtil.getMethod("getHandle", CraftPlayer);
    private static final Method playerConnectionSendPacketMethod = ReflectionUtil.getMethod("sendPacket", PlayerConnection, Packet);

    public static void sendTitle(Player player, String title, String subtitle, int fadeIn, int stay, int fadeOut) {
        Object craftPlayer = CraftPlayer.cast(player);
        Object playerConn = ReflectionUtil.getField("playerConnection", EntityPlayer,
                ReflectionUtil.invokeMethod(craftPlayerGetHandleMethod, craftPlayer));

        ReflectionUtil.invokeMethod(playerConnectionSendPacketMethod, playerConn,
                ReflectionUtil.instantiate(packetPlayOutTitleConstruct, fadeIn, stay, fadeOut));

        if (title != null) {
            ReflectionUtil.invokeMethod(playerConnectionSendPacketMethod, playerConn, getPacketTitle("TITLE", title));
        }

        if (subtitle != null) {
            ReflectionUtil.invokeMethod(playerConnectionSendPacketMethod, playerConn, getPacketTitle("SUBTITLE", subtitle));
        }

    }

    public static void sendTitle(Player player, String title, String subtitle) {
        sendTitle(player, title, subtitle, 10, 70, 20);
    }

    private static Object getPacketTitle(String titleOpt, String title) {
        return ReflectionUtil.instantiate(ReflectionUtil.getConstructor(PacketPlayOutTitle,
                EnumTitleAction, IChatBaseComponent), Enum.valueOf(EnumTitleAction,
                titleOpt), ReflectionUtil.instantiate(ReflectionUtil.getConstructor(ChatMessage, String.class, Object[].class),
                title, new Object[]{}));
    }

}