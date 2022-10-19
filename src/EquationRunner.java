import java.util.Scanner;
public class EquationRunner {
    public static void main(String[] args){
        System.out.print("Enter the first x-y coordinate point: ");
        Scanner myObj = new Scanner(System.in);
        String firstCoordinate = myObj.nextLine();
        int comma = firstCoordinate.indexOf(",");
        int x1 = Integer.valueOf(firstCoordinate.substring(1,comma));
        int y1 = Integer.valueOf(firstCoordinate.substring(comma +1,firstCoordinate.length()-1));
        System.out.print("Enter the second x-y coordinate point: ");
        String secondCoordinate = myObj.nextLine();
        int comma2 = secondCoordinate.indexOf(",");
        int x2 = Integer.valueOf(secondCoordinate.substring(1,comma2));
        int y2 = Integer.valueOf(secondCoordinate.substring(comma2 +1,firstCoordinate.length()-1));
        LinearEquation taco = new LinearEquation(x1,y1,x2,y2);
        System.out.println(taco.toString());
        System.out.println("Enter an x-value: ");


    }
}
