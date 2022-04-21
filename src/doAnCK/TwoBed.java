package doAnCK;

import java.text.DecimalFormat;

public class TwoBed extends Apartment implements Pay {

	public TwoBed(String apartID, double apartArea, boolean hasBanCong, int floor) {
		super(apartID, apartArea, hasBanCong, floor);
		// TODO Auto-generated constructor stub
		type = "twoBed";
		price = 1.5;
		sold = "no";
	}

	@Override
	public String[] payment() {
		DecimalFormat df = new DecimalFormat("#.##");
		int has;
		double fl;
		if (hasBanCong)
			has = 1;
		else
			has = 0;

		if (floor < 3)
			fl = 0.1;
		else if (floor >= 3 && floor < 5)
			fl = 0.075;
		else if (floor < 8)
			fl = 0.5;
		else if (floor > 20 && floor <= 25)
			fl = 0.1;
		else if (floor > 25 && floor < 30)
			fl = 0.15;
		else
			fl = 0;

		return new String[] { (df.format(price + 0.1 * has + fl)), String.valueOf(has), String.valueOf(fl) };
	}

}
