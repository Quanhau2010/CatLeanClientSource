package su.catlean.mixins.world;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.world.CrystalCreateEvent;

public class EndCrystalMixin {

    public int field_7034;
    private float startAge;

    public EndCrystalMixin() {
        this.startAge = -1.0F;
    }

    private void tickHook(CallbackInfo ci) {
        this.startAge = this.field_7034;
        this.field_7034 = 0;
    }

}
