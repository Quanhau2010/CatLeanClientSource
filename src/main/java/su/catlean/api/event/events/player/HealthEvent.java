package su.catlean.api.event.events.player;

import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class HealthEvent extends Event {

    public static final HealthEvent INSTANCE;
    private static final ReadWriteProperty healthSetting;

    private HealthEvent() {
        super();
    }

    public float getHealth() {
        return (Number) healthSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void setHealth(float value) {
        healthSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    public boolean call(float health) {
        this.setHealth(health);
        this.setCancelled(0);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] var0 = new KProperty[1];
        INSTANCE = new HealthEvent();
        healthSetting = Delegates.INSTANCE.notNull();
    }

}
