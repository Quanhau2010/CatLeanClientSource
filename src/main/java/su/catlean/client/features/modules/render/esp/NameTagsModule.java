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
        return (NameTagsSeeCatleanUsersMode) seeCatleanUsersSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private NameTagsNameMode getNameMode() {
        return (NameTagsNameMode) nameModeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private SettingGroup getComponents() {
        return (SettingGroup) componentsSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getGamemode() {
        return (Boolean) gamemodeSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getPing() {
        return (Boolean) pingSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private boolean getHp() {
        return (Boolean) hpSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private boolean getDistance() {
        return (Boolean) distanceSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private boolean getPops() {
        return (Boolean) popsSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private boolean getEnchantss() {
        return (Boolean) enchantssSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private boolean getOnlyHands() {
        return (Boolean) onlyHandsSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private boolean getPotions() {
        return (Boolean) potionsSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private boolean getShulkers() {
        return (Boolean) shulkersSetting.getValue(this, DELEGATED_PROPERTIES[11]);
    }

    private SettingGroup getSelection() {
        return (SettingGroup) selectionSetting.getValue(this, DELEGATED_PROPERTIES[12]);
    }

    private boolean getSpawners() {
        return (Boolean) spawnersSetting.getValue(this, DELEGATED_PROPERTIES[13]);
    }

    private boolean getEntityOwner() {
        return (Boolean) entityOwnerSetting.getValue(this, DELEGATED_PROPERTIES[14]);
    }

    private Color getFillColorA() {
        return (Color) fillColorASetting.getValue(this, DELEGATED_PROPERTIES[15]);
    }

    private Color getOutlineColor() {
        return (Color) outlineColorSetting.getValue(this, DELEGATED_PROPERTIES[16]);
    }

    private Color getFillColorF() {
        return (Color) fillColorFSetting.getValue(this, DELEGATED_PROPERTIES[17]);
    }

    private Color getFriendOutlineColor() {
        return (Color) friendOutlineColorSetting.getValue(this, DELEGATED_PROPERTIES[18]);
    }

    private NameTagsArmorMode getArmorMode() {
        return (NameTagsArmorMode) armorModeSetting.getValue(this, DELEGATED_PROPERTIES[19]);
    }

    private NameTagsHealthMode getHealth() {
        return (NameTagsHealthMode) healthSetting.getValue(this, DELEGATED_PROPERTIES[20]);
    }

    public NameTagsHealthProviderMode getHealthProvider() {
        return (NameTagsHealthProviderMode) healthProviderSetting.getValue(this, DELEGATED_PROPERTIES[21]);
    }

    private void onRenderNameTagEvent(RenderNameTagEvent arg0) {
        if (!(var4)) {
        }
        arg0.cancel();
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        DrawContext context = arg0.getContext();
        if (!(var71)) {
            if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            }
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            }
        }
        1.0F.executeAction(0.0F);
        textValue = "";
        Iterable var74 = (Iterable) SharedKt.getWorld().getPlayers();
        int var75 = 0;
        Iterator iterator = CollectionsKt.sortedWith((Comparator) new Comparator12()).iterator();
        if (iterator.hasNext()) {
            var74 = (AbstractClientPlayerEntity) iterator.next();
            if (!(var71)) {
                if (!(var71)) {
                }
                if (Intrinsics.areEqual(SharedKt.getMc().player) && SharedKt.getMc().options.method_31044().method_31034()) {
                }
                if (this.getHealth() == NameTagsHealthMode.Number) {
                }
                float var66 = 0.55F;
                float var67 = 0.4F;
                var75 = var74.resolveVector4d();
                String var76 = this.resolveString((PlayerEntity) var74);
                float var77 = SFMServiceComponent.resolveFontRenderHelper6().computeValue();
                double var78 = ((var75.x + ((var75.z - var75.x) / 2.0F)) - (var77 / 2.0F));
                if (!(var71)) {
                    if (Float.isNaN()) {
                    }
                }
                float var79 = this.render((PlayerEntity) var74, context, var75.x, var75.y);
                int var80 = 0;
                float var81 = (var78 - 2);
                float var82 = (((var78 - 2) + var77) + 4);
                float var83 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue();
                if (!(var71)) {
                    if (var81 <= var83) {
                    }
                    if (!(var71)) {
                        if (var83 <= var82) {
                        }
                    }
                } else {
                }
                if (0) {
                    var81 = (var75.y - 13.0F);
                    var82 = ((var75.y - 13.0F) + 12);
                    var83 = POSITIONCOLORRenderHelper.INSTANCE.getNumericValue2();
                    if (!(var71)) {
                        if (var81 <= var83) {
                        }
                        if (!(var71)) {
                            if (var83 <= var82) {
                            }
                        }
                    } else {
                    }
                    if (0 && SharedKt.getMc().currentScreen != null) {
                        textValue = var74.method_7334().name();
                        var80 = 1;
                    }
                }
                if (EntityHelper4.isFriend((PlayerEntity) var74)) {
                    if (var80) {
                    }
                    arg0.getContext().method_51448().executeAction((var78 - 2), (var75.y - 13.0F), (var77 + 4), 12.0F, 0.5F, 1.0F);
                    if (var71) {
                    }
                    if (var80) {
                    }
                    arg0.getContext().method_51448().executeAction((var78 - 2), (var75.y - 13.0F), (var77 + 4), 12.0F, 0.5F, 1.0F);
                }
                var67 = 96;
                int var68 = 0;
                int var69 = 0;
                Color var70 = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), context.method_51448(), (var75.y - 13.0F));
                if (!(var71)) {
                    if (this.getHealth() != NameTagsHealthMode.Number) {
                        context.method_51448().pushMatrix();
                        var14.render(this, var75.x, var75.y, context, (PlayerEntity) var74, var74.method_45325(class_5134.field_23716), class_3532.method_15386(var74.method_6032()), class_3532.method_15386(var74.method_6067()));
                        context.method_51448().popMatrix();
                    }
                }
                if (this.getPotions()) {
                    var79 = (var79 - this.render(context, var75.x, ((var75.y + var79) - 55), (PlayerEntity) var74));
                }
                var81 = var74.method_6047().getItem();
                if (!(var71)) {
                    if (!(var71)) {
                        if (this.getShulkers() && SharedKt.getMc().currentScreen == null) {
                            context.method_51448().translate((var75.x - 97.0F), ((var75.y + var79) - 20.0F));
                            if (!(var71)) {
                            }
                            if (var81 instanceof class_1747 && (class_1747) var81.method_7711() instanceof class_2480) {
                            }
                            var82 = var74.method_6079();
                            var66 = var82;
                            var67 = var74.method_6047();
                            context.render();
                            context.method_51448().translate((var75.x - 97.0F), ((var75.y + var79) - 20.0F));
                        }
                    }
                }
                if (!(var71)) {
                }
                if (!(var71)) {
                    if (!(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
                    }
                    if (!(var71)) {
                        if (easingServiceComponent.getNumericValue() == 0.0F) {
                        }
                    } else {
                    }
                    if (!(0)) {
                    }
                    MissingnoRenderHelper.executeAction(missingnoRenderHelper, (Matrix3x2f) context.method_51448(), (var78 - 18.0D), (var75.y - 16.0D), 0.0F, 0.0F, null, null, easingServiceComponent.getNumericValue());
                }
                context.method_51448().popMatrix();
            }
        }
        if (!(var71)) {
            if (this.getSpawners()) {
                this.render(context);
            }
            if (!(var71)) {
            }
            if (this.getEntityOwner()) {
            }
            this.render2(context);
        }
        stackShaderComponent.executeAction(context.method_51448(), this.getFillColorA(), this.getOutlineColor(), 1);
        stackShaderComponent2.executeAction(context.method_51448(), this.getFillColorF(), this.getFriendOutlineColor(), 1);
        SFMServiceComponent.resolveFontRenderHelper6().executeAction();
        SFMServiceComponent.resolveFontRenderHelper().executeAction();
    }

    private void onInputEvent(InputEvent arg0) {
        if (var18) {
            if (!(StringsKt.isBlank((CharSequence) textValue))) {
            }
        } else {
        }
        if (var18) {
        }
        if (var18) {
            if (PlayerEntityHelper.INSTANCE.checkCondition(textValue)) {
                PlayerEntityHelper.INSTANCE.checkCondition2(textValue);
                MessageServiceComponent.S(this, (class_124.field_1061 + textValue + class_124.field_1080 + MessageServiceComponent.Z(this, "removed", new Object[0])));
            }
        }
        PlayerEntityHelper.INSTANCE.checkCondition(textValue);
        MessageServiceComponent.S(this, (class_124.field_1060 + textValue + class_124.field_1080 + MessageServiceComponent.Z(this, "added", new Object[0])));
    }

    private float render(PlayerEntity arg0, DrawContext arg1, double arg2, double arg3) {
        List<BlockPos> positions = new ArrayList();
        float var32 = 0.0F;
        if (var30) {
            if (this.getArmorMode() != NameTagsArmorMode.Durability) {
                positions.add(arg0.method_6079());
            }
            positions.add(EntityHelper2.resolveList(arg0).get(0));
            positions.add(EntityHelper2.resolveList(arg0).get(1));
            positions.add(EntityHelper2.resolveList(arg0).get(2));
            positions.add(EntityHelper2.resolveList(arg0).get(3));
            if (var30) {
            }
            if (this.getArmorMode() != NameTagsArmorMode.Durability) {
                positions.add(arg0.method_6047());
            }
            arg1.method_51448().pushMatrix();
        }
        float var33 = 0.0F;
        if (this.getArmorMode() != NameTagsArmorMode.None) {
            Iterator iterator = positions.iterator();
            if (iterator.hasNext()) {
                ItemStack stack = (ItemStack) iterator.next();
                if (var30) {
                    if (!(stack.isEmpty())) {
                        if (this.getArmorMode() == NameTagsArmorMode.Full) {
                            arg1.method_51448().pushMatrix();
                            arg1.method_51448().translate(((arg2 - 55.0F) + var33), (arg3 - 33.0F));
                            arg1.method_51448().scale(1.1F, 1.1F);
                            arg1.method_51427(stack, 0, 0);
                            arg1.method_51431(SharedKt.getMc().field_1772, stack, 0, 0);
                            arg1.method_51448().popMatrix();
                            if (!(var30)) {
                            }
                            int var36 = (stack.method_7936() - stack.method_7919());
                            float var37 = ((var36 / stack.method_7936()) * 100.0F);
                            if (var30) {
                                if (var37 < 33) {
                                }
                            }
                            if (var30) {
                                if (34 <= var37) {
                                    if (var30) {
                                    }
                                    if (var37 < 66) {
                                    }
                                }
                            } else {
                            }
                            if (0) {
                            }
                            Color var38 = Color.GREEN;
                            FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg1.method_51448(), (var37), ((arg2 - 35.0F) + var33), (arg3 - 22.0F));
                        }
                        var36 = 0.0F;
                        var37 = class_1890.method_57532(stack);
                        if (var30) {
                            if (var30) {
                                if (this.getOnlyHands()) {
                                }
                                if (var30) {
                                    if (!(Intrinsics.areEqual(stack, arg0.method_6079()))) {
                                    }
                                    if (this.getEnchantss() && Intrinsics.areEqual(stack, arg0.method_6047())) {
                                    }
                                }
                                var38 = lookupMap.keySet().iterator();
                                if (var38.hasNext()) {
                                    class_5321 var39 = (class_5321) var38.next();
                                    if (var30) {
                                    }
                                    String var40 = (String) lookupMap.get();
                                    int var41 = var37.method_57536((class_6880) (class_2378) SharedKt.getWorld().method_30349().method_46759(var39.method_58273()).get().method_10223(var39.method_29177()).get());
                                    String var42 = (var40 + var41);
                                    int var26 = 96;
                                    int var27 = 0;
                                    int var28 = 0;
                                    Color var29 = new Color(-1);
                                    FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg1.method_51448(), ((arg2 - 50.0F) + var33), ((arg3 - 45) + var36));
                                    var36 = (var36 - 8.0F);
                                    if (var30) {
                                    }
                                    var32 = var36;
                                }
                            }
                        }
                        var33 = (var33 + 18.0F);
                    }
                }
            }
        }
        return var32;
    }

    private String resolveString(PlayerEntity arg0) {
        if (ContentTypeServiceComponent.INSTANCE.checkCondition(arg0.method_7334().name())) {
        }
        String var44 = "";
        if (!(var43)) {
            if (this.getPing()) {
                var44 = (var44 + this.resolveString(this.computeValue(arg0)) + this.computeValue(arg0) + "ms " + class_124.field_1068);
            }
        }
        if (!(var43)) {
            if (this.getGamemode()) {
                var44 = (var44 + this.resolveString(this.resolveMinecraftObject(arg0)));
            }
        }
        NoWhenBranchMatchedException var45 = new NoWhenBranchMatchedException();
        CharSequence var46 = (CharSequence) var45;
        Object var55 = var44;
        int var47 = 0;
        Object var48 = var46;
        Collection var49 = (Collection) new ArrayList(var46.length());
        int var50 = 0;
        int var51 = 0;
        if (var51 < var48.length()) {
            char var52 = var48.charAt();
            int var53 = var52;
            Object var56 = var49;
            int var54 = 0;
            if (!(var43)) {
                if (!(var43)) {
                    if ((Character) lookupMap2.get(Character.valueOf()) != null) {
                    }
                }
                var56.add(Character.valueOf());
            }
            var44 = (var55 + CollectionsKt.joinToString$default((Iterable) var49, (CharSequence) ""));
        }
        if (!(var43)) {
            if (!(var43)) {
                if (this.getHp() && this.getHealth() == NameTagsHealthMode.Number) {
                    var44 = (var44 + this.resolveString(this.computeValue(arg0, this.getHealthProvider())) + this.computeValue(this.computeValue(arg0, this.getHealthProvider())) + class_124.field_1068);
                }
            }
        }
        if (!(var43)) {
            if (this.getDistance()) {
                var46 = new Object[1];
                var46[0] = Float.valueOf(SharedKt.getPlayer().distanceTo(arg0));
                var44 = (var44 + String.format("%.1f") + "m ");
            }
        }
        if (!(var43)) {
        }
        if (this.getPops() && EntityPacketHelper.INSTANCE.computeValue(arg0)) {
            var44 = (var44 + class_124.field_1070 + EntityPacketHelper.INSTANCE.computeValue(arg0));
        }
        return var44;
    }

    private void render(DrawContext arg0) {
        Iterator iterator = TheNetherPacketHelper.INSTANCE.getList().iterator();
        class_2586 var24 = (class_2586) iterator.next();
        Vector4d var25 = PolygonShaderComponent.INSTANCE.resolveVector4d(((class_2636) var24.method_11016().method_10263() + 0.5D), ((class_2636) var24.method_11016().method_10264() + 1.5F), ((class_2636) var24.method_11016().method_10260() + 0.5D));
        if (!(var22)) {
            if ((class_2636) var24.method_11390() != null) {
            }
            if (!(var22)) {
                if ((class_2636) var24.method_11390().method_8283((World) SharedKt.getWorld(), (class_2636) var24.method_11016()) == null) {
                }
            }
        }
        String var28 = "%.1f";
        Object[] var29 = new Object[1];
        var29[0] = Float.valueOf(((class_2636) var24.method_11390().field_9154 / 20.0F));
        String var26 = ((class_2636) var24.method_11390().method_8283((World) SharedKt.getWorld(), (class_2636) var24.method_11016()).method_5477().getString() + String.format(Arrays.copyOf()));
        if (!(var22)) {
            if ((class_2636) var24.method_11390().method_8278() == (class_2636) var24.method_11390().method_8279()) {
            }
        } else {
        }
        if (!(var22)) {
            if ((class_2636) var24.method_11390().method_8278() == 0.0D) {
            }
        } else {
        }
        if (!(var22)) {
            if (((class_2636) var24.method_11390().field_9154 / 20.0F) == 1.0F) {
            }
        } else {
        }
        if (0 && 0 && 0) {
            var26 = ((class_2636) var24.method_11390().method_8283((World) SharedKt.getWorld(), (class_2636) var24.method_11016()).method_5477().getString() + " loot!");
        }
        float var27 = SFMServiceComponent.resolveFontRenderHelper6().computeValue();
        var28 = ((var25.x + ((var25.z - var25.x) / 2.0F)) - (var27 / 2));
        StackShaderComponent.executeAction(stackShaderComponent, arg0.method_51448(), (var28 - 2), (var25.y - 13.0F), (var27 + 4), 11.0F, 0.0F);
        int var18 = 96;
        int var19 = 0;
        int var20 = 0;
        Color var21 = new Color(-1);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.method_51448(), (var25.y - 12.5F));
    }

    private void render2(DrawContext arg0) {
        Iterator iterator = SharedKt.getWorld().method_18112().iterator();
        Entity entity = iterator.next();
        String var24 = "";
        if (var21) {
            if (entity instanceof class_1676) {
                if (var21) {
                    if ((class_1676) entity.method_24921() != null) {
                    }
                    var24 = (class_1676) entity.method_24921().method_5476().getString();
                }
            }
            if (var21) {
                if (entity instanceof class_1498) {
                    if ((class_1498) entity.method_35057() != null) {
                    }
                    if (!(var21) && null != null) {
                        var24 = (class_1498) entity.method_35057().method_5667().toString();
                        if (!(var21)) {
                        }
                    }
                    if (var21) {
                        if (var21) {
                        }
                    }
                    if (var21) {
                        if (entity instanceof class_1321 && (class_1321) entity.method_6181() && (class_1321) entity.method_35057() != null) {
                        }
                        var24 = (class_1321) entity.method_35057().method_5476().getString();
                        if (!(var21)) {
                        }
                    }
                }
            }
        }
        if (var21) {
            if (!((CharSequence) var24.length())) {
            }
        } else {
        }
        if (0) {
        }
        Vector4d var25 = PolygonShaderComponent.resolveVector4d(entity, 0.0F);
        String var26 = (1 + class_124.field_1080 + class_124.field_1070 + " " + var24);
        float var27 = SFMServiceComponent.resolveFontRenderHelper6().computeValue();
        double var28 = (((var25.x + ((var25.z - var25.x) / 2)) - (var27 / 2)) * 1);
        StackShaderComponent.executeAction(stackShaderComponent, arg0.method_51448(), (var28 - 2), (var25.y - 13.0F), (var27 + 4), 12.0F, 0.0F);
        int var17 = 96;
        int var18 = 0;
        int var19 = 0;
        Color var20 = new Color(-1);
        FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.method_51448(), (var25.y - 12.0F));
    }

    public int computeValue(PlayerEntity entity) {
        if (!(var6)) {
            if (SharedKt.getMc().method_1562() != null) {
                if (SharedKt.getMc().method_1562().method_2871(entity.method_5667()) == null) {
                }
                SharedKt.getMc().method_1562().method_2871(entity.method_5667());
            }
            return 0;
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
        if (!(var4)) {
            if (arg0 == null) {
                return "[BOT]";
            }
        }
        Object var5 = arg0;
        return new NoWhenBranchMatchedException();
    }

    public float computeValue(PlayerEntity ent, NameTagsHealthProviderMode healthProvider) {
        String var8 = "";
        float var9 = 0.0F;
        class_269 var10 = ent.method_73183().method_8428();
        class_266 var11 = var10.method_1189(class_8646.field_45158);
        if (var11 != null) {
            Object var12 = var11;
            Object var13 = var12;
            int var14 = 0;
            var8 = class_9013.method_55398(var10.method_55430((class_9015) ent), var13.method_55380((class_9022) class_9025.field_47566)).getString();
        } else {
        }
        var9 = Float.parseFloat();
        return var9;
        var8 = SharedKt.getWorld().method_8428().method_1189(class_8646.field_45156);
        if (var8 != null) {
        } else {
            var8.method_1118();
        }
        if (null == class_275.field_1471) {
            if (SharedKt.getWorld().method_8428().method_55430(class_9015.method_55420(ent.method_7334())) != null) {
            } else {
                Integer.valueOf(SharedKt.getWorld().method_8428().method_55430(class_9015.method_55420(ent.method_7334())).method_55397());
            }
            if (var9 != null) {
                return var9;
            }
        }
        return 0.0F;
        return (ent.method_6032() + ent.method_6067());
    }

    private void render(double arg0, double arg1, DrawContext arg2, PlayerEntity arg3, float arg4, int arg5, int arg6) {
        arg2.method_51448().pushMatrix();
        arg2.method_51448().translate((arg0 - 44.0F), (arg1 + 1.0F));
        arg2.method_51448().scale(1.1F, 1.1F);
        int var21 = class_3532.method_15384((arg4 / 2.0D));
        int var22 = class_3532.method_15384((arg6 / 2.0D));
        int var23 = (var21 * 2);
        int var24 = 0;
        int var25 = ((var21 + var22) - 1);
        if (-1 < var25) {
            int var26 = (var25 % 10);
            int var27 = (var26 * 8);
            if (var20) {
                if (var24 < 10) {
                    this.render(arg2, OptionMode11.CONTAINER, 0, arg3);
                }
            }
            int var28 = (var25 * 2);
            if (var20) {
                if (var28 < arg5) {
                    if (var20) {
                        if ((var28 + 1) == arg5) {
                        }
                    } else {
                    }
                    Object var15 = arg3;
                    int var16 = 0;
                    int var17 = 1;
                    int var18 = var27;
                    OptionMode11 var19 = OptionMode11.NORMAL;
                    arg2.render();
                }
            }
            if (var20) {
                if (var25 >= var21) {
                }
                int var29 = (var28 - var23);
                if (var20) {
                    if ((var28 - var23) < arg6) {
                        arg2.method_51448().pushMatrix();
                        if (var20) {
                            if ((var29 + 1) == arg6) {
                            }
                        } else {
                        }
                        var15 = arg3;
                        var16 = 0;
                        var17 = 1;
                        var18 = var27;
                        var19 = OptionMode11.ABSORBING;
                        arg2.render();
                        arg2.method_51448().popMatrix();
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
            Color var26 = this.getFillColorA();
            if (arg0 >= 0 && var25) {
                if (arg2 == OptionMode11.CONTAINER) {
                    Color[] var27 = new Color[1];
                    var27[0] = var26;
                    PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 7.0F, 3.0F);
                }
            }
            if (arg4) {
                var27 = new Color[1];
                var27[0] = this.resolveColor((arg5.method_6032() + arg5.method_6067()));
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 3.0F, 3.0F);
                var27 = new Color[1];
                var27[0] = var26;
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), (arg3 + 3.0F), 0.0F, 4.0F, 3.0F);
                if (arg0 >= 0) {
                }
                var27 = new Color[1];
                var27[0] = this.resolveColor((arg5.method_6032() + arg5.method_6067()));
                PolygonShaderComponent.INSTANCE.executeAction(arg1.method_51448(), arg3, 0.0F, 7.0F, 3.0F);
                if (arg0 > 0) {
                }
            }
            arg1.method_52706(class_10799.field_56883, arg2.resolveMinecraftObject(arg4), arg3, 0, 9, 9);
        }
    }

    private String resolveString(float arg0) {
        if (arg0 <= 15.0F) {
            if (var4 && var4) {
                if (arg0 > 7.0F) {
                    return (class_124.field_1054);
                }
            }
        }
        if (arg0 > 15.0F) {
            return (class_124.field_1060);
        }
        return (class_124.field_1061);
    }

    private String resolveString(int arg0) {
        if (!(var7)) {
            if (arg0 > TheNetherPacketHelper.f()) {
                return (class_124.field_1060);
            }
        }
        if (!(var7)) {
        }
        if (arg0 <= TheNetherPacketHelper.f() && Math.abs((arg0 - TheNetherPacketHelper.f())) < 15) {
            return (class_124.field_1054);
        }
        return (class_124.field_1061);
    }

    private Color resolveColor(float arg0) {
        if (arg0 <= 15.0F) {
            if (var4 && var4) {
                if (arg0 > 7.0F) {
                    return Color.YELLOW;
                }
            }
        }
        if (arg0 > 15.0F) {
            return Color.GREEN;
        }
        return Color.RED;
    }

    public float computeValue(float value) {
        if (!(var4)) {
            if (!(Float.isNaN(value))) {
                if (!(var4)) {
                    if (Float.isInfinite(value)) {
                    }
                }
                return 1.0F;
            }
        }
        return new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
    }

    private float render(DrawContext arg0, float arg1, float arg2, PlayerEntity arg3) {
        float var22 = arg1;
        List<BlockPos> positions = new ArrayList(arg3.method_6026());
        if (!(var21)) {
            if (positions.isEmpty()) {
                return 0.0F;
            }
            var22 = (var22 + (positions.size() * 12.5F));
        }
        float var24 = 0.0F;
        Iterator iterator = Ordering.natural().reverse().sortedCopy((Iterable) positions).iterator();
        if (iterator.hasNext()) {
            class_1293 var26 = (class_1293) iterator.next();
            if (!(var21)) {
                var22 = (var22 - 25.0F);
                String var27 = "";
                if (!(var21)) {
                    var27 = "I";
                    if (var21) {
                        var27 = "II";
                        if (var21) {
                            var27 = "III";
                            if (var21) {
                                var27 = "IV";
                                if (var21) {
                                    var27 = "V";
                                }
                            }
                        }
                    }
                    arg0.method_51448().pushMatrix();
                    arg0.method_51448().translate(arg2);
                    arg0.method_52707(class_10799.field_56883, class_329.method_71644(var26.method_5579()), 0, 0, 18, 18, -1);
                }
                String var28 = this.resolveString();
                int var17 = 96;
                int var18 = 0;
                int var19 = 0;
                Color var20 = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg0.method_51448(), (9.0F - (SFMServiceComponent.resolveFontRenderHelper().computeValue() / 2.0F)), -8.0F);
                var17 = 96;
                var18 = 0;
                var19 = 0;
                var20 = new Color(-1);
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper(), arg0.method_51448(), (9.0F - (SFMServiceComponent.resolveFontRenderHelper().computeValue() / 2.0F)), -16.0F);
                arg0.method_51448().popMatrix();
                var24 = 40.0F;
            }
        }
        return var24;
    }

    private void render(long arg0, DrawContext arg1, int arg2, ItemStack arg3) {
        if (!(var12) || (class_9288) arg3.method_58694(class_9334.field_49622) == null) {
            return;
        }
        class_9288 var13 = (class_9288) arg3.method_58694(class_9334.field_49622);
        Item var14 = arg3.getItem();
        if (arg0 > 0L) {
            if (var12) {
            }
        }
        if (!(var14 instanceof class_1747) || arg2 < 0) {
            return;
        }
        if (var12) {
            if ((class_1747) var14.method_7711() instanceof class_2480) {
                return;
            }
            StackShaderComponent.executeAction(stackShaderComponent, arg1.method_51448(), 12.0F, -79.0F, 169.0F, 60.0F, 0.0F);
        }
        int var15 = 0;
        int var16 = 0;
        Iterator iterator = var13.method_57489().toList().iterator();
        if (iterator.hasNext()) {
            ItemStack stack = (ItemStack) iterator.next();
            arg1.method_51427(stack, (16 + (var16 * 18)), (-75 + (var15 * 18)));
            arg1.method_51431(SharedKt.getMc().field_1772, stack, (16 + (var16 * 18)), (-75 + (var15 * 18)));
            if (arg0 > 0L) {
                if (var12) {
                }
                var16 = 0;
            }
        }
    }

    public String resolveString(class_1293 pe) {
        if (!(var7)) {
            if (pe.method_48559()) {
            }
        }
        String var8 = "%02d";
        Object[] var9 = new Object[1];
        var9[0] = Integer.valueOf(((pe.method_5584() % 1200) / 20));
        return ((pe.method_5584() / 1200) + String.format(Arrays.copyOf()));
    }

    private static boolean isActive() {
        return INSTANCE.getEnchantss();
    }

    static {
        KProperty[] var51 = new KProperty[22];
        INSTANCE = new NameTagsModule();
        seeCatleanUsersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "see-catlean-users", NameTagsSeeCatleanUsersMode.INSTANCE);
        nameModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "name-mode", NameTagsNameMode.FULL);
        componentsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "components", OptionMode14.BOOLS);
        gamemodeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "gamemode", 0, INSTANCE.getComponents());
        pingSetting = VisibleRenderHelper.registerSetting(INSTANCE, "ping", 0, INSTANCE.getComponents());
        hpSetting = VisibleRenderHelper.registerSetting(INSTANCE, "h-p", 1, INSTANCE.getComponents());
        distanceSetting = VisibleRenderHelper.registerSetting(INSTANCE, "distance", 1, INSTANCE.getComponents());
        popsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "totem-pops", 1, INSTANCE.getComponents());
        enchantssSetting = VisibleRenderHelper.registerSetting(INSTANCE, "enchants", 1, INSTANCE.getComponents());
        onlyHandsSetting = VisibleRenderHelper.resolveVisibleVisibleSettingPropertyImpl(INSTANCE, "only-hands-enchants", 0, INSTANCE.getComponents(), this::isActive);
        potionsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "potions", 1, INSTANCE.getComponents());
        shulkersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulkers", 1, INSTANCE.getComponents());
        selectionSetting = VisibleRenderHelper.registerSetting(INSTANCE, "selection", OptionMode14.BOOLS);
        spawnersSetting = VisibleRenderHelper.registerSetting(INSTANCE, "spawners", 0, INSTANCE.getSelection());
        entityOwnerSetting = VisibleRenderHelper.registerSetting(INSTANCE, "entity-owner", 0, INSTANCE.getSelection());
        fillColorASetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(150, 150, 150, 255));
        outlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline", new Color(-1));
        fillColorFSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-fill", new Color(150, 150, 150, 255));
        friendOutlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "friend-outline", new Color(0, 255, 0, 255));
        armorModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "armor-mode", NameTagsArmorMode.Full);
        healthSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health", NameTagsHealthMode.Number);
        healthProviderSetting = VisibleRenderHelper.registerSetting(INSTANCE, "health-provider", NameTagsHealthProviderMode.Entity);
        lookupMap = (Map) new HashMap();
        missingnoRenderHelper = new MissingnoRenderHelper("add-friend", 15, 15);
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        stackShaderComponent = new StackShaderComponent();
        stackShaderComponent2 = new StackShaderComponent();
        var51 = new Pair[25];
        var51[0] = TuplesKt.to(Character.valueOf(7424), Character.valueOf(65));
        var51[1] = TuplesKt.to(Character.valueOf(665), Character.valueOf(66));
        var51[2] = TuplesKt.to(Character.valueOf(7428), Character.valueOf(67));
        var51[3] = TuplesKt.to(Character.valueOf(7429), Character.valueOf(68));
        var51[4] = TuplesKt.to(Character.valueOf(7431), Character.valueOf(69));
        var51[5] = TuplesKt.to(Character.valueOf(42800), Character.valueOf(70));
        var51[6] = TuplesKt.to(Character.valueOf(610), Character.valueOf(71));
        var51[7] = TuplesKt.to(Character.valueOf(668), Character.valueOf(72));
        var51[8] = TuplesKt.to(Character.valueOf(618), Character.valueOf(73));
        var51[9] = TuplesKt.to(Character.valueOf(7434), Character.valueOf(74));
        var51[10] = TuplesKt.to(Character.valueOf(7435), Character.valueOf(75));
        var51[11] = TuplesKt.to(Character.valueOf(671), Character.valueOf(76));
        var51[12] = TuplesKt.to(Character.valueOf(7437), Character.valueOf(77));
        var51[13] = TuplesKt.to(Character.valueOf(628), Character.valueOf(78));
        var51[14] = TuplesKt.to(Character.valueOf(7439), Character.valueOf(79));
        var51[15] = TuplesKt.to(Character.valueOf(7448), Character.valueOf(80));
        var51[16] = TuplesKt.to(Character.valueOf(42927), Character.valueOf(81));
        var51[17] = TuplesKt.to(Character.valueOf(640), Character.valueOf(82));
        var51[18] = TuplesKt.to(Character.valueOf(42801), Character.valueOf(83));
        var51[19] = TuplesKt.to(Character.valueOf(7451), Character.valueOf(84));
        var51[20] = TuplesKt.to(Character.valueOf(7452), Character.valueOf(85));
        var51[21] = TuplesKt.to(Character.valueOf(7456), Character.valueOf(86));
        var51[22] = TuplesKt.to(Character.valueOf(7457), Character.valueOf(87));
        var51[23] = TuplesKt.to(Character.valueOf(655), Character.valueOf(89));
        var51[24] = TuplesKt.to(Character.valueOf(7458), Character.valueOf(90));
        lookupMap2 = MapsKt.mapOf();
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
