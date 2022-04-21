package doAnCK;

import java.text.DecimalFormat;

public class PentHouse extends Apartment implements Pay{
	

	public PentHouse(String apartID, double apartArea, boolean hasBanCong, int floor) {
		super(apartID, apartArea, hasBanCong, floor);
		// TODO Auto-generated constructor stub
		type = "pentHouse";
		price = 5;
		sold = "no";
	}
	
	@Override
	public String[] payment() {
		DecimalFormat df = new DecimalFormat("#.##");
		int has;
		double fl = 0;
		if (hasBanCong)
			has = 1;
		else
			has = 0;

		if (floor >= 30)
			fl = 0.3;
		else
			fl = 0;

		return new String[] { (df.format(price + 0.2 * has + fl)), String.valueOf(has), String.valueOf(fl) };
	}
	
}
