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
        if (!(enabledFlag2) && !(SharedKt.getMc().currentScreen instanceof class_408) && !(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
        } else {
        }
        this.executeAction(1.0F);
        this.executeAction(120.0F, 43.0F);
        context.method_51448().pushMatrix();
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 21.5F));
        context.method_51448().scale(((Number) RangesKt.coerceIn(((Comparable) Float.valueOf(easingServiceComponent2.getNumericValue())), RangesKt.rangeTo(0.0F, 2.0F))), ((Number) RangesKt.coerceIn(((Comparable) Float.valueOf(easingServiceComponent2.getNumericValue())), RangesKt.rangeTo(0.0F, 2.0F))));
        context.method_51448().translate((this.computeValue() + 60.0F), (this.computeValue2() + 21.5F));
        if (!(SharedKt.getMc().currentScreen instanceof CatleanWidgetEditorRenderHelper)) {
            if (mediaInfo == null && SharedKt.getMc().currentScreen instanceof class_408) {
                CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 43.0F, 0.0F, false);
                SFMServiceComponent.resolveFontRenderHelper6().render(context, this.getString2(), (this.computeValue() + 60.0F), (this.computeValue2() + 21.0F), NewThemeRenderHelper.INSTANCE.getColor7());
            }
        }
        if (mediaInfo == null) {
            context.method_51448().popMatrix();
            return;
        }
        float factor = RangesKt.coerceIn((mediaInfo.getPosition() / mediaInfo.getDuration()), 0.0F, 1.0F);
        if (mediaInfo.getPlaying()) {
        } else {
        }
        this.executeAction(0.0F);
        CheckRenderHelper.executeAction(this, context.method_51448(), this.computeValue(), this.computeValue2(), 120.0F, 43.0F, 0.0F, false);
        ColorValueShaderComponent.executeAction((this.computeValue() + 4.0F), (this.computeValue2() + 4.0F), 35.0F, 35.0F, 3.0F, 2.0F, 0.0F, RangesKt.coerceIn((easingServiceComponent.getNumericValue() + 0.5F), 0.0F, 1.0F), Color.WHITE, Color.WHITE, context.method_51448(), minecraftRef);
        ColorValueShaderComponent.executeAction((this.computeValue() + 4.0F), (this.computeValue2() + 4.0F), 35.0F, 35.0F, 3.0F, 2.0F, 0.0F, 1.0F, Color.WHITE, Color.WHITE, context.method_51448(), minecraftRef);
        if (!(mediaInfo.getPlaying())) {
            if (easingServiceComponent.getNumericValue() < 1.0F) {
                this.executeAction(context.method_51448(), (this.computeValue() + 13.0F), (this.computeValue2() + 10.0F), 6.0F, 22.0F, (1.0F - easingServiceComponent.getNumericValue()), false);
                this.executeAction(context.method_51448(), (this.computeValue() + 23.0F), (this.computeValue2() + 10.0F), 6.0F, 22.0F, (1.0F - easingServiceComponent.getNumericValue()), false);
            }
        }
        float factor2 = SFMServiceComponent.resolveFontRenderHelper6().computeValue(mediaInfo.getTitle());
        float factor3 = 74.0F;
        int index = (120 / 120.0F);
        String text = String.valueOf((mediaInfo.getPosition() % 60));
        PolygonShaderComponent.INSTANCE.render(context, new ServiceComponent78((this.computeValue() + 43.0F), this.computeValue2(), (this.computeValue() + 116.0F), (this.computeValue2() + 30.0F)));
        if (factor2 > factor3) {
        } else {
        }
        if (factor2 > factor3) {
        } else {
        }
        mediaInfo.getTitle().render((mediaInfo.getTitle() + ""), (this.computeValue() + 42.0F), ((index * factor2) - 0.0F), (this.computeValue2() + 3.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        SFMServiceComponent.resolveFontRenderHelper4().render(context, mediaInfo.getArtist(), (this.computeValue() + 42.0F), (this.computeValue2() + 13.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        PolygonShaderComponent.INSTANCE.render(context);
        if (text.length() == 1) {
        } else {
        }
        context.render((mediaInfo.getPosition() / 60.0F), (":0" + ":" + text), (this.computeValue() + 42.0F), (this.computeValue2() + 29.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        float factor4 = SFMServiceComponent.resolveFontRenderHelper4().computeValue(textValue);
        SFMServiceComponent.resolveFontRenderHelper4().render(context, textValue, ((this.computeValue() + 116.0F) - factor4), (this.computeValue2() + 29.0F), NewThemeRenderHelper.INSTANCE.getColor7());
        ColorValue1RenderHelper.executeAction((this.computeValue() + 42.0F), (this.computeValue2() + 23.0F), 74.0F, 4.0F, 2.0F, PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), PolygonShaderComponent.INSTANCE.resolveColor(NewThemeRenderHelper.INSTANCE.getColor11(), 0.7F), context.method_51448(), 2.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction((this.computeValue() + 42.0F), (this.computeValue2() + 23.0F), (74.0F * factor), 4.0F, 2.0F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), context.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        ColorValue1RenderHelper.executeAction((((this.computeValue() - 2) + (70.0F * factor)) + 42.0F), ((this.computeValue2() + 23.0F) - 1.5F), 7.0F, 7.0F, 2.5F, NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), NewThemeRenderHelper.INSTANCE.getColor9(), context.method_51448(), 1.0F, NewThemeRenderHelper.INSTANCE.getColor12());
        context.method_51448().popMatrix();
    }

    public void updateValue() {
        if (!(serviceComponent10.checkCondition(1000))) {
            return;
        }
        enabledFlag = 0;
        countValue = (countValue + 1);
        if (countValue > 20) {
            enabledFlag2 = 0;
        }
        ThreadsKt.thread$default(false, false, null, null, 0, this::getUnit);
    }

    private static Unit getUnit() {
        Iterable iterable = ((Iterable) MediaPlayerInfo.Instance.getMediaSessions());
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            IMediaSession iMediaSession = ((IMediaSession) element);
            mediaInfo = iMediaSession.getMedia();
            textValue = iMediaSession.getOwner();
            if (iMediaSession.getMedia().getArtwork() != null) {
                BufferedImage bufferedImage = iMediaSession.getMedia().getArtwork();
                PolygonShaderComponent.INSTANCE.executeAction(minecraftRef, UrlServiceComponent.INSTANCE.resolveBufferedImage(bufferedImage));
                minecraftRef2 = new class_241(bufferedImage.getWidth(), bufferedImage.getHeight());
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
        easingServiceComponent = new EasingServiceComponent(TpYawSmootherMode.OUT_QUINT);
        easingServiceComponent2 = new EasingServiceComponent(TpYawSmootherMode.OUT_BACK);
        serviceComponent10 = new ServiceComponent10();
    }

}
