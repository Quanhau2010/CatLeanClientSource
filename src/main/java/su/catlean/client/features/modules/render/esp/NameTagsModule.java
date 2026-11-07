package su.catlean.client.features.modules.render.esp;

import com.google.common.collect.Ordering;
import com.mojang.authlib.GameProfile;
import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import net.minecraft.class_10055;
import net.minecraft.class_10799;
import net.minecraft.class_124;
import net.minecraft.class_1293;
import net.minecraft.class_1321;
import net.minecraft.class_1498;
import net.minecraft.class_1676;
import net.minecraft.class_1747;
import net.minecraft.class_1890;
import net.minecraft.class_1893;
import net.minecraft.class_1917;
import net.minecraft.class_1934;
import net.minecraft.class_2378;
import net.minecraft.class_2480;
import net.minecraft.class_2561;
import net.minecraft.class_2586;
import net.minecraft.class_2636;
import net.minecraft.class_266;
import net.minecraft.class_269;
import net.minecraft.class_274.class_275;
import net.minecraft.class_315;
import net.minecraft.class_329;
import net.minecraft.class_3532;
import net.minecraft.class_408;
import net.minecraft.class_5134;
import net.minecraft.class_5250;
import net.minecraft.class_5321;
import net.minecraft.class_5455;
import net.minecraft.class_5498;
import net.minecraft.class_640;
import net.minecraft.class_6880;
import net.minecraft.class_8646;
import net.minecraft.class_9013;
import net.minecraft.class_9015;
import net.minecraft.class_9022;
import net.minecraft.class_9025;
import net.minecraft.class_9288;
import net.minecraft.class_9304;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Vector4d;
import su.catlean.SharedKt;
import su.catlean.api.event.events.client.InputEvent;
import su.catlean.api.event.events.client.InputEvent.Action;
import su.catlean.api.event.events.client.InputEvent.Device;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.RenderNameTagEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl7;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.SettingGroup;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.services.client.ContentTypeServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.MessageServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent86;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.network.TheNetherPacketHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.player.EntityHelper4;
import su.catlean.client.services.player.PlayerEntityHelper;
import su.catlean.client.services.render.CatleanWidgetEditorRenderHelper;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.MissingnoRenderHelper;
import su.catlean.client.services.render.POSITIONCOLORRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent;
import su.catlean.client.tools.comparators.Comparator12;
import su.catlean.client.types.OptionMode11;
import su.catlean.client.types.OptionMode14;
import su.catlean.client.types.TpYawSmootherMode;
import su.catlean.client.types.mappings.NameTagsNameModeWhenMappings;

public class NameTagsModule extends Module {

    public static final NameTagsModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 seeCatleanUsersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 nameModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 componentsSetting;
    private static final VisibleVisibleSettingPropertyImpl gamemodeSetting;
    private static final VisibleVisibleSettingPropertyImpl pingSetting;
    private static final VisibleVisibleSettingPropertyImpl hpSetting;
    private static final VisibleVisibleSettingPropertyImpl distanceSetting;
    private static final VisibleVisibleSettingPropertyImpl popsSetting;
    private static final VisibleVisibleSettingPropertyImpl enchantssSetting;
    private static final VisibleVisibleSettingPropertyImpl onlyHandsSetting;
    private static final VisibleVisibleSettingPropertyImpl potionsSetting;
    private static final VisibleVisibleSettingPropertyImpl shulkersSetting;
    private static final DefaultValueVisibleSettingPropertyImpl7 selectionSetting;
    private static final VisibleVisibleSettingPropertyImpl spawnersSetting;
    private static final VisibleVisibleSettingPropertyImpl entityOwnerSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 fillColorASetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 outlineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 fillColorFSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 friendOutlineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 armorModeSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 healthSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 healthProviderSetting;
    private static final Map lookupMap;
    private static final MissingnoRenderHelper missingnoRenderHelper;
    private static EasingServiceComponent easingServiceComponent;
    private static final StackShaderComponent stackShaderComponent;
    private static final StackShaderComponent stackShaderComponent2;
    private static final Map lookupMap2;
    private static String textValue;
    private static int[] countValueArray;

    private NameTagsModule() {
        super("name-tags", SubCategoriesKt.getEspCategory());
    }

