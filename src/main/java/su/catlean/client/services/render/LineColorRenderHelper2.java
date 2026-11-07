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
        Box var10 = new Box(this.blockPos);
        float var11 = 1.0F;
        if (!(var9)) {
            var11 = (1 - (time / 300.0F));
            var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
            if (!(var9)) {
                var11 = (1.0F - (time / 300.0F));
                var10 = new Box(this.blockPos);
                if (!(var9)) {
                    var11 = (time / 300.0F);
                    var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
                    if (!(var9)) {
                        if (var9) {
                            if (time > 100L) {
                            }
                        }
                        var11 = (time / 100);
                        var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
                        if (!(var9)) {
                            var11 = (time / 300.0F);
                            var10 = new Box(this.blockPos.method_10263(), (this.blockPos.method_10264() + var11), this.blockPos.method_10260(), (this.blockPos.method_10263() + 1), this.blockPos.method_10264(), (this.blockPos.method_10260() + 1));
                            if (!(var9)) {
                                if (var9) {
                                    if (time < 200L) {
                                    }
                                }
                                var11 = (1 + ((time - 200.0F) / 400.0F));
                                var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
                                if (!(var9)) {
                                    if (time < 200L) {
                                    }
                                    var11 = 1.0F;
                                    var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5F)), (0.5D + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
                                    if (!(var9)) {
                                        var11 = (1.0F + (time / 1500.0F));
                                        var10 = new Box(this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260(), this.blockPos.method_10263(), this.blockPos.method_10264(), this.blockPos.method_10260()).method_1002().method_989((0.5D + (var11 * 0.5F)), (0.5F + (var11 * 0.5D)), (0.5D + (var11 * 0.5D)));
                                        if (!(var9)) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        this.executeAction(this.blockPlacementRenderMode, this.colorValue, this.colorValue2);
    }

    private void executeAction(float arg0, long arg1, Box arg2, BlockPlacementRenderMode arg3, Color arg4, Color arg5) {
        if (!(var23)) {
            if (arg3 != BlockPlacementRenderMode.BOTH) {
            }
            if (arg1 > 0L) {
                if (!(var23)) {
                    if (arg3 == BlockPlacementRenderMode.LINE) {
                    }
                    TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(arg4, (PolygonShaderComponent.INSTANCE.computeValue2(arg4) * arg0)));
                }
            }
        }
        if (arg1 >= 0L) {
            if (!(var23)) {
                if (arg3 != BlockPlacementRenderMode.BOTH) {
                }
            }
            if (arg1 >= 0L && !(var23)) {
                if (arg3 == BlockPlacementRenderMode.FILL) {
                }
                TextShaderComponent2.checkCondition(arg2, PolygonShaderComponent.INSTANCE.resolveColor(arg5, (PolygonShaderComponent.INSTANCE.computeValue2(arg5) * arg0)));
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
        if (var12) {
            if ((arg6 & 1)) {
                arg1 = arg0.blockPos;
            }
        }
        if (var12) {
            if ((arg6 & 2)) {
                arg2 = arg0.colorValue;
            }
        }
        if (var12) {
            if ((arg6 & 4)) {
                arg3 = arg0.colorValue2;
            }
        }
        if (var12) {
            if ((arg6 & 8)) {
                arg4 = arg0.blockPlacementRenderAnimationMode;
            }
        }
        if ((arg6 & 16)) {
            arg5 = arg0.blockPlacementRenderMode;
        }
        return arg0.resolveLineColorRenderHelper2(arg1, arg2, arg3, arg4, arg5);
    }

    public String toString() {
        BlockPlacementRenderMode var3 = this.blockPlacementRenderMode;
        BlockPlacementRenderAnimationMode var4 = this.blockPlacementRenderAnimationMode;
        Color var5 = this.colorValue2;
        Color var6 = this.colorValue;
        BlockPos blockPos = this.blockPos;
        return ("BlockRenderData(pos=" + blockPos + ", lineColor=" + var6 + ", fillColor=" + var5 + ", animationMode=" + var4 + ", renderMode=" + var3 + ")");
    }

    public int hashCode() {
        int var3 = this.blockPos.hashCode();
        var3 = ((var3 * 31) + this.colorValue.hashCode());
        var3 = ((var3 * 31) + this.colorValue2.hashCode());
        var3 = ((var3 * 31) + this.blockPlacementRenderAnimationMode.hashCode());
        var3 = ((var3 * 31) + this.blockPlacementRenderMode.hashCode());
        return var3;
    }

    public boolean equals(Object other) {
        if (!(var4)) {
            if (this == other) {
                return true;
            }
        }
        if (!(var4)) {
            if (!(other instanceof LineColorRenderHelper2)) {
                return false;
            }
        }
        LineColorRenderHelper2 var5 = (LineColorRenderHelper2) other;
        if (!(var4)) {
            if (!(Intrinsics.areEqual(this.blockPos, var5.blockPos))) {
                return false;
            }
        }
        if (!(var4)) {
            if (!(Intrinsics.areEqual(this.colorValue, var5.colorValue))) {
                return false;
            }
            if (!(var4)) {
            }
            if (!(Intrinsics.areEqual(this.colorValue2, var5.colorValue2))) {
                return false;
            }
        }
        if (!(var4)) {
            if (this.blockPlacementRenderAnimationMode != var5.blockPlacementRenderAnimationMode) {
                return false;
            }
        }
        if (this.blockPlacementRenderMode != var5.blockPlacementRenderMode) {
            return false;
        }
        return true;
    }

}
