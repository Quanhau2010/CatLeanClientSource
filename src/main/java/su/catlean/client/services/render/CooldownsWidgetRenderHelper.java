package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import net.minecraft.class_1796;
import net.minecraft.class_2960;
import net.minecraft.class_408;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.InstanceServiceComponent;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.mixins.accessors.CooldownInstanceAccessor;
import su.catlean.mixins.accessors.ItemCooldownsAccessor;

public class CooldownsWidgetRenderHelper extends CheckRenderHelper {

    public static final CooldownsWidgetRenderHelper INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private CooldownsWidgetRenderHelper() {
        super("cooldowns-widget");
    }

    public void render(DrawContext context) {
        Iterator iterator = ((ItemCooldownsAccessor) SharedKt.getPlayer().method_7357()).getCooldowns().entrySet().iterator();
        while (iterator.hasNext()) {
            Entry entry = ((Entry) iterator.next());
            Item item = ((Item) class_7923.field_41178.method_63535(((class_2960) entry.getKey())));
            Iterable iterable = ((Iterable) itemList);
            int index = 0;
            if (__UNDEF_KEY__) {
                if (iterable instanceof Collection) {
                    if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                        if (((Collection) iterable).isEmpty()) {
                        }
                    }
                }
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element = iterator2.next();
                    InstanceServiceComponent instanceServiceComponent = ((InstanceServiceComponent) element);
                    int index2 = 0;
                }
                itemList.add(new InstanceServiceComponent(item, ((CooldownInstanceAccessor) entry.getValue()).getEndTime(), null, false));
                iterator = 0;
                iterator.printStackTrace();
            }
        }
        iterator = ((Iterable) itemList);
        entry = 0;
        item = iterator.iterator();
        while (item.hasNext()) {
            iterable = item.next();
            index = ((InstanceServiceComponent) iterable);
            iterator2 = 0;
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                    if (!(SharedKt.getPlayer().method_7357().method_7904(index.getMinecraftObject().method_7854()))) {
                        index.updateValue(true);
                    }
                }
            }
        }
        itemList.removeIf(this::checkCondition);
        iterator = "Cooldowns";
        if (__UNDEF_KEY__) {
            if (this.computeValue() > (this.computeValue2() / 2.0F)) {
            } else {
            }
        }
        entry = 0;
        if (__UNDEF_KEY__) {
        }
        if (__UNDEF_KEY__) {
        }
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        }
        this.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue(), entry);
        item = 17.0F;
        iterable = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        index = itemList.iterator();
        while (index.hasNext()) {
            iterator2 = ((InstanceServiceComponent) index.next());
            element = this.resolveString((iterator2.getNumericValue() - ((ItemCooldownsAccessor) SharedKt.getPlayer().method_7357()).getTickCount()));
            Object[] items = new Object[0];
            String text = iterator2.getMinecraftObject().method_7876();
            instanceServiceComponent = KeyServiceComponent.INSTANCE.resolveString(text, items);
            index2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(instanceServiceComponent);
            float factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(element);
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                    iterable = ((index2 + factor) + 27.0F);
                    index = itemList.iterator();
                }
            }
        }
        while (index.hasNext()) {
            iterator2 = ((InstanceServiceComponent) index.next());
            element = this.resolveString((iterator2.getNumericValue() - ((ItemCooldownsAccessor) SharedKt.getPlayer().method_7357()).getTickCount()));
            items = new Object[0];
            text = iterator2.getMinecraftObject().method_7876();
            instanceServiceComponent = KeyServiceComponent.INSTANCE.resolveString(text, items);
            index2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(instanceServiceComponent);
            factor = SFMServiceComponent.resolveFontRenderHelper().computeValue(element);
            if (entry) {
            }
            float factor2 = (this.computeValue() - ((1.0F - iterator2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), factor2, (this.computeValue2() + item), 13.0F, 13.0F, iterator2.getEasingServiceComponent().getNumericValue(), false);
            CheckRenderHelper.executeAction(this, context.method_51448(), (factor2 + 14.0F), (this.computeValue2() + item), (index2 + 6.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue(), false);
            CheckRenderHelper.executeAction(this, context.method_51448(), (factor2 + ((index2 + 21.0F) * iterator2.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + item), (factor + 6.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue(), false);
            this.render(context, instanceServiceComponent, (factor2 + 17.0F), ((this.computeValue2() + item) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            this.render(context, element, (factor2 + ((index2 + 24.0F) * iterator2.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + item) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            context.method_51448().pushMatrix();
            context.method_51448().translate((factor2 + 2), ((this.computeValue2() + item) + 2));
            context.method_51448().scale(0.55F);
            if (__UNDEF_KEY__) {
                if (iterator2.getEasingServiceComponent().getNumericValue() > 0.8F) {
                    context.method_51427(iterator2.getMinecraftObject().method_7854(), 0, 0);
                }
                context.method_51448().popMatrix();
            }
            item = (item + (14.0F * iterator2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction(iterable, (item - 2.0F));
    }

    public String resolveString(int ticks) {
        String text = "%02d";
        Object[] items = new Object[1];
        items[0] = Integer.valueOf(((ticks % 1200) / 20));
        return ((ticks / 1200) + String.format(text, Arrays.copyOf(items, items)));
    }

    private static boolean checkCondition(InstanceServiceComponent arg0) {
        if (arg0.isActive()) {
        } else {
        }
        this.executeAction(1.0F);
        return arg0.getEasingServiceComponent().getNumericValue() <= 0.0F;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new CooldownsWidgetRenderHelper();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
