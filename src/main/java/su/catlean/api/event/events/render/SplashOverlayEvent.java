package su.catlean.api.event.events.render;

import java.util.function.Consumer;
import net.minecraft.class_4011;
import net.minecraft.client.gui.DrawContext;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class SplashOverlayEvent extends Event {

    public static final SplashOverlayEvent INSTANCE;
    private static boolean reloading;
    private static float progress;
    private static long reloadCompleteTime;
    private static long reloadStartTime;
    private static class_4011 reload;
    private static Consumer exceptionHandler;
    private static DrawContext context;

    private SplashOverlayEvent() {
        super();
    }

    public boolean getReloading() {
        return reloading;
    }

    public void setReloading(boolean value) {
        reloading = value;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float value) {
        progress = value;
    }

    public long getReloadCompleteTime() {
        return reloadCompleteTime;
    }

    public void setReloadCompleteTime(long value) {
        reloadCompleteTime = value;
    }

    public long getReloadStartTime() {
        return reloadStartTime;
    }

    public void setReloadStartTime(long value) {
        reloadStartTime = value;
    }

    public class_4011 getReload() {
        return reload;
    }

    public void setReload(class_4011 value) {
        reload = value;
    }

    public Consumer getExceptionHandler() {
        return exceptionHandler;
    }

    public void setExceptionHandler(Consumer value) {
        exceptionHandler = value;
    }

    public DrawContext getContext() {
        return context;
    }

    public void setContext(DrawContext value) {
        context = value;
    }

    public boolean call(DrawContext context, boolean reloading, float progress, long reloadCompleteTime, long reloadStartTime, class_4011 reload, Consumer exceptionHandler) {
        context = context;
        reloading = reloading;
        progress = progress;
        reloadCompleteTime = reloadCompleteTime;
        reloadStartTime = reloadStartTime;
        reload = reload;
        exceptionHandler = exceptionHandler;
        this.setCancelled(false);
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new SplashOverlayEvent();
        reloadCompleteTime = -1L;
        reloadStartTime = -1L;
    }

}
