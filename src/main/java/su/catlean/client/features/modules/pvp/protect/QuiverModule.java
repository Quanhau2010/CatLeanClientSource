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
        SequenceServiceComponent.INSTANCE.executeAction(new RotationServiceComponent4(0, this::getUnit));
    }

    private boolean checkCondition(int arg0, char arg1, char arg2) {
        Iterable iterable = ((Iterable) new IntRange(0, 35));
        int index = 0;
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        int index2 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            int index3 = ((IntIterator) iterator).nextInt();
            int index4 = index3;
            if (arg2 >= 0) {
                if (__UNDEF_KEY__) {
                    ItemStack stack = SharedKt.getPlayer().method_31548().method_5438(index4);
                    if (stack.getItem() instanceof class_1744) {
                    }
                    collection.add();
                    if (arg0 >= 0) {
                    }
                }
            }
        }
        List list = CollectionsKt.filterNotNull(((Iterable) collection));
        if (__UNDEF_KEY__) {
            if (list.isEmpty()) {
                return false;
            }
        }
        index = ((Iterable) list);
        iterable2 = 0;
        collection = index.iterator();
        if (__UNDEF_KEY__) {
            if (!(collection.hasNext())) {
            }
        }
        index2 = collection.next();
        if (__UNDEF_KEY__) {
            if (!(collection.hasNext())) {
            }
        }
        iterator = ((ServiceComponent84) index2);
        index3 = 0;
        iterator = iterator.getNumericValue();
        index3 = collection.next();
        index4 = ((ServiceComponent84) index3);
        index4 = index4.getNumericValue();
        if (iterator > index4) {
            index2 = index3;
            iterator = index4;
        }
        iterable = ((ServiceComponent84) index2).getNumericValue();
        index = list.iterator();
        while (index.hasNext()) {
            iterable2 = ((ServiceComponent84) index.next());
            if (arg1 >= 0) {
                if (__UNDEF_KEY__) {
                    if (iterable2.getNumericValue() != iterable) {
                        HandServiceComponent.e(iterable2.getNumericValue(), 0, null, false);
                        HandServiceComponent.e(iterable, 0, null, false);
                        HandServiceComponent.e(iterable2.getNumericValue(), 0, null, true);
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean checkCondition(ServiceComponent84 arg0) {
        if (arg0.getMinecraftObject() != null) {
        }
        arg0.getMinecraftObject().method_5579();
        if (Intrinsics.areEqual(null, class_1294.field_5910)) {
            if (SharedKt.getMc().player != null) {
                if (!(SharedKt.getMc().player.method_6059(class_1294.field_5910))) {
                } else {
                }
                if (0 == 1) {
                }
            } else {
            }
            if (!(0)) {
                if (arg0.getMinecraftObject() != null) {
                }
                arg0.getMinecraftObject().method_5579();
                if (SharedKt.getMc().player != null) {
                    if (!(SharedKt.getMc().player.method_6059(class_1294.field_5904))) {
                    } else {
                    }
                    if (0 == 1) {
                    }
                } else {
                }
                if (Intrinsics.areEqual(null, class_1294.field_5904) && 0) {
                }
            }
        }
        return false;
    }

    private static Unit getUnit() {
        PacketPacketHelper.handlePacket(((Packet) new class_2846(class_2847.field_12974, BlockPos.field_10980, SharedKt.getPlayer().method_5735())));
        SharedKt.getPlayer().method_6075();
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new QuiverModule();
    }

}
