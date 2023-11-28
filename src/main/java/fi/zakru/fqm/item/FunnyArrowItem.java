package fi.zakru.fqm.item;

import fi.zakru.fqm.entity.FqmEntityTypes;
import fi.zakru.fqm.entity.FunnyProjectileEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class FunnyArrowItem extends ArrowItem {

	public FunnyArrowItem(Settings settings) {
		super(settings);
	}

	@Override
	public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
		return new FunnyProjectileEntity(FqmEntityTypes.FUNNY_ARROW, world, shooter);
	}
}
