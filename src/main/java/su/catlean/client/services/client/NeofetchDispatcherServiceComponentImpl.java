package su.catlean.client.services.client;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;

public class NeofetchDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final NeofetchDispatcherServiceComponentImpl INSTANCE;

    private NeofetchDispatcherServiceComponentImpl() {
        super("neofetch");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        builder.executes(this::computeValue);
    }

    private static int computeValue(CommandContext arg0) {
        return 1;
    }

    static {
        INSTANCE = new NeofetchDispatcherServiceComponentImpl();
    }

}
