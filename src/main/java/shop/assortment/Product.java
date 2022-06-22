package shop.assortment;

public abstract class Product {
    protected String name;
    protected String unit;

    @Override
    public String toString() {
        return name + " (" + unit + ")";
    }

    public String getName() {
        return name;
    }
}
