public class LinearEquation {
    private int x1; // represents x-value of first coordinate
    private int x2; // represents x-value of second coordinate
    private int y1; // represents y-value of first coordinate
    private int y2; // represents y-value of second coordinate
    private double m; // represents slope
    private double b; // represents y-intercept
    private double distance; // represents the distance between the two points
    private String equation; // represents the equation of line

    public LinearEquation(int x1, int y1, int x2, int y2) { // creates an object using four int parameters and assigns the x and y-values accordingly
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateSlope() {  // method for calculating slope and returns it to the hundredths place
        m = Math.round((double)(y2 - y1) / (x2 -x1) * 100.0) / 100.0;
        return m;
    }

    public double calculateDistance() { // method for calculating the distance using the formula and returns it to hundredths place
        distance = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2-y1,2));
        return Math.round(distance * 100.0) / 100.0;
    }

    public double calculateIntersect() { // method for calculating the y-intersect using the slope and returns it
        if (x1 < 0) { // if the x-value of the first coordinate is positive, will calculate and assign b to a positive value
            b = y1 + (Math.abs(x1) * m);
        }
        else if (x1 > 0) { // if the x-value of the first coordinate is negative, will calculate and assign b to a positive value
            b = y1 - (x1 * m);
        }
        else {
            b = y1; // if the x-value is neither positive nor negative, essentially 0, b is assigned the first coordinate's y-value
        }
        return Math.round(b * 100.0) / 100.0; // returns the y-intersect rounded to hundredths place
    }

    public int findGCD(int n1, int n2) { // method for finding the gcf of a fraction for simplifying, has two int parameters
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) { // assigned i to 1 and assumes it's less than n1 and n2. If condition not met, increase i by 1.
            if (n1 % i == 0 && n2 % i == 0) { // if both the numerator and denominator can be fully divided by i, will set gcd to i's value.
                    gcd = i;
            }
        }
        return gcd;
    }

    public String decimalToFraction() { // method for converting a decimal, assuming it's in hundredths place, to a fraction string
        String slopeAsString = Double.toString(m * 100); // converts slope into a decimal with no values after decimal point
        int period = slopeAsString.indexOf("."); // finds index of "." in the slope
        int numerator = Integer.valueOf(slopeAsString.substring(0,period)); // assigns numerator to value before the decimal point
        int denominator = 100; // assigns denominator to 100 (since this project has all slopes rounded to hundredths place).
        int gcd = findGCD(Math.abs(numerator),denominator); // uses GCD method to assign gcd a value
        numerator = numerator / gcd; // simplifies numerator
        denominator = denominator / gcd; // simplifies denominator
        return numerator + "/" + denominator; // 
    }
    public String slopeIntersectForm() { // method for returning the equation of the line in slope-intersect form
        if (b < 0) {  // if y-intersect is negative, will have equation have a "-" for y-intercept
            equation = decimalToFraction() + ("x - ") + Math.abs((double) b); // if b is negative, will change the "+" to a "-"
        }
        else if (b >= 0) { // if y-intersect is 0 or positive, will have equation have a "+" for y-intercept
            equation = decimalToFraction() + ("x + ") + (double) b; // if b is not negative, will use the normal y = mx + b format
        }
        return equation;
    }

    public String toString() { // method for returning all the information needed about the linear equation
        String pair1 = "(" + x1 + (",") + y1 + (")"); // combines x1 and y1 to make first coordinate
        String pair2 = "(" + x2 + (",") + y2 + (")"); // combines x2 and y2 to make second coordinate
        String information = "First Pair: " + pair1 + ("\nSecond Pair: " + pair2 + ("\nSlope of Line: ") + calculateSlope()
                + ("\nY-intersect: ") + calculateIntersect() + ("\nSlope intersect form: ") + slopeIntersectForm()
                + ("\nDistance between points: ") + calculateDistance()); // puts all information into a string
        return information;
    }

    public String calculateY(double x) { // Given an x-value, it will return the coordinate of that value according to the linear equation.
        return "Solved coordinate point is: (" + x + ", " + (m * x + b) + ")"; // uses mx + b to find y and puts it into coordinate
    }
}
