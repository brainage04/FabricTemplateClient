package com.example.key.core;

import com.example.ExampleMod;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class ModKeys {
    public static final KeyBinding.Category MAIN_CATEGORY = KeyBinding.Category.create(Identifier.of(ExampleMod.MOD_ID, "main"));

    public static final KeyBinding TEST_KEY = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "key.%s.testKey".formatted(ExampleMod.MOD_ID),
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            MAIN_CATEGORY
    ));

    public static void initialize() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (TEST_KEY.isPressed()) {
                // used for instant/discrete actions such as toggles
            }

            while (TEST_KEY.wasPressed()) {
                // used for continuous actions such as mining blocks
            }
        });
    }
}
