package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import net.minecraft.src.GuiIngameMenu;
import net.minecraft.src.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngameMenu.class)
public class MixinGameMenuScreen extends GuiScreen {

	@SuppressWarnings("unchecked")
	@Inject(at = @At("RETURN"), method = "func_6448_a")
	public void drawMenuButton(CallbackInfo info) {
		this.controlList.add(new ModMenuButtonWidget(100, this.width / 2 - 100, this.height / 4 + 120, 200, 20,  "Mods (" + ModMenu.getFormattedModCount() + " loaded)"));
	}
}
