package su.catlean.client.services.client;

import java.util.List;

public class SubCategoriesServiceComponent {

    private final String textValue;
    private final List itemList;

    public SubCategoriesServiceComponent(String id, List subCategories) {
        this.textValue = id;
        this.itemList = subCategories;
    }

    public String getString() {
        return this.textValue;
    }

    public List getList() {
        return this.itemList;
    }

}
