package su.catlean.client.features.modules.render.esp;

import com.mojang.blaze3d.systems.CommandEncoder;
import com.mojang.blaze3d.systems.GpuDevice;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;
import net.minecraft.class_10017;
import net.minecraft.class_10039;
import net.minecraft.class_11286;
import net.minecraft.class_11659;
import net.minecraft.class_11661;
import net.minecraft.class_11684;
import net.minecraft.class_1542;
import net.minecraft.class_1747;
import net.minecraft.class_2480;
import net.minecraft.class_276;
import net.minecraft.class_290;
import net.minecraft.class_315;
import net.minecraft.class_3532;
import net.minecraft.class_4184;
import net.minecraft.class_4597.class_4598;
import net.minecraft.class_4599;
import net.minecraft.class_6364;
import net.minecraft.class_7172;
import net.minecraft.class_757;
import net.minecraft.class_897;
import net.minecraft.class_898;
import net.minecraft.class_9288;
import net.minecraft.class_9334;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.joml.Matrix3x2fc;
import org.joml.Vector4d;
import su.catlean.SharedKt;
import su.catlean.api.event.GofraState;
import su.catlean.api.event.events.render.FrameBufferEvent;
import su.catlean.api.event.events.render.Render2DEvent;
import su.catlean.api.event.events.render.Render3DEvent;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl10;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl8;
import su.catlean.api.setting.DefaultValueVisibleSettingPropertyImpl9;
import su.catlean.api.setting.RangeVisibleSettingPropertyImpl2;
import su.catlean.api.setting.VisibleVisibleSettingPropertyImpl;
import su.catlean.client.features.modules.Module;
import su.catlean.client.features.modules.render.cosmetic.HandChamsModule;
import su.catlean.client.services.client.ItemsServiceComponent;
import su.catlean.client.services.client.ItemsServiceComponent2;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.module.category.SubCategoriesKt;
import su.catlean.client.services.render.FontRenderHelper;
import su.catlean.client.services.render.FormatRenderHelper;
import su.catlean.client.services.render.VisibleRenderHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.tools.comparators.Comparator3;
import su.catlean.client.types.mappings.ItemEspHighlightModeWhenMappings;
import su.catlean.mixins.accessors.GameRendererAccessor;

public class ItemEspModule extends Module {

    public static final ItemEspModule INSTANCE;
    private static final DefaultValueVisibleSettingPropertyImpl10 highlightSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 shaderModeSetting;
    private static final VisibleVisibleSettingPropertyImpl mergeSetting;
    private static final VisibleVisibleSettingPropertyImpl onePlateSetting;
    private static final VisibleVisibleSettingPropertyImpl shulkerLootSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 colorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 outlineColorSetting;
    private static final DefaultValueVisibleSettingPropertyImpl9 highLightColorSetting;
    private static final RangeVisibleSettingPropertyImpl2 lineWithValueSetting;
    private static final DefaultValueVisibleSettingPropertyImpl10 filterSetting;
    private static final DefaultValueVisibleSettingPropertyImpl8 itemsSetting;
    private static class_6364 minecraftRef;
    private static boolean enabledFlag;
    private static final StackShaderComponent stackShaderComponent;

    private ItemEspModule() {
        super("item-esp", SubCategoriesKt.getEspCategory());
    }

    private ItemEspHighlightMode getHighlight() {
        return (ItemEspHighlightMode) highlightSetting.getValue(this, DELEGATED_PROPERTIES[0]);
    }

    private ItemEspShaderMode getShaderMode() {
        return (ItemEspShaderMode) shaderModeSetting.getValue(this, DELEGATED_PROPERTIES[1]);
    }

    private boolean getMerge() {
        return (Boolean) mergeSetting.getValue(this, DELEGATED_PROPERTIES[2]);
    }

    private boolean getOnePlate() {
        return (Boolean) onePlateSetting.getValue(this, DELEGATED_PROPERTIES[3]);
    }

    private boolean getShulkerLoot() {
        return (Boolean) shulkerLootSetting.getValue(this, DELEGATED_PROPERTIES[4]);
    }

    private Color getColor() {
        return (Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[5]);
    }

    private Color getOutlineColor() {
        return (Color) outlineColorSetting.getValue(this, DELEGATED_PROPERTIES[6]);
    }

