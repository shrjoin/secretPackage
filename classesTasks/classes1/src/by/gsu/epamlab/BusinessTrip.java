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

    private String kopToByn(int sum) {
        String sumStr = String.valueOf(sum);
        int sumStrLength = sumStr.length();
        StringBuilder sb = new StringBuilder();

        if (sum < 0) {
            sumStr = sumStr.substring(1, sumStrLength);
            sb.append("-");
        }

        switch (sumStrLength) {
            case 1:
                sb.append("0.0").append(sumStr);
                return sb.toString();
            case 2:
                sb.append("0.").append(sumStr);
                return sb.toString();
            default:
                String firstHalf = sumStr.substring(0, sumStrLength - 2);
                String secondHalf = sumStr.substring(sumStrLength - 2, sumStrLength);

                sb.append(firstHalf).append(".").append(secondHalf);
                return sb.toString();
        }
    }

    private String getTotal() {
        int totalCost = transportationExpensesInBYN + DAILY_ALLOWANCE_RATE_IN_BLR * numberOfDays;
        return kopToByn(totalCost);
    }

    public void show() {
        System.out.println("Account = " + employeeAccount
                + ",\ndaily allowance rate in BYN = " + kopToByn(DAILY_ALLOWANCE_RATE_IN_BLR)
                + ",\ntransportation expenses in BYN = " + kopToByn(transportationExpensesInBYN)
                + ",\nnumber of days = " + numberOfDays
                + ",\ntotal business trip cost = " + getTotal() + ".\n");
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s", employeeAccount, kopToByn(transportationExpensesInBYN), numberOfDays, getTotal());
    }

    public static BusinessTrip createRandomBusinessTrip() {
        String employeeAccount = "EmployeeAccount_" + accountIndex;
        accountIndex++;
        int transportationExpensesInBYN = new Random().nextInt(100) + 100;
        int numberOfDays = new Random().nextInt(10) + 1;

        return new BusinessTrip(employeeAccount, transportationExpensesInBYN, numberOfDays);
    }
}
