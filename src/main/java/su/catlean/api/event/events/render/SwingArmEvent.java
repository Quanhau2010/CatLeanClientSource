package su.catlean.api.event.events.render;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import net.minecraft.class_1306;
import net.minecraft.client.util.math.MatrixStack;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SwingArmEvent extends Event {

    public static final SwingArmEvent INSTANCE;
    private static final ReadWriteProperty swingProgressSetting;
    public static MatrixStack matrices;
    private static final ReadWriteProperty armXSetting;
    public static class_1306 arm;

    private SwingArmEvent() {
        super();
    }

    public float getSwingProgress() {
        return (Number) swingProgressSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public void setSwingProgress(float value) {
        swingProgressSetting.setValue(this, DELEGATED_PROPERTIES[0], Float.valueOf(value));
    }

    public MatrixStack getMatrices() {
        if (matrices != null) {
            return matrices;
        }
        Intrinsics.throwUninitializedPropertyAccessException("matrices");
        return null;
    }

    public void setMatrices(MatrixStack value) {
        matrices = value;
    }

    private int getArmX() {
        return (Number) armXSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void setArmX(int value) {
        armXSetting.setValue(this, DELEGATED_PROPERTIES[1], Integer.valueOf(value));
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

    public boolean call(float swingProgress, MatrixStack matrices, int armX, class_1306 arm) {
        this.setCancelled(0);
        this.setSwingProgress(swingProgress);
        this.setMatrices(matrices);
        this.setArm(arm);
        this.setArmX(armX);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        KProperty[] var0 = new KProperty[2];
        INSTANCE = new SwingArmEvent();
        swingProgressSetting = Delegates.INSTANCE.notNull();
        armXSetting = Delegates.INSTANCE.notNull();
    }

}
