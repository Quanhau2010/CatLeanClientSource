package su.catlean.client.features.modules.render.cosmetic;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlin.reflect.KProperty;
import net.minecraft.class_1007;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_2960;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_591;
import net.minecraft.class_630;
import net.minecraft.class_630.class_593;
import net.minecraft.class_630.class_618;
import net.minecraft.class_630.class_628;
import net.minecraft.class_7833;
import net.minecraft.class_8685;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.joml.Matrix4f;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.StartupServiceComponent;
import su.catlean.client.services.client.VecServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextureShaderComponent;
import su.catlean.client.types.OptionMode3;
import su.catlean.mixins.accessors.ModelPartAccessor;

public class DismembermentModule extends Module {

    public static final DismembermentModule INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl soundSetting;
    private static final RangeVisibleSettingPropertyImpl lifeTimeSetting;
    private static final List itemList;
    private static final List itemList2;

    private DismembermentModule() {
        super("dismemberment", SubCategoriesKt.getCosmeticCategory());
    }

    public boolean getSound() {
        return (Boolean) soundSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    public int getLifeTime() {
        return (Number) lifeTimeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public List getList() {
        return itemList;
    }

    public List getList2() {
        return itemList2;
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 32978412894279L);
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (itemList.isEmpty()) {
            return;
        }
        Iterable var7 = (Iterable) itemList;
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            TextureShaderComponent var11 = (TextureShaderComponent) var10;
            int var12 = 0;
            var11.render(arg0.getStack());
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable var7 = (Iterable) SharedKt.getWorld().getPlayers();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var10;
            int var12 = 0;
            if (!(itemList2.contains(player))) {
                itemList2.add(player);
            }
        }
        itemList2.removeIf(this::checkCondition);
        itemList.removeIf(this::checkCondition2);
    }

    private void executeAction(PlayerEntity arg0) {
        if (arg0 instanceof ClientPlayerEntity || SharedKt.getPlayer().field_6012 < 20) {
            return;
        }
        class_2960 var17 = (AbstractClientPlayerEntity) arg0.method_52814().comp_1626().comp_3627();
        double var18 = (AbstractClientPlayerEntity) arg0.getX();
        double var20 = ((AbstractClientPlayerEntity) arg0.getY() + 1.45F);
        double var22 = (AbstractClientPlayerEntity) arg0.getZ();
        class_1007 var24 = (class_1007) SharedKt.getMc().method_1561().method_3953(SharedKt.getPlayer());
        class_591 var25 = (class_591) var24.method_4038();
        Iterable var26 = (Iterable) itemList;
        int var27 = 0;
        if (var26 instanceof Collection && (Collection) var26.isEmpty()) {
        } else {
            Iterator iterator = var26.iterator();
            if (iterator.hasNext()) {
                Object var29 = iterator.next();
                TextureShaderComponent var30 = (TextureShaderComponent) var29;
                int var31 = 0;
            } else {
            }
        }
        if (0) {
            return;
        }
        itemList.add(new TextureShaderComponent(OptionMode3.HEAD));
        itemList.add(new TextureShaderComponent(OptionMode3.BODY));
        itemList.<init>(new TextureShaderComponent, new TextureShaderComponent, OptionMode3.RIGHT_ARM, (var18 + 0.35F), (var20 - 0.15F));
        0.add();
        itemList.<init>(new TextureShaderComponent, new TextureShaderComponent, OptionMode3.LEFT_ARM, (var18 - 0.35F), (var20 - 0.15F));
        this.add();
        itemList.<init>(new TextureShaderComponent, new TextureShaderComponent, OptionMode3.RIGHT_LEG, (var18 + 0.1F), (var20 - 0.7F));
        this.add();
        itemList.<init>(new TextureShaderComponent, new TextureShaderComponent, OptionMode3.LEFT_LEG, (var18 - 0.1F), (var20 - 0.7F));
        this.add();
        StartupServiceComponent.INSTANCE.getVecServiceComponent18().executeAction();
    }

    public void render(MatrixStack stack, class_591 model, FormatRenderHelper polygon, double posX, double posY, double posZ, double rotX, double rotY, double rotZ, OptionMode3 part, Color color) {
        stack.method_22903();
        stack.method_22904(posX, posY, posZ);
        stack.method_22905(0.0555F, 0.0555F, 0.0555F);
        stack.method_22907((Quaternionfc) class_7833.field_40714.rotationDegrees(rotX));
        stack.method_22907((Quaternionfc) class_7833.field_40716.rotationDegrees(rotY));
        stack.method_22907((Quaternionfc) class_7833.field_40718.rotationDegrees(rotZ));
        Matrix4f var23 = stack.method_23760().method_23761();
        int var24 = 0;
        INSTANCE.executeAction((class_630) part.getFunction1().invoke(model), polygon, color);
        INSTANCE.executeAction((class_630) part.getFunction12().invoke(model), polygon, color);
        stack.method_22909();
    }

    public void executeAction(class_630 part, FormatRenderHelper polygon, Color color, Matrix4f mat) {
        Iterable var17 = (Iterable) (ModelPartAccessor) part.getCuboidsList();
        int var18 = 0;
        Iterator iterator = var17.iterator();
        if (iterator.hasNext()) {
            Object var20 = iterator.next();
            class_628 var21 = (class_628) var20;
            int var22 = 0;
            Object[] var23 = (Object[]) var21.field_3649;
            int var24 = 0;
            int var25 = 0;
            if (var25 < var26) {
                Object var27 = var23[var25];
                class_593 var28 = (class_593) var27;
                int var29 = 0;
                class_618[] var30 = var28.comp_3184();
                int var31 = 0;
                polygon.resolveFormatRenderHelper(mat, var30[0].comp_4804(), var30[0].comp_4805(), var30[0].comp_4806()).resolveFormatRenderHelper(var30[0].comp_3187(), var30[0].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, var30[1].comp_4804(), var30[1].comp_4805(), var30[1].comp_4806()).resolveFormatRenderHelper(var30[1].comp_3187(), var30[1].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, var30[2].comp_4804(), var30[2].comp_4805(), var30[2].comp_4806()).resolveFormatRenderHelper(var30[2].comp_3187(), var30[2].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, var30[3].comp_4804(), var30[3].comp_4805(), var30[3].comp_4806()).resolveFormatRenderHelper(var30[3].comp_3187(), var30[3].comp_3188()).resolveFormatRenderHelper(color);
                if (0L >= 0 && var16 == null) {
                }
            }
        }
    }

    private static boolean checkCondition(PlayerEntity arg0) {
        if (!(CollectionsKt.contains((Iterable) SharedKt.getWorld().getPlayers(), arg0))) {
            INSTANCE.executeAction(arg0);
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    private static boolean checkCondition(TextureShaderComponent arg0) {
        return arg0.checkCondition();
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        KProperty[] var28 = new KProperty[2];
        INSTANCE = new DismembermentModule();
        soundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sound");
        lifeTimeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "life-time", 10, new IntRange(3, 100));
        itemList = new ArrayList();
        itemList2 = new ArrayList();
    }

}
