package su.catlean.client.features.modules.pvp.protect;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import net.minecraft.class_1293;
import net.minecraft.class_1294;
import net.minecraft.class_1661;
import net.minecraft.class_1744;
import net.minecraft.class_1844;
import net.minecraft.class_2846;
import net.minecraft.class_2846.class_2847;
import net.minecraft.class_9334;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.BlockPos;
import su.catlean.SharedKt;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MoveFixServiceComponent;
import su.catlean.client.services.client.RotationServiceComponent4;
import su.catlean.client.services.client.SequenceServiceComponent;
import su.catlean.client.services.client.ServiceComponent84;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.PacketPacketHelper;

public class QuiverModule extends Module {

    public static final QuiverModule INSTANCE;

    private QuiverModule() {
        super("Quiver", SubCategoriesKt.getProtectCategory());
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (!(var15)) {
        }
        if (!(var15)) {
        }
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(new MoveFixServiceComponent(SharedKt.getPlayer().method_36455(), -90.0F), 0, this::getUnit));
    }

    private boolean checkCondition(int arg0, char arg1, char arg2) {
        Iterable var14 = (Iterable) new IntRange(0, 35);
        int var15 = 0;
        Object var16 = var14;
        Collection var17 = (Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(10));
        int var18 = 0;
        Iterator iterator = var16.iterator();
        if (iterator.hasNext()) {
            int var20 = (IntIterator) iterator.nextInt();
            int var21 = var20;
            Object var24 = var17;
            int var22 = 0;
            if (arg2 >= 0) {
                if (var12) {
                }
                ItemStack stack = SharedKt.getPlayer().method_31548().method_5438();
                if (stack.getItem() instanceof class_1744) {
                }
                var24.add();
            }
            if (arg0 >= 0) {
            }
        }
        List positions = CollectionsKt.filterNotNull((Iterable) var17);
        if (var12) {
            if (positions.isEmpty()) {
                return false;
            }
        }
        var15 = (Iterable) positions;
        var16 = 0;
        var17 = var15.iterator();
        if (var12) {
            if (!(var17.hasNext())) {
            }
        }
        var18 = var17.next();
        if (var12) {
            if (!(var17.hasNext())) {
            }
        }
        iterator = (ServiceComponent84) var18;
        var20 = 0;
        iterator = iterator.getNumericValue();
        var20 = var17.next();
        var21 = (ServiceComponent84) var20;
        var22 = 0;
        var21 = var21.getNumericValue();
        if (iterator > var21) {
            var18 = var20;
            iterator = var21;
        }
        var14 = (ServiceComponent84) var18.getNumericValue();
        var15 = positions.iterator();
        if (var15.hasNext()) {
            var16 = (ServiceComponent84) var15.next();
            if (arg1 >= 0) {
                if (var12) {
                }
                if (var16.getNumericValue() != var14) {
                    HandServiceComponent.e(var16.getNumericValue());
                    HandServiceComponent.e();
                    HandServiceComponent.e(var16.getNumericValue());
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkCondition(ServiceComponent84 arg0) {
        if (!(var6)) {
            if (arg0.getMinecraftObject() != null) {
            }
            arg0.getMinecraftObject().method_5579();
        }
        if (Intrinsics.areEqual(null, class_1294.field_5910)) {
            if (SharedKt.getMc().player != null) {
                if (!(var6)) {
                    if (!(SharedKt.getMc().player.method_6059(class_1294.field_5910))) {
                    }
                } else {
                }
                if (0 == 1) {
                }
            } else {
            }
            if (!(0)) {
            }
            if (arg0.getMinecraftObject() != null) {
            }
            arg0.getMinecraftObject().method_5579();
            if (SharedKt.getMc().player != null) {
                if (!(var6)) {
                    if (!(SharedKt.getMc().player.method_6059(class_1294.field_5904))) {
                    }
                } else {
                }
                if (0 == 1) {
                }
            } else {
            }
            if (Intrinsics.areEqual(null, class_1294.field_5904) && 0) {
            }
        }
        return false;
    }

    private static Unit getUnit() {
        PacketPacketHelper.handlePacket((Packet) new class_2846(class_2847.field_12974, BlockPos.field_10980, SharedKt.getPlayer().method_5735()));
        SharedKt.getPlayer().method_6075();
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new QuiverModule();
    }

}
