package kr.lk.lklab.aramchat.Keyboard;


import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.event.TickEvent;

import java.awt.*;

public interface KeyboardLayout {
    String getName();
    String getIndicatorText();
    Color getIndicatorColor();
    String getLayoutString();

    void onCharTyped(ScreenEvent.CharacterTyped.Pre event);
    void onKeyPressed(ScreenEvent.KeyPressed.Pre event);
    void renderTick(TickEvent.RenderTickEvent event);

    void cleanUp();
}
