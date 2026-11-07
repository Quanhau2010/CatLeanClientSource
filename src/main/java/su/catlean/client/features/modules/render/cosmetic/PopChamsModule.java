package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_2663;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4588;
import net.minecraft.class_591;
import net.minecraft.class_757;
import net.minecraft.class_8685;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.esp.LogoutSpotsModule;
import su.catlean.client.features.modules.render.esp.PlayerEspRenderMode;
import su.catlean.client.services.client.ModelServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.PolygonRenderHelper2;
import su.catlean.client.services.render.StackRenderHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class PopChamsModule extends Module {

    public static final PopChamsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 modeSetting;
    private static final RangeVisibleSettingPropertyImpl alphaSetting;
    private static final RangeVisibleSettingPropertyImpl2 ySpeedSetting;
    private static final RangeVisibleSettingPropertyImpl2 aSpeedSetting;
    private static final CopyOnWriteArrayList copyOnWriteArrayList;

    private PopChamsModule() {
        super("pop-chams", SubCategoriesKt.getCosmeticCategory());
    }

    private PopChamsMode getMode() {
        return (PopChamsMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private int getAlpha() {
        return (Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private float getYSpeed() {
        return (Number) ySpeedSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private float getASpeed() {
        return (Number) aSpeedSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        copyOnWriteArrayList.removeIf(this::checkCondition);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getMode() == PopChamsMode.DEFAULT) {
            int var26 = 4;
            int var27 = 0;
            int var28 = (copyOnWriteArrayList.size() * 72);
            VertexFormat var29 = class_290.field_1576;
            FormatRenderHelper var31 = new FormatRenderHelper();
            Iterable var32 = (Iterable) copyOnWriteArrayList;
            int var33 = 0;
            Iterator iterator = var32.iterator();
            while (iterator.hasNext()) {
                Object var35 = iterator.next();
                ModelServiceComponent var36 = (ModelServiceComponent) var35;
                int var37 = 0;
                StackRenderHelper3.INSTANCE.render(arg0.getStack(), var36.getMinecraftObject(), var36.getMinecraftObject(), var36.resolveMinecraftObject(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), var36.computeValue()), PlayerEspRenderMode.FILL);
            }
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, arg0.getStack().method_23760().method_23761());
            int var25 = 1;
            var26 = (copyOnWriteArrayList.size() * 144);
            var27 = class_290.field_1576;
            var31 = new FormatRenderHelper();
            var32 = (Iterable) copyOnWriteArrayList;
            var33 = 0;
            iterator = var32.iterator();
            while (iterator.hasNext()) {
                var35 = iterator.next();
                var36 = (ModelServiceComponent) var35;
                var37 = 0;
                StackRenderHelper3.INSTANCE.render(arg0.getStack(), var36.getMinecraftObject(), var36.getMinecraftObject(), var36.resolveMinecraftObject(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (var36.computeValue() * 2.0F)), PlayerEspRenderMode.OUTLINE);
            }
            FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, arg0.getStack().method_23760().method_23761());
        } else {
            var31 = (Iterable) copyOnWriteArrayList;
            var32 = 0;
            var33 = var31.iterator();
            while (var33.hasNext()) {
                iterator = var33.next();
                var35 = (ModelServiceComponent) iterator;
                var36 = 0;
                INSTANCE.render(arg0.getStack());
            }
        }
    }

    public void onReceivePacket(ReceivePacket event) {
        if (SharedKt.getMc().method_1560() == null || SharedKt.getMc().player == null || SharedKt.getMc().field_1773.method_19418() == null || SharedKt.getMc().world == null || SharedKt.getPlayer().field_6012 < 10) {
            return;
        }
        Packet var21 = event.getPacket();
        Entity entity = (class_2663) var21.method_11469((World) SharedKt.getWorld());
        if (entity instanceof PlayerEntity) {
        } else {
        }
        if (null == null) {
            return;
        }
        PlayerEntity player = (PlayerEntity) entity;
        if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
            return;
        }
        class_591 var23 = (class_591) (class_1007) SharedKt.getMc().method_1561().method_3953(player).method_4038();
        class_10017 var25 = SharedKt.getMc().method_1561().method_3953(player).method_62425(player, TextShaderComponent2.INSTANCE.computeValue());
        entity = (class_10055) var25;
        var25 = new class_10055();
        var25.field_53536 = entity.field_53536;
        var25.field_53537 = entity.field_53537;
        var25.field_53538 = entity.field_53538;
        var25.field_53325 = entity.field_53325;
        var25.field_53326 = entity.field_53326;
        var25.field_53327 = entity.field_53327;
        var25.field_53446 = entity.field_53446;
        var25.field_53447 = entity.field_53447;
        var25.field_53448 = entity.field_53448;
        var25.field_63604 = entity.field_63604;
        var25.field_53521 = entity.field_53521;
        var25.field_53328 = entity.field_53328;
        var25.field_53451 = entity.field_53451;
        var25.field_53405 = entity.field_53405;
        var25.field_53450 = entity.field_53450;
        var23.method_62110(entity);
        Vec3d vec = this.resolveMinecraftObject(player);
        class_2960 var27 = (AbstractClientPlayerEntity) player.method_52814().comp_1626().comp_3627();
        copyOnWriteArrayList.add(new ModelServiceComponent(vec, this.getAlpha()));
    }

    private void render(MatrixStack arg0, ModelServiceComponent arg1) {
        GpuTextureView var31 = SharedKt.getMc().method_1531().method_4619(arg1.getMinecraftObject()).method_71659();
        int var27 = 4;
        int var28 = 0;
        int var29 = 256;
        VertexFormat var30 = class_290.field_1575;
        FormatRenderHelper var32 = new FormatRenderHelper();
        PolygonRenderHelper2 var33 = new PolygonRenderHelper2(PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), arg1.computeValue()));
        arg0.method_22903();
        Vec3d vec = arg1.resolveMinecraftObject();
        Vec3d vec2 = SharedKt.getMc().method_1561().field_4686.method_71156();
        double var36 = (vec.field_1352 - vec2.method_10216());
        double var38 = (vec.field_1351 - vec2.method_10214());
        double var40 = (vec.field_1350 - vec2.method_10215());
        arg0.method_46416();
        arg0.method_22905(arg1.getMinecraftObject().field_53453, arg1.getMinecraftObject().field_53453, arg1.getMinecraftObject().field_53453);
        LogoutSpotsModule.INSTANCE.render(arg1.getMinecraftObject(), arg0, arg1.getMinecraftObject().field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
        arg0.method_46416(0.0F, -1.501F, 0.0F);
        arg1.getMinecraftObject().method_62110(arg1.getMinecraftObject());
        arg1.getMinecraftObject().method_62100(arg0, (class_4588) var33, 15728880, 0, NewThemeRenderHelper.INSTANCE.getColor2().getRGB());
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline16(), null, null, new MatrixStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0")));
        arg0.method_22909();
    }

    private static boolean checkCondition(ModelServiceComponent arg0) {
        return arg0.checkCondition(INSTANCE.getASpeed(), INSTANCE.getYSpeed());
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var31 = new KProperty[4];
        INSTANCE = new PopChamsModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", PopChamsMode.DEFAULT);
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-alpha", 255, new IntRange(0, 255));
        ySpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y-speed", 0.1F, RangesKt.rangeTo(-1.0F, 1.0F));
        aSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha-speed", 5.0F, RangesKt.rangeTo(1.0F, 20.0F));
        copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

}