    public NameTagsSeeCatleanUsersMode getSeeCatleanUsers() {
        return ((NameTagsSeeCatleanUsersMode) seeCatleanUsersSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private NameTagsNameMode getNameMode() {
        return ((NameTagsNameMode) nameModeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private SettingGroup getComponents() {
        return ((SettingGroup) componentsSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getGamemode() {
        return ((Boolean) gamemodeSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getPing() {
        return ((Boolean) pingSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private boolean getHp() {
        return ((Boolean) hpSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private boolean getDistance() {
        return ((Boolean) distanceSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private boolean getPops() {
        return ((Boolean) popsSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private boolean getEnchantss() {
        return ((Boolean) enchantssSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private boolean getOnlyHands() {
        return ((Boolean) onlyHandsSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private boolean getPotions() {
        return ((Boolean) potionsSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private boolean getShulkers() {
        return ((Boolean) shulkersSetting.getValue(this, DELEGATED_PROPERTIES[11]));
    }

    private SettingGroup getSelection() {
        return ((SettingGroup) selectionSetting.getValue(this, DELEGATED_PROPERTIES[12]));
    }

    private boolean getSpawners() {
        return ((Boolean) spawnersSetting.getValue(this, DELEGATED_PROPERTIES[13]));
    }

    private boolean getEntityOwner() {
        return ((Boolean) entityOwnerSetting.getValue(this, DELEGATED_PROPERTIES[14]));
    }

    private Color getFillColorA() {
        return ((Color) fillColorASetting.getValue(this, DELEGATED_PROPERTIES[15]));
    }

    private Color getOutlineColor() {
        return ((Color) outlineColorSetting.getValue(this, DELEGATED_PROPERTIES[16]));
    }

    private Color getFillColorF() {
        return ((Color) fillColorFSetting.getValue(this, DELEGATED_PROPERTIES[17]));
    }

    private Color getFriendOutlineColor() {
        return ((Color) friendOutlineColorSetting.getValue(this, DELEGATED_PROPERTIES[18]));
    }

    private NameTagsArmorMode getArmorMode() {
        return ((NameTagsArmorMode) armorModeSetting.getValue(this, DELEGATED_PROPERTIES[19]));
    }

    private NameTagsHealthMode getHealth() {
        return ((NameTagsHealthMode) healthSetting.getValue(this, DELEGATED_PROPERTIES[20]));
    }

    public NameTagsHealthProviderMode getHealthProvider() {
        return ((NameTagsHealthProviderMode) healthProviderSetting.getValue(this, DELEGATED_PROPERTIES[21]));
    }

    private void onRenderNameTagEvent(RenderNameTagEvent arg0) {
        arg0.cancel();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        DrawContext context = arg0.getContext();
        if (!(__UNDEF_KEY__)) {
            if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
                if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
                }
            }
        }
        this.executeAction(0.0F);
        textValue = "";
        Iterable iterable = ((Iterable) SharedKt.getWorld().getPlayers());
        int index = 0;
        Iterator iterator = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator12())).iterator();
        while (iterator.hasNext()) {
            iterable = ((AbstractClientPlayerEntity) iterator.next());
            if (!(__UNDEF_KEY__)) {
                if (!(__UNDEF_KEY__)) {
                }
                if (Intrinsics.areEqual(iterable, SharedKt.getMc().player) && SharedKt.getMc().options.method_31044().method_31034()) {
                }
                if (this.getHealth() == NameTagsHealthMode.Number) {
                }
                float factor = 0.55F;
                float factor2 = 0.4F;
                index = iterable.resolveVector4d(factor2, factor);
                String text = this.resolveString(((PlayerEntity) iterable));
                float factor3 = SFMServiceComponent.resolveFontRenderHelper6().computeValue(text);
                double offset = ((index.x + ((index.z - index.x) / 2.0F)) - (factor3 / 2.0F));
                if (!(__UNDEF_KEY__)) {
                    if (Float.isNaN(offset)) {
                    }
                }
                float factor4 = this.render(((PlayerEntity) iterable), context, index.x, index.y);
                int index2 = 0;
                double offset2 = (offset - 2);
                double offset3 = (((offset - 2) + factor3) + 4);
                float factor5 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
                if (!(__UNDEF_KEY__)) {
                    if (offset2 <= factor5) {
                        if (!(__UNDEF_KEY__)) {
                            if (factor5 <= offset3) {
                            }
                        }
                    } else {
                    }
                }
                if (0) {
                    offset2 = (index.y - 13.0F);
                    offset3 = ((index.y - 13.0F) + 12);
                    factor5 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
                    if (!(__UNDEF_KEY__)) {
                        if (offset2 <= factor5) {
                            if (!(__UNDEF_KEY__)) {
                                if (factor5 <= offset3) {
                                }
                            }
                        } else {
                        }
                    }
                    if (0 && SharedKt.getMc().currentScreen != null) {
                        textValue = iterable.method_7334().name();
                        index2 = 1;
                    }
                }
                if (EntityHelper4.isFriend(((PlayerEntity) iterable))) {
                    if (index2) {
                    }
                    arg0.getContext().method_51448().executeAction((offset - 2), (index.y - 13.0F), (factor3 + 4), 12.0F, 0.5F, 1.0F);
                    if (__UNDEF_KEY__) {
                        if (index2) {
                        }
                        arg0.getContext().method_51448().executeAction((offset - 2), (index.y - 13.0F), (factor3 + 4), 12.0F, 0.5F, 1.0F);
                    }
                }
                factor2 = 96;
                int index3 = 0;
                int index4 = 0;
                Color color = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), context.method_51448(), text, offset, (index.y - 13.0F), color, index4, index3, factor2, factor);
                if (!(__UNDEF_KEY__)) {
                    if (this.getHealth() != NameTagsHealthMode.Number) {
                        context.method_51448().pushMatrix();
                        this.render(this, index.x, index.y, context, ((PlayerEntity) iterable), iterable.method_45325(class_5134.field_23716), class_3532.method_15386(iterable.method_6032()), class_3532.method_15386(iterable.method_6067()));
                        context.method_51448().popMatrix();
                    }
                }
                if (this.getPotions()) {
                    factor4 = (factor4 - this.render(context, index.x, ((index.y + factor4) - 55), ((PlayerEntity) iterable)));
                }
                offset2 = iterable.method_6047().getItem();
                if (!(__UNDEF_KEY__)) {
                    if (!(__UNDEF_KEY__)) {
                        if (this.getShulkers() && SharedKt.getMc().currentScreen == null) {
                            context.method_51448().translate((index.x - 97.0F), ((index.y + factor4) - 20.0F));
                            if (!(__UNDEF_KEY__)) {
                            }
                            if (offset2 instanceof class_1747 && ((class_1747) offset2).method_7711() instanceof class_2480) {
                            }
                            offset3 = iterable.method_6079();
                            factor = offset3;
                            factor2 = iterable.method_6047();
                            context.render(factor2, factor);
                            context.method_51448().translate((index.x - 97.0F), ((index.y + factor4) - 20.0F));
                        }
                    }
                }
                if (!(__UNDEF_KEY__)) {
                }
                if (!(__UNDEF_KEY__)) {
                    if (!(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
                        if (!(__UNDEF_KEY__)) {
                            if (easingServiceComponent.getNumericValue() == 0.0F) {
                            } else {
                            }
                        }
                        if (!(0)) {
                            MissingnoRenderHelper.executeAction(missingnoRenderHelper, ((Matrix3x2f) context.method_51448()), (offset - 18.0D), (index.y - 16.0D), 0.0F, 0.0F, null, null, easingServiceComponent.getNumericValue());
                        }
                    }
                }
                context.method_51448().popMatrix();
            }
        }
        if (!(__UNDEF_KEY__)) {
            if (this.getSpawners()) {
                this.render(context);
            }
            if (!(__UNDEF_KEY__)) {
                if (this.getEntityOwner()) {
                    this.render2(context);
                }
            }
        }
        stackShaderComponent.executeAction(context.method_51448(), this.getFillColorA(), this.getOutlineColor(), true);
        stackShaderComponent2.executeAction(context.method_51448(), this.getFillColorF(), this.getFriendOutlineColor(), true);
        SFMServiceComponent.resolveFontRenderHelper6().executeAction();
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    private void onInputEvent(InputEvent arg0) {
        if (PlayerEntityHelper.INSTANCE.checkCondition(textValue)) {
            PlayerEntityHelper.INSTANCE.checkCondition2(textValue);
            MessageServiceComponent.S(this, (class_124.field_1061 + textValue + class_124.field_1080 + MessageServiceComponent.Z(this, "removed", new Object[0], false)), false);
        }
        PlayerEntityHelper.INSTANCE.checkCondition(textValue);
        MessageServiceComponent.S(this, (class_124.field_1060 + textValue + class_124.field_1080 + MessageServiceComponent.Z(this, "added", new Object[0], false)), false);
    }

    private float render(PlayerEntity arg0, DrawContext arg1, double arg2, double arg3) {
        List<BlockPos> list = new ArrayList();
        float factor = 0.0F;
        if (__UNDEF_KEY__) {
            if (this.getArmorMode() != NameTagsArmorMode.Durability) {
                list.add(arg0.method_6079());
            }
            list.add(EntityHelper2.resolveList(arg0).get(0));
            list.add(EntityHelper2.resolveList(arg0).get(1));
            list.add(EntityHelper2.resolveList(arg0).get(2));
            list.add(EntityHelper2.resolveList(arg0).get(3));
            if (__UNDEF_KEY__) {
                if (this.getArmorMode() != NameTagsArmorMode.Durability) {
                    list.add(arg0.method_6047());
                }
                arg1.method_51448().pushMatrix();
            }
        }
        float factor2 = 0.0F;
        if (this.getArmorMode() != NameTagsArmorMode.None) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                ItemStack stack = ((ItemStack) iterator.next());
                if (__UNDEF_KEY__) {
                    if (!(stack.isEmpty())) {
                        if (this.getArmorMode() == NameTagsArmorMode.Full) {
                            arg1.method_51448().pushMatrix();
                            arg1.method_51448().translate(((arg2 - 55.0F) + factor2), (arg3 - 33.0F));
                            arg1.method_51448().scale(1.1F, 1.1F);
                            arg1.method_51427(stack, 0, 0);
                            arg1.method_51431(SharedKt.getMc().field_1772, stack, 0, 0);
                            arg1.method_51448().popMatrix();
                            if (!(__UNDEF_KEY__)) {
                                int index = (stack.method_7936() - stack.method_7919());
                                int index2 = ((index / stack.method_7936()) * 100.0F);
                                if (__UNDEF_KEY__) {
                                    if (index2 < 33) {
                                    }
                                }
                                if (__UNDEF_KEY__) {
                                    if (34 <= index2) {
                                        if (__UNDEF_KEY__) {
                                            if (index2 < 66) {
                                            }
                                        }
                                    } else {
                                    }
                                }
                                if (0) {
                                }
                                Color color = Color.GREEN;
                                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg1.method_51448(), (index2), ((arg2 - 35.0F) + factor2), (arg3 - 22.0F), color, false);
                            }
                        }
                        index = 0.0F;
                        index2 = class_1890.method_57532(stack);
                        if (__UNDEF_KEY__) {
                            if (__UNDEF_KEY__) {
                                if (this.getOnlyHands()) {
                                    if (__UNDEF_KEY__) {
                                        if (!(Intrinsics.areEqual(stack, arg0.method_6079()))) {
                                            if (this.getEnchantss() && Intrinsics.areEqual(stack, arg0.method_6047())) {
                                                color = lookupMap.keySet().iterator();
                                                while (color.hasNext()) {
                                                    class_5321 class5321 = ((class_5321) color.next());
                                                    if (__UNDEF_KEY__) {
                                                    }
                                                    String text = ((String) lookupMap.get(class5321));
                                                    int index3 = index2.method_57536(((class_6880) ((class_2378) SharedKt.getWorld().method_30349().method_46759(class5321.method_58273()).get()).method_10223(class5321.method_29177()).get()));
                                                    String text2 = (text + index3);
                                                    int index4 = 96;
                                                    int index5 = 0;
                                                    int index6 = 0;
                                                    Color color2 = new Color(-1);
                                                    FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg1.method_51448(), text2, ((arg2 - 50.0F) + factor2), ((arg3 - 45) + index), color2, index6, index5, index4);
                                                    index = (index - 8.0F);
                                                    if (__UNDEF_KEY__) {
                                                    }
                                                    factor = index;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            factor2 = (factor2 + 18.0F);
                        }
                    }
                }
            }
        }
        return factor;
    }

    private String resolveString(PlayerEntity arg0) {
        if (ContentTypeServiceComponent.INSTANCE.checkCondition(arg0.method_7334().name())) {
        }
        String text = "";
        if (this.getPing()) {
            text = (text + this.resolveString(this.computeValue(arg0)) + this.computeValue(arg0) + "ms " + class_124.field_1068);
        }
        if (this.getGamemode()) {
            text = (text + this.resolveString(this.resolveMinecraftObject(arg0)));
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        CharSequence charSequence = ((CharSequence) noWhenBranchMatchedException);
        Collection collection = ((Collection) new ArrayList(charSequence.length()));
        int index = 0;
        if (index < charSequence.length()) {
            char ch = charSequence.charAt(index);
            if (((Character) lookupMap2.get(Character.valueOf(ch))) != null) {
            }
            collection.add(Character.valueOf(ch));
        }
        text = (text + CollectionsKt.joinToString$default(((Iterable) collection), ((CharSequence) "")));
        if (this.getHp() && this.getHealth() == NameTagsHealthMode.Number) {
            text = (text + this.resolveString(this.computeValue(arg0, this.getHealthProvider())) + this.computeValue(this.computeValue(arg0, this.getHealthProvider())) + class_124.field_1068);
        }
        if (this.getDistance()) {
            charSequence = new Object[1];
            charSequence[0] = Float.valueOf(SharedKt.getPlayer().distanceTo(arg0));
            text = (text + String.format("%.1f", charSequence) + "m ");
        }
        if (this.getPops() && EntityPacketHelper.INSTANCE.computeValue(arg0)) {
            text = (text + class_124.field_1070 + EntityPacketHelper.INSTANCE.computeValue(arg0));
        }
        return text;
    }

    private void render(DrawContext arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        while (iterator.hasNext()) {
            class_2586 class2586 = ((class_2586) iterator.next());
            Vector4d vector4d = PolygonShaderComponent.INSTANCE.resolveVector4d((((class_2636) class2586).method_11016().method_10263() + 0.5D), (((class_2636) class2586).method_11016().method_10264() + 1.5F), (((class_2636) class2586).method_11016().method_10260() + 0.5D));
            if (!(__UNDEF_KEY__)) {
                if (((class_2636) class2586).method_11390() != null) {
                    if (!(__UNDEF_KEY__)) {
                        if (((class_2636) class2586).method_11390().method_8283(((World) SharedKt.getWorld()), ((class_2636) class2586).method_11016()) == null) {
                        }
                    }
                }
            }
            String text = "%.1f";
            Object[] items = new Object[1];
            items[0] = Float.valueOf((((class_2636) class2586).method_11390().field_9154 / 20.0F));
            String text2 = (((class_2636) class2586).method_11390().method_8283(((World) SharedKt.getWorld()), ((class_2636) class2586).method_11016()).method_5477().getString() + String.format(text, Arrays.copyOf(items, items)));
            if (!(__UNDEF_KEY__)) {
                if (((class_2636) class2586).method_11390().method_8278() == ((class_2636) class2586).method_11390().method_8279()) {
                } else {
                }
            }
            if (!(__UNDEF_KEY__)) {
                if (((class_2636) class2586).method_11390().method_8278() == 0.0D) {
                } else {
                }
            }
            if (!(__UNDEF_KEY__)) {
                if ((((class_2636) class2586).method_11390().field_9154 / 20.0F) == 1.0F) {
                } else {
                }
            }
            if (0 && 0 && 0) {
                text2 = (((class_2636) class2586).method_11390().method_8283(((World) SharedKt.getWorld()), ((class_2636) class2586).method_11016()).method_5477().getString() + " loot!");
            }
            float factor = SFMServiceComponent.resolveFontRenderHelper6().computeValue(text2);
            text = ((vector4d.x + ((vector4d.z - vector4d.x) / 2.0F)) - (factor / 2));
            StackShaderComponent.executeAction(stackShaderComponent, arg0.method_51448(), (text - 2), (vector4d.y - 13.0F), (factor + 4), 11.0F, 0.0F);
            int index = 96;
            int index2 = 0;
            int index3 = 0;
            Color color = new Color(-1);
            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.method_51448(), text2, text, (vector4d.y - 12.5F), color, index3, index2, index);
        }
    }

    private void render2(DrawContext arg0) {
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        while (iterator.hasNext()) {
            Entity entity = iterator.next();
            String text = "";
            if (__UNDEF_KEY__) {
                if (entity instanceof class_1676) {
                    if (__UNDEF_KEY__) {
                        if (((class_1676) entity).method_24921() != null) {
                            text = ((class_1676) entity).method_24921().method_5476().getString();
                            if (__UNDEF_KEY__) {
                                if (entity instanceof class_1498) {
                                    if (((class_1498) entity).method_35057() != null) {
                                    }
                                    if (!(__UNDEF_KEY__) && null != null) {
                                        text = ((class_1498) entity).method_35057().method_5667().toString();
                                        if (!(__UNDEF_KEY__)) {
                                            if (__UNDEF_KEY__) {
                                                if (__UNDEF_KEY__) {
                                                }
                                            }
                                            if (__UNDEF_KEY__) {
                                                if (entity instanceof class_1321 && ((class_1321) entity).method_6181() && ((class_1321) entity).method_35057() != null) {
                                                    text = ((class_1321) entity).method_35057().method_5476().getString();
                                                    if (!(__UNDEF_KEY__)) {
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
            if (__UNDEF_KEY__) {
                if (!(((CharSequence) text).length())) {
                } else {
                }
            }
            if (0) {
            }
            Vector4d vector4d = PolygonShaderComponent.resolveVector4d(entity, 0.0F);
            String text2 = (1 + class_124.field_1080 + class_124.field_1070 + " " + text);
            float factor = SFMServiceComponent.resolveFontRenderHelper6().computeValue(text2);
            double offset = (((vector4d.x + ((vector4d.z - vector4d.x) / 2)) - (factor / 2)) * 1);
            StackShaderComponent.executeAction(stackShaderComponent, arg0.method_51448(), (offset - 2), (vector4d.y - 13.0F), (factor + 4), 12.0F, 0.0F);
            int index = 96;
            int index2 = 0;
            int index3 = 0;
            Color color = new Color(-1);
            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.method_51448(), text2, offset, (vector4d.y - 12.0F), color, index3, index2, index);
        }
    }

    public int computeValue(PlayerEntity entity) {
        if (!(__UNDEF_KEY__)) {
            if (SharedKt.getMc().method_1562() != null) {
                if (SharedKt.getMc().method_1562().method_2871(entity.method_5667()) == null) {
                    SharedKt.getMc().method_1562().method_2871(entity.method_5667());
                    return 0;
                }
            }
        }
        if (this.method_2959() != null) {
        }
        return null;
    }

    private class_1934 resolveMinecraftObject(PlayerEntity arg0) {
        if (arg0 == null) {
            return null;
        }
        if (SharedKt.getMc().method_1562().method_2871(arg0.method_5667()) != null) {
        }
        SharedKt.getMc().method_1562().method_2871(arg0.method_5667()).method_2958();
        return null;
    }

    private String resolveString(class_1934 arg0, long arg1) {
        if (arg0 == null) {
            return "[BOT]";
        }
        return new NoWhenBranchMatchedException();
    }

    public float computeValue(PlayerEntity ent, NameTagsHealthProviderMode healthProvider) {
        String text = "";
        float factor = 0.0F;
        class_269 class269 = ent.method_73183().method_8428();
        class_266 class266 = class269.method_1189(class_8646.field_45158);
        if (class266 != null) {
            text = class_9013.method_55398(class269.method_55430(((class_9015) ent), class266), class266.method_55380(((class_9022) class_9025.field_47566))).getString();
        } else {
        }
        factor = Float.parseFloat(text);
        return factor;
        text = SharedKt.getWorld().method_8428().method_1189(class_8646.field_45156);
        if (text != null) {
        } else {
            text.method_1118();
        }
        if (null == class_275.field_1471) {
            if (SharedKt.getWorld().method_8428().method_55430(class_9015.method_55420(ent.method_7334()), text) != null) {
            } else {
                Integer.valueOf(SharedKt.getWorld().method_8428().method_55430(class_9015.method_55420(ent.method_7334()), text).method_55397());
            }
            if (factor != null) {
                return factor;
            }
        }
        return 0.0F;
        return (ent.method_6032() + ent.method_6067());
    }

    private void render(double arg0, double arg1, DrawContext arg2, PlayerEntity arg3, float arg4, int arg5, int arg6) {
        arg2.method_51448().pushMatrix();
        arg2.method_51448().translate((arg0 - 44.0F), (arg1 + 1.0F));
        arg2.method_51448().scale(1.1F, 1.1F);
        int index = class_3532.method_15384((arg4 / 2.0D));
        int index2 = class_3532.method_15384((arg6 / 2.0D));
        int index3 = (index * 2);
        int index4 = 0;
        int index5 = ((index + index2) - 1);
        if (-1 < index5) {
            int index6 = (index5 % 10);
            int index7 = (index6 * 8);
            if (__UNDEF_KEY__) {
                if (index4 < 10) {
                    this.render(arg2, OptionMode11.CONTAINER, index7, false, arg3);
                }
            }
            int index8 = (index5 * 2);
            if (__UNDEF_KEY__) {
                if (index8 < arg5) {
                    if (__UNDEF_KEY__) {
                        if ((index8 + 1) == arg5) {
                        } else {
                        }
                    }
                    PlayerEntity player = arg3;
                    int index9 = 0;
                    int index10 = 1;
                    int index11 = index7;
                    OptionMode11 optionMode11 = OptionMode11.NORMAL;
                    arg2.render(optionMode11, index11, index10, index9, player);
                }
            }
            if (__UNDEF_KEY__) {
                if (index5 >= index) {
                    int index12 = (index8 - index3);
                    if (__UNDEF_KEY__) {
                        if ((index8 - index3) < arg6) {
                            arg2.method_51448().pushMatrix();
                            if (__UNDEF_KEY__) {
                                if ((index12 + 1) == arg6) {
                                } else {
                                }
                            }
                            player = arg3;
                            index9 = 0;
                            index10 = 1;
                            index11 = index7;
                            optionMode11 = OptionMode11.ABSORBING;
                            arg2.render(optionMode11, index11, index10, index9, player);
                            arg2.method_51448().popMatrix();
                        }
                    }
                }
            }
        }
        arg2.method_51448().popMatrix();
    }

    private void render(int arg0, DrawContext arg1, OptionMode11 arg2, int arg3, boolean arg4, PlayerEntity arg5) {
        if (this.getHealth() == NameTagsHealthMode.Dots) {
            if (EntityHelper4.isFriend(arg5)) {
            }
            Color color = this.getFillColorA();
            if (arg0 >= 0) {
                Color[] items = new Color[1];
                items[0] = color;
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 7.0F, 3.0F, items);
            }
            if (arg4) {
                items = new Color[1];
                items[0] = this.resolveColor((arg5.method_6032() + arg5.method_6067()));
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 3.0F, 3.0F, items);
                items = new Color[1];
                items[0] = color;
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), (arg3 + 3.0F), 0.0F, 4.0F, 3.0F, items);
                if (arg0 >= 0) {
                    items = new Color[1];
                    items[0] = this.resolveColor((arg5.method_6032() + arg5.method_6067()));
                    PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 7.0F, 3.0F, items);
                    if (arg0 > 0) {
                        arg1.method_52706(class_10799.field_56883, arg2.resolveMinecraftObject(arg4), arg3, 0, 9, 9);
                    }
                }
            }
        }
    }

    private String resolveString(float arg0) {
        if (arg0 <= 15.0F && arg0 > 7.0F) {
            return (class_124.field_1054);
        }
        if (arg0 > 15.0F) {
            return (class_124.field_1060);
        }
        return (class_124.field_1061);
    }

    private String resolveString(int arg0) {
        if (arg0 > TheNetherPacketHelper.f()) {
            return (class_124.field_1060);
        }
        if (arg0 <= TheNetherPacketHelper.f() && Math.abs((arg0 - TheNetherPacketHelper.f())) < 15) {
            return (class_124.field_1054);
        }
        return (class_124.field_1061);
    }

    private Color resolveColor(float arg0) {
        if (arg0 <= 15.0F && arg0 > 7.0F) {
            return Color.YELLOW;
        }
        if (arg0 > 15.0F) {
            return Color.GREEN;
        }
        return Color.RED;
    }

    public float computeValue(float value) {
        if (!(Float.isNaN(value))) {
            if (Float.isInfinite(value)) {
                return 1.0F;
            }
        }
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
    }

    private float render(DrawContext arg0, float arg1, float arg2, PlayerEntity arg3) {
        float factor = arg1;
        List<BlockPos> list = new ArrayList(arg3.method_6026());
        if (!(__UNDEF_KEY__)) {
            if (list.isEmpty()) {
                return 0.0F;
            }
            factor = (factor + (list.size() * 12.5F));
        }
        float factor2 = 0.0F;
        Iterator iterator = Ordering.natural().reverse().sortedCopy(((Iterable) list)).iterator();
        while (iterator.hasNext()) {
            class_1293 class1293 = ((class_1293) iterator.next());
            if (!(__UNDEF_KEY__)) {
                factor = (factor - 25.0F);
                String text = "";
                if (!(__UNDEF_KEY__)) {
                    text = "I";
                    if (__UNDEF_KEY__) {
                        text = "II";
                        if (__UNDEF_KEY__) {
                            text = "III";
                            if (__UNDEF_KEY__) {
                                text = "IV";
                                if (__UNDEF_KEY__) {
                                    text = "V";
                                }
                            }
                        }
                    }
                    arg0.method_51448().pushMatrix();
                    arg0.method_51448().translate(factor, arg2);
                    arg0.method_52707(class_10799.field_56883, class_329.method_71644(class1293.method_5579()), 0, 0, 18, 18, -1);
                }
                String text2 = this.resolveString(class1293);
                int index = 96;
                int index2 = 0;
                int index3 = 0;
                Color color = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg0.method_51448(), text2, (9.0F - (SFMServiceComponent.resolveFontRenderHelper().computeValue(text2) / 2.0F)), -8.0F, color, index3, index2, index);
                index = 96;
                index2 = 0;
                index3 = 0;
                color = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg0.method_51448(), text, (9.0F - (SFMServiceComponent.resolveFontRenderHelper().computeValue(text) / 2.0F)), -16.0F, color, index3, index2, index);
                arg0.method_51448().popMatrix();
                factor2 = 40.0F;
            }
        }
        return factor2;
    }

    private void render(long arg0, DrawContext arg1, int arg2, ItemStack arg3) {
        if (((class_9288) arg3.method_58694(class_9334.field_49622)) == null) {
            return;
        }
        Item item = arg3.getItem();
        if (arg0 > 0L) {
            if (__UNDEF_KEY__) {
            }
        }
        if (!(item instanceof class_1747) || arg2 < 0) {
            return;
        }
        StackShaderComponent.executeAction(stackShaderComponent, arg1.method_51448(), 12.0F, -79.0F, 169.0F, 60.0F, 0.0F);
        int index = 0;
        int index2 = 0;
        Iterator iterator = this.method_57489().toList().iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            arg1.method_51427(stack, (16 + (index2 * 18)), (-75 + (index * 18)));
            arg1.method_51431(SharedKt.getMc().field_1772, stack, (16 + (index2 * 18)), (-75 + (index * 18)));
            if (arg0 > 0L) {
                index2 = 0;
            }
        }
    }

    public String resolveString(class_1293 pe) {
        if (!(__UNDEF_KEY__)) {
            if (pe.method_48559()) {
            }
        }
        String text = "%02d";
        Object[] items = new Object[1];
        items[0] = Integer.valueOf(((pe.method_5584() % 1200) / 20));
        return ((pe.method_5584() / 1200) + String.format(text, Arrays.copyOf(items, items)));
    }

    private static boolean isActive() {
        return INSTANCE.getEnchantss();
    }

    static {
        KProperty[] items = new KProperty[22];
        INSTANCE = new NameTagsModule();
        seeCatleanUsersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "see-catlean-users", NameTagsSeeCatleanUsersMode.INSTANCE);
        nameModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "name-mode", NameTagsNameMode.FULL);
        componentsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "components", OptionMode14.BOOLS);
        gamemodeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gamemode", false, INSTANCE.getComponents());
        pingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ping", false, INSTANCE.getComponents());
        hpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "h-p", true, INSTANCE.getComponents());
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", true, INSTANCE.getComponents());
        popsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-pops", true, INSTANCE.getComponents());
        enchantssSetting = VisibleRenderHelper.registerSetting(INSTANCE, "enchants", true, INSTANCE.getComponents());
        onlyHandsSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "only-hands-enchants", false, INSTANCE.getComponents(), this::isActive);
        potionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potions", true, INSTANCE.getComponents());
        shulkersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulkers", true, INSTANCE.getComponents());
        selectionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        spawnersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spawners", false, INSTANCE.getSelection());
        entityOwnerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entity-owner", false, INSTANCE.getSelection());
        fillColorASetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(150, 150, 150, 255));
        outlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline", new Color(-1));
        fillColorFSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-fill", new Color(150, 150, 150, 255));
        friendOutlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-outline", new Color(0, 255, 0, 255));
        armorModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "armor-mode", NameTagsArmorMode.Full);
        healthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health", NameTagsHealthMode.Number);
        healthProviderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health-provider", NameTagsHealthProviderMode.Entity);
        lookupMap = ((Map) new HashMap());
        missingnoRenderHelper = new MissingnoRenderHelper("add-friend", 15, 15);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        stackShaderComponent = new StackShaderComponent();
        stackShaderComponent2 = new StackShaderComponent();
        items = new Pair[25];
        items[0] = TuplesKt.to(Character.valueOf(7424), Character.valueOf(65));
        items[1] = TuplesKt.to(Character.valueOf(665), Character.valueOf(66));
        items[2] = TuplesKt.to(Character.valueOf(7428), Character.valueOf(67));
        items[3] = TuplesKt.to(Character.valueOf(7429), Character.valueOf(68));
        items[4] = TuplesKt.to(Character.valueOf(7431), Character.valueOf(69));
        items[5] = TuplesKt.to(Character.valueOf(42800), Character.valueOf(70));
        items[6] = TuplesKt.to(Character.valueOf(610), Character.valueOf(71));
        items[7] = TuplesKt.to(Character.valueOf(668), Character.valueOf(72));
        items[8] = TuplesKt.to(Character.valueOf(618), Character.valueOf(73));
        items[9] = TuplesKt.to(Character.valueOf(7434), Character.valueOf(74));
        items[10] = TuplesKt.to(Character.valueOf(7435), Character.valueOf(75));
        items[11] = TuplesKt.to(Character.valueOf(671), Character.valueOf(76));
        items[12] = TuplesKt.to(Character.valueOf(7437), Character.valueOf(77));
        items[13] = TuplesKt.to(Character.valueOf(628), Character.valueOf(78));
        items[14] = TuplesKt.to(Character.valueOf(7439), Character.valueOf(79));
        items[15] = TuplesKt.to(Character.valueOf(7448), Character.valueOf(80));
        items[16] = TuplesKt.to(Character.valueOf(42927), Character.valueOf(81));
        items[17] = TuplesKt.to(Character.valueOf(640), Character.valueOf(82));
        items[18] = TuplesKt.to(Character.valueOf(42801), Character.valueOf(83));
        items[19] = TuplesKt.to(Character.valueOf(7451), Character.valueOf(84));
        items[20] = TuplesKt.to(Character.valueOf(7452), Character.valueOf(85));
        items[21] = TuplesKt.to(Character.valueOf(7456), Character.valueOf(86));
        items[22] = TuplesKt.to(Character.valueOf(7457), Character.valueOf(87));
        items[23] = TuplesKt.to(Character.valueOf(655), Character.valueOf(89));
        items[24] = TuplesKt.to(Character.valueOf(7458), Character.valueOf(90));
        lookupMap2 = MapsKt.mapOf(items);
        textValue = "";
        lookupMap.put(class_1893.field_9107, "B");
        lookupMap.put(class_1893.field_9111, "P");
        lookupMap.put(class_1893.field_9118, "S");
        lookupMap.put(class_1893.field_9131, "E");
        lookupMap.put(class_1893.field_9119, "U");
        lookupMap.put(class_1893.field_9103, "PO");
        lookupMap.put(class_1893.field_9097, "T");
    }

    public static void updateValue(int[] arg0) {
        countValueArray = arg0;
    }

    public static int[] process() {
        return countValueArray;
    }

}
