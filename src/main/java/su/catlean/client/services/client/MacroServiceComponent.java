package su.catlean.client.services.client;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;
import net.minecraft.block.Block;
import net.minecraft.class_1661;
import net.minecraft.class_1713;
import net.minecraft.class_1747;
import net.minecraft.class_1819;
import net.minecraft.class_3965;
import net.minecraft.class_7922;
import net.minecraft.class_7923;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.util.Hand;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract8;
import su.catlean.api.contracts.Contract9;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.player.PlayerUpdateEvent;
import su.catlean.api.setting.VisibleSettingProperty;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.movement.basic.GuiMoveClickBypassMode;
import su.catlean.client.features.modules.movement.basic.GuiMoveModule;
import su.catlean.client.features.modules.movement.basic.SprintModule;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.IdRecord11;
import su.catlean.client.services.client.config.models.IdRecord9;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.network.EventPacketHelper2;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.KeybindsWidgetCheckRenderHelperImpl;
import su.catlean.client.ui.clickgui.ProxyGuiElement;
import su.catlean.mixins.accessors.MinecraftAccessor;

public class MacroServiceComponent implements Contract9 {

    public static final MacroServiceComponent INSTANCE;
    private static Function0 function0;
    private static int countValue;
    private static boolean enabledFlag;
    private static final Map lookupMap;

    private MacroServiceComponent() {
    }

    public List resolveList() {
        return ProxyGuiElement.INSTANCE.getJsonServiceComponent6().resolveList();
    }

    public boolean checkCondition(Contract8 macro) {
        return this.resolveList().add(macro);
    }

    public boolean checkCondition(Contract8 macro) {
        return this.resolveList().remove(macro);
    }

    private void onPlayerUpdateEvent(PlayerUpdateEvent arg0) {
        if (var10) {
            SprintModule.INSTANCE.updateValue(1);
            enabledFlag = SharedKt.getPlayer().method_5624();
            SharedKt.getPlayer().method_5728(0);
            EventPacketHelper2.INSTANCE.updateValue5();
        }
        countValue = 1;
        SprintModule.INSTANCE.updateValue(1);
        GuiMoveModule.INSTANCE.updateValue(1);
        if (var10) {
            if (function0 != null) {
            }
            function0.invoke();
        } else {
        }
        GuiMoveModule.INSTANCE.updateValue(0);
        SprintModule.INSTANCE.updateValue(1);
        SharedKt.getPlayer().method_5728(enabledFlag);
        EventPacketHelper2.INSTANCE.updateValue6();
        countValue = 0;
        function0 = null;
    }

    private void onInputEvent(InputEvent arg0) {
        if (!(var13)) {
        }
        if (!(var13)) {
        }
        if (arg0.getKey() == -1 || SharedKt.getMc().world == null || SharedKt.getMc().player == null || SharedKt.getMc().currentScreen != null || arg0.getAction() == Action.Hold) {
            return;
        }
        Iterable var14 = (Iterable) this.resolveList();
        int var15 = 0;
        Object var16 = var14;
        Collection var17 = (Collection) new ArrayList();
        int var18 = 0;
        Iterator iterator = var16.iterator();
        if (iterator.hasNext()) {
            Object var20 = iterator.next();
            Contract8 var21 = var20;
            int var22 = 0;
            if (!(var13)) {
                if (!(var13)) {
                }
                if (!(var13)) {
                    if (var21.getKeyRecord().getNumericValue() == arg0.getKey() && var21.isActive()) {
                    }
                } else {
                }
                var17.add();
            }
            var14 = (Iterable) var17;
        }
        var15 = 0;
        var16 = var14.iterator();
        if (var16.hasNext()) {
            var17 = var16.next();
            var18 = var17;
            iterator = 0;
            var20 = INSTANCE;
            var21 = 0;
            if (arg0.getAction() == Action.Press) {
            }
            int var12 = 0;
            var18.executeAction(1);
        }
    }

