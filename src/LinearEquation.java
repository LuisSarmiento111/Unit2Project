public class LinearEquation {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    private int m;
    private int b;
    private double distance;
    private String equation;

    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int calculateSlope(){
        m = (y2 - y1) / (x2 -x1);
        return m;
    }

    public double calculateDistance(){
        distance = Math.sqrt(Math.pow(x2 - x1,2) + Math.pow(y2-y1,2));
        return Math.round(distance * 100.0) / 100.0;
    }

    public int calculateIntersect(){
        if (x1 < 0)
                b = y1 + (Math.abs(x1) * m);
        else if (x1 > 0)
            b = y1 - (x1 * m);
        else
            b = x1;
        return b;
    }

    public String slopeIntersectForm(){   // Make it print the equation as a fraction and not a decimal and for negative y-intersect
        equation = m + ("x + ") + (double) b;
        return equation;
    }

    public String toString(){
        String pair1 = "(" + x1 + (",") + y1 + (")");
        String pair2 = "(" + x2 + (",") + y2 + (")");
        String s = "First Pair: " + pair1 + ("\nSecond Pair: " + pair2 + ("\nSlope of Line: ") + calculateSlope() + ("\nY-intersect: ") + calculateIntersect() + ("\nSlope intersect form: ") + slopeIntersectForm());
        return s;
    }


}
