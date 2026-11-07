package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import su.catlean.api.event.events.client.TickFactorEvent;

public class MixinDynamic {

    private float field_51958;
    private float field_51959;
    private long field_51962;
    private float field_51964;

    public MixinDynamic() {
    }

    private void beginRenderTickHook(long timeMillis, CallbackInfoReturnable cir) {
        this.field_51958 = (((timeMillis - this.field_51962) / this.field_51964) * TickFactorEvent.INSTANCE.getFactor());
        this.field_51962 = timeMillis;
        this.field_51959 = (this.field_51959 + this.field_51958);
        float factor = this.field_51959;
        this.field_51959 = (this.field_51959 - factor);
        cir.setReturnValue(Integer.valueOf(factor));
    }

}
