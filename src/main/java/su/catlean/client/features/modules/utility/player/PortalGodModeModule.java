package su.catlean.client.features.modules.utility.player;

import kotlin.jvm.internal.Intrinsics;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_2793;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.SendPacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.module.category.SubCategoriesKt;

public class PortalGodModeModule extends Module {

    public static final PortalGodModeModule INSTANCE;
    private static final ServiceComponent10 serviceComponent10;

    private PortalGodModeModule() {
        super("portal-god-mode", SubCategoriesKt.getPlayerUtilityCategory());
    }

    public void onSendPacket(SendPacket e) {
        if (e.getPacket() instanceof class_2793 && serviceComponent10.getNumericValue() < 5000L) {
            e.cancel();
        }
    }

    public void onPlayerUpdateEvent(PlayerUpdateEvent e) {
        double var9 = (SharedKt.getPlayer().getX() - 2);
        double var10 = (SharedKt.getPlayer().getX() + 2);
        double var11 = (SharedKt.getPlayer().getZ() - 2);
        double var12 = (SharedKt.getPlayer().getZ() + 2);
        if (var11 < var12) {
            double var13 = (SharedKt.getPlayer().getY() - 2);
            double var14 = (SharedKt.getPlayer().getY() + 2);
            if (var13 < var14) {
                if (Intrinsics.areEqual(SharedKt.getWorld().getBlockState(BlockPos.method_49637()).getBlock(), Blocks.field_10316)) {
                    serviceComponent10.executeAction();
                }
            }
        }
    }

    static {
        INSTANCE = new PortalGodModeModule();
        serviceComponent10 = new ServiceComponent10();
        serviceComponent10.updateValue();
    }

}
