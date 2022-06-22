package shop.assortment;

public class Household extends Product implements InstructionManual, additionalPackaging {
    private int shelfLife;
    private String securityMeasures;
    private final String danger = "Опасно для жизни!";

    public Household(String name, String unit, int shelfLife, String securityMeasures) {
        this.securityMeasures = securityMeasures;
        this.shelfLife = shelfLife;
        super.name = name;
        super.unit = unit;
    }

    @Override
    public String getInstructions() {
        return "Инструкция применения:" + securityMeasures + ". Срок годности:" + shelfLife +
                ", после истечения утилизировать в спецконтейнер!" + danger;
    }

    @Override
    public void pack() {
        System.out.println("Товар дополнительно упакован, чтобы не попал на другие товары!");
    }
}
