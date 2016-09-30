/*
 * Lab03.java
 *
 * I pledge my honor that I have abided by the Stevens Honor System.
 * Jacob Fallin
 *
 */

package Lab03; /*DO NOT CHANGE!!!!!!*/

import java.util.ArrayList;
import java.util.List;
/**
 * Preforms the functions of Lab03,
 * converting binary periodic numbers to decimal,
 * finding the longest substring of two given strings,
 * and validating the 3n + 1 conjecture.
 *
 * @author Jacob Fallin
 * @version 1.0
 * @since YYYYMMDD
 *
 */
public class Lab03_jacobfallin {

    public static final String NAME = "Jacob Fallin"; /*<<<insert your name here*/

    /**
     * Given a binary periodic string, return an double value
     * Accepts any input ("._" should return 0)
     *
     * @param s the binay string, in the format of D.A_P
     * @return the String  value of the binary string, in the form of
     * INTEGER_VALUE + numerator/denominator
     */
    public static String binaryPeriodic(String s) {

        //variables
        String D = "", P = "", A = "";
        double y = 0, x = 0, z = 0, result = 0;
        double bk = 1.0, ck = 1.0;
        boolean empty = false;

        //regex to max string into multiple
        String[] periodicValue = s.split("[\\_.]");

        //normal case
        if ((s.contains(".")) && (s.contains("_"))) {
            if (s.length() == 2) //if empty
            {
                empty = true;
            } else {

                D = periodicValue[0];
                A = periodicValue[1];
                P = periodicValue[2];
            }
        }
        //if no Aperiodic
        else if ((s.contains(".")) && (!(s.contains("_")))) {
            D = periodicValue[0];
            A = "0";
            P = periodicValue[1];

        }
        //if no decimal assume 0
        else if ((s.contains("_")) && (!(s.contains(".")))) {
            D = "0";
            A = periodicValue[0];
            P = periodicValue[1];
        }

        //so we know its valid
        if (P.length() > 0) {

            //b formatting
            double periodicVal = (double) binaryToDecimal(P);
            //2k
            bk = Math.pow(2.0, (double) P.length()) - 1;

            //x
            x = periodicVal / bk;
            result = x;

            //if its valid
            if (A.length() > 0) {
                //c
                double aperiodicVal = (double) binaryToDecimal(A);
                //u
                ck = Math.pow(2.0, A.length());

                //y
                y = (x + aperiodicVal) / ck;
                result = y;
            }

            //if valid
            if (D.length() > 0) {
                //z
                z = (double) binaryToDecimal(D);
                result += z;
            }
        }

        //find the least common denominator for the ck, bk
        int denom = (lcm((int) bk, (int) ck));

        //make a string of the value
        String ss = Double.toString(result);

        //prevent overflow
        if (ss.length() > 10)
            ss = ss.substring(0, 11);

        //regex to divide to whole number + fraction
        String[] output = ss.split("\\.");
        int whole = Integer.parseInt(output[0]);

        //fraction in the form between 0 < x < 1
        output[1] = "." + output[1];
        double dd = Double.parseDouble(output[1]);

        // frac * denom = num
        double numerator = dd * denom;

        //round to nearest whole number
        int numInt = (int) Math.round(numerator);

        //String
        String numeratorString = Integer.toString(numInt);
        String denomString = Integer.toString((int) denom);

        //in case its empty
        if(empty)
        {
            whole = 0;
            numeratorString = "0";
            denomString = "0";
        }

        return "" + whole + " + " + numeratorString + "/" + denomString;
    }

    /**
     * Computes an decimal value when supplied with a binary string
     *
     * @param v the number to be processed
     * @return the string in integer form, converted from binary.
     * @requires The value being processed to be positive or 0 in a
     * non decimal format. Handles 0.
     */
    public static int binaryToDecimal(String v) {
        int val = Integer.parseInt(v);

        //What will be printed.
        int result = 0;

        //What decimal place are we in.
        int power = 0;

        while (val > 0) {

            //Chop off the first decimal place
            int remain = val % 10;

            //Take result and add it to the remained to the power of the decimal place
            result = (int) (result + remain * Math.pow(2, power));

            //decrement the value so it doesnt continue forever
            val /= 10;

            //as decimal place increases, increase the power you multiply the remainder by
            //ie. for ones place its 0, for hundreds place its 2.
            power++;

        }

        return result;
    }

