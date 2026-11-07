package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.minecraft.class_1306;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class EquipArmEvent extends Event {

    public static final EquipArmEvent INSTANCE;
    private static final ReadWriteProperty progressSetting;
    public static class_1306 arm;

    private EquipArmEvent() {
        super();
    }

    public float getProgress() {
        return (Number) progressSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void setProgress(float value) {
        progressSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    public class_1306 getArm() {
        if (arm != null) {
            return arm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("arm");
        return null;
    }

    public void setArm(class_1306 value) {
        arm = value;
    }

    public boolean call(float swingProgress, class_1306 arm) {
        this.setCancelled(0);
        this.setProgress(swingProgress);
        this.setArm(arm);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] var0 = new KProperty[1];
        INSTANCE = new EquipArmEvent();
        progressSetting = Delegates.INSTANCE.notNull();
    }

}
