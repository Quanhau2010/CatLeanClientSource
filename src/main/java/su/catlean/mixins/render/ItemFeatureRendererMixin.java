package su.catlean.mixins.render;

import net.minecraft.class_10444.class_10445;
import net.minecraft.class_4597;
import su.catlean.api.event.events.render.ItemCommandEvent;

public abstract class ItemFeatureRendererMixin {

    public ItemFeatureRendererMixin() {
    }

    private class_4597 renderHook(class_4597 original) {
        if (ItemCommandEvent.INSTANCE.call()) {
            return ItemCommandEvent.INSTANCE.getProvider();
        }
        return original;
    }

    private class_10445 renderHook(class_10445 original) {
        if (ItemCommandEvent.INSTANCE.call()) {
            return class_10445.field_55341;
        }
        return original;
    }

}
