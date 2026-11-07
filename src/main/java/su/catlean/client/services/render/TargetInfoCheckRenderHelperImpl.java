package su.catlean.client.services.render;

import com.mojang.blaze3d.textures.GpuTextureView;
import com.mojang.blaze3d.vertex.VertexFormat;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import net.minecraft.class_1044;
import net.minecraft.class_1060;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_290;
import net.minecraft.class_408;
import net.minecraft.class_8685;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.features.modules.pvp.attack.AuraModule;
import su.catlean.client.features.modules.pvp.attack.AutoCrystalModule;
import su.catlean.client.features.modules.render.esp.NameTagsModule;
import su.catlean.client.services.client.AtlasTextureServiceComponent;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent83;
import su.catlean.client.services.network.EntityPacketHelper;
import su.catlean.client.services.player.EntityHelper2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;
import su.catlean.client.services.render.shader.TextShaderComponent2;
import su.catlean.client.services.render.shader.VertexUBOShaderComponent;
import su.catlean.client.types.OptionMode6;
import su.catlean.client.types.TpYawSmootherMode;

public class TargetInfoCheckRenderHelperImpl extends CheckRenderHelper {

    public static final TargetInfoCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static LivingEntity minecraftRef;
    private static final EasingServiceComponent easingServiceComponent;
    private static final EasingServiceComponent easingServiceComponent2;
    private static int countValue;

    private TargetInfoCheckRenderHelperImpl() {
        super("target-info");
    }

    public LivingEntity getMinecraftObject() {
        return minecraftRef;
    }

    public void updateValue(LivingEntity value) {
        minecraftRef = value;
    }

    public EasingServiceComponent getEasingServiceComponent() {
        return easingServiceComponent;
    }

    public void updateValue() {
        if (minecraftRef != null && minecraftRef.method_29504() && minecraftRef instanceof PlayerEntity && !(Intrinsics.areEqual(minecraftRef, SharedKt.getPlayer()))) {
            countValue = (__UNDEF_KEY__ + 1);
        } else {
            countValue = 0;
        }
        if (AuraModule.INSTANCE.getTarget() == null) {
            AuraModule.INSTANCE.getTarget();
            if (AutoCrystalModule.INSTANCE.getEnabled()) {
            } else {
            }
        }
        if (__UNDEF_KEY__ instanceof PlayerEntity && this.method_6032() < 10.0F && !((this.field_6012 % 6))) {
            itemList.add(new ServiceComponent83(((this.computeValue() + 46) + (28 * Math.random())), (this.computeValue2() + 5.0F), ((Math.random() * 2.0F) - 1.0F), (Math.random() * 2), 0, 0.0F, 0.0F, false));
        }
        float factor = (easingServiceComponent2.getNumericValue() / 20.0F);
        float factor2 = Math.clamp(factor, 0.0F, 1.0F);
        if (__UNDEF_KEY__ instanceof LivingEntity) {
            int index = this.field_6235;
            if (5 <= index) {
            } else {
                if (index < 11) {
                    index = 6;
                    int index2 = 0;
                    if (index2 < index) {
                        itemList.add(new ServiceComponent83(((INSTANCE.computeValue() - 2.0F) + (114.0F * factor2)), (((INSTANCE.computeValue2() + 44.5F) + (Math.random() * 2)) - 1.0F), (Math.random() * 2.0F), ((Math.random() * 1.0F) - 0.5F), 0, 0.0F, 0.0F, true));
                    }
                }
            }
        }
        itemList.removeIf(this::checkCondition);
    }

    public void render(DrawContext context) {
        this.render(context, false);
    }

    public void render(DrawContext context) {
        this.render(context, true);
    }

