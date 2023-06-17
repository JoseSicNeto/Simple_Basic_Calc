import java.util.InputMismatchException;
import java.util.Scanner;

								//Class Numbers = Asks for the Values.
class Numbers {
	private int num;
	Scanner type_it = new Scanner(System.in);
	
	public int Type() {
		while(true) {						//Check Exceptions. If the User Enters a Non-Numeric Value. 
			try {
				System.out.print("Enter the value: "); 
				num = type_it.nextInt();
				break;
			}catch(InputMismatchException e) {
				type_it.next();
			}
		}
		return num;
	}
}
											//Class Array = Creates List of Numbers and Average.

class Array{
	private int SizeList;
	private int[] num;
	Scanner type_it = new Scanner(System.in);
											//Asks the Size of the List.
	public void Type() {
		while(true) {
			try {
				System.out.print("Enter the Size of the List: "); 
				SizeList = type_it.nextInt();
				break;
			}catch(InputMismatchException e) {
				type_it.next();
			}
		}									//Type the Numbers in the List.
		num = new int[SizeList];
		
		for(int i = 0; i < SizeList; i++) {
			Numbers number = new Numbers();						//Call the Class Numbers.
			num[i] = number.Type();
		}
	}
											//Do the Average.
	public void Average(){
		double average = 0;
		for(int i = 0; i < SizeList; i++) {
			average = average + num[i]; 
		}
		average = average/SizeList;
		System.out.println("Your average is: " + average);
	}
	
	public void CloseScan() {				//Close the Scanner. Good Practice.
		type_it.close();
	}

}
											//Class Standard = Run Program.

public class Standard {
	public static void main(String[] args) {
		Start();
	}
											//Introduction.
	public static void Start() {
		System.out.println("Discover Your Media Just By Typing Notes.\n");
		Array play = new Array();
		play.Type();
		play.Average();						//Calls Methods of the Class Array.
		play.CloseScan();
	}
}