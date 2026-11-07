package su.catlean.client.services.render.shader;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.block.BlockState;
import net.minecraft.block.FluidBlock;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_290;
import net.minecraft.class_2960;
import net.minecraft.class_4184;
import net.minecraft.class_4587.class_4665;
import net.minecraft.class_591;
import net.minecraft.class_757;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.DismembermentModule;
import su.catlean.client.services.player.EntityHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.types.OptionMode3;

public class TextureShaderComponent {

    private class_2960 minecraftRef;
    private class_591 minecraftRef2;
    private OptionMode3 optionMode3;
    private double preciseValue;
    private double preciseValue2;
    private double preciseValue3;
    private double preciseValue4;
    private double preciseValue5;
    private double preciseValue6;
    private double preciseValue7;
    private double preciseValue8;
    private double preciseValue9;
    private double preciseValue10;
    private double preciseValue11;
    private double preciseValue12;
    private double preciseValue13;
    private double preciseValue14;
    private double preciseValue15;
    private int countValue;
    private double preciseValue16;
    private double preciseValue17;
    private double preciseValue18;

    public TextureShaderComponent(class_2960 texture, class_591 model, OptionMode3 part, double x, double y, double z) {
        this.minecraftRef = texture;
        this.minecraftRef2 = model;
        this.optionMode3 = part;
        this.preciseValue = x;
        this.preciseValue2 = y;
        this.preciseValue3 = z;
        this.preciseValue4 = this.getNumericValue4();
        this.preciseValue5 = this.getNumericValue4();
        this.preciseValue6 = this.getNumericValue4();
        this.preciseValue7 = (this.getNumericValue5() * 5.0D);
        this.preciseValue8 = (this.getNumericValue5() * 5.0D);
        this.preciseValue9 = (this.getNumericValue5() * 5.0D);
        this.preciseValue10 = this.preciseValue7;
        this.preciseValue11 = this.preciseValue8;
        this.preciseValue12 = this.preciseValue9;
        this.preciseValue13 = this.getNumericValue5();
        this.preciseValue14 = this.getNumericValue5();
        this.preciseValue15 = this.getNumericValue5();
        this.preciseValue16 = this.preciseValue;
        this.preciseValue17 = this.preciseValue2;
        this.preciseValue18 = this.preciseValue3;
    }

    public class_2960 getMinecraftObject() {
        return this.minecraftRef;
    }

    public void executeAction(class_2960 value) {
        this.minecraftRef = value;
    }

    public class_591 getMinecraftObject() {
        return this.minecraftRef2;
    }

    public void executeAction(class_591 value) {
        this.minecraftRef2 = value;
    }

    public OptionMode3 getOptionMode3() {
        return this.optionMode3;
    }

    public void executeAction(OptionMode3 value) {
        this.optionMode3 = value;
    }

    public double getNumericValue() {
        return this.preciseValue;
    }

    public void updateValue(double value) {
        this.preciseValue = value;
    }

    public double getNumericValue2() {
        return this.preciseValue2;
    }

    public void updateValue2(double value) {
        this.preciseValue2 = value;
    }

    public double getNumericValue3() {
        return this.preciseValue3;
    }

    public void updateValue3(double value) {
        this.preciseValue3 = value;
    }

    public double getNumericValue4() {
        return ((Math.random() * 0.3D) - 0.15D);
    }

    public double getNumericValue5() {
        return ((Math.random() * 5.0D) - 2.5D);
    }

    public double getNumericValue6() {
        return this.preciseValue4;
    }

    public void updateValue4(double value) {
        this.preciseValue4 = value;
    }

    public double getNumericValue7() {
        return this.preciseValue5;
    }

    public void updateValue5(double value) {
        this.preciseValue5 = value;
    }

    public double getNumericValue8() {
        return this.preciseValue6;
    }

    public void updateValue6(double value) {
        this.preciseValue6 = value;
    }

    public double getNumericValue9() {
        return this.preciseValue7;
    }

    public void updateValue7(double value) {
        this.preciseValue7 = value;
    }

    public double getNumericValue10() {
        return this.preciseValue8;
    }

    public void updateValue8(double value) {
        this.preciseValue8 = value;
    }

    public double getNumericValue11() {
        return this.preciseValue9;
    }

    public void updateValue9(double value) {
        this.preciseValue9 = value;
    }

    public double getNumericValue12() {
        return this.preciseValue10;
    }

    public void updateValue10(double value) {
        this.preciseValue10 = value;
    }

    public double getNumericValue13() {
        return this.preciseValue11;
    }

    public void updateValue11(double value) {
        this.preciseValue11 = value;
    }

    public double getNumericValue14() {
        return this.preciseValue12;
    }

    public void updateValue12(double value) {
        this.preciseValue12 = value;
    }

    public double getNumericValue15() {
        return this.preciseValue13;
    }

    public void updateValue13(double value) {
        this.preciseValue13 = value;
    }

    public double getNumericValue16() {
        return this.preciseValue14;
    }

    public void updateValue14(double value) {
        this.preciseValue14 = value;
    }

    public double getNumericValue17() {
        return this.preciseValue15;
    }