    private void executeAction(Contract8 arg0, byte arg1, boolean arg2, int arg3, int arg4) {
        GuiMoveModule.INSTANCE.updateValue(1);
        Object var15 = arg0;
        if (!(var14)) {
            if (var15 instanceof IdRecord9) {
                this.executeAction((IdRecord9) arg0);
            }
        }
        if (arg1 >= 0) {
            if (!(var14)) {
                if (var15 instanceof IdRecord) {
                    RunnableServiceComponent2.executeAction(0, -10, 0, this::updateValue);
                }
            }
        }
        if (arg3 >= 0) {
            if (var15 instanceof IdRecord11) {
                this.executeAction((IdRecord11) arg0, arg2);
            }
            if (arg2 && var14 && arg2 && var14 && var14) {
            }
        }
        GuiMoveModule.INSTANCE.updateValue(0);
    }

    private void executeAction(IdRecord9 arg0) {
        if (var6) {
            if (StringsKt.startsWith$default(arg0.getString(), "/")) {
                SharedKt.getPlayer().field_3944.method_45730(StringsKt.replaceFirst$default(arg0.getString(), "/", ""));
            }
        }
        SharedKt.getPlayer().field_3944.method_45729(arg0.getString());
    }

    private void executeAction(IdRecord arg0) {
        Item var40 = this.resolveMinecraftObject(arg0.getString());
        Item[] var42 = new Item[1];
        var42[0] = var40;
        StackServiceComponent2 var41 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        Item[] var43 = new Item[1];
        var43[0] = var40;
        var42 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2();
        if (!(var39)) {
            if (var41.isActive()) {
                if (!(var39)) {
                    if (arg0.isActive()) {
                        var41.updateValue();
                        if (!(var39)) {
                            RunnableServiceComponent2.executeAction(RangeServiceComponent.f((ClosedRange) new IntRange(1, 2)), 0, 0, this::executeAction);
                        }
                    }
                    ItemPacketHelper.INSTANCE.executeAction(var41.getNumericValue());
                }
                if (!(var40 instanceof class_1747)) {
                }
                if (!(var39)) {
                }
                if (!(var39)) {
                    if (SharedKt.getMc().field_1765 != null && SharedKt.getMc().field_1765 instanceof class_3965) {
                    }
                    if (SharedKt.getWorld().method_22347((class_3965) SharedKt.getMc().field_1765.method_17777())) {
                    }
                }
                SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, (class_3965) SharedKt.getMc().field_1765);
                SharedKt.getPlayer().method_6104(Hand.field_5808);
                ItemPacketHelper.INSTANCE.updateValue2();
                return;
            }
        }
        if (var40 == null || var40 instanceof class_1819 || !(var39) || !(var39)) {
            return;
        }
        if (var42.isActive() && EventPacketHelper2.INSTANCE.checkCondition()) {
        }
        if (!(var39)) {
            if (function0 != null) {
            }
            function0.invoke();
        } else {
            HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
        }
        function0 = null;
    }

    private void executeAction(IdRecord11 arg0, boolean arg1) {
        Iterable var13 = (Iterable) EnabledServiceComponent.INSTANCE.getArrayList2();
        int var14 = 0;
        Iterator iterator = var13.iterator();
        if (iterator.hasNext()) {
            Object var16 = iterator.next();
            Module var17 = (Module) var16;
            int var18 = 0;
        } else {
        }
        if ((Module) null == null) {
            return;
        }
        Object var11 = var16;
        var14 = (Iterable) var11.getList();
        iterator = 0;
        var16 = var14.iterator();
        if (var16.hasNext()) {
            var17 = var16.next();
            var18 = (VisibleSettingProperty) var17;
            int var19 = 0;
        } else {
        }
        if ((VisibleSettingProperty) null == null) {
            return;
        }
        Object var12 = var17;
        var13 = var12.getObject2();
        if (!(var10)) {
            if (var13 instanceof Integer) {
                if (!(var10)) {
                    if (var12 instanceof VisibleSettingProperty) {
                    }
                } else {
                }
                if (!(var10)) {
                    if (arg0.isActive()) {
                        if (!(var10)) {
                            if (arg1) {
                                var14.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString3())));
                                new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                            }
                            var12.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                        }
                        var14.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString4())));
                        iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                        var16 = 0;
                        var17 = iterator;
                        var18 = (Collection) new ArrayList();
                        var19 = 0;
                        Iterator iterator2 = var17.iterator();
                        if (iterator2.hasNext()) {
                            Object var21 = iterator2.next();
                            BindServiceComponent var22 = (BindServiceComponent) var21;
                            int var23 = 0;
                            if (!(var10)) {
                                if (!(var10)) {
                                }
                                var18.add();
                            }
                            iterator = (Iterable) var18;
                        }
                        var16 = 0;
                        var17 = iterator.iterator();
                        if (var17.hasNext()) {
                            var18 = var17.next();
                            var19 = (BindServiceComponent) var18;
                            iterator2 = 0;
                            var19.updateValue(1);
                            if (!(var10)) {
                            }
                        }
                    } else {
                    }
                    if (!(var10)) {
                    }
                    if (!(var10)) {
                        if ((Number) var14.getObject2() == Integer.parseInt(arg0.getString3())) {
                            var14.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString4())));
                            iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                            var16 = 0;
                            var17 = iterator;
                            var18 = (Collection) new ArrayList();
                            var19 = 0;
                            iterator2 = var17.iterator();
                            if (iterator2.hasNext()) {
                                var21 = iterator2.next();
                                var22 = (BindServiceComponent) var21;
                                var23 = 0;
                                if (!(var10)) {
                                    if (!(var10)) {
                                    }
                                    var18.add();
                                }
                                iterator = (Iterable) var18;
                            }
                            var16 = 0;
                            var17 = iterator.iterator();
                            if (var17.hasNext()) {
                                var18 = var17.next();
                                var19 = (BindServiceComponent) var18;
                                iterator2 = 0;
                                var19.updateValue(1);
                                if (!(var10)) {
                                }
                            }
                        } else {
                            var14.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString3())));
                            new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                        }
                        this.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                    } else {
                    }
                    if (!(var10)) {
                        if (var13 instanceof Float) {
                            if (!(var10)) {
                                if (var12 instanceof VisibleSettingProperty) {
                                }
                            } else {
                            }
                            if (!(var10)) {
                                if (arg0.isActive()) {
                                    if (!(var10)) {
                                        if (arg1) {
                                            var14.updateValue(Float.valueOf(Float.parseFloat(arg0.getString3())));
                                            new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                        }
                                        var12.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                    }
                                    var14.updateValue(Float.valueOf(Float.parseFloat(arg0.getString4())));
                                    iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                    var16 = 0;
                                    var17 = iterator;
                                    var18 = (Collection) new ArrayList();
                                    var19 = 0;
                                    iterator2 = var17.iterator();
                                    if (iterator2.hasNext()) {
                                        var21 = iterator2.next();
                                        var22 = (BindServiceComponent) var21;
                                        var23 = 0;
                                        if (!(var10)) {
                                            if (!(var10)) {
                                            }
                                            var18.add();
                                        }
                                        iterator = (Iterable) var18;
                                    }
                                    var16 = 0;
                                    var17 = iterator.iterator();
                                    if (var17.hasNext()) {
                                        var18 = var17.next();
                                        var19 = (BindServiceComponent) var18;
                                        iterator2 = 0;
                                        var19.updateValue(1);
                                        if (!(var10)) {
                                        }
                                    }
                                } else {
                                }
                                if (!(var10)) {
                                }
                                if (!(var10)) {
                                    if ((Number) var14.getObject2() == Float.parseFloat(arg0.getString3())) {
                                    }
                                } else {
                                }
                                if (0) {
                                    var14.updateValue(Float.valueOf(Float.parseFloat(arg0.getString4())));
                                    iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                    var16 = 0;
                                    var17 = iterator;
                                    var18 = (Collection) new ArrayList();
                                    var19 = 0;
                                    iterator2 = var17.iterator();
                                    if (iterator2.hasNext()) {
                                        var21 = iterator2.next();
                                        var22 = (BindServiceComponent) var21;
                                        var23 = 0;
                                        if (!(var10)) {
                                            if (!(var10)) {
                                            }
                                            var18.add();
                                        }
                                        iterator = (Iterable) var18;
                                    }
                                    var16 = 0;
                                    var17 = iterator.iterator();
                                    if (var17.hasNext()) {
                                        var18 = var17.next();
                                        var19 = (BindServiceComponent) var18;
                                        iterator2 = 0;
                                        var19.updateValue(1);
                                        if (!(var10)) {
                                        }
                                    }
                                } else {
                                    var14.updateValue(Float.valueOf(Float.parseFloat(arg0.getString3())));
                                    new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                    1.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                } else {
                                }
                                if (!(var10)) {
                                    if (var13 instanceof Boolean) {
                                        if (!(var10)) {
                                            if (var12 instanceof VisibleSettingProperty) {
                                            }
                                        } else {
                                        }
                                        if (!(var10)) {
                                            if (arg0.isActive()) {
                                                if (!(var10)) {
                                                    if (arg1) {
                                                        var14.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString3())));
                                                        new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                                    }
                                                    var12.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                }
                                                var14.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString4())));
                                                iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                                var16 = 0;
                                                var17 = iterator;
                                                var18 = (Collection) new ArrayList();
                                                var19 = 0;
                                                iterator2 = var17.iterator();
                                                if (iterator2.hasNext()) {
                                                    var21 = iterator2.next();
                                                    var22 = (BindServiceComponent) var21;
                                                    var23 = 0;
                                                    if (!(var10)) {
                                                        if (!(var10)) {
                                                        }
                                                        var18.add();
                                                    }
                                                    iterator = (Iterable) var18;
                                                }
                                                var16 = 0;
                                                var17 = iterator.iterator();
                                                if (var17.hasNext()) {
                                                    var18 = var17.next();
                                                    var19 = (BindServiceComponent) var18;
                                                    iterator2 = 0;
                                                    var19.updateValue(1);
                                                    if (!(var10)) {
                                                    }
                                                }
                                            } else {
                                            }
                                            if (!(var10)) {
                                            }
                                            if (!(var10)) {
                                                if ((Boolean) var14.getObject2() == Boolean.parseBoolean(arg0.getString3())) {
                                                    var14.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString4())));
                                                    iterator = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                                    var16 = 0;
                                                    var17 = iterator;
                                                    var18 = (Collection) new ArrayList();
                                                    var19 = 0;
                                                    iterator2 = var17.iterator();
                                                    if (iterator2.hasNext()) {
                                                        var21 = iterator2.next();
                                                        var22 = (BindServiceComponent) var21;
                                                        var23 = 0;
                                                        if (!(var10)) {
                                                            if (!(var10)) {
                                                            }
                                                            var18.add();
                                                        }
                                                        iterator = (Iterable) var18;
                                                    }
                                                    var16 = 0;
                                                    var17 = iterator.iterator();
                                                    if (var17.hasNext()) {
                                                        var18 = var17.next();
                                                        var19 = (BindServiceComponent) var18;
                                                        iterator2 = 0;
                                                        var19.updateValue(1);
                                                        if (!(var10)) {
                                                        }
                                                    }
                                                } else {
                                                    var14.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString3())));
                                                    new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                                }
                                                this.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                            } else {
                                            }
                                            if (!(var10)) {
                                                if (!(var10)) {
                                                }
                                                if (var12 instanceof VisibleSettingProperty) {
                                                }
                                            } else {
                                            }
                                            if (!(var10)) {
                                            }
                                            var17 = var14.getObject2().getClass().getEnumConstants();
                                            var18 = 0;
                                            var19 = 0;
                                            iterator2 = var17;
                                            if (var19 < iterator2) {
                                                var21 = var17[var19];
                                                var22 = var21;
                                                var23 = 0;
                                                if (!(var10)) {
                                                    if (!(var10)) {
                                                        if (StringsKt.equals(var22.name(), StringsKt.replace$default(arg0.getString3(), " ", "_"), 1)) {
                                                        }
                                                    }
                                                }
                                            }
                                            if (null == null) {
                                                return;
                                            }
                                            iterator = var21;
                                            var18 = var14.getObject2().getClass().getEnumConstants();
                                            var19 = 0;
                                            iterator2 = 0;
                                            var21 = var18;
                                            if (iterator2 < var21) {
                                                var22 = var18[iterator2];
                                                var23 = var22;
                                                int var24 = 0;
                                                if (!(var10)) {
                                                    if (!(var10)) {
                                                        if (StringsKt.equals(var23.name(), StringsKt.replace$default(arg0.getString4(), " ", "_"), 1)) {
                                                        }
                                                    }
                                                }
                                            }
                                            if (null == null) {
                                                return;
                                            }
                                            var16 = var22;
                                            if (!(var10)) {
                                                if (arg0.isActive()) {
                                                    if (!(var10)) {
                                                        if (arg1) {
                                                            var14.updateValue(iterator);
                                                            new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                                        }
                                                        var12.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                    }
                                                    var14.updateValue();
                                                    var17 = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                                    var18 = 0;
                                                    var19 = var17;
                                                    iterator2 = (Collection) new ArrayList();
                                                    var21 = 0;
                                                    var22 = var19.iterator();
                                                    if (var22.hasNext()) {
                                                        var23 = var22.next();
                                                        var24 = (BindServiceComponent) var23;
                                                        int var25 = 0;
                                                        if (!(var10)) {
                                                            if (!(var10)) {
                                                            }
                                                            iterator2.add();
                                                        }
                                                        var17 = (Iterable) iterator2;
                                                    }
                                                    var18 = 0;
                                                    var19 = var17.iterator();
                                                    if (var19.hasNext()) {
                                                        iterator2 = var19.next();
                                                        var21 = (BindServiceComponent) iterator2;
                                                        var22 = 0;
                                                        var21.updateValue(1);
                                                        if (!(var10)) {
                                                        }
                                                    }
                                                } else {
                                                }
                                                if (!(var10)) {
                                                }
                                                if (!(var10)) {
                                                    if (Intrinsics.areEqual(var14.getObject2(), iterator)) {
                                                        var14.updateValue();
                                                        var17 = (Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList();
                                                        var18 = 0;
                                                        var19 = var17;
                                                        iterator2 = (Collection) new ArrayList();
                                                        var21 = 0;
                                                        var22 = var19.iterator();
                                                        if (var22.hasNext()) {
                                                            var23 = var22.next();
                                                            var24 = (BindServiceComponent) var23;
                                                            var25 = 0;
                                                            if (!(var10)) {
                                                                if (!(var10)) {
                                                                }
                                                                iterator2.add();
                                                            }
                                                            var17 = (Iterable) iterator2;
                                                        }
                                                        var18 = 0;
                                                        var19 = var17.iterator();
                                                        if (var19.hasNext()) {
                                                            iterator2 = var19.next();
                                                            var21 = (BindServiceComponent) iterator2;
                                                            var22 = 0;
                                                            var21.updateValue(1);
                                                            if (!(var10)) {
                                                            }
                                                        }
                                                    } else {
                                                        var14.updateValue(iterator);
                                                        new BindServiceComponent(new BindServiceComponent, arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim((CharSequence) var11.getString2()).toString() + var12.getString2() + " -> " + arg0.getString3()));
                                                    }
                                                    this.add(KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public Item resolveMinecraftObject(String id) {
        if (var4) {
            if (lookupMap.containsKey(id)) {
            }
            return (Item) lookupMap.get(id);
        }
        Iterator iterator = class_7923.field_41175.iterator();
        if (iterator.hasNext()) {
            Block var6 = (Block) iterator.next();
            lookupMap.put(id, var6.method_8389());
            return var6.method_8389();
        }
        iterator = class_7923.field_41178.iterator();
        if (iterator.hasNext()) {
            var6 = (Item) iterator.next();
            lookupMap.put(id);
            return var6;
        }
        return null;
    }

    private static void updateValue(Contract8 arg0) {
        INSTANCE.executeAction((IdRecord) arg0);
    }

    private static void executeAction() {
        (MinecraftAccessor) SharedKt.getMc().idoItemUse();
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    private static Unit resolveUnit(IdRecord arg0, StackServiceComponent2 arg1) {
        if (!(var17)) {
            if (arg0.isActive()) {
                HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
                if (var17) {
                }
            }
            HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
            if (!(var17)) {
            }
            if (!(var17)) {
                if (SharedKt.getMc().field_1765 != null && SharedKt.getMc().field_1765 instanceof class_3965) {
                }
                if (SharedKt.getWorld().method_22347((class_3965) SharedKt.getMc().field_1765.method_17777())) {
                }
            }
            SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, (class_3965) SharedKt.getMc().field_1765);
            SharedKt.getPlayer().method_6104(Hand.field_5808);
            HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791);
        }
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new MacroServiceComponent();
        lookupMap = (Map) new LinkedHashMap();
    }

}
