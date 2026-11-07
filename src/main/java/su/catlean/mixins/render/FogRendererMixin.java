package su.catlean.mixins.render;

import org.joml.Vector4f;
import su.catlean.api.event.GetFogBufferEvent;
import su.catlean.api.event.events.world.ApplyFogEvent;

public abstract class FogRendererMixin {

    public FogRendererMixin() {
    }

    private Vector4f applyFogHook(Vector4f original) {
        if (original.w != 0.0F && ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getColorVec();
        }
        return original;
    }

    private float modifyEnvironmentalStart(float value) {
        if (ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getEStart();
        }
        return value;
    }

    private float envEndHook(float value) {
        if (ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getEEnd();
        }
        return value;
    }

    private float renderStartHook(float value) {
        if (ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getRStart();
        }
        return value;
    }

    private float renderEndHook(float value) {
        if (ApplyFogEvent.INSTANCE.call()) {
            return ApplyFogEvent.INSTANCE.getREnd();
        }
        return value;
    }

    private boolean getFogBufferHook(boolean value) {
        if (GetFogBufferEvent.INSTANCE.call()) {
            return false;
        }
        return value;
    }

}
