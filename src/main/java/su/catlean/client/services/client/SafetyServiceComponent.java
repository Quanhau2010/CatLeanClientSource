package su.catlean.client.services.client;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import su.catlean.client.types.OptionMode12;
import su.catlean.client.types.OptionMode17;
import su.catlean.client.types.mappings.zWhenMappings;

public class SafetyServiceComponent {

    private final BlockPos blockPos;
    private final OptionMode12 optionMode12;
    private final OptionMode17 optionMode17;

    public SafetyServiceComponent(BlockPos pos, OptionMode12 safety, OptionMode17 shape) {
        this.blockPos = pos;
        this.optionMode12 = safety;
        this.optionMode17 = shape;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public OptionMode12 getOptionMode12() {
        return this.optionMode12;
    }

    public OptionMode17 getOptionMode17() {
        return this.optionMode17;
    }

    public Box resolveMinecraftObject(float height) {
        int var4 = this.blockPos.method_10263();
        int var6 = this.blockPos.method_10264();
        int var8 = this.blockPos.method_10260();
        return new Box((var4 + 1.0D), (var6 + height), (var8 + 1.0D));
    }

}
