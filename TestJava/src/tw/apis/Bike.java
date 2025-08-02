package tw.apis;

import java.io.Serializable;

public class Bike implements Serializable{
	protected double speed;
	
	public Bike upSpeed() {
		speed = speed < 1 ? 1 : speed * 1.4;
		return this;
	}
	
	public void downSpeed() {
		speed = speed < 1 ? 0 : speed * 0.6;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	@Override
	public String toString() {
		return "Speed:" + speed;
	}
	
	
	
}

//	Bike是類別，speed是屬性，upSpeed() 是方法，可以用 new Bike() 建立一個「物件」








