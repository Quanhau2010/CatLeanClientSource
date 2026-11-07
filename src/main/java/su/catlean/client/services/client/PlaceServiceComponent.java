package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_124;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class PlaceServiceComponent {

    private int countValue;
    private Vec3d vec3d;
    private boolean enabledFlag;
    private double preciseValue;
    private static final long timestampValue2;

    public PlaceServiceComponent(long time, int attempts, Vec3d pos, boolean place) {
        this.timestampValue = time;
        this.countValue = attempts;
        this.vec3d = pos;
        this.enabledFlag = place;
        this.preciseValue = SharedKt.getPlayer().method_5707(this.vec3d);
    }

    public long getNumericValue() {
        return this.timestampValue;
    }

    public void updateValue(long value) {
        this.timestampValue = value;
    }

    public Vec3d getMinecraftObject() {
        return this.vec3d;
    }

    public void executeAction(Vec3d value) {
        this.vec3d = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public double getNumericValue() {
        return this.preciseValue;
    }

    public void updateValue(double value) {
        this.preciseValue = value;
    }

    public boolean checkCondition() {
        if (this.checkCondition()) {
        } else {
        }
        if (1.0F < 10.0F) {
            if ((SharedKt.getNumericValue() - this.timestampValue) > timestampValue2) {
            } else {
            }
        }
        return false;
    }

    public void executeAction(int arg0) {
        int index = this.countValue;
        this.countValue = (index + 1);
        if (arg0 >= 0) {
            if (this.enabledFlag) {
            } else {
            }
        }
        class_124.field_1061.executeAction(("place" + "[Auto Crystal] Failed to " + "break" + ", change your config!"));
    }

    public boolean checkCondition() {
        if (this.countValue >= Math.max(5, Math.ceil((TheNetherPacketHelper.f() / 25.0F)))) {
        } else {
        }
        return false;
    }

    public long getNumericValue2() {
        return this.timestampValue;
    }

    private int getNumericValue() {
        return this.countValue;
    }

    public Vec3d getMinecraftObject2() {
        return this.vec3d;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public PlaceServiceComponent resolvePlaceServiceComponent(long time, int attempts, Vec3d pos, boolean place) {
        return new PlaceServiceComponent(time, attempts, pos, place);
    }

    public String toString() {
        boolean flag = this.enabledFlag;
        Vec3d vec = this.vec3d;
        int index = this.countValue;
        return ("Attempt(time=" + __UNDEF_KEY__ + ", attempts=" + index + ", pos=" + vec + ", place=" + flag + ")");
    }

    public int hashCode() {
        return __UNDEF_KEY__;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceServiceComponent)) {
            return false;
        }
        PlaceServiceComponent placeServiceComponent = ((PlaceServiceComponent) other);
        if (this.timestampValue != placeServiceComponent.timestampValue) {
            return false;
        }
        if (this.countValue != placeServiceComponent.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.vec3d, placeServiceComponent.vec3d))) {
            return false;
        }
        if (this.enabledFlag != placeServiceComponent.enabledFlag) {
            return false;
        }
        return true;
    }

}
