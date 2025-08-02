package tw.YL;

import tw.apis.Bike;
import tw.apis.Scooter;

public class lab18 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		s1.changeGear(4);
		s1.upSpeed(); s1.upSpeed();
		s1.upSpeed(); s1.downSpeed();
		System.out.println(s1.getSpeed());
		
		Bike b1 = new Bike();
		b1.upSpeed(); b1.upSpeed();
		b1.upSpeed(); b1.downSpeed();
		System.out.println(b1.getSpeed());
	}
	

}
