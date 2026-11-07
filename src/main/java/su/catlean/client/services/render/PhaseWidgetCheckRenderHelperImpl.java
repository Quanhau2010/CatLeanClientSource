package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import net.minecraft.block.BlockState;
import net.minecraft.class_408;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;

public class PhaseWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PhaseWidgetCheckRenderHelperImpl INSTANCE;
    private static BlockPos blockPos;
    private static boolean enabledFlag;

    private PhaseWidgetCheckRenderHelperImpl() {
        super("phase-widget");
    }

    public BlockPos getMinecraftObject() {
        return blockPos;
    }

    public void updateValue(BlockPos value) {
        blockPos = value;
    }

    public boolean isActive() {
        return enabledFlag;
    }

    public void updateValue(boolean value) {
        enabledFlag = value;
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 50910300018319L);
        long var6 = (0L ^ 133399993616875L);
        long var8 = (0L ^ 20494741382199L);
        long var10 = (0L ^ 30591967126976L);
        long var12 = (0L ^ 109580710346244L);
        float var14 = 50.0F;
        if (blockPos == null) {
            return;
        }
        double var15 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6014, SharedKt.getPlayer().getX(), PolygonShaderComponent.INSTANCE.computeValue());
        double var17 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_5969, SharedKt.getPlayer().getZ(), PolygonShaderComponent.INSTANCE.computeValue());
        int var19 = (blockPos.method_10263() + 0.5F);
        int var20 = (blockPos.method_10260() + 0.5F);
        double var21 = (((var15 - var19) + 0.2F) * var14);
        double var22 = (((var17 - var20) + 0.2F) * var14);
        context.method_51448().pushMatrix();
        context.method_51448().rotateAbout(Math.toRadians((SharedKt.getPlayer().method_36454() + 180.0D)), (this.computeValue() + (var14 * 0.5F)), (this.computeValue2() + (var14 * 0.5F)));
        float var23 = (this.computeValue() + var21);
        float var24 = (this.computeValue2() + var22);
        if (!(enabledFlag)) {
        } else {
        }
        Color var25 = Color.RED;
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), this.computeValue(), this.computeValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (var14 * 0.6F), (var14 * 0.6F));
        context.method_51448().popMatrix();
        this.executeAction();
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 4312191108922L);
        long var5 = (arg0 ^ 29379288129452L);
        long var7 = (arg0 ^ 36689842386875L);
        long var9 = (arg0 ^ 38798774274332L);
        Box var12 = SharedKt.getPlayer().method_5829();
        float var13 = 1.0E-5F;
        enabledFlag = 0;
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            }
        } else {
        }
        blockPos = null;
        BlockPos[] var15 = new BlockPos[4];
        var15[0] = BlockPos.method_49637(var12.field_1323, (var12.field_1322 + 0.3D), var12.field_1321);
        var15[1] = BlockPos.method_49637(var12.field_1323, (var12.field_1322 + 0.3D), (var12.field_1324 - var13));
        var15[2] = BlockPos.method_49637((var12.field_1320 - var13), (var12.field_1322 + 0.3D), var12.field_1321);
        var15[3] = BlockPos.method_49637((var12.field_1320 - var13), (var12.field_1322 + 0.3D), (var12.field_1324 - var13));
        List positions = CollectionsKt.listOf();
        var15 = positions.iterator();
        if (var15.hasNext()) {
            BlockPos blockPos = (BlockPos) var15.next();
            if (!(SharedKt.getWorld().getBlockState(blockPos).method_45474())) {
                blockPos = blockPos;
            }
            enabledFlag = 1;
        }
    }

    static {
        INSTANCE = new PhaseWidgetCheckRenderHelperImpl();
    }

}
