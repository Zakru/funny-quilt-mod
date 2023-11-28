package fi.zakru.fqm.client.entity.render;

import fi.zakru.fqm.FqmMod;
import fi.zakru.fqm.entity.FunnyProjectileEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class FunnyArrowEntityRenderer extends ProjectileEntityRenderer<FunnyProjectileEntity> {
	public static final Identifier TEXTURE = new Identifier(FqmMod.MODID, "textures/entity/projectiles/funny_arrow.png");

	public FunnyArrowEntityRenderer(EntityRendererFactory.Context context) {
		super(context);
	}

	public Identifier getTexture(FunnyProjectileEntity entity) {
		return TEXTURE;
	}
}
