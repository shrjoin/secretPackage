package by.gsu.epamlab;

public class Runner {
    public static void main(String[] args) {
//        1. Create the object which represents the steel wire having the volume 0.03 cubic meters.
        Subject wire = new Subject("wire", new Material("steel"), 0.03);

//        2. Output the object content to the console, using toString() method.
        System.out.println(wire);

//        3. Update the wire material to copper (density = 8500.0) and output its mass.
        wire.setMaterial(new Material("copper"));
        System.out.println(wire);
        System.out.println(wire.getMass());
    }
}