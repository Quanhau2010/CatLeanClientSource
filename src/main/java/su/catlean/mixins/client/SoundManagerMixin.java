package su.catlean.mixins.client;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.client.CloseSoundManagerEvent;

public class SoundManagerMixin {

    public SoundManagerMixin() {
    }

    public void close(CallbackInfo ci) {
        CloseSoundManagerEvent.INSTANCE.call();
    }

}