    private void render(DrawContext arg0, boolean arg1) {
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            } else {
                if (AuraModule.INSTANCE.getTarget() == null) {
                    AuraModule.INSTANCE.getTarget();
                    if (AutoCrystalModule.INSTANCE.getEnabled()) {
                    } else {
                    }
                }
            }
        }
        if (__UNDEF_KEY__ != null && __UNDEF_KEY__ instanceof LivingEntity) {
            minecraftRef = ((LivingEntity) __UNDEF_KEY__);
        }
        if (__UNDEF_KEY__ != null) {
            if (!(this.isAlive())) {
                if (1 <= countValue) {
                } else {
                    if (countValue < 20) {
                    } else {
                    }
                }
            }
        }
        this.executeAction(0.0F);
        if (easingServiceComponent.getNumericValue() <= 0.0F) {
            minecraftRef = null;
        }
        arg0.method_51448().pushMatrix();
        arg0.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        arg0.method_51448().scale(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
        arg0.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        if (minecraftRef != null) {
            if (!(easingServiceComponent)) {
                CheckRenderHelper.executeAction(this, arg0.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 57.0F, 0.0F, false);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 42), (this.computeValue2() + 2), 36.0F, 36.0F, 1.0F, false);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 81), (this.computeValue2() + 2), 36.0F, 17.0F, 1.0F, false);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 81), (this.computeValue2() + 21), 36.0F, 17.0F, 1.0F, false);
                if (minecraftRef instanceof PlayerEntity) {
                    this.render(arg0, EntityHelper2.resolveList(((PlayerEntity) minecraftRef)), arg1);
                }
                if (countValue > 0) {
                    CheckRenderHelper.executeAction(this, arg0.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 55.0F, Math.clamp((((countValue + 5.0F) + TextShaderComponent2.INSTANCE.computeValue()) / 20.0F), 0.0F, 1.0F), false);
                }
                this.executeAction(120.0F, 55.0F);
            } else {
                this.render(arg0);
                this.render(arg0, minecraftRef);
                if (minecraftRef instanceof PlayerEntity) {
                    this.render(arg0, EntityHelper2.resolveList(((PlayerEntity) minecraftRef)), true);
                    this.render(arg0, ((PlayerEntity) minecraftRef));
                }
                this.render(arg0, minecraftRef);
            }
        }
        SFMServiceComponent.resolveFontRenderHelper5().render(arg0, StringsKt.dropLast("EZZZZZZZZZZ", (11 - Math.clamp(countValue, 0, 11))), (this.computeValue() + 59.0F), (this.computeValue2() + 19.0F), 10);
        arg0.method_51448().popMatrix();
    }

    private void render(DrawContext arg0, PlayerEntity arg1) {
        if (countValue > 0) {
            return;
        }
        arg0.method_51448().pushMatrix();
        arg0.method_51448().translate((this.computeValue() + 83.0F), (this.computeValue2() + 3.5F));
        arg0.method_51448().scale(0.8F, 0.8F);
        arg0.method_51427(arg1.method_6047(), 0, 0);
        arg0.method_51431(SharedKt.getMc().field_1772, arg1.method_6047(), 0, 0);
        arg0.method_51427(arg1.method_6079(), 22, 0);
        arg0.method_51431(SharedKt.getMc().field_1772, arg1.method_6079(), 22, 0);
        arg0.method_51427(Items.field_8288.method_7854(), 0, 24);
        arg0.method_51448().popMatrix();
        int index = EntityPacketHelper.INSTANCE.computeValue(arg1);
        if (!(index)) {
        } else {
        }
        arg0.render("-", (index), (this.computeValue() + 105.0F), (this.computeValue2() + 28.5F), Color.white);
    }

    private void render(DrawContext arg0, LivingEntity arg1) {
        if (!(arg1 instanceof PlayerEntity)) {
            return;
        }
        arg0.method_51448().pushMatrix();
        float factor = ((10.0F - Math.clamp(easingServiceComponent2.getNumericValue(), 0.0F, 10.0F)) / 2.0F);
        float factor2 = (factor * Math.sin((arg1.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
        float factor3 = (factor * Math.cos((arg1.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
        float factor4 = (factor * factor2);
        arg0.method_51448().translate((((this.computeValue() + 46.0F) + 14.0F) + factor4), (((this.computeValue2() + 7.0F) + 14.0F) - factor3));
        arg0.method_51448().rotate(Math.toRadians(factor2));
        arg0.method_51448().scale((1.0F - (arg1.field_6235 / 100.0F)), (1.0F - (arg1.field_6235 / 100.0F)));
        arg0.method_51448().translate((((this.computeValue() + 46.0F) + 14.0F) + factor4), (((this.computeValue2() + 7.0F) + 14.0F) - factor3));
        int index = 4;
        int index2 = 0;
        int index3 = 2;
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(((AbstractClientPlayerEntity) arg1).method_52814().comp_1626().comp_3627()).method_71659();
        PolygonShaderComponent.executeAction(formatRenderHelper, (this.computeValue() + 46.0F), (this.computeValue2() + 7.0F), 28.0F, 28.0F, Color.WHITE, null, null, null, 0.125F, 0.125F, 0.25F, 0.25F);
        PolygonShaderComponent.executeAction(formatRenderHelper, (this.computeValue() + 44.0F), (this.computeValue2() + 5.0F), 32.0F, 32.0F, Color.WHITE, null, null, null, 0.625F, 0.125F, 0.75F, 0.25F);
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, ((Matrix3x2f) arg0.method_51448()), MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
        arg0.method_51448().scale(1.0F, 1.0F);
        arg0.method_51448().popMatrix();
    }

    private void render(int arg0, short arg1, DrawContext arg2) {
        int index = 4;
        int index2 = 0;
        int index3 = itemList.size();
        VertexFormat vertexFormat = class_290.field_1575;
        FormatRenderHelper formatRenderHelper = new FormatRenderHelper(vertexFormat, index3, index2, index);
        GpuTextureView gpuTextureView = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        Iterable iterable = ((Iterable) itemList);
        Iterable iterable2 = iterable;
        Collection collection = ((Collection) new ArrayList());
        int index4 = 0;
        Iterator iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ServiceComponent83 serviceComponent83 = ((ServiceComponent83) element);
            if (arg1 < 0) {
                collection.add(element);
                iterable = ((Iterable) collection);
                if (arg1 < 0) {
                }
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index4 = ((ServiceComponent83) collection);
            iterator = 0;
            element = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), ((1.0F - ((index4.getNumericValue() + TextShaderComponent2.INSTANCE.computeValue()) / 10.0F)) * 0.8F));
            PolygonShaderComponent.executeAction(formatRenderHelper, PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue5(), index4.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue6(), index4.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()), 10.0F, 10.0F, element, null, null, null, OptionMode6.FIREFLY_ALT.getNumericValue(), OptionMode6.FIREFLY_ALT.getNumericValue2(), OptionMode6.FIREFLY_ALT.getNumericValue3(), OptionMode6.FIREFLY_ALT.getNumericValue4());
            if (arg0 < 0 || !(__UNDEF_KEY__)) {
                continue;
            }
        }
        iterable2 = iterable;
        collection = ((Collection) new ArrayList());
        index4 = 0;
        iterator = iterable2.iterator();
        while (iterator.hasNext()) {
            element = iterator.next();
            serviceComponent83 = ((ServiceComponent83) element);
            if (arg0 >= 0) {
                collection.add(element);
                iterable = ((Iterable) collection);
                if (arg0 >= 0) {
                }
            }
        }
        iterable2 = iterable.iterator();
        while (iterable2.hasNext()) {
            collection = iterable2.next();
            index4 = ((ServiceComponent83) collection);
            iterator = 0;
            PolygonShaderComponent.executeAction(formatRenderHelper, PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue5(), index4.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), PolygonShaderComponent.INSTANCE.computeValue(index4.getNumericValue6(), index4.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()), 6.0F, 6.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (1.0F - ((index4.getNumericValue() + TextShaderComponent2.INSTANCE.computeValue()) / 60.0F))), null, null, null, OptionMode6.DROP.getNumericValue(), OptionMode6.DROP.getNumericValue2(), OptionMode6.DROP.getNumericValue3(), OptionMode6.DROP.getNumericValue4());
        }
        FormatRenderHelper.executeAction(formatRenderHelper, VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), SharedKt.getMc().method_1522(), null, null, ((Matrix3x2f) arg2.method_51448()), MapsKt.mapOf(TuplesKt.to("Sampler0", gpuTextureView)));
    }

    private void render(DrawContext arg0, LivingEntity arg1) {
        Color color = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.8F);
        Color color2 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.3F);
        if (__UNDEF_KEY__) {
            if (arg1 instanceof PlayerEntity) {
                easingServiceComponent2.executeAction(NameTagsModule.INSTANCE.computeValue(((PlayerEntity) arg1), NameTagsModule.INSTANCE.getHealthProvider()));
                if (!(__UNDEF_KEY__)) {
                    easingServiceComponent2.executeAction((arg1.method_6032() + arg1.method_6067()));
                }
            }
        }
        float factor = 0.0F;
        Iterable iterable = ((Iterable) EntityHelper2.resolveList(arg1));
        int index = 0;
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            ItemStack stack = ((ItemStack) element);
            factor = (factor + (stack.method_7936() - stack.method_7919()));
            if (__UNDEF_KEY__) {
            }
        }
        iterable = RangesKt.coerceIn((factor / 2035.0F), 0.0F, 1.0F);
        index = (easingServiceComponent2.getNumericValue() / 20.0F);
        iterator = Math.clamp(index, 0.0F, 1.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 40), 114.0F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, color2, color2, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 40), (114.0F * iterable), 4.0F, 2.0F, 1.0F, 1.0F, 1.0F, color, color, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 45), 114.0F, 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, color2, color2, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 45), (114.0F * iterator), 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, color, color, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, String.valueOf((MathKt.roundToInt((easingServiceComponent2.getNumericValue() * 10.0D)) / 10.0D)), (this.computeValue() + 59.5F), (this.computeValue2() + 48.5F), Color.black);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, String.valueOf((MathKt.roundToInt((easingServiceComponent2.getNumericValue() * 10.0D)) / 10.0D)), (this.computeValue() + 59.0F), (this.computeValue2() + 48.0F), Color.white);
    }

    private void render(DrawContext arg0, List arg1, boolean arg2) {
        if (countValue > 0) {
            return;
        }
        Pair[] items = new Pair[4];
        items[0] = new Pair(Float.valueOf((this.computeValue() + 3)), Float.valueOf((this.computeValue2() + 2)));
        items[1] = new Pair(Float.valueOf((this.computeValue() + 22)), Float.valueOf((this.computeValue2() + 2)));
        items[2] = new Pair(Float.valueOf((this.computeValue() + 22)), Float.valueOf((this.computeValue2() + 21)));
        items[3] = new Pair(Float.valueOf((this.computeValue() + 3)), Float.valueOf((this.computeValue2() + 21)));
        List list = CollectionsKt.listOf(items);
        items = ((Iterable) list);
        int index = 0;
        Iterator iterator = items.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair pair = ((Pair) element);
            float factor = ((Number) pair.component1());
            float factor2 = ((Number) pair.component2());
            Color color = Color.BLACK;
            int index2 = (((ItemStack) arg1.get((3 - index))).method_7919() / ((ItemStack) arg1.get((3 - index))).method_7936());
            if (!(Float.isNaN(index2))) {
                color = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, Color.RED, (((ItemStack) arg1.get((3 - index))).method_7919() / ((ItemStack) arg1.get((3 - index))).method_7936()));
            }
            color = PolygonShaderComponent.INSTANCE.resolveColor(color, 0.2F);
            CheckRenderHelper.executeAction(INSTANCE, arg0.method_51448(), factor, factor2, 17.0F, 17.0F, 0.0F, false);
            ColorValue1RenderHelper.executeAction(factor, (factor2 + (17 * index2)), 17.0F, (17.0F * (1.0F - index2)), 2.0F, color, color, color, color, arg0.method_51448(), 0.0F);
            arg0.method_51448().pushMatrix();
            arg0.method_51448().translate((factor + 0.5F), factor2);
            arg0.method_51427(((ItemStack) arg1.get((3 - index))), 0, 0);
            arg0.method_51448().popMatrix();
        }
    }

    private static boolean checkCondition(ServiceComponent83 arg0) {
        arg0.updateValue5(arg0.getNumericValue());
        arg0.updateValue6(arg0.getNumericValue2());
        arg0.updateValue((arg0.getNumericValue() + arg0.getNumericValue3()));
        arg0.updateValue2((arg0.getNumericValue2() + arg0.getNumericValue4()));
        arg0.updateValue3((arg0.getNumericValue3() * 0.95F));
        arg0.updateValue4((arg0.getNumericValue4() * 0.95F));
        float factor = (INSTANCE.computeValue() + 46.0D);
        float factor2 = (INSTANCE.computeValue() + 74.0D);
        float factor3 = (arg0.getNumericValue() + 4);
        if (factor <= factor3) {
        } else {
            if (factor3 <= factor2) {
                factor = (INSTANCE.computeValue2() + 5.0D);
                factor2 = (INSTANCE.computeValue2() + 33.0D);
                factor3 = (arg0.getNumericValue2() + 4);
                if (factor <= factor3) {
                } else {
                }
            }
        }
        if (factor3 > factor2 && !(arg0.isActive())) {
            arg0.updateValue4((arg0.getNumericValue4() + 0.2F));
            arg0.updateValue3((arg0.getNumericValue3() * 0.95F));
        }
        factor = arg0.getNumericValue();
        arg0.updateValue((factor + 1));
        if (arg0.isActive()) {
        } else {
        }
        return 10 > 60;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return ((Boolean) arg0.invoke(arg1));
    }

    static {
        INSTANCE = new TargetInfoCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
    }

}
