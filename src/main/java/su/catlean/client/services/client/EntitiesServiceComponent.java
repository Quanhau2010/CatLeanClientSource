package su.catlean.client.services.client;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public class EntitiesServiceComponent {

    private final List itemList;

    public EntitiesServiceComponent(List entities) {
        this.itemList = entities;
    }

    public List getList() {
        return this.itemList;
    }

    public List getList2() {
        return this.itemList;
    }

    public EntitiesServiceComponent resolveEntitiesServiceComponent(List entities) {
        return new EntitiesServiceComponent(entities);
    }

    public String toString() {
        return ("EntitiesValue(entities=" + this.itemList + ")");
    }

    public int hashCode() {
        return this.itemList.hashCode();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EntitiesServiceComponent)) {
            return false;
        }
        EntitiesServiceComponent entitiesServiceComponent = ((EntitiesServiceComponent) other);
        if (!(Intrinsics.areEqual(this.itemList, entitiesServiceComponent.itemList))) {
            return false;
        }
        return true;
    }

    public EntitiesServiceComponent() {
        this();
    }

}
