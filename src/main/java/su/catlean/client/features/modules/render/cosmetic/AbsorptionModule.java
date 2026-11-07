package su.catlean.client.features.modules.render.cosmetic;

import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.ParticlesServiceComponent;
import su.catlean.client.services.client.ServiceComponent96;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.RenderHelper4;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;
import su.catlean.client.types.mappings.ParticlesLmodeModeWhenMappings2;

public class AbsorptionModule extends Module {

    public static final AbsorptionModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 lmodeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final ThreadLocalRandom threadLocalRandom;
    private static final List itemList;

    private AbsorptionModule() {
        super("absorption", SubCategoriesKt.getCosmeticCategory());
    }

    private ParticlesLmodeMode getLmode() {
        return ((ParticlesLmodeMode) lmodeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ParticlesServiceComponent particlesServiceComponent = ((ParticlesServiceComponent) element);
            Iterator iterator2 = particlesServiceComponent.getList().iterator();
            while (iterator2.hasNext()) {
                ServiceComponent96 serviceComponent96 = ((ServiceComponent96) iterator2.next());
                int index = serviceComponent96.getNumericValue2();
                serviceComponent96.updateValue((index + 1));
                serviceComponent96.updateValue2(serviceComponent96.getNumericValue());
                serviceComponent96.updateValue((serviceComponent96.getNumericValue() + serviceComponent96.getNumericValue7()));
                serviceComponent96.updateValue5(serviceComponent96.getNumericValue5());
                if (__UNDEF_KEY__ == null) {
                    if (serviceComponent96.isActive()) {
                        serviceComponent96.updateValue4((serviceComponent96.getNumericValue5() + 0.2F));
                        if (serviceComponent96.getNumericValue5() >= 1.0F) {
                            serviceComponent96.updateValue4(1.0F);
                            if (__UNDEF_KEY__ == null) {
                                if (threadLocalRandom.nextInt(1000) < 5) {
                                    serviceComponent96.updateValue(false);
                                    if (__UNDEF_KEY__ != null) {
                                        serviceComponent96.updateValue4((serviceComponent96.getNumericValue5() - 0.2F));
                                        if (__UNDEF_KEY__ == null && __UNDEF_KEY__ == null) {
                                            if (serviceComponent96.getNumericValue5() <= 0.0F) {
                                                iterator2.remove();
                                            }
                                            if (__UNDEF_KEY__ == null) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                serviceComponent96.updateValue(false);
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        if (SharedKt.getMc().world != null) {
            if (__UNDEF_KEY__ != null || SharedKt.getMc().world.getPlayers() == null) {
                return;
            }
        }
        List list = SharedKt.getMc().world.getPlayers();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                    }
                    float factor = RangesKt.coerceIn((player.method_6067() / 16.0F), 0.0F, 1.0F);
                    int index = (60 * factor);
                    Iterable iterable = ((Iterable) itemList);
                    int index2 = 0;
                    Iterator iterator2 = iterable.iterator();
                    while (iterator2.hasNext()) {
                        Object element = iterator2.next();
                        ParticlesServiceComponent particlesServiceComponent = ((ParticlesServiceComponent) element);
                        int index3 = 0;
                        if (__UNDEF_KEY__ == null) {
                            if (particlesServiceComponent.getNumericValue() == player.method_5628()) {
                            } else {
                            }
                        }
                    }
                    ParticlesServiceComponent particlesServiceComponent2 = ((ParticlesServiceComponent) null);
                    if (__UNDEF_KEY__ == null) {
                        if (particlesServiceComponent2 == null) {
                            iterable = new ArrayList();
                            index2 = 0;
                            if (index2 < index) {
                                iterator2 = index2;
                                element = 0;
                            }
                            index2 = ((Collection) itemList);
                            index2.add(new ParticlesServiceComponent(player.method_5628(), iterable));
                        }
                    }
                    if (__UNDEF_KEY__ == null) {
                        if (particlesServiceComponent2.getList().size() < index) {
                            iterable = ((Collection) particlesServiceComponent2.getList());
                            iterable.add(new ServiceComponent96((threadLocalRandom.nextFloat() * 360.0F), 0.0F, (threadLocalRandom.nextFloat() * 360.0F), (1.0F + (threadLocalRandom.nextFloat() * 0.2F)), 0.0F, 0.0F, false, 0.0F));
                        }
                    }
                    if (__UNDEF_KEY__ == null) {
                    }
                    iterable = (particlesServiceComponent2.getList().size() - index);
                    index2 = 0;
                    iterator2 = ((Iterable) particlesServiceComponent2.getList());
                    element = 0;
                    particlesServiceComponent = iterator2.iterator();
                    while (particlesServiceComponent.hasNext()) {
                        index3 = particlesServiceComponent.next();
                        ServiceComponent96 serviceComponent96 = ((ServiceComponent96) index3);
                        int index4 = 0;
                        if (__UNDEF_KEY__ == null) {
                            if (index2 < iterable) {
                                serviceComponent96.updateValue((serviceComponent96.getNumericValue2() + 5));
                                index2 = (index2 + 1);
                            }
                        }
                    }
                    arg0.getStack().method_22903();
                    RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
                    RenderHelper4.render(arg0.getStack(), ((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
                }
            }
        }
        iterator = 0;
        player = ((Iterable) itemList);
        factor = 0;
        index = player.iterator();
        while (index.hasNext()) {
            particlesServiceComponent2 = index.next();
            iterable = ((ParticlesServiceComponent) particlesServiceComponent2);
            index2 = 0;
            iterator = (iterator + iterable.getList().size());
            if (__UNDEF_KEY__ == null) {
            }
        }
        int index5 = 4;
        int index6 = 0;
        VertexFormat vertexFormat = class_290.field_1575;
        player = new FormatRenderHelper(vertexFormat, iterator, index6, index5);
        factor = itemList.iterator();
        while (factor.hasNext()) {
            index = ((ParticlesServiceComponent) factor.next());
            if (__UNDEF_KEY__ != null || __UNDEF_KEY__ != null || SharedKt.getWorld().method_8469(index.getNumericValue()) == null) {
                continue;
            }
            particlesServiceComponent2 = SharedKt.getWorld().method_8469(index.getNumericValue());
            iterable = this.computeValue(PolygonShaderComponent.INSTANCE, particlesServiceComponent2.field_6014, particlesServiceComponent2.getX());
            iterator2 = (this.computeValue(PolygonShaderComponent.INSTANCE, particlesServiceComponent2.field_6036, particlesServiceComponent2.getY()) + 1.0D);
            particlesServiceComponent = this.computeValue(PolygonShaderComponent.INSTANCE, particlesServiceComponent2.field_5969, particlesServiceComponent2.getZ());
            serviceComponent96 = index.getList().iterator();
            index4 = ((ServiceComponent96) serviceComponent96.next());
            double offset = Math.toRadians(PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue2(), index4.getNumericValue()));
            double offset2 = Math.toRadians(index4.getNumericValue3());
            Iterable iterable2 = (iterable + ((Math.cos(offset) * index4.getNumericValue4()) * Math.cos(offset2)));
            Iterator iterator3 = (iterator2 + (Math.sin(offset2) * index4.getNumericValue4()));
            ParticlesServiceComponent particlesServiceComponent3 = (particlesServiceComponent + ((Math.sin(offset) * index4.getNumericValue4()) * Math.cos(offset2)));
            Iterable iterable3 = (iterable2 - iterable);
            Iterator iterator4 = (iterator3 - iterator2);
            ParticlesServiceComponent particlesServiceComponent4 = (particlesServiceComponent3 - particlesServiceComponent);
            double offset3 = (Math.toDegrees(Math.atan2(particlesServiceComponent4, iterable3)) + 90.0F);
            double offset4 = Math.sqrt(((iterable3 * iterable3) + (particlesServiceComponent4 * particlesServiceComponent4)));
            double offset5 = Math.toDegrees(Math.atan2(iterator4, offset4));
            if (__UNDEF_KEY__ == null) {
            }
            offset4 = new NoWhenBranchMatchedException();
            float factor2 = PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue6(), index4.getNumericValue5());
            float factor3 = (0.4F * factor2);
            Color color = PolygonShaderComponent.INSTANCE.resolveColor(offset4, factor2);
            MatrixStack matrices = new MatrixStack();
            matrices.method_22903();
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotationDegrees(class4184.method_19329())));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotationDegrees((class4184.method_19330() + 180.0F))));
            matrices.method_22904((iterable2 - class4184.method_71156().field_1352), (iterator3 - class4184.method_71156().field_1351), (particlesServiceComponent3 - class4184.method_71156().field_1350));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40716.rotationDegrees(offset3)));
            RenderHelper4.render(matrices, ((Quaternionfc) class_7833.field_40714.rotationDegrees(offset5)));
            OptionMode6 optionMode6 = OptionMode6.HEART;
            matrices.method_22904((factor3 / 2.0D), (factor3 / 2.0D), 0.0D);
            Matrix4f matrix4f = matrices.method_23760().method_23761();
            player.resolveFormatRenderHelper(matrix4f, 0.0F, factor3, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
            player.resolveFormatRenderHelper(matrix4f, factor3, factor3, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue2()).resolveFormatRenderHelper(color);
            player.resolveFormatRenderHelper(matrix4f, factor3, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
            player.resolveFormatRenderHelper(matrix4f, 0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(optionMode6.getNumericValue3(), optionMode6.getNumericValue4()).resolveFormatRenderHelper(color);
            matrices.method_22909();
        }
        FormatRenderHelper.executeAction(player, VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private static boolean isActive() {
        return INSTANCE.getLmode() == ParticlesLmodeMode.CUSTOM;
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new AbsorptionModule();
        lmodeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", ParticlesLmodeMode.CUSTOM);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.ORANGE, null, this::isActive);
        threadLocalRandom = ThreadLocalRandom.current();
        itemList = new ArrayList();
    }

}
