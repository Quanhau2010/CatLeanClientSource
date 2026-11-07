package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.joml.Matrix3x2fStack;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.network.ItemPacketHelper;

public class PvpResourcesWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PvpResourcesWidgetCheckRenderHelperImpl INSTANCE;
    private static final VisibleVisibleSettingPropertyImpl totemsSetting;
    private static final VisibleVisibleSettingPropertyImpl crystalsSetting;
    private static final VisibleVisibleSettingPropertyImpl gapplesSetting;
    private static final VisibleVisibleSettingPropertyImpl crapplesSetting;
    private static final VisibleVisibleSettingPropertyImpl fireworksSetting;
    private static final VisibleVisibleSettingPropertyImpl xpSetting;
    private static final VisibleVisibleSettingPropertyImpl obbySetting;

    private PvpResourcesWidgetCheckRenderHelperImpl() {
        super("pvp-resources-widget");
    }

    private boolean getTotems() {
        return ((Boolean) totemsSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private boolean getCrystals() {
        return ((Boolean) crystalsSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getGapples() {
        return ((Boolean) gapplesSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getCrapples() {
        return ((Boolean) crapplesSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getFireworks() {
        return ((Boolean) fireworksSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getXp() {
        return ((Boolean) xpSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getObby() {
        return ((Boolean) obbySetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    public void render(DrawContext context) {
        int index = 2;
        List list = new ArrayList();
        if (this.getTotems()) {
            list.add(Items.field_8288);
        }
        if (this.getCrystals()) {
            list.add(Items.field_8301);
        }
        if (this.getXp()) {
            list.add(Items.field_8287);
        }
        if (this.getGapples()) {
            list.add(Items.field_8367);
        }
        if (this.getCrapples()) {
            list.add(Items.field_8463);
        }
        if (this.getFireworks()) {
            list.add(Items.FIREWORK_ROCKET);
        }
        if (this.getObby()) {
            list.add(Items.field_8281);
        }
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), (1.0F + (20.0F * list.size())), 29.0F, 0.0F, false);
        context.method_51448().pushMatrix();
        context.method_51448().translate(this.computeValue(), this.computeValue2());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Item item = ((Item) iterator.next());
            if (!(Intrinsics.areEqual(item, CollectionsKt.last(list)))) {
                CheckRenderHelper.executeAction(this, context.method_51448(), (index + 17.5F), 7.0F, 0.0F);
            }
            context.method_51427(item.method_7854(), index, 2);
            int index2 = ItemPacketHelper.computeValue(item, false);
            if (index2 > 0) {
            } else {
            }
            String text = "-";
            int index3 = 96;
            int index4 = 0;
            int index5 = 0;
            Color color = Color.WHITE;
            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), context.method_51448(), text, ((index + 8.0F) - (SFMServiceComponent.resolveFontRenderHelper().computeValue(text) / 2.0F)), 18.0F, color, index5, index4, index3);
        }
        context.method_51448().popMatrix();
        this.executeAction((1.0F + (list.size() * 20.0F)), 29.0F);
    }

    public void render(DrawContext context) {
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    static {
        KProperty[] items = new KProperty[7];
        INSTANCE = new PvpResourcesWidgetCheckRenderHelperImpl();
        totemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totems", true);
        crystalsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystals", true);
        gapplesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapples", true);
        crapplesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crapples", false);
        fireworksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fireworks", true);
        xpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "xp", true);
        obbySetting = VisibleRenderHelper.registerSetting(INSTANCE, "obby", false);
    }

}
