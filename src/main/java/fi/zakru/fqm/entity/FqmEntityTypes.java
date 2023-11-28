package fi.zakru.fqm.entity;

import fi.zakru.fqm.FqmMod;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.quiltmc.qsl.entity.api.QuiltEntityTypeBuilder;

public class FqmEntityTypes {

	public static final EntityType<FunnyProjectileEntity> FUNNY_PROJECTILE = QuiltEntityTypeBuilder.<FunnyProjectileEntity>create(SpawnGroup.MISC, FunnyProjectileEntity::new)
		.setDimensions(EntityDimensions.fixed(0.25f, 0.25f))
		.trackingTickInterval(10)
		.build();

	public static final EntityType<FunnyProjectileEntity> FUNNY_ARROW = QuiltEntityTypeBuilder.<FunnyProjectileEntity>create(SpawnGroup.MISC, FunnyProjectileEntity::new)
		.setDimensions(EntityDimensions.fixed(0.25f, 0.25f))
		.trackingTickInterval(10)
		.build();

	public static void registerEntityTypes() {
		Registry.register(Registries.ENTITY_TYPE, new Identifier(FqmMod.MODID, "funny_projectile"), FUNNY_PROJECTILE);
		Registry.register(Registries.ENTITY_TYPE, new Identifier(FqmMod.MODID, "funny_arrow"), FUNNY_ARROW);
	}
}
