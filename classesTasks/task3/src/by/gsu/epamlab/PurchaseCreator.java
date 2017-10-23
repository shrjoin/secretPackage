package by.gsu.epamlab;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PurchaseCreator {
    public Purchase[] getArrayWithValuesFromFile(String filePath) throws IOException {
        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            List<String> stringList = new ArrayList<>();
            while (sc.hasNext()) {
                stringList.add(sc.nextLine());
            }

            return stringList.stream().map(this::convertStringToPurchase).toArray(Purchase[]::new);
        }
    }

    private Purchase convertStringToPurchase(String str) {
        String[] valuesFromString = str.split(" ");

        String productName = valuesFromString[0];
        int priceInBYN = Integer.valueOf(valuesFromString[1]);
        int numberOfPurchasedUnits = Integer.valueOf(valuesFromString[2]);
        int discountPercent = Integer.valueOf(valuesFromString[3]);
        int weekDay = Integer.valueOf(valuesFromString[4]);

        return new Purchase(productName, priceInBYN, numberOfPurchasedUnits, discountPercent, weekDay);
    }
}
