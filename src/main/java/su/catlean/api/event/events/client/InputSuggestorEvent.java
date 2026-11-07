package su.catlean.api.event.events.client;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.class_637;
import su.catlean.api.event.Event;

public class InputSuggestorEvent extends Event {

    public static final InputSuggestorEvent INSTANCE;
    private static String prefix;
    private static CommandDispatcher dispatcher;
    private static class_637 source;

    private InputSuggestorEvent() {
        super();
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String value) {
        prefix = value;
    }

    public CommandDispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(CommandDispatcher value) {
        dispatcher = value;
    }

    public class_637 getSource() {
        return source;
    }

    public void setSource(class_637 value) {
        source = value;
    }

    static {
        INSTANCE = new InputSuggestorEvent();
        prefix = "";
    }

}
