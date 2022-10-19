public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private double m;
    private double b;
    private double distance;
    private String equation;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double calculateSlope(){   // make it double but print as int
        m = Math.round((y2 - y1) / (x2 -x1) * 100.0) / 100.0;
        return m;
    }

    public double calculateDistance(){
        distance = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2-y1,2));
        return Math.round(distance * 100.0) / 100.0;
    }

    public double calculateIntersect(){
        if (x1 < 0)
                b = y1 + (Math.abs(x1) * m);
        else if (x1 > 0)
            b = y1 - (x1 * m);
        else
            b = x1;
        return Math.round(b * 100.0) / 100.0;
    }

    public int findGCD(int n1, int n2) {
        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public String decimalToFraction(){
        String slopeAsString = Double.toString(m * 100);
        int period = slopeAsString.indexOf(".");
        int numerator = Integer.valueOf(slopeAsString.substring(0,period));
        int denominator = 100;
        int gcd = findGCD(Math.abs(numerator),denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "/" + denominator;
    }
    public String slopeIntersectForm(){
        if (b < 0) {
            equation = decimalToFraction() + ("x - ") + Math.abs((double) b); // if b is negative, will change the "+" to a "-"
        }
        else if (b >= 0){
            equation = decimalToFraction() + ("x + ") + (double) b; // if b is not negative, will use the normal y = mx + b format
        }
        return equation;
    }

    public String toString(){
        String pair1 = "(" + x1 + (",") + y1 + (")");
        String pair2 = "(" + x2 + (",") + y2 + (")");
        String s = "First Pair: " + pair1 + ("\nSecond Pair: " + pair2 + ("\nSlope of Line: ") + calculateSlope()
                + ("\nY-intersect: ") + calculateIntersect() + ("\nSlope intersect form: ") + slopeIntersectForm()
                + ("\nDistance between points: ") + calculateDistance());
        return s;
    }

    public String calculateY(double x){ // Given an x-value, it will return the coordinate of that value according to the linear equation.
        return "Solved coordinate point is: (" + x + ", " + (m * x + b) + ")";
    }
}
