package su.catlean.client.services.client;

import kotlin.Pair;

public class DraftIdServiceComponent {

    private Object object;
    private String textValue;
    private String textValue2;
    private Pair pair;
    private Pair pair2;
    private Pair pair3;
    private Pair pair4;

    public DraftIdServiceComponent(Object draftId, String details, String state, Pair largeImage, Pair smallImage, Pair button1, Pair button2) {
        this.object = draftId;
        this.textValue = details;
        this.textValue2 = state;
        this.pair = largeImage;
        this.pair2 = smallImage;
        this.pair3 = button1;
        this.pair4 = button2;
    }

    public Object getObject() {
        return this.object;
    }

    public void executeAction(Object value) {
        this.object = value;
    }

    public String getString() {
        return this.textValue;
    }

    public void updateValue(String value) {
        this.textValue = value;
    }

    public String getString2() {
        return this.textValue2;
    }

    public void updateValue2(String value) {
        this.textValue2 = value;
    }

    public Pair getPair() {
        return this.pair;
    }

    public void updateValue(Pair value) {
        this.pair = value;
    }

    public Pair getPair2() {
        return this.pair2;
    }

    public void updateValue2(Pair value) {
        this.pair2 = value;
    }

    public Pair getPair3() {
        return this.pair3;
    }

    public void updateValue3(Pair value) {
        this.pair3 = value;
    }

    public Pair getPair4() {
        return this.pair4;
    }

    public void updateValue4(Pair value) {
        this.pair4 = value;
    }

    public DraftIdServiceComponent() {
        this();
    }

}
