package su.catlean.client.services.render;

import java.awt.Color;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.RangesKt;
import net.minecraft.class_3965;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.ParticlesLmodeMode;
import su.catlean.client.features.modules.render.cosmetic.ParticlesModule;
import su.catlean.client.features.modules.render.cosmetic.ParticlesPhysicsMode;
import su.catlean.client.services.client.RangeServiceComponent;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.mappings.ParticlesLmodeModeWhenMappings;

public class RenderHelper5 {

    private float factorValue;
    private float factorValue2;
    private float factorValue3;
    private float factorValue4;
    private float factorValue5;
    private float factorValue6;
    private float factorValue7;
    private float factorValue8;
    private float factorValue9;
    private float factorValue10;
    private float factorValue11;
    private float factorValue12;
    private float factorValue13;
    private int countValue;
    private int countValue2;
    private boolean enabledFlag;
    private boolean enabledFlag2;
    private int countValue3;
    private final Color colorValue;
    private float factorValue14;

    public RenderHelper5(float posX, float posY, float posZ, float motionX, float motionY, float motionZ, float rot, float rotSpeed, float size) {
        this.factorValue = posX;
        this.factorValue2 = posY;
        this.factorValue3 = posZ;
        this.factorValue4 = motionX;
        this.factorValue5 = motionY;
        this.factorValue6 = motionZ;
        this.factorValue7 = rot;
        this.factorValue8 = rotSpeed;
        this.factorValue9 = size;
        this.factorValue10 = this.factorValue;
        this.factorValue11 = this.factorValue2;
        this.factorValue12 = this.factorValue3;
        this.factorValue13 = this.factorValue7;
        if (__UNDEF_KEY__ != null) {
            if (ParticlesModule.resolveParticlesPhysicsMode() == ParticlesPhysicsMode.RAIN) {
            }
        }
        ParticlesModule particlesModule = ParticlesModule.INSTANCE;
        this.countValue = (ParticlesModule.computeValue(particlesModule) + (ParticlesModule.computeValue() * RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 0.5F)), false)));
        this.countValue2 = this.countValue;
        this.countValue3 = (360 * RangeServiceComponent.p(((ClosedRange) RangesKt.rangeTo(0.0F, 1.0F)), false));
        if (__UNDEF_KEY__ != null) {
            particlesModule = ParticlesModule.INSTANCE;
        }
        PolygonShaderComponent.INSTANCE.resolveColor(18, this.countValue3, 1.0F, 1.0F).colorValue = new NoWhenBranchMatchedException();
        class_3965 class3965 = ExplosionPosEntityHelper.resolveMinecraftObject(new Vec3d(this.factorValue, this.factorValue2, this.factorValue3), new Vec3d(this.factorValue, (this.factorValue2 - 128.0D), this.factorValue3), false, null, false);
        if (__UNDEF_KEY__ != null) {
            if (class3965 != null) {
                BlockPos blockPos = class3965.method_17777();
                if (__UNDEF_KEY__ != null) {
                    if (blockPos != null) {
                        BlockPos blockPos2 = blockPos.up();
                        if (__UNDEF_KEY__ != null) {
                            if (blockPos2 != null) {
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
                blockPos2.method_10264().factorValue14 = this.factorValue2;
            }
        }
        if (__UNDEF_KEY__ >= 0) {
        }
    }

    public float getNumericValue() {
        return this.factorValue;
    }

    public void updateValue(float value) {
        this.factorValue = value;
    }

    public float getNumericValue2() {
        return this.factorValue2;
    }

    public void updateValue2(float value) {
        this.factorValue2 = value;
    }

    public float getNumericValue3() {
        return this.factorValue3;
    }

    public void updateValue3(float value) {
        this.factorValue3 = value;
    }

    public float getNumericValue4() {
        return this.factorValue4;
    }

    public void updateValue4(float value) {
        this.factorValue4 = value;
    }

    public float getNumericValue5() {
        return this.factorValue5;
    }

    public void updateValue5(float value) {
        this.factorValue5 = value;
    }

    public float getNumericValue6() {
        return this.factorValue6;
    }

    public void updateValue6(float value) {
        this.factorValue6 = value;
    }

    public float getNumericValue7() {
        return this.factorValue7;
    }

    public void updateValue7(float value) {
        this.factorValue7 = value;
    }

    public float getNumericValue8() {
        return this.factorValue8;
    }

    public void updateValue8(float value) {
        this.factorValue8 = value;
    }

    public float getNumericValue9() {
        return this.factorValue9;
    }

    public void updateValue9(float value) {
        this.factorValue9 = value;
    }

    public float getNumericValue10() {
        return this.factorValue10;
    }

    public void updateValue10(float value) {
        this.factorValue10 = value;
    }

    public float getNumericValue11() {
        return this.factorValue11;
    }

    public void updateValue11(float value) {
        this.factorValue11 = value;
    }

    public float getNumericValue12() {
        return this.factorValue12;
    }

    public void updateValue12(float value) {
        this.factorValue12 = value;
    }

    public float getNumericValue13() {
        return this.factorValue13;
    }

    public void updateValue13(float value) {
        this.factorValue13 = value;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public void updateValue(int value) {
        this.countValue = value;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public void updateValue2(int value) {
        this.countValue2 = value;
    }

    public boolean isActive() {
        return this.enabledFlag;
    }

    public void updateValue(boolean value) {
        this.enabledFlag = value;
    }

    public boolean isActive2() {
        return this.enabledFlag2;
    }

    public void updateValue2(boolean value) {
        this.enabledFlag2 = value;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public void updateValue3(int value) {
        this.countValue3 = value;
    }

    public Color getColor() {
        return this.colorValue;
    }

    public float getNumericValue14() {
        return this.factorValue14;
    }

    public void updateValue14(float value) {
        this.factorValue14 = value;
    }

}
