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
        return (ParticlesLmodeMode) lmodeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable var5 = (Iterable) itemList;
        int var6 = 0;
        Iterator iterator = var5.iterator();
        if (iterator.hasNext()) {
            Object var8 = iterator.next();
            ParticlesServiceComponent var9 = (ParticlesServiceComponent) var8;
            int var10 = 0;
            Iterator iterator2 = var9.getList().iterator();
            if (iterator2.hasNext()) {
                ServiceComponent96 var12 = (ServiceComponent96) iterator2.next();
                int var13 = var12.getNumericValue2();
                var12.updateValue((var13 + 1));
                var12.updateValue2(var12.getNumericValue());
                var12.updateValue((var12.getNumericValue() + var12.getNumericValue7()));
                var12.updateValue5(var12.getNumericValue5());
                if (var4 == null) {
                    if (var12.isActive()) {
                        var12.updateValue4((var12.getNumericValue5() + 0.2F));
                        if (var12.getNumericValue5() >= 1.0F) {
                            var12.updateValue4(1.0F);
                            if (var4 == null) {
                                if (threadLocalRandom.nextInt(1000) < 5) {
                                    var12.updateValue(0);
                                    if (var4 != null) {
                                    }
                                    var12.updateValue4((var12.getNumericValue5() - 0.2F));
                                }
                                if (var4 == null && var4 == null) {
                                    if (var12.getNumericValue5() <= 0.0F) {
                                        iterator2.remove();
                                    }
                                }
                            }
                        }
                        if (var4 == null) {
                        }
                    }
                }
                var12.updateValue(0);
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        class_4184 var49 = SharedKt.getMc().field_1773.method_19418();
        if (SharedKt.getMc().world != null) {
            if (var48 != null || SharedKt.getMc().world.getPlayers() == null) {
                return;
            }
        }
        List positions = SharedKt.getMc().world.getPlayers();
        Iterator iterator = positions.iterator();
        if (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            if (var48 == null) {
                if (var48 == null) {
                    if (Intrinsics.areEqual(player, SharedKt.getMc().player)) {
                    }
                }
                float var53 = RangesKt.coerceIn((player.method_6067() / 16.0F), 0.0F, 1.0F);
                int var54 = (60 * var53);
                Iterable var56 = (Iterable) itemList;
                int var57 = 0;
                Iterator iterator2 = var56.iterator();
                if (iterator2.hasNext()) {
                    Object var59 = iterator2.next();
                    ParticlesServiceComponent var60 = (ParticlesServiceComponent) var59;
                    int var61 = 0;
                    if (var48 == null) {
                        if (var60.getNumericValue() == player.method_5628()) {
                        }
                    } else {
                    }
                } else {
                }
                ParticlesServiceComponent var55 = (ParticlesServiceComponent) null;
                if (var48 == null) {
                    if (var55 == null) {
                        var56 = new ArrayList();
                        var57 = 0;
                        if (var57 < var54) {
                            iterator2 = var57;
                            var59 = 0;
                        }
                        var57 = (Collection) itemList;
                        var57.add(new ParticlesServiceComponent(player.method_5628()));
                    }
                }
                if (var48 == null) {
                    if (var55.getList().size() < var54) {
                        var56 = (Collection) var55.getList();
                        var56.add(new ServiceComponent96((threadLocalRandom.nextFloat() * 360.0F), 0.0F, (threadLocalRandom.nextFloat() * 360.0F), (1.0F + (threadLocalRandom.nextFloat() * 0.2F)), 0.0F, 0.0F, 0, 0.0F));
                    }
                }
                if (var48 == null) {
                }
                var56 = (var55.getList().size() - var54);
                var57 = 0;
                iterator2 = (Iterable) var55.getList();
                var59 = 0;
                var60 = iterator2.iterator();
                if (var60.hasNext()) {
                    var61 = var60.next();
                    ServiceComponent96 var62 = (ServiceComponent96) var61;
                    int var63 = 0;
                    if (var48 == null) {
                        if (var57 < var56) {
                            var62.updateValue((var62.getNumericValue2() + 5));
                            var57 = (var57 + 1);
                        }
                    }
                }
            }
            arg0.getStack().method_22903();
            RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40716.rotationDegrees((var49.method_19330() + 180.0F)));
            RenderHelper4.render(arg0.getStack(), (Quaternionfc) class_7833.field_40714.rotationDegrees(var49.method_19329()));
        }
        iterator = 0;
        player = (Iterable) itemList;
        var53 = 0;
        var54 = player.iterator();
        if (var54.hasNext()) {
            var55 = var54.next();
            var56 = (ParticlesServiceComponent) var55;
            var57 = 0;
            iterator = (iterator + var56.getList().size());
            if (var48 == null) {
            }
        }
        int var44 = 4;
        int var45 = 0;
        int var46 = iterator;
        VertexFormat var47 = class_290.field_1575;
        player = new FormatRenderHelper();
        var53 = itemList.iterator();
        if (var53.hasNext()) {
            var54 = (ParticlesServiceComponent) var53.next();
            if (var48 != null || var48 != null || SharedKt.getWorld().method_8469(var54.getNumericValue()) == null) {
                continue;
            }
            var55 = SharedKt.getWorld().method_8469(var54.getNumericValue());
            var56 = var38.computeValue(PolygonShaderComponent.INSTANCE, var55.field_6014, var55.getX());
            iterator2 = (var38.computeValue(PolygonShaderComponent.INSTANCE, var55.field_6036, var55.getY()) + 1.0D);
            var60 = var38.computeValue(PolygonShaderComponent.INSTANCE, var55.field_5969, var55.getZ());
            var62 = var54.getList().iterator();
            var63 = (ServiceComponent96) var62.next();
            double var64 = Math.toRadians(PolygonShaderComponent.INSTANCE.computeValue(var63.getNumericValue2(), var63.getNumericValue()));
            double var66 = Math.toRadians(var63.getNumericValue3());
            double var68 = (var56 + ((Math.cos() * var63.getNumericValue4()) * Math.cos()));
            double var70 = (iterator2 + (Math.sin() * var63.getNumericValue4()));
            double var72 = (var60 + ((Math.sin() * var63.getNumericValue4()) * Math.cos()));
            double var74 = (var68 - var56);
            double var76 = (var70 - iterator2);
            double var78 = (var72 - var60);
            double var80 = (Math.toDegrees(Math.atan2()) + 90.0F);
            double var82 = Math.sqrt(((var74 * var74) + (var78 * var78)));
            double var81 = Math.toDegrees(Math.atan2());
            if (var48 == null) {
            }
            var82 = new NoWhenBranchMatchedException();
            float var83 = PolygonShaderComponent.INSTANCE.computeValue(var63.getNumericValue6(), var63.getNumericValue5());
            float var84 = (0.4F * var83);
            Color var85 = PolygonShaderComponent.INSTANCE.resolveColor();
            MatrixStack matrices = new MatrixStack();
            matrices.method_22903();
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotationDegrees(var49.method_19329()));
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotationDegrees((var49.method_19330() + 180.0F)));
            matrices.method_22904((var68 - var49.method_71156().field_1352), (var70 - var49.method_71156().field_1351), (var72 - var49.method_71156().field_1350));
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40716.rotationDegrees());
            RenderHelper4.render(matrices, (Quaternionfc) class_7833.field_40714.rotationDegrees());
            OptionMode6 var87 = OptionMode6.HEART;
            matrices.method_22904((var84 / 2.0D), (var84 / 2.0D), 0.0D);
            Matrix4f var88 = matrices.method_23760().method_23761();
            player.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var87.getNumericValue3(), var87.getNumericValue2()).resolveFormatRenderHelper();
            player.resolveFormatRenderHelper(0.0F).resolveFormatRenderHelper(var87.getNumericValue(), var87.getNumericValue2()).resolveFormatRenderHelper();
            player.resolveFormatRenderHelper(0.0F, 0.0F).resolveFormatRenderHelper(var87.getNumericValue(), var87.getNumericValue4()).resolveFormatRenderHelper();
            player.resolveFormatRenderHelper(0.0F, 0.0F, 0.0F).resolveFormatRenderHelper(var87.getNumericValue3(), var87.getNumericValue4()).resolveFormatRenderHelper();
            matrices.method_22909();
        }
        FormatRenderHelper.executeAction(player, VertexUBOShaderComponent.INSTANCE.getRenderPipeline19(), null, null, arg0.getStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659())));
        arg0.getStack().method_22909();
    }

    private static boolean isActive() {
        return INSTANCE.getLmode() == ParticlesLmodeMode.CUSTOM;
    }

    static {
        KProperty[] var30 = new KProperty[2];
        INSTANCE = new AbsorptionModule();
        lmodeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color-mode", ParticlesLmodeMode.CUSTOM);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.ORANGE, null, this::isActive);
        threadLocalRandom = ThreadLocalRandom.current();
        itemList = new ArrayList();
    }

}
