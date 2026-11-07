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
        return ((Boolean) soundSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    public int getLifeTime() {
        return ((Number) lifeTimeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    public List getList() {
        return itemList;
    }

    public List getList2() {
        return itemList2;
    }

    public void updateValue() {
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (itemList.isEmpty()) {
            return;
        }
        Iterable iterable = ((Iterable) itemList);
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            TextureShaderComponent textureShaderComponent = ((TextureShaderComponent) element);
            textureShaderComponent.render(arg0.getStack());
        }
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            AbstractClientPlayerEntity player = ((AbstractClientPlayerEntity) element);
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
        class_2960 class2960 = ((AbstractClientPlayerEntity) arg0).method_52814().comp_1626().comp_3627();
        double offset = ((AbstractClientPlayerEntity) arg0).getX();
        double offset2 = (((AbstractClientPlayerEntity) arg0).getY() + 1.45F);
        double offset3 = ((AbstractClientPlayerEntity) arg0).getZ();
        class_1007 class1007 = ((class_1007) SharedKt.getMc().method_1561().method_3953(SharedKt.getPlayer()));
        class_591 class591 = ((class_591) class1007.method_4038());
        Iterable iterable = ((Iterable) itemList);
        if (iterable instanceof Collection && ((Collection) iterable).isEmpty()) {
        } else {
            Iterator iterator = iterable.iterator();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                TextureShaderComponent textureShaderComponent = ((TextureShaderComponent) element);
            }
        }
        if (0) {
            return;
        }
        itemList.add(new TextureShaderComponent(class2960, class591, OptionMode3.HEAD, offset, offset2, offset3));
        itemList.add(new TextureShaderComponent(class2960, class591, OptionMode3.BODY, offset, offset2, offset3));
        this.add(new TextureShaderComponent(class2960, class591, OptionMode3.RIGHT_ARM, (offset + 0.35F), (offset2 - 0.15F), offset3));
        this.add(new TextureShaderComponent(class2960, class591, OptionMode3.LEFT_ARM, (offset - 0.35F), (offset2 - 0.15F), offset3));
        this.add(new TextureShaderComponent(class2960, class591, OptionMode3.RIGHT_LEG, (offset + 0.1F), (offset2 - 0.7F), offset3));
        this.add(new TextureShaderComponent(class2960, class591, OptionMode3.LEFT_LEG, (offset - 0.1F), (offset2 - 0.7F), offset3));
        StartupServiceComponent.INSTANCE.getVecServiceComponent18().executeAction(offset, offset2, offset3);
    }

    public void render(MatrixStack stack, class_591 model, FormatRenderHelper polygon, double posX, double posY, double posZ, double rotX, double rotY, double rotZ, OptionMode3 part, Color color) {
        stack.method_22903();
        stack.method_22904(posX, posY, posZ);
        stack.method_22905(0.0555F, 0.0555F, 0.0555F);
        stack.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(rotX)));
        stack.method_22907(((Quaternionfc) class_7833.field_40716.rotationDegrees(rotY)));
        stack.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(rotZ)));
        Matrix4f matrix4f = stack.method_23760().method_23761();
        INSTANCE.executeAction(((class_630) part.getFunction1().invoke(model)), polygon, color, matrix4f);
        INSTANCE.executeAction(((class_630) part.getFunction12().invoke(model)), polygon, color, matrix4f);
        stack.method_22909();
    }

    public void executeAction(class_630 part, FormatRenderHelper polygon, Color color, Matrix4f mat) {
        Iterable iterable = ((Iterable) ((ModelPartAccessor) part).getCuboidsList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            class_628 class628 = ((class_628) element);
            Object[] items = ((Object[]) class628.field_3649);
            int index = 0;
            if (index < __UNDEF_KEY__) {
                Object element2 = items[index];
                class_593 class593 = ((class_593) element2);
                class_618[] items2 = class593.comp_3184();
                polygon.resolveFormatRenderHelper(mat, items2[0].comp_4804(), items2[0].comp_4805(), items2[0].comp_4806()).resolveFormatRenderHelper(items2[0].comp_3187(), items2[0].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, items2[1].comp_4804(), items2[1].comp_4805(), items2[1].comp_4806()).resolveFormatRenderHelper(items2[1].comp_3187(), items2[1].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, items2[2].comp_4804(), items2[2].comp_4805(), items2[2].comp_4806()).resolveFormatRenderHelper(items2[2].comp_3187(), items2[2].comp_3188()).resolveFormatRenderHelper(color);
                polygon.resolveFormatRenderHelper(mat, items2[3].comp_4804(), items2[3].comp_4805(), items2[3].comp_4806()).resolveFormatRenderHelper(items2[3].comp_3187(), items2[3].comp_3188()).resolveFormatRenderHelper(color);
                if (__UNDEF_KEY__ >= 0 && __UNDEF_KEY__ == null) {
                }
            }
        }
    }

    private static boolean checkCondition(PlayerEntity arg0) {
        if (!(CollectionsKt.contains(((Iterable) SharedKt.getWorld().getPlayers()), arg0))) {
            INSTANCE.executeAction(arg0);
        } else {
        }
        return false;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    private static boolean checkCondition(TextureShaderComponent arg0) {
        return arg0.checkCondition();
    }

    private static boolean checkCondition2(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new DismembermentModule();
        soundSetting = VisibleRenderHelper.registerSetting(INSTANCE, "sound", true);
        lifeTimeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "life-time", 10, new IntRange(3, 100));
        itemList = new ArrayList();
        itemList2 = new ArrayList();
    }

}
