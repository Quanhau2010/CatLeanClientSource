package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import su.catlean.client.features.modules.BlockPlacementRenderAnimationMode;
import su.catlean.client.features.modules.BlockPlacementRenderMode;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.mappings.BlockPlacementRenderAnimationModeWhenMappings;

public class LineColorRenderHelper2 {

    private final BlockPos blockPos;
    private final Color colorValue;
    private final Color colorValue2;
    private final BlockPlacementRenderAnimationMode blockPlacementRenderAnimationMode;
    private final BlockPlacementRenderMode blockPlacementRenderMode;

    public LineColorRenderHelper2(BlockPos pos, Color lineColor, Color fillColor, BlockPlacementRenderAnimationMode animationMode, BlockPlacementRenderMode renderMode) {
        this.blockPos = pos;
        this.colorValue = lineColor;
        this.colorValue2 = fillColor;
        this.blockPlacementRenderAnimationMode = animationMode;
        this.blockPlacementRenderMode = renderMode;
    }

    public BlockPos getMinecraftObject() {
        return this.blockPos;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public Color getColor2() {
        return this.colorValue2;
    }

    public BlockPlacementRenderAnimationMode getBlockPlacementRenderAnimationMode() {
        return this.blockPlacementRenderAnimationMode;
    }

    public BlockPlacementRenderMode getBlockPlacementRenderMode() {
        return this.blockPlacementRenderMode;
    }

    public void render(long time, MatrixStack stack) {
        Box box = new Box(this.blockPos);
        float factor = 1.0F;
        if (!(__UNDEF_KEY__)) {
            factor = (1 - (time / 300.0F));
            box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
            if (!(__UNDEF_KEY__)) {
                factor = (1.0F - (time / 300.0F));
                box = new Box(this.blockPos);
                if (!(__UNDEF_KEY__)) {
                    factor = (time / 300.0F);
                    box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
                    if (!(__UNDEF_KEY__)) {
                        if (__UNDEF_KEY__) {
                            if (time > 100L) {
                            }
                        }
                        factor = (time / 100);
                        box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
                        if (!(__UNDEF_KEY__)) {
                            factor = (time / 300.0F);
                            box = new Box(this.blockPos.method_10263(), (this.blockPos.method_10264() + factor), this.blockPos.method_10260(), (this.blockPos.method_10263() + 1), this.blockPos.method_10264(), (this.blockPos.method_10260() + 1));
                            if (!(__UNDEF_KEY__)) {
                                if (__UNDEF_KEY__) {
                                    if (time < 200L) {
                                    }
                                }
                                factor = (1 + ((time - 200.0F) / 400.0F));
                                box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
                                if (!(__UNDEF_KEY__)) {
                                    if (time < 200L) {
                                    }
                                    factor = 1.0F;
                                    box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5F)), (0.5D + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
                                    if (!(__UNDEF_KEY__)) {
                                        factor = (1.0F + (time / 1500.0F));
                                        box = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002(factor, factor, factor).method_989((0.5D + (factor * 0.5F)), (0.5F + (factor * 0.5D)), (0.5D + (factor * 0.5D)));
                                        if (!(__UNDEF_KEY__)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.executeAction(factor, box, this.blockPlacementRenderMode, this.colorValue, this.colorValue2);
    }

    private void executeAction(float arg0, long arg1, Box arg2, BlockPlacementRenderMode arg3, Color arg4, Color arg5) {
        if (arg3 != BlockPlacementRenderMode.BOTH) {
            if (arg1 > 0L) {
                if (!(__UNDEF_KEY__)) {
                    if (arg3 == BlockPlacementRenderMode.LINE) {
                        TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(arg4, (PolygonShaderComponent.INSTANCE.computeValue2(arg4) * arg0)));
                    }
                }
            }
        }
        if (arg1 >= 0L) {
            if (!(__UNDEF_KEY__)) {
                if (arg3 != BlockPlacementRenderMode.BOTH) {
                    if (arg1 >= 0L) {
                        if (arg3 == BlockPlacementRenderMode.FILL) {
                            TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(arg5, (PolygonShaderComponent.INSTANCE.computeValue2(arg5) * arg0)));
                        }
                    }
                }
            }
        }
        TextShaderComponent2.INSTANCE.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(arg5, (PolygonShaderComponent.INSTANCE.computeValue2(arg5) * arg0)), PolygonShaderComponent.INSTANCE.resolveColor(arg4, (PolygonShaderComponent.INSTANCE.computeValue2(arg4) * arg0)));
    }

    public BlockPos getMinecraftObject2() {
        return this.blockPos;
    }

    public Color getColor3() {
        return this.colorValue;
    }

    public Color getColor4() {
        return this.colorValue2;
    }

    public BlockPlacementRenderAnimationMode getBlockPlacementRenderAnimationMode2() {
        return this.blockPlacementRenderAnimationMode;
    }

    public BlockPlacementRenderMode getBlockPlacementRenderMode2() {
        return this.blockPlacementRenderMode;
    }

    public LineColorRenderHelper2 resolveLineColorRenderHelper2(BlockPos pos, Color lineColor, Color fillColor, BlockPlacementRenderAnimationMode animationMode, BlockPlacementRenderMode renderMode) {
        return new LineColorRenderHelper2(pos, lineColor, fillColor, animationMode, renderMode);
    }

    public static LineColorRenderHelper2 resolveLineColorRenderHelper2(LineColorRenderHelper2 arg0, BlockPos arg1, Color arg2, Color arg3, BlockPlacementRenderAnimationMode arg4, BlockPlacementRenderMode arg5, int arg6, Object arg7) {
        arg1 = arg0.blockPos;
        arg2 = arg0.colorValue;
        arg3 = arg0.colorValue2;
        arg4 = arg0.blockPlacementRenderAnimationMode;
        if ((arg6 & 16) != 0) {
            arg5 = arg0.blockPlacementRenderMode;
        }
        return arg0.resolveLineColorRenderHelper2(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        BlockPlacementRenderMode blockPlacementRenderMode = this.blockPlacementRenderMode;
        BlockPlacementRenderAnimationMode blockPlacementRenderAnimationMode = this.blockPlacementRenderAnimationMode;
        Color color = this.colorValue2;
        Color color2 = this.colorValue;
        BlockPos blockPos = this.blockPos;
        return ("BlockRenderData(pos=" + blockPos + ", lineColor=" + color2 + ", fillColor=" + color + ", animationMode=" + blockPlacementRenderAnimationMode + ", renderMode=" + blockPlacementRenderMode + ")");
    }

    public int hashCode() {
        int index = this.blockPos.hashCode();
        index = ((index * 31) + this.colorValue.hashCode());
        index = ((index * 31) + this.colorValue2.hashCode());
        index = ((index * 31) + this.blockPlacementRenderAnimationMode.hashCode());
        index = ((index * 31) + this.blockPlacementRenderMode.hashCode());
        return index;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LineColorRenderHelper2)) {
            return false;
        }
        LineColorRenderHelper2 lineColorRenderHelper2 = ((LineColorRenderHelper2) other);
        if (!(Intrinsics.areEqual(this.blockPos, lineColorRenderHelper2.blockPos))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue, lineColorRenderHelper2.colorValue))) {
            return false;
        }
        if (!(Intrinsics.areEqual(this.colorValue2, lineColorRenderHelper2.colorValue2))) {
            return false;
        }
        if (this.blockPlacementRenderAnimationMode != lineColorRenderHelper2.blockPlacementRenderAnimationMode) {
            return false;
        }
        if (this.blockPlacementRenderMode != lineColorRenderHelper2.blockPlacementRenderMode) {
            return false;
        }
        return true;
    }

}
