package shop;

import shop.assortment.Auto;
import shop.assortment.Food;
import shop.assortment.Household;
import shop.assortment.Product;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private List<Order> orderList;
    private List<String> storeFeatures;

    public Shop(String name) {
        this.name = name;
        storeFeatures = new ArrayList<>();
    }

    public List<String> getStoreFeatures() {
        return storeFeatures;
    }

    private List<Product> catalog;
    private List<Integer> priceСatalog;

    public List<Product> getCatalog() {
        return catalog;
    }

    public List<Integer> getPriceСatalog() {
        return priceСatalog;
    }

    public void completionСatalogAndPriceDefault() {
        catalog = new ArrayList<>();
        priceСatalog = new ArrayList<>();
        catalog.add(new Food("Хлеб", "шт.", 7, "Нарезать"));
        priceСatalog.add(35);
        catalog.add(new Household("Пемолюкс", "шт.", 365, "Одеть перчатки, насыпать на поверхность и чиститть щеткой"));
        priceСatalog.add(77);
        catalog.add(new Auto("Масло", "л.", "Новый", "иномарка"));
        priceСatalog.add(1500);
    }

    public void printCatalogAndPrice() {
        for (int i = 0; i < catalog.size(); i++) {
            System.out.println(i + 1 + ". Товар:" + catalog.get(i) + ", цена:" + priceСatalog.get(i));
        }
    }

    public void printCatalogAndPrice(String keyword) {
        catalog.stream()
                .filter(w -> w.getName().contains(keyword))
                .forEach(s -> System.out.println("Товар:" + s.getName() + ", цена:" + priceСatalog.get(catalog.indexOf(s))));
    }

    public void printCatalogAndPrice(int price, int sign) {
        priceСatalog.stream()
                .filter(w -> {
                    if (sign == 1) {
                        return (w >= price);
                    } else {
                        return (w <= price);
                    }
                })
                .forEach(s -> System.out.println("Товар:" + catalog.get(priceСatalog.indexOf(s)) + ", цена:" + s));

    }

    public void addProductInCatalog(Product product, int price) {
        catalog.add(product);
        priceСatalog.add(price);
    }

    public void addStoreFeaturesDefault() {
        storeFeatures.add("1. Выйти");
        storeFeatures.add("2. Посмотреть каталог магазина");
        storeFeatures.add("3. Отфильтровать по ключевому слову");
        storeFeatures.add("4. Отфильтровать по цене");
        storeFeatures.add("5. Оформить заказ");
    }

    public void addStoreFeatures(String possibility) {
        storeFeatures.add(possibility);
    }

    public void printStoreFeatures() {
        for (String s : storeFeatures) {
            System.out.println(s);
        }
    }

}
