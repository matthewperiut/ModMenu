package io.github.prospector.modmenu.mixin;

import net.minecraft.client.EnumOperatingSystems;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Minecraft.class)
public interface MinecraftAccessor {

	@Invoker("getOperatingSystem")
	static EnumOperatingSystems getOS() {
		return EnumOperatingSystems.WINDOWS;
	}

}
