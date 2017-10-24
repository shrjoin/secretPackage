package by.gsu.epamlab;

import java.util.Random;

public class BusinessTrip {
    private static int accountIndex = 0;

    private static final int DAILY_ALLOWANCE_RATE_IN_BLR = 222;
    private String employeeAccount;
    private int transportationExpensesInBYN;
    private int numberOfDays;

    public BusinessTrip() {
        this.employeeAccount = "EmployeeAccount_" + accountIndex;
        accountIndex++;
        this.transportationExpensesInBYN = 111;
        this.numberOfDays = 1;
    }

    public BusinessTrip(String employeeAccount, int transportationExpensesInBYN, int numberOfDays) {
        this.employeeAccount = employeeAccount;
        this.transportationExpensesInBYN = transportationExpensesInBYN;
        this.numberOfDays = numberOfDays;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public double getTransportationExpensesInBYN() {
        return transportationExpensesInBYN;
    }

    public void setTransportationExpensesInBYN(int transportationExpensesInBYN) {
        this.transportationExpensesInBYN = transportationExpensesInBYN;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    private String transferKopecksIntoRublesString(int kopecks) {
        String rubles = String.valueOf(kopecks);
        StringBuilder sb = new StringBuilder();
        switch (rubles.length()) {
            case 1:
                sb.append("0.0").append(rubles);
                return sb.toString();
            case 2:
                sb.append("0.").append(rubles);
                return sb.toString();
            default:
                String firstHalf = rubles.substring(0, rubles.length() - 2);
                String secondHalf = rubles.substring(rubles.length() - 2, rubles.length());

                sb.append(firstHalf).append(".").append(secondHalf);
                return sb.toString();
        }
    }

    private String getTotal() {
        int totalCost = transportationExpensesInBYN + DAILY_ALLOWANCE_RATE_IN_BLR * numberOfDays;
        return transferKopecksIntoRublesString(totalCost);
    }

    public void show() {
        System.out.println("Account = " + employeeAccount
                + ",\ndaily allowance rate in BYN = " + transferKopecksIntoRublesString(DAILY_ALLOWANCE_RATE_IN_BLR)
                + ",\ntransportation expenses in BYN = " + transferKopecksIntoRublesString(transportationExpensesInBYN)
                + ",\nnumber of days = " + numberOfDays
                + ",\ntotal business trip cost = " + getTotal() + ".\n");
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", employeeAccount, transferKopecksIntoRublesString(transportationExpensesInBYN), numberOfDays, getTotal());
    }

    public static BusinessTrip createRandomBusinessTrip() {
        String employeeAccount = "EmployeeAccount_" + accountIndex;
        accountIndex++;
        int transportationExpensesInBYN = new Random().nextInt(100) + 100;
        int numberOfDays = new Random().nextInt(10) + 1;

        return new BusinessTrip(employeeAccount, transportationExpensesInBYN, numberOfDays);
    }
}
