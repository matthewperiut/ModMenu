package io.github.prospector.modmenu.gui;

import io.github.prospector.modmenu.mixin.MixinGuiButton;
import net.minecraft.client.gui.widget.ButtonWidget;

public class GuiButtonAccessor {

	public static ButtonWidget createButton(int buttonId, int x, int y, int width, int height, String text) {
		ButtonWidget button = new ButtonWidget(buttonId, x, y, text);
		//noinspection ConstantConditions
		MixinGuiButton accessor = (MixinGuiButton) button;
		accessor.setWidth(width);
		accessor.setHeight(height);
		return button;
	}
}
