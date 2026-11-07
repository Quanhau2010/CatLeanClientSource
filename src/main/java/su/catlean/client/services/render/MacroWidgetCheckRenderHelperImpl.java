package su.catlean.client.services.render;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_1796;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.Item;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.api.contracts.Contract8;
import su.catlean.client.services.client.MacroServiceComponent;
import su.catlean.client.services.client.NoneServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent13;
import su.catlean.client.services.client.StackServiceComponent2;
import su.catlean.client.services.client.config.models.IdRecord;
import su.catlean.client.services.client.config.models.KeyRecord;
import su.catlean.client.services.network.ItemPacketHelper;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.services.render.shader.StackShaderComponent2;

public class MacroWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final MacroWidgetCheckRenderHelperImpl INSTANCE;

    private MacroWidgetCheckRenderHelperImpl() {
        super("macro-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 112807673159841L);
        long var6 = (0L ^ 50910300018319L);
        long var8 = (0L ^ 4149061658461L);
        long var10 = ((0L ^ 89424814517768L) >>> 48);
        long var11 = (((0L ^ 89424814517768L) << 16) >>> 32);
        long var12 = (((0L ^ 89424814517768L) << 48) >>> 48);
        long var13 = (0L ^ 109580710346244L);
        long var15 = ((0L ^ 104104530525409L) >>> 48);
        long var16 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var17 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var18 = ((0L ^ 117179548680370L) >>> 48);
        long var19 = (((0L ^ 117179548680370L) << 16) >>> 32);
        long var20 = (((0L ^ 117179548680370L) << 48) >>> 48);
        long var21 = ((0L ^ 137326906772616L) >>> 48);
        long var22 = (((0L ^ 137326906772616L) << 16) >>> 48);
        long var23 = (((0L ^ 137326906772616L) << 32) >>> 32);
        long var24 = ((0L ^ 64416723276910L) >>> 48);
        long var25 = (((0L ^ 64416723276910L) << 16) >>> 16);
        long var27 = (0L ^ 128377113661390L);
        long var29 = (0L ^ 20173347401993L);
        long var31 = (0L ^ 99949442920536L);
        long var33 = (0L ^ 20494741382199L);
        long var35 = (0L ^ 23238624456863L);
        long var37 = (0L ^ 30591967126976L);
        float var40 = this.computeValue();
        float var41 = this.computeValue2();
        float var42 = 0.0F;
        Iterable var44 = (Iterable) MacroServiceComponent.INSTANCE.resolveList();
        int var45 = 0;
        Object var46 = var44;
        Collection var47 = (Collection) new ArrayList();
        int var48 = 0;
        Iterator iterator = var46.iterator();
        while (iterator.hasNext()) {
            if (0L > 0L) {
            }
            Object var50 = iterator.next();
            Contract8 var51 = var50;
            int var52 = 0;
            if (0L >= 0L && var39) {
            }
            var47.add();
        }
        Iterator iterator2 = var47.iterator();
        while (iterator2.hasNext()) {
            var44 = iterator2.next();
            var45 = (IdRecord) var44;
            if (0L > 0L) {
            }
            if (MacroServiceComponent.INSTANCE.resolveMinecraftObject(var45.getString()) == null) {
                MacroServiceComponent.INSTANCE.resolveMinecraftObject(var45.getString());
            }
            var48 = new Item[1];
            var48[0] = var46;
            var47 = ItemPacketHelper.INSTANCE.resolveStackServiceComponent2().isActive();
            var48 = ServiceComponent13.checkCondition(var45.getKeyRecord().getNumericValue());
            iterator = NoneServiceComponent.INSTANCE.resolveString(var45.getKeyRecord().getNumericValue());
            var50 = (SFMServiceComponent.resolveFontRenderHelper().computeValue(iterator) + 22.0F);
            var51 = SharedKt.getPlayer().method_7357().method_7904(var46.method_7854());
            CheckRenderHelper.executeAction(this, context.method_51448(), 16.0F, 0.0F);
            if (0L > 0L) {
                if (var39) {
                }
                if (var51) {
                    var52 = SharedKt.getPlayer().method_7357().method_7905(var46.method_7854(), PolygonShaderComponent.INSTANCE.computeValue());
                    StackShaderComponent2.executeAction(context.method_51448(), (var41 + (16.0F * (1.0F - var52))), (16.0F * var52), 3.0F, 0.0F, 0.0F, 1.0F, Color.RED, NewThemeRenderHelper.INSTANCE.getColor6(), 0.0F, 0.0F, 0.0F);
                }
                context.method_51448().pushMatrix();
                context.method_51448().translate((var40 + 2.0F), (var41 + 2.0F));
                context.method_51448().scale(0.7F);
                context.method_51427(var46.method_7854(), 0, 0);
                context.method_51448().popMatrix();
            }
            var52 = new Color[1];
            var52[0] = new Color(1157627903, 1);
            PolygonShaderComponent.INSTANCE.executeAction(context.method_51448(), (var40 + 14), (var41 + 4.0F), 0.5F, 9.0F);
            if (0L > 0L) {
                if (var48) {
                } else {
                }
                if (var47) {
                } else {
                }
            }
            var52 = Color.RED;
            this.render(context, iterator, (var40 + 18.0F), (var41 + 3.0F));
            var40 = (var40 + (var50 + 2.0F));
            var42 = (var42 + (var50 + 2.0F));
        }
        this.executeAction(16.0F);
    }

    static {
        INSTANCE = new MacroWidgetCheckRenderHelperImpl();
    }

}
