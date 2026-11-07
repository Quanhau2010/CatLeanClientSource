package su.catlean.client.services.client;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;

public class ServiceComponent128 {

    private final BlockPos blockPos;
    private float factorValue;
    private float factorValue2;

    public ServiceComponent128(BlockPos pos, float progress, float prevProgress) {
        this.blockPos = pos;
        this.factorValue = progress;
        this.factorValue2 = prevProgress;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public boolean checkCondition() {
        this.factorValue2 = this.factorValue;
        this.factorValue = (this.factorValue + 0.025F);
        if (SharedKt.getWorld().method_22347(this.blockPos)) {
            return true;
        }
        if (this.factorValue > 2.0F != null) {
        }
        return null;
    }

}
