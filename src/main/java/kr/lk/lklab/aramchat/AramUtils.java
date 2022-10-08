package kr.lk.lklab.aramchat;

import kr.lk.lklab.aramchat.Obfuscated.ReflectionFieldInfo;
import kr.lk.lklab.aramchat.Obfuscated.ReflectionFieldMap;
import kr.lk.lklab.aramchat.Wrapper.TextComponentWrapper;
import kr.lk.lklab.aramchat.Wrapper.TextFieldWidgetWrapper;
import kr.lk.lklab.aramchat.Wrapper.TextInputUtilWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.font.TextFieldHelper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AramUtils {

    private static ReflectionFieldMap<EditBox> textFieldWidgetRefMap = new ReflectionFieldMap(EditBox.class);
    private static ReflectionFieldMap<TextFieldHelper> textInputUtilRefMap = new ReflectionFieldMap(TextFieldHelper.class);

    public static TextComponentWrapper getTextComponent() {
        EditBox widget = getWidget();
        TextFieldHelper inputUtil = getTextInput();

        if (widget != null) {
            return new TextFieldWidgetWrapper(widget);
        }

        if (inputUtil != null) {
            return new TextInputUtilWrapper(inputUtil);
        }
        return null;
    }

    private static TextFieldHelper getTextInput() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen == null) return null;

        return textInputUtilRefMap.findField(mc.screen);
    }

    private static EditBox getWidget() {
        Minecraft mc = Minecraft.getInstance();
        if (mc.screen == null) return null;

        return textFieldWidgetRefMap.findField(mc.screen);
    }
}
