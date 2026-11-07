package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityEntityHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class DamageParticlesModule extends Module {

    public static final DamageParticlesModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl9 color1Setting;
    private static final DefaultValueVisibleSettingPropertyImpl9 color2Setting;
    private static final RangeVisibleSettingPropertyImpl2 sizeSetting;
    private static final RangeVisibleSettingPropertyImpl ticksSetting;
    private static final HashMap hashMap;
    private static final ArrayList arrayList;
    private static final DecimalFormat decimalFormat;

    private DamageParticlesModule() {
        super("damage-particles", SubCategoriesKt.getCosmeticCategory());
    }

    private Color getColor1() {
        return (Color) color1Setting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getColor2() {
        return (Color) color2Setting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private float getSize() {
        return (Number) sizeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getTicks() {
        return (Number) ticksSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    public DecimalFormat getDecimalFormat() {
        return decimalFormat;
    }

    public void updateValue() {
        arrayList.clear();
        hashMap.clear();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            if (!(entity instanceof LivingEntity)) {
            }
            if ((Float) hashMap.getOrDefault(Integer.valueOf((LivingEntity) entity.method_5628()), Float.valueOf((LivingEntity) entity.method_6063())) != null) {
            } else {
            }
            float var15 = 20.0F;
            float var16 = ((LivingEntity) entity.method_6032() + (LivingEntity) entity.method_6067());
            if (var15 == var16) {
            }
            arrayList.add(new EntityEntityHelper(entity, (var16 - var15), ((LivingEntity) entity.getX() + RangeServiceComponent.a(-0.5D, 0.5D)), ((LivingEntity) entity.getY() + ((LivingEntity) entity.method_5829().method_17940() / 2.0F)), ((LivingEntity) entity.getZ() + RangeServiceComponent.a(-0.5D, 0.5D))));
        }
        arrayList.removeIf(this::checkCondition);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        Iterable var28 = (Iterable) arrayList;
        int var29 = 0;
        Iterator iterator = var28.iterator();
        while (iterator.hasNext()) {
            Object var31 = iterator.next();
            EntityEntityHelper var32 = (EntityEntityHelper) var31;
            int var33 = 0;
            int var34 = (INSTANCE.getTicks() / 2.0F);
            if (var32.getNumericValue() < var34) {
            } else {
            }
            float var35 = (1.0F - ((var32.getNumericValue() - var34) / var34));
            if (var32.getNumericValue() > 0.0F) {
            } else {
            }
            int var19 = 24;
            FontRenderHelper var20 = SFMServiceComponent.resolveFontRenderHelper8();
            int var21 = 1;
            float var22 = 0.0F;
            float var23 = 0.0F;
            Color var24 = INSTANCE.getColor1().resolveColor(INSTANCE.getColor2());
            PolygonShaderComponent var25 = PolygonShaderComponent.INSTANCE;
            Vec3d vec = new Vec3d(var32.getNumericValue(), var32.getNumericValue2(), var32.getNumericValue3());
            TextShaderComponent2.executeAction(decimalFormat.format(Float.valueOf(var32.getNumericValue())), vec);
        }
    }

    private static boolean checkCondition(EntityEntityHelper arg0) {
        int var7 = arg0.getNumericValue();
        arg0.updateValue((var7 + 1));
        if (var6 != null) {
            if (var7 >= INSTANCE.getTicks()) {
            }
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var32 = new KProperty[4];
        INSTANCE = new DamageParticlesModule();
        color1Setting = VisibleRenderHelper.registerSetting(INSTANCE, "heal-color", Color.GREEN);
        color2Setting = VisibleRenderHelper.registerSetting(INSTANCE, "damage-color", Color.RED);
        sizeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "size", 0.5F, RangesKt.rangeTo(0.1F, 3.0F));
        ticksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ticks", 35, new IntRange(5, 60));
        hashMap = new HashMap();
        arrayList = new ArrayList();
        decimalFormat = new DecimalFormat("#.#");
    }

}
