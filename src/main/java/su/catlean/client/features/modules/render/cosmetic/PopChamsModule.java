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
        return ((PopChamsMode) modeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private int getAlpha() {
        return ((Number) alphaSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private float getYSpeed() {
        return ((Number) ySpeedSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private float getASpeed() {
        return ((Number) aSpeedSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        copyOnWriteArrayList.removeIf(this::checkCondition);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getMode() == PopChamsMode.DEFAULT) {
            int index = 4;
            int index2 = 0;
            int index3 = (copyOnWriteArrayList.size() * 72);
            VertexFormat vertexFormat = class_290.field_1576;
            FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
            Iterable iterable = ((Iterable) copyOnWriteArrayList);
            int index4 = 0;
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                ModelServiceComponent modelServiceComponent = ((ModelServiceComponent) element);
                StackRenderHelper3.INSTANCE.render(arg0.getStack(), modelServiceComponent.getMinecraftObject(), modelServiceComponent.getMinecraftObject(), modelServiceComponent.resolveMinecraftObject(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), modelServiceComponent.computeValue()), PlayerEspRenderMode.FILL, formatRenderHelper);
            }
            FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, arg0.getStack().method_23760().method_23761());
            int index5 = 1;
            index = (copyOnWriteArrayList.size() * 144);
            index2 = class_290.field_1576;
            formatRenderHelper = new FormatRenderHelper(index2, index, index5);
            iterable = ((Iterable) copyOnWriteArrayList);
            index4 = 0;
            iterator = iterable.iterator();
            while (iterator.hasNext()) {
                element = iterator.next();
                modelServiceComponent = ((ModelServiceComponent) element);
                StackRenderHelper3.INSTANCE.render(arg0.getStack(), modelServiceComponent.getMinecraftObject(), modelServiceComponent.getMinecraftObject(), modelServiceComponent.resolveMinecraftObject(), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), (modelServiceComponent.computeValue() * 2.0F)), PlayerEspRenderMode.OUTLINE, formatRenderHelper);
            }
            FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline25(), null, null, arg0.getStack().method_23760().method_23761());
        } else {
            formatRenderHelper = ((Iterable) copyOnWriteArrayList);
            iterable = 0;
            index4 = formatRenderHelper.iterator();
            while (index4.hasNext()) {
                iterator = index4.next();
                element = ((ModelServiceComponent) iterator);
                modelServiceComponent = 0;
                INSTANCE.render(arg0.getStack(), element);
            }
        }
    }

    public void onReceivePacket(ReceivePacket event) {
        if (SharedKt.getMc().method_1560() == null || SharedKt.getMc().player == null || SharedKt.getMc().field_1773.method_19418() == null || SharedKt.getMc().world == null || SharedKt.getPlayer().field_6012 < 10) {
            return;
        }
        Packet packet = event.getPacket();
        Entity entity = ((class_2663) packet).method_11469(((World) SharedKt.getWorld()));
        if (entity instanceof PlayerEntity) {
        } else {
        }
        if (null == null) {
            return;
        }
        PlayerEntity player = ((PlayerEntity) entity);
        if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
            return;
        }
        class_591 class591 = ((class_591) ((class_1007) SharedKt.getMc().method_1561().method_3953(player)).method_4038());
        class_10017 class10017 = SharedKt.getMc().method_1561().method_3953(player).method_62425(player, TextShaderComponent2.INSTANCE.computeValue());
        entity = ((class_10055) class10017);
        class10017 = new class_10055();
        class10017.field_53536 = entity.field_53536;
        class10017.field_53537 = entity.field_53537;
        class10017.field_53538 = entity.field_53538;
        class10017.field_53325 = entity.field_53325;
        class10017.field_53326 = entity.field_53326;
        class10017.field_53327 = entity.field_53327;
        class10017.field_53446 = entity.field_53446;
        class10017.field_53447 = entity.field_53447;
        class10017.field_53448 = entity.field_53448;
        class10017.field_63604 = entity.field_63604;
        class10017.field_53521 = entity.field_53521;
        class10017.field_53328 = entity.field_53328;
        class10017.field_53451 = entity.field_53451;
        class10017.field_53405 = entity.field_53405;
        class10017.field_53450 = entity.field_53450;
        class591.method_62110(entity);
        Vec3d vec = this.resolveMinecraftObject(player);
        class_2960 class2960 = ((AbstractClientPlayerEntity) player).method_52814().comp_1626().comp_3627();
        copyOnWriteArrayList.add(new ModelServiceComponent(class591, class10017, vec, class2960, this.getAlpha()));
    }

    private void render(MatrixStack arg0, ModelServiceComponent arg1) {
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(arg1.getMinecraftObject()).method_71659();
        int index = 4;
        int index2 = 0;
        int index3 = 256;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        PolygonRenderHelper2 polygonRenderHelper2 = new PolygonRenderHelper2(formatRenderHelper, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), arg1.computeValue()));
        arg0.method_22903();
        Vec3d vec = arg1.resolveMinecraftObject();
        Vec3d vec2 = SharedKt.getMc().method_1561().field_4686.method_71156();
        double offset = (vec.field_1352 - vec2.method_10216());
        double offset2 = (vec.field_1351 - vec2.method_10214());
        double offset3 = (vec.field_1350 - vec2.method_10215());
        arg0.method_46416(offset, offset2, offset3);
        arg0.method_22905(arg1.getMinecraftObject().field_53453, arg1.getMinecraftObject().field_53453, arg1.getMinecraftObject().field_53453);
        LogoutSpotsModule.INSTANCE.render(arg1.getMinecraftObject(), arg0, arg1.getMinecraftObject().field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
        arg0.method_46416(0.0F, -1.501F, 0.0F);
        arg1.getMinecraftObject().method_62110(arg1.getMinecraftObject());
        arg1.getMinecraftObject().method_62100(arg0, ((class_4588) polygonRenderHelper2), 15728880, 0, NewThemeRenderHelper.INSTANCE.getColor2().getRGB());
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline16(), null, null, new MatrixStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
        arg0.method_22909();
    }

    private static boolean checkCondition(ModelServiceComponent arg0) {
        return arg0.checkCondition(INSTANCE.getASpeed(), INSTANCE.getYSpeed());
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new PopChamsModule();
        modeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "mode", PopChamsMode.DEFAULT);
        alphaSetting = VisibleRenderHelper.registerSetting(INSTANCE, "start-alpha", 255, new IntRange(0, 255));
        ySpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "y-speed", 0.1F, RangesKt.rangeTo(-1.0F, 1.0F));
        aSpeedSetting = VisibleRenderHelper.registerSetting(INSTANCE, "alpha-speed", 5.0F, RangesKt.rangeTo(1.0F, 20.0F));
        copyOnWriteArrayList = new CopyOnWriteArrayList();
    }

}
