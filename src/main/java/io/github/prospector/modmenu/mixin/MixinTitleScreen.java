package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import io.github.prospector.modmenu.gui.ModListScreen;
import io.github.prospector.modmenu.gui.ModMenuButtonWidget;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiMainMenu;
import net.minecraft.src.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinTitleScreen extends GuiScreen {

	@SuppressWarnings("unchecked")
	@Inject(at = @At("RETURN"), method = "func_6448_a")
	public void drawMenuButton(CallbackInfo info) {
		GuiButton texturePackButton = (GuiButton) this.controlList.get(this.controlList.size() - 2);
		texturePackButton.displayString = "Texture Packs";
		int newWidth = ((MixinGuiButton) texturePackButton).getWidth() / 2 - 5;
		((MixinGuiButton) texturePackButton).setWidth(newWidth);
		this.controlList.add(new ModMenuButtonWidget(100, this.width / 2 + 6, texturePackButton.yPosition, newWidth, 20,  "Mods (" + ModMenu.getFormattedModCount() + " loaded)"));
	}

	@Inject(method = "actionPerformed", at = @At("HEAD"))
	private void onActionPerformed(GuiButton button, CallbackInfo ci) {
		if (button.id == 100) {
			mc.func_6272_a(new ModListScreen(this));
		}
	}

}
