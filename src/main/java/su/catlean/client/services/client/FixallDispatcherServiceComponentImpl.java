package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.concurrent.ExecutorService;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import su.catlean.SharedKt;

public class FixallDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final FixallDispatcherServiceComponentImpl INSTANCE;

    private FixallDispatcherServiceComponentImpl() {
        super("fixall");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        long var4 = (0L ^ 61473902788714L);
        builder.then(this.resolveRequiredArgumentBuilder("delay", (ArgumentType) IntegerArgumentType.integer()).executes(this::computeValue));
        builder.executes(this::computeValue2);
    }

    public void executeAction(long delay) {
        SharedKt.getNetwork().method_45730("fix hand");
        SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, 1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, (PlayerEntity) SharedKt.getPlayer());
        RunnableServiceComponent var12 = RunnableServiceComponent.INSTANCE;
        int var13 = 0;
        int var14 = 0;
        var12.getExecutorService().execute((Runnable) new ServiceComponent50(delay));
    }

    private static int computeValue(CommandContext arg0) {
        int var5 = (Number) arg0.getArgument("delay", Integer.TYPE);
        INSTANCE.executeAction();
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        INSTANCE.executeAction(100L);
        return 1;
    }

    static {
        INSTANCE = new FixallDispatcherServiceComponentImpl();
    }

}
