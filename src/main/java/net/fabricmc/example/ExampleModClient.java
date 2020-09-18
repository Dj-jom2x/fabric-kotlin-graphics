package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.gui.MainScreen;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.options.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ExampleModClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        KeyBinding test = KeyBindingHelper.registerKeyBinding(new KeyBinding("test", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_RIGHT_SHIFT, "test"));
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (test.isPressed()) {
                if (client.player != null && client.currentScreen == null) {
                    client.openScreen(new MainScreen());
                }
            }
        });
    }
}
