package by.gsu.epamlab;

public enum WeekDay {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, UNKNOWN_WEEK_DAY;

    static WeekDay getDayOfWeekByNumber(int number) {
        switch (number) {
            case 0: {
                return SUNDAY;
            }
            case 1: {
                return MONDAY;
            }
            case 2: {
                return TUESDAY;
            }
            case 3: {
                return WEDNESDAY;
            }
            case 4: {
                return THURSDAY;
            }
            case 5: {
                return FRIDAY;
            }
            case 6: {
                return SATURDAY;
            }
            default: {
                return UNKNOWN_WEEK_DAY;
            }
        }
    }
}