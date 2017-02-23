// Matthew Miller - 33.33% of wor
// Hunter Suchyj - 33.33% of work
// Matthew Matusek - 33.33% of work
package pkgMain;

import java.util.Scanner;

import org.apache.poi.ss.formula.functions.*;

public class cMain {

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Years work?");
		int YearsWork = scan.nextInt();
		
		System.out.println("Annual Return?(0-.20)");
		double AnnualReturn = scan.nextDouble();
		while(AnnualReturn > .20 || AnnualReturn < 0 )
		{
			System.out.println("That input is invalid. Please enter an annual retun between 0 and 20%");
			AnnualReturn = scan.nextDouble();
		}
		
		System.out.println("Years retired?");
		int YearsRetired = scan.nextInt();
		
		System.out.println("Payback Return?(0-.03)");
		double PaybackReturn = scan.nextDouble();
		while(PaybackReturn > .03 || PaybackReturn < 0 )
		{
			System.out.println("That input is invalid. Please enter an annual retun between 0 and 3%");
			PaybackReturn = scan.nextDouble();
		}
		
		System.out.println("Required Income?");
		double ReqIncome = scan.nextDouble();
		
		System.out.println("Monthly SSI?");
		double SSI = scan.nextDouble();
				
		double diff = ReqIncome - SSI;
		double monthly = PaybackReturn / 12;
		double n1 = YearsRetired * 12;
		boolean b = false;	
	
		double presentValue = FinanceLib.pv(monthly, n1, diff, 0, b);
		
		monthly = AnnualReturn / 12; 
		n1 = YearsWork * 12;
		
		double pmt = FinanceLib.pmt(monthly, n1, 0, presentValue, b);
		System.out.println("You will have to save " + (double)Math.round(pmt * 100)/100 + " a month.");
	}
}
