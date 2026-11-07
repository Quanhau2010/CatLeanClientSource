package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.entity.decoration.EndCrystalEntity;
import su.catlean.client.features.modules.Module;

public class CrystalServiceComponent {

    private final EndCrystalEntity minecraftRef;
    private final boolean enabledFlag;
    private static boolean enabledFlag2;

    public CrystalServiceComponent(EndCrystalEntity crystal, boolean block) {
        this.minecraftRef = crystal;
        this.enabledFlag = block;
    }

    public EndCrystalEntity getMinecraftObject() {
        return this.minecraftRef;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public EndCrystalEntity getMinecraftObject2() {
        return this.minecraftRef;
    }

    public boolean isActive2() {
        return this.enabledFlag;
    }

    public CrystalServiceComponent resolveCrystalServiceComponent(EndCrystalEntity crystal, boolean block) {
        return new CrystalServiceComponent(crystal, block);
    }

    public String toString() {
        return (null + this.minecraftRef + ", block=" + this.enabledFlag + ")");
    }

    public int hashCode() {
        int index = this.minecraftRef.hashCode();
        index = ((index * 31) + Boolean.hashCode(this.enabledFlag));
        if (__UNDEF_KEY__) {
        }
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CrystalServiceComponent)) {
            return false;
        }
        CrystalServiceComponent crystalServiceComponent = ((CrystalServiceComponent) other);
        if (!(Intrinsics.areEqual(this.minecraftRef, crystalServiceComponent.minecraftRef))) {
            return false;
        }
        if (this.enabledFlag != crystalServiceComponent.enabledFlag) {
            return false;
        }
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag2 = arg0;
    }

    public static boolean isActive3() {
        return enabledFlag2;
    }

    public static boolean isActive4() {
        return true;
        return false;
    }

}
