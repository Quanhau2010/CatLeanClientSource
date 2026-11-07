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
        float factor = 50.0F;
        if (blockPos == null) {
            return;
        }
        double offset = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6014, SharedKt.getPlayer().getX(), PolygonShaderComponent.INSTANCE.computeValue());
        double offset2 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_5969, SharedKt.getPlayer().getZ(), PolygonShaderComponent.INSTANCE.computeValue());
        int index = (blockPos.method_10263() + 0.5F);
        int index2 = (blockPos.method_10260() + 0.5F);
        double offset3 = (((offset - index) + 0.2F) * factor);
        double offset4 = (((offset2 - index2) + 0.2F) * factor);
        context.method_51448().pushMatrix();
        context.method_51448().rotateAbout(Math.toRadians((SharedKt.getPlayer().method_36454() + 180.0D)), (this.computeValue() + (factor * 0.5F)), (this.computeValue2() + (factor * 0.5F)));
        float factor2 = (this.computeValue() + offset3);
        float factor3 = (this.computeValue2() + offset4);
        if (!(enabledFlag)) {
        } else {
        }
        Color color = Color.RED;
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), this.computeValue(), this.computeValue2(), factor, factor, NewThemeRenderHelper.INSTANCE.getColor7());
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), factor2, factor3, (factor * 0.6F), (factor * 0.6F), color);
        context.method_51448().popMatrix();
        this.executeAction(factor, factor);
    }

    public void updateValue() {
        Box box = SharedKt.getPlayer().method_5829();
        float factor = 1.0E-5F;
        enabledFlag = 0;
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            } else {
            }
        }
        blockPos = null;
        BlockPos[] items = new BlockPos[4];
        items[0] = BlockPos.method_49637(box.field_1323, (box.field_1322 + 0.3D), box.field_1321);
        items[1] = BlockPos.method_49637(box.field_1323, (box.field_1322 + 0.3D), (box.field_1324 - factor));
        items[2] = BlockPos.method_49637((box.field_1320 - factor), (box.field_1322 + 0.3D), box.field_1321);
        items[3] = BlockPos.method_49637((box.field_1320 - factor), (box.field_1322 + 0.3D), (box.field_1324 - factor));
        List list = CollectionsKt.listOf(items);
        items = list.iterator();
        while (items.hasNext()) {
            BlockPos blockPos = ((BlockPos) items.next());
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
