package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class SideServiceComponent {

    private final BlockPos blockPos;
    private final Direction minecraftRef;
    private final float factorValue;
    private final float factorValue2;

    public SideServiceComponent(BlockPos pos, Direction side, float damage, float selfDamage) {
        this.blockPos = pos;
        this.minecraftRef = side;
        this.factorValue = damage;
        this.factorValue2 = selfDamage;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public Direction getMinecraftObject() {
        return this.minecraftRef;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public Direction getMinecraftObject2() {
        return this.minecraftRef;
    }

    public float getNumericValue3() {
        return this.factorValue;
    }

    public float getNumericValue4() {
        return this.factorValue2;
    }

    public SideServiceComponent resolveSideServiceComponent(BlockPos pos, Direction side, float damage, float selfDamage) {
        return new SideServiceComponent(pos, side, damage, selfDamage);
    }

    public String toString() {
        float var3 = this.factorValue2;
        float var4 = this.factorValue;
        Direction var5 = this.minecraftRef;
        BlockPos blockPos = this.blockPos;
        return ("RenderPosition(pos=" + blockPos + ", side=" + var5 + ", damage=" + var4 + ", selfDamage=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.blockPos.hashCode();
        var3 = ((var3 * 31) + this.minecraftRef.hashCode());
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue));
        var3 = ((var3 * 31) + Float.hashCode(this.factorValue2));
        return var3;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SideServiceComponent)) {
            return false;
        }
        SideServiceComponent var5 = (SideServiceComponent) other;
        if (!(Intrinsics.areEqual(this.blockPos, var5.blockPos))) {
            return false;
        }
        if (this.minecraftRef != var5.minecraftRef) {
            return false;
        }
        if (Float.compare(this.factorValue, var5.factorValue)) {
            return false;
        }
        if (Float.compare(this.factorValue2, var5.factorValue2)) {
            return false;
        }
        return true;
    }

}
