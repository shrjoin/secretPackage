package by.gsu.epamlab;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class Runner {
    public static void main(String[] args) {
        BusinessTrip[] businessTripsArray = task1_CreateBusinessTripArray();

        task2_OutputArrayContentToConsoleUsingShowMethod(businessTripsArray);

        businessTripsArray = task3_UpdateEmployeeTransportationExpensesForLastObjectOfArray(businessTripsArray);

        task4_OutputTotalDurationOfTwoInitialBusinessTripsBySingleOperator(businessTripsArray);

        task5_OutputArrayContentToConsoleUsingToString(businessTripsArray);
    }

    private static BusinessTrip[] task1_CreateBusinessTripArray() {
        return Stream.of(
                BusinessTrip.createRandomBusinessTrip(),
                BusinessTrip.createRandomBusinessTrip(),
                null,
                BusinessTrip.createRandomBusinessTrip(),
                new BusinessTrip())
                .toArray(BusinessTrip[]::new);
    }

    private static void task2_OutputArrayContentToConsoleUsingShowMethod(BusinessTrip[] businessTripsArray) {
        Arrays.stream(businessTripsArray)
                .filter(Objects::nonNull)
                .forEach(BusinessTrip::show);
    }

    private static BusinessTrip[] task3_UpdateEmployeeTransportationExpensesForLastObjectOfArray(BusinessTrip[] businessTripsArray) {
        int arrayLength = businessTripsArray.length;
        if (arrayLength > 0) {
            if (businessTripsArray[arrayLength - 1] != null) {
                BusinessTrip[] changedBusinessTripsArray = businessTripsArray.clone();
                changedBusinessTripsArray[arrayLength - 1].setTransportationExpensesInBYN(999);

                return changedBusinessTripsArray;
            } else {
                return businessTripsArray;
            }
        } else {
            return businessTripsArray;
        }
    }

    private static void task4_OutputTotalDurationOfTwoInitialBusinessTripsBySingleOperator(BusinessTrip[] businessTripsArray) {
        if (businessTripsArray.length > 1) {
            if (businessTripsArray[0] != null && businessTripsArray[1] != null) {
                int duration = businessTripsArray[0].getNumberOfDays() + businessTripsArray[1].getNumberOfDays();
                System.out.println("Total duration of two initial business trips: " + duration +"\n");
            } else {
                System.out.println("Total duration of two initial business trips: ERROR, incorrect business trip value\n");
            }
        } else {
            System.out.println("Total duration of two initial business trips: ERROR, number of business trips < 2\n");
        }
    }

    private static void task5_OutputArrayContentToConsoleUsingToString(BusinessTrip[] businessTripsArray) {
        Arrays.stream(businessTripsArray)
                .filter(Objects::nonNull)
                .forEach(System.out::println);
    }
}
