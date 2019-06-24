package convert;

import java.util.Scanner;

public class Convert {
	public static void main(String[] args) {
		Scanner key;
		key = new Scanner(System.in);
		System.out.println("Please enter the number:");
		//get the number input as a string
		String input = key.next();
		System.out.println("Please enter the base of the number:");
//		original input base
		int originalBase = key.nextInt();
		//checking the if the base is correct
		//loop util it get right
		while(checkInuputIsRightOrNot(input,originalBase) != 0) {
			//return the error
			System.out.println(errorMessage(checkInuputIsRightOrNot(input,originalBase)));
			System.out.println("Please enter the base of the number:");
			originalBase = key.nextInt();
		}
		System.out.println("Please enter the target base:");
		//get the target base
		int targetBase = key.nextInt();
		String result;
//			check if the input is an integer. if not, then run through the if statement 
		if(integerOrNot(input)) {
			String integerPart = input.substring(0, input.indexOf("."));
			String fractionalPart = input.substring(input.indexOf(".")+1);
			result = connect(integralPartDecimalToTarget(integralPartToDecimal(integerPart,originalBase),targetBase),
			fractionalDecimalToTarget(fractionalPartToDecimal(fractionalPart,originalBase),targetBase));
		}
			//if the input is an integer, then run through the code below
		else {
			result = integralPartDecimalToTarget(integralPartToDecimal(input,originalBase),targetBase);
		}
		//check if the input is a negative number or not
		//if the input is a positive then go through the if statement
		if(!negativeOrNot(input)) {
			System.out.println(eliminateZero(result));
		}else {			
			System.out.println("-" + eliminateZero(result));
		}
		
		
	}
//check if input decimal or integer
	public static boolean integerOrNot(String input) {
		return input.contains(".");
	}
//	check if input negative or positive;
	public static boolean negativeOrNot(String input) {
		return input.startsWith("-");
	}
	public static String eliminateZero(String result) {
		while(result.startsWith("0")) {
			result = result.substring(1);
		}
		return result;
	}
	//convert everything to decimal first
	public static int integralPartToDecimal(String integerPart,int originalBase) {
		int decimal = 0;
		for(int i = 0; i < integerPart.length(); i++) {
			char individualNumber = integerPart.charAt(i);
			if(Character.isDigit(individualNumber)) {
				decimal += Character.getNumericValue(individualNumber) * (int)Math.pow(originalBase, (integerPart.length()-1-i));
			}
			//convert the letter to relate number
			else if(Character.isLetter(individualNumber)) {
				if(individualNumber=='a') {
					decimal += 10 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='b') {
					decimal += 11 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='c') {
					decimal += 12 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='d') {
					decimal += 13 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='e') {
					decimal += 14 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='f') {
					decimal += 15 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='g') {
					decimal += 16 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='h') {
					decimal += 17 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='i') {
					decimal += 18 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='j') {
					decimal += 19 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='k') {
					decimal += 20 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='l') {
					decimal += 21 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='m') {
					decimal += 22 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='n') {
					decimal += 23 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='o') {
					decimal += 24 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='p') {
					decimal += 25 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='q') {
					decimal += 26 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='r') {
					decimal += 27 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='s') {
					decimal += 28 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='t') {
					decimal += 29 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='u') {
					decimal += 30 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='v') {
					decimal += 31 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='w') {
					decimal += 32 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='x') {
					decimal += 33 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='y') {
					decimal += 34 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}else if(individualNumber=='z') {
					decimal += 35 * (int)Math.pow(originalBase, (integerPart.length()-1-i));
				}
			}
		}
		return decimal;
	}
	//convert decimal to target base;
	public static String integralPartDecimalToTarget(int num, int targetBase) {
		String result = "";
		int b = num % targetBase;
		int a = num / targetBase;
		//if the module greater than or equals 10
		result += convertToLetter(b);
		//Divide the target base repeatly
		do {
			b = a % targetBase;
			a = a / targetBase;
			result +=convertToLetter(b);
		}while(a!=0);
		return reverse(result);
	}
	//basing the method of the converting, the order of the answer must be reversed and then can get the right answer;
	public static String reverse(String result) {
		String reverse = "";
		for(int i = result.length() -1 ; i >= 0 ; i--) {
			reverse += result.charAt(i);
		}
		return reverse;
	}
	//convert decimal part to 10 base first
	public static double fractionalPartToDecimal(String fractionalPart,int originalBase) {
		double decimal = 0;
		for(int i = 0 ;i < fractionalPart.length();i++) {
			char individualNumber = fractionalPart.charAt(i);
			if(Character.isDigit(individualNumber)) {
				decimal += Character.getNumericValue(individualNumber) * (Math.pow(originalBase,-(i+1)));
			}
		//convert the letter to relate number
			if(Character.isLetter(individualNumber)) {
				if(individualNumber=='a') {
					decimal += 10 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='b') {
					decimal += 11 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='c') {
					decimal += 12 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='d') {
					decimal += 13 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='e') {
					decimal += 14 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='f') {
					decimal += 15 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='g') {
					decimal += 16 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='h') {
					decimal += 17 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='i') {
					decimal += 18 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='j') {
					decimal += 19 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='k') {
					decimal += 20 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='l') {
					decimal += 21 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='m') {
					decimal += 22 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='n') {
					decimal += 23 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='o') {
					decimal += 24 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='p') {
					decimal += 25 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='q') {
					decimal += 26 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='r') {
					decimal += 27 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='s') {
					decimal += 28 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='t') {
					decimal += 29 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='u') {
					decimal += 30 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='v') {
					decimal += 31 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='w') {
					decimal += 32 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='x') {
					decimal += 33 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='y') {
					decimal += 34 * (Math.pow(originalBase,-(i+1)));
				}else if(individualNumber=='z') {
					decimal += 35 * (Math.pow(originalBase,-(i+1)));
				}
			}
		}
		return decimal;
	}
	//the convert the to the target base;
	public static String fractionalDecimalToTarget(double num, int targetBase) {
		String result ="" ;
		int count = 0;
		double a = num * targetBase;
		double b = a - (int)a/1;
		result += convertToLetter((int)a/1);
		while(b!=0 && count < 10){
			a = b*targetBase;
			result += convertToLetter((int)a/1);
			b = a - a/1;
			count++;
		}
		return result;
	}
//	check if the input and original base match or not
	public static int  checkInuputIsRightOrNot(String input, int originalBase ) {
		
		if(originalBase < 2 || originalBase > 37) {
			return 1;
		}
		
		if(input.toLowerCase().contains("2") && originalBase<3) {
			return 2;
		}
		if(input.toLowerCase().contains("3") && originalBase<4) {
			return 2;
		}
		if(input.toLowerCase().contains("4") && originalBase<5) {
			return 2;
		}
		if(input.toLowerCase().contains("5") && originalBase<6) {
			return 2;
		}
		if(input.toLowerCase().contains("6") && originalBase<7) {
			return 2;
		}
		if(input.toLowerCase().contains("7") && originalBase<8) {
			return 2;
		}
		if(input.toLowerCase().contains("8") && originalBase<9) {
			return 2;
		}
		if(input.toLowerCase().contains("9") && originalBase<10) {
			return 2;
		}
		if(input.toLowerCase().contains("a") && originalBase<11) {
			return 2;
		}
		if(input.toLowerCase().contains("a") && originalBase<11) {
			return 2;
		}
		if (input.toLowerCase().contains("b") && originalBase<12) {
			return 2;
		}
		if(input.toLowerCase().contains("c") && originalBase<13) {
			return 2;
		}
		if(input.toLowerCase().contains("d") && originalBase<14) {
			return 2;
		}
		if(input.toLowerCase().contains("e") && originalBase<15) {
			return 2;
		}
		if(input.toLowerCase().contains("f") && originalBase<16) {
			return 2;
		}
		if(input.toLowerCase().contains("g") && originalBase<17) {
			return 2;
		}
		if(input.toLowerCase().contains("h") && originalBase<18) {
			return 2;
		}
		if(input.toLowerCase().contains("i") && originalBase<19) {
			return 2;
		}
		if(input.toLowerCase().contains("j") && originalBase<20) {
			return 2;
		}
		if(input.toLowerCase().contains("k") && originalBase<21) {
			return 2;
		}
		if(input.toLowerCase().contains("l") && originalBase<22) {
			return 2;
		}
		if(input.toLowerCase().contains("m") && originalBase<23) {
			return 2;
		}
		if(input.toLowerCase().contains("n") && originalBase<24) {
			return 2;
		}
		if(input.toLowerCase().contains("o") && originalBase<25) {
			return 2;
		}
		if(input.toLowerCase().contains("p") && originalBase<26) {
			return 2;
		}
		if(input.toLowerCase().contains("q") && originalBase<27) {
			return 2;
		}
		if(input.toLowerCase().contains("r") && originalBase<28) {
			return 2;
		}
		if(input.toLowerCase().contains("s") && originalBase<29) {
			return 2;
		}
		if(input.toLowerCase().contains("t") && originalBase<30) {
			return 2;
		}
		if(input.toLowerCase().contains("u") && originalBase<31) {
			return 2;
		}
		if(input.toLowerCase().contains("v") && originalBase<32) {
			return 2;
		}
		if(input.toLowerCase().contains("w") && originalBase<33) {
			return 2;
		}
		if(input.toLowerCase().contains("x") && originalBase<34) {
			return 2;
		}
		if(input.toLowerCase().contains("y") && originalBase<35) {
			return 2;
		}
		if(input.toLowerCase().contains("z") && originalBase<36) {
			return 2;
		}
		return 0;
	}
	//sent back the error message
	
public static String errorMessage(int check) {
		if(check == 1) {
			return "The range of the base must be in range [2,36] ";
		}else if(check == 2) {
			return "The input doesn't match with its base input";
		}else {
			return " ";
		}
	}
//treat the input or output that has special character and also convert number to String
	public static String convertToLetter(int b) {
		if(b == 0) {return "0";}
		else if(b == 1) {return "1";}
		else if(b == 2) {return "2";}
		else if(b == 3) {return "3";}
		else if(b == 4) {return "4";}
		else if(b == 5) {return "5";}
		else if(b == 6) {return "6";}
		else if(b == 7) {return "7";}
		else if(b == 8) {return "8";}
		else if(b == 9) {return "9";}
		else if(b == 10) {return "a";}
		else if(b == 11) {return "b";}
		else if(b == 12) {return "c";}
		else if(b == 13) {return "d";}
		else if(b == 14) {return "e";}
		else if(b == 15) {return "f";}
		else if(b == 16) {return "g";}
		else if(b == 17) {return "h";}
		else if(b == 18) {return "i";}
		else if(b == 19) {return "g";}
		else if(b == 20) {return "k";}
		else if(b == 21) {return "l";}
		else if(b == 22) {return "m";}
		else if(b == 23) {return "n";}
		else if(b == 24) {return "o";}
		else if(b == 25) {return "p";}
		else if(b == 26) {return "q";}
		else if(b == 27) {return "r";}
		else if(b == 28) {return "s";}
		else if(b == 29) {return "t";}
		else if(b == 30) {return "u";}
		else if(b == 31) {return "v";}
		else if(b == 32) {return "w";}
		else if(b == 33) {return "x";}
		else if(b == 34) {return "y";}
		else if(b == 35) {return "z";}
		else {return "*";}
	}
	//connect two part if the input is not a integer
	public static String connect(String IntegerPart,String fractionalPart) {
		return IntegerPart + "." + fractionalPart;
	}
}
