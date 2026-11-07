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
            }
        } else {
        }
        return false;
    }

    public void executeAction(int arg0) {
        int var14 = this.countValue;
        this.countValue = (var14 + 1);
        if (arg0 >= 0) {
            if (this.enabledFlag) {
            } else {
            }
        }
        class_124.field_1061.executeAction(("place" + "[Auto Crystal] Failed to " + "break" + ", change your config!"));
    }

    public boolean checkCondition() {
        if (var6 != null) {
            if (this.countValue >= Math.max(5, Math.ceil((TheNetherPacketHelper.f() / 25.0F)))) {
            }
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
        boolean var3 = this.enabledFlag;
        Vec3d vec = this.vec3d;
        int var5 = this.countValue;
        return ("Attempt(time=" + var6 + ", attempts=" + var5 + ", pos=" + vec + ", place=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = ((var3 * 31) + Integer.hashCode(this.countValue));
        var3 = ((var3 * 31) + this.vec3d.hashCode());
        var3 = ((var3 * 31) + Boolean.hashCode(this.enabledFlag));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlaceServiceComponent)) {
            return false;
        }
        PlaceServiceComponent var5 = (PlaceServiceComponent) other;
        if (this.timestampValue != var5.timestampValue) {
            return false;
        }
        if (this.countValue != var5.countValue) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.vec3d, var5.vec3d))) {
            return false;
        }
        if (this.enabledFlag != var5.enabledFlag) {
            return false;
        }
        return true;
    }

}
