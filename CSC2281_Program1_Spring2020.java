

// Name: Brock Wilson
// Date: 2/7/20
// Assignment Title: FSC Chick-fil-A






package csc2281_program1_spring2020;

import java.util.*;

public class CSC2281_Program1_Spring2020 {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		
		// Initialize relevant variables
		int mmNum;
		String bldStr;
		String nmStr;
		int fChoice;
		String[] receiptStr = new String[50];
		double[] receiptDoub = new double[50];
		int i = 0;
		int orderNum = 1947;
		
		
		while (true) {
			orderNum++;
			mmNum = readAndVerifyMain(in);
			// Checks if user chooses 1  on main menu, the option to order food
			if (mmNum == 1) {
				bldStr = readAndVerifyBLDchoice(in);
				// Checks if user selects breakfast
				if (bldStr.equals("breakfast")) {
					while (true) {
						fChoice = readAndVerifyFoodChoice(in, bldStr);
						// Determines breakfast food ordered. Sets arrays at i to names and prices
						switch (fChoice) {
							case 1:
								receiptStr[i] = "Chick-fil-A Chicken Biscuit";
								receiptDoub[i] = 3.49;
								break;
								
							case 2: 
								receiptStr[i] = "Chicken, Egg & Cheese Bagel";
								receiptDoub[i] = 3.69;
								break;

							case 3:
								receiptStr[i] = "Hash Brown Scramble Burrito";
								receiptDoub[i] = 3.79;
								break;

							case 4:
								receiptStr[i] = "Egg White Grill";
								receiptDoub[i] = 3.69;
								break;

							case 5:
								receiptStr[i] = "Chick-fil-A Chicken Biscuit";
								receiptDoub[i] = 3.49;
								break;
						}
						// Counts up the array indices by 1 in order to go to next order
						i++;
						// Checks if user wants to continue ordering						
						if (readAndVerifyYesNo(in) == false) {
							char discountType = readAndVerifyDiscountType(in);
							printReceipt(bldStr, receiptStr, receiptDoub, discountType, i, orderNum);
							break;
						}
					}
				}
				// Checks if user selects lunch or dinner
				else if (bldStr.equals("lunch") || bldStr.equals("dinner")) {
					while (true) {
						fChoice = readAndVerifyFoodChoice(in, bldStr);
						//  Determines lunch/dinner food ordered. Sets arrays at i to names and prices.
						switch (fChoice) {
							case 1:
								receiptStr[i] = "Chick-fil-A Chicken Sandwich";
								receiptDoub[i] = 3.49;
								break;
							case 2:
								receiptStr[i] = "Spicy Chicken Sandwich";
								receiptDoub[i] = 3.75;
								break;
							case 3:
								receiptStr[i] = "Grilled Chicken Sandwich";
								receiptDoub[i] = 4.75;
								break;
							case 4:
								receiptStr[i] = "Waffle Potato Fries";
								receiptDoub[i] = 1.85;
								break;
							case 5:
								receiptStr[i] = "Milkshake";
								receiptDoub[i] = 2.99;
								break;
						}
						// Counts up the array indices by 1 in order to go to next order
						i++;
						// Checks if user wants to continue ordering
						if (readAndVerifyYesNo(in) == false) {
							char discountType = readAndVerifyDiscountType(in);
							printReceipt(bldStr, receiptStr, receiptDoub, discountType, i, orderNum);
							break;
						}
					}
				}
				
				
			}
			// Checks if user enters option 2 on main menu, the option to view the menu for nutritional facts
			else if (mmNum == 2) {
				nmStr = readAndVerifyNMchoice(in);
				// Checks if user wants to view menu.
				if (nmStr.equals("breakfast") || nmStr.equals("lunch") || nmStr.equals("dinner")) {
					printNutritionalInfo(nmStr);
				}
			}
			// Checks if user enters option 3 on main menu, the option to quit.
			else if (mmNum == 3) {
				break;
			}
		}
		
		
		
		
		
	}
	// Simply displays main menu
	public static void showMainMenu() {
		System.out.print(
"\n----------------------------------------------------------\n" +
"|             FSC Chick-fil-A Ordering System            |\n" +
"----------------------------------------------------------\n" +
"| Please choose from the following menu:                 |\n" +
"|     1. Place a food order.                             |\n" +
"|     2. Nutritional Information.                        |\n" +
"|     3. Exit the Ordering System.                       |\n" +
"----------------------------------------------------------\n" +
"> Enter your choice: ");
	}
	// Reads through user responses until valid response given, returns response
	public static int readAndVerifyMain(Scanner in) {
		int mmChoice;
		String conv;
		while (true) {
			showMainMenu();
			// ASCII converter so that my code does not crash if given the wrong input
			conv = in.next();
			int ascii = (int) conv.charAt(0);
			if (conv.length() == 1 && (ascii == 49 || ascii == 50 || ascii == 51)) {
				mmChoice = ascii-48;
				break;
			}
			else {
				System.out.print("\n> You entered an invalid option. Please try again.\n");
			}
		}
		return mmChoice;
	}
	// Simply displays the type of food options to order from
	public static void showFoodOrderMenu() {
		System.out.print(
"\n----------------------------------------------------------\n" +
"|                  Placing a Food Order                  |\n" +
"----------------------------------------------------------\n" +
"| Please choose from the following menu:                 |\n" +
"|     Enter \"Breakfast\" to place a breakfast order       |\n" +
"|     Enter \"Lunch\" to place a lunch order               |\n" +
"|     Enter \"Dinner\" to place a dinner order             |\n" +
"|     Or, enter \"Return\" to return to previous menu      |\n" +
"----------------------------------------------------------\n" +
"> Enter your choice: " );
	}
	// Loops until valid choice between breakfast lunch or dinner is given, returns choice
	public static String readAndVerifyBLDchoice(Scanner in) {
		String bldChoice;
		while (true) {
			showFoodOrderMenu();
			bldChoice = in.next();
			bldChoice = bldChoice.toLowerCase();
			if (bldChoice.equals("breakfast") || bldChoice.equals("lunch") || bldChoice.equals("dinner") || bldChoice.equals("return")) {
				break;
			}
			else {
				System.out.print("\n> You entered an invalid option. Please try again.\n");
			}
		}
		return bldChoice;
	}
	// Displays menu for displaying nutritional facts about each food type, used to take user input in later method
	public static void showNutritionalMenu() {
		System.out.print(
"\n------------------Nutritional Information-----------------\n" +
"Please choose from the following:\n" +
"    Enter \"Breakfast\" to view breakfast nutritional info.\n" +
"    Enter \"Lunch\" to view lunch nutritional info.\n" +
"    Enter \"Dinner\" to view dinner nutritional info.\n" +
"    Or, enter \"Return\" to return to previous menu.\n" + 
"> Enter your choice: " );
	}
	// Waits for user selection on menu. Loops until user chooses valid option. Returns choice.
	public static String readAndVerifyNMchoice(Scanner in) {
		String nmChoice;
		while (true) {
			showNutritionalMenu();
			nmChoice = in.next();
			nmChoice = nmChoice.toLowerCase();
			if (nmChoice.equals("breakfast") || nmChoice.equals("lunch") || nmChoice.equals("dinner") || nmChoice.equals("return")) {
				break;
			}
			else {
				System.out.print("\n> You entered an invalid option. Please try again.\n");
			}
		}
		return nmChoice;
	}
	// Simply displays the options for breakfast foods
	public static void showBreakfastMenu() {
		System.out.print(
"\n--------------------> Breakfast Menu <--------------------\n" +
"    1. Chick-fil-A Chicken Biscuit            $3.49\n" +
"    2. Chicken, Egg & Cheese Bagel            $3.69\n" +
"    3. Hash Brown Scramble Burrito            $3.79\n" +
"    4. Egg White Grill                        $3.65\n" +
"    5. Hash Browns                            $1.09\n" +
"----------------------------------------------------------\n" +
"Enter your choice (1, 2, 3, 4, or 5): ");
	}
	// Simply displays the options for lunch and dinner foods. Takes input on which option user would like to see.
	public static void showLunchDinnerMenu(String ldChoice) {
		String ld = "";
		if (ldChoice.equals("lunch")) {
			ld = "-------------------->  Lunch Menu  <----------------------";
		}
		else if (ldChoice.equals("dinner")) {
			ld = "-------------------->  Dinner Menu  <---------------------";
		}
		System.out.printf(
"\n%s\n" +
"    1. Chick-fil-A Chicken Sandwich           $3.49\n" +
"    2. Spicy Chicken Sandwich                 $3.75\n" +
"    3. Grilled Chicken Sandwich               $4.75\n" +
"    4. Waffle Potato Fries                    $1.85\n" +
"    5. Milkshake                              $2.99\n" +
"----------------------------------------------------------\n" +
"Enter your choice (1, 2, 3, 4, or 5): ", ld);
		
	}
	// Displays ordering menu based on input. Loops until valid option given. Returns choice.
	public static int readAndVerifyFoodChoice(Scanner in, String bldChoice2) {
		bldChoice2 = bldChoice2.toLowerCase();
		String foodChoice = "";
		OUTER:
		while (true) {
			if (bldChoice2.equals("breakfast")) {
				showBreakfastMenu();
			}
			else {
				showLunchDinnerMenu(bldChoice2);
			}
			foodChoice = in.next();
			switch (foodChoice) {
				case "1": case "2": case "3": case "4": case "5":
					break OUTER;
				default:
					System.out.print("\n> You entered an invalid option. Please try again.\n");
			}
		}
		return Integer.parseInt(foodChoice);
	}
	// Asks if the user would like to continue ordering. Can only answer y or Y, for yes or n or N, for no.
	// Loops until user enters valid response.
	public static boolean readAndVerifyYesNo(Scanner in) {
		
		String ynStr;
		boolean ynChoice;
		OUTER:
		while (true) {
			System.out.print("\nWould you like another item (Y/N): ");
			ynStr = in.next().toLowerCase();
			switch (ynStr) {
				case "y":
					ynChoice = true;
					break OUTER;
				case "n":
					ynChoice = false;
					break OUTER;
				default:
					System.out.print("\n> You entered an invalid option. Please try again.\n");
			}
		}
		return ynChoice;
	}
	
	
	// Asks user what discount they should receive based on
	// faculty or student status.
	public static char readAndVerifyDiscountType(Scanner in) {
		String dtChoice;
		OUTER:
		while (true) {
		System.out.print(
"Florida Southern College Discount Program:\n" +
"    Enter \"s\" for Student or \"f\" for Faculty/Staff.\n" +
"Enter your choice: ");
		
			dtChoice = in.next().toLowerCase();

			// Determines if s  or f inputed
			switch (dtChoice) {
				case "s": case "f":
					break OUTER;
				default:
					System.out.print("> You entered an invalid option. Please try again.\n");
			}
		}
		// Converts s or f to char and returns
		return dtChoice.charAt(0);
	}
	
	
	// Prints out receipt to user
	// Params: receiptHeader - breakfast, lunch, or dinner order. itemsOrdered - all of items ordered. subtotal - all of prices associated with items ordered.
	// discountType - character of s or f that determines discount for student or faculty respectively. numItems - the number of items purchased. orderNum - Cycles thru
	// order number.
	public static void printReceipt(String receiptHeader, String[] itemsOrdered, double[] subtotal, char discountType, int numItems, int orderNum) {
		
		// Initialized secondary variables
		double subtotal2 = 0;
		double discountRate;
		String discountType2;
		// Capitalizes first letter of receiptHeader
		receiptHeader = receiptHeader.substring(0, 1).toUpperCase() + receiptHeader.substring(1);
		
		// Sets String associated with discountType to print to receipt
		if (discountType == 's') {
			discountType2 = "Student";
			discountRate = .4;
		}
		else {
			discountType2 = "Faculty";
			discountRate = .3;
		}
		
		// Receipt header
		System.out.printf(
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +	
"+              %s: Order Number %d              +\n" +	
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n", receiptHeader, orderNum );
		
		// For loop to print multiple lines with items and prices associated that have been ordered.
		for (int j = 0; j < numItems; j++) {
			subtotal2 += subtotal[j];
			System.out.printf(
"+    %d. %s            $ %.2f    +\n", j+1, itemsOrdered[j], subtotal[j] );
		}
		
		// Applying discount to variables. Results in discountTotal, representing "saved dollars"
		// Also resulting in total, all items subtracted from discountTotal.
		double discountTotal = subtotal2*discountRate;
		double total = subtotal2-discountTotal;
		
		
		// Prints out formatted variables into bottom of print statement.
		// subtotal2 - represents the real subtotal
		// discountType2 - represents the type of person receiving discount
		// discountTotal - representing "saved dollars"  from discount
		// total - represents true total of order
		// numItems - number of items determines time. 1 min per item.
			System.out.printf(
"+    ------------------------------------------------    +\n" +
"+    Subtotal:                                 $ %.2f    +\n" +	
"+    %s Discount:                         $ %.2f    +\n" +
"+    ------------------------------------------------    +\n" +
"+    Total:                                    $ %.2f    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+         Your order will be ready in %d minutes.         +\n" +
"+               Thank you for your order!                +\n" +
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n", subtotal2, discountType2, discountTotal, total, numItems);
		
		
	}
	// Displays corresponding nutritional info based on input.
	// Input must be one of the food types: breakfast, lunch, or dinner.
	public static void printNutritionalInfo(String bldNMChoice) {
		
		// Capitalizes first character
		bldNMChoice = bldNMChoice.substring(0, 1).toUpperCase() + bldNMChoice.substring(1);
			
		
		// Determines which menu to print
		if (bldNMChoice.equals("Breakfast")) {
			System.out.print(
"\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
"+-------------------> Breakfast Menu <-------------------+\n" +
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
"+                                                        +\n" +
"+    1. Chick-fil-A Chicken Biscuit                      +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       440|        20g|        48g|        16g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    2. Chicken, Egg & Cheese Bagel                      +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       460|        18g|        49g|        26g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    3. Hash Brown Scramble Burrito                      +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       690|        38g|        52g|        35g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    4. Egg White Grill                                  +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       300|         7g|        31g|        25g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    5. Hash Browns                                      +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       250|        17g|        23g|         3g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" );
		}
		else {
			System.out.printf(
"\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
"+------------------->  %s Menu  <--------------------+ \n" +
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n" +
"+                                                        +\n" +
"+    1. Chick-fil-A Chicken Sandwich                     +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       440|        19g|        40g|        28g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    2. Spicy Chicken Sandwich                           +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       450|        19g|        41g|        29g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    3. Grilled Chicken Sandwich                         +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       310|         6g|        36g|        29g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    4. Waffle Potato Fries                              +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       360|        18g|        43g|         5g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"+    5. Milkshake                                        +\n" +
"+    |  Calories|        Fat|      Carbs|    Protein|    +\n" +
"+    |       580|        22g|        88g|        12g|    +\n" +
"+    ------------------------------------------------    +\n" +
"+                                                        +\n" +
"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n", bldNMChoice);
		}
	}
}
