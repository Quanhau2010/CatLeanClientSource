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

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 50830991023686L);
        long var5 = (arg0 ^ 121690619240855L);
        long var7 = (arg0 ^ 100272641512152L);
        long var9 = (arg0 ^ 38798774274332L);
        long var11 = (arg0 ^ 70886708780098L);
        if (arg0 >= 0L) {
            if (minecraftRef != null && minecraftRef.method_29504() && minecraftRef instanceof PlayerEntity && !(Intrinsics.areEqual(minecraftRef, SharedKt.getPlayer()))) {
                countValue = (var14 + 1);
                if (arg0 >= 0L) {
                } else {
                }
                countValue = 0;
            }
        }
        if (arg0 >= 0L) {
            if (AuraModule.INSTANCE.getTarget() == null) {
                AuraModule.INSTANCE.getTarget();
            }
            if (AutoCrystalModule.INSTANCE.getEnabled()) {
            } else {
            }
        }
        if (arg0 > 0L) {
        }
        if (arg0 > 0L) {
            if (arg0 >= 0L) {
            }
            if (arg0 > 0L) {
            }
            if (var14 != null && var14 instanceof PlayerEntity && (PlayerEntity) var14.method_6032() < 10.0F && !(((PlayerEntity) var14.field_6012 % 6))) {
                itemList.add(new ServiceComponent83(((this.computeValue() + 46) + (28 * Math.random())), (this.computeValue2() + 5.0F), ((Math.random() * 2.0F) - 1.0F), (Math.random() * 2), 0, 0.0F, 0.0F));
            }
        }
        float var15 = (easingServiceComponent2.getNumericValue() / 20.0F);
        float var16 = Math.clamp(0.0F, 1.0F);
        if (var14 instanceof LivingEntity) {
            int var17 = (LivingEntity) var14.field_6235;
            if (arg0 > 0L) {
                if (5 <= var17) {
                }
            } else {
            }
            if (var17 < 11) {
                var17 = 6;
                int var18 = 0;
                if (var18 < var17) {
                    int var19 = var18;
                    int var20 = 0;
                    itemList.add(new ServiceComponent83(((INSTANCE.computeValue() - 2.0F) + (114.0F * var16)), (((INSTANCE.computeValue2() + 44.5F) + (Math.random() * 2)) - 1.0F), (Math.random() * 2.0F), ((Math.random() * 1.0F) - 0.5F), 0, 0.0F, 0.0F));
                }
            }
        }
        itemList.removeIf(this::checkCondition);
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 50709462495480L);
        this.render(context, 0);
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 119229165910437L);
        this.render(context, 1);
    }

    private void render(DrawContext arg0, boolean arg1) {
        if (!(SharedKt.getMc().currentScreen instanceof class_408)) {
            if (SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper) {
            }
        } else {
            if (AuraModule.INSTANCE.getTarget() == null) {
                AuraModule.INSTANCE.getTarget();
                if (AutoCrystalModule.INSTANCE.getEnabled()) {
                } else {
                }
            }
        }
        if (var44 != null && var44 instanceof LivingEntity) {
            minecraftRef = (LivingEntity) var44;
        }
        if (var44 != null) {
            if (!(var44.isAlive())) {
            }
            int var45 = countValue;
            if (1 <= var45) {
            } else {
            }
            if (var45 < 20) {
            }
        } else {
        }
        1.0F.executeAction(0.0F);
        if (easingServiceComponent.getNumericValue() <= 0.0F) {
            minecraftRef = null;
        }
        arg0.method_51448().pushMatrix();
        arg0.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        arg0.method_51448().scale(Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F), Math.clamp(easingServiceComponent.getNumericValue(), 0.0F, 2.0F));
        arg0.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 28.5F));
        if (minecraftRef != null) {
            if (!(easingServiceComponent)) {
                CheckRenderHelper.executeAction(this, arg0.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 57.0F, 0.0F);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 42), (this.computeValue2() + 2), 36.0F, 36.0F, 1.0F);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 81), (this.computeValue2() + 2), 36.0F, 17.0F, 1.0F);
                CheckRenderHelper.executeAction(this, arg0.method_51448(), (this.computeValue() + 81), (this.computeValue2() + 21), 36.0F, 17.0F, 1.0F);
                if (minecraftRef instanceof PlayerEntity) {
                    this.render(arg0, EntityHelper2.resolveList((PlayerEntity) minecraftRef), arg1);
                }
                if (countValue > 0) {
                    CheckRenderHelper.executeAction(this, arg0.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 55.0F, Math.clamp((((countValue + 5.0F) + TextShaderComponent2.INSTANCE.computeValue()) / 20.0F), 0.0F, 1.0F));
                }
                this.executeAction(120.0F, 55.0F);
            } else {
                this.render(arg0);
                LivingEntity entity = minecraftRef;
                this.render(arg0, entity);
                if (minecraftRef instanceof PlayerEntity) {
                    this.render(arg0, EntityHelper2.resolveList((PlayerEntity) minecraftRef), 1);
                    this.render(arg0, (PlayerEntity) minecraftRef);
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
        int var21 = EntityPacketHelper.INSTANCE.computeValue(arg1);
        if (!(var21)) {
        } else {
        }
        arg0.render("-", (var21), (this.computeValue() + 105.0F), (this.computeValue2() + 28.5F), Color.white);
    }

    private void render(DrawContext arg0, LivingEntity arg1) {
        if (var28) {
            if (!(arg1 instanceof PlayerEntity)) {
                return;
            }
            arg0.method_51448().pushMatrix();
        }
        float var29 = ((10.0F - Math.clamp(easingServiceComponent2.getNumericValue(), 0.0F, 10.0F)) / 2.0F);
        float var30 = (var29 * Math.sin((arg1.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
        float var31 = (var29 * Math.cos((arg1.field_6012 + TextShaderComponent2.INSTANCE.computeValue())));
        float var32 = (var29 * var30);
        arg0.method_51448().translate((((this.computeValue() + 46.0F) + 14.0F) + var32), (((this.computeValue2() + 7.0F) + 14.0F) - var31));
        arg0.method_51448().rotate(Math.toRadians());
        arg0.method_51448().scale((1.0F - (arg1.field_6235 / 100.0F)), (1.0F - (arg1.field_6235 / 100.0F)));
        arg0.method_51448().translate((((this.computeValue() + 46.0F) + 14.0F) + var32), (((this.computeValue2() + 7.0F) + 14.0F) - var31));
        int var24 = 4;
        int var25 = 0;
        int var26 = 2;
        VertexFormat var27 = class_290.field_1575;
        FormatRenderHelper var33 = new FormatRenderHelper();
        GpuTextureView var34 = SharedKt.getMc().method_1531().method_4619((AbstractClientPlayerEntity) arg1.method_52814().comp_1626().comp_3627()).method_71659();
        PolygonShaderComponent.executeAction((this.computeValue() + 46.0F), (this.computeValue2() + 7.0F), 28.0F, 28.0F, Color.WHITE, null, null, null, 0.125F, 0.125F, 0.25F, 0.25F);
        PolygonShaderComponent.executeAction((this.computeValue() + 44.0F), (this.computeValue2() + 5.0F), 32.0F, 32.0F, Color.WHITE, null, null, null, 0.625F, 0.125F, 0.75F, 0.25F);
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline14(), SharedKt.getMc().method_1522(), null, null, (Matrix3x2f) arg0.method_51448(), MapsKt.mapOf(TuplesKt.to("Sampler0")));
        arg0.method_51448().scale(1.0F, 1.0F);
        arg0.method_51448().popMatrix();
    }

    private void render(int arg0, short arg1, DrawContext arg2) {
        int var22 = 4;
        int var23 = 0;
        int var24 = itemList.size();
        VertexFormat var25 = class_290.field_1575;
        FormatRenderHelper var27 = new FormatRenderHelper();
        GpuTextureView var28 = SharedKt.getMc().method_1531().method_4619(AtlasTextureServiceComponent.getMinecraftObject()).method_71659();
        Iterable var29 = (Iterable) itemList;
        int var30 = 0;
        Object var31 = var29;
        Collection var32 = (Collection) new ArrayList();
        int var33 = 0;
        Iterator iterator = var31.iterator();
        while (iterator.hasNext()) {
            Object var35 = iterator.next();
            ServiceComponent83 var36 = (ServiceComponent83) var35;
            int var37 = 0;
            if (arg1 < 0) {
                var32.add();
            }
            var29 = (Iterable) var32;
            if (arg1 < 0) {
                var30 = 0;
            }
        }
        var31 = var29.iterator();
        while (var31.hasNext()) {
            var32 = var31.next();
            var33 = (ServiceComponent83) var32;
            iterator = 0;
            var35 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), ((1.0F - ((var33.getNumericValue() + TextShaderComponent2.INSTANCE.computeValue()) / 10.0F)) * 0.8F));
            PolygonShaderComponent.executeAction(PolygonShaderComponent.INSTANCE.computeValue(var33.getNumericValue5(), var33.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), PolygonShaderComponent.INSTANCE.computeValue(var33.getNumericValue6(), var33.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()), 10.0F, 10.0F, null, null, null, OptionMode6.FIREFLY_ALT.getNumericValue(), OptionMode6.FIREFLY_ALT.getNumericValue2(), OptionMode6.FIREFLY_ALT.getNumericValue3(), OptionMode6.FIREFLY_ALT.getNumericValue4());
            if (arg0 < 0 || !(var26)) {
                continue;
            }
        }
        var31 = var29;
        var32 = (Collection) new ArrayList();
        var33 = 0;
        iterator = var31.iterator();
        while (iterator.hasNext()) {
            var35 = iterator.next();
            var36 = (ServiceComponent83) var35;
            var37 = 0;
            if (arg0 >= 0) {
                var32.add();
            }
            var29 = (Iterable) var32;
            if (arg0 >= 0) {
                var30 = 0;
            }
        }
        var31 = var29.iterator();
        while (var31.hasNext()) {
            var32 = var31.next();
            var33 = (ServiceComponent83) var32;
            iterator = 0;
            PolygonShaderComponent.executeAction(PolygonShaderComponent.INSTANCE.computeValue(var33.getNumericValue5(), var33.getNumericValue(), TextShaderComponent2.INSTANCE.computeValue()), PolygonShaderComponent.INSTANCE.computeValue(var33.getNumericValue6(), var33.getNumericValue2(), TextShaderComponent2.INSTANCE.computeValue()), 6.0F, 6.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, (1.0F - ((var33.getNumericValue() + TextShaderComponent2.INSTANCE.computeValue()) / 60.0F))), null, null, null, OptionMode6.DROP.getNumericValue(), OptionMode6.DROP.getNumericValue2(), OptionMode6.DROP.getNumericValue3(), OptionMode6.DROP.getNumericValue4());
        }
        FormatRenderHelper.executeAction(VertexUBOShaderComponent.INSTANCE.getRenderPipeline18(), SharedKt.getMc().method_1522(), null, null, (Matrix3x2f) arg2.method_51448(), MapsKt.mapOf(TuplesKt.to("Sampler0")));
    }

    private void render(DrawContext arg0, LivingEntity arg1) {
        Color var29 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.8F);
        Color var30 = PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor2(), 0.3F);
        if (var28) {
            if (arg1 instanceof PlayerEntity) {
                easingServiceComponent2.executeAction(NameTagsModule.INSTANCE.computeValue((PlayerEntity) arg1, NameTagsModule.INSTANCE.getHealthProvider()));
            }
            if (!(var28)) {
            }
            easingServiceComponent2.executeAction((arg1.method_6032() + arg1.method_6067()));
        }
        float var31 = 0.0F;
        Iterable var32 = (Iterable) EntityHelper2.resolveList(arg1);
        int var33 = 0;
        Iterator iterator = var32.iterator();
        if (iterator.hasNext()) {
            Object var35 = iterator.next();
            ItemStack stack = (ItemStack) var35;
            int var37 = 0;
            var31 = (var31 + (stack.method_7936() - stack.method_7919()));
            if (var28) {
            }
        }
        var32 = RangesKt.coerceIn((var31 / 2035.0F), 0.0F, 1.0F);
        var33 = (easingServiceComponent2.getNumericValue() / 20.0F);
        iterator = Math.clamp(0.0F, 1.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 40), 114.0F, 4.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 40), (114.0F * var32), 4.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 45), 114.0F, 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        StackShaderComponent2.executeAction(arg0.method_51448(), (this.computeValue() + 3), (this.computeValue2() + 45), (114.0F * iterator), 9.0F, 2.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, String.valueOf((MathKt.roundToInt((easingServiceComponent2.getNumericValue() * 10.0D)) / 10.0D)), (this.computeValue() + 59.5F), (this.computeValue2() + 48.5F), Color.black);
        SFMServiceComponent.resolveFontRenderHelper().render(arg0, String.valueOf((MathKt.roundToInt((easingServiceComponent2.getNumericValue() * 10.0D)) / 10.0D)), (this.computeValue() + 59.0F), (this.computeValue2() + 48.0F), Color.white);
    }

    private void render(DrawContext arg0, List arg1, boolean arg2) {
        if (countValue > 0) {
            return;
        }
        Pair[] var22 = new Pair[4];
        var22[0] = new Pair(Float.valueOf((this.computeValue() + 3)), Float.valueOf((this.computeValue2() + 2)));
        var22[1] = new Pair(Float.valueOf((this.computeValue() + 22)), Float.valueOf((this.computeValue2() + 2)));
        var22[2] = new Pair(Float.valueOf((this.computeValue() + 22)), Float.valueOf((this.computeValue2() + 21)));
        var22[3] = new Pair(Float.valueOf((this.computeValue() + 3)), Float.valueOf((this.computeValue2() + 21)));
        List positions = CollectionsKt.listOf();
        var22 = (Iterable) positions;
        int var23 = 0;
        int var24 = 0;
        Iterator iterator = var22.iterator();
        while (iterator.hasNext()) {
            Object var26 = iterator.next();
            int var27 = var24;
            if (var27 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Pair var28 = (Pair) var26;
            int var29 = var27;
            int var30 = 0;
            float var31 = (Number) var28.component1();
            float var32 = (Number) var28.component2();
            Color var33 = Color.BLACK;
            int var34 = ((ItemStack) arg1.get((3 - var29)).method_7919() / (ItemStack) arg1.get((3 - var29)).method_7936());
            if (!(Float.isNaN())) {
                var33 = PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, Color.RED, ((ItemStack) arg1.get((3 - var29)).method_7919() / (ItemStack) arg1.get((3 - var29)).method_7936()));
            }
            Object var35 = var33;
            var33 = PolygonShaderComponent.INSTANCE.resolveColor(0.2F);
            CheckRenderHelper.executeAction(INSTANCE, arg0.method_51448(), 17.0F, 17.0F, 0.0F);
            ColorValue1RenderHelper.executeAction((var32 + (17 * var34)), 17.0F, (17.0F * (1.0F - var34)), 2.0F, arg0.method_51448(), 0.0F);
            arg0.method_51448().pushMatrix();
            arg0.method_51448().translate((var31 + 0.5F));
            arg0.method_51427((ItemStack) arg1.get((3 - var29)), 0, 0);
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
        float var8 = (INSTANCE.computeValue() + 46.0D);
        float var10 = (INSTANCE.computeValue() + 74.0D);
        float var12 = (arg0.getNumericValue() + 4);
        if (var8 <= var12) {
        } else {
        }
        if (var12 <= var10) {
            var8 = (INSTANCE.computeValue2() + 5.0D);
            var10 = (INSTANCE.computeValue2() + 33.0D);
            var12 = (arg0.getNumericValue2() + 4);
            if (var8 <= var12) {
            } else {
            }
        }
        if (var12 > var10 && !(arg0.isActive())) {
            arg0.updateValue4((arg0.getNumericValue4() + 0.2F));
            arg0.updateValue3((arg0.getNumericValue3() * 0.95F));
        }
        var8 = arg0.getNumericValue();
        arg0.updateValue((var8 + 1));
        if (arg0.isActive()) {
        } else {
        }
        return 10 > 60;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new TargetInfoCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK, var0[1]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[0]);
    }

}
