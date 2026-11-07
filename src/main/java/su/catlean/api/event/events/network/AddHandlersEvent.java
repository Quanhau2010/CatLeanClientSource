package su.catlean.api.event.events.network;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.minecraft.class_2598;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class AddHandlersEvent extends Event {

    public static final AddHandlersEvent INSTANCE;
    private static AtomicReference pipeline;
    private static class_2598 side;
    private static final ReadWriteProperty localSetting;

    private AddHandlersEvent() {
        super();
    }

    public AtomicReference getPipeline() {
        if (pipeline != null) {
            return pipeline;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pipeline");
        return null;
    }

    public class_2598 getSide() {
        if (side != null) {
            return side;
        }
        Intrinsics.throwUninitializedPropertyAccessException("side");
        return null;
    }

    public boolean getLocal() {
        return ((Boolean) localSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setLocal(boolean value) {
        localSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    public boolean call(AtomicReference pipeline, class_2598 side, boolean local) {
        this.setCancelled(false);
        pipeline = pipeline;
        side = side;
        this.setLocal(local);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new AddHandlersEvent();
        localSetting = Delegates.INSTANCE.notNull();
    }

}
