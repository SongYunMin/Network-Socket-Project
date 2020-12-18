package network_term_project;


/*
 *		Money의 입출력을 위한 Class 
 */

public class Money_Input {
	private int Money;
	private int Total_Money;
	
	public Money_Input(int Money) {
		this.Money = Money;
	}

	public int getMoney() {
		return Money;
	}

	public void setMoney(int money, int plus) {
		Money = money + plus;
	}
	
	public void MinusMoney(int money, int minus) {
		Money = money - minus;
	}
}
