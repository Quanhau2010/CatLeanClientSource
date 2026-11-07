package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Collection;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import net.minecraft.class_1893;
import net.minecraft.class_408;
import net.minecraft.class_7833;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.joml.Matrix3x2fStack;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.movement.basic.ElytraRecastModule;
import su.catlean.client.features.modules.movement.rage.ElytraPlusMode;
import su.catlean.client.features.modules.movement.rage.ElytraPlusModule;
import su.catlean.client.features.modules.render.esp.TracersModule;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.StackServiceComponent3;
import su.catlean.client.services.network.ElytraDurabilityPacketHelper;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class FlightWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final FlightWidgetCheckRenderHelperImpl INSTANCE;
    private static final ArrayDeque arrayDeque;
    private static final EasingServiceComponent easingServiceComponent;

    private FlightWidgetCheckRenderHelperImpl() {
        super("flight-widget");
    }

    public void render(DrawContext context) {
        if (SharedKt.getPlayer().isFallFlying()) {
        }
        if (ElytraRecastModule.INSTANCE.getEnabled() && !(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            } else {
            }
        }
        this.executeAction(0.0F);
        if (easingServiceComponent.getNumericValue() <= 0.0F) {
            return;
        }
        context.method_51448().pushMatrix();
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        context.method_51448().scale(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        this.executeAction(context.method_51448(), this.computeValue(), this.computeValue2(), 135.0F, 57.0F, 1.0F, false);
        this.executeAction(context.method_51448(), (this.computeValue() + 2), (this.computeValue2() + 2), 53.0F, 53.0F, 0.6F, false);
        this.executeAction(context.method_51448(), (this.computeValue() + 57), (this.computeValue2() + 2), 8.0F, 53.0F, 0.6F, false);
        float factor = (this.computeValue() + 27.5F);
        float factor2 = (this.computeValue2() + 27.5F);
        float factor3 = (SharedKt.getPlayer().method_36454() + 90.0F);
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        matrices.method_46416((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F), 0.0F);
        matrices.method_22905(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), 0.0F);
        matrices.method_46416((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F), 0.0F);
        matrices.method_46416((factor + 1.0F), (factor2 + 1.0F), 0.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(factor3)));
        matrices.method_46416((factor - 1.0F), (factor2 - 1.0F), 0.0F);
        TracersModule.INSTANCE.render(matrices, (factor + 1.0F), factor2, 15.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0));
        matrices.method_22909();
        float factor4 = (((SharedKt.getPlayer().method_36455() / 90.0F) * 26.5F) + 26.5F);
        int index = 2;
        int index2 = 0;
        Item item = Items.FIREWORK_ROCKET;
        int index3 = ItemPacketHelper.computeValue(item, index2, index);
        index = 2;
        index2 = 0;
        item = Items.ELYTRA;
        int index4 = ItemPacketHelper.computeValue(item, index2, index);
        int index5 = 0;
        float factor5 = 0.0F;
        float factor6 = (((EventPacketHelper2.INSTANCE.getNumericValue() * 72.0F) * 10.0F) / 10.0F);
        double offset = ((((SharedKt.getPlayer().getY() - SharedKt.getPlayer().field_6036) * 72.0F) * 10.0F) / 10.0F);
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        if (stack.method_31574(Items.ELYTRA) && !(((Collection) arrayDeque).isEmpty())) {
            int index6 = StackServiceComponent3.computeValue(stack, class_1893.field_9119);
            index5 = (stack.method_7936() - stack.method_7919());
            factor5 = (index5 * CollectionsKt.averageOfFloat(((Iterable) arrayDeque)));
            factor5 = ((factor5 * 10) / 10.0F);
            if (index6 > 0) {
                factor5 = (factor5 * (index6 - 1));
            }
        }
        this.render(context, "X", (this.computeValue() + 25.5F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "z", (this.computeValue() + 4.0F), (this.computeValue2() + 22.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "x", (this.computeValue() + 25.5F), (this.computeValue2() + 44.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "Z", (this.computeValue() + 49.0F), (this.computeValue2() + 22.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Fireworks: " + index3), (this.computeValue() + 67.0F), this.computeValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Durability: " + index5), (this.computeValue() + 67.0F), (this.computeValue2() + 9.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Res (km): " + factor5), (this.computeValue() + 67.0F), (this.computeValue2() + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Elytras: " + index4), (this.computeValue() + 67.0F), (this.computeValue2() + 27.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("XZ Speed: " + factor6), (this.computeValue() + 67.0F), (this.computeValue2() + 36.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Y Speed: " + offset), (this.computeValue() + 67.0F), (this.computeValue2() + 45.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (ElytraPlusModule.INSTANCE.getEnabled() && ElytraPlusModule.INSTANCE.getMode() == ElytraPlusMode.INFINITE) {
            index6 = ElytraDurabilityPacketHelper.INSTANCE.getNumericValue2();
            int index7 = (((index6 / 90.0F) * 26.5F) + 26.5F);
            Color[] items = new Color[1];
            items[0] = Color.RED;
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.computeValue() + 57.0F), (this.computeValue2() + index7), 8.0F, 1.0F, items);
        }
        index6 = new Color[1];
        index6[0] = new Color(1157627903, true);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.computeValue() + 57.0F), (this.computeValue2() + factor4), 8.0F, 1.0F, index6);
        context.method_51448().popMatrix();
        this.executeAction(120.0F, 55.0F);
    }

    public void updateValue(long arg0) {
        if (arrayDeque.size() >= 400) {
            arrayDeque.removeFirst();
        }
        arrayDeque.add(Float.valueOf((EventPacketHelper2.INSTANCE.getNumericValue() * 20.0F)));
    }

    static {
        INSTANCE = new FlightWidgetCheckRenderHelperImpl();
        arrayDeque = new ArrayDeque(400);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
