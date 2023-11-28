package fi.zakru.fqm.sound;

import fi.zakru.fqm.FqmMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class FqmSoundEvents {
	public static final SoundEvent ENTITY_FUNNY_PROJECTILE_THROW = SoundEvent.createVariableRangeEvent(new Identifier(FqmMod.MODID, "entity.fqm.funny_projectile.throw"));

	public static void registerSoundEvents() {
		Registry.register(Registries.SOUND_EVENT, ENTITY_FUNNY_PROJECTILE_THROW.getId(), ENTITY_FUNNY_PROJECTILE_THROW);
	}
}
