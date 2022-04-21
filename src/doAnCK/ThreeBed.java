package doAnCK;

import java.text.DecimalFormat;

public class ThreeBed extends Apartment implements Pay{
	

	public ThreeBed(String apartID, double apartArea, boolean hasBanCong, int floor) {
		super(apartID, apartArea, hasBanCong, floor);
		// TODO Auto-generated constructor stub
		type = "threeBed";
		price = 2.5;
		sold = "no";
	}


	@Override
	public String[] payment() {
		DecimalFormat df = new DecimalFormat("#.##");
		int has;
		double fl;
		if (hasBanCong)
			has=1;
		else
			has=0;
		
		if (floor<3)
			fl=0.25;
		else if (floor>=3 && floor <5)
			fl=0.2;
		else if (floor >= 5 && floor<8)
			fl=0.15;
		
		else if (floor>20 && floor<=25)
			fl=0.2;
		else if (floor>25 && floor <30)
			fl=0.4;
		else
			fl=0;
		
		return new String[] {(df.format(price+0.2*has+fl)),String.valueOf(has),String.valueOf(fl)};
	}
}
