package su.catlean.mixins.render;

import java.util.function.Consumer;
import net.minecraft.class_4011;
import net.minecraft.client.gui.DrawContext;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public abstract class MixinLoadingOverlay {

    private boolean field_18219;
    private float field_17770;
    private long field_17771;
    private long field_18220;
    private class_4011 field_17767;
    private Consumer field_18218;

    public MixinLoadingOverlay() {
        this.field_17771 = -1L;
        this.field_18220 = -1L;
    }

    public void render(DrawContext context, float delta, CallbackInfo ci) {
    }

}
