package su.catlean.client.services.client;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import su.catlean.SharedKt;
import su.catlean.client.services.render.TestRenderHelper;

public class EasingsdebugDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final EasingsdebugDispatcherServiceComponentImpl INSTANCE;

    private EasingsdebugDispatcherServiceComponentImpl() {
        super("easingsdebug");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        builder.executes(this::computeValue);
    }

    private static void executeAction() {
        SharedKt.getMc().method_1507((Screen) new TestRenderHelper());
    }

    private static int computeValue(CommandContext arg0) {
        RunnableServiceComponent2.executeAction(10, 0, 0, this::executeAction);
        return 1;
    }

    static {
        INSTANCE = new EasingsdebugDispatcherServiceComponentImpl();
    }

}
