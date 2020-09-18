package net.fabricmc.example.gui;

import glm_.vec2.Vec2;
import imgui.ImGui;
import imgui.WindowFlag;
import imgui.classes.IO;
import imgui.impl.gl.ImplGL3;
import imgui.impl.glfw.ImplGlfw;
import net.fabricmc.example.core.KotlinGraphics;
import net.fabricmc.example.core.KotlinMutation;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.LiteralText;
import org.lwjgl.glfw.GLFW;

import java.util.HashSet;
import java.util.Objects;

public class MainScreen extends Screen {

    private final ImGui UI = KotlinGraphics.UI;
    private final ImplGL3 implGl3 = KotlinGraphics.implGl3;
    private final ImplGlfw implGlfw = KotlinGraphics.implGlfw;
    private final IO ImGuiIO = KotlinGraphics.ImGuiIO;

    private static final HashSet<Integer> keyBuffer = new HashSet<>();

    public MainScreen() {
        super(new LiteralText("blah"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean charTyped(char chr, int keyCode) {
        if (ImGuiIO.getWantTextInput()) {
            ImGuiIO.addInputCharacter(chr);
        }
        super.charTyped(chr, keyCode);
        return true;
    }

    @Override
    public boolean mouseScrolled(double x, double y, double amount) {
        if (ImGuiIO.getWantCaptureMouse()) {
            ImGuiIO.setMouseWheel((float) amount);
        }
        super.mouseScrolled(x, y, amount);
        return true;
    }

    @Override
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        if (ImGuiIO.getWantCaptureKeyboard()) {
            ImGuiIO.getKeysDown()[keyCode] = true;
            keyBuffer.add(keyCode);
        }

        // Skip handling of the ESC key, because Minecraft uses it to close the screen.
        if (keyCode == GLFW.GLFW_KEY_ESCAPE) {
            ImGuiIO.getKeysDown()[GLFW.GLFW_KEY_ESCAPE] = false;
        }

        super.keyPressed(keyCode, scanCode, modifiers);
        return true;
    }

    @Override
    public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
        ImGuiIO.getKeysDown()[keyCode] = false;
        keyBuffer.remove(keyCode);

        super.keyReleased(keyCode, scanCode, modifiers);
        return true;
    }

    @Override
    public void onClose() {
        // When Minecraft closes the screen, clear the key buffer.
        for (int keyCode : keyBuffer) {
            ImGuiIO.getKeysDown()[keyCode] = false;
        }
        keyBuffer.clear();
        super.onClose();
    }

    private void startRender() {
        implGl3.newFrame();
        implGlfw.newFrame();
        UI.newFrame();
    }

    private void endRender() {
        UI.render();
        implGl3.renderDrawData(Objects.requireNonNull(UI.getDrawData()));
    }

//    MutableProperty0 show = new MutableProperty0<Boolean>(false); // this will not because of class 52 55 mismatch

    KotlinMutation<Boolean> show = new KotlinMutation<Boolean>(false);


//    boolean[] show = new boolean[]{true}; //this will work

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        startRender();

        if (show.get()) {
            if (UI.begin("Console##cons", show, WindowFlag.AlwaysAutoResize.i)) {
                UI.text("Hello world...............");
                UI.end();
            }
        }

        if (UI.begin("Hello Friends", null, 0, WindowFlag.AlwaysAutoResize.i + WindowFlag.MenuBar.i)) {
            UI.text("Hello Everyone...............");
//
            if (UI.button("Show Console", new Vec2(60, 80))) {
                show.set(true);
            }


        }
        endRender();
    }
}
