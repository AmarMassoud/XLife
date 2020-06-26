package me.amar.lifex.API;

import lombok.SneakyThrows;
import org.bukkit.Bukkit;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectionUtil {
    public static String version() {
        return Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
    }

    public static final Class IChatBaseComponent = getNMSClass("IChatBaseComponent");
    public static final Class CraftMetaBook = getOBCClass("inventory.CraftMetaBook");

    @SneakyThrows
    public static Class getNMSClass(String clazz) {
        return Class.forName("net.minecraft.server." + version() + "." + clazz);
    }

    @SneakyThrows
    public static Class getOBCClass(String clazz) {
        return Class.forName("org.bukkit.craftbukkit." + version() + "." + clazz);
    }

    @SneakyThrows
    public static Method getMethod(String method, Class clazz, Class... classes) {
        return clazz.getMethod(method, classes);
    }

    @SneakyThrows
    public static Object invokeMethod(Method method, Object obj, Object... classes) {
        return method.invoke(obj, classes);
    }

    @SneakyThrows
    public static Constructor getConstructor(Class clazz, Class... classes) {
        return clazz.getConstructor(classes);
    }

    @SneakyThrows
    public static Object instantiate(Constructor constructor, Object... objs) {
        return constructor.newInstance(objs);
    }

    @SneakyThrows
    public static Object getField(String field, Class clazz, Object obj) {
        return clazz.getField(field).get(obj);
    }
}