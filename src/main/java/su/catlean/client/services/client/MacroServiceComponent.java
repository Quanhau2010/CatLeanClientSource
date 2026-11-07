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
        SprintModule.INSTANCE.updateValue(true);
        enabledFlag = SharedKt.getPlayer().method_5624();
        SharedKt.getPlayer().method_5728(false);
        EventPacketHelper2.INSTANCE.updateValue5();
        countValue = 1;
        SprintModule.INSTANCE.updateValue(true);
        GuiMoveModule.INSTANCE.updateValue(true);
        if (function0 != null) {
            function0.invoke();
        } else {
        }
        GuiMoveModule.INSTANCE.updateValue(false);
        SprintModule.INSTANCE.updateValue(true);
        SharedKt.getPlayer().method_5728(enabledFlag);
        EventPacketHelper2.INSTANCE.updateValue6();
        countValue = 0;
        function0 = null;
    }

    private void onInputEvent(InputEvent arg0) {
        if (arg0.getKey() == -1 || SharedKt.getMc().world == null || SharedKt.getMc().player == null || SharedKt.getMc().currentScreen != null || arg0.getAction() == Action.Hold) {
            return;
        }
        Iterable iterable = ((Iterable) this.resolveList());
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Contract8 contract8 = element;
            if (contract8.getKeyRecord().getNumericValue() == arg0.getKey() && contract8.isActive()) {
            } else {
            }
            collection.add(element);
        }
        iterable = ((Iterable) collection);
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index = collection;
            iterator = 0;
            element = INSTANCE;
            contract8 = 0;
            if (arg0.getAction() == Action.Press) {
            }
            int index2 = 0;
            index.executeAction(1, index2);
        }
    }

    private void executeAction(Contract8 arg0, byte arg1, boolean arg2, int arg3, int arg4) {
        GuiMoveModule.INSTANCE.updateValue(true);
        if (!(__UNDEF_KEY__)) {
            if (arg0 instanceof IdRecord9) {
                this.executeAction(((IdRecord9) arg0));
            }
        }
        if (arg1 >= 0) {
            if (!(__UNDEF_KEY__)) {
                if (arg0 instanceof IdRecord) {
                    RunnableServiceComponent2.executeAction(0, -10, false, this::updateValue);
                }
            }
        }
        if (arg3 >= 0) {
            if (arg0 instanceof IdRecord11) {
                this.executeAction(((IdRecord11) arg0), arg2);
                if (arg2 && __UNDEF_KEY__ && arg2 && __UNDEF_KEY__ && __UNDEF_KEY__) {
                }
            }
        }
        GuiMoveModule.INSTANCE.updateValue(false);
    }

    private void executeAction(IdRecord9 arg0) {
        if (StringsKt.startsWith$default(arg0.getString(), "/", false)) {
            SharedKt.getPlayer().field_3944.method_45730(StringsKt.replaceFirst$default(arg0.getString(), "/", "", false));
        }
        SharedKt.getPlayer().field_3944.method_45729(arg0.getString());
    }

    private void executeAction(IdRecord arg0) {
        Item item = this.resolveMinecraftObject(arg0.getString());
        Item[] items = new Item[1];
        items[0] = item;
        StackServiceComponent2 stackServiceComponent2 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items);
        Item[] items2 = new Item[1];
        items2[0] = item;
        items = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2(items2);
        if (!(__UNDEF_KEY__)) {
            if (stackServiceComponent2.isActive()) {
                if (!(__UNDEF_KEY__)) {
                    if (arg0.isActive()) {
                        stackServiceComponent2.updateValue();
                        if (!(__UNDEF_KEY__)) {
                            RunnableServiceComponent2.executeAction(RangeServiceComponent.f(((ClosedRange) new IntRange(1, 2)), false), 0, false, this::executeAction);
                        }
                    }
                    ItemPacketHelper.INSTANCE.executeAction(stackServiceComponent2.getNumericValue());
                }
                if (!(item instanceof class_1747)) {
                }
                if (!(__UNDEF_KEY__)) {
                }
                if (!(__UNDEF_KEY__)) {
                    if (SharedKt.getMc().field_1765 != null && SharedKt.getMc().field_1765 instanceof class_3965) {
                        if (SharedKt.getWorld().method_22347(((class_3965) SharedKt.getMc().field_1765).method_17777())) {
                        }
                    }
                }
                SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, ((class_3965) SharedKt.getMc().field_1765));
                SharedKt.getPlayer().method_6104(Hand.field_5808);
                ItemPacketHelper.INSTANCE.updateValue2();
                return;
            }
        }
        if (item == null || item instanceof class_1819 || !(__UNDEF_KEY__) || !(__UNDEF_KEY__)) {
            return;
        }
        if (items.isActive() && EventPacketHelper2.INSTANCE.checkCondition()) {
        }
        if (!(__UNDEF_KEY__)) {
            if (function0 != null) {
                function0.invoke();
            } else {
                HandServiceComponent.K(Hand.field_5808, 0.0F, 0.0F);
            }
        }
        function0 = null;
    }

    private void executeAction(IdRecord11 arg0, boolean arg1) {
        Iterable iterable = ((Iterable) EnabledServiceComponent.INSTANCE.getArrayList2());
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            Module module = ((Module) element);
            int index2 = 0;
        }
        if (((Module) null) == null) {
            return;
        }
        index = ((Iterable) element.getList());
        iterator = 0;
        element = index.iterator();
        while (element.hasNext()) {
            module = element.next();
            index2 = ((VisibleSettingProperty) module);
            int index3 = 0;
        }
        if (((VisibleSettingProperty) null) == null) {
            return;
        }
        iterable = module.getObject2();
        if (!(__UNDEF_KEY__)) {
            if (iterable instanceof Integer) {
                if (!(__UNDEF_KEY__)) {
                    if (module instanceof VisibleSettingProperty) {
                    } else {
                    }
                }
                if (!(__UNDEF_KEY__)) {
                    if (arg0.isActive()) {
                        if (!(__UNDEF_KEY__)) {
                            if (arg1) {
                                index.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString3())));
                                KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                            }
                        }
                        index.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString4())));
                        iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                        element = 0;
                        module = iterator;
                        index2 = ((Collection) new ArrayList());
                        index3 = 0;
                        Iterator iterator2 = module.iterator();
                        while (iterator2.hasNext()) {
                            Object element2 = iterator2.next();
                            BindServiceComponent bindServiceComponent = ((BindServiceComponent) element2);
                            int index4 = 0;
                            if (!(__UNDEF_KEY__)) {
                                if (!(__UNDEF_KEY__)) {
                                }
                                index2.add(element2);
                                iterator = ((Iterable) index2);
                            }
                        }
                        element = 0;
                        module = iterator.iterator();
                        while (module.hasNext()) {
                            index2 = module.next();
                            index3 = ((BindServiceComponent) index2);
                            iterator2 = 0;
                            index3.updateValue(true);
                            if (!(__UNDEF_KEY__)) {
                            }
                        }
                    } else {
                        if (!(__UNDEF_KEY__)) {
                        }
                        if (!(__UNDEF_KEY__)) {
                            if (((Number) index.getObject2()) == Integer.parseInt(arg0.getString3())) {
                                index.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString4())));
                                iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                element = 0;
                                module = iterator;
                                index2 = ((Collection) new ArrayList());
                                index3 = 0;
                                iterator2 = module.iterator();
                                while (iterator2.hasNext()) {
                                    element2 = iterator2.next();
                                    bindServiceComponent = ((BindServiceComponent) element2);
                                    index4 = 0;
                                    if (!(__UNDEF_KEY__)) {
                                        if (!(__UNDEF_KEY__)) {
                                        }
                                        index2.add(element2);
                                        iterator = ((Iterable) index2);
                                    }
                                }
                                element = 0;
                                module = iterator.iterator();
                                while (module.hasNext()) {
                                    index2 = module.next();
                                    index3 = ((BindServiceComponent) index2);
                                    iterator2 = 0;
                                    index3.updateValue(true);
                                    if (!(__UNDEF_KEY__)) {
                                    }
                                }
                            } else {
                                index.updateValue(Integer.valueOf(Integer.parseInt(arg0.getString3())));
                                KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                if (!(__UNDEF_KEY__)) {
                                    if (iterable instanceof Float) {
                                        if (!(__UNDEF_KEY__)) {
                                            if (module instanceof VisibleSettingProperty) {
                                            } else {
                                            }
                                        }
                                        if (!(__UNDEF_KEY__)) {
                                            if (arg0.isActive()) {
                                                if (!(__UNDEF_KEY__)) {
                                                    if (arg1) {
                                                        index.updateValue(Float.valueOf(Float.parseFloat(arg0.getString3())));
                                                        KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                    }
                                                }
                                                index.updateValue(Float.valueOf(Float.parseFloat(arg0.getString4())));
                                                iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                element = 0;
                                                module = iterator;
                                                index2 = ((Collection) new ArrayList());
                                                index3 = 0;
                                                iterator2 = module.iterator();
                                                while (iterator2.hasNext()) {
                                                    element2 = iterator2.next();
                                                    bindServiceComponent = ((BindServiceComponent) element2);
                                                    index4 = 0;
                                                    if (!(__UNDEF_KEY__)) {
                                                        if (!(__UNDEF_KEY__)) {
                                                        }
                                                        index2.add(element2);
                                                        iterator = ((Iterable) index2);
                                                    }
                                                }
                                                element = 0;
                                                module = iterator.iterator();
                                                while (module.hasNext()) {
                                                    index2 = module.next();
                                                    index3 = ((BindServiceComponent) index2);
                                                    iterator2 = 0;
                                                    index3.updateValue(true);
                                                    if (!(__UNDEF_KEY__)) {
                                                    }
                                                }
                                            } else {
                                                if (!(__UNDEF_KEY__)) {
                                                }
                                                if (!(__UNDEF_KEY__)) {
                                                    if (((Number) index.getObject2()) == Float.parseFloat(arg0.getString3())) {
                                                    } else {
                                                    }
                                                }
                                                if (0) {
                                                    index.updateValue(Float.valueOf(Float.parseFloat(arg0.getString4())));
                                                    iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                    element = 0;
                                                    module = iterator;
                                                    index2 = ((Collection) new ArrayList());
                                                    index3 = 0;
                                                    iterator2 = module.iterator();
                                                    while (iterator2.hasNext()) {
                                                        element2 = iterator2.next();
                                                        bindServiceComponent = ((BindServiceComponent) element2);
                                                        index4 = 0;
                                                        if (!(__UNDEF_KEY__)) {
                                                            if (!(__UNDEF_KEY__)) {
                                                            }
                                                            index2.add(element2);
                                                            iterator = ((Iterable) index2);
                                                        }
                                                    }
                                                    element = 0;
                                                    module = iterator.iterator();
                                                    while (module.hasNext()) {
                                                        index2 = module.next();
                                                        index3 = ((BindServiceComponent) index2);
                                                        iterator2 = 0;
                                                        index3.updateValue(true);
                                                        if (!(__UNDEF_KEY__)) {
                                                        }
                                                    }
                                                } else {
                                                    index.updateValue(Float.valueOf(Float.parseFloat(arg0.getString3())));
                                                    KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                    if (!(__UNDEF_KEY__)) {
                                                        if (iterable instanceof Boolean) {
                                                            if (!(__UNDEF_KEY__)) {
                                                                if (module instanceof VisibleSettingProperty) {
                                                                } else {
                                                                }
                                                            }
                                                            if (!(__UNDEF_KEY__)) {
                                                                if (arg0.isActive()) {
                                                                    if (!(__UNDEF_KEY__)) {
                                                                        if (arg1) {
                                                                            index.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString3())));
                                                                            KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                                        }
                                                                    }
                                                                    index.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString4())));
                                                                    iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                                    element = 0;
                                                                    module = iterator;
                                                                    index2 = ((Collection) new ArrayList());
                                                                    index3 = 0;
                                                                    iterator2 = module.iterator();
                                                                    while (iterator2.hasNext()) {
                                                                        element2 = iterator2.next();
                                                                        bindServiceComponent = ((BindServiceComponent) element2);
                                                                        index4 = 0;
                                                                        if (!(__UNDEF_KEY__)) {
                                                                            if (!(__UNDEF_KEY__)) {
                                                                            }
                                                                            index2.add(element2);
                                                                            iterator = ((Iterable) index2);
                                                                        }
                                                                    }
                                                                    element = 0;
                                                                    module = iterator.iterator();
                                                                    while (module.hasNext()) {
                                                                        index2 = module.next();
                                                                        index3 = ((BindServiceComponent) index2);
                                                                        iterator2 = 0;
                                                                        index3.updateValue(true);
                                                                        if (!(__UNDEF_KEY__)) {
                                                                        }
                                                                    }
                                                                } else {
                                                                    if (!(__UNDEF_KEY__)) {
                                                                    }
                                                                    if (!(__UNDEF_KEY__)) {
                                                                        if (((Boolean) index.getObject2()) == Boolean.parseBoolean(arg0.getString3())) {
                                                                            index.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString4())));
                                                                            iterator = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                                            element = 0;
                                                                            module = iterator;
                                                                            index2 = ((Collection) new ArrayList());
                                                                            index3 = 0;
                                                                            iterator2 = module.iterator();
                                                                            while (iterator2.hasNext()) {
                                                                                element2 = iterator2.next();
                                                                                bindServiceComponent = ((BindServiceComponent) element2);
                                                                                index4 = 0;
                                                                                if (!(__UNDEF_KEY__)) {
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                    }
                                                                                    index2.add(element2);
                                                                                    iterator = ((Iterable) index2);
                                                                                }
                                                                            }
                                                                            element = 0;
                                                                            module = iterator.iterator();
                                                                            while (module.hasNext()) {
                                                                                index2 = module.next();
                                                                                index3 = ((BindServiceComponent) index2);
                                                                                iterator2 = 0;
                                                                                index3.updateValue(true);
                                                                                if (!(__UNDEF_KEY__)) {
                                                                                }
                                                                            }
                                                                        } else {
                                                                            index.updateValue(Boolean.valueOf(Boolean.parseBoolean(arg0.getString3())));
                                                                            KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                                            if (!(__UNDEF_KEY__)) {
                                                                                if (!(__UNDEF_KEY__)) {
                                                                                    if (module instanceof VisibleSettingProperty) {
                                                                                    } else {
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (!(__UNDEF_KEY__)) {
                                                                            }
                                                                            module = index.getObject2().getClass().getEnumConstants();
                                                                            index2 = 0;
                                                                            index3 = 0;
                                                                            iterator2 = module;
                                                                            if (index3 < iterator2) {
                                                                                element2 = module[index3];
                                                                                bindServiceComponent = element2;
                                                                                index4 = 0;
                                                                                if (!(__UNDEF_KEY__)) {
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                        if (StringsKt.equals(bindServiceComponent.name(), StringsKt.replace$default(arg0.getString3(), " ", "_", false), true)) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (null == null) {
                                                                                return;
                                                                            }
                                                                            iterator = element2;
                                                                            index2 = index.getObject2().getClass().getEnumConstants();
                                                                            index3 = 0;
                                                                            iterator2 = 0;
                                                                            element2 = index2;
                                                                            if (iterator2 < element2) {
                                                                                bindServiceComponent = index2[iterator2];
                                                                                index4 = bindServiceComponent;
                                                                                int index5 = 0;
                                                                                if (!(__UNDEF_KEY__)) {
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                        if (StringsKt.equals(index4.name(), StringsKt.replace$default(arg0.getString4(), " ", "_", false), true)) {
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                            if (null == null) {
                                                                                return;
                                                                            }
                                                                            element = bindServiceComponent;
                                                                            if (!(__UNDEF_KEY__)) {
                                                                                if (arg0.isActive()) {
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                        if (arg1) {
                                                                                            index.updateValue(iterator);
                                                                                            KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                                                        }
                                                                                    }
                                                                                    index.updateValue(element);
                                                                                    module = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                                                    index2 = 0;
                                                                                    index3 = module;
                                                                                    iterator2 = ((Collection) new ArrayList());
                                                                                    element2 = 0;
                                                                                    bindServiceComponent = index3.iterator();
                                                                                    while (bindServiceComponent.hasNext()) {
                                                                                        index4 = bindServiceComponent.next();
                                                                                        index5 = ((BindServiceComponent) index4);
                                                                                        if (!(__UNDEF_KEY__)) {
                                                                                            if (!(__UNDEF_KEY__)) {
                                                                                            }
                                                                                            iterator2.add(index4);
                                                                                            module = ((Iterable) iterator2);
                                                                                        }
                                                                                    }
                                                                                    index2 = 0;
                                                                                    index3 = module.iterator();
                                                                                    while (index3.hasNext()) {
                                                                                        iterator2 = index3.next();
                                                                                        element2 = ((BindServiceComponent) iterator2);
                                                                                        bindServiceComponent = 0;
                                                                                        element2.updateValue(true);
                                                                                        if (!(__UNDEF_KEY__)) {
                                                                                        }
                                                                                    }
                                                                                } else {
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                    }
                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                        if (Intrinsics.areEqual(index.getObject2(), iterator)) {
                                                                                            index.updateValue(element);
                                                                                            module = ((Iterable) KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList());
                                                                                            index2 = 0;
                                                                                            index3 = module;
                                                                                            iterator2 = ((Collection) new ArrayList());
                                                                                            element2 = 0;
                                                                                            bindServiceComponent = index3.iterator();
                                                                                            while (bindServiceComponent.hasNext()) {
                                                                                                index4 = bindServiceComponent.next();
                                                                                                index5 = ((BindServiceComponent) index4);
                                                                                                if (!(__UNDEF_KEY__)) {
                                                                                                    if (!(__UNDEF_KEY__)) {
                                                                                                    }
                                                                                                    iterator2.add(index4);
                                                                                                    module = ((Iterable) iterator2);
                                                                                                }
                                                                                            }
                                                                                            index2 = 0;
                                                                                            index3 = module.iterator();
                                                                                            while (index3.hasNext()) {
                                                                                                iterator2 = index3.next();
                                                                                                element2 = ((BindServiceComponent) iterator2);
                                                                                                bindServiceComponent = 0;
                                                                                                element2.updateValue(true);
                                                                                                if (!(__UNDEF_KEY__)) {
                                                                                                }
                                                                                            }
                                                                                        } else {
                                                                                            index.updateValue(iterator);
                                                                                            KeybindsWidgetCheckRenderHelperImpl.INSTANCE.getList().add(new BindServiceComponent(arg0.getString(), (NoneServiceComponent.INSTANCE.resolveString(arg0.getKeyRecord().getNumericValue()) + StringsKt.trim(((CharSequence) element.getString2())).toString() + module.getString2() + " -> " + arg0.getString3()), null, false));
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        } else {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    } else {
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
        if (__UNDEF_KEY__) {
            if (lookupMap.containsKey(id)) {
                return ((Item) lookupMap.get(id));
            }
        }
        Iterator iterator = class_7923.field_41175.iterator();
        while (iterator.hasNext()) {
            Block block = ((Block) iterator.next());
            lookupMap.put(id, block.method_8389());
            return block.method_8389();
        }
        iterator = class_7923.field_41178.iterator();
        while (iterator.hasNext()) {
            block = ((Item) iterator.next());
            lookupMap.put(id, block);
            return block;
        }
        return null;
    }

    private static void updateValue(Contract8 arg0) {
        INSTANCE.executeAction(((IdRecord) arg0));
    }

    private static void executeAction() {
        ((MinecraftAccessor) SharedKt.getMc()).idoItemUse();
        SharedKt.getPlayer().method_6104(Hand.field_5808);
    }

    private static Unit resolveUnit(IdRecord arg0, StackServiceComponent2 arg1) {
        if (arg0.isActive()) {
            HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
        }
        HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
        if (SharedKt.getMc().field_1765 != null && SharedKt.getMc().field_1765 instanceof class_3965) {
            if (SharedKt.getWorld().method_22347(((class_3965) SharedKt.getMc().field_1765).method_17777())) {
            }
        }
        SharedKt.getInteractionManager().method_2896(SharedKt.getPlayer(), Hand.field_5808, ((class_3965) SharedKt.getMc().field_1765));
        SharedKt.getPlayer().method_6104(Hand.field_5808);
        HandServiceComponent.e(arg1.getNumericValue(), SharedKt.getPlayer().method_31548().method_67532(), class_1713.field_7791, false);
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new MacroServiceComponent();
        lookupMap = ((Map) new LinkedHashMap());
    }

}
