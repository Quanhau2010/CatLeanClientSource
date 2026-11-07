package su.catlean.client.features.modules.render.esp;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_10017;
import net.minecraft.class_10055;
import net.minecraft.class_1007;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_2561;
import net.minecraft.class_2703;
import net.minecraft.class_2703.class_2705;
import net.minecraft.class_2703.class_5893;
import net.minecraft.class_290;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_4588;
import net.minecraft.class_591;
import net.minecraft.class_745;
import net.minecraft.class_7828;
import net.minecraft.class_7833;
import net.minecraft.class_8685;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2f;
import org.joml.Quaternionfc;
import org.joml.Vector4d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent33;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.UuidEntityHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.PolygonRenderHelper2;
import su.catlean.client.services.render.StackRenderHelper3;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;

public class LogoutSpotsModule extends Module {

    public static final LogoutSpotsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 renderModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final VisibleVisibleSettingPropertyImpl friendsSetting;
    private static final RangeVisibleSettingPropertyImpl hDistanceSetting;
    private static final RangeVisibleSettingPropertyImpl vDistanceSetting;
    private static final VisibleVisibleSettingPropertyImpl timeOutSetting;
    private static final RangeVisibleSettingPropertyImpl2 timeOutValueSetting;
    private static final Map lookupMap;
    private static final ArrayList arrayList;
    private static final MissingnoRenderHelper missingnoRenderHelper;

    private LogoutSpotsModule() {
        super("logout-spots", SubCategoriesKt.getEspCategory());
    }

