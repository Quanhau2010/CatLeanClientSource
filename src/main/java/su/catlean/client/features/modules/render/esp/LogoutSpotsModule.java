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
        return ((LogoutSpotsRenderMode) renderModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getFriends() {
        return ((Boolean) friendsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private int getHDistance() {
        return ((Number) hDistanceSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private void setHDistance(int value) {
        hDistanceSetting.setValue(this, DELEGATED_PROPERTIES[3], Integer.valueOf(value));
    }

    private int getVDistance() {
        return ((Number) vDistanceSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private void setVDistance(int value) {
        vDistanceSetting.setValue(this, DELEGATED_PROPERTIES[4], Integer.valueOf(value));
    }

    private boolean getTimeOut() {
        return ((Boolean) timeOutSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private float getTimeOutValue() {
        return ((Number) timeOutValueSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private void onReceivePacket(ReceivePacket arg0) {
        if (arg0.getPacket() instanceof class_2703) {
            class_2703 class2703 = ((class_2703) arg0.getPacket());
            if (class2703.method_46327().contains(class_5893.field_29136)) {
                Iterator iterator = class2703.method_46330().iterator();
                while (iterator.hasNext()) {
                    class_2705 class2705 = ((class_2705) iterator.next());
                    arrayList.removeIf(this::checkCondition);
                }
            }
            lookupMap.clear();
        }
        class2703 = ((class_7828) arg0.getPacket()).comp_1105().iterator();
        while (class2703.hasNext()) {
            iterator = ((UUID) class2703.next());
            class2705 = lookupMap.keySet().iterator();
            while (class2705.hasNext()) {
            }
            UUID uUID = ((UUID) class2705.next());
            if (!(Intrinsics.areEqual(uUID, iterator))) {
            }
            if (((PlayerEntity) lookupMap.get(uUID)) != null) {
                PlayerEntity player = ((PlayerEntity) lookupMap.get(uUID));
                if (!(INSTANCE.getFriends())) {
                    if (!(EntityHelper4.isFriend(player))) {
                        Object[] items = new Object[4];
                        items[0] = player.method_5477().getString();
                        items[1] = Integer.valueOf(player.getX());
                        items[2] = Integer.valueOf(player.getY());
                        items[3] = Integer.valueOf(player.getZ());
                        MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "logout", items, false), false);
                        arrayList.add(new UuidEntityHelper(uUID, player, System.currentTimeMillis()));
                    }
                }
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
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) iterator.next());
            if (__UNDEF_KEY__ == null) {
            }
            if (__UNDEF_KEY__ == null) {
                if (__UNDEF_KEY__ == null) {
                    if (this.checkCondition(((PlayerEntity) player))) {
                    }
                }
            }
            lookupMap.put(player.method_7334().id(), player);
        }
        iterator = ((Iterable) Lists.newArrayList(((Iterable) arrayList)));
        player = 0;
        Iterator iterator2 = iterator.iterator();
        while (iterator2.hasNext()) {
            Object element = iterator2.next();
            UuidEntityHelper uuidEntityHelper = ((UuidEntityHelper) element);
            if (__UNDEF_KEY__ == null) {
                if ((SharedKt.getNumericValue() - uuidEntityHelper.getNumericValue()) > (INSTANCE.getTimeOutValue() * 1000)) {
                    arrayList.remove(uuidEntityHelper);
                }
            }
        }
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        this.render(arg0.getStack());
        Iterable iterable = ((Iterable) arrayList);
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(this.getColor(), 1.0F);
        Color color2 = this.getColor();
        PlayerEspRenderMode playerEspRenderMode = PlayerEspRenderMode.BOTH;
        MatrixStack matrices = arg0.getStack();
        StackRenderHelper3 stackRenderHelper3 = StackRenderHelper3.INSTANCE;
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            UuidEntityHelper uuidEntityHelper = ((UuidEntityHelper) element);
            Collection collection2 = collection;
            collection2.add(uuidEntityHelper.getMinecraftObject());
        }
        collection2 = collection;
        int index = this.getHDistance();
        int index2 = this.getVDistance();
        List<BlockPos> list = Lists.newArrayList(((Iterable) collection2));
        stackRenderHelper3.render(matrices, playerEspRenderMode, color2, color, list, index2, index);
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        Iterable iterable = ((Iterable) Lists.newArrayList(((Iterable) arrayList)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            UuidEntityHelper uuidEntityHelper = ((UuidEntityHelper) element);
            if (INSTANCE.getTimeOut()) {
            }
            float factor = 1.0F;
            Vec3d vec = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(INSTANCE.resolveMinecraftObject(uuidEntityHelper.getMinecraftObject()).method_1031(0.0D, 2.0D, 0.0D));
            if (__UNDEF_KEY__ == null) {
            }
            if (vec.field_1350 > 0.0D && vec.field_1350 < 1.0D) {
                Vector4d vector4d = new Vector4d(vec.field_1352, vec.field_1351, vec.field_1350, 0.0D);
                vector4d.x = Math.min(vec.field_1352, vector4d.x);
                vector4d.y = Math.min(vec.field_1351, vector4d.y);
                vector4d.z = Math.max(vec.field_1352, vector4d.z);
            }
            long time = ((System.currentTimeMillis() - uuidEntityHelper.getNumericValue()) / 500.0F);
            long time2 = ((System.currentTimeMillis() - uuidEntityHelper.getNumericValue()) / 1000.0D);
            String text = (uuidEntityHelper.getMinecraftObject().method_5477().getString() + (uuidEntityHelper.getMinecraftObject().method_6032() + uuidEntityHelper.getMinecraftObject().method_6067()) + (time2 / 60) + (time2 % 60));
            text = StringsKt.dropLast(text, Math.max(0, (text.length() * (1.0F - time))));
            if (__UNDEF_KEY__ == null) {
                if (vector4d != null) {
                    double offset = ((vector4d.z - vector4d.x) / 2.0F);
                    float factor2 = (SFMServiceComponent.resolveFontRenderHelper6().computeValue(text) + 18.0F);
                    double offset2 = ((vector4d.x + offset) - (factor2 / 2.0F));
                    StackShaderComponent2.executeAction(arg0.getContext().method_51448(), (offset2 - 2), (vector4d.y - 13.0F), factor2, 12.0F, 2.0F, 1.5F, 0.0F, 1.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor5(), (factor * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor6(), (factor * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), 0.0F, 0.0F, 0.0F);
                    MissingnoRenderHelper.executeAction(missingnoRenderHelper, ((Matrix3x2f) arg0.getContext().method_51448()), offset2, (vector4d.y - 13.5D), 0.0F, 0.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (factor * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))), null, 0.0F);
                    SFMServiceComponent.resolveFontRenderHelper6().render(arg0.getContext(), text, (offset2 + 12.0F), (vector4d.y - 13.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), (factor * PolygonShaderComponent.INSTANCE.computeValue2(NewThemeRenderHelper.INSTANCE.getColor5()))));
                }
            }
        }
    }

    private boolean checkCondition(PlayerEntity arg0) {
        if (!(StringsKt.contains$default(((CharSequence) arg0.method_7334().name()), ((CharSequence) "-"), false))) {
            if (StringsKt.contains$default(((CharSequence) arg0.method_7334().name()), ((CharSequence) "_"), false)) {
            } else {
            }
        }
        return false;
    }

    private void render(MatrixStack arg0, int arg1) {
        Iterable iterable = ((Iterable) Lists.newArrayList(((Iterable) arrayList)));
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            UuidEntityHelper uuidEntityHelper = ((UuidEntityHelper) element);
            if (INSTANCE.getTimeOut()) {
            }
            arg0.render(uuidEntityHelper, (1.0F - ((SharedKt.getNumericValue() - uuidEntityHelper.getNumericValue()) / (INSTANCE.getTimeOutValue() * 1000.0F))), Math.max(0.4F, (1.0F - ((SharedKt.getNumericValue() - uuidEntityHelper.getNumericValue()) / 800.0F))));
        }
    }

    private void render(MatrixStack arg0, UuidEntityHelper arg1, float arg2) {
        PlayerEntity player = arg1.getMinecraftObject();
        class_591 class591 = ((class_591) ((class_1007) SharedKt.getMc().method_1561().method_3953(player)).method_4038());
        class_10017 class10017 = SharedKt.getMc().method_1561().method_3953(player).method_62425(player, 1.0F);
        class_10055 class10055 = ((class_10055) class10017);
        class10017 = SharedKt.getMc().method_1531().method_4619(((class_745) player).method_52814().comp_1626().comp_3627()).method_71659();
        int index = 4;
        int index2 = 0;
        int index3 = 256;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        PolygonRenderHelper2 polygonRenderHelper2 = new PolygonRenderHelper2(formatRenderHelper, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), arg2));
        arg0.method_22903();
        Vec3d vec = this.resolveMinecraftObject(player);
        double offset = (vec.field_1352 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10216());
        double offset2 = (vec.field_1351 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10214());
        double offset3 = (vec.field_1350 - SharedKt.getMc().method_1561().field_4686.method_71156().method_10215());
        arg0.method_46416(offset, offset2, offset3);
        arg0.method_22905(class10055.field_53453, class10055.field_53453, class10055.field_53453);
        this.render(class10055, arg0, class10055.field_53446);
        arg0.method_22905(-1.0F, -1.0F, 1.0F);
        arg0.method_22905(0.9375F, 0.9375F, 0.9375F);
        arg0.method_46416(0.0F, -1.501F, 0.0F);
        class591.method_62110(class10055);
        class591.method_62100(arg0, ((class_4588) polygonRenderHelper2), 15728880, 0, NewThemeRenderHelper.INSTANCE.getColor2().getRGB());
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline16(), null, null, new MatrixStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0", class10017)));
        arg0.method_22909();
    }

    public void render(class_10055 state, MatrixStack stack, float bodyYaw) {
        if (__UNDEF_KEY__ == null) {
            if (state.field_53411) {
                stack.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw))));
                if (__UNDEF_KEY__ > 0 && __UNDEF_KEY__ == null) {
                    if (!(state.field_53459)) {
                        stack.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees((state.method_64259() * (-90.0F - state.field_53448)))));
                    }
                }
                stack.method_22907(((Quaternionfc) class_7833.field_40716.rotation(state.field_53521)));
            }
        }
        if (state.field_53403 > 0.0F) {
            stack.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw))));
            if (state.field_53458) {
            }
            class_7833.field_40714.method_22907(((Quaternionfc) state.field_53403.rotationDegrees(class_3532.method_16439(0.0F, (-90.0F - state.field_53448), -90.0F))));
            if (__UNDEF_KEY__ >= 0L) {
                if (__UNDEF_KEY__ == null) {
                    stack.method_46416(0.0F, -1.0F, 0.3F);
                }
                if (__UNDEF_KEY__ >= 0) {
                    stack.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees((180.0F - bodyYaw))));
                }
            }
        }
    }

    private static boolean checkCondition(class_2705 arg0, UuidEntityHelper arg1) {
        if (__UNDEF_KEY__ == null) {
            if (arg0.comp_1107() != null) {
            }
            arg0.comp_1107().id();
        }
        if (Intrinsics.areEqual(arg1.getUUID())) {
            Object[] items = new Object[4];
            items[0] = arg1.getMinecraftObject().method_5477().getString();
            items[1] = Integer.valueOf(arg1.getMinecraftObject().getX());
            items[2] = Integer.valueOf(arg1.getMinecraftObject().getY());
            items[3] = Integer.valueOf(arg1.getMinecraftObject().getZ());
            MessageServiceComponent.S(INSTANCE, MessageServiceComponent.Z(INSTANCE, "login", items, false), false);
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new LogoutSpotsModule();
        renderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "render-mode", LogoutSpotsRenderMode.GHOST);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", Color.WHITE);
        friendsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friends", false);
        hDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-horizontal-distance", 64, new IntRange(1, 256));
        vDistanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "max-vertical-distance", 32, new IntRange(1, 256));
        timeOutSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time-out", false);
        timeOutValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "time-out-value", 1.0F, RangesKt.rangeTo(0.0F, 3600.0F));
        lookupMap = ((Map) Maps.newConcurrentMap());
        arrayList = new ArrayList();
        missingnoRenderHelper = new MissingnoRenderHelper("no-connection", 10, 10);
    }

}
