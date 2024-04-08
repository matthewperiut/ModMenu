package io.github.prospector.modmenu.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.util.OperatingSystem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Minecraft.class)
public interface MinecraftAccessor {

	@Invoker("getOperatingSystem")
	static OperatingSystem getOS() {
		return OperatingSystem.WINDOWS;
	}

}
