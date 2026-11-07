package su.catlean.client.services.client;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.class_124;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.ui.clickgui.ProxyGuiElement;

public class FriendDispatcherServiceComponentImpl extends DispatcherServiceComponent {

    public static final FriendDispatcherServiceComponentImpl INSTANCE;

    private FriendDispatcherServiceComponentImpl() {
        super("friend");
    }

    public void executeAction(LiteralArgumentBuilder builder) {
        long var4 = (0L ^ 131983109906692L);
        long var6 = (0L ^ 61473902788714L);
        builder.then(this.resolveLiteralArgumentBuilder("clear").executes(this::computeValue));
        builder.then(this.resolveLiteralArgumentBuilder("add").then(this.resolveRequiredArgumentBuilder("player", (ArgumentType) ReaderServiceComponent2.serviceComponent60.getReaderServiceComponent2()).executes(this::computeValue2)));
        builder.then(this.resolveLiteralArgumentBuilder("remove").then(this.resolveRequiredArgumentBuilder("player", (ArgumentType) ReaderServiceComponent4.serviceComponent56.getReaderServiceComponent4()).executes(this::computeValue3)));
        builder.then(this.resolveLiteralArgumentBuilder("list").executes(this::computeValue4));
        builder.executes(this::computeValue5);
    }

    private static int computeValue(CommandContext arg0) {
        PlayerEntityHelper.INSTANCE.updateValue();
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.friend.reset", new Object[0]));
        return 1;
    }

    private static int computeValue2(CommandContext arg0) {
        String var11 = (String) arg0.getArgument("player", String.class);
        PlayerEntityHelper.INSTANCE.checkCondition();
        Object[] var12 = new Object[1];
        var12[0] = var11;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.friend.add"));
        return 1;
    }

    private static int computeValue3(CommandContext arg0) {
        String var10 = (String) arg0.getArgument("player", String.class);
        PlayerEntityHelper.INSTANCE.checkCondition2();
        Object[] var11 = new Object[1];
        var11[0] = var10;
        INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.friend.remove"));
        return 1;
    }

    private static int computeValue4(CommandContext arg0) {
        if (ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().isEmpty()) {
            INSTANCE.executeAction(KeyServiceComponent.INSTANCE.resolveString("commands.friend.empty", new Object[0]));
        } else {
            StringBuilder var11 = new StringBuilder(KeyServiceComponent.INSTANCE.resolveString("commands.friend.friends", new Object[0]));
            Iterator iterator = ProxyGuiElement.INSTANCE.getJsonServiceComponent2().resolveList().iterator();
            while (iterator.hasNext()) {
                String var13 = (String) iterator.next();
                var11.append().append(", ");
            }
            INSTANCE.executeAction(StringsKt.dropLast(var11.toString(), 2));
        }
        return 1;
    }

    private static int computeValue5(CommandContext arg0) {
        INSTANCE.executeAction((class_124.field_1061 + "friend add <name> / friend remove <name> / friend list / friend clear"));
        return 1;
    }

    static {
        INSTANCE = new FriendDispatcherServiceComponentImpl();
    }

}
