package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import io.github.prospector.modmenu.gui.ModListScreen;
import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import net.minecraft.client.gui.screen.ScreenBase;
import net.minecraft.client.gui.screen.ingame.Pause;
import net.minecraft.client.gui.widgets.Button;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Pause.class)
public class MixinGameMenuScreen extends ScreenBase {

	@SuppressWarnings("unchecked")
	@Inject(at = @At("RETURN"), method = "init")
	public void drawMenuButton(CallbackInfo info) {
		this.buttons.add(new ModMenuButtonWidget(100, this.width / 2 - 100, this.height / 4 + 72 - 16, 200, 20,  "Mods (" + ModMenu.getFormattedModCount() + " loaded)"));
	}

	@Inject(method = "buttonClicked", at = @At("HEAD"))
	private void onActionPerformed(Button button, CallbackInfo ci) {
		if (button.id == 100) {
			minecraft.openScreen(new ModListScreen(this));
		}
	}
}
