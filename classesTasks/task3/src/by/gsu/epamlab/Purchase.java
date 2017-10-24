package by.gsu.epamlab;

public class Purchase implements Comparable<Purchase> {
    private String productName;
    private int priceInBYN;
    private int numberOfPurchasedUnits;
    private int discountPercent;
    private final WeekDay weekDay;

    public Purchase() {
        this.weekDay = WeekDay.UNKNOWN_WEEK_DAY;
    }

    public Purchase(String productName, int priceInBYN, int numberOfPurchasedUnits, int discountPercent, int weekDayNumber) {
        this.productName = productName;
        this.priceInBYN = priceInBYN;
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
        this.discountPercent = discountPercent;
        this.weekDay = WeekDay.getDayOfWeekByNumber(weekDayNumber);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPriceInBYN() {
        return priceInBYN;
    }

    public void setPriceInBYN(int priceInBYN) {
        this.priceInBYN = priceInBYN;
    }

    public int getNumberOfPurchasedUnits() {
        return numberOfPurchasedUnits;
    }

    public void setNumberOfPurchasedUnits(int numberOfPurchasedUnits) {
        this.numberOfPurchasedUnits = numberOfPurchasedUnits;
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public WeekDay getWeekDay() {
        return weekDay;
    }

    public int getCost() {
        return priceInBYN * numberOfPurchasedUnits * (100 - discountPercent) / 100;
    }

    @Override
    public String toString() {
        return String.format("%s;%s;%s;%s;%s",
                productName, transferKopecksIntoRublesString(priceInBYN), numberOfPurchasedUnits, discountPercent, transferKopecksIntoRublesString(getCost()));
    }

    public static String transferKopecksIntoRublesString(int kopecks) {
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

    @Override
    public int compareTo(Purchase p) {
        return Integer.compare(this.numberOfPurchasedUnits, p.numberOfPurchasedUnits);
    }
}
