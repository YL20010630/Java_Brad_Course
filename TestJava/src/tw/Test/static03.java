package tw.Test;


public class static03 {
	
	/*
		練習題：設計一個簡單的計算機 Calculator
		需求：
		
		建立一個類別 Calculator，裡面有：
		
		一個 static 方法 add(int a, int b)，回傳兩數相加結果
		
		一個 static 方法 subtract(int a, int b)，回傳兩數相減結果
		
		一個非 static 方法 multiply(int a, int b)，回傳兩數相乘結果
		
		一個非 static 方法 divide(int a, int b)，回傳兩數相除結果（int 除法）
		
		在 main 方法裡：
		
		直接呼叫 add 和 subtract，印出結果
		
		建立 Calculator 物件，呼叫 multiply 和 divide，印出結果


	 */

	public static void main(String[] args) {
		
//		Caclulator.add(){		// 錯誤，呼叫方法要帶參數
//		Calculator.add(10, 3){
//			System.out.println("a + b = " +add);
//		}
//		Caculator.subtract(10, 3)("a - b = " +subtract);
//		
//		Calculator obj1 = new Calculator();
//		obj1.multiply(10, 3);
//		obj1.divide(10, 3);
		
        // 直接呼叫 static 方法
        int sum = Calculator.add(10, 5);
        int diff = Calculator.subtract(10, 5);
        System.out.println("10 + 5 = " + sum);
        System.out.println("10 - 5 = " + diff);
        
        // 建立物件，呼叫非 static 方法
        Calculator calc = new Calculator();
        int product = calc.multiply(10, 5);
        int quotient = calc.divide(10, 5);
        System.out.println("10 * 5 = " + product);
        System.out.println("10 / 5 = " + quotient);
		

	}


//	*若建立的類別包含在初始類別public class static03 {}s裡就要static
	static class Calculator {
		static int add(int a, int b) {
			return a + b;
		}
		static int subtract(int a, int b) {
			return a - b;
		}
		int multiply(int a, int b) {
			return a * b;
		}
		int divide(int a, int b) {
			return a / b;
		}
	}

}
