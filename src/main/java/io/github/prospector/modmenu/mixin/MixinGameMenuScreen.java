package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import io.github.prospector.modmenu.gui.ModListScreen;
import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.pack.PackScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class MixinGameMenuScreen extends Screen {

	@SuppressWarnings("unchecked")
	@Inject(at = @At("RETURN"), method = "init")
	public void drawMenuButton(CallbackInfo info) {
		this.buttons.add(new ButtonWidget(100, this.width / 2 - 100, this.height / 4 + 72 - 16, 98, 20, "Texture Packs"));
		this.buttons.add(new ModMenuButtonWidget(101, this.width / 2 + 2, this.height / 4 + 72 - 16, 98, 20, "Mods (" + ModMenu.getFormattedModCount() + " loaded)"));
	}

	@Inject(method = "buttonClicked", at = @At("HEAD"))
	private void onActionPerformed(ButtonWidget button, CallbackInfo ci) {
		if (button.id == 100) {
			minecraft.setScreen(new PackScreen(this));
		}
		if (button.id == 101) {
			minecraft.setScreen(new ModListScreen(this));
		}
	}
}
