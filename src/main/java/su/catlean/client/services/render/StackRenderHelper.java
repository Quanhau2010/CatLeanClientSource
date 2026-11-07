package su.catlean.client.services.render;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_10017;
import net.minecraft.class_11286;
import net.minecraft.class_11659;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_12075;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4597.class_4598;
import net.minecraft.class_4599;
import net.minecraft.class_5498;
import net.minecraft.class_6364;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.client.features.modules.render.esp.PlayerEspShaderMode;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.mixins.accessors.GameRendererAccessor;

public class StackRenderHelper {

    private class_6364 minecraftRef;
    private class_6364 minecraftRef2;
    private boolean enabledFlag;

    public StackRenderHelper() {
    }

    public class_6364 getMinecraftObject() {
        return this.minecraftRef;
    }

    public void updateValue(class_6364 value) {
        this.minecraftRef = value;
    }

    public class_6364 getMinecraftObject2() {
        return this.minecraftRef2;
    }

    public void updateValue2(class_6364 value) {
        this.minecraftRef2 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public void render(MatrixStack stack, boolean crystals, int vDistance, int hDistance) {
        this.enabledFlag = true;
        this.executeAction();
        this.render2(stack, crystals, vDistance, hDistance);
        this.enabledFlag = false;
    }

    public void executeAction(PlayerEspShaderMode mode, Color color, boolean glass, boolean borders, float radiusValue, float distanceValue, float glowAlphaValue, float lineWidthValue, int colorModev, Color color1v, Color color2v, int glowQualityV, float glowRadiusV, float glowAlphaMultV, float fillAlphaMultV, float saturationV, float brightnessV, float alpha) {
        if (this.minecraftRef == null || __UNDEF_KEY__ < 0) {
            return;
        }
        this.enabledFlag = __UNDEF_KEY__;
    }

    private void executeAction(char arg0, short arg1) {
        if (this.minecraftRef == null) {
            this.minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (arg1 >= 0) {
            if (SharedKt.getMc().method_1522().field_1482 == this.minecraftRef.field_1482) {
                if (SharedKt.getMc().method_1522().field_1481 != this.minecraftRef.field_1481) {
                    this.minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
                }
            }
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.minecraftRef.method_30277(), 0, this.minecraftRef.method_30278(), 1.0D);
        if (arg0 >= 0) {
            if (this.minecraftRef2 == null) {
                this.minecraftRef2 = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        if (arg0 >= 0) {
            if (SharedKt.getMc().method_1522().field_1482 == this.minecraftRef2.field_1482) {
                if (SharedKt.getMc().method_1522().field_1481 != this.minecraftRef2.field_1481) {
                    this.minecraftRef2.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
                }
            }
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.minecraftRef2.method_30277(), 0, this.minecraftRef2.method_30278(), 1.0D);
    }

    private void render2(MatrixStack arg0, boolean arg1, int arg2, int arg3) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        float factor = TextShaderComponent2.INSTANCE.computeValue();
        boolean flag = ((Boolean) SharedKt.getMc().options.method_42435().method_41753());
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(false));
        GofraState.INSTANCE.setModifyBuffer(true);
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix(((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        Iterable iterable = SharedKt.getWorld().method_18112();
        int index = 0;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            if (__UNDEF_KEY__) {
                Object element = iterator.next();
                Entity entity = element;
                int index2 = 0;
                if (__UNDEF_KEY__) {
                }
                if (__UNDEF_KEY__) {
                    if (Math.hypot((class4184.method_71156().field_1352 - entity.getX()), (class4184.method_71156().field_1350 - entity.getZ())) < arg3 && Math.abs((class4184.method_71156().field_1351 - entity.getY())) < arg2) {
                    } else {
                    }
                }
                collection.add(element);
            }
        }
        Iterator iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            iterable = iterator2.next();
            if (__UNDEF_KEY__) {
                if (__UNDEF_KEY__) {
                    if (!(SharedKt.getMc().method_1561().method_3950(iterable, TextShaderComponent2.INSTANCE.getMinecraftObject(), class4184.method_71156().field_1352, class4184.method_71156().field_1351, class4184.method_71156().field_1350))) {
                    }
                }
                if (Intrinsics.areEqual(iterable, SharedKt.getMc().player)) {
                    if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                    }
                }
                if (!(iterable instanceof PlayerEntity)) {
                    if (__UNDEF_KEY__ && __UNDEF_KEY__) {
                    }
                }
                if (__UNDEF_KEY__) {
                    if (!(iterable instanceof EndCrystalEntity)) {
                    }
                }
                index = (class_3532.method_16436(factor, iterable.field_6038, iterable.getX()) - class4184.method_71156().field_1352);
                collection = (class_3532.method_16436(factor, iterable.field_5971, iterable.getY()) - class4184.method_71156().field_1351);
                iterator = (class_3532.method_16436(factor, iterable.field_5989, iterable.getZ()) - class4184.method_71156().field_1350);
                entity = iterable.method_5767();
                index2 = iterable.method_36361();
                iterable.method_5648(false);
                iterable.method_5834(false);
                class_10017 class10017 = SharedKt.getMc().method_1561().method_3953(iterable).method_62425(iterable, TextShaderComponent2.INSTANCE.computeValue());
                class10017.field_61821 = 0;
                class_12075 class12075 = ((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelRenderState().field_63082;
                SharedKt.getMc().method_1561().method_72976(class10017, class12075, index, collection, iterator, arg0, ((class_11659) SharedKt.getMc().field_1773.method_72910()));
                class10017 = 1;
                iterable.method_5648(entity);
                iterable.method_5834(index2);
                SharedKt.getMc().field_1773.method_72911().method_73002();
                SharedKt.getMc().method_22940().method_23000().method_22993();
                SharedKt.getMc().field_1773.method_72910().method_72953();
                GofraState.INSTANCE.setModifyBuffer(false);
            }
        }
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(flag));
        RenderSystem.restoreProjectionMatrix();
    }

}
