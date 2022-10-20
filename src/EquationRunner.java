import java.util.Scanner;
public class EquationRunner {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in); // scanner is created for user input
        System.out.print("Enter the first x-y coordinate point: ");
        String firstCoordinate = myObj.nextLine(); // assigns firstCoordinate given value
        int comma = firstCoordinate.indexOf(","); // finds index of the first coordinate comma and assigns it to comma variable
        int x1 = Integer.valueOf(firstCoordinate.substring(1,comma)); // separates x-value from coordinate
        int y1 = Integer.valueOf(firstCoordinate.substring(comma +1,firstCoordinate.length()-1)); // separates y-value from coordinate
        System.out.print("Enter the second x-y coordinate point: ");
        String secondCoordinate = myObj.nextLine(); // assigns secondCoordinate given value
        int comma2 = secondCoordinate.indexOf(","); // finds index of the second coordinate comma and assigns it to comma2 variable
        int x2 = Integer.valueOf(secondCoordinate.substring(1,comma2)); // separates x-value from coordinate
        int y2 = Integer.valueOf(secondCoordinate.substring(comma2 +1,secondCoordinate.length()-1)); // separates y-value from coordinate
        LinearEquation myEquation = new LinearEquation(x1,y1,x2,y2); // creates object myEquation with the four integer values as inputs
        System.out.println(myEquation.toString()); // prints the information of the linear equation
        System.out.print("Enter an x-value: "); // asks user to put in an x-value
        System.out.println(myEquation.calculateY(myObj.nextDouble())); // prints the coordinate of that x-value


    }
}
