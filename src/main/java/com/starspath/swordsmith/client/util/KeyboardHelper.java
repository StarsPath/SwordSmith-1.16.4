package com.starspath.swordsmith.client.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.lwjgl.glfw.GLFW;

public class KeyboardHelper {
    private static final long WINDOW = Minecraft.getInstance().getMainWindow().getHandle();

    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingLeftShift(){
        return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT);
    }
    @OnlyIn(Dist.CLIENT)
    public static boolean isHoldingLeftCtrl(){
        return InputMappings.isKeyDown(WINDOW, GLFW.GLFW_KEY_LEFT_CONTROL);
    }
    @OnlyIn(Dist.CLIENT)
    public static boolean isKeyPressed(){ return isHoldingLeftShift() || isHoldingLeftCtrl(); }
}
