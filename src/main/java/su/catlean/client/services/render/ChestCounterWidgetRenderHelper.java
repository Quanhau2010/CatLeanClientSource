package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Pair;
import net.minecraft.block.BlockState;
import net.minecraft.class_2281;
import net.minecraft.class_2595;
import net.minecraft.class_2745;
import net.minecraft.class_2769;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.world.ClientWorld;
import su.catlean.SharedKt;
import su.catlean.client.services.network.TheNetherPacketHelper;

public class ChestCounterWidgetRenderHelper extends CheckRenderHelper {

    public static final ChestCounterWidgetRenderHelper INSTANCE;

    private ChestCounterWidgetRenderHelper() {
        super("chest-counter-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 116853176505585L);
        long var6 = (0L ^ 14448239366368L);
        Pair var8 = this.resolvePair();
        Object var11 = context;
        Object var10 = this;
        int var9 = 0;
        String var12 = (null + var8.getFirst() + " D:" + var8.getSecond());
        var10.render();
    }

    private Pair resolvePair() {
        int var6 = 0;
        int var7 = 0;
        Iterable var8 = (Iterable) TheNetherPacketHelper.INSTANCE.getList();
        int var9 = 0;
        Object var10 = var8;
        Collection var11 = (Collection) new ArrayList();
        int var12 = 0;
        Iterator iterator = var10.iterator();
        if (iterator.hasNext()) {
            Object var14 = iterator.next();
            if (var5) {
                if (var5) {
                }
                var11.add();
            }
            var8 = (Iterable) var11;
        }
        var9 = 0;
        var10 = var8.iterator();
        if (var10.hasNext()) {
            var11 = var10.next();
            var12 = (class_2595) var11;
            iterator = 0;
            var14 = (class_2745) SharedKt.getWorld().getBlockState(var12.method_11016()).method_11654((class_2769) class_2281.field_10770);
            if (var5) {
                if (var14 == class_2745.field_12569) {
                    int var15 = var6;
                    var6 = (var15 + 1);
                    if (!(var5)) {
                    }
                    var15 = var7;
                    var7 = (var15 + 1);
                }
            }
        }
        return new Pair(Integer.valueOf(), Integer.valueOf((var7 / 2)));
    }

    static {
        INSTANCE = new ChestCounterWidgetRenderHelper();
    }

}
