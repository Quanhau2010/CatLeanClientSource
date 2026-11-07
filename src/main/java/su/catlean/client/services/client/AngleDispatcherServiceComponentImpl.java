package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import kotlin.text.StringsKt;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;

public class AngleDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final AngleDispatcherServiceComponentImpl INSTANCE;

    private AngleDispatcherServiceComponentImpl() {
        super("angle");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
    }

    private static float computeValue(String arg0, float arg1) {
        if (StringsKt.startsWith$default(arg0, "~", false)) {
            if (StringsKt.toFloatOrNull(StringsKt.removePrefix(arg0, ((CharSequence) "~"))) != null) {
            } else {
                StringsKt.toFloatOrNull(StringsKt.removePrefix(arg0, ((CharSequence) "~")));
            }
            float factor = 0.0F;
        } else {
            if (StringsKt.toFloatOrNull(arg0) != null) {
            } else {
                StringsKt.toFloatOrNull(arg0);
            }
        }
        return arg1;
    }

    private static int computeValue(CommandContext arg0) {
        String text = ((String) arg0.getArgument("yaw", String.class));
        String text2 = ((String) arg0.getArgument("pitch", String.class));
        SharedKt.getPlayer().method_36456(computeValue(text, SharedKt.getPlayer().method_36454()));
        SharedKt.getPlayer().method_36457(computeValue(text2, SharedKt.getPlayer().method_36455()));
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        INSTANCE.executeAction("angle <yaw> <pitch>");
        return 1;
    }

    static {
        INSTANCE = new AngleDispatcherServiceComponentImpl();
    }

}
