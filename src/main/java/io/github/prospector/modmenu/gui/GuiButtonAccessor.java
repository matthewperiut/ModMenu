package io.github.prospector.modmenu.gui;

import io.github.prospector.modmenu.mixin.MixinGuiButton;
import net.minecraft.client.gui.widgets.Button;

public class GuiButtonAccessor {

	public static Button createButton(int buttonId, int x, int y, int width, int height, String text) {
		Button button = new Button(buttonId, x, y, text);
		//noinspection ConstantConditions
		MixinGuiButton accessor = (MixinGuiButton) button;
		accessor.setWidth(width);
		accessor.setHeight(height);
		return button;
	}
}
