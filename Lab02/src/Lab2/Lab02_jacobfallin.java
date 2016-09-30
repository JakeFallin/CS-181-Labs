
/*
 * Lab02.java
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Jacob Fallin
 *
 */

package Lab2;

/**
 * ENTER A BRIEF DESCRIPTION OF WHAT YOUR PROGRAM DOES HERE
 *
 * IN THE LINES BELOW, FILL IN FIELDS WITH APPROPRIATE RESPONSES. DELETE THIS LINE.
 * @author Jacob Fallin
 * @version 1.0
 * @since 20160913
 *
 */

public class Lab02_jacobfallin {

    public static final String NAME = "Jacob Fallin";

    /**
     * Given a string, in the format of yyyymmdd, extracts the day of the
     * week the date falls on
     *
     * @param s  the string, in the format of yyyymmdd to be processed
     * @return   the day of the week, as a String
     */
    public static String getDay(String s) {

        String[] daysOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        String result = "Invalid";

        int year = 0, month = 0, day = 0;
        //check to make sure its a valid input
        if (s.length() == 8) {

            String ye = s.substring(0, 4);
            String mo = s.substring(4, 6);
            String da = s.substring(6, 8);

            year = Integer.parseInt(ye);
            month = Integer.parseInt(mo);
            day = Integer.parseInt(da);

            int D = 0, M = 0, Y = 0, W = 0;

            //setup to treat jan and feb like 13th/14th month
            if (month >= 1 && month <= 2) {

                D = day;
                M = month + 12;
                Y = year - 1;

            } else {

                D = day;
                M = month;
                Y = year;

            }

            //formula to computer the weekday of any given date.
            W = (D - 1 + ((13 * (M + 1)) / 5) + Y + (Y / 4) - (Y / 100) + (Y / 400)) % 7;

            //compare the week to the string array in days
             result = daysOfWeek[W];
            System.out.println(result);

        }
        return result;
    }

    /**
     * Given a string date and a number, computes the day of the week n days
     * after (or before) the date given
     *
     * @param s  the string, in the format of yyyymmdd to be processed
     * @param n  the number of days after (or before if negative)
     *           the specified date
     * @return   the new date,as a String in yyyymmdd format
     */
    public static String newDate(String s, int n) {

        //number of days in each month
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int year = 0, month = 0, day = 0;
        //check to make sure its a valid input
        if (s.length() == 8) {
            //split string up to yyyy, mm, dd
            String ye = s.substring(0, 4);
            String mo = s.substring(4, 6);
            String da = s.substring(6, 8);

             year = Integer.parseInt(ye);
             month = Integer.parseInt(mo);
             day = Integer.parseInt(da);


            //for adding days
            if (n > 0) {
                for (int i = 0; i < n; i++) {

                    day++; //first increment day

                    if (day > days[month - 1]) { //if day is greater than days in month

                        //check for leap year condition 1
                        if ((month == 02) && (day == 29) && (year % 4 == 0)) {
                        } else {

                            //check for leap year condition 2
                            if ((year % 100 == 0) && (year % 400 == 0)) {
                            } else {

                                month++; //month
                                day = 1;
                            }
                        }
                    }
                    //increment year
                    if (month > 12) {

                        year++;
                        month = 1;
                        day = 1;

                    }
                }
            }
            //if its a negative number
            else if (n < 0) {

                for (int i = 0; i > n; i--) {

                    day--;

                    if (day < 1) {

                        //Checks the month counter
                        //leap year condition 1
                        if (((year % 4 == 0) && (year % 100 != 0)) && (month < 3) || (month > 1)) {
                            month = 2;
                            day = 29;

                            //check if leap year condition 2
                        } else if ((year % 100 == 0 && year % 400 == 0) && month == 3) {
                            month = 2;
                            day = 29;
                        } else {
                            month--;
                        }

                        //once month is established check to decrement the month
                        if (month != 0) {
                            day = days[month - 1]; //out of bounds
                        }
                    }
                    //year increment
                    if (month < 1) {
                        year--;
                        month = 12;
                        day = days[month - 1]; //out of bounds
                    }
                }
            }
            //if its 0, return date
            else {
                return s;
            }
        }
        //formatting return
        String retYear;
        retYear = "" + year;
        retYear = String.format("%04d", year); //year to 4 decimal places
        String retMonth;
        retMonth = "" + month;
        retMonth = String.format("%02d", month); //month to 2 decimal places
        String retDay;
        retDay = "" + day;
        retDay = String.format("%02d", day); //day to 2 decimal places

        System.out.println("New Date: " + retYear + retMonth + retDay);
        return "" + retYear + retMonth + retDay;

    }

    /**
     * Given two dates, computes the number of days inbetween them.
     *
     * @param start  the start date, in the format of yyyymmdd
     * @param end    the end date
     * @return       the number of days between the two dates
     */
    public static int daysBetween(String start, String end) {

        int daysBetween = 0;
        int year = 0, month = 0, day = 0;
        //check to make sure its a valid input
        if ((start.length() == 8) && (end.length() == 8)) {
            String ye = start.substring(0, 4);
            String mo = start.substring(4, 6);
            String da = start.substring(6, 8);
            String ye1 = end.substring(0, 4);
            String mo1 = end.substring(4, 6);
            String da1 = end.substring(6, 8);

            int yearStart = Integer.parseInt(ye);
            int monthStart = Integer.parseInt(mo);
            int dayStart = Integer.parseInt(da);
            int yearEnd = Integer.parseInt(ye1);
            int monthEnd = Integer.parseInt(mo1);
            int dayEnd = Integer.parseInt(da1);

            //math in order to make the calculations work
            //treats jan and feb like the 13th, 14th months
            if (monthStart <= 2) {
                monthStart = monthStart + 13;
                yearStart = yearStart - 1;
            } else {
                monthStart = monthStart + 1;
            }

            if (monthEnd <= 2) {
                monthEnd = monthEnd + 13;
                yearEnd = yearEnd - 1;
            } else {
                monthEnd = monthEnd + 1;
            }

            //formula to compute number of days. Weird constants that factor in leap years
            int sd = ((1461 * yearStart) / 4) + ((153 * monthStart) / 5) + dayStart;
            int ed = ((1461 * yearEnd) / 4) + ((153 * monthEnd) / 5) + dayEnd;
            daysBetween = Math.abs(ed - sd); //in case end date is before start date

            System.out.println(daysBetween + " Days between " + start + " and " + end);

        }
        return daysBetween;

    }

    /*
     * For Testing may delete the inner code.
     */
    public static void main(String[] args){

        int choice = Integer.parseInt(args[0]);

        switch (choice) {

            case(1):
                getDay(args[1]);
                break;

            case(2):
                int numdays = Integer.parseInt(args[2]);
                newDate(args[1], numdays);
                break;

            case(3):
                daysBetween(args[1], args[2]);
                break;
        }
    }
}

