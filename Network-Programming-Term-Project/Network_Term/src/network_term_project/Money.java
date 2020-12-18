package network_term_project;

// Money Class
public class Money {
		protected int count;
		public Money(int count){this.count = count;}
		public int getCount() {return count;}
		
		public void PlusCount(int count, int plus){
			this.count = count + plus;
		}
}

// 10원
class Money10 extends Money{
	private int money_10;

	public Money10(int money_10, int count) {
		super(count);
		this.money_10 = money_10;
	}
	// Getter Setter
	public int getMoney_10() {
		return money_10;
	}
	public void setMoney_10(int money_10, int How) {
		this.money_10 = money_10 + How;
	}
	
	public void minusMoney_10(int money_10, int How) {
		this.money_10 = money_10 - How;
	}

	// count 하나씩 감소
	public void delete(){ count--; }
}


// 50원
class Money50 extends Money{
	private int money_50;

	public Money50(int money_50, int count) {
		super(count);
		this.money_50 = money_50;
	}
	// Getter Setter
	public int getMoney_50() {
		return money_50;
	}
	public void setMoney_50(int money_50, int How) {
		this.money_50 = money_50 + How;
	}
	
	public void minusMoney_50(int money_50, int How) {
		this.money_50 = money_50 - How;
	}

	// count 하나씩 감소
	public void delete(){ count--; }
}

// 100원
class Money100 extends Money{
	private int money_100;
	
	public Money100(int money_100, int count) {
		super(count);
		this.money_100 = money_100;
	}
	// Getter Setter
	public int getMoney_100() {
		return money_100;
	}
	public void setMoney_100(int money_100,int How) {
		this.money_100 = money_100 + How;
	}
	
	public void minusMoney_100(int money_100, int How) {
		this.money_100 = money_100- How;
	}

	// count 하나씩 감소
	public void delete(){	count--; }
}

// 500원
class Money500 extends Money{
	private int money_500;

	public Money500(int money_500, int count) {
		super(count);
		this.money_500 = money_500;
	}
	// Getter Setter
	public int getMoney_500() {
		return money_500;
	}
	public void setMoney_500(int money_500, int How) {
		this.money_500 = money_500 + How;
	}
	public void minusMoney_500(int money_500, int How) {
		this.money_500 = money_500 - How;
	}
	
	// count 하나씩 감소
	public void delete(){ count--; }
}

// 1000원
class Money1000 extends Money{
	private int money_1000;

	public Money1000(int money_1000, int count) {
		super(count);
		this.money_1000 = money_1000;
	}
	// Getter Setter
	public int getMoney_1000() {
		return money_1000;
	}
	public void setMoney_1000(int money_1000, int How) {
		this.money_1000 = money_1000 + How;
	}
	
	public void minusMoney_1000(int money_1000, int How) {
		this.money_1000 = money_1000 - How;
	}
	
	public void delete(){ count--; }
}