package network_term_project;

// ���� Ŭ����
public class Drink {
	private int number;

	// �����ڷ� ������ ���� �ʱ�ȭ ��
	public Drink(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void MinusNumber(int number, int minus) {
		this.number = number - minus;
	}

	public void setNumber(int number, int how) {
		this.number = number - how;
	}

}

// ��
class Water_class extends Drink {
	private int water;
	private int number;
	
	public Water_class(int number, int water) {
		super(number);
		this.water = water;
		this.number = number;
	}

	public int getWater() {
		return water;
	}

	public void setWater(int water) {
		this.water = water;
	}
	public int getWaterPrice() {
		return number;
	}
}

// Ŀ��
class Coffee_class extends Drink {
	private int coffee;

	public Coffee_class(int number, int coffee) {
		super(number);
		this.coffee = coffee;
	}

	public int getCoffee() {
		return coffee;
	}

	public void setCoffee(int coffee) {
		this.coffee = coffee;
	}
}

// �̿�����
class Ion_Beverage_class extends Drink {
	private int ion_beverage;

	public Ion_Beverage_class(int number, int ion_beverage) {
		super(number);
		this.ion_beverage = ion_beverage;
	}

	public int getIon_beverage() {
		return ion_beverage;
	}

	public void setIon_beverage(int ion_beverage) {
		this.ion_beverage = ion_beverage;
	}
}

// ���Ŀ��
class High_Quality_Coffee_class extends Drink {
	private int high_quality_coffee;

	public High_Quality_Coffee_class(int number, int High_Coffee) {
		super(number);
		this.high_quality_coffee = High_Coffee;
	}

	public int getHigh_quality_coffee() {
		return high_quality_coffee;
	}

	public void setHigh_quality_coffee(int high_quality_coffee) {
		this.high_quality_coffee = high_quality_coffee;
	}
}

// ź������
class Soda_class extends Drink {
	private int soda;

	public Soda_class(int number, int soda) {
		super(number);
		this.soda = soda;
	}

	public int getSoda() {
		return soda;
	}

	public void setSoda(int soda) {
		this.soda = soda;
	}
}
