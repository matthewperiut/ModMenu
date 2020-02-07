package io.github.prospector.modmenu.mixin;

import net.minecraft.src.GuiButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GuiButton.class)
public interface GuiButtonAccessor {

	@Invoker("<init>(IIIIILjava/lang/String;)V")
	static GuiButton createButton(int buttonId, int x, int y, int width, int height, String text) {
		return new GuiButton(buttonId, x, y, text);
	}

}
