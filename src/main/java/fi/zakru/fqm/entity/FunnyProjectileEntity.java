package fi.zakru.fqm.entity;

import fi.zakru.fqm.item.FqmItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.FlyingItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class FunnyProjectileEntity extends PersistentProjectileEntity implements FlyingItemEntity {

	protected FunnyProjectileEntity(EntityType<? extends FunnyProjectileEntity> entityType, World world) {
		super(entityType, world);
	}

	public FunnyProjectileEntity(EntityType<? extends FunnyProjectileEntity> entityType, World world, LivingEntity owner) {
		super(entityType, owner, world);
	}

	@Override
	protected ItemStack asItemStack() {
		return new ItemStack(FqmItems.FUNNY_ITEM);
	}

	@Override
	public ItemStack getStack() {
		return new ItemStack(FqmItems.FUNNY_ITEM);
	}

	@Override
	protected void onBlockHit(BlockHitResult blockHitResult) {
		this.activateFunny();
	}

	@Override
	protected void onEntityHit(EntityHitResult entityHitResult) {
		Entity entity = entityHitResult.getEntity();

		Entity owner = getOwner();
		DamageSource damageSource = getDamageSources().arrow(this, owner == null ? this : owner);
		if (entity.damage(damageSource, 0.01f)) {
			if (entity.getType() == EntityType.ENDERMAN) {
				return;
			}

			if (entity instanceof LivingEntity livingEntity) {
				this.onHit(livingEntity);
			}
		}

		this.activateFunny();
	}

	private void activateFunny() {
		this.playSound(SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, 4.0f, 1.0f / (this.random.nextFloat() * 0.2f + 0.9f));
		this.discard();
	}
}
