package telran.multithreading;

import java.util.ArrayList;

public class PrinterPortionsApp {

	private static final int N_PRINTERS = 4;
	private static final int N_PORTIONS = 5;
	private static final int N_NUMBERS = 20;

	public static void main(String[] args) throws InterruptedException {
	
		if (N_NUMBERS % N_PORTIONS != 0) {
			System.out.println("Wrong parametrs (numbers % portions must be 0)");
		} else {

			ArrayList<PrinterPortions> printers = new ArrayList<>();
			for (int i = 0; i < N_PRINTERS; i++) {
				printers.add(new PrinterPortions(i + 1, N_PORTIONS, N_NUMBERS, printers));
				printers.get(i).start();
			}
			printers.get(0).interrupt();
		}

	}

}
