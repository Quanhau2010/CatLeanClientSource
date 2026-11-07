package su.catlean.client.features.modules.render.cosmetic;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_2824;
import net.minecraft.class_2824.class_5907;
import net.minecraft.class_290;
import net.minecraft.class_4587.class_4665;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.CriticalsModule;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.VecServiceComponent3;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;

public class HitFxModule extends Module {

    public static final HitFxModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl smokeSetting;
    private static final VisibleVisibleSettingPropertyImpl particlesSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 particleSetting;
    private static final RangeVisibleSettingPropertyImpl2 sizeSetting;
    private static final RangeVisibleSettingPropertyImpl durationSetting;
    private static final RangeVisibleSettingPropertyImpl countSetting;
    private static final RangeVisibleSettingPropertyImpl2 gravitySetting;
    private static final RangeVisibleSettingPropertyImpl2 velocityXZSetting;
    private static final RangeVisibleSettingPropertyImpl2 velocityYSetting;
    private static final List itemList;

    private HitFxModule() {
        super("hit-fx", SubCategoriesKt.getCosmeticCategory());
    }

    private boolean getSmoke() {
        return ((Boolean) smokeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private void setSmoke(boolean value) {
        smokeSetting.setValue(this, DELEGATED_PROPERTIES[0], Boolean.valueOf(value));
    }

    private boolean getParticles() {
        return ((Boolean) particlesSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void setParticles(boolean value) {
        particlesSetting.setValue(this, DELEGATED_PROPERTIES[1], Boolean.valueOf(value));
    }

    private HitFxParticleMode getParticle() {
        return ((HitFxParticleMode) particleSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private void setParticle(HitFxParticleMode value) {
        particleSetting.setValue(this, DELEGATED_PROPERTIES[2], value);
    }

    private float getSize() {
        return ((Number) sizeSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setSize(float value) {
        sizeSetting.setValue(this, DELEGATED_PROPERTIES[3], Float.valueOf(value));
    }

    private int getDuration() {
        return ((Number) durationSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setDuration(int value) {
        durationSetting.setValue(this, DELEGATED_PROPERTIES[4], Integer.valueOf(value));
    }

    private int getCount() {
        return ((Number) countSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private void setCount(int value) {
        countSetting.setValue(this, DELEGATED_PROPERTIES[5], Integer.valueOf(value));
    }

    private float getGravity() {
        return ((Number) gravitySetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void setGravity(float value) {
        gravitySetting.setValue(this, DELEGATED_PROPERTIES[6], Float.valueOf(value));
    }

    private float getVelocityXZ() {
        return ((Number) velocityXZSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private void setVelocityXZ(float value) {
        velocityXZSetting.setValue(this, DELEGATED_PROPERTIES[7], Float.valueOf(value));
    }

    private float getVelocityY() {
        return ((Number) velocityYSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void setVelocityY(float value) {
        velocityYSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private void onSendPacket(SendPacket arg0) {
        SharedKt.getMc().method_40000(this::onSendPacket2);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        List<BlockPos> list = Lists.newArrayList(((Iterable) itemList));
        int index = 4;
        int index2 = 0;
        int index3 = (list.size() * 2);
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        Iterable iterable = ((Iterable) list);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            VecServiceComponent3 vecServiceComponent3 = ((VecServiceComponent3) element);
            int index4 = RangesKt.coerceIn((vecServiceComponent3.getServiceComponent10().getNumericValue() / 40.0F), 0, 8);
            float factor = ((OptionMode6.SMOKE.getNumericValue3() - OptionMode6.SMOKE.getNumericValue()) / 3.0F);
            float factor2 = ((OptionMode6.SMOKE.getNumericValue4() - OptionMode6.SMOKE.getNumericValue2()) / 3.0F);
            float factor3 = (OptionMode6.SMOKE.getNumericValue() + ((index4 % 3) * factor));
            float factor4 = (OptionMode6.SMOKE.getNumericValue2() + ((index4 / 3) * factor2));
            long time = (vecServiceComponent3.getServiceComponent10().getNumericValue() / 450.0F);
            TextShaderComponent2.executeAction(AtlasTextureServiceComponent.getMinecraftObject(), vecServiceComponent3.getMinecraftObject(), vecServiceComponent3.getNumericValue(), vecServiceComponent3.getNumericValue2(), 0.0F, (1.0F + time), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor(10), 1.0F), false, formatRenderHelper, factor3, factor4, (factor3 + factor), (factor4 + factor2), true);
        }
        iterable = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), SharedKt.getMc().method_1522(), null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", iterable)));
        itemList.removeIf(this::checkCondition);
    }

    private static boolean isActive() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive2() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive3() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive4() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive5() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive6() {
        return INSTANCE.getParticles();
    }

    private static boolean isActive7() {
        return INSTANCE.getParticles();
    }

    private static void onSendPacket2(SendPacket arg0) {
        if (EventPacketHelper2.INSTANCE.resolveMinecraftObject(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2(), AuraModule.INSTANCE.getAttackRange()) == null) {
            EventPacketHelper2.INSTANCE.resolveMinecraftObject(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2(), AuraModule.INSTANCE.getAttackRange());
            Entity entity = CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket()));
            if (entity != null) {
                Box box = entity.method_5829();
                if (box != null) {
                } else {
                }
            } else {
            }
        }
        if (__UNDEF_KEY__ == null) {
            MoveFixServiceComponent moveFixServiceComponent = SequenceServiceComponent.resolveMoveFixServiceComponent(false);
            if (EventPacketHelper2.INSTANCE.resolveMinecraftObject(moveFixServiceComponent.getNumericValue(), moveFixServiceComponent.getNumericValue2(), AuraModule.INSTANCE.getAttackRange()) == null) {
                EventPacketHelper2.INSTANCE.resolveMinecraftObject(moveFixServiceComponent.getNumericValue(), moveFixServiceComponent.getNumericValue2(), AuraModule.INSTANCE.getAttackRange());
                if (CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket())) != null && CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket())).method_5829() != null) {
                } else {
                    CriticalsModule.INSTANCE.resolveMinecraftObject(((class_2824) arg0.getPacket())).method_5829().method_1005();
                }
            }
        }
        if (__UNDEF_KEY__ != null) {
            if (INSTANCE.getSmoke()) {
                itemList.add(new VecServiceComponent3(EventPacketHelper2.INSTANCE.computeValue(), EventPacketHelper2.INSTANCE.computeValue2()));
            }
            if (INSTANCE.getParticles()) {
                int index = INSTANCE.getCount();
                int index2 = 0;
                if (index2 < index) {
                    POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(INSTANCE.getParticle().getOptionMode6(), (Math.random() * 50.0F), INSTANCE.getSize(), INSTANCE.getDuration(), null, INSTANCE.getGravity(), 0.0F, false));
                }
            }
        } else {
            box.method_1005();
        }
    }

    private static boolean checkCondition(VecServiceComponent3 arg0) {
        return arg0.getServiceComponent10().checkCondition(360);
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[9];
        INSTANCE = new HitFxModule();
        smokeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "smoke", true);
        particlesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "particles", true);
        particleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "particle", HitFxParticleMode.HEART, null, this::isActive);
        sizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "size", 0.2F, RangesKt.rangeTo(0.01F, 0.5F), null, this::isActive2);
        durationSetting = VisibleRenderHelper.registerSetting(INSTANCE, "duration", 15, new IntRange(5, 60), null, this::isActive3);
        countSetting = VisibleRenderHelper.registerSetting(INSTANCE, "count", 15, new IntRange(5, 60), null, this::isActive4);
        gravitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "gravity", 0.03F, RangesKt.rangeTo(-0.15F, 0.15F), null, this::isActive5);
        velocityXZSetting = VisibleRenderHelper.registerSetting(INSTANCE, "horizontal-motion", 0.25F, RangesKt.rangeTo(0.01F, 2.0F), null, this::isActive6);
        velocityYSetting = VisibleRenderHelper.registerSetting(INSTANCE, "vertical-motion", 0.5F, RangesKt.rangeTo(0.01F, 2.0F), null, this::isActive7);
        itemList = new ArrayList();
    }

}
