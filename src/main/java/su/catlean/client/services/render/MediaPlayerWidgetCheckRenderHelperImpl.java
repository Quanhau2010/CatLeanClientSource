package su.catlean.client.services.render;

import dev.redstones.mediaplayerinfo.IMediaSession;
import dev.redstones.mediaplayerinfo.MediaInfo;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo;
import dev.redstones.mediaplayerinfo.MediaPlayerInfo.Instance;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.ranges.RangesKt;
import net.minecraft.class_241;
import net.minecraft.class_2960;
import net.minecraft.class_408;
import net.minecraft.client.gui.DrawContext;
import org.joml.Matrix3x2fStack;
import su.catlean.SharedKt;
import su.catlean.client.services.client.EasingServiceComponent;
import su.catlean.client.services.client.SFMServiceComponent;
import su.catlean.client.services.client.ServiceComponent10;
import su.catlean.client.services.client.ServiceComponent78;
import su.catlean.client.services.client.StringServiceComponent2;
import su.catlean.client.services.client.UrlServiceComponent;
import su.catlean.client.services.render.shader.ColorValueShaderComponent;
import su.catlean.client.services.render.shader.PolygonShaderComponent;
import su.catlean.client.types.TpYawSmootherMode;

public class MediaPlayerWidgetCheckRenderHelperImpl extends CheckRenderHelper {

    public static final MediaPlayerWidgetCheckRenderHelperImpl INSTANCE;
    private static MediaInfo mediaInfo;
    private static class_2960 minecraftRef;
    private static class_241 minecraftRef2;
    private static boolean enabledFlag;
    private static String textValue;
    private static final EasingServiceComponent easingServiceComponent;
    private static final EasingServiceComponent easingServiceComponent2;
    private static boolean enabledFlag2;
    private static int countValue;
    private static ServiceComponent10 serviceComponent10;

    private MediaPlayerWidgetCheckRenderHelperImpl() {
        super("media-player-widget");
    }

