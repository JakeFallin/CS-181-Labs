/**
 * Created by jakefallin on 9/6/16.
 * I pledge my honor that I have abided by the Stevens Honor System.
 */

public class main {

    /**
     1. Binary Integer Conversion
     2. Square/Cube Root Calculator
     3. Roots of a Quadratic Function */

    //Main method, calls the correct method based on args[0]
    public static void main(String args[])
    {
        String choice = args[0];
        int ch = Integer.parseInt(choice);

        switch(ch) {
            case (1):
                binary(args[1]);
                break;
            case (2):
                squareRoot(args[1]);
                break;
            case (3):
                quadraticRoots(args[1], args[2], args[3]);
                break;
            default:
                System.out.println("Please make your first argument either 1, 2, or 3.");
                break;
        }

    }

    //Method to check what args[1] starts with and calls the appropriate method
    public static void binary(String number)
    {
        //To find the first letter
        String binaryOrDecimal = number.substring(0, 1);
        //The actual numbers
        String v = number.substring(1, number.length());

        if(binaryOrDecimal.equals("b"))
        {
            binaryToDecimal(v);
        }

        else if (binaryOrDecimal.equals("i"))
        {
           decimalToBinary(v);
        }
    }

    //Method if it starts with b, called by binary method.
    public static void binaryToDecimal(String v)
    {
        int val = Integer.parseInt(v);

        //What will be printed.
        int result = 0;

        //What decimal place are we in.
        int power = 0;

        while(val > 0) {

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

        System.out.println("i" + result);
    }

    //Method if it starts with d, called by binary method.
    public static void decimalToBinary(String v)
    {
        int value = Integer.parseInt(v);

        //provide a large array for adequate binary numbers
        //storage is easier in an array for printing
        String result[] = new String[100];

        //keeps track of array position
        int resultCounter = 0;

        while(value > 0)
        {
            //take remainer of value base 2. Either a 1 or 0.
            int remain = value % 2;

            //Add that to array.
            result[resultCounter] = "" + remain;

            //decrement the value
            value = value / 2;

            //increment the array counter
            resultCounter++;
            System.out.println("remainder: " + remain + " value: " + value);


        }

        System.out.print("b");
        //print the array starting at the length the result counter went to -1 (OutOfBound Error otherwise)
        for(int print = resultCounter - 1; print >= 0; print--)
        {
            System.out.print(result[print]);
        }
    }

    //Method to calculate the square root of a number using the Newton Method.
    public static void squareRoot(String number)
    {
        double value = Double.parseDouble(number);

        if(value < 0)
            System.out.println("Error no square root");

        else {

            //let a represent the value of the number
            //let sqrt(a) represent the square root
            //let x represent the working result/square root

            //make a guess that the original is 1/2 of the value.
            double result = value / 2;

            for(int iterations = 0; iterations < 20; iterations++) {

                //sqrt(a) = 1/2(a / x + x)
                result = (value / result + result) * 0.5;
            }

            //format to 10 decimal places
            String output = String.format("%.10f", result);
            System.out.println("Square Root of " + number + " is: " + output);

        }
    }

    //Method to find the quadratic roots of a quadratic equation, given Coefficients a, b, and c.
    public static void quadraticRoots(String Coa, String Cob, String Coc)
    {

        int a, b, c;
        double r1, r2, det;

        //Coefficients
        a = Integer.parseInt(Coa);
        b = Integer.parseInt(Cob);
        c = Integer.parseInt(Coc);

        //What is under the square root
        det = b * b - 4 * a * c;

        // 2 roots if det > 0
        if(det > 0)
        {
            //Opposite of b +/- the square root of b^2 - 4ac / 2a
            r1 = (-b + Math.sqrt(det))/(2*a);
            r2 = (-b - Math.sqrt(det))/(2*a);

            System.out.println("Root 1: " + r1);
            System.out.println("Root 2: " + r2);

        }
        //1 root if det == 0
        else if(det == 0)
        {
            //Opposite of b +/- the square root of b^2 - 4ac / 2a
            r1 = (-b+Math.sqrt(det))/(2*a);

            System.out.println("Root 1: " + r1);

        }
        //0 roots if det < 0
        else
        {
            System.out.println("No Roots");

        }
    }

}

