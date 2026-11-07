package su.catlean.client.services.client;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import net.minecraft.class_2561;
import net.minecraft.class_5250;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;

public abstract class DispatcherServiceComponent {

    private final String textValue;
    private final String textValue2;
    private static Module[] moduleArray;

    public DispatcherServiceComponent(String name) {
        this.textValue = name;
        this.textValue2 = KeyServiceComponent.INSTANCE.resolveString(("commands.descriptions." + this.textValue), new Object[0]);
    }

    public String getString() {
        return this.textValue;
    }

    public void executeAction(LiteralArgumentBuilder arg0) {
    }

    public void executeAction(CommandDispatcher dispatcher) {
        LiteralArgumentBuilder var6 = LiteralArgumentBuilder.literal(this.textValue);
        this.executeAction();
        dispatcher.register();
    }

    public RequiredArgumentBuilder resolveRequiredArgumentBuilder(String name, ArgumentType type) {
        if (RequiredArgumentBuilder.argument(name, type) != null) {
        }
        return null;
    }

    public LiteralArgumentBuilder resolveLiteralArgumentBuilder(String name) {
        return LiteralArgumentBuilder.literal(name);
    }

    public void executeAction(String msg) {
        this.executeAction(AdditionServiceComponent.resolveMinecraftObject(msg));
    }

    public void executeAction(class_2561 msg) {
        class_5250 var15 = AdditionServiceComponent.resolveMinecraftObject2(AdditionServiceComponent.resolveMinecraftObject(AdditionServiceComponent.resolveMinecraftObject(), ">"), " ");
        var15.method_10852(msg);
        if (SharedKt.getMc().method_18854()) {
            SharedKt.getPlayer().method_7353((class_2561) var15, 0);
        }
        SharedKt.getMc().method_40000(this::updateValue);
    }

    private static void updateValue(class_5250 arg0) {
        SharedKt.getPlayer().method_7353((class_2561) arg0, 0);
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
