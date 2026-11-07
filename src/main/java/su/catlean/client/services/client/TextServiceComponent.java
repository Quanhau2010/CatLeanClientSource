package su.catlean.client.services.client;

import kotlin.jvm.internal.Intrinsics;

public class TextServiceComponent {

    private final String textValue;

    public TextServiceComponent(String text) {
        this.textValue = text;
    }

    public String getString() {
        return this.textValue;
    }

    public String getString2() {
        return this.textValue;
    }

    public TextServiceComponent resolveTextServiceComponent(String text) {
        return new TextServiceComponent(text);
    }

    public String toString() {
        return ("NotationValue(text=" + this.textValue + ")");
    }

    public int hashCode() {
        return this.textValue.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TextServiceComponent)) {
            return false;
        }
        TextServiceComponent var5 = (TextServiceComponent) other;
        if (!(Intrinsics.areEqual(this.textValue, var5.textValue))) {
            return false;
        }
        return true;
    }

}
