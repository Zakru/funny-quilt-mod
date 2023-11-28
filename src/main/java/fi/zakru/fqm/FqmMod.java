package fi.zakru.fqm;

import fi.zakru.fqm.client.entity.render.FunnyArrowEntityRenderer;
import fi.zakru.fqm.entity.FqmEntityTypes;
import fi.zakru.fqm.item.FqmItems;
import fi.zakru.fqm.sound.FqmSoundEvents;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.item.ItemGroups;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FqmMod implements ModInitializer, ClientModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Funny Quilt Mod");

	public static final String MODID = "fqm";

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Hello Quilt world from {}!", mod.metadata().name());

		FqmItems.registerItems();
		FqmEntityTypes.registerEntityTypes();
		FqmSoundEvents.registerSoundEvents();

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(content -> {
			content.addItem(FqmItems.FUNNY_ITEM);
			content.addItem(FqmItems.FUNNY_ARROW);
		});
	}

	@Override
	public void onInitializeClient(ModContainer mod) {
		EntityRendererRegistry.register(FqmEntityTypes.FUNNY_ARROW, FunnyArrowEntityRenderer::new);
		EntityRendererRegistry.register(FqmEntityTypes.FUNNY_PROJECTILE, FlyingItemEntityRenderer::new);
	}
}
