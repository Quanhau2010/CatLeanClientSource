package su.catlean.client.features.modules;

public enum BlockPlacementRenderMode {

    public static final BlockPlacementRenderMode SHADER;
    public static final BlockPlacementRenderMode FILL;
    public static final BlockPlacementRenderMode LINE;
    public static final BlockPlacementRenderMode BOTH;
    public static final BlockPlacementRenderMode NONE;

    BlockPlacementRenderMode(String arg0, int arg1) {
        super(arg0, arg1);
    }

}
