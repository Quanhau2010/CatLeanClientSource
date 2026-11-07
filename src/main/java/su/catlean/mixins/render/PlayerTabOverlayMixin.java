package su.catlean.mixins.render;

import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import su.catlean.api.event.events.network.PlayerListSizeEvent;

public class PlayerTabOverlayMixin {

    public PlayerTabOverlayMixin() {
    }

    private void collectPlayerEntriesHook(Args args) {
        args.set(0, Long.valueOf(1000L));
    }

}
