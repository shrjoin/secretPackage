package by.gsu.epamlab;

import java.io.IOException;
import java.util.Arrays;

public class Runner {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaStud\\secretPackage\\classesTasks\\task3\\src\\in.txt";

        PurchaseCreator purchaseCreator = new PurchaseCreator();
        Purchase[] arrayWithValuesFromFile = purchaseCreator.getArrayWithValuesFromFile(filePath);

        Arrays.stream(arrayWithValuesFromFile).forEach(System.out::println);

    }
}
