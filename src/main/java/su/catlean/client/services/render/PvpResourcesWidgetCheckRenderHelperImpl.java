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
        return (Boolean) totemsSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private boolean getCrystals() {
        return (Boolean) crystalsSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getGapples() {
        return (Boolean) gapplesSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getCrapples() {
        return (Boolean) crapplesSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getFireworks() {
        return (Boolean) fireworksSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getXp() {
        return (Boolean) xpSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getObby() {
        return (Boolean) obbySetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 50910300018319L);
        long var6 = (0L ^ 124694419039781L);
        long var8 = (0L ^ 7291883418847L);
        long var10 = ((0L ^ 58809736933323L) >>> 16);
        long var12 = (((0L ^ 58809736933323L) << 48) >>> 48);
        long var13 = ((0L ^ 95600647083779L) >>> 32);
        long var14 = (((0L ^ 95600647083779L) << 32) >>> 48);
        long var15 = (((0L ^ 95600647083779L) << 48) >>> 48);
        long var16 = (0L ^ 118028023098805L);
        long var18 = ((0L ^ 104104530525409L) >>> 48);
        long var19 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var20 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var21 = (0L ^ 122621818626690L);
        long var23 = (0L ^ 38698685614388L);
        long var25 = (0L ^ 37502280442033L);
        long var27 = (0L ^ 20173347401993L);
        long var29 = (0L ^ 58410826854445L);
        long var31 = (0L ^ 99949442920536L);
        long var33 = (0L ^ 38163162552857L);
        long var35 = (0L ^ 30591967126976L);
        int var43 = 2;
        List positions = new ArrayList();
        if (this.getTotems()) {
            positions.add(Items.field_8288);
        }
        if (0L > 0L) {
            if (!(var42)) {
                if (this.getCrystals()) {
                    positions.add(Items.field_8301);
                }
            }
        }
        if (0L > 0L) {
            if (!(var42)) {
                if (this.getXp()) {
                    positions.add(Items.field_8287);
                }
            }
        }
        if (0L >= 0L) {
            if (!(var42)) {
                if (this.getGapples()) {
                    positions.add(Items.field_8367);
                }
            }
        }
        if (0L >= 0L) {
            if (!(var42)) {
                if (this.getCrapples()) {
                    positions.add(Items.field_8463);
                }
            }
            if (0L > 0L) {
            }
            if (this.getFireworks()) {
                positions.add(Items.FIREWORK_ROCKET);
            }
            if (0L > 0L) {
            }
            if (0L > 0L) {
                if (this.getObby()) {
                }
                positions.add(Items.field_8281);
            }
            CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), (1.0F + (20.0F * positions.size())), 29.0F, 0.0F);
            context.method_51448().pushMatrix();
            context.method_51448().translate(this.computeValue(), this.computeValue2());
        }
        Iterator iterator = positions.iterator();
        while (iterator.hasNext()) {
            Item var46 = (Item) iterator.next();
            if (0L >= 0L) {
            }
            if (!(Intrinsics.areEqual(CollectionsKt.last(positions)))) {
                CheckRenderHelper.executeAction(this, context.method_51448(), (var43 + 17.5F), 7.0F, 0.0F);
            }
            context.method_51427(var46.method_7854(), 2);
            int var47 = ItemPacketHelper.computeValue();
            if (var47 > 0) {
            } else {
            }
            String var48 = "-";
            int var38 = 96;
            int var39 = 0;
            int var40 = 0;
            Color var41 = Color.WHITE;
            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), context.method_51448(), ((var43 + 8.0F) - (SFMServiceComponent.resolveFontRenderHelper().computeValue() / 2.0F)), 18.0F);
        }
        context.method_51448().popMatrix();
        this.executeAction((1.0F + (positions.size() * 20.0F)), 29.0F);
    }

    public void render(DrawContext context) {
        long var4 = ((0L ^ 1549896540735L) >>> 32);
        long var5 = (((0L ^ 1549896540735L) << 32) >>> 48);
        long var6 = (((0L ^ 1549896540735L) << 48) >>> 48);
        long var7 = (0L ^ 26980051417349L);
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    static {
        KProperty[] var26 = new KProperty[7];
        INSTANCE = new PvpResourcesWidgetCheckRenderHelperImpl();
        totemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totems");
        crystalsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crystals");
        gapplesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gapples");
        crapplesSetting = VisibleRenderHelper.registerSetting(INSTANCE, "crapples");
        fireworksSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fireworks");
        xpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "xp");
        obbySetting = VisibleRenderHelper.registerSetting(INSTANCE, "obby");
    }

}
