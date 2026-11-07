package su.catlean.client.features.modules.utility.player;

import java.util.concurrent.ExecutorService;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.random.Random.Default;
import kotlin.reflect.KProperty;
import net.minecraft.class_1661;
import net.minecraft.class_1787;
import net.minecraft.class_2767;
import net.minecraft.class_2945;
import net.minecraft.class_3417;
import net.minecraft.class_6880;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.HandServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.RunnableServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent100;
import su.catlean.client.services.client.ServiceComponent123;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.VisibleRenderHelper;

public class AutoFishModule extends Module {

    public static final AutoFishModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 detectModeSetting;
    private static final VisibleVisibleSettingPropertyImpl rodSaveSetting;
    private static final VisibleVisibleSettingPropertyImpl changeRodSetting;
    private static final VisibleVisibleSettingPropertyImpl legitSetting;
    private static boolean enabledFlag;
    private static final ServiceComponent10 serviceComponent10;
    private static final ServiceComponent10 serviceComponent102;

    private AutoFishModule() {
        super("auto-fish", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private AutoFishDetectMode getDetectMode() {
        return ((AutoFishDetectMode) detectModeSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getRodSave() {
        return ((Boolean) rodSaveSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getChangeRod() {
        return ((Boolean) changeRodSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getLegit() {
        return ((Boolean) legitSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    public void updateValue2() {
        enabledFlag = 0;
    }

    private void onReceivePacket(ReceivePacket arg0) {
        this.updateValue();
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (SharedKt.getPlayer().method_6047().getItem() instanceof class_1787 && SharedKt.getPlayer().method_6047().method_7919() > 52 && this.getRodSave()) {
            if (this.getChangeRod() && this.computeValue() != -1) {
                MessageServiceComponent.S(this, MessageServiceComponent.Z(this, "swapped", new Object[0], false), false);
                ItemPacketHelper.INSTANCE.executeAction(this.computeValue());
                serviceComponent102.executeAction();
            } else {
                this.executeAction(MessageServiceComponent.Z(this, "almost-broken", new Object[0], false));
            }
        }
        if (!(serviceComponent102.checkCondition(1000))) {
            return;
        }
        if (serviceComponent10.checkCondition(45000) && SharedKt.getPlayer().method_6047().getItem() instanceof class_1787) {
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            serviceComponent10.executeAction();
            serviceComponent102.executeAction();
        }
        boolean flag = ((Boolean) SharedKt.getPlayer().field_7513.method_5841().method_12789(FishingBobberEntity.field_23234));
        if (!(enabledFlag) && flag) {
            this.updateValue();
            enabledFlag = 1;
        } else {
            enabledFlag = 0;
        }
    }

    private void updateValue() {
        double offset = ((Random.Default.nextDouble() * 150.0D) + 200.0D);
        RunnableServiceComponent runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        double offset2 = offset;
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent123(offset2)));
        runnableServiceComponent = RunnableServiceComponent.INSTANCE;
        offset2 = (offset * 2);
        runnableServiceComponent.getExecutorService().execute(((Runnable) new ServiceComponent100(offset2)));
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        serviceComponent10.executeAction();
    }

    private int computeValue() {
        int index = 0;
        if (index < 9) {
            if (__UNDEF_KEY__ != null) {
                if (__UNDEF_KEY__ != null) {
                }
                if (__UNDEF_KEY__ != null) {
                    if (Intrinsics.areEqual(SharedKt.getPlayer().method_31548().method_5438(index).getItem(), Items.field_8378) && SharedKt.getPlayer().method_31548().method_5438(index).method_7919() < 52) {
                        return index;
                    }
                }
            }
        }
        return -1;
    }

    public static ServiceComponent10 getServiceComponent10() {
        return serviceComponent10;
    }

    static {
        KProperty[] items = new KProperty[4];
        INSTANCE = new AutoFishModule();
        detectModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "detect-mode", AutoFishDetectMode.V1_17);
        rodSaveSetting = VisibleRenderHelper.registerSetting(INSTANCE, "rod-save", true);
        changeRodSetting = VisibleRenderHelper.registerSetting(INSTANCE, "change-rod", false);
        legitSetting = VisibleRenderHelper.registerSetting(INSTANCE, "legit", true);
        serviceComponent10 = new ServiceComponent10();
        serviceComponent102 = new ServiceComponent10();
    }

}
