package su.catlean.mixins.render;

import net.minecraft.class_2561;
import net.minecraft.client.gui.screen.Screen;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.client.PostTitleScreenInitEvent;

public class TitleScreenMixin extends Screen {

    protected TitleScreenMixin(class_2561 title) {
        super(title);
    }

    public void postInitHook(CallbackInfo ci) {
        PostTitleScreenInitEvent.INSTANCE.call();
    }

}
