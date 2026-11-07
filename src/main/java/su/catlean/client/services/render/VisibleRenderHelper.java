package su.catlean.client.services.render;

import java.awt.Color;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import su.catlean.api.contracts.Contract5;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl2;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl3;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl4;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl5;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl6;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl8;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.SettingIdVisibleSettingPropertyImpl;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ActionServiceComponent2;
import su.catlean.client.services.client.BlocksServiceComponent;
import su.catlean.client.services.client.EntitiesServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.TextServiceComponent;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.client.config.models.XRecord;
import su.catlean.client.types.OptionMode14;

public class VisibleRenderHelper {

    private static boolean enabledFlag;

    public static VisibleVisibleSettingPropertyImpl resolveVisibleVisibleSettingPropertyImpl(Contract5 receiver, String id, boolean defaultValue, SettingGroup group, Function0 visible) {
        VisibleVisibleSettingPropertyImpl var9 = new VisibleVisibleSettingPropertyImpl(id, defaultValue, group, visible);
        return var9;
    }

    public static RangeVisibleSettingPropertyImpl resolveRangeVisibleSettingPropertyImpl(Contract5 receiver, String id, int defaultValue, IntRange range, SettingGroup group, Function0 visible) {
        RangeVisibleSettingPropertyImpl var10 = new RangeVisibleSettingPropertyImpl(id, defaultValue, range, group, visible);
        return var10;
    }

    public static RangeVisibleSettingPropertyImpl2 resolveRangeVisibleSettingPropertyImpl2(Contract5 receiver, String id, float defaultValue, ClosedFloatingPointRange range, SettingGroup group, Function0 visible) {
        RangeVisibleSettingPropertyImpl2 var10 = new RangeVisibleSettingPropertyImpl2(id, defaultValue, range, group, visible);
        return var10;
    }

    public static SettingIdVisibleSettingPropertyImpl resolveSettingIdVisibleSettingPropertyImpl(Contract5 receiver, String id, String defaultValue, SettingGroup group, Function0 visible) {
        SettingIdVisibleSettingPropertyImpl var12 = new SettingIdVisibleSettingPropertyImpl(id, defaultValue, group, visible);
        return var12;
    }

    public static DefaultValueVisibleSettingPropertyImpl2 resolveDefaultValueVisibleSettingPropertyImpl2(Contract5 receiver, String id, KeyRecord defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl2 var9 = new DefaultValueVisibleSettingPropertyImpl2(id, defaultValue, visible);
        var9.updateValue(group);
        return var9;
    }

    public static DefaultValueVisibleSettingPropertyImpl10 resolveDefaultValueVisibleSettingPropertyImpl10(Contract5 receiver, String id, Enum defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl10 var9 = new DefaultValueVisibleSettingPropertyImpl10(id, defaultValue, group, visible);
        return var9;
    }

    public static DefaultValueVisibleSettingPropertyImpl5 resolveDefaultValueVisibleSettingPropertyImpl5(Contract5 receiver, String id, XRecord defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl5 var9 = new DefaultValueVisibleSettingPropertyImpl5(id, defaultValue, group, visible);
        receiver.getList().add();
        return var9;
    }

    public static DefaultValueVisibleSettingPropertyImpl9 resolveDefaultValueVisibleSettingPropertyImpl9(Contract5 receiver, String id, Color defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl9 var9 = new DefaultValueVisibleSettingPropertyImpl9(id, defaultValue, group, visible);
        receiver.getList().add();
        return var9;
    }

    public static DefaultValueVisibleSettingPropertyImpl3 resolveDefaultValueVisibleSettingPropertyImpl3(Contract5 receiver, String id, BlocksServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl3 var12 = new DefaultValueVisibleSettingPropertyImpl3(id, defaultValue, group, visible);
        receiver.getList().add();
        return var12;
    }

    public static DefaultValueVisibleSettingPropertyImpl6 resolveDefaultValueVisibleSettingPropertyImpl6(Contract5 receiver, String id, EntitiesServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl6 var12 = new DefaultValueVisibleSettingPropertyImpl6(id, defaultValue, group, visible);
        receiver.getList().add();
        return var12;
    }

    public static DefaultValueVisibleSettingPropertyImpl8 resolveDefaultValueVisibleSettingPropertyImpl8(Contract5 receiver, String id, ItemsServiceComponent2 defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl8 var12 = new DefaultValueVisibleSettingPropertyImpl8(id, defaultValue, group, visible);
        receiver.getList().add();
        return var12;
    }

