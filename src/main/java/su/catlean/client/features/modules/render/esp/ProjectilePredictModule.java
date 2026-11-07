package su.catlean.client.features.modules.render.esp;

import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_1542;
import net.minecraft.class_1665;
import net.minecraft.class_1680;
import net.minecraft.class_1681;
import net.minecraft.class_1684;
import net.minecraft.class_1685;
import net.minecraft.class_1686;
import net.minecraft.class_239.class_240;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_3959;
import net.minecraft.class_3959.class_242;
import net.minecraft.class_3959.class_3960;
import net.minecraft.class_3965;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_757;
import net.minecraft.class_7833;
import net.minecraft.class_8956;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.event.events.world.EntityRemove;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.TexRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.POSITIONCOLORShaderComponent;
import su.catlean.client.services.render.shader.POSITIONTEXCOLORShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.OptionMode6;

public class ProjectilePredictModule extends Module {

    public static final ProjectilePredictModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl7 groupSetting;
    private static final VisibleVisibleSettingPropertyImpl pearlsSetting;
    private static final VisibleVisibleSettingPropertyImpl arrowsSetting;
    private static final VisibleVisibleSettingPropertyImpl tridentsSetting;
    private static final VisibleVisibleSettingPropertyImpl eggsSetting;
    private static final VisibleVisibleSettingPropertyImpl windchargesSetting;
    private static final VisibleVisibleSettingPropertyImpl snowBallsSetting;
    private static final VisibleVisibleSettingPropertyImpl potionsSetting;
    private static final VisibleVisibleSettingPropertyImpl drawCircleSetting;
    private static final VisibleVisibleSettingPropertyImpl itemsSetting;
    private static final VisibleVisibleSettingPropertyImpl drawPlayerSetting;
    private static final VisibleVisibleSettingPropertyImpl drawHitSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 lineTypeSetting;

    private ProjectilePredictModule() {
        super("projectile-predict", SubCategoriesKt.getEspCategory());
    }

