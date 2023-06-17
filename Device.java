package calculator;

import java.util.Scanner;
													//Class Numbers = Asks for the Numbers.
class Numbers {
	Scanner type_it = new Scanner(System.in);
	public int Type() {
        System.out.print("Enter the value: "); 
        int num = type_it.nextInt();
        return num;
    }
	public void CloseScan() {
		type_it.close();
	}
}
													//Class Operator = Asks the Operator.

class Operator {
	Scanner type_it = new Scanner(System.in);
	int op;
	public int Type() {								//A Loop Until You Type a Valid Option.
		do {
			System.out.println(" \nWhich Operation Do You Want to Use?");		//Inform the Options.
			System.out.println("1 - Addition --- 2 - Subtraction\n3 - Division --- 4 - Multiplication\n5 - Square Root\n");
        	System.out.print("Enter with your Operator: ");
        	op = type_it.nextInt();
		}while(op < 1 || op > 5);
    	return op;											
	}
	public void CloseScan() {
		type_it.close();
	}
}
													//Class Operations = Do the Math.

class Operations{
	public void Action(int num1, int num2, int op) {		//Get the Values of the Other Classes.
		
		switch (op) {										//A Switch Case for Selecting the Chosen Operation.
		case 1:
			System.out.println("Your Calculation Gave: " + (num1+num2));
			break;
		case 2:
			System.out.println("Your Calculation Gave: " + (num1-num2));
			break;																	//A Break To End Switch Case Execution
		case 3:
			try {																	//A Try Catch To Check Division By Zero.
				System.out.println("Your Calculation Gave: " + (num1/num2));
				break;
			}catch(ArithmeticException a) {
				System.out.println("Error: Impossible to Divide by Zero");
				break;
			}
		case 4:
			System.out.println("Your Calculation Gave: " + (num1*num2));
			break;
		case 5:
			System.out.println("Your Calculation Gave: " + (Math.sqrt(num1)));
			break;																	//Only First Number.
		}
	}
}
													//Class Device = Run Program.

public class Device {
	public static void main(String[] args) {
		Start();												//Organize the Execution.
	}
	
	public static void Start() {
		Numbers number = new Numbers();							
		int num1 = number.Type(); 
		int num2 = number.Type();
		number.CloseScan();
		
		Operator operator = new Operator();						//Call the Classes.
		int op = operator.Type();								//Appends the Value to a Variable.
		operator.CloseScan();
		
		Operations make = new Operations();						
		make.Action(num1, num2, op);			
	}
}