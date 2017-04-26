package ua.epamkpi.timonov.tasks.task04;

import java.util.Scanner;

public class Date implements Comparable<Date> {
    public static final int JANUARY = 1;
    public static final int MARCH = 3;
    public static final int MAY = 5;
    public static final int JULY = 7;
    public static final int AUGUST = 8;
    public static final int OCTOBER = 10;
    public static final int DECEMBER = 12;
    public static final int APRIL = 4;
    public static final int JUNE = 6;
    public static final int SEPTEMBER = 9;
    public static final int NOVEMBER = 11;
    public static final int FEBRUARY = 2;

    public static final int NUMBER_OF_MONTHS = 12;
    public static final int DAYS_IN_LONG_MONTH = 31;
    public static final int DAYS_IN_SHORT_MONTH = 30;
    public static final int DAYS_IN_LEAP_YEAR_FEBRUARY = 29;
    public static final int DAYS_IN_NOT_LEAP_YEAR_FEBRUARY = 28;

    public static final String MESSAGE_NEGATIVE_DATE = "Decreasing date leads to negative date";

    private int year;
    private int month;
    private int day;

    public Date() {
    }

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Date getDate() {
        return new Date(year, month, day);
    }

    public void setDate(Date date) {
        this.year = date.getYear();
        this.month = date.getMonth();
        this.day = date.getDay();
    }

    public boolean isCorrect() {
        if (year <= 0) {
            return false;
        }
        if (month <= 0 || month > NUMBER_OF_MONTHS) {
            return false;
        }
        if (!dayInMonthIsCorrect()) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Date anotherDate) {
        int anotherYear = anotherDate.getYear();
        int anotherMonth = anotherDate.getMonth();
        int anotherDay = anotherDate.getDay();
        return year < anotherYear ? -1 : year > anotherYear ? 1 : compareByMonthAndDay(anotherMonth, anotherDay);
    }

    private int compareByMonthAndDay(int anotherMonth, int anotherDay) {
        return month < anotherMonth ? -1 : month > anotherMonth ? 1 : compareByDay(anotherDay);
    }

    private int compareByDay(int anotherDay) {
        return day < anotherDay ? -1 : day > anotherDay ? 1 : 0;
    }

    public void inputDateFromConsole() {
        boolean inputIsCorrect = true;
        Scanner scanner = new Scanner(System.in);
        do {
            if (inputIsCorrect) {
                System.out.println("Please, input date (day, month, year):");
            } else {
                System.out.println("You've entered incorrect date! Please input one more: ");
            }
            System.out.println("Day: ");
            day = scanner.nextInt();
            System.out.println("Month: ");
            month = scanner.nextInt();
            System.out.println("Year: ");
            year = scanner.nextInt();
            inputIsCorrect = isCorrect();
        }
        while (!inputIsCorrect);
    }

    public void printToConsole() {
        System.out.println(this);
    }

    public boolean isLeapYear() {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;
    }

    private boolean dayInMonthIsCorrect() {
        return day > 0 && day <= findDaysNumberInMonth();
    }

    private int findDaysNumberInMonth() {
        int daysInMonth = 0;
        switch (month) {
            case JANUARY:
            case MARCH:
            case MAY:
            case JULY:
            case AUGUST:
            case OCTOBER:
            case DECEMBER:
                daysInMonth = DAYS_IN_LONG_MONTH;
                break;
            case APRIL:
            case JUNE:
            case SEPTEMBER:
            case NOVEMBER:
                daysInMonth = DAYS_IN_SHORT_MONTH;
                break;
            case 2:
                if (isLeapYear()) {
                    daysInMonth = DAYS_IN_LEAP_YEAR_FEBRUARY;
                } else {
                    daysInMonth = DAYS_IN_NOT_LEAP_YEAR_FEBRUARY;
                }
                break;
        }
        return daysInMonth;
    }

    public void increaseByNumberOfDays(int daysToIncrease) {
        int residue = daysToIncrease;
        while (residue > 0) {
            int restInCurrentMonth = findDaysNumberInMonth() - day;
            if (residue <= restInCurrentMonth) {
                day += residue;
                residue = 0;
            } else {
                increaseMonth();
                day = 1;
                residue -= restInCurrentMonth + 1;
            }
        }
    }