    private Color getHighLightColor() {
        return (Color) highLightColorSetting.getValue(this, DELEGATED_PROPERTIES[7]);
    }

    private float getLineWithValue() {
        return (Number) lineWithValueSetting.getValue(this, DELEGATED_PROPERTIES[8]);
    }

    private void setLineWithValue(float value) {
        lineWithValueSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private ItemEspFilterMode getFilter() {
        return (ItemEspFilterMode) filterSetting.getValue(this, DELEGATED_PROPERTIES[9]);
    }

    private ItemsServiceComponent2 getItems() {
        return (ItemsServiceComponent2) itemsSetting.getValue(this, DELEGATED_PROPERTIES[10]);
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer((class_276) minecraftRef);
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getHighlight() == ItemEspHighlightMode.SHADER) {
            this.executeAction();
            this.render(arg0.getStack());
        }
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            class_1542 var27 = (class_1542) iterator.next();
            TextShaderComponent2.checkCondition(TextShaderComponent2.INSTANCE.resolveMinecraftObject(), this.getHighLightColor());
            return;
            TextShaderComponent2.checkCondition(TextShaderComponent2.INSTANCE.resolveMinecraftObject(), PolygonShaderComponent.INSTANCE.resolveColor(this.getHighLightColor(), 1.0F));
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        List positions = this.resolveList();
        Iterable var68 = (Iterable) positions;
        int var69 = 0;
        Iterator iterator = CollectionsKt.sortedWith((Comparator) new Comparator3()).iterator();
        if (iterator.hasNext()) {
            var68 = (ItemsServiceComponent) iterator.next();
            var69 = Math.min(((class_1542) CollectionsKt.first(var68.getList()).field_6012 / 15.0F), 1.0F);
            Vector4d var70 = PolygonShaderComponent.INSTANCE.resolveVector4d(var68.resolveMinecraftObject());
            List positions2 = var68.resolveList();
            float var72 = 0.0F;
            Iterator iterator2 = positions2.iterator();
            while (iterator2.hasNext()) {
                String var74 = (String) iterator2.next();
                float var75 = SFMServiceComponent.resolveFontRenderHelper6().computeValue();
                var72 = var75;
            }
            iterator2 = ((var70.x + ((var70.z - var70.x) / 2.0F)) - (var72 / 2));
            if (this.getOnePlate()) {
                stackShaderComponent.executeAction(arg0.getContext().method_51448(), (iterator2 - 3.0F), ((var70.y - 1.0F) - (12.0F * positions2.size())), (var72 + 5.0F), (12.0F * positions2.size()));
            }
            var74 = (Iterable) positions2;
            var75 = 0;
            int var76 = 0;
            Iterator iterator3 = var74.iterator();
            while (iterator3.hasNext()) {
                Object var78 = iterator3.next();
                int var79 = var76;
                if (var79 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String var80 = (String) var78;
                int var81 = var79;
                int var82 = 0;
                if (!(INSTANCE.getOnePlate())) {
                    stackShaderComponent.executeAction(arg0.getContext().method_51448(), (((iterator2 - 3.0F) + (var72 / 2.0F)) - (SFMServiceComponent.resolveFontRenderHelper6().computeValue() / 2.0F)), ((var70.y - 13.0F) - (12.0F * var81)), (SFMServiceComponent.resolveFontRenderHelper6().computeValue() + 5.0F), 12.0F);
                }
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.getContext().method_51448(), (((iterator2 - 1.0F) + (var72 / 2.0F)) - (SFMServiceComponent.resolveFontRenderHelper6().computeValue() / 2.0F)), ((var70.y - 13.0F) - (12.0F * var81)), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE));
            }
            var75 = (Iterable) var68.getList();
            var76 = 0;
            iterator3 = var75;
            var78 = (Collection) new ArrayList();
            var79 = 0;
            var80 = iterator3.iterator();
            while (var80.hasNext()) {
                var81 = var80.next();
                var82 = (class_1542) var81;
                int var83 = 0;
                var78.add();
            }
            var74 = var78.iterator();
            while (var74.hasNext()) {
            }
            var75 = (class_1542) var74.next();
            arg0.getContext().method_51448().pushMatrix();
            arg0.getContext().method_51448().translate((var70.x - 58.2F), (var70.y - 4.0F));
            arg0.getContext().method_51448().scale(0.6F);
            this.render(arg0.getContext(), var75.method_6983(), 1.0F);
            arg0.getContext().method_51448().popMatrix();
        }
        stackShaderComponent.executeAction(arg0.getContext().method_51448(), this.getColor(), this.getOutlineColor(), 1);
        SFMServiceComponent.resolveFontRenderHelper6().executeAction();
        if (this.getHighlight() == ItemEspHighlightMode.FRAME) {
            int var61 = 4;
            int var62 = 0;
            int var63 = (this.resolveList().size() * 8);
            VertexFormat var64 = class_290.field_1576;
            iterator = new FormatRenderHelper();
            var68 = this.resolveList().iterator();
            while (var68.hasNext()) {
                var69 = (class_1542) var68.next();
                var70 = PolygonShaderComponent.INSTANCE.process();
                var72 = 0;
                iterator2 = var70;
                if (var72 < iterator2) {
                    var74 = var70[var72];
                    var75 = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(var74.field_1352, var74.field_1351, var74.field_1350));
                    if (var75.field_1350 > 0.0D) {
                        if (var75.field_1350 < 1.0D) {
                            if (positions2 == null) {
                                positions2 = new Vector4d(var75.field_1352, var75.field_1351, var75.field_1350, 0.0D);
                            }
                            positions2.x = Math.min(var75.field_1352, positions2.x);
                            positions2.y = Math.min(var75.field_1351, positions2.y);
                            positions2.z = Math.max(var75.field_1352, positions2.z);
                            positions2.w = Math.max(var75.field_1351, positions2.w);
                        }
                    }
                }
                var72 = positions2.x;
                iterator2 = positions2.y;
                var74 = positions2.z;
                var75 = positions2.w;
                PolygonShaderComponent.INSTANCE.executeAction(iterator, iterator2, this.getHighLightColor());
            }
            FormatRenderHelper.executeAction(iterator, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f((Matrix3x2fc) arg0.getContext().method_51448()));
        }
        if (this.getShaderMode() == ItemEspShaderMode.DEFAULT) {
        } else {
        }
        HandChamsModule.INSTANCE.executeAction(iterator, this.getHighLightColor(), minecraftRef, minecraftRef, 0, 0, 0.0F, 0.0F, 0.0F, this.getLineWithValue(), 0, Color.WHITE, Color.WHITE, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    }

    private List resolveList() {
        List positions = new ArrayList();
        List positions2 = this.resolveList();
        List positions3 = new ArrayList();
        Iterator iterator = positions2.iterator();
        while (iterator.hasNext()) {
            class_1542 var17 = (class_1542) iterator.next();
            if (positions3.contains()) {
            }
            List positions4 = new ArrayList();
            ItemsServiceComponent var18 = new ItemsServiceComponent(positions4);
            var18.getList().add();
            Iterator iterator2 = positions2.iterator();
            while (iterator2.hasNext()) {
                class_1542 var20 = (class_1542) iterator2.next();
                if (this.getMerge()) {
                } else {
                }
                var18.getList().add();
                positions3.add();
            }
            positions.add();
        }
        return CollectionsKt.distinct((Iterable) positions);
    }

    private void render(DrawContext arg0, ItemStack arg1, float arg2) {
        if ((class_9288) arg1.method_58694(class_9334.field_49622) == null) {
            return;
        }
        Item var10 = arg1.getItem();
        if (!(var10 instanceof class_1747) || !((class_1747) var10.method_7711() instanceof class_2480)) {
            return;
        }
        if (var9.method_57489().toList().isEmpty()) {
            return;
        }
        stackShaderComponent.executeAction(arg0.method_51448(), 12.0F, -79.0F, 169.0F, 60.0F, 2.0F);
        int var11 = 0;
        int var12 = 0;
        Iterator iterator = var9.method_57489().toList().iterator();
        while (iterator.hasNext()) {
            ItemStack stack = (ItemStack) iterator.next();
            arg0.method_51427(stack, (16 + (var12 * 18)), (-75 + (var11 * 18)));
            arg0.method_51431(SharedKt.getMc().field_1772, stack, (16 + (var12 * 18)), (-75 + (var11 * 18)));
            var12 = 0;
        }
    }

    private void render(MatrixStack arg0) {
        class_4184 var13 = SharedKt.getMc().field_1773.method_19418();
        float var14 = TextShaderComponent2.INSTANCE.computeValue();
        boolean var16 = (Boolean) SharedKt.getMc().options.method_42435().method_41753();
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(0));
        GofraState.INSTANCE.setModifyBuffer(1);
        enabledFlag = 1;
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix((GameRendererAccessor) SharedKt.getMc().field_1773.getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            class_1542 var18 = (class_1542) iterator.next();
            if (!(SharedKt.getMc().method_1561().method_3950(TextShaderComponent2.INSTANCE.getMinecraftObject(), var13.method_71156().field_1352, var13.method_71156().field_1351, var13.method_71156().field_1350))) {
            }
            double var19 = (class_3532.method_16436(var18.field_6038, var18.getX()) - var13.method_71156().field_1352);
            double var21 = (class_3532.method_16436(var18.field_5971, var18.getY()) - var13.method_71156().field_1351);
            double var23 = (class_3532.method_16436(var18.field_5989, var18.getZ()) - var13.method_71156().field_1350);
            class_10017 var26 = SharedKt.getMc().method_1561().method_3953().method_62425(TextShaderComponent2.INSTANCE.computeValue());
            class_10039 var25 = (class_10039) var26;
            var26 = (GameRendererAccessor) SharedKt.getMc().field_1773.getLevelRenderState().field_63082;
            SharedKt.getMc().method_1561().method_72976((class_10017) var25, arg0, (class_11659) SharedKt.getMc().field_1773.method_72910());
        }
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
        GofraState.INSTANCE.setModifyBuffer(0);
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf());
    }

    private void executeAction(char arg0) {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        } else {
            if (arg0 >= 0) {
                if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
                }
                if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
                }
                minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
            }
            RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
        }
    }

    private List resolveList(int arg0, char arg1) {
        Iterable var11 = SharedKt.getWorld().method_18112();
        int var12 = 0;
        Object var13 = var11;
        Collection var14 = (Collection) new ArrayList();
        int var15 = 0;
        Iterator iterator = var13.iterator();
        while (iterator.hasNext()) {
            Object var17 = iterator.next();
            if (arg1 >= 0) {
                var14.add();
            }
            var11 = (Iterable) var14;
            var12 = 0;
            var13 = var11;
            var14 = (Collection) new ArrayList();
            if (arg0 >= 0) {
                var15 = 0;
            }
        }
        iterator = var13.iterator();
        while (iterator.hasNext()) {
            var17 = iterator.next();
            class_1542 var18 = (class_1542) var17;
            int var19 = 0;
            var14.add();
        }
        return var14;
    }

    private boolean checkCondition(ItemStack arg0) {
        return !(this.getItems().getList().contains(arg0.getItem()));
    }

    private static boolean isActive() {
        return INSTANCE.getHighlight() == ItemEspHighlightMode.SHADER;
    }

    private static boolean isActive2() {
        return INSTANCE.getMerge();
    }

    private static boolean isActive3() {
        if (var6) {
            if (INSTANCE.getShaderMode() != ItemEspShaderMode.DEFAULT) {
            }
            if (INSTANCE.getHighlight() == ItemEspHighlightMode.SHADER) {
            }
        } else {
        }
        return false;
    }

    private static boolean isActive4() {
        return INSTANCE.getFilter() != ItemEspFilterMode.NONE;
    }

    static {
        KProperty[] var37 = new KProperty[11];
        INSTANCE = new ItemEspModule();
        highlightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "highlight", ItemEspHighlightMode.OFF);
        shaderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-mode", ItemEspShaderMode.DEFAULT, null, this::isActive);
        mergeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "merge");
        onePlateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "one-plate", 1, null, this::isActive2);
        shulkerLootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulkers");
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(150, 150, 150, 255));
        outlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline", new Color(-1));
        highLightColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "highlight-color", new Color(-1));
        lineWithValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-width", 4.0F, RangesKt.rangeTo(1.0F, 4.0F), null, this::isActive3);
        filterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "filter", ItemEspFilterMode.NONE);
        itemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "items", new ItemsServiceComponent2(), null, this::isActive4);
        stackShaderComponent = new StackShaderComponent();
    }

}