    public void updateValue15(double value) {
        this.preciseValue15 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public double getNumericValue18() {
        return this.preciseValue16;
    }

    public void updateValue16(double value) {
        this.preciseValue16 = value;
    }

    public double getNumericValue19() {
        return this.preciseValue17;
    }

    public void updateValue17(double value) {
        this.preciseValue17 = value;
    }

    public double getNumericValue20() {
        return this.preciseValue18;
    }

    public void updateValue18(double value) {
        this.preciseValue18 = value;
    }

    public boolean checkCondition(int arg0, int arg1) {
        this.preciseValue16 = this.preciseValue;
        this.preciseValue17 = this.preciseValue2;
        this.preciseValue18 = this.preciseValue3;
        this.preciseValue11 = this.preciseValue8;
        this.preciseValue12 = this.preciseValue9;
        this.preciseValue10 = this.preciseValue7;
        this.preciseValue5 = (this.preciseValue5 - 0.08D);
        BlockPos blockPos = BlockPos.method_49637(this.preciseValue, (this.preciseValue2 - 0.3D), this.preciseValue3);
        BlockState state = SharedKt.getWorld().getBlockState(blockPos);
        this.preciseValue4 = (this.preciseValue4 * 0.91D);
        this.preciseValue5 = (this.preciseValue5 * 0.98D);
        this.preciseValue6 = (this.preciseValue6 * 0.91D);
        this.preciseValue13 = (this.preciseValue13 * 0.91D);
        this.preciseValue14 = (this.preciseValue14 * 0.91D);
        this.preciseValue15 = (this.preciseValue15 * 0.91D);
        if (state.getBlock() instanceof FluidBlock) {
            this.preciseValue5 = 0.31D;
        }
        if (!(state.method_26215())) {
            this.preciseValue5 = 0.0D;
            this.preciseValue2 = (blockPos.method_10264() + 1.0D);
            this.preciseValue4 = (this.preciseValue4 * 0.8D);
            this.preciseValue6 = (this.preciseValue6 * 0.8D);
            this.preciseValue7.preciseValue7 = (-90.0F + ((this.preciseValue7 - 360.0F) / 2));
            this.preciseValue13 = 0.0D;
            this.preciseValue14 = 0.0D;
            this.preciseValue15 = 0.0D;
        }
        Iterable var16 = SharedKt.getWorld().method_18112();
        int var17 = 0;
        Object var18 = var16;
        Collection var19 = (Collection) new ArrayList();
        int var20 = 0;
        Iterator iterator = var18.iterator();
        while (iterator.hasNext()) {
            if (arg0 > 0) {
            }
            Object var22 = iterator.next();
            Entity entity = var22;
            int var24 = 0;
            var19.add();
        }
        Iterator iterator2 = var19.iterator();
        while (iterator2.hasNext()) {
            var16 = iterator2.next();
            var17 = (this.preciseValue - var16.getX());
            var19 = (this.preciseValue3 - var16.getZ());
            this.preciseValue4 = (var17 * 0.5D);
            if (arg0 > 0) {
                this.preciseValue6 = (var19 * 0.5D);
            }
            this.preciseValue = (this.preciseValue + this.preciseValue4);
            this.preciseValue2 = (this.preciseValue2 + this.preciseValue5);
            this.preciseValue3 = (this.preciseValue3 + this.preciseValue6);
            this.preciseValue7 = (this.preciseValue7 + this.preciseValue13);
            this.preciseValue8 = (this.preciseValue8 + this.preciseValue14);
            this.preciseValue9 = (this.preciseValue9 + this.preciseValue15);
        }
        iterator2 = this.countValue;
        this.countValue = (iterator2 + 1);
        return iterator2 > (DismembermentModule.INSTANCE.getLifeTime() * 20);
    }

    public void render(MatrixStack stack) {
        class_4184 var36 = SharedKt.getMc().field_1773.method_19418();
        GpuTextureView var38 = SharedKt.getMc().method_1531().method_4619(this.minecraftRef).method_71659();
        int var20 = 4;
        int var21 = 0;
        int var22 = 12;
        VertexFormat var23 = class_290.field_1575;
        FormatRenderHelper var39 = new FormatRenderHelper();
        Color var19 = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (RangesKt.coerceIn(((DismembermentModule.INSTANCE.getLifeTime() * 20) - this.countValue), 0, 3) / 3.0F));
        var20 = this.optionMode3;
        var21 = var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue12, this.preciseValue9);
        var23 = var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue11, this.preciseValue8);
        double var25 = (var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue10, this.preciseValue7) + 180.0D);
        double var27 = (var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue18, this.preciseValue3) - var36.method_71156().field_1350);
        double var29 = ((this.optionMode3.getNumericValue2() + this.optionMode3.getNumericValue()) - var36.method_71156().field_1351);
        double var31 = var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue17, this.preciseValue2);
        double var33 = (var17.computeValue(PolygonShaderComponent.INSTANCE, this.preciseValue16, this.preciseValue) - var36.method_71156().field_1352);
        Object var34 = var39;
        stack.render(this.minecraftRef2);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline17(), null, null, new MatrixStack().method_23760().method_23761(), null, MapsKt.mapOf(TuplesKt.to("Sampler0")));
    }

}
