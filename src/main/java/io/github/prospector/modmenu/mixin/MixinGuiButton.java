package io.github.prospector.modmenu.mixin;

import net.minecraft.src.GuiButton;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(GuiButton.class)
public interface MixinGuiButton {

	@Accessor
	void setWidth(int width);

	@Accessor
	void setHeight(int height);

}
