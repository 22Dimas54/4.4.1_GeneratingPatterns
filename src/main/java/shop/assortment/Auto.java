package shop.assortment;

public class Auto extends Product implements InstructionManual, Destiny {
    private String condition;
    private String carBrand;

    public Auto(String name, String unit, String condition, String carBrand) {
        this.condition = condition;
        super.name = name;
        super.unit = unit;
    }

    @Override
    public String getInstructions() {
        return "Качество " + condition + " влияет на срок службы детали. Храните запчасти в сухом месте!";
    }

    @Override
    public String printDestiny() {
        return "Предназначено для " + carBrand;
    }
}
