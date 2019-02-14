package example.mixin;

import net.minecraft.entity.passive.EntityChicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import net.minecraft.util.SoundEvent;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mixin(EntityChicken.class)
public abstract class MixinEntityChicken {

    private static final Logger LOGGER = LogManager.getLogger();

    @Inject(method = "livingTick", at = @At("HEAD"), cancellable = true)
    public void onLivingTick(CallbackInfo callbackInfo) {
        callbackInfo.cancel();
    }

    @Inject(method = "getAmbientSound", at = @At("HEAD"), cancellable = true)
    public void onAmbientSound(CallbackInfoReturnable<SoundEvent> callbackInfo) {
        callbackInfo.cancel();
    }
}
