package network_term_project;

public class Gross_Sales {
	private  int Day_Sales;		
	
	// 생성자
	public Gross_Sales() {
		Day_Sales = 0;
	};		
	
	// 일 매출
	public int getDay_Sales() {
		return Day_Sales;
	}
	public void setDay_Sales(int day_Sales) {
		Day_Sales = day_Sales;
	}
	public void Plus_Day_Sales(int day_Sales,int plus) {
		this.Day_Sales = day_Sales + plus;
	}
}