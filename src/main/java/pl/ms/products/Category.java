package pl.ms.products;

public enum Category {
    HOUSEHOLD_ARTICLE("domowe"),
    FOOD_PRODUCT("spozywcze"),
    OTHER("inne");

    private final String plName;

    Category(String plName) {
        this.plName = plName;
    }

    public String getPlName() {
        return plName;
    }
}
