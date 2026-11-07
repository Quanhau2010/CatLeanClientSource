package su.catlean.mixins.accessors;

import it.unimi.dsi.fastutil.ints.IntList;

public interface ClientboundRemoveEntitiesPacketAccessor {

    public IntList getIds();

    public void setIds(IntList value);

}
