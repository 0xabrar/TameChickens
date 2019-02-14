package example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.dimdev.rift.listener.BootstrapListener;
import org.dimdev.rift.listener.MinecraftStartListener;
import org.dimdev.riftloader.listener.InitializationListener;

import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import net.minecraft.init.Items;

/**
 * The example mod listener, as defined in the riftmod.json file
 * 
 * As many more as wanted can be made by adding their full names in the riftmod.json file
 * 
 * @author Reisse, Chocohead
 */
public class ExampleListener implements MinecraftStartListener, BootstrapListener, InitializationListener {
	private static final Logger LOGGER = LogManager.getLogger();
	public static ExampleListener instance;


	@Override
	public void onInitialization() {
		MixinBootstrap.init();
		Mixins.addConfiguration("mixins.example.json");
		instance=this;
	}

	@Override
	public void onMinecraftStart() {
		//Minecraft has started but hasn't registered any blocks or items
		//Prime time for loading a config if you need one
		LOGGER.info("Minecraft starting abrar");
	}

	//Blocks can be added by implementing BlockAdder, Items from ItemAdder etc.
	//See open sourced mods such as HalfLogs for reference

	@Override
	public void afterVanillaBootstrap() {
		//Minecraft has now finished Bootstrap so all blocks and items are registered
		//You probably won't need to listen to this normally.
		LOGGER.info("Minecraft loaded abrar: " + Items.CARROT_ON_A_STICK);
	}

	public void renderOverlay(float partialTicks) {

	}
}
