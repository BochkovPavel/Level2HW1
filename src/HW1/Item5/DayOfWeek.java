package HW1.Item5;

public enum DayOfWeek {
    SUNDAY (0),
    MONDAY ( 8),
    TUESDAY (8),
    WEDNESDAY (8),
    THURSDAY (8),
    FRIDAY (7),
    SATURDAY (0);
    private int hours;

    DayOfWeek(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }

}

