package su.catlean.mixins.render;

import su.catlean.api.event.events.render.StringDecomposerEvent;

public abstract class StringDecomposerMixin {

    public StringDecomposerMixin() {
    }

    private static String iterateFormattedHook(String original) {
        return StringDecomposerEvent.INSTANCE.call(original);
    }

}