    private LogoutSpotsRenderMode getRenderMode() {
        return (LogoutSpotsRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getFriends() {
        return (Boolean) friendsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private int getHDistance() {
        return (Number) hDistanceSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private void setHDistance(int value) {
        hDistanceSetting.setValue(this, DELEGATED_PROPERTIES[3], Integer.valueOf(value));
    }

    private int getVDistance() {
        return (Number) vDistanceSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private void setVDistance(int value) {
        vDistanceSetting.setValue(this, DELEGATED_PROPERTIES[4], Integer.valueOf(value));
    }

    private boolean getTimeOut() {
        return (Boolean) timeOutSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private float getTimeOutValue() {
        return (Number) timeOutValueSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (var15 == null) {
            if (arg0.getPacket() instanceof class_2703) {
                class_2703 var16 = (class_2703) arg0.getPacket();
                if (var15 == null) {
                    if (var16.method_46327().contains(class_5893.field_29136)) {
                    }
                    Iterator iterator = var16.method_46330().iterator();
                    if (iterator.hasNext()) {
                        class_2705 var18 = (class_2705) iterator.next();
                        arrayList.removeIf(this::checkCondition);
                        if (var15 == null) {
                        }
                    }
                    lookupMap.clear();
                }
            }
            if (var15 == null) {
            }
        }
        var16 = (class_7828) arg0.getPacket().comp_1105().iterator();
        iterator = (UUID) var16.next();
        var18 = lookupMap.keySet().iterator();
        UUID var19 = (UUID) var18.next();
        if (var15 == null) {
            if (!(Intrinsics.areEqual(iterator))) {
            }
        }
        if ((PlayerEntity) lookupMap.get() != null) {
            PlayerEntity player = (PlayerEntity) lookupMap.get();
            int var21 = 0;
            if (var15 == null) {
                if (!(INSTANCE.getFriends())) {
                    if (!(EntityHelper4.isFriend(player))) {
                    }
                }
                Object[] var22 = new Object[4];
                var22[0] = player.method_5477().getString();
                var22[1] = Integer.valueOf(player.getX());
                var22[2] = Integer.valueOf(player.getY());
                var22[3] = Integer.valueOf(player.getZ());
                MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "logout"));
                arrayList.add(new UuidEntityHelper(player, System.currentTimeMillis()));
            }
        }
    }

    public void updateValue() {
        lookupMap.clear();
        arrayList.clear();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterator iterator = SharedKt.getWorld().getPlayers().iterator();
        while (iterator.hasNext()) {
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) iterator.next();
            if (var15 == null) {
            }
            if (var15 == null) {
                if (var15 == null) {
                }
                if (this.checkCondition((PlayerEntity) player)) {
                }
            }
            lookupMap.put(player.method_7334().id(), player);
        }
        iterator = (Iterable) Lists.newArrayList((Iterable) arrayList);
        player = 0;
        Iterator iterator2 = iterator.iterator();
        if (iterator2.hasNext()) {
            Object var19 = iterator2.next();
            UuidEntityHelper var20 = (UuidEntityHelper) var19;
            int var21 = 0;
            if (var15 == null) {
                if ((SharedKt.getNumericValue() - var20.getNumericValue()) > (INSTANCE.getTimeOutValue() * 1000)) {
                    arrayList.remove();
                }
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (var24 == null) {
        }
        this.render(arg0.getStack());
        Iterable var25 = (Iterable) arrayList;
        Color var38 = PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), 1.0F);
        Color var37 = this.getColor();
        PlayerEspRenderMode var36 = PlayerEspRenderMode.BOTH;
        MatrixStack matrices = arg0.getStack();
        StackRenderHelper3 var34 = StackRenderHelper3.INSTANCE;
        int var26 = 0;
        Object var27 = var25;
        Collection var28 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var29 = 0;
        Iterator iterator = var27.iterator();
        if (iterator.hasNext()) {
            Object var31 = iterator.next();
            UuidEntityHelper var32 = (UuidEntityHelper) var31;
            Object var39 = var28;
            int var33 = 0;
            var39.add(var32.getMinecraftObject());
        }
        var39 = var28;
        int var21 = this.getHDistance();
        int var22 = this.getVDistance();
        List<BlockPos> positions = Lists.newArrayList((Iterable) var39);
        var34.render(matrices, positions);
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        Iterable var31 = (Iterable) Lists.newArrayList((Iterable) arrayList);
        int var32 = 0;
        Iterator iterator = var31.iterator();
        if (iterator.hasNext()) {
            Object var34 = iterator.next();
            UuidEntityHelper var35 = (UuidEntityHelper) var34;
            int var36 = 0;
            if (INSTANCE.getTimeOut()) {
            }
            float var37 = 1.0F;
            Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(INSTANCE.resolveMinecraftObject(var35.getMinecraftObject()).method_1031(0.0D, 2.0D, 0.0D));
            if (var30 == null) {
            }
            if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                Vector4d var39 = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                var39.x = Math.min(vec.field_1352, var39.x);
                var39.y = Math.min(vec.field_1351, var39.y);
                var39.z = Math.max(vec.field_1352, var39.z);
            }
            long var40 = ((System.currentTimeMillis() - var35.getNumericValue()) / 500.0F);
            long var41 = ((System.currentTimeMillis() - var35.getNumericValue()) / 1000.0D);
            String var42 = (var35.getMinecraftObject().method_5477().getString() + (var35.getMinecraftObject().method_6032() + var35.getMinecraftObject().method_6067()) + (var41 / 60) + (var41 % 60));
            var42 = StringsKt.dropLast(Math.max(0, (var42.length() * (1.0F - var40))));
            if (var30 == null) {
                if (var39 != null) {
                    double var43 = ((var39.z - var39.x) / 2.0F);
                    float var44 = (SFMServiceComponent.resolveFontRenderHelper6().computeValue() + 18.0F);
                    double var45 = ((var39.x + var43) - (var44 / 2.0F));
                    StackShaderComponent2.executeAction(arg0.getContext().method_51448(), (var45 - 2), (var39.y - 13.0F), 12.0F, 2.0F, 1.5F, 0.0F, 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor5(), (var37 * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), (var37 * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), 0.0F, 0.0F, 0.0F);
                    MissingnoRenderHelper.executeAction(missingnoRenderHelper, (Matrix3x2f) arg0.getContext().method_51448(), (var39.y - 13.5D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (var37 * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), null, 0.0F);
                    SFMServiceComponent.resolveFontRenderHelper6().render(arg0.getContext(), (var45 + 12.0F), (var39.y - 13.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (var37 * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))));
                }
            }
        }
    }

    private boolean checkCondition(PlayerEntity arg0) {
        if (!(StringsKt.contains$default((CharSequence) arg0.method_7334().name(), (CharSequence) "-"))) {
            if (var4 == null && var4 == null) {
                if (StringsKt.contains$default((CharSequence) arg0.method_7334().name(), (CharSequence) "_")) {
                }
            }
        } else {
        }
        return false;
    }

    private void render(MatrixStack arg0, int arg1) {
        Iterable var15 = (Iterable) Lists.newArrayList((Iterable) arrayList);
        int var16 = 0;
        Iterator iterator = var15.iterator();
        if (iterator.hasNext()) {
            Object var18 = iterator.next();
            UuidEntityHelper var19 = (UuidEntityHelper) var18;
            int var20 = 0;
            if (INSTANCE.getTimeOut()) {
            }
            arg0.render((1.0F - ((SharedKt.getNumericValue() - var19.getNumericValue()) / (INSTANCE.getTimeOutValue() * 1000.0F))), Math.max(0.4F, (1.0F - ((SharedKt.getNumericValue() - var19.getNumericValue()) / 800.0F))));
        }
    }

    private void render(MatrixStack arg0, UuidEntityHelper arg1, float arg2) {
        PlayerEntity player = arg1.getMinecraftObject();
        class_591 var29 = (class_591) (class_1007) SharedKt.getMc().method_1561().method_3953(player).method_4038();
        class_10017 var31 = SharedKt.getMc().method_1561().method_3953(player).method_62425(player, 1.0F);
        class_10055 var30 = (class_10055) var31;
        var31 = SharedKt.getMc().method_1531().method_4619((class_745) player.method_52814().comp_1626().comp_3627()).method_71659();
        int var24 = 4;
        int var25 = 0;
        int var26 = 256;
        VertexFormat var27 = class_290.field_1575;
        FormatRenderHelper var32 = new FormatRenderHelper();
        PolygonRenderHelper2 var33 = new PolygonRenderHelper2(PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), arg2));
        arg0.method_22903();
        Vec3d vec = this.resolveMinecraftObject(player);
        double var35 = (vec.field_1352 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10216());
        double var37 = (vec.field_1351 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10214());
        double var39 = (vec.field_1350 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10215());
        arg0.method_46416();
        arg0.method_22905(var30.field_53453, var30.field_53453, var30.field_53453);
        this.render(arg0, var30.field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
        arg0.method_46416(0.0F, -1.501F, 0.0F);
        var29.method_62110();
        var29.method_62100(arg0, (class_4588) var33, 15728880, 0, NewThemeRenderHelper.INSTANCE.getColor2().getRGB());
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline16(), null, null, new MatrixStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0")));
        arg0.method_22909();
    }

    public void render(class_10055 state, MatrixStack stack, float bodyYaw) {
        if (var9 == null) {
            if (state.field_53411) {
                stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw)));
                if (0L > 0 && var9 == null) {
                    if (!(state.field_53459)) {
                        stack.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees((state.method_64259() * (-90.0F - state.field_53448))));
                    }
                }
                stack.method_22907((Quaternionfc) class_7833.field_40716.rotation(state.field_53521));
            }
        }
        if (state.field_53403 > 0.0F) {
            stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw)));
            if (state.field_53458) {
            }
            class_7833.field_40714.method_22907((Quaternionfc) state.field_53403.rotationDegrees(class_3532.method_16439(0.0F, (-90.0F - state.field_53448), -90.0F)));
            if (0L >= 0L) {
                if (var9 == null) {
                    stack.method_46416(0.0F, -1.0F, 0.3F);
                }
                if (0L >= 0) {
                }
            }
            stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw)));
        }
    }

    private static boolean checkCondition(class_2705 arg0, UuidEntityHelper arg1) {
        if (var9 == null) {
            if (arg0.comp_1107() != null) {
            }
            arg0.comp_1107().id();
        }
        if (Intrinsics.areEqual(arg1.getUUID())) {
            Object[] var10 = new Object[4];
            var10[0] = arg1.getMinecraftObject().method_5477().getString();
            var10[1] = Integer.valueOf(arg1.getMinecraftObject().getX());
            var10[2] = Integer.valueOf(arg1.getMinecraftObject().getY());
            var10[3] = Integer.valueOf(arg1.getMinecraftObject().getZ());
            MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "login"));
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var38 = new KProperty[7];
        INSTANCE = new LogoutSpotsModule();
        renderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render-mode", LogoutSpotsRenderMode.GHOST);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.WHITE);
        friendsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friends");
        hDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-horizontal-distance", 64, new IntRange(1, 256));
        vDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-vertical-distance", 32, new IntRange(1, 256));
        timeOutSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time-out");
        timeOutValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time-out-value", 1.0F, RangesKt.rangeTo(0.0F, 3600.0F));
        lookupMap = (Map) Maps.newConcurrentMap();
        arrayList = new ArrayList();
        missingnoRenderHelper = new MissingnoRenderHelper("no-connection", 10, 10);
    }

}
