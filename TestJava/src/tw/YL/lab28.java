package tw.YL;

public class lab28 {

	public static void main(String[] args) {
		lab281 obj = new lab282();		// 父類型變數 指向 子類物件
	    obj.m1();			// 應該印出lab282:m1()

	}

}

//	Override覆寫的進階用法 - 回傳型別的協變

class lab281{
	protected Number m1() {
		System.out.println("lab281:m1()");
		return null;
	}
	void m2() {}
}

class lab282 extends lab281{
	public Byte m1() {
		System.out.println("lab282:m1()");
		super.m2();
		return null;
	}
}


//lab281.m1() 回傳的是 Number
//lab282.m1() 回傳的是 Byte
//而 Byte 是 Number 的子類別，這種情況是允許的，稱為 協變回傳型別
//回傳型別相容（可協變）Number → Byte
//
//
//Java 中覆寫方法時，子類別的可見範圍可以擴大，但不能縮小。
//所以 protected → public 是可以的，這代表子類可以讓這個方法「對更多人開放」。

