package tw.YL;

import java.security.GeneralSecurityException;

public class lab43 {

	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(3);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("OK");

	}

}


class Bird {
	int leg;
	void setLeg(int n)throws GeneralSecurityException {
//		這支方法內如果發生 GeneralSecurityException，請呼叫者自己處理。
//		throws 不處理，把責任往外丟

		if(n>=0 && n<=2) {
			leg = n;
		}else {
//			throw new RuntimeException();
//			在這裡立刻丟出一個執行期錯誤，強制中斷後面程式
			
			throw new GeneralSecurityException();
		}
	}
}