    public void render(DrawContext context) {
        long var4 = (0L ^ 73719739740194L);
        long var6 = (0L ^ 137466198657546L);
        long var8 = (0L ^ 50910300018319L);
        long var10 = (0L ^ 81581919584095L);
        long var12 = (0L ^ 32333673308231L);
        long var14 = (0L ^ 32496943983440L);
        long var16 = ((0L ^ 99541060701969L) >>> 48);
        long var17 = (((0L ^ 99541060701969L) << 16) >>> 32);
        long var18 = (((0L ^ 99541060701969L) << 48) >>> 48);
        long var19 = (0L ^ 90317468167310L);
        long var21 = (0L ^ 109580710346244L);
        long var23 = ((0L ^ 104104530525409L) >>> 48);
        long var24 = (((0L ^ 104104530525409L) << 16) >>> 32);
        long var25 = (((0L ^ 104104530525409L) << 48) >>> 48);
        long var26 = (0L ^ 37430498539930L);
        long var28 = (0L ^ 16349136930672L);
        long var30 = (0L ^ 20173347401993L);
        long var32 = (0L ^ 20494741382199L);
        long var34 = (0L ^ 4180373105917L);
        long var36 = (0L ^ 116938881892165L);
        long var38 = (0L ^ 99253988284703L);
        long var40 = (0L ^ 30591967126976L);
        if (0L > 0L) {
        }
        if (!(enabledFlag2) && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        0.0F.executeAction(1.0F);
        this.executeAction(120.0F, 43.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 21.5F));
        context.method_51448().scale((Number) RangesKt.coerceIn((Comparable) Float.valueOf(easingServiceComponent2.getNumericValue()), RangesKt.rangeTo(0.0F, 2.0F)), (Number) RangesKt.coerceIn((Comparable) Float.valueOf(easingServiceComponent2.getNumericValue()), RangesKt.rangeTo(0.0F, 2.0F)));
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 21.5F));
        if (0L >= 0L && var42) {
            if (0L > 0L) {
                if (!(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
                }
                if (mediaInfo == null && SharedKt.getMc().currentScreen instanceof class_408) {
                }
                CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 43.0F, 0.0F);
                SFMServiceComponent.resolveFontRenderHelper6().render(context, this.getString2(), (this.computeValue() + 60.0F), (this.computeValue2() + 21.0F), NewThemeRenderHelper.INSTANCE.getColor7());
            }
        }
        if (mediaInfo == null) {
            context.method_51448().popMatrix();
            return;
        }
        float var43 = RangesKt.coerceIn((mediaInfo.getPosition() / mediaInfo.getDuration()), 0.0F, 1.0F);
        if (0L > 0L && var42) {
        }
        if (0L >= 0L) {
            if (mediaInfo.getPlaying()) {
            }
        }
        easingServiceComponent.executeAction(0.0F);
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 43.0F, 0.0F);
        ColorValueShaderComponent.executeAction((this.computeValue2() + 4.0F), 35.0F, 35.0F, 3.0F, 2.0F, 0.0F, easingServiceComponent.getNumericValue(), RangesKt.coerceIn((easingServiceComponent.getNumericValue() + 0.5F), 0.0F, 1.0F), Color.WHITE, Color.WHITE, context.method_51448(), minecraftRef);
        if (0L > 0L) {
        }
        ColorValueShaderComponent.executeAction((this.computeValue() + 4.0F), (this.computeValue2() + 4.0F), 35.0F, 35.0F, 3.0F, 2.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), minecraftRef);
        if (!(mediaInfo.getPlaying())) {
            if (easingServiceComponent.getNumericValue() < 1.0F) {
                this.executeAction(context.method_51448(), (this.computeValue() + 13.0F), (this.computeValue2() + 10.0F), 6.0F, 22.0F, (1.0F - easingServiceComponent.getNumericValue()), 0);
                this.executeAction(context.method_51448(), (this.computeValue() + 23.0F), (this.computeValue2() + 10.0F), 6.0F, 22.0F, (1.0F - easingServiceComponent.getNumericValue()), 0);
            }
        }
        float var45 = SFMServiceComponent.resolveFontRenderHelper6().computeValue(mediaInfo.getTitle());
        float var46 = 74.0F;
        int var47 = (120 / 120.0F);
        String var48 = String.valueOf((mediaInfo.getPosition() % 60));
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.computeValue() + 43.0F), this.computeValue2(), (this.computeValue() + 116.0F), (this.computeValue2() + 30.0F)));
        if (var45 > var46) {
        } else {
        }
        if (0L > 0L) {
            if (var45 > var46) {
            }
        } else {
        }
        mediaInfo.getTitle().render((mediaInfo.getTitle() + ""), (this.computeValue() + 42.0F), ((var47 * var45) - 0.0F), (this.computeValue2() + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        SFMServiceComponent.resolveFontRenderHelper4().render(context, mediaInfo.getArtist(), (this.computeValue() + 42.0F), (this.computeValue2() + 13.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        PolygonShaderComponent.INSTANCE.render(context);
        if (var48.length() == 1) {
        } else {
        }
        context.render((mediaInfo.getPosition() / 60.0F), (":0" + ":" + var48), (this.computeValue() + 42.0F), (this.computeValue2() + 29.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        float var49 = SFMServiceComponent.resolveFontRenderHelper4().computeValue(textValue);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, textValue, ((this.computeValue() + 116.0F) - var49), (this.computeValue2() + 29.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        ColorValue1RenderHelper.executeAction((this.computeValue() + 42.0F), (this.computeValue2() + 23.0F), 74.0F, 4.0F, 2.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), context.method_51448(), 2.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction((this.computeValue() + 42.0F), (this.computeValue2() + 23.0F), (74.0F * var43), 4.0F, 2.0F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), context.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction((((this.computeValue() - 2) + (70.0F * var43)) + 42.0F), ((this.computeValue2() + 23.0F) - 1.5F), 7.0F, 7.0F, 2.5F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), context.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        context.method_51448().popMatrix();
    }

    public void updateValue(long arg0) {
        long var3 = (arg0 ^ 90548526182604L);
        if (!(serviceComponent10.checkCondition(1000))) {
            return;
        }
        enabledFlag = 0;
        int var6 = countValue;
        countValue = (var6 + 1);
        if (var6 > 20) {
            enabledFlag2 = 0;
        }
        ThreadsKt.thread$default(0, 0, null, null, 0, this::getUnit);
    }

    private static Unit getUnit() {
        Iterable var7 = (Iterable) MediaPlayerInfo.Instance.getMediaSessions();
        int var8 = 0;
        Iterator iterator = var7.iterator();
        while (iterator.hasNext()) {
            Object var10 = iterator.next();
            IMediaSession var11 = (IMediaSession) var10;
            int var12 = 0;
            mediaInfo = var11.getMedia();
            textValue = var11.getOwner();
            if (var11.getMedia().getArtwork() != null) {
                BufferedImage var13 = var11.getMedia().getArtwork();
                int var14 = 0;
                PolygonShaderComponent.INSTANCE.executeAction(minecraftRef, UrlServiceComponent.INSTANCE.resolveBufferedImage());
                minecraftRef2 = new class_241(var13.getWidth(), var13.getHeight());
            } else {
            }
            enabledFlag2 = 1;
            countValue = 0;
        }
        enabledFlag = 1;
        serviceComponent10.executeAction();
        return Unit.INSTANCE;
    }

    static {
        INSTANCE = new MediaPlayerWidgetCheckRenderHelperImpl();
        minecraftRef = StringServiceComponent2.resolveMinecraftObject("catlean", "temp/cover");
        minecraftRef2 = new class_241(1.0F, 1.0F);
        enabledFlag = 1;
        textValue = "";
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT, var0[1]);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK, var0[0]);
        serviceComponent10 = new ServiceComponent10();
    }

}
