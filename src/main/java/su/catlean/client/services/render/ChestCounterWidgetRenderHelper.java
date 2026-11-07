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
        Pair pair = this.resolvePair();
        String text = (null + pair.getFirst() + " D:" + pair.getSecond());
        this.render(context, text);
    }

    private Pair resolvePair() {
        int index = 0;
        int index2 = 0;
        Iterable iterable = ((Iterable) TheNetherPacketHelper.INSTANCE.getList());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index3 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                }
                collection.add(element);
                iterable = ((Iterable) collection);
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index3 = ((class_2595) collection);
            iterator = 0;
            element = ((class_2745) SharedKt.getWorld().getBlockState(index3.method_11016()).method_11654(((class_2769) class_2281.field_10770)));
            if (__UNDEF_KEY__) {
                if (element == class_2745.field_12569) {
                    int index4 = index;
                    index = (index4 + 1);
                    if (!(__UNDEF_KEY__)) {
                        index4 = index2;
                        index2 = (index4 + 1);
                    }
                }
            }
        }
        return new Pair(Integer.valueOf(index), Integer.valueOf((index2 / 2)));
    }

    static {
        INSTANCE = new ChestCounterWidgetRenderHelper();
    }

}
