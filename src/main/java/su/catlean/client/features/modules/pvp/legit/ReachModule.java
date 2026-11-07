package su.catlean.client.features.modules.pvp.legit;

import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import su.catlean.api.event.events.player.ReachStateEvent;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.VisibleRenderHelper;

public class ReachModule extends Module {

    public static final ReachModule INSTANCE;
    private static final RangeVisibleSettingPropertyImpl2 blocksRangeSetting;
    private static final RangeVisibleSettingPropertyImpl2 entitySetting;

    private ReachModule() {
        super("reach", SubCategoriesKt.getLegitCategory());
    }

    private float getBlocksRange() {
        return (Number) blocksRangeSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private float getEntity() {
        return (Number) entitySetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private void onReachStateEvent(ReachStateEvent arg0) {
        arg0.setBlockRange(this.getBlocksRange());
        arg0.setEntityRange(this.getEntity());
        arg0.cancel();
    }

    static {
        KProperty[] var26 = new KProperty[2];
        INSTANCE = new ReachModule();
        blocksRangeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "blocks-range", 3.0F, RangesKt.rangeTo(0.1F, 10.0F), null, null, 6742912154355105816L);
        entitySetting = VisibleRenderHelper.registerSetting(INSTANCE, "entity-range", 3.0F, RangesKt.rangeTo(0.1F, 10.0F), null, null, -590771634873303016L);
    }

}