    /**
     * Computes the least common multiple of two ints
     * using Eulcidean algorithm for Greatest Common Divisor
     *
     * @param a multiple of Aperiodic Value
     * @param b multiple of Periodic Value
     * @return The least common multiple of the two ints
     * @requires The value of these ints to be > 0 to work
     * correctly and also be less than Math.sqrt(Integer.MAX_VALUE)
     */
    public static int lcm(int a, int b) {
        int c = a, d = b; //so a and b can be used for lcm

        int gcd = 0; // value of gcm

        //computes GCD
        while (c != 0 && d != 0) // until either one of them is 0
        {
            int f = d; //temp
            d = c % d; //mod till one is 0
            c = f; // set equal to temp
        }
        gcd = c + d;

        //gcd determines if smaller is possible and then multiplies
        return a * (b / gcd);
    }

    /**
     * Given a string, find the longest substring fowards and backwards
     * More details in lab description
     * Accepts any input (including empty strings)
     *
     * @param s1 String 1 to be processed
     * @param s2 String 2 to be processed
     * @return a SPACE deliminated string with 4 values:
     * longest substring when both strings forward,
     * longest substring s1 backward, longest substring s2 backward
     * longest substring both backward.
     * Example return is "car car rac rac"
     */
    public static String longestSubstring(String s1, String s2) {

        //check if not applicable
        if (s1 == null || s1.length() == 0) {
            return "";
        } else if (s2 == null || s2.length() == 0) {
            return "";
        }

        //case doesnt matter
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        String result = "";

        //for reversing
        for (int k = 0; k < 4; k++) {
            switch (k) {
                case (0):
                    break;
                case (1):
                    s1 = new StringBuilder(s1).reverse().toString(); //reversed
                    break;
                case (2):
                    s1 = new StringBuilder(s1).reverse().toString(); //normal
                    s2 = new StringBuilder(s2).reverse().toString(); //reversed
                    break;
                case (3):
                    s1 = new StringBuilder(s1).reverse().toString(); //reversed
                    break;
            }

            int firstInCommon = 0; //where to start shared string
            int lastInCommon = 0; //where to end shared string
            int shared = 0;
            boolean multipleOverflow = false;

            for (int i = 0; i < s1.length(); i++) //first string
            {
                for (int j = 0; j < s2.length(); j++)  //second string
                {
                    int greatestMultiple = 0; //How big of a string to they share

                    //while they are the same
                    while ((s1.charAt(i + greatestMultiple) == s2.charAt(j + greatestMultiple))) {
                        //increase common shared value count
                        greatestMultiple++;
                        //shared valuess
                        shared++;

                        //test if overflow
                        if (shared > greatestMultiple) {
                            shared = greatestMultiple; //last = most
                        }

                        //kill loop if out of bounds
                        if ((i + greatestMultiple) >= s1.length())
                            break; //end it

                        //debug test for overflow
                        if ((i + greatestMultiple + 1) > s1.length() + 2) {
                            multipleOverflow = true; //test
                        }

                        //kill loop if out of bounds
                        if ((j + greatestMultiple) >= s2.length())
                            break;
                    }

                    //correct bounds for shared string
                    if (greatestMultiple > lastInCommon) {
                        lastInCommon = greatestMultiple; //last = most
                        firstInCommon = i; //index to start common
                        shared++;
                    }
                }
            }

            int endResult = firstInCommon + lastInCommon;
            // 4 times find bound
            result += s1.substring(firstInCommon, endResult) + " "; //add space for formatting
            //result += s1.substring(shared, (firstInCommon + lastInCommon)) + " ";

        }

        return result;
    }

    /**
     * Computes the intermediate steps of the 3n+1 conjecture
     *
     * @param n the number to be processed
     * @return the string of intermediate steps, seperated by SPACES.
     * The last character of the string, based on the conjecture
     * should always be a 1
     * @requires n to be a positive, non-zero integer
     * ^^The requires flag tells you what input conditions
     * your method requires. So this flag means your method
     * does not need to handle negative nums or 0. Yay!
     */
    public static String threeNPlusOne(int n) {

        //to output
        List<Integer> nums = new ArrayList<>();

        //empty
        if (n == 1)
            return "Already 1";
        //check if overflow error
        if ((n * 3) + 1 > Integer.MAX_VALUE)
            return "Too Large";

        while (n != 1) {

            //if even
            if (n % 2 == 0) {
                n = n / 2; // n/2
                nums.add(n);

                //if odd
            } else if (n % 2 == 1) {
                n = (3 * n) + 1; //3n + 1
                nums.add(n);
            }
        }

        //print result
        String result = "";
        for (int i = 0; i < nums.size(); i++) {
            result = result + nums.get(i) + " ";

        }
        return result;
    }


    public static void main(String[] args) {

//        int i = Integer.parseInt(args[0]);
//
//        switch(i) {
//            case(1):
//                binaryPeriodic(args[1]);
//                break;
//            case(2) :
//                longestSubstring(args[1], args[2]);
//                break;
//            case(3) :
//                int n = Integer.parseInt(args[1]);
//                threeNPlusOne(n);
//                break;
//        }
    }
}
