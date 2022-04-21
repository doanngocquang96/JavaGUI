package doAnCK;

public class Apartment {
	protected String apartID;
	protected double apartArea;
	protected boolean hasBanCong;
	protected int floor;
	protected String type;
	protected double price;
	protected String sold;
	
	
	@Override
	public String toString() {
		return "Apartment [apartID=" + apartID + ", apartArea=" + apartArea + ", hasBanCong=" + hasBanCong + ", floor="
				+ floor + ", type=" + type + ", price=" + price + ", sold=" + sold + "]";
	}


	public Apartment(String apartID, double apartArea, boolean hasBanCong, int floor, String type, double price, String sold) {
		this.apartID = apartID;
		this.apartArea = apartArea;
		this.hasBanCong = hasBanCong;
		this.floor = floor;
		this.type = type;
		this.price = price;
		this.sold = sold;
	}


	public Apartment(String apartID, double apartArea, boolean hasBanCong, int floor) {
		this.apartID = apartID;
		this.apartArea = apartArea;
		this.hasBanCong = hasBanCong;
		this.floor = floor;
	}

	
}
