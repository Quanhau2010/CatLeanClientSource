package su.catlean.client.services.client;

public class OwnerServiceComponent {

    private final int countValue;
    private final int countValue2;
    private final int countValue3;
    private final int countValue4;
    private final char fieldValue;
    private final FontServiceComponent fontServiceComponent;

    public OwnerServiceComponent(int u, int v, int width, int height, char value, FontServiceComponent owner) {
        this.countValue = u;
        this.countValue2 = v;
        this.countValue3 = width;
        this.countValue4 = height;
        this.fieldValue = value;
        this.fontServiceComponent = owner;
    }

    public int getNumericValue() {
        return this.countValue;
    }

    public int getNumericValue2() {
        return this.countValue2;
    }

    public int getNumericValue3() {
        return this.countValue3;
    }

    public int getNumericValue4() {
        return this.countValue4;
    }

    public char process() {
        return this.fieldValue;
    }

    public FontServiceComponent getFontServiceComponent() {
        return this.fontServiceComponent;
    }

}
