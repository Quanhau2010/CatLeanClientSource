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
        this.enabledFlag = 1;
        this.executeAction();
        this.render2(stack, crystals, vDistance, hDistance);
        this.enabledFlag = 0;
    }

    public void executeAction(PlayerEspShaderMode mode, Color color, boolean glass, boolean borders, float radiusValue, float distanceValue, float glowAlphaValue, float lineWidthValue, int colorModev, Color color1v, Color color2v, int glowQualityV, float glowRadiusV, float glowAlphaMultV, float fillAlphaMultV, float saturationV, float brightnessV, float alpha) {
        if (this.minecraftRef == null || 0L < 0) {
            return;
        }
        this.enabledFlag = var26;
    }

    private void executeAction(char arg0, short arg1) {
        if (this.minecraftRef == null) {
            this.minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        if (arg1 >= 0) {
            if (SharedKt.getMc().method_1522().field_1482 == this.minecraftRef.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != this.minecraftRef.field_1481) {
            }
            this.minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.minecraftRef.method_30277(), 0, this.minecraftRef.method_30278(), 1.0D);
        if (arg0 >= 0) {
            if (this.minecraftRef2 == null) {
                this.minecraftRef2 = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
        }
        if (arg0 >= 0) {
            if (SharedKt.getMc().method_1522().field_1482 == this.minecraftRef2.field_1482) {
            }
            if (SharedKt.getMc().method_1522().field_1481 != this.minecraftRef2.field_1481) {
            }
            this.minecraftRef2.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        }
        RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(this.minecraftRef2.method_30277(), 0, this.minecraftRef2.method_30278(), 1.0D);
    }

    private void render2(MatrixStack arg0, boolean arg1, int arg2, int arg3) {
        class_4184 var15 = SharedKt.getMc().field_1773.method_19418();
        float var16 = TextShaderComponent2.INSTANCE.computeValue();
        boolean var18 = (Boolean) SharedKt.getMc().options.method_42435().method_41753();
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(0));
        GofraState.INSTANCE.setModifyBuffer(1);
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix((GameRendererAccessor) SharedKt.getMc().field_1773.getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        Iterable var20 = SharedKt.getWorld().method_18112();
        int var21 = 0;
        Object var22 = var20;
        Collection var23 = (Collection) new ArrayList();
        int var24 = 0;
        Iterator iterator = var22.iterator();
        if (iterator.hasNext()) {
            if (var14) {
                Object var26 = iterator.next();
                Entity entity = var26;
                int var28 = 0;
                if (var14) {
                }
                if (var14) {
                    if (Math.hypot((var15.method_71156().field_1352 - entity.getX()), (var15.method_71156().field_1350 - entity.getZ())) < arg3 && Math.abs((var15.method_71156().field_1351 - entity.getY())) < arg2) {
                    }
                } else {
                }
                var23.add();
            }
        }
        Iterator iterator2 = var23.iterator();
        if (iterator2.hasNext()) {
            var20 = iterator2.next();
            if (var14) {
                if (var14) {
                    if (!(SharedKt.getMc().method_1561().method_3950(TextShaderComponent2.INSTANCE.getMinecraftObject(), var15.method_71156().field_1352, var15.method_71156().field_1351, var15.method_71156().field_1350))) {
                    }
                }
                if (Intrinsics.areEqual(SharedKt.getMc().player)) {
                    if (var14 && var14) {
                    }
                }
                if (!(var20 instanceof PlayerEntity)) {
                    if (var14 && var14) {
                    }
                }
                if (var14) {
                    if (!(var20 instanceof EndCrystalEntity)) {
                    }
                }
                var21 = (class_3532.method_16436(var20.field_6038, var20.getX()) - var15.method_71156().field_1352);
                var23 = (class_3532.method_16436(var20.field_5971, var20.getY()) - var15.method_71156().field_1351);
                iterator = (class_3532.method_16436(var20.field_5989, var20.getZ()) - var15.method_71156().field_1350);
                entity = var20.method_5767();
                var28 = var20.method_36361();
                var20.method_5648(0);
                var20.method_5834(0);
                class_10017 var29 = SharedKt.getMc().method_1561().method_3953().method_62425(TextShaderComponent2.INSTANCE.computeValue());
                var29.field_61821 = 0;
                class_12075 var30 = (GameRendererAccessor) SharedKt.getMc().field_1773.getLevelRenderState().field_63082;
                SharedKt.getMc().method_1561().method_72976(iterator, arg0, (class_11659) SharedKt.getMc().field_1773.method_72910());
                var29 = 1;
                var20.method_5648(entity);
                var20.method_5834();
            }
            SharedKt.getMc().field_1773.method_72911().method_73002();
            SharedKt.getMc().method_22940().method_23000().method_22993();
            SharedKt.getMc().field_1773.method_72910().method_72953();
            GofraState.INSTANCE.setModifyBuffer(0);
        }
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf());
        RenderSystem.restoreProjectionMatrix();
    }

}
