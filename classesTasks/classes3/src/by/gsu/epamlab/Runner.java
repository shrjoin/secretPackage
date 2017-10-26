package by.gsu.epamlab;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        String filePath = "D:\\JavaStud\\secretPackage\\classesTasks\\classes3\\src\\in.txt";

        try (Scanner sc = new Scanner(new FileReader(filePath))) {
            sc.useLocale(Locale.ENGLISH);
//            1. Create an array for PURCHASES_NUMBER purchases.
            final int PURCHASES_NUMBER = sc.nextInt();
            Purchase[] purchases = new Purchase[PURCHASES_NUMBER];
            sc.nextLine();

//            2. Initialize this array by the file data.
            String tempStr;
            Purchase tempPurchase;
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                tempStr = sc.nextLine();
                tempPurchase = convertStringToPurchase(tempStr);
                purchases[i] = tempPurchase;
            }

//            3. Output the array content to the console in the following format:
//            class constants
//            purchase[0]
//            …
//            purchase[PURCHASES_NUMBER - 1]
            for (int i = 0; i < PURCHASES_NUMBER; i++) {
                System.out.println(purchases[i]);
            }

//            4. Calculate:
//              the mean cost of all purchases (3 digits after the point),
//              the total cost of all purchases on Monday,
//              the day with the maximum purchase cost.
//            Output them to the console.

            int totalCostOfAllPurchasesInKopecks = 0;
            double meanCostOfAllPurchasesInKopecks;
            int totalCostOfAllPurchasesOnMonday = 0;
            Purchase tempForSearchWeekDayWithMaxPurchaseCost = purchases[0];

            for (Purchase p : purchases) {
                totalCostOfAllPurchasesInKopecks += p.getCost();

                if (p.getWeekDay().equals(WeekDay.MONDAY)) {
                    totalCostOfAllPurchasesOnMonday += p.getCost();
                }

                if (p.getCost() > tempForSearchWeekDayWithMaxPurchaseCost.getCost()) {
                    tempForSearchWeekDayWithMaxPurchaseCost = p;
                }
            }

            meanCostOfAllPurchasesInKopecks = totalCostOfAllPurchasesInKopecks / PURCHASES_NUMBER;
            String formattedMeanCostOfAllPurchasesInKopecks = String.format("%.3f", meanCostOfAllPurchasesInKopecks);
            System.out.println("\nThe mean cost of all purchases = " + formattedMeanCostOfAllPurchasesInKopecks);

            System.out.println("The total cost of all purchases on Monday = " + Purchase.transferKopecksIntoRublesString(totalCostOfAllPurchasesOnMonday));

            System.out.println("Day with the maximum purchase cost " + tempForSearchWeekDayWithMaxPurchaseCost.getWeekDay() + "\n");

//            5. Sort the array by the field number in the ascending order by the method sort() of the class Arrays.
            Arrays.sort(purchases);

//            6. Output the array content to the console in the format above.
            for (Purchase p : purchases) {
                System.out.println(p);
            }

//            7. Find some purchase with number equaled to 5 by the method binarySearch() of the class Arrays and output it.
            int i = Arrays.binarySearch(purchases, new Purchase());
            System.out.println(i);
        }
    }

    private static Purchase convertStringToPurchase(String str) {
        String[] valuesFromString = str.split(" ");

        int numberOfPurchasedUnits = Integer.valueOf(valuesFromString[0]);
        int discountPercent = Integer.valueOf(valuesFromString[1]);
        int weekDay = Integer.valueOf(valuesFromString[2]);

        return new Purchase(numberOfPurchasedUnits, discountPercent, weekDay);
    }

}