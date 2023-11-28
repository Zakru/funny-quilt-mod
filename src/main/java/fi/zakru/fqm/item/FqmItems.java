package fi.zakru.fqm.item;

import fi.zakru.fqm.FqmMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class FqmItems {
	public static final FunnyItem FUNNY_ITEM = new FunnyItem(new QuiltItemSettings());
	public static final FunnyArrowItem FUNNY_ARROW = new FunnyArrowItem(new QuiltItemSettings());

	private static boolean itemsRegistered = false;

	public static void registerItems() {
		if (itemsRegistered) throw new IllegalStateException("Items already registered");
		itemsRegistered = true;

		registerItem("funny_item", FUNNY_ITEM);
		registerItem("funny_arrow", FUNNY_ARROW);
	}

	private static void registerItem(String id, Item item) {
		Registry.register(Registries.ITEM, new Identifier(FqmMod.MODID, id), item);
	}
}
