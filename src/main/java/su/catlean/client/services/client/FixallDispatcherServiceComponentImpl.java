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
        builder.then(this.resolveRequiredArgumentBuilder("delay", ((ArgumentType) IntegerArgumentType.integer())).executes(this::computeValue));
        builder.executes(this::computeValue2);
    }

    public void executeAction(long delay) {
        SharedKt.getNetwork().method_45730("fix hand");
        SharedKt.getInteractionManager().method_2906(SharedKt.getPlayer().field_7512.field_7763, 1, SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, ((PlayerEntity) SharedKt.getPlayer()));
        RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        int index = 0;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent50(index, delay)));
    }

    private static int computeValue(CommandContext arg0) {
        int index = ((Number) arg0.getArgument("delay", Integer.TYPE));
        INSTANCE.executeAction(index);
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
