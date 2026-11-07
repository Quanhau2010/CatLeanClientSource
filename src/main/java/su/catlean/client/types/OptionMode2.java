package su.catlean.client.types;

public enum OptionMode2 {

    public static final OptionMode2 HANDSHAKE;
    public static final OptionMode2 FRAME;
    public static final OptionMode2 CLOSE;
    public static final OptionMode2 PING;
    public static final OptionMode2 PONG;

    OptionMode2(String arg0, int arg1) {
        super(arg0, arg1);
    }

}
