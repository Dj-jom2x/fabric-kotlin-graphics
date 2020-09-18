package net.fabricmc.example.core;

import imgui.ImGui;
import imgui.ImguiKt;
import imgui.classes.Context;
import imgui.classes.IO;
import imgui.impl.gl.ImplGL3;
import imgui.impl.glfw.ImplGlfw;
import net.minecraft.client.MinecraftClient;
import uno.glfw.GlfwWindow;

public class KotlinGraphics {
    public static ImGui UI = ImGui.INSTANCE;
    public static ImplGL3 implGl3;
    public static ImplGlfw implGlfw;
    public static GlfwWindow window;
    public static IO ImGuiIO;
    public static Context ctx;
    public static final MinecraftClient MC = MinecraftClient.getInstance();

    public static void boot() {
        ImguiKt.MINECRAFT_BEHAVIORS = true;
        window = GlfwWindow.from(MinecraftClient.getInstance().getWindow().getHandle());
        window.makeContextCurrent();
        ctx = new Context();
        ImGuiIO = UI.getIo();
        implGlfw = new ImplGlfw(window, false, null);
        implGl3 = new ImplGL3();
    }
}
