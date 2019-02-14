package example.mixin;

import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.Minecraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(EntityChicken.class)
public abstract class MixinEntityChicken {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(method = "livingTick", at = @At("HEAD"), cancellable = true)
    public void onLivingTick(CallbackInfo ci) {
        EntityPlayerSP entityplayer = Minecraft.getInstance().player;
        entityplayer.dropItem(false);
        LOGGER.info("player tick ran with mixin");
    }
}