    private void increaseMonth() {
        if (month < DECEMBER) {
            month++;
        } else {
            year++;
            month = JANUARY;
        }
    }

    public void decreaseByNumberOfDays(int daysToDecrease) {
        int residue = daysToDecrease;
        while (residue > 0) {
            if (day > residue) {
                day -= residue;
                residue = 0;
            } else {
                int restInCurrentMonth = day;
                decreaseMonth();
                day = findDaysNumberInMonth();
                residue -= restInCurrentMonth;
            }
        }
    }

    private void decreaseMonth() {
        if (month > JANUARY) {
            month--;
        } else {
            if (year > 1) {
                year--;
            } else {
                throw new IllegalArgumentException(MESSAGE_NEGATIVE_DATE);
            }
            month = DECEMBER;
        }
    }

    public void increaseByNumberOfMonths(int monthsToIncrease) {
        for (int i = 0; i < monthsToIncrease; i++) {
            increaseMonth();
        }
        if (!isCorrect()) {
            day = findDaysNumberInMonth();
        }
    }

    public void decreaseByNumberOfMonths(int monthsToDecrease) {
        for (int i = 0; i < monthsToDecrease; i++) {
            decreaseMonth();
        }
        if (!isCorrect()) {
            day = findDaysNumberInMonth();
        }
    }

    public void increaseByNumberOfYears(int yearsToIncrease) {
        year += yearsToIncrease;
        if (!isCorrect()) {
            day = findDaysNumberInMonth();
        }
    }

    public void decreaseByNumberOfYears(int yearsToDecrease) {
        if (year > yearsToDecrease) {
            year -= yearsToDecrease;
            if (!isCorrect()) {
                day = findDaysNumberInMonth();
            }
        } else {
            throw new IllegalArgumentException(MESSAGE_NEGATIVE_DATE);
        }
    }

    public void increaseByYearsMonthsDays(int years, int months, int days) {
        increaseByNumberOfYears(years);
        increaseByNumberOfMonths(months);
        increaseByNumberOfDays(days);
    }

    public void decreaseByYearsMonthsDays(int years, int months, int days) {
        decreaseByNumberOfYears(years);
        decreaseByNumberOfMonths(months);
        decreaseByNumberOfDays(days);
    }

    public int findNumberOfFullMonths(Date anotherDate) {
        if (anotherDate.compareTo(this) > 0) {
            Date copyOfThis = new Date(year, month, day);
            return copyOfThis.runCountMonths(anotherDate);
        } else {
            Date copyOfAnother = new Date(anotherDate.getYear(), anotherDate.getMonth(), anotherDate.getDay());
            return copyOfAnother.runCountMonths(this);
        }
    }

    private int runCountMonths(Date anotherDate) {
        int result = 0;
        boolean currentDateIsLess = true;
        while (currentDateIsLess) {
            increaseMonth();
            if (compareTo(anotherDate) < 0) {
                result++;
            } else {
                currentDateIsLess = false;
            }
        }
        return result;
    }

    public int findNumberOfFullYears(Date anotherDate) {
        if (anotherDate.compareTo(this) > 0) {
            Date copyOfThis = new Date(year, month, day);
            return copyOfThis.runCountYears(anotherDate);
        } else {
            Date copyOfAnother = new Date(anotherDate.getYear(), anotherDate.getMonth(), anotherDate.getDay());
            return copyOfAnother.runCountYears(this);
        }
    }

    private int runCountYears(Date anotherDate) {
        int result = 0;
        boolean currentDateIsLess = true;
        while (currentDateIsLess) {
            year++;
            if (compareTo(anotherDate) < 0) {
                result++;
            } else {
                currentDateIsLess = false;
            }
        }
        return result;
    }

    /* ========= Getters & setters =========== */

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Date)) return false;

        Date date = (Date) o;

        if (year != date.year) return false;
        if (month != date.month) return false;
        return day == date.day;
    }

    @Override
    public int hashCode() {
        int result = year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}
