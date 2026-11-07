package su.catlean.client.features.modules.utility.player;

import java.awt.Color;
import java.util.Collection;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.class_10182;
import net.minecraft.class_2602;
import net.minecraft.class_2708;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.network.ReceivePacket;
import su.catlean.api.event.events.player.FinishUsingItemEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.TextShaderComponent2;

public class ChorusDelayModule extends Module {

    public static final ChorusDelayModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl2 confirmSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static boolean enabledFlag;
    private static final LinkedList linkedList;

    private ChorusDelayModule() {
        super("chorus-delay", SubCategoriesKt.getPlayerUtilityCategory());
    }

    private KeyRecord getConfirm() {
        return (KeyRecord) confirmSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    public void updateValue() {
        linkedList.clear();
        enabledFlag = 0;
    }

    public void updateValue2(long arg0) {
        long var3 = ((arg0 ^ 97978716797187L) >>> 32);
        long var4 = (((arg0 ^ 97978716797187L) << 32) >>> 48);
        long var5 = (((arg0 ^ 97978716797187L) << 48) >>> 48);
        this.executeAction();
    }

    public void onRender3DEvent(Render3DEvent e) {
        int var9 = 4;
        Color var11 = this.getColor();
        Box var12 = new Box((class_2708) CollectionsKt.first(linkedList).comp_3228().comp_3148().method_1031(-0.27D, 0.0D, -0.27D), (class_2708) CollectionsKt.first(linkedList).comp_3228().comp_3148().method_1031(0.27D, 1.8D, 0.27D));
        TextShaderComponent2.checkCondition();
    }

    public void onInputEvent(InputEvent e) {
        if (var9 == null) {
        }
        if (e.getKey() == this.getConfirm().getNumericValue() && e.getAction() == Action.Release) {
            this.executeAction();
        }
    }

    public void onReceivePacket(ReceivePacket e) {
        if (!(enabledFlag)) {
        }
        linkedList.add((class_2708) e.getPacket());
        e.cancel();
    }

    private void onFinishUsingItemEvent(FinishUsingItemEvent arg0) {
        enabledFlag = 1;
    }

    private void executeAction(short arg0) {
        enabledFlag = 0;
        if (!(linkedList.isEmpty())) {
            (class_2708) linkedList.poll().method_11740((class_2602) SharedKt.getNetwork());
        }
    }

    static {
        KProperty[] var32 = new KProperty[2];
        INSTANCE = new ChorusDelayModule();
        confirmSetting = VisibleRenderHelper.registerSetting(INSTANCE, "confirm", new KeyRecord(7570150686952784212L, 0, 0, 689587429216092166L), null, null, -8482684791852892148L);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "color", new Color(3253805521966202879L), null, null, 2858437878088728588L);
        linkedList = new LinkedList();
    }

}
