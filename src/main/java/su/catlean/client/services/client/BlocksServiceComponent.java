package su.catlean.client.services.client;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import su.catlean.client.features.modules.Module;

public class BlocksServiceComponent {

    private final List itemList;
    private static Module[] moduleArray;

    public BlocksServiceComponent(List blocks) {
        this.itemList = blocks;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public BlocksServiceComponent resolveBlocksServiceComponent(List blocks) {
        return new BlocksServiceComponent(blocks);
    }

    public String toString() {
        return ("BlocksValue(blocks=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BlocksServiceComponent)) {
            return false;
        }
        BlocksServiceComponent var5 = (BlocksServiceComponent) other;
        if (!(Intrinsics.areEqual(this.itemList, var5.itemList))) {
            return false;
        }
        return true;
    }

    public BlocksServiceComponent() {
        this();
    }

    public static void updateValue(Module[] arg0) {
        moduleArray = arg0;
    }

    public static Module[] process() {
        return moduleArray;
    }

}
