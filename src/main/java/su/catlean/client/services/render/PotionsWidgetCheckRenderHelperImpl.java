package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10799;
import net.minecraft.class_1291;
import net.minecraft.class_1293;
import net.minecraft.class_329;
import net.minecraft.class_408;
import net.minecraft.class_4081;
import net.minecraft.class_6880;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.InstanceServiceComponent2;
import su.catlean.client.services.client.KeyServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class PotionsWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PotionsWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private PotionsWidgetCheckRenderHelperImpl() {
        super("potions-widget");
    }

    public void render(DrawContext context) {
        Iterator iterator = SharedKt.getPlayer().method_6026().iterator();
        while (iterator.hasNext()) {
            class_1293 class1293 = ((class_1293) iterator.next());
            Iterable iterable = ((Iterable) itemList);
            int index = 0;
            if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
            } else {
                Iterator iterator2 = iterable.iterator();
                while (iterator2.hasNext()) {
                    Object element = iterator2.next();
                    InstanceServiceComponent2 instanceServiceComponent2 = ((InstanceServiceComponent2) element);
                    int index2 = 0;
                }
            }
            itemList.add(new InstanceServiceComponent2(class1293, null, false));
        }
        iterator = ((Iterable) itemList);
        class1293 = 0;
        iterable = iterator.iterator();
        while (iterable.hasNext()) {
            index = iterable.next();
            iterator2 = ((InstanceServiceComponent2) index);
            element = 0;
            instanceServiceComponent2 = ((Iterable) SharedKt.getPlayer().method_6026());
            index2 = 0;
            if (instanceServiceComponent2 instanceof Collection && ((Collection) instanceServiceComponent2).isEmpty()) {
            } else {
                Iterator iterator3 = instanceServiceComponent2.iterator();
                while (iterator3.hasNext()) {
                    int index3 = 0;
                }
            }
            if (1) {
                iterator2.updateValue(true);
            }
        }
        itemList.removeIf(this::checkCondition);
        iterator = "Potions";
        class1293 = this.computeValue() > (this.computeValue2() / 2.0F);
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        this.executeAction(1.0F);
        this.render(context, iterator, easingServiceComponent.getNumericValue(), class1293);
        iterable = 17.0F;
        index = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 24.0F);
        iterator2 = itemList.iterator();
        while (iterator2.hasNext()) {
            element = ((InstanceServiceComponent2) iterator2.next());
            Object[] items = new Object[0];
            String text = element.getMinecraftObject().method_5586();
            if (element.getMinecraftObject().method_5578() > 0) {
            } else {
            }
            instanceServiceComponent2 = (((element.getMinecraftObject().method_5578() + 1)) + "");
            index2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(instanceServiceComponent2);
            iterator3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(NameTagsModule.INSTANCE.resolveString(element.getMinecraftObject()));
            index = ((index2 + iterator3) + 27.0F);
        }
        iterator2 = itemList.iterator();
        while (iterator2.hasNext()) {
            element = ((InstanceServiceComponent2) iterator2.next());
            items = new Object[0];
            text = element.getMinecraftObject().method_5586();
            if (element.getMinecraftObject().method_5578() > 0) {
            } else {
            }
            instanceServiceComponent2 = (((element.getMinecraftObject().method_5578() + 1)) + "");
            index2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(instanceServiceComponent2);
            iterator3 = SFMServiceComponent.resolveFontRenderHelper().computeValue(NameTagsModule.INSTANCE.resolveString(element.getMinecraftObject()));
            if (class1293) {
            } else {
            }
            float factor = (this.computeValue() - ((1.0F - element.getEasingServiceComponent().getNumericValue()) * 10));
            index3 = 1.0F;
            if (element.getMinecraftObject().method_48557(200)) {
                index3 = (1.0F - (Math.sin(element.getMinecraftObject().method_5584()) * 0.5F));
            }
            CheckRenderHelper.executeAction(this, context.method_51448(), factor, (this.computeValue2() + iterable), 13.0F, 13.0F, element.getEasingServiceComponent().getNumericValue(), false);
            CheckRenderHelper.executeAction(this, context.method_51448(), (factor + 14.0F), (this.computeValue2() + iterable), (index2 + 6.0F), 13.0F, element.getEasingServiceComponent().getNumericValue(), false);
            CheckRenderHelper.executeAction(this, context.method_51448(), (factor + ((index2 + 21.0F) * element.getEasingServiceComponent().getNumericValue())), (this.computeValue2() + iterable), (iterator3 + 6.0F), 13.0F, element.getEasingServiceComponent().getNumericValue(), false);
            Color color = NewThemeRenderHelper.INSTANCE.getColor7();
            context.render(instanceServiceComponent2, (factor + 17.0F), ((this.computeValue2() + iterable) + 1.0F), PolygonShaderComponent.INSTANCE, Color.RED.resolveColor(color, (element.getEasingServiceComponent().getNumericValue() * index3)));
            this.render(context, NameTagsModule.INSTANCE.resolveString(element.getMinecraftObject()), (factor + ((index2 + 24.0F) * element.getEasingServiceComponent().getNumericValue())), ((this.computeValue2() + iterable) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (element.getEasingServiceComponent().getNumericValue() * index3)));
            context.method_51448().pushMatrix();
            context.method_51448().translate((factor + 2), ((this.computeValue2() + iterable) + 2));
            context.method_51448().scale(0.55F);
            context.method_52707(class_10799.field_56883, class_329.method_71644(element.getMinecraftObject().method_5579()), 0, 0, 18, 18, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (element.getEasingServiceComponent().getNumericValue() * index3)).getRGB());
            context.method_51448().popMatrix();
            iterable = (iterable + (14.0F * element.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction(index, (iterable - 2.0F));
    }

    private static boolean checkCondition(InstanceServiceComponent2 arg0) {
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
        INSTANCE = new PotionsWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
