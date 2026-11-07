package su.catlean.client.features.modules.render.esp;

import java.awt.Color;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_1041;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4604;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.EventServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.types.OptionMode6;
import su.catlean.client.types.TpYawSmootherMode;

public class TracersModule extends Module {

    public static final TracersModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final VisibleVisibleSettingPropertyImpl flatSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyOffscreenSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 friendColorSetting;
    private static final VisibleVisibleSettingPropertyImpl teamColorSetting;
    private static float factorValue;
    private static EasingServiceComponent easingServiceComponent;
    private static EasingServiceComponent easingServiceComponent2;

    private TracersModule() {
        super("tracers", SubCategoriesKt.getEspCategory());
    }

    public TracersMode getMode() {
        return (TracersMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getFlat() {
        return (Boolean) flatSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getOnlyOffscreen() {
        return (Boolean) onlyOffscreenSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private Color getFriendColor() {
        return (Color) friendColorSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getTeamColor() {
        return (Boolean) teamColorSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    public void onRender2DEvent(Render2DEvent e) {
        if (this.getMode() == TracersMode.LINES) {
            return;
        }
        if (!(this.getFlat())) {
        }
        90.0F.executeAction(42.0F);
        150.0F.executeAction(40.0F);
        int var35 = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        int var36 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
        factorValue = this.computeValue(factorValue, SharedKt.getPlayer().method_36454(), 13.0F);
        Iterable var37 = (Iterable) RunnableServiceComponent.INSTANCE.getList();
        int var38 = 0;
        int var39 = 0;
        Iterator iterator = var37.iterator();
        while (iterator.hasNext()) {
            Object var41 = iterator.next();
            int var42 = var39;
            if (var42 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var41;
            int var44 = var42;
            int var45 = 0;
            if (!(Intrinsics.areEqual(player, SharedKt.getMc().player))) {
                if (INSTANCE.getOnlyOffscreen()) {
                    if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093(player.method_5829()))) {
                    }
                    MatrixStack matrices = new MatrixStack();
                    matrices.method_22903();
                    matrices.method_46416(0.0F);
                    float var47 = Math.min(90.0F, Math.max(SharedKt.getPlayer().method_36455(), easingServiceComponent.getNumericValue()));
                    matrices.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((Math.abs() - 102)));
                    matrices.method_46416(0.0F);
                    double var48 = PolygonShaderComponent.INSTANCE.computeValue(player.field_6014, player.getX(), TextShaderComponent2.INSTANCE.computeValue());
                    double var50 = PolygonShaderComponent.INSTANCE.computeValue(player.field_5969, player.getZ(), TextShaderComponent2.INSTANCE.computeValue());
                    double var52 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6014, SharedKt.getPlayer().getX(), TextShaderComponent2.INSTANCE.computeValue());
                    double var54 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_5969, SharedKt.getPlayer().getZ(), TextShaderComponent2.INSTANCE.computeValue());
                    double var56 = (class_3532.method_15338((Math.toDegrees(Math.atan2((var50 - var54), (var48 - var52))) - 90.0D)) - factorValue);
                    matrices.method_46416(0.0F);
                    matrices.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees());
                    matrices.method_46416(0.0F);
                    if (EntityHelper4.isFriend((PlayerEntity) player)) {
                    } else {
                    }
                    Color var57 = NewThemeRenderHelper.INSTANCE.resolveColor((var44 * 30));
                    if (player.method_5781() != null) {
                        if (INSTANCE.getTeamColor()) {
                            var57 = new Color(player.method_22861());
                        }
                    }
                    INSTANCE.render(matrices, (var36 - easingServiceComponent2.getNumericValue()), 18.0F);
                    matrices.method_22909();
                }
            }
        }
    }

    public void render(MatrixStack matrices, float x, float y, float size, Color color) {
        Matrix4f var16 = matrices.method_23760().method_23761();
        PolygonShaderComponent.INSTANCE.executeAction(AtlasTextureServiceComponent.getMinecraftObject(), x, y, size, size, color, color, color, color, 1, this.getMode().getOptionMode6().getNumericValue(), this.getMode().getOptionMode6().getNumericValue2(), this.getMode().getOptionMode6().getNumericValue3(), this.getMode().getOptionMode6().getNumericValue4());
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (this.getMode() != TracersMode.LINES) {
            return;
        }
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        if (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
            }
            Box var28 = TextShaderComponent2.INSTANCE.resolveMinecraftObject(player);
            Vec3d vec = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
            if (EntityHelper4.isFriend((PlayerEntity) player)) {
            } else {
            }
            Color var30 = NewThemeRenderHelper.INSTANCE.resolveColor(30);
            if (player.method_5781() != null && this.getTeamColor()) {
                var30 = new Color(player.method_22861());
            }
            TextShaderComponent2.checkCondition(vec, var28.method_1005());
        }
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float var6 = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - var6) * arg0) + (var6 * arg1));
    }

    static {
        KProperty[] var44 = new KProperty[5];
        INSTANCE = new TracersModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", TracersMode.ARROWS_1);
        flatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "flat");
        onlyOffscreenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-off-screen");
        friendColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend", Color.GREEN);
        teamColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "team-colors");
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
    }

}
