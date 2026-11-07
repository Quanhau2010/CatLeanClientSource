package su.catlean.client.features.modules.pvp.protect;

import java.io.PrintStream;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_1299;
import net.minecraft.class_1661;
import net.minecraft.class_2604;
import net.minecraft.class_2663;
import net.minecraft.class_2749;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.player.ExplosionPosEntityHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class MainhandTotemModule extends Module {

    public static final MainhandTotemModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 hpSetting;
    private static final VisibleVisibleSettingPropertyImpl pauseOnEatingSetting;
    private static final ServiceComponent10 serviceComponent10;

    private MainhandTotemModule() {
        super("mainhand-totem", SubCategoriesKt.getProtectCategory());
    }

    private float getHp() {
        return ((Number) hpSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getPauseOnEating() {
        return ((Boolean) pauseOnEatingSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        this.executeAction(this.computeValue());
        serviceComponent10.executeAction();
    }

    public void onReceivePacket(ReceivePacket e) {
        Packet packet = e.getPacket();
        if (__UNDEF_KEY__) {
        }
        if (__UNDEF_KEY__) {
            if (packet instanceof class_2604) {
                if (__UNDEF_KEY__) {
                    if (Intrinsics.areEqual(((class_2604) packet).method_11169(), class_1299.field_6110)) {
                        if (__UNDEF_KEY__) {
                            if ((this.computeValue() - ExplosionPosEntityHelper.computeValue(new Vec3d(((class_2604) packet).method_11175(), ((class_2604) packet).method_11174(), ((class_2604) packet).method_11176()), ((PlayerEntity) SharedKt.getPlayer()), 3, false, null, false)) <= this.getHp()) {
                                this.executeAction(this.computeValue());
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__) {
            if (packet instanceof class_2663) {
                if (__UNDEF_KEY__) {
                    if (((class_2663) packet).method_11470() == 35) {
                        if (__UNDEF_KEY__) {
                            if (Intrinsics.areEqual(((class_2663) packet).method_11469(((World) SharedKt.getWorld())), SharedKt.getPlayer())) {
                                this.executeAction(this.computeValue());
                            }
                        }
                    }
                }
            }
        }
        if (__UNDEF_KEY__) {
            if (__UNDEF_KEY__) {
                if (RunnableServiceComponent.INSTANCE.checkCondition() && packet instanceof class_2749 && this.computeValue() <= this.getHp()) {
                    this.executeAction(this.computeValue());
                    System.out.println(("Mainhand Totem Error: " + this.getLocalizedMessage()));
                }
            }
        }
    }

    private void executeAction(int arg0) {
        if (arg0 == -1) {
            return;
        }
        if (SharedKt.getPlayer().method_6115() && this.getPauseOnEating()) {
            return;
        }
        Item item = Items.field_8288;
        if (ItemPacketHelper.INSTANCE.computeValue(item) <= 1 && OffhandModule.INSTANCE.getEnabled()) {
            return;
        }
        ItemPacketHelper.INSTANCE.executeAction(arg0);
    }

    private int computeValue() {
        Item[] items = new Item[1];
        items[0] = Items.field_8288;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        if (stackServiceComponent2.isActive()) {
            if (stackServiceComponent2.getNumericValue() == SharedKt.getPlayer().method_31548().method_67532()) {
            } else {
            }
        }
        return stackServiceComponent2.getNumericValue();
    }

    private float computeValue() {
        return (SharedKt.getPlayer().method_6032() + SharedKt.getPlayer().method_6067());
    }

    static {
        KProperty[] items = new KProperty[2];
        INSTANCE = new MainhandTotemModule();
        hpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "hp", 16.0F, RangesKt.rangeTo(0.0F, 36.0F));
        pauseOnEatingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "pause-while-eating", false);
        serviceComponent10 = new ServiceComponent10();
    }

}
