package io.github.prospector.modmenu.mixin;

import io.github.prospector.modmenu.ModMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.InputStream;
import net.minecraft.class_285;
import net.minecraft.class_592;

@Mixin({class_285.class, class_592.class})
public class MixinTexturePacks {

	@Inject(method = "method_976", at = @At(value = "INVOKE", target = "Ljava/lang/Class;getResourceAsStream(Ljava/lang/String;)Ljava/io/InputStream;", remap = false), cancellable = true)
	private void onGetResource(String resource, CallbackInfoReturnable<InputStream> ci) {
		InputStream in = ModMenu.class.getClassLoader().getResourceAsStream(resource);
		if (in != null)
			ci.setReturnValue(in);
	}

}