    private SettingGroup getGroup() {
        return (SettingGroup) groupSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getPearls() {
        return (Boolean) pearlsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getArrows() {
        return (Boolean) arrowsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getTridents() {
        return (Boolean) tridentsSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getEggs() {
        return (Boolean) eggsSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getWindcharges() {
        return (Boolean) windchargesSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getSnowBalls() {
        return (Boolean) snowBallsSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getPotions() {
        return (Boolean) potionsSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getDrawCircle() {
        return (Boolean) drawCircleSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getItems() {
        return (Boolean) itemsSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getDrawPlayer() {
        return (Boolean) drawPlayerSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getDrawHit() {
        return (Boolean) drawHitSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private ProjectilePredictLineTypeMode getLineType() {
        return (ProjectilePredictLineTypeMode) lineTypeSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        arg0.getStack().method_22903();
        Iterable var45 = SharedKt.getWorld().method_18112();
        int var46 = 0;
        Object var47 = var45;
        Collection var48 = (Collection) new ArrayList();
        int var49 = 0;
        Iterator iterator = var47.iterator();
        while (iterator.hasNext()) {
            Object var51 = iterator.next();
            Entity entity = var51;
            int var53 = 0;
            if (INSTANCE.getPearls()) {
            }
            if (INSTANCE.getArrows()) {
                if (entity instanceof class_1665) {
                }
            }
            if (INSTANCE.getTridents()) {
                if (entity instanceof class_1685) {
                }
            }
            if (INSTANCE.getWindcharges()) {
            }
            if (INSTANCE.getEggs()) {
            }
            if (INSTANCE.getSnowBalls()) {
            }
            if (INSTANCE.getPotions()) {
                if (!(entity instanceof class_1684) && !((class_1665) entity.method_5675()) && !((class_1685) entity.method_5675()) && !(entity instanceof class_8956) && !(entity instanceof class_1681) && !(entity instanceof class_1680) && !(entity instanceof class_1686)) {
                }
            }
            var48.add();
        }
        List positions = var48;
        if (this.getLineType() == ProjectilePredictLineTypeMode.DEFAULT) {
        } else {
            int var35 = 4;
            int var36 = 0;
            int var37 = (positions.size() * 100);
            VertexFormat var38 = class_290.field_1575;
        }
        var45 = new FormatRenderHelper();
        var46 = (Iterable) positions;
        var47 = 0;
        var48 = var46.iterator();
        while (var48.hasNext()) {
            var49 = var48.next();
            iterator = var49;
            var51 = 0;
            INSTANCE.render(arg0.getStack(), iterator);
        }
        var46 = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        var47 = SharedKt.getMc().field_1773.method_19418();
        arg0.getStack().method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((var47.method_19330() + 180.0F)));
        arg0.getStack().method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(var47.method_19329()));
        if (this.getLineType() == ProjectilePredictLineTypeMode.DOT) {
            if (var45 != null) {
                var35 = 20;
                var36 = MapsKt.mapOf(TuplesKt.to("Sampler0"));
                var38 = arg0.getStack().method_23760().method_23761();
                class_276 var40 = SharedKt.getMc().method_1522();
                RenderPipeline var41 = VertexUBOShaderComponent.INSTANCE.getRenderPipeline18();
                Object var42 = var45;
                FormatRenderHelper.executeAction();
            } else {
            }
        }
        arg0.getStack().method_22909();
    }

    private void onEntityRemove(EntityRemove arg0) {
        int var15 = 25;
        int var16 = 0;
        int var17 = var16;
        int var18 = 0;
        Entity entity = arg0.getEntity();
        POSITIONTEXCOLORShaderComponent.INSTANCE.checkCondition(new TexRenderHelper(OptionMode6.FIREFLY, INSTANCE.resolveMinecraftObject(entity), 0.0F, 0.25F, 12, new Vec3d(((Math.random() / 2.0F) - 0.25F), (Math.random() / 4.0F), ((Math.random() / 2.0F) - 0.25F)), NewThemeRenderHelper.INSTANCE.resolveColor((var17 * 10)), 0.0F, 0.0F));
    }

    private void render(MatrixStack arg0, Entity arg1, FormatRenderHelper arg2, byte arg3, long arg4) {
        Vec3d vec = arg1.method_18798();
        Vec3d vec2 = this.resolveMinecraftObject(arg1);
        int var44 = 0;
        int var46 = 0;
        if (var46 < 300) {
            Object var45 = vec2;
            if (arg4 > 0L) {
                if (var41) {
                    if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.ofFloored(vec2)).getBlock(), Blocks.BEDROCK)) {
                    }
                    if (arg4 >= 0L) {
                    }
                    if (arg1 instanceof class_1685) {
                    } else {
                    }
                    if (arg1 instanceof class_1684) {
                    } else {
                    } else {
                    }
                }
            }
            double var47 = 0.99D;
            vec = vec.method_1031(0.0D, arg1.method_56989(), 0.0D);
            vec = vec.method_1021();
            vec2 = vec2.method_1019(vec);
            class_3965 var49 = SharedKt.getWorld().method_17742(new class_3959(vec2, class_3960.field_17558, class_242.field_1348, SharedKt.getPlayer()));
            if (arg3 >= 0) {
                if (var49.method_17783() != class_240.field_1332) {
                }
                if (var49.method_17783() == class_240.field_1331) {
                }
                if (arg3 >= 0) {
                    if (var41) {
                        if (this.getLineType() == ProjectilePredictLineTypeMode.DOT) {
                        }
                    }
                    if (arg4 >= 0L) {
                        if (var41) {
                            if (this.getDrawCircle() && !(arg1.isOnGround())) {
                                TextShaderComponent2 var50 = TextShaderComponent2.INSTANCE;
                                class_2960 var51 = AtlasTextureServiceComponent.getMinecraftObject();
                                Vec3d vec3 = var49.method_17784().method_1031(0.0D, 0.01D, 0.0D);
                                Color var53 = NewThemeRenderHelper.INSTANCE.resolveColor(0);
                                float var54 = OptionMode6.CIRCLE.getNumericValue();
                                float var55 = OptionMode6.CIRCLE.getNumericValue3();
                                float var56 = OptionMode6.CIRCLE.getNumericValue2();
                                float var57 = OptionMode6.CIRCLE.getNumericValue4();
                                TextShaderComponent2.executeAction(vec3, 0.0F, 90.0F, 0.0F, 1.0F);
                                if (arg3 >= 0) {
                                    if (!(var41)) {
                                    }
                                }
                                TextShaderComponent2.checkCondition(var49.method_17784().method_1031(0.0D, 0.01D, 0.0D), NewThemeRenderHelper.INSTANCE.resolveColor((var46 * 10)));
                            }
                        }
                    }
                    if (arg3 >= 0) {
                    }
                    if (arg4 >= 0L) {
                        if (var41) {
                        }
                        if (arg4 >= 0L) {
                        }
                    }
                    if (arg3 >= 0) {
                        if (this.getDrawPlayer() && arg1 instanceof class_1684 && (class_1684) arg1.method_24921() != null && (class_1684) arg1.method_24921() instanceof PlayerEntity) {
                            int var38 = ((arg1.field_6012 + TextShaderComponent2.INSTANCE.computeValue()) / (arg1.field_6012 + var44));
                            PlayerEntity player = (PlayerEntity) (class_1684) arg1.method_24921();
                            Vec3d vec4 = var49.method_17784();
                            this.render(arg0, vec4, player);
                        }
                    }
                }
                if (arg4 >= 0L) {
                }
            }
            if (arg3 >= 0) {
                if (var41) {
                    if (!(var41) && vec2.field_1351 > -65.0D) {
                    }
                }
                if (arg1.method_18798().field_1352 == 0.0D) {
                    if (arg4 >= 0L && arg4 > 0L) {
                        if (arg1.method_18798().field_1351 == 0.0D) {
                            if (arg1.method_18798().field_1350 != 0.0D) {
                            }
                        }
                    }
                    var50 = (Number) RangesKt.coerceIn((Comparable) Float.valueOf((var46 / 8.0F)), RangesKt.rangeTo(0.0F, 1.0F));
                    var51 = (Number) RangesKt.coerceIn((Comparable) Float.valueOf(((var46 + 1) / 8.0F)), RangesKt.rangeTo(0.0F, 1.0F));
                    if (arg3 >= 0) {
                        if (var41) {
                            if (this.getLineType() == ProjectilePredictLineTypeMode.DOT) {
                                TextShaderComponent2.executeAction(AtlasTextureServiceComponent.getMinecraftObject(), vec2, 0.0F, 0.0F, 0.0F, 0.3F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((var46 * 10))), 0, arg2, OptionMode6.FIREFLY.getNumericValue(), OptionMode6.FIREFLY.getNumericValue2(), OptionMode6.FIREFLY.getNumericValue3(), OptionMode6.FIREFLY.getNumericValue4());
                            }
                        }
                        if (!(var41)) {
                        }
                        TextShaderComponent2.checkCondition(vec2, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((var46 * 10))), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.resolveColor((var46 * 10))));
                    }
                }
            }
        }
    }

    private void render(MatrixStack arg0, Vec3d arg1, PlayerEntity arg2, float arg3) {
        if (var24) {
            if (SharedKt.getPlayer().method_5707(arg1) < 1.0D) {
                return;
            }
            TextShaderComponent2.render(arg0, arg1, arg2, 0.45F);
        }
        int var20 = 4;
        int var21 = 0;
        int var22 = 6;
        VertexFormat var23 = class_290.field_1576;
        FormatRenderHelper var25 = new FormatRenderHelper();
        float var26 = 1.8F;
        float var27 = (arg3 * var26);
        Box var28 = new Box((arg1.field_1352 - 0.6F), (arg1.field_1351 + var27), (arg1.field_1350 - 0.6F), (arg1.field_1352 + 0.6F), ((arg1.field_1351 + var26) + 0.5F), (arg1.field_1350 + 0.6F));
        POSITIONCOLORShaderComponent.INSTANCE.executeAction(Color.BLACK, Color.BLACK);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline21(), null, null, arg0.method_23760().method_23761());
        TextShaderComponent2.INSTANCE.render(arg0, arg1, arg2, 1.0F, 1);
    }

    private static boolean isActive() {
        return INSTANCE.getPearls();
    }

    private static boolean isActive2() {
        return INSTANCE.getPearls();
    }

    static {
        KProperty[] var33 = new KProperty[13];
        INSTANCE = new ProjectilePredictModule();
        groupSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        pearlsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pearls", 1, INSTANCE.getGroup());
        arrowsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "arrows", 1, INSTANCE.getGroup());
        tridentsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "tridents", 1, INSTANCE.getGroup());
        eggsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "eggs", 1, INSTANCE.getGroup());
        windchargesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "windcharges", 1, INSTANCE.getGroup());
        snowBallsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "snowballs", 1, INSTANCE.getGroup());
        potionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potions", 1, INSTANCE.getGroup());
        drawCircleSetting = VisibleRenderHelper.registerSetting(INSTANCE, "draw-circle", 1, INSTANCE.getGroup());
        itemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "items", 1, INSTANCE.getGroup());
        drawPlayerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "draw-player", 1, null, this::isActive);
        drawHitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "draw-hit", 1, null, this::isActive2);
        lineTypeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-type", ProjectilePredictLineTypeMode.DOT);
    }

}
