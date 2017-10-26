package by.gsu.epamlab;

public class Material {
    public enum Name {STEEL, COPPER, UNKNOWN}

    private final Name name;
    private final double density;

    public Material() {
        this.name = Name.UNKNOWN;
        this.density = chooseTheDensityOfTheMaterial(name);
    }

    public Material(String name) {
        this.name = chooseNameOfMaterial(name);
        this.density = chooseTheDensityOfTheMaterial(this.name);
    }

    private Name chooseNameOfMaterial(String materialName) {
        switch (materialName.toLowerCase()) {
            case "steel":
                return Name.STEEL;
            case "copper":
                return Name.COPPER;
            default:
                return Name.UNKNOWN;
        }
    }
    private int chooseTheDensityOfTheMaterial(Name materialName) {
        switch (materialName) {
            case STEEL:
                return 7850;
            case COPPER:
                return 8500;
            default:
                return 0;
        }
    }

    public Name getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    @Override
    public String toString() {
        return String.format("%s;%s", name, density);
    }
}
