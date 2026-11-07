package su.catlean.mixins.client;

import net.minecraft.class_703;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.render.RenderParticleEvent;

public class ParticleEngineMixin {

    public ParticleEngineMixin() {
    }

    public void addParticleHook(class_703 particle, CallbackInfo ci) {
        ci.cancel();
    }

}
