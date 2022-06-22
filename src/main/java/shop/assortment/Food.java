package shop.assortment;

public class Food extends Product implements InstructionManual {
    private int shelfLife;
    private String recipe;

    public Food(String name, String unit, int shelfLife, String recipe) {
        this.shelfLife = shelfLife;
        this.recipe = recipe;
        super.name = name;
        super.unit = unit;
    }

    @Override
    public String getInstructions() {
        return "Рецепт приготовления:" + recipe + ". Срок годности:" + shelfLife + ", после истечения не употреблять в пищу!";
    }
}
