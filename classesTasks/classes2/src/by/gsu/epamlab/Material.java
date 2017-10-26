package by.gsu.epamlab;

public class Material {
    public enum Name {
        STEEL, COPPER;

        public static int getMaterialDensity(Name materialName) {
            switch (materialName) {
                case STEEL:
                    return 7850;
                case COPPER:
                    return 8500;
                default:
                    return 0;
            }
        }
    }

    private Name name;
    private double density;

    public Material() {
    }

    public Material(Name name) {
        this.name = name;
        this.density = Name.getMaterialDensity(this.name);
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
