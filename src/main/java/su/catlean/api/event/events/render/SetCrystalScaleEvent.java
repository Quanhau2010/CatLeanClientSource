package su.catlean.api.event.events.render;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SetCrystalScaleEvent extends Event {

    public static final SetCrystalScaleEvent INSTANCE;
    private static float scale;
    private static final ReadWriteProperty ageSetting;

    private SetCrystalScaleEvent() {
        super();
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float value) {
        scale = value;
    }

    public float getAge() {
        return ((Number) ageSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public void setAge(float value) {
        ageSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    public boolean call(float age) {
        scale = 1.0F;
        this.setCancelled(false);
        this.setAge(age);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] items = new KProperty[1];
        INSTANCE = new SetCrystalScaleEvent();
        scale = 1.0F;
        ageSetting = Delegates.INSTANCE.notNull();
    }

}
