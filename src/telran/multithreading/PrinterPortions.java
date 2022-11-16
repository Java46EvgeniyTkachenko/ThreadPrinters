package telran.multithreading;

import java.util.ArrayList;

public class PrinterPortions extends Thread {

	private int number;
	private int portion;
	private int nNumbers;
	private ArrayList<PrinterPortions> printers;

	public PrinterPortions(int number, int portion, int nNumbers, ArrayList<PrinterPortions> printers) {

		this.number = number;
		this.portion = portion;
		this.nNumbers = nNumbers;
		this.printers = printers;
	}

	@Override
	public void run() {
		int stop = nNumbers;
		while (true) {

			try {
				sleep(1);
			} catch (InterruptedException e) {
				System.out.println(Integer.toString(number).repeat(portion));
				stop = stop - portion;
				if (number < printers.size()) {
					printers.get(number).interrupt();

				} else {
					printers.get(0).interrupt();
				}
				if (stop == 0) {

					break;
				}
			}

		}
	}
}
