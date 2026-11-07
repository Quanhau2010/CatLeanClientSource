package su.catlean.client.services.client;

import com.viaversion.viaversion.api.Via;
import com.viaversion.viaversion.api.ViaManager;
import com.viaversion.viaversion.api.connection.ConnectionManager;
import com.viaversion.viaversion.api.connection.ProtocolInfo;
import com.viaversion.viaversion.api.connection.UserConnection;
import com.viaversion.viaversion.api.protocol.ProtocolPipeline;
import com.viaversion.viaversion.api.protocol.packet.PacketType;
import com.viaversion.viaversion.api.protocol.packet.PacketWrapper;
import com.viaversion.viaversion.api.type.Type;
import com.viaversion.viaversion.api.type.Types;
import com.viaversion.viaversion.protocols.v1_21_4to1_21_5.packet.ServerboundPackets1_21_5;
import com.viaversion.viaversion.protocols.v1_21_5to1_21_6.Protocol1_21_5To1_21_6;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_2851;
import net.minecraft.class_744;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.network.packet.Packet;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.network.PacketPacketHelper;

public class ViafabricplusServiceComponent {

    public static final ViafabricplusServiceComponent INSTANCE;
    private static String[] textValueArray;

    private ViafabricplusServiceComponent() {
    }

    public void executeAction(boolean value) {
        if (var15 != null) {
        }
        if ((UserConnection) CollectionsKt.firstOrNull((Iterable) Via.getManager().getConnectionManager().getConnections()) != null) {
            if ((UserConnection) CollectionsKt.firstOrNull((Iterable) Via.getManager().getConnectionManager().getConnections()).getProtocolInfo() != null) {
                if ((UserConnection) CollectionsKt.firstOrNull((Iterable) Via.getManager().getConnectionManager().getConnections()).getProtocolInfo().getPipeline() != null) {
                }
            }
        }
        boolean var16 = 0;
        if (var15 != null) {
            if (!(var16)) {
                int var13 = value;
                class_744 var14 = SharedKt.getPlayer().field_3913;
                PacketPacketHelper.handlePacket((Packet) new class_2851(ServiceComponent127.resolveMinecraftObject().field_54155));
            }
            if (var15 == null) {
            }
            Object var17 = this;
            ViafabricplusServiceComponent var18 = (ViafabricplusServiceComponent) var17;
            int var19 = 0;
            PacketWrapper var20 = PacketWrapper.create((PacketType) ServerboundPackets1_21_5.PLAYER_COMMAND, (UserConnection) CollectionsKt.firstOrNull((Iterable) Via.getManager().getConnectionManager().getConnections()));
            var20.write((Type) Types.VAR_INT, Integer.valueOf(SharedKt.getPlayer().method_5628()));
            if (var15 != null) {
                if (value) {
                }
            } else {
            }
            (Type) Types.VAR_INT.write(0, Integer.valueOf(1));
            var20.write((Type) Types.VAR_INT, Integer.valueOf(0));
            var20.scheduleSendToServer(Protocol1_21_5To1_21_6.class);
            var18 = Result.constructor-impl(Unit.INSTANCE);
            var19 = var20;
            var18 = Result.constructor-impl(ResultKt.createFailure());
            Result.box-impl();
        }
        SharedKt.getPlayer().method_5660(value);
        SharedKt.getMc().options.field_1832.method_23481(value);
    }

    static {
        INSTANCE = new ViafabricplusServiceComponent();
    }

    public static void updateValue(String[] arg0) {
        textValueArray = arg0;
    }

    public static String[] process() {
        return textValueArray;
    }

}
