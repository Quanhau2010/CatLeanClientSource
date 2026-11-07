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
import su.catlean.client.services.client.AnimationServiceComponent2;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.ProfileServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.network.EntryPacketHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class StaffWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final StaffWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private StaffWidgetCheckRenderHelperImpl() {
        super("staff-widget");
    }

    public void render(DrawContext context) {
        Iterator iterator = EntryPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            Iterable iterable = ((Iterable) itemList);
            int index = 0;
            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
            } else {
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element = iterator2.next();
                    AnimationServiceComponent2 animationServiceComponent2 = ((AnimationServiceComponent2) element);
                    int index2 = 0;
                }
            }
            int index3 = 1;
            itemList.add(new AnimationServiceComponent2(this.resolveString3(), null, false));
        }
        iterator = ((Iterable) itemList);
        index3 = iterator.iterator();
        while (index3.hasNext()) {
            iterable = index3.next();
            index = ((AnimationServiceComponent2) iterable);
            iterator2 = 0;
            element = ((Iterable) EntryPacketHelper.INSTANCE.getList());
            animationServiceComponent2 = 0;
            if (element instanceof Collection && ((Collection) element).isEmpty()) {
            } else {
                index2 = element.iterator();
                while (index2.hasNext()) {
                    Object element2 = index2.next();
                    ProfileServiceComponent profileServiceComponent = ((ProfileServiceComponent) element2);
                }
            }
            if (1) {
                index.updateValue(true);
            }
        }
        itemList.removeIf(this::checkCondition);
        iterator = "Staff";
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        this.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue());
        index3 = 17.0F;
        iterable = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        index = itemList.iterator();
        while (index.hasNext()) {
            iterator2 = ((AnimationServiceComponent2) index.next());
            element = SFMServiceComponent.resolveFontRenderHelper().computeValue(StringsKt.trim(((CharSequence) iterator2.getString())).toString());
            iterable = (element + 7.0F);
        }
        index = itemList.iterator();
        while (index.hasNext()) {
            iterator2 = ((AnimationServiceComponent2) index.next());
            element = SFMServiceComponent.resolveFontRenderHelper().computeValue(StringsKt.trim(((CharSequence) iterator2.getString())).toString());
            animationServiceComponent2 = (this.computeValue() - ((1.0F - iterator2.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), animationServiceComponent2, (this.computeValue2() + index3), (element + 7.0F), 13.0F, iterator2.getEasingServiceComponent().getNumericValue(), false);
            index2 = index3;
            this.render(context, StringsKt.trim(((CharSequence) iterator2.getString())).toString(), (animationServiceComponent2 + 3.0F), ((this.computeValue2() + index2) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), iterator2.getEasingServiceComponent().getNumericValue()));
            index3 = (index3 + (14.0F * iterator2.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction(iterable, (13.0F + index3));
    }

    private static boolean checkCondition(AnimationServiceComponent2 arg0) {
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
        INSTANCE = new StaffWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
