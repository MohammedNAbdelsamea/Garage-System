package Garage;

import java.util.Scanner;

public class Screen {
	static void all() {

		Scanner cin = new Scanner(System.in);
		System.out.println("Hello Garage owner.");
		System.out.println("Select your selection slot algorithm");
		System.out.println("1-first in first served  2-most fit");
		int x = cin.nextInt();
		if (x == 1)
			ParkIn.isFirstConf = true;
		else
			ParkIn.isFirstConf = false;
		System.out.println("Enter the numbers of the cars");
		int size = cin.nextInt();
		ParkIn.setSize(size);

		for (int i = 0; i < ParkIn.slots.length; i++) {
			System.out.println("Enter your slot dimantion width-depth");
			double w = cin.nextDouble();
			double d = cin.nextDouble();
			try {
				ParkIn.setDimantion(w, d, i);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				i--;
				System.out.println(e);
			}
		}
		int val;
		while (true) {
			System.out.println("if any car arrive press 1 ");
			System.out.println("if you want to display the available slots press 2");
			System.out.println("if you want to display dimantions of slots press 3");
			System.out.println("if you want to departure press 4");
			System.out.println("if you want to get total income press 5");
			System.out.println("if you want to get total number of vehicles press 6");
			System.out.println("if you need to exit the system press any other number");
			val = cin.nextInt();
			if (val == 1) {
				System.out.println("Enter your car detils carWidth - carDepth - modelName - modelYear - ID");
				boolean isRight = true;
				double cw = 0, cd = 0;
				while (isRight) {
					cw = cin.nextDouble();
					cd = cin.nextDouble();
					isRight = false;
					try {
						if (cw <= 0 || cd <= 0)
							throw new Exception("Wrong dimantions!");
					} catch (Exception e) {
						isRight = true;
						System.out.println(e);
					}
				}
				String modelName = cin.next();
				String modelYear = cin.next();

				int id = cin.nextInt();
				try {
					ParkIn.park(cw, cd, modelYear, id,modelName);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
			} else if (val == 2) {
				ParkIn.DisplayAvliSlots();
			} else if (val == 3)
				ParkIn.PrintTest();
			else if (val == 4) {
				System.out.println("Enter your slot ID:\n");
				int id = cin.nextInt();
				ParkOut.parkOut(--id);
				
			}
			else if (val == 5) {
				System.out.println(FeezCalculate.totalIncome);
			}
			else if(val ==6 ){
				System.out.println(Vehicle.totalNumberOfVehicle);
			}
			else
				break;
		}
	}
}
