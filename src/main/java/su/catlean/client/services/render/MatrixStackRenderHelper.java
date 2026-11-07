package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.BlockPlacementRenderAnimationMode;
import su.catlean.client.features.modules.BlockPlacementRenderMode;

public class MatrixStackRenderHelper {

    public static final MatrixStackRenderHelper INSTANCE;
    private static final Map lookupMap;

    private MatrixStackRenderHelper() {
    }

    public Map getMap() {
        return lookupMap;
    }

    public void render(MatrixStack matrixStack) {
        Map var7 = lookupMap;
        int var8 = 0;
        Iterator iterator = var7.entrySet().iterator();
        if (iterator.hasNext()) {
            Entry var10 = (Entry) iterator.next();
            Object var11 = var10;
            int var12 = 0;
            LineColorRenderHelper2 var13 = (LineColorRenderHelper2) var11.getKey();
            long var14 = (Number) var11.getValue().longValue();
            if (var6) {
                if ((SharedKt.getNumericValue() - var14) > 300.0F) {
                    lookupMap.remove();
                }
                if (!(var6)) {
                }
                var13.render((SharedKt.getNumericValue() - var14), matrixStack);
            }
        }
    }

    public void executeAction(BlockPos pos, Color lineColor, Color fillColor, BlockPlacementRenderAnimationMode animationMode, BlockPlacementRenderMode renderMode) {
        if (var14) {
            if (renderMode == BlockPlacementRenderMode.NONE) {
                return;
            }
        }
        lookupMap.put(new LineColorRenderHelper2(pos, lineColor, fillColor, animationMode, renderMode), Long.valueOf(SharedKt.getNumericValue()));
    }

    public boolean checkCondition(BlockPos pos) {
        return lookupMap.keySet().stream().anyMatch(this::checkCondition);
    }

    private static boolean checkCondition(BlockPos arg0, LineColorRenderHelper2 arg1) {
        return Intrinsics.areEqual(arg1.getMinecraftObject(), arg0);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new MatrixStackRenderHelper();
        lookupMap = (Map) new ConcurrentHashMap();
    }

}
