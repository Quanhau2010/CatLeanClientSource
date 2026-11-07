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
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 137466198657546L);
        long var8 = (0L ^ 50910300018319L);
        long var10 = (0L ^ 116354511866655L);
        long var12 = (0L ^ 81581919584095L);
        long var14 = (0L ^ 17946477735558L);
        long var16 = (0L ^ 29635521244215L);
        long var18 = (0L ^ 109580710346244L);
        long var20 = (0L ^ 655743806298L);
        long var22 = (0L ^ 122621818626690L);
        long var24 = (0L ^ 128377113661390L);
        long var26 = ((0L ^ 100947255473036L) >>> 32);
        long var27 = (((0L ^ 100947255473036L) << 32) >>> 40);
        long var28 = (((0L ^ 100947255473036L) << 56) >>> 56);
        long var29 = (0L ^ 23238624456863L);
        long var31 = (0L ^ 30591967126976L);
        if (SharedKt.getPlayer().isFallFlying()) {
            if (0L > 0L) {
                if (!(var37)) {
                }
            }
            if (0L > 0L) {
            }
            if (ElytraRecastModule.INSTANCE.getEnabled() && !(SharedKt.getMc().currentScreen instanceof class_408)) {
            }
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            }
        } else {
        }
        1.0F.executeAction(0.0F);
        if (0L > 0L) {
            if (easingServiceComponent.getNumericValue() <= 0.0F) {
                return;
            }
            context.method_51448().pushMatrix();
            context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
            context.method_51448().scale(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
            context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
            this.executeAction(context.method_51448(), this.computeValue(), this.computeValue2(), 135.0F, 57.0F, 1.0F, 0);
            this.executeAction(context.method_51448(), (this.computeValue() + 2), (this.computeValue2() + 2), 53.0F, 53.0F, 0.6F, 0);
            this.executeAction(context.method_51448(), (this.computeValue() + 57), (this.computeValue2() + 2), 8.0F, 53.0F, 0.6F, 0);
        }
        float var38 = (this.computeValue() + 27.5F);
        float var39 = (this.computeValue2() + 27.5F);
        float var40 = (SharedKt.getPlayer().method_36454() + 90.0F);
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        matrices.method_46416((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F), 0.0F);
        matrices.method_22905(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), 0.0F);
        matrices.method_46416((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F), 0.0F);
        matrices.method_46416((var38 + 1.0F), (var39 + 1.0F), 0.0F);
        matrices.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees());
        matrices.method_46416((var38 - 1.0F), (var39 - 1.0F), 0.0F);
        TracersModule.INSTANCE.render(matrices, (var38 + 1.0F), 15.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0));
        matrices.method_22909();
        float var42 = (((SharedKt.getPlayer().method_36455() / 90.0F) * 26.5F) + 26.5F);
        int var34 = 2;
        int var35 = 0;
        Item var36 = Items.FIREWORK_ROCKET;
        int var43 = ItemPacketHelper.computeValue();
        var34 = 2;
        var35 = 0;
        var36 = Items.ELYTRA;
        int var44 = ItemPacketHelper.computeValue();
        int var45 = 0;
        float var46 = 0.0F;
        float var47 = (((EventPacketHelper2.INSTANCE.getNumericValue() * 72.0F) * 10.0F) / 10.0F);
        double var48 = ((((SharedKt.getPlayer().getY() - SharedKt.getPlayer().field_6036) * 72.0F) * 10.0F) / 10.0F);
        ItemStack stack = SharedKt.getPlayer().getEquippedStack(EquipmentSlot.CHEST);
        if (stack.method_31574(Items.ELYTRA) && !((Collection) arrayDeque.isEmpty())) {
            int var50 = StackServiceComponent3.computeValue(stack, class_1893.field_9119);
            var45 = (stack.method_7936() - stack.method_7919());
            var46 = (var45 * CollectionsKt.averageOfFloat((Iterable) arrayDeque));
            var46 = ((var46 * 10) / 10.0F);
            if (var50 > 0) {
                var46 = (var46 * (var50 - 1));
            }
        }
        this.render(context, "X", (this.computeValue() + 25.5F), (this.computeValue2() + 1.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "z", (this.computeValue() + 4.0F), (this.computeValue2() + 22.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "x", (this.computeValue() + 25.5F), (this.computeValue2() + 44.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, "Z", (this.computeValue() + 49.0F), (this.computeValue2() + 22.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Fireworks: " + var43), (this.computeValue() + 67.0F), this.computeValue2(), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Durability: " + var45), (this.computeValue() + 67.0F), (this.computeValue2() + 9.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Res (km): " + var46), (this.computeValue() + 67.0F), (this.computeValue2() + 18.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Elytras: " + var44), (this.computeValue() + 67.0F), (this.computeValue2() + 27.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("XZ Speed: " + var47), (this.computeValue() + 67.0F), (this.computeValue2() + 36.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        this.render(context, ("Y Speed: " + var48), (this.computeValue() + 67.0F), (this.computeValue2() + 45.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        if (ElytraPlusModule.INSTANCE.getEnabled() && ElytraPlusModule.INSTANCE.getMode() == ElytraPlusMode.INFINITE) {
            var50 = ElytraDurabilityPacketHelper.INSTANCE.getNumericValue2();
            float var51 = (((var50 / 90.0F) * 26.5F) + 26.5F);
            Color[] var52 = new Color[1];
            var52[0] = Color.RED;
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.computeValue() + 57.0F), (this.computeValue2() + var51), 8.0F, 1.0F);
        }
        var50 = new Color[1];
        var50[0] = new Color(1157627903, 1);
        PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (this.computeValue() + 57.0F), (this.computeValue2() + var42), 8.0F, 1.0F);
        context.method_51448().popMatrix();
        this.executeAction(120.0F, 55.0F);
    }

    public void updateValue(long arg0) {
        if (!(var3)) {
            if (arrayDeque.size() >= 400) {
                arrayDeque.removeFirst();
            }
        }
        arrayDeque.add(Float.valueOf((EventPacketHelper2.INSTANCE.getNumericValue() * 20.0F)));
    }

    static {
        INSTANCE = new FlightWidgetCheckRenderHelperImpl();
        arrayDeque = new ArrayDeque(400);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
