package su.catlean.client.services.render;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.minecraft.class_408;
import net.minecraft.client.gui.DrawContext;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.utility.misc.UIModule;
import su.catlean.client.services.client.BindServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EnabledServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class KeybindsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final KeybindsWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private KeybindsWidgetCheckRenderHelperImpl() {
        super("keybinds-widget");
    }

    public List getList() {
        return itemList;
    }

    public void render(DrawContext context) {
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            int index3 = 0;
            collection.add(element);
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = ((Module) iterator2.next());
            iterable2 = ((Iterable) itemList);
            collection = 0;
            if (iterable2 instanceof Collection && ((Collection) iterable2).isEmpty()) {
            } else {
                index2 = iterable2.iterator();
                while (index2.hasNext()) {
                    iterator = index2.next();
                    element = ((BindServiceComponent) iterator);
                    module = 0;
                }
            }
            index = 1;
            if (iterable.getBind().getNumericValue() != -1 && iterable.getEnabled() && index) {
                itemList.add(new BindServiceComponent(iterable.getString2(), NoneServiceComponent.INSTANCE.resolveString(iterable.getBind().getNumericValue()), null, null, false));
            }
            if (iterable.getBind().getNumericValue() != -1) {
            }
            iterable2 = ((Iterable) itemList);
            collection = 0;
            index2 = iterable2;
            iterator = ((Collection) new ArrayList());
            element = 0;
            module = index2.iterator();
            while (module.hasNext()) {
                index3 = module.next();
                BindServiceComponent bindServiceComponent = ((BindServiceComponent) index3);
                iterator.add(index3);
            }
            iterable2 = ((Iterable) iterator);
            collection = 0;
            index2 = iterable2.iterator();
            while (index2.hasNext()) {
                iterator = index2.next();
                element = ((BindServiceComponent) iterator);
                module = 0;
                element.updateValue(true);
            }
        }
        itemList.removeIf(this::checkCondition);
        iterator2 = "Key Binds";
        iterable = this.computeValue() > (this.computeValue2() / 2.0F);
        if (itemList.isEmpty()) {
            if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
                if (!(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
                } else {
                }
            } else {
            }
        } else {
        }
        this.executeAction(1.0F);
        this.render(context, iterator2, easingServiceComponent.getNumericValue(), iterable);
        index = 17.0F;
        iterable2 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator2) + 24.0F);
        collection = itemList.iterator();
        while (collection.hasNext()) {
            index2 = ((BindServiceComponent) collection.next());
            element = ((CharSequence) index2.getString3());
            if (!(element.length())) {
                FontRenderHelper fontRenderHelper = SFMServiceComponent.resolveFontRenderHelper();
                module = 0;
            } else {
            }
            iterator = StringsKt.trim(((CharSequence) index2.getString())).toString().computeValue(((String) element));
            element = SFMServiceComponent.resolveFontRenderHelper().computeValue(index2.getString2());
            iterable2 = ((iterator + element) + 13.0F);
        }
        collection = itemList.iterator();
        while (collection.hasNext()) {
            index2 = ((BindServiceComponent) collection.next());
            element = ((CharSequence) index2.getString3());
            if (!(element.length())) {
                fontRenderHelper = SFMServiceComponent.resolveFontRenderHelper();
                module = 0;
            } else {
            }
            iterator = StringsKt.trim(((CharSequence) index2.getString())).toString().computeValue(((String) element));
            element = SFMServiceComponent.resolveFontRenderHelper().computeValue(index2.getString2());
            if (iterable) {
            } else {
            }
            module = (this.computeValue() - ((1.0F - index2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), module, (this.computeValue2() + index), (iterator + 6.0F), 13.0F, index2.getEasingServiceComponent().getNumericValue(), false);
            CheckRenderHelper.executeAction(this, context.method_51448(), (module + ((iterator + 7.0F) * index2.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + index), (element + 8.0F), 13.0F, index2.getEasingServiceComponent().getNumericValue(), false);
            index3 = index;
            bindServiceComponent = ((CharSequence) index2.getString3());
            if (!(bindServiceComponent.length())) {
                fontRenderHelper = this;
                String text = StringsKt.trim(((CharSequence) index2.getString())).toString();
            } else {
            }
            context.render(text, ((String) bindServiceComponent), (module + 3.0F), ((this.computeValue2() + index3) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), index2.getEasingServiceComponent().getNumericValue()));
            this.render(context, index2.getString2(), (module + ((iterator + 11.0F) * index2.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + index3) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), index2.getEasingServiceComponent().getNumericValue()));
            index = (index + (14.0F * index2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction(iterable2, (index - 2.0F));
    }

    private static boolean checkCondition(BindServiceComponent arg0) {
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
        INSTANCE = new KeybindsWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
