package fi.zakru.fqm.item;

import fi.zakru.fqm.entity.FqmEntityTypes;
import fi.zakru.fqm.entity.FunnyProjectileEntity;
import fi.zakru.fqm.sound.FqmSoundEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class FunnyItem extends Item {

	public FunnyItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		ItemStack itemStack = user.getStackInHand(hand);
		world.playSound(
			null,
			user.getX(),
			user.getY(),
			user.getZ(),
			FqmSoundEvents.ENTITY_FUNNY_PROJECTILE_THROW,
			SoundCategory.PLAYERS,
			0.5F,
			0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
		);

		if (!world.isClient) {
			FunnyProjectileEntity entity = new FunnyProjectileEntity(FqmEntityTypes.FUNNY_PROJECTILE, world, user);
			entity.setProperties(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
			world.spawnEntity(entity);
		}

		user.incrementStat(Stats.USED.getOrCreateStat(this));
		if (!user.getAbilities().creativeMode) {
			itemStack.decrement(1);
		}

		return TypedActionResult.success(itemStack, world.isClient());
	}
}
