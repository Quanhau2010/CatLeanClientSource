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
        return ((ItemEspHighlightMode) highlightSetting.getValue(this, DELEGATED_PROPERTIES[0]));
    }

    private ItemEspShaderMode getShaderMode() {
        return ((ItemEspShaderMode) shaderModeSetting.getValue(this, DELEGATED_PROPERTIES[1]));
    }

    private boolean getMerge() {
        return ((Boolean) mergeSetting.getValue(this, DELEGATED_PROPERTIES[2]));
    }

    private boolean getOnePlate() {
        return ((Boolean) onePlateSetting.getValue(this, DELEGATED_PROPERTIES[3]));
    }

    private boolean getShulkerLoot() {
        return ((Boolean) shulkerLootSetting.getValue(this, DELEGATED_PROPERTIES[4]));
    }

    private Color getColor() {
        return ((Color) colorSetting.getValue(this, DELEGATED_PROPERTIES[5]));
    }

    private Color getOutlineColor() {
        return ((Color) outlineColorSetting.getValue(this, DELEGATED_PROPERTIES[6]));
    }

    private Color getHighLightColor() {
        return ((Color) highLightColorSetting.getValue(this, DELEGATED_PROPERTIES[7]));
    }

    private float getLineWithValue() {
        return ((Number) lineWithValueSetting.getValue(this, DELEGATED_PROPERTIES[8]));
    }

    private void setLineWithValue(float value) {
        lineWithValueSetting.setValue(this, DELEGATED_PROPERTIES[8], Float.valueOf(value));
    }

    private ItemEspFilterMode getFilter() {
        return ((ItemEspFilterMode) filterSetting.getValue(this, DELEGATED_PROPERTIES[9]));
    }

    private ItemsServiceComponent2 getItems() {
        return ((ItemsServiceComponent2) itemsSetting.getValue(this, DELEGATED_PROPERTIES[10]));
    }

    private void onFrameBufferEvent(FrameBufferEvent arg0) {
        arg0.setFrameBuffer(((class_276) minecraftRef));
        arg0.cancel();
    }

    private void onRender3DEvent(Render3DEvent arg0) {
        if (this.getHighlight() == ItemEspHighlightMode.SHADER) {
            this.executeAction();
            this.render(arg0.getStack());
        }
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            class_1542 class1542 = ((class_1542) iterator.next());
            TextShaderComponent2.checkCondition(TextShaderComponent2.INSTANCE.resolveMinecraftObject(class1542), this.getHighLightColor());
            return;
            TextShaderComponent2.checkCondition(TextShaderComponent2.INSTANCE.resolveMinecraftObject(class1542), PolygonShaderComponent.INSTANCE.resolveColor(this.getHighLightColor(), 1.0F));
        }
    }

    private void onRender2DEvent(Render2DEvent arg0) {
        List list = this.resolveList();
        Iterable iterable = ((Iterable) list);
        int index = 0;
        Iterator iterator = CollectionsKt.sortedWith(iterable, ((Comparator) new Comparator3())).iterator();
        while (iterator.hasNext()) {
            iterable = ((ItemsServiceComponent) iterator.next());
            index = Math.min((((class_1542) CollectionsKt.first(iterable.getList())).field_6012 / 15.0F), 1.0F);
            Vector4d vector4d = PolygonShaderComponent.INSTANCE.resolveVector4d(iterable.resolveMinecraftObject());
            List list2 = iterable.resolveList();
            float factor = 0.0F;
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                String text = ((String) iterator2.next());
                float factor2 = SFMServiceComponent.resolveFontRenderHelper6().computeValue(text);
                factor = factor2;
            }
            iterator2 = ((vector4d.x + ((vector4d.z - vector4d.x) / 2.0F)) - (factor / 2));
            if (this.getOnePlate()) {
                stackShaderComponent.executeAction(arg0.getContext().method_51448(), (iterator2 - 3.0F), ((vector4d.y - 1.0F) - (12.0F * list2.size())), (factor + 5.0F), (12.0F * list2.size()), index);
            }
            text = ((Iterable) list2);
            factor2 = 0;
            int index2 = 0;
            Iterator iterator3 = text.iterator();
            while (iterator3.hasNext()) {
                Object element = iterator3.next();
                int index3 = index2;
                if (index3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String text2 = ((String) element);
                int index4 = index3;
                int index5 = 0;
                if (!(INSTANCE.getOnePlate())) {
                    stackShaderComponent.executeAction(arg0.getContext().method_51448(), (((iterator2 - 3.0F) + (factor / 2.0F)) - (SFMServiceComponent.resolveFontRenderHelper6().computeValue(text2) / 2.0F)), ((vector4d.y - 13.0F) - (12.0F * index4)), (SFMServiceComponent.resolveFontRenderHelper6().computeValue(text2) + 5.0F), 12.0F, index);
                }
                FontRenderHelper.W(SFMServiceComponent.resolveFontRenderHelper6(), arg0.getContext().method_51448(), text2, (((iterator2 - 1.0F) + (factor / 2.0F)) - (SFMServiceComponent.resolveFontRenderHelper6().computeValue(text2) / 2.0F)), ((vector4d.y - 13.0F) - (12.0F * index4)), PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, index), false);
            }
            factor2 = ((Iterable) iterable.getList());
            index2 = 0;
            iterator3 = factor2;
            element = ((Collection) new ArrayList());
            index3 = 0;
            text2 = iterator3.iterator();
            while (text2.hasNext()) {
                index4 = text2.next();
                index5 = ((class_1542) index4);
                element.add(index4);
            }
            text = element.iterator();
            while (text.hasNext()) {
            }
            factor2 = ((class_1542) text.next());
            arg0.getContext().method_51448().pushMatrix();
            arg0.getContext().method_51448().translate((vector4d.x - 58.2F), (vector4d.y - 4.0F));
            arg0.getContext().method_51448().scale(0.6F);
            this.render(arg0.getContext(), factor2.method_6983(), 1.0F);
            arg0.getContext().method_51448().popMatrix();
        }
        stackShaderComponent.executeAction(arg0.getContext().method_51448(), this.getColor(), this.getOutlineColor(), true);
        SFMServiceComponent.resolveFontRenderHelper6().executeAction();
        if (this.getHighlight() == ItemEspHighlightMode.FRAME) {
            int index6 = 4;
            int index7 = 0;
            int index8 = (this.resolveList().size() * 8);
            VertexFormat vertexFormat = class_290.field_1576;
            iterator = new FormatRenderHelper(vertexFormat, index8, index7, index6);
            iterable = this.resolveList().iterator();
            while (iterable.hasNext()) {
                index = ((class_1542) iterable.next());
                vector4d = PolygonShaderComponent.INSTANCE.process(index);
                factor = 0;
                iterator2 = vector4d;
                if (factor < iterator2) {
                    text = vector4d[factor];
                    factor2 = PolygonShaderComponent.INSTANCE.resolveMinecraftObject(new Vec3d(text.field_1352, text.field_1351, text.field_1350));
                    if (factor2.field_1350 > 0.0D) {
                        if (factor2.field_1350 < 1.0D) {
                            if (list2 == null) {
                                list2 = new Vector4d(factor2.field_1352, factor2.field_1351, factor2.field_1350, 0.0D);
                            }
                            list2.x = Math.min(factor2.field_1352, list2.x);
                            list2.y = Math.min(factor2.field_1351, list2.y);
                            list2.z = Math.max(factor2.field_1352, list2.z);
                            list2.w = Math.max(factor2.field_1351, list2.w);
                        }
                    }
                }
                factor = list2.x;
                iterator2 = list2.y;
                text = list2.z;
                factor2 = list2.w;
                PolygonShaderComponent.INSTANCE.executeAction(iterator, factor, iterator2, text, factor2, this.getHighLightColor());
            }
            FormatRenderHelper.executeAction(iterator, VertexUBOShaderComponent.INSTANCE.getRenderPipeline22(), null, null, null, new Matrix3x2f(((Matrix3x2fc) arg0.getContext().method_51448())));
        }
        if (this.getShaderMode() == ItemEspShaderMode.DEFAULT) {
        } else {
        }
        HandChamsModule.INSTANCE.executeAction(iterator, this.getHighLightColor(), minecraftRef, minecraftRef, false, false, 0.0F, 0.0F, 0.0F, this.getLineWithValue(), 0, Color.WHITE, Color.WHITE, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    }

    private List resolveList() {
        List list = new ArrayList();
        List list2 = this.resolveList();
        List list3 = new ArrayList();
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            class_1542 class1542 = ((class_1542) iterator.next());
            if (list3.contains(class1542)) {
            }
            List list4 = new ArrayList();
            ItemsServiceComponent itemsServiceComponent = new ItemsServiceComponent(list4);
            itemsServiceComponent.getList().add(class1542);
            Iterator iterator2 = list2.iterator();
            while (iterator2.hasNext()) {
                class_1542 class15422 = ((class_1542) iterator2.next());
                if (this.getMerge()) {
                } else {
                }
                itemsServiceComponent.getList().add(class15422);
                list3.add(class15422);
            }
            list.add(itemsServiceComponent);
        }
        return CollectionsKt.distinct(((Iterable) list));
    }

    private void render(DrawContext arg0, ItemStack arg1, float arg2) {
        if (((class_9288) arg1.method_58694(class_9334.field_49622)) == null) {
            return;
        }
        Item item = arg1.getItem();
        if (!(item instanceof class_1747) || !(((class_1747) item).method_7711() instanceof class_2480)) {
            return;
        }
        if (this.method_57489().toList().isEmpty()) {
            return;
        }
        stackShaderComponent.executeAction(arg0.method_51448(), 12.0F, -79.0F, 169.0F, 60.0F, 2.0F);
        int index = 0;
        int index2 = 0;
        Iterator iterator = this.method_57489().toList().iterator();
        while (iterator.hasNext()) {
            ItemStack stack = ((ItemStack) iterator.next());
            arg0.method_51427(stack, (16 + (index2 * 18)), (-75 + (index * 18)));
            arg0.method_51431(SharedKt.getMc().field_1772, stack, (16 + (index2 * 18)), (-75 + (index * 18)));
            index2 = 0;
        }
    }

    private void render(MatrixStack arg0) {
        class_4184 class4184 = SharedKt.getMc().field_1773.method_19418();
        float factor = TextShaderComponent2.INSTANCE.computeValue();
        boolean flag = ((Boolean) SharedKt.getMc().options.method_42435().method_41753());
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(false));
        GofraState.INSTANCE.setModifyBuffer(true);
        enabledFlag = 1;
        RenderSystem.backupProjectionMatrix();
        RenderSystem.setProjectionMatrix(((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelProjectionMatrixBuffer().method_71123(TextShaderComponent2.INSTANCE.getMatrix4f()), RenderSystem.getProjectionType());
        Iterator iterator = this.resolveList().iterator();
        while (iterator.hasNext()) {
            class_1542 class1542 = ((class_1542) iterator.next());
            if (!(SharedKt.getMc().method_1561().method_3950(class1542, TextShaderComponent2.INSTANCE.getMinecraftObject(), class4184.method_71156().field_1352, class4184.method_71156().field_1351, class4184.method_71156().field_1350))) {
            }
            double offset = (class_3532.method_16436(factor, class1542.field_6038, class1542.getX()) - class4184.method_71156().field_1352);
            double offset2 = (class_3532.method_16436(factor, class1542.field_5971, class1542.getY()) - class4184.method_71156().field_1351);
            double offset3 = (class_3532.method_16436(factor, class1542.field_5989, class1542.getZ()) - class4184.method_71156().field_1350);
            class_10017 class10017 = SharedKt.getMc().method_1561().method_3953(class1542).method_62425(class1542, TextShaderComponent2.INSTANCE.computeValue());
            class_10039 class10039 = ((class_10039) class10017);
            class10017 = ((GameRendererAccessor) SharedKt.getMc().field_1773).getLevelRenderState().field_63082;
            SharedKt.getMc().method_1561().method_72976(((class_10017) class10039), class10017, offset, offset2, offset3, arg0, ((class_11659) SharedKt.getMc().field_1773.method_72910()));
        }
        SharedKt.getMc().field_1773.method_72911().method_73002();
        SharedKt.getMc().method_22940().method_23000().method_22993();
        SharedKt.getMc().field_1773.method_72910().method_72953();
        RenderSystem.restoreProjectionMatrix();
        enabledFlag = 0;
        GofraState.INSTANCE.setModifyBuffer(false);
        SharedKt.getMc().options.method_42435().method_41748(Boolean.valueOf(flag));
    }

    private void executeAction(char arg0) {
        if (minecraftRef == null) {
            minecraftRef = new class_6364(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
        } else {
            if (arg0 >= 0) {
                if (SharedKt.getMc().method_1522().field_1482 == minecraftRef.field_1482) {
                    if (SharedKt.getMc().method_1522().field_1481 != minecraftRef.field_1481) {
                        minecraftRef.method_1234(SharedKt.getMc().method_1522().field_1482, SharedKt.getMc().method_1522().field_1481);
                    }
                }
            }
            RenderSystem.getDevice().createCommandEncoder().clearColorAndDepthTextures(minecraftRef.method_30277(), 0, minecraftRef.method_30278(), 1.0D);
        }
    }

    private List resolveList(int arg0, char arg1) {
        Iterable iterable = SharedKt.getWorld().method_18112();
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (arg1 >= 0) {
                collection.add(element);
                iterable = ((Iterable) collection);
                iterable2 = iterable;
                collection = ((Collection) new ArrayList());
                if (arg0 >= 0) {
                }
            }
        }
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            class_1542 class1542 = ((class_1542) element);
            collection.add(element);
        }
        return collection;
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
        if (INSTANCE.getShaderMode() != ItemEspShaderMode.DEFAULT) {
            if (INSTANCE.getHighlight() == ItemEspHighlightMode.SHADER) {
            } else {
            }
        }
        return false;
    }

    private static boolean isActive4() {
        return INSTANCE.getFilter() != ItemEspFilterMode.NONE;
    }

    static {
        KProperty[] items = new KProperty[11];
        INSTANCE = new ItemEspModule();
        highlightSetting = VisibleRenderHelper.registerSetting(INSTANCE, "highlight", ItemEspHighlightMode.OFF);
        shaderModeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shader-mode", ItemEspShaderMode.DEFAULT, null, this::isActive);
        mergeSetting = VisibleRenderHelper.registerSetting(INSTANCE, "merge", true);
        onePlateSetting = VisibleRenderHelper.registerSetting(INSTANCE, "one-plate", true, null, this::isActive2);
        shulkerLootSetting = VisibleRenderHelper.registerSetting(INSTANCE, "shulkers", true);
        colorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "fill", new Color(150, 150, 150, 255));
        outlineColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "outline", new Color(-1));
        highLightColorSetting = VisibleRenderHelper.registerSetting(INSTANCE, "highlight-color", new Color(-1));
        lineWithValueSetting = VisibleRenderHelper.registerSetting(INSTANCE, "line-width", 4.0F, RangesKt.rangeTo(1.0F, 4.0F), null, this::isActive3);
        filterSetting = VisibleRenderHelper.registerSetting(INSTANCE, "filter", ItemEspFilterMode.NONE);
        itemsSetting = VisibleRenderHelper.registerSetting(INSTANCE, "items", new ItemsServiceComponent2(), null, this::isActive4);
        stackShaderComponent = new StackShaderComponent();
    }

}
