package su.catlean.api.event.events.render;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class CrystalYOffsetEvent extends Event {

    public static final CrystalYOffsetEvent INSTANCE;
    private static float offset;
    private static final ReadWriteProperty ageSetting;

    private CrystalYOffsetEvent() {
        super();
    }

    public float getOffset() {
        return offset;
    }

    public void setOffset(float value) {
        offset = value;
    }

    public float getAge() {
        return ((Number) ageSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void setAge(float value) {
        ageSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    public boolean call(float age) {
        this.setAge(age);
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new CrystalYOffsetEvent();
        ageSetting = Delegates.INSTANCE.notNull();
    }

}
