package su.catlean.mixins.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import net.minecraft.class_2172;
import net.minecraft.class_342;
import net.minecraft.class_4717.class_464;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import su.catlean.api.event.events.client.InputSuggestorEvent;

public abstract class MixinCommandSuggestions {

    private class_342 field_21599;
    private boolean field_21614;
    private ParseResults field_21610;
    private CompletableFuture field_21611;
    private class_464 field_21612;

    public MixinCommandSuggestions() {
    }

    protected void method_23937() {
    }

    public void refreshHook(CallbackInfo ci, StringReader reader) {
        reader.setCursor((reader.getCursor() + 1));
        if (this.field_21610 == null) {
            this.field_21610 = (CommandDispatcher) Objects.requireNonNull(InputSuggestorEvent.INSTANCE.getDispatcher()).parse(reader, (class_2172) Objects.requireNonNull(InputSuggestorEvent.INSTANCE.getSource()));
        }
        int var3 = this.field_21599.method_1881();
        if (this.field_21612 != null) {
            if (var3 >= 1 && !(this.field_21614)) {
            }
            this.field_21611 = (CommandDispatcher) Objects.requireNonNull(InputSuggestorEvent.INSTANCE.getDispatcher()).getCompletionSuggestions(this.field_21610);
            this.field_21611.thenRun(this::lambda$refreshHook$0);
        }
        ci.cancel();
    }

}
