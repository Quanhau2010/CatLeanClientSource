package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.util.math.BlockPos;

public class GpsDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final GpsDispatcherServiceComponentImpl INSTANCE;

    private GpsDispatcherServiceComponentImpl() {
        super("gps");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        builder.then(this.resolveLiteralArgumentBuilder("off").executes(this::computeValue));
        builder.then(this.resolveRequiredArgumentBuilder("x", ((ArgumentType) IntegerArgumentType.integer())).then(this.resolveRequiredArgumentBuilder("z", ((ArgumentType) IntegerArgumentType.integer())).executes(this::computeValue2)));
        builder.executes(this::computeValue3);
    }

    private static int computeValue(CommandContext arg0) {
        WHITEServiceComponent.INSTANCE.updateValue(null);
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        Integer integer = ((Integer) arg0.getArgument("x", Integer.TYPE));
        Integer integer2 = ((Integer) arg0.getArgument("z", Integer.TYPE));
        WHITEServiceComponent.INSTANCE.updateValue(new BlockPos(integer, 0, integer2));
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        INSTANCE.executeAction("gps <off / x z>");
        return 1;
    }

    static {
        INSTANCE = new GpsDispatcherServiceComponentImpl();
    }

}
