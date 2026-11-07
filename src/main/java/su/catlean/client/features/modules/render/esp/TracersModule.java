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
        return ((TracersMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getFlat() {
        return ((Boolean) flatSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getOnlyOffscreen() {
        return ((Boolean) onlyOffscreenSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private Color getFriendColor() {
        return ((Color) friendColorSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getTeamColor() {
        return ((Boolean) teamColorSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    public void onRender2DEvent(Render2DEvent e) {
        if (this.getMode() == TracersMode.LINES) {
            return;
        }
        if (!(this.getFlat())) {
        }
        this.executeAction(42.0F);
        this.executeAction(40.0F);
        int index = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        int index2 = (SharedKt.getMc().method_22683().method_4502() / 2.0F);
        factorValue = this.computeValue(factorValue, SharedKt.getPlayer().method_36454(), 13.0F);
        Iterable iterable = ((Iterable) RunnableServiceComponent.INSTANCE.getList());
        int index3 = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
            if (!(Intrinsics.areEqual(player, SharedKt.getMc().player))) {
                if (INSTANCE.getOnlyOffscreen()) {
                    if (!(TextShaderComponent2.INSTANCE.getMinecraftObject().method_23093(player.method_5829()))) {
                        MatrixStack matrices = new MatrixStack();
                        matrices.method_22903();
                        matrices.method_46416(index, index2, 0.0F);
                        float factor = Math.min(90.0F, Math.max(SharedKt.getPlayer().method_36455(), easingServiceComponent.getNumericValue()));
                        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((Math.abs(factor) - 102))));
                        matrices.method_46416(index, index2, 0.0F);
                        double offset = PolygonShaderComponent.INSTANCE.computeValue(player.field_6014, player.getX(), TextShaderComponent2.INSTANCE.computeValue());
                        double offset2 = PolygonShaderComponent.INSTANCE.computeValue(player.field_5969, player.getZ(), TextShaderComponent2.INSTANCE.computeValue());
                        double offset3 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6014, SharedKt.getPlayer().getX(), TextShaderComponent2.INSTANCE.computeValue());
                        double offset4 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_5969, SharedKt.getPlayer().getZ(), TextShaderComponent2.INSTANCE.computeValue());
                        double offset5 = (class_3532.method_15338((Math.toDegrees(Math.atan2((offset2 - offset4), (offset - offset3))) - 90.0D)) - factorValue);
                        matrices.method_46416(index, index2, 0.0F);
                        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(offset5)));
                        matrices.method_46416(index, index2, 0.0F);
                        if (EntityHelper4.isFriend(((PlayerEntity) player))) {
                        } else {
                        }
                        Color color = NewThemeRenderHelper.INSTANCE.resolveColor((index3 * 30));
                        if (player.method_5781() != null) {
                            if (INSTANCE.getTeamColor()) {
                                color = new Color(player.method_22861());
                            }
                        }
                        INSTANCE.render(matrices, index, (index2 - easingServiceComponent2.getNumericValue()), 18.0F, color);
                        matrices.method_22909();
                    }
                }
            }
        }
    }

    public void render(MatrixStack matrices, float x, float y, float size, Color color) {
        Matrix4f matrix4f = matrices.method_23760().method_23761();
        PolygonShaderComponent.INSTANCE.executeAction(matrix4f, AtlasTextureServiceComponent.getMinecraftObject(), x, y, size, size, color, color, color, color, true, this.getMode().getOptionMode6().getNumericValue(), this.getMode().getOptionMode6().getNumericValue2(), this.getMode().getOptionMode6().getNumericValue3(), this.getMode().getOptionMode6().getNumericValue4());
    }

    public void onRender3DEvent(Render3DEvent e) {
        if (this.getMode() != TracersMode.LINES) {
            return;
        }
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            if (Intrinsics.areEqual(player, SharedKt.getPlayer())) {
            }
            Box box = TextShaderComponent2.INSTANCE.resolveMinecraftObject(player);
            Vec3d vec = new Vec3d(0.0D, 0.0D, 75.0D).method_1037(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19329())).method_1024(Math.toRadians(SharedKt.getMc().field_1773.method_19418().method_19330())).method_1019(SharedKt.getMc().field_1773.method_19418().method_71156());
            if (EntityHelper4.isFriend(((PlayerEntity) player))) {
            } else {
            }
            Color color = NewThemeRenderHelper.INSTANCE.resolveColor(30);
            if (player.method_5781() != null && this.getTeamColor()) {
                color = new Color(player.method_22861());
            }
            TextShaderComponent2.checkCondition(vec, box.method_1005(), color, null, true);
        }
    }

    private float computeValue(float arg0, float arg1, float arg2) {
        if (EventServiceComponent.INSTANCE.getNumericValue() > 5) {
        } else {
        }
        float factor = Math.clamp((0.016F * arg2), 0.0F, 1.0F);
        return (((1.0F - factor) * arg0) + (factor * arg1));
    }

    static {
        KProperty[] items = new KProperty[5];
        INSTANCE = new TracersModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", TracersMode.ARROWS_1);
        flatSetting = VisibleRenderHelper.registerSetting(INSTANCE, "flat", false);
        onlyOffscreenSetting = VisibleRenderHelper.registerSetting(INSTANCE, "only-off-screen", false);
        friendColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend", Color.GREEN);
        teamColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "team-colors", false);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
    }

}
