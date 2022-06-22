import shop.Client;
import shop.Order;
import shop.assortment.Food;
import shop.Shop;

import java.util.*;

public class Main {
    private static Shop shop = new Shop("SOLID");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            shop.completionСatalogAndPriceDefault();
            shop.addProductInCatalog(new Food("Молоко", "л.", 5, "Употреблять, использовать в приготовлении пиши"), 90);
            shop.addStoreFeaturesDefault();
            shop.printStoreFeatures();

            while (true) {
                System.out.println("Выберите пункт меню:");
                int input = scanner.nextInt();
                if (input == 1) {
                    System.out.println("Благодарим за покупки!");
                    scanner.close();
                    break;
                }
                //String[] inputPurchases = input.split(" ");
                if (input > 0 && input <= shop.getStoreFeatures().size()) {
                    switch (input) {
                        case (2):
                            printCatalogShop();
                            break;
                        case (3):
                            filteringCatalogShopByWord();
                            break;
                        case (4):
                            filteringCatalogShopByPrice();
                            break;
                        case (5):
                            placeAnOrder();
                            break;
                        default:
                            ;
                            break;
                    }
                } else {
                    System.out.println("Извините, в нашем магазине возможностей под таким номером нет");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    private static void printCatalogShop() {
        shop.printCatalogAndPrice();
    }

    private static void filteringCatalogShopByWord() {
        System.out.println("Введите слово для фильтра:");
        scanner.nextLine();
        shop.printCatalogAndPrice(scanner.nextLine());
    }

    private static void filteringCatalogShopByPrice() {
        int price;
        int sign;
        System.out.println("Введите знак фильтра(1 = '>=';2 = '<='):");
        sign = scanner.nextInt();
        System.out.println("Введите цену:");
        price = scanner.nextInt();
        shop.printCatalogAndPrice(price, sign);
    }

    private static void placeAnOrder() {
        Client client = new Client();
        client.completionClientScanner(scanner);
        int numberOrder = new Random(10_000).nextInt();
        if (numberOrder < 0) {
            numberOrder = numberOrder * (-1);
        }
        Order order = new Order(numberOrder, client);
        //order.setBasket(new ArrayList<>(shop.getCatalog().size()));
        order.setBasket(new ArrayList(Collections.nCopies(shop.getCatalog().size(), 0)));
        while (true) {
            System.out.println("(O-Выход)Введите номер товара:");
            int inputProduct = Integer.parseInt(scanner.nextLine()) - 1;
            if (inputProduct == -1) {
                break;
            }
            System.out.println("Введите количество товара:");
            int inputCount = Integer.parseInt(scanner.nextLine());
            order.getBasket().set(inputProduct, order.getBasket().get(inputProduct) + inputCount);
        }
        System.out.println("Уважаемый клиент " + order.getClient().toString() + ". Ваша заказ №" + order.getNumber() + " оформлен!");
        printBasket(order.getBasket());
    }

    private static void printBasket(List<Integer> basket) {
        int sum = 0;
        for (int i = 0; i < basket.size(); i++) {
            if (basket.get(i) > 0) {
                sum = sum+basket.get(i) * shop.getPriceСatalog().get(i);
                System.out.printf("Товар:%s в количестве %s по цене %s на сумму %s\n",
                        shop.getCatalog().get(i),
                        basket.get(i),
                        shop.getPriceСatalog().get(i),
                        basket.get(i) * shop.getPriceСatalog().get(i));
            }
        }
        System.out.println("---------------------------------");
        System.out.printf("Общая сумма составила:%s\n", sum);
    }
}
