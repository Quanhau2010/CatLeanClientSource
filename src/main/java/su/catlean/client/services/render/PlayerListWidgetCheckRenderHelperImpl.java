package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import net.minecraft.class_12079.class_12081;
import net.minecraft.class_408;
import net.minecraft.class_8685;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import org.joml.Matrix3x2f;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.player.EntityEntityHelper2;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class PlayerListWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final PlayerListWidgetCheckRenderHelperImpl INSTANCE;
    private static final List itemList;
    private static final EasingServiceComponent easingServiceComponent;

    private PlayerListWidgetCheckRenderHelperImpl() {
        super("player-list-widget");
    }

    public List getList() {
        return itemList;
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 50910300018319L);
        long var8 = (0L ^ 81581919584095L);
        long var10 = (0L ^ 20795373550736L);
        long var12 = (0L ^ 22879798888836L);
        long var14 = (0L ^ 107471649456291L);
        long var16 = ((0L ^ 99541060701969L) >>> 48);
        long var17 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var18 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var19 = (0L ^ 100479272291701L);
        long var21 = (0L ^ 130512158954640L);
        long var23 = ((0L ^ 104104530525409L) >>> 48);
        long var24 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var25 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var26 = (0L ^ 128377113661390L);
        long var28 = (0L ^ 20173347401993L);
        long var30 = (0L ^ 99949442920536L);
        long var32 = (0L ^ 30591967126976L);
        Iterable var36 = (Iterable) SharedKt.getWorld().getPlayers();
        int var37 = 0;
        Object var38 = var36;
        Collection var39 = (Collection) new ArrayList();
        int var40 = 0;
        Iterator iterator = var38.iterator();
        while (iterator.hasNext()) {
            if (0L > 0L) {
            }
            Object var42 = iterator.next();
            AbstractClientPlayerEntity player = (AbstractClientPlayerEntity) var42;
            int var44 = 0;
            var39.add();
        }
        Iterator iterator2 = var39.iterator();
        while (iterator2.hasNext()) {
            var36 = (AbstractClientPlayerEntity) iterator2.next();
            var38 = (Iterable) itemList;
            var39 = 0;
            if (0L >= 0L) {
                if (!(var34)) {
                }
                if (var38 instanceof Collection && (Collection) var38.isEmpty()) {
                } else {
                    var40 = var38.iterator();
                    if (var40.hasNext()) {
                        iterator = var40.next();
                        var42 = (EntityEntityHelper2) iterator;
                        player = 0;
                    } else {
                    }
                }
                var37 = 1;
                itemList.add(new EntityEntityHelper2((PlayerEntity) var36));
            }
        }
        iterator2 = (Iterable) itemList;
        var36 = 0;
        var37 = iterator2;
        var38 = (Collection) new ArrayList();
        var39 = 0;
        var40 = var37.iterator();
        while (var40.hasNext()) {
            iterator = var40.next();
            var42 = (EntityEntityHelper2) iterator;
            player = 0;
            if (0L < 0L || 0L > 0L) {
                continue;
            }
        }
        var37 = (Iterable) SharedKt.getWorld().getPlayers().iterator();
        while (var37.hasNext()) {
            var38 = var37.next();
            var39 = (EntityEntityHelper2) var38;
            var40 = 0;
            var39.updateValue(1);
            if (0L > 0L) {
                if (!(var34)) {
                }
                itemList.removeIf(this::checkCondition);
            }
        }
        iterator2 = "Players";
        var36 = this.computeValue() > (this.computeValue2() / 2.0F);
        if (0L >= 0L) {
            if (!(var34)) {
            }
            if (0L > 0L) {
            }
        }
        if (itemList.isEmpty() && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        0.0F.executeAction(1.0F);
        this.render(context, iterator2, easingServiceComponent.getNumericValue());
        var37 = 17.0F;
        var38 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator2) + 24.0F);
        var39 = itemList.iterator();
        while (var39.hasNext()) {
            var40 = (EntityEntityHelper2) var39.next();
            iterator = SFMServiceComponent.resolveFontRenderHelper().computeValue(var40.resolveString());
            if (0L >= 0L) {
            }
            var38 = (iterator + 13.0F);
        }
        var39 = itemList.iterator();
        while (var39.hasNext()) {
            var40 = (EntityEntityHelper2) var39.next();
            iterator = SFMServiceComponent.resolveFontRenderHelper().computeValue(var40.resolveString());
            if (0L > 0L) {
            }
            if (var36) {
            } else {
            }
            var42 = (this.computeValue() - ((1.0F - var40.getEasingServiceComponent().getNumericValue()) * 10));
            CheckRenderHelper.executeAction(this, context.method_51448(), (this.computeValue2() + var37), (iterator + 21.0F), 13.0F, var40.getEasingServiceComponent().getNumericValue());
            player = var37;
            this.render(context, var40.resolveString(), (var42 + 3.0F), ((this.computeValue2() + player) + 1.0F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor7(), var40.getEasingServiceComponent().getNumericValue()));
            this.executeAction(context.method_51448(), ((var42 + iterator) + 6.0F), ((this.computeValue2() + 2.0F) + player), (var40.getEasingServiceComponent().getNumericValue() * 0.27F));
            var37 = (var37 + (14.0F * var40.getEasingServiceComponent().getNumericValue()));
        }
        this.executeAction((var37 - 2.0F));
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 118901760466898L);
        long var6 = ((0L ^ 116421505234798L) >>> 32);
        long var7 = (((0L ^ 116421505234798L) << 32) >>> 48);
        long var8 = (((0L ^ 116421505234798L) << 48) >>> 48);
        long var9 = (0L ^ 95252125974745L);
        long var11 = (0L ^ 88194911549524L);
        long var13 = (0L ^ 26980051417349L);
        long var15 = ((0L ^ 27379191465548L) >>> 48);
        long var16 = (((0L ^ 27379191465548L) << 16) >>> 32);
        long var17 = (((0L ^ 27379191465548L) << 48) >>> 48);
        long var18 = (0L ^ 98664999447709L);
        long var20 = (0L ^ 27539938346024L);
        String var23 = "Players";
        boolean var24 = this.computeValue() > (this.computeValue2() / 2.0F);
        float var25 = 17.0F;
        float var26 = (SFMServiceComponent.resolveFontRenderHelper().computeValue() + 24.0F);
        Iterator iterator = itemList.iterator();
        while (iterator.hasNext()) {
            EntityEntityHelper2 var28 = (EntityEntityHelper2) iterator.next();
            float var29 = SFMServiceComponent.resolveFontRenderHelper().computeValue(var28.resolveString());
            if (0L >= 0L) {
            }
            var26 = (var29 + 13.0F);
        }
        iterator = itemList.iterator();
        while (iterator.hasNext()) {
            var28 = (EntityEntityHelper2) iterator.next();
            var29 = SFMServiceComponent.resolveFontRenderHelper().computeValue(var28.resolveString());
            if (var24) {
            } else {
            }
            float var30 = (this.computeValue() - ((1.0F - var28.getEasingServiceComponent().getNumericValue()) * 10));
            float var31 = var25;
            PolygonShaderComponent.executeAction((Matrix3x2f) context.method_51448(), (AbstractClientPlayerEntity) var28.getMinecraftObject().method_52814().comp_1626().comp_3627(), ((var30 + var29) + 10.0F), ((this.computeValue2() + 2.5F) + var31), 8.0F, 8.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, var28.getEasingServiceComponent().getNumericValue()), null, null, null, 0.125F, 0.125F, 0.25F, 0.25F);
            PolygonShaderComponent.executeAction((Matrix3x2f) context.method_51448(), (AbstractClientPlayerEntity) var28.getMinecraftObject().method_52814().comp_1626().comp_3627(), ((var30 + var29) + 9.0F), ((this.computeValue2() + 1.5F) + var31), 10.0F, 10.0F, PolygonShaderComponent.INSTANCE.resolveColor(Color.WHITE, var28.getEasingServiceComponent().getNumericValue()), null, null, null, 0.625F, 0.125F, 0.75F, 0.25F);
            var25 = (var25 + (14.0F * var28.getEasingServiceComponent().getNumericValue()));
        }
    }

    private static boolean checkCondition(EntityEntityHelper2 arg0) {
        if (arg0.isActive()) {
        } else {
        }
        0.0F.executeAction(1.0F);
        return arg0.getEasingServiceComponent().getNumericValue() <= 0.0F;
    }

    private static boolean checkCondition(Function1 arg0, Object arg1) {
        return (Boolean) arg0.invoke(arg1);
    }

    static {
        INSTANCE = new PlayerListWidgetCheckRenderHelperImpl();
        itemList = new ArrayList();
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
    }

}
