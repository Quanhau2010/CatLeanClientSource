package su.catlean.api.event.events.client;

import net.minecraft.client.gui.screen.Screen;
import su.catlean.api.event.Event;
import su.catlean.gofra.Gofra;

public class ScreenEvent extends Event {

    public static final ScreenEvent INSTANCE;
    private static Screen screen;

    private ScreenEvent() {
        super();
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen value) {
        screen = value;
    }

    public boolean call(Screen screen) {
        this.setCancelled(false);
        screen = screen;
        Gofra.INSTANCE.drain(this);
        return this.getCancelled();
    }

    static {
        INSTANCE = new ScreenEvent();
    }

}