    public static DefaultValueVisibleSettingPropertyImpl resolveDefaultValueVisibleSettingPropertyImpl(Contract5 receiver, String id, Function0 defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl var15 = new DefaultValueVisibleSettingPropertyImpl(id, new ActionServiceComponent2(defaultValue), group, visible);
        receiver.getList().add();
        return var15;
    }

    public static DefaultValueVisibleSettingPropertyImpl4 resolveDefaultValueVisibleSettingPropertyImpl4(Contract5 receiver, String id, TextServiceComponent defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl4 var10 = new DefaultValueVisibleSettingPropertyImpl4(id, defaultValue, group, visible);
        receiver.getList().add();
        return var10;
    }

    public static DefaultValueVisibleSettingPropertyImpl7 resolveDefaultValueVisibleSettingPropertyImpl7(Contract5 receiver, String id, OptionMode14 type, Function0 visible) {
        SettingGroup var10 = new SettingGroup(0, type);
        DefaultValueVisibleSettingPropertyImpl7 var11 = new DefaultValueVisibleSettingPropertyImpl7(id, visible);
        receiver.getList().add();
        return var11;
    }

    public static DefaultValueVisibleSettingPropertyImpl7 resolveDefaultValueVisibleSettingPropertyImpl7(Module parent, String id, OptionMode14 type, Function0 visible) {
        SettingGroup var13 = new SettingGroup(0, type);
        DefaultValueVisibleSettingPropertyImpl7 var14 = new DefaultValueVisibleSettingPropertyImpl7(id, visible);
        return var14;
    }

    public static RangeVisibleSettingPropertyImpl2 resolveRangeVisibleSettingPropertyImpl2(Module parent, String id, float defaultValue, ClosedFloatingPointRange range, SettingGroup group, Function0 visible) {
        RangeVisibleSettingPropertyImpl2 var10 = new RangeVisibleSettingPropertyImpl2(id, defaultValue, range, group, visible);
        return var10;
    }

    public static RangeVisibleSettingPropertyImpl resolveRangeVisibleSettingPropertyImpl(Module parent, String id, int defaultValue, IntRange range, SettingGroup group, Function0 visible) {
        RangeVisibleSettingPropertyImpl var10 = new RangeVisibleSettingPropertyImpl(id, defaultValue, range, group, visible);
        return var10;
    }

    public static VisibleVisibleSettingPropertyImpl resolveVisibleVisibleSettingPropertyImpl(Module parent, String id, boolean defaultValue, SettingGroup group, Function0 visible) {
        VisibleVisibleSettingPropertyImpl var12 = new VisibleVisibleSettingPropertyImpl(id, defaultValue, group, visible);
        return var12;
    }

    public static DefaultValueVisibleSettingPropertyImpl10 resolveDefaultValueVisibleSettingPropertyImpl10(Module parent, String id, Enum defaultValue, SettingGroup group, Function0 visible) {
        DefaultValueVisibleSettingPropertyImpl10 var12 = new DefaultValueVisibleSettingPropertyImpl10(id, defaultValue, group, visible);
        return var12;
    }

    private static boolean isActive() {
        return true;
    }

    private static boolean isActive2() {
        return true;
    }

    private static boolean isActive3() {
        return true;
    }

    private static boolean isActive4() {
        return true;
    }

    private static boolean isActive5() {
        return true;
    }

    private static boolean isActive6() {
        return true;
    }

    private static boolean isActive7() {
        return true;
    }

    private static boolean isActive8() {
        return true;
    }

    private static boolean isActive9() {
        return true;
    }

    private static boolean isActive10() {
        return true;
    }

    private static boolean isActive11() {
        return true;
    }

    private static boolean isActive12() {
        return true;
    }

    private static boolean isActive13() {
        return true;
    }

    private static boolean isActive14() {
        return true;
    }

    private static boolean isActive15() {
        return true;
    }

    private static boolean isActive16() {
        return true;
    }

    private static boolean isActive17() {
        return true;
    }

    private static boolean isActive18() {
        return true;
    }

    private static boolean isActive19() {
        return true;
    }

    public static void updateValue(boolean arg0) {
        enabledFlag = arg0;
    }

    public static boolean isActive20() {
        return enabledFlag;
    }

    public static boolean isActive21() {
        return true;
        return false;
    }

}
