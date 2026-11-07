package su.catlean.client.services.client;

import com.mojang.brigadier.CommandDispatcher;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.StringsKt;
import net.minecraft.class_1041;
import net.minecraft.class_3532;
import net.minecraft.class_7833;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import org.joml.Quaternionfc;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.InputSuggestorEvent;
import su.catlean.api.event.events.network.SendMessageEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.client.features.modules.render.esp.TracersModule;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.NewThemeRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class WHITEServiceComponent implements Contract9 {

    public static final WHITEServiceComponent INSTANCE;
    private static String textValue;
    private static BlockPos blockPos;
    private static final List itemList;
    private static final CommandDispatcher commandDispatcher;

    private WHITEServiceComponent() {
    }

    public String getString() {
        return textValue;
    }

    public void executeAction(String value) {
        textValue = value;
    }

    public BlockPos getMinecraftObject() {
        return blockPos;
    }

    public void updateValue(BlockPos value) {
        blockPos = value;
    }

    public List getList() {
        return itemList;
    }

    public CommandDispatcher getCommandDispatcher() {
        return commandDispatcher;
    }

    private void executeAction(DispatcherServiceComponent arg0) {
        arg0.executeAction(commandDispatcher);
        itemList.add(arg0);
    }

    private void onSendMessageEvent(SendMessageEvent arg0) {
        commandDispatcher.execute(arg0.getMessage().substring(textValue.length()), SharedKt.getMc().method_1562().method_2875());
        arg0.cancel();
    }

    private void onInputSuggestorEvent(InputSuggestorEvent arg0) {
        arg0.setSource(SharedKt.getMc().method_1562().method_2875());
        arg0.setPrefix(textValue);
        arg0.setDispatcher(commandDispatcher);
        arg0.cancel();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        int index = (SharedKt.getMc().method_22683().method_4486() / 2.0F);
        float factor = 40.0F;
        MatrixStack matrices = new MatrixStack();
        matrices.method_22903();
        matrices.method_46416(index, factor, 0.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40714.rotationDegrees(((90.0F / Math.abs((90.0F / Math.clamp(55.0F, SharedKt.getPlayer().method_36455(), 90.0F)))) - 102))));
        matrices.method_46416(index, factor, 0.0F);
        matrices.method_22903();
        double offset = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_6014, SharedKt.getPlayer().getX(), TextShaderComponent2.INSTANCE.computeValue());
        double offset2 = PolygonShaderComponent.INSTANCE.computeValue(SharedKt.getPlayer().field_5969, SharedKt.getPlayer().getZ(), TextShaderComponent2.INSTANCE.computeValue());
        double offset3 = (class_3532.method_15338((Math.toDegrees(Math.atan2((blockPos.method_10260() - offset2), (blockPos.method_10263() - offset))) - 90.0D)) - SharedKt.getPlayer().method_36454());
        matrices.method_46416(index, factor, 0.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(offset3)));
        matrices.method_46416(index, factor, 0.0F);
        TracersModule.INSTANCE.render(matrices, index, factor, 32.0F, NewThemeRenderHelper.INSTANCE.resolveColor(0));
        matrices.method_46416(index, factor, 0.0F);
        matrices.method_22907(((Quaternionfc) class_7833.field_40718.rotationDegrees(offset3)));
        matrices.method_46416(index, factor, 0.0F);
        matrices.method_22909();
        matrices.method_22909();
        String text = (this.computeValue(null, null, EventPacketHelper2.INSTANCE, blockPos.toCenterPos().field_1352, blockPos.toCenterPos().field_1350));
        float factor2 = SFMServiceComponent.resolveFontRenderHelper().computeValue(text);
        StackShaderComponent2.executeAction(arg0.getContext().method_51448(), ((index - (factor2 / 2.0F)) - 2.0F), 56.0F, (factor2 + 4.0F), 11.0F, 3.0F, 1.5F, 0.0F, 1.0F, NewThemeRenderHelper.INSTANCE.getColor5(), NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0.getContext(), text, index, 60.0F, Color.WHITE);
    }

    static {
        INSTANCE = new WHITEServiceComponent();
        textValue = "^";
        itemList = new ArrayList();
        commandDispatcher = new CommandDispatcher();
        INSTANCE.executeAction(((DispatcherServiceComponent) BindDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) FriendDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) CfgDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) GpsDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) FixallDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) AngleDispatcherServiceComponentImpl.INSTANCE));
        INSTANCE.executeAction(((DispatcherServiceComponent) EasingsdebugDispatcherServiceComponentImpl.INSTANCE));
    }

}
