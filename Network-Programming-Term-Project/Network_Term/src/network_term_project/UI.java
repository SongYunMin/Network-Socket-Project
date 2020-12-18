package network_term_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class UI extends JFrame {
	private JPanel Money_text;
	public static JTextField InputMoney;
	public static JTextField WaterNum;
	public static JTextField CoffeeNum;
	public static JTextField HighCoffeeNum;
	public static JTextField SportNum;
	public static JTextField SodaNum;
	public static JButton Water;
	public static JButton Coffee;
	public static JButton SportDrink;
	public static JButton High_Coffee;
	public static JButton Soda;
	public static Gross_Sales GS = new Gross_Sales();
	public static Gross_UI Gross = new Gross_UI();
	public static int count = 0;
	public static Money_Input money = new Money_Input(0);
	// Drink 초기화
	public static Water_class water = new Water_class(3, 450);
	public static Coffee_class coffee = new Coffee_class(3, 500);
	public static Ion_Beverage_class ion = new Ion_Beverage_class(3, 550);
	public static High_Quality_Coffee_class high_coffee = new High_Quality_Coffee_class(3, 700);
	public static Soda_class soda = new Soda_class(3, 750);
	private JTextField Money10_Num;
	private JTextField Money50_Num;
	private JTextField Money100_Num;
	private JTextField Money500_Num;
	private JTextField Money1000_Num;
	public static Socket socket = null;

	public UI() {
		/*
		 * Class init Area
		 */
		if (count == 0) {
			Main.ID_PW.setID_Start("manager");
			Main.ID_PW.setPW_Start("manager@1234");
			count++;
		}
		// Money 초기화
		Money10 money10 = new Money10(10, 5);
		Money50 money50 = new Money50(50, 5);
		Money100 money100 = new Money100(100, 5);
		Money500 money500 = new Money500(500, 5);
		Money1000 money1000 = new Money1000(1000, 5);

		// 현재 총액을 알려줄 class
		money.setMoney(0, 0);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 686);
		Money_text = new JPanel();
		Money_text.setBackground(new Color(204, 204, 255));
		Money_text.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Money_text);
		Money_text.setLayout(null);

		JLabel Main_Text = new JLabel("\uC74C\uB8CC \uC790\uD310\uAE30");
		Main_Text.setHorizontalAlignment(SwingConstants.CENTER);
		Main_Text.setForeground(new Color(0, 0, 0));
		Main_Text.setFont(new Font("배달의민족 주아", Font.PLAIN, 47));
		Main_Text.setBackground(new Color(0, 0, 0));
		Main_Text.setBounds(12, 18, 304, 57);
		Money_text.add(Main_Text);

		/*
		 * 음료들의 Image
		 */

		ImageIcon water_image = new ImageIcon(
				"C:\\Users\\thd93\\git\\Network-Programming-Term-Project\\Network_Term\\src\\java_term_project\\image\\water.png");
		ImageIcon coffee_image = new ImageIcon(
				"C:\\Users\\thd93\\git\\Network-Programming-Term-Project\\Network_Term\\src\\java_term_project\\image\\coffee.jpg");
		ImageIcon sport_image = new ImageIcon(
				"C:\\Users\\thd93\\git\\Network-Programming-Term-Project\\Network_Term\\src\\java_term_project\\image\\sportdrink.png");
		ImageIcon highcoffee_image = new ImageIcon(
				"C:\\Users\\thd93\\git\\Network-Programming-Term-Project\\Network_Term\\src\\java_term_project\\image\\highcoffee.png");
		ImageIcon soda_image = new ImageIcon(
				"C:\\Users\\thd93\\git\\Network-Programming-Term-Project\\Network_Term\\src\\java_term_project\\image\\soda.jpg");

		JLabel Water_Label = new JLabel(water_image);
		Water_Label.setForeground(Color.BLACK);
		Water_Label.setFont(new Font("순천향체", Font.PLAIN, 60));
		Water_Label.setBackground(Color.BLACK);
		Water_Label.setBounds(94, 93, 97, 187);
		Money_text.add(Water_Label);

		JLabel Coffee_Label = new JLabel(coffee_image);
		Coffee_Label.setForeground(Color.BLACK);
		Coffee_Label.setFont(new Font("순천향체", Font.PLAIN, 60));
		Coffee_Label.setBackground(Color.BLACK);
		Coffee_Label.setBounds(236, 104, 108, 176);
		Money_text.add(Coffee_Label);

		JLabel Sport_Label = new JLabel(sport_image);
		Sport_Label.setForeground(Color.BLACK);
		Sport_Label.setFont(new Font("순천향체", Font.PLAIN, 60));
		Sport_Label.setBackground(Color.BLACK);
		Sport_Label.setBounds(390, 104, 97, 176);
		Money_text.add(Sport_Label);

		JLabel HighCoffee_Label = new JLabel(highcoffee_image);
		HighCoffee_Label.setForeground(Color.BLACK);
		HighCoffee_Label.setFont(new Font("순천향체", Font.PLAIN, 60));
		HighCoffee_Label.setBackground(Color.BLACK);
		HighCoffee_Label.setBounds(550, 116, 97, 164);
		Money_text.add(HighCoffee_Label);

		JLabel Soda_Label = new JLabel(soda_image);
		Soda_Label.setForeground(Color.BLACK);
		Soda_Label.setFont(new Font("순천향체", Font.PLAIN, 60));
		Soda_Label.setBackground(Color.BLACK);
		Soda_Label.setBounds(706, 116, 97, 164);
		Money_text.add(Soda_Label);

		// 관리자 메뉴 버튼
		JButton Admin_Menu = new JButton("\uAD00\uB9AC\uC790 \uBA54\uB274");
		Admin_Menu.setBackground(new Color(135, 206, 250));
		Admin_Menu.setForeground(new Color(47, 79, 79));
		Admin_Menu.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
		Admin_Menu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login Lg = new Login();
				Lg.setVisible(true);
				/*
				 * Manager ma = new Manager(); ma.setVisible(true);
				 */
			}
		});
		Admin_Menu.setBounds(661, 20, 117, 48);
		Money_text.add(Admin_Menu);

		/*
		 * Button Area 음료의 버튼 클릭시 이벤트 발생하는 공간
		 */

		// Water 버튼
		Water = new JButton("물");
		Water.addActionListener(new ActionListener() {
			// 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				// 재고 Check
				if (water.getNumber() == 0) {
					WaterNum.setText("품절");
					JOptionPane.showMessageDialog(Money_text, "재고가 부족합니다");
					return;
				}
				// 잔액이 물의 금액보다 같거나 많다면 분기 실행
				if (money.getMoney() >= 450) {
					// 재고 한개 Down
					DataTransfer dt = new DataTransfer();
					try {
						String buf;
						dt.StatusTransfer("update");
						buf = dt.dataTransfer("UPDATE vending set water_num = water_num-1 "
								+ "where vending_index=");
						dt.StatusTransfer("money");
						buf = dt.dataTransfer("UPDATE vending set money = money + 450 "
								+ "where vending_index=");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					water.MinusNumber(water.getNumber(), 1);
					WaterNum.setText("수량 : " + water.getNumber());
					InputMoney.setText(String.valueOf(money.getMoney() - 450));
					money.MinusMoney(money.getMoney(), 450);
					JOptionPane.showMessageDialog(Money_text, "물 을 구입하였습니다.");
					GS.Plus_Day_Sales(GS.getDay_Sales(), water.getWater());
				}
				// 잔액 부족
				else {
					JOptionPane.showMessageDialog(Money_text, "잔액이 부족합니다.");
				}
			}
		});

		Water.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Water.setForeground(new Color(0, 0, 0));
		Water.setBackground(new Color(255, 228, 225));
		Water.setBounds(105, 288, 81, 48);
		Money_text.add(Water);

		// Coffee 버튼
		Coffee = new JButton("\uCEE4\uD53C");
		Coffee.addActionListener(new ActionListener() {
			// 클릭 이벤트
			public void actionPerformed(ActionEvent e) {
				// 재고 Check
				if (coffee.getNumber() == 0) {
					WaterNum.setText("품절");
					JOptionPane.showMessageDialog(Money_text, "재고가 부족합니다");
					return;
				}
				// 잔액이 물의 금액보다 같거나 많다면 분기 실행
				if (money.getMoney() >= 500) {
					// 재고 한개 Down
					DataTransfer dt = new DataTransfer();
					try {
						String buf;
						dt.StatusTransfer("update");
						buf = dt.dataTransfer("UPDATE vending set coffee_num = coffee_num-1 where vending_index=");
						dt.StatusTransfer("money");
						buf = dt.dataTransfer("UPDATE vending set money = money + 500 "
								+ "where vending_index=");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					coffee.MinusNumber(coffee.getNumber(), 1);
					CoffeeNum.setText("수량 : " + coffee.getNumber());
					InputMoney.setText(String.valueOf(money.getMoney() - 500));
					money.MinusMoney(money.getMoney(), 500);
					JOptionPane.showMessageDialog(Money_text, "커피 을 구입하였습니다.");
					GS.Plus_Day_Sales(GS.getDay_Sales(), coffee.getCoffee());
				}
				// 잔액 부족
				else {
					JOptionPane.showMessageDialog(Money_text, "잔액이 부족합니다.");
				}
			}
		});

		Coffee.setBackground(new Color(255, 245, 238));
		Coffee.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Coffee.setBounds(247, 288, 81, 48);
		Money_text.add(Coffee);

		// SportDrink 버튼
		SportDrink = new JButton("\uC774\uC628\uC74C\uB8CC");
		SportDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 재고 Check
				if (ion.getNumber() == 0) {
					SportNum.setText("품절");
					JOptionPane.showMessageDialog(Money_text, "재고가 부족합니다");
					return;
				}
				if (money.getMoney() >= 550) {
					// 재고 한개 Down
					// 재고 한개 Down
					DataTransfer dt = new DataTransfer();
					try {
						String buf;
						dt.StatusTransfer("update");
						buf = dt.dataTransfer("UPDATE vending set sport_num = sport_num-1 where vending_index=");
						dt.StatusTransfer("money");
						buf = dt.dataTransfer("UPDATE vending set money = money + 550 "
								+ "where vending_index=");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ion.MinusNumber(ion.getNumber(), 1);
					SportNum.setText("수량 : " + ion.getNumber());
					InputMoney.setText(String.valueOf(money.getMoney() - 550));
					money.MinusMoney(money.getMoney(), 550);
					JOptionPane.showMessageDialog(Money_text, "이온음료를 구입하였습니다.");
					GS.Plus_Day_Sales(GS.getDay_Sales(), ion.getIon_beverage());
				}
				// 잔액 부족
				else {
					JOptionPane.showMessageDialog(Money_text, "잔액이 부족합니다.");
				}
			}
		});
		SportDrink.setBackground(new Color(250, 235, 215));
		SportDrink.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		SportDrink.setBounds(390, 288, 97, 48);
		Money_text.add(SportDrink);

		// High_Coffee 버튼
		High_Coffee = new JButton("\uACE0\uAE09\uCEE4\uD53C");
		High_Coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 재고 Check
				if (high_coffee.getNumber() == 0) {
					HighCoffeeNum.setText("품절");
					JOptionPane.showMessageDialog(Money_text, "재고가 부족합니다");
					return;
				}
				if (money.getMoney() >= 700) {
					// 재고 한개 Down
					// 재고 한개 Down
					DataTransfer dt = new DataTransfer();
					try {
						String buf;
						dt.StatusTransfer("update");
						buf = dt.dataTransfer("UPDATE vending set highcoffee_num = highcoffee_num-1 "
								+ "where vending_index=");
						dt.StatusTransfer("money");
						buf = dt.dataTransfer("UPDATE vending set money = money + 700 "
								+ "where vending_index=");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					high_coffee.MinusNumber(high_coffee.getNumber(), 1);
					HighCoffeeNum.setText("수량 : " + high_coffee.getNumber());
					InputMoney.setText(String.valueOf(money.getMoney() - 700));
					money.MinusMoney(money.getMoney(), 700);
					JOptionPane.showMessageDialog(Money_text, "고급커피를 구입하였습니다.");
					GS.Plus_Day_Sales(GS.getDay_Sales(), high_coffee.getHigh_quality_coffee());
				}
				// 잔액 부족
				else {
					JOptionPane.showMessageDialog(Money_text, "잔액이 부족합니다.");
				}
			}
		});
		High_Coffee.setBackground(new Color(240, 255, 255));
		High_Coffee.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		High_Coffee.setBounds(550, 288, 97, 48);
		Money_text.add(High_Coffee);

		// 탄산음료 버튼
		Soda = new JButton("\uD0C4\uC0B0\uC74C\uB8CC");
		Soda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 재고 Check
				if (soda.getNumber() == 0) {
					SodaNum.setText("품절");
					JOptionPane.showMessageDialog(Money_text, "재고가 부족합니다");
					return;
				}
				if (money.getMoney() >= 750) {
					// 재고 한개 Down
					// 재고 한개 Down
					DataTransfer dt = new DataTransfer();
					try {
						String buf;
						dt.StatusTransfer("update");
						buf = dt.dataTransfer("UPDATE vending set soda_num = soda_num-1 where "
								+ "vending_index=");
						dt.StatusTransfer("money");
						buf = dt.dataTransfer("UPDATE vending set money = money + 750 "
								+ "where vending_index=");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					soda.MinusNumber(soda.getNumber(), 1);
					SodaNum.setText("수량 : " + soda.getNumber());
					InputMoney.setText(String.valueOf(money.getMoney() - 750));
					money.MinusMoney(money.getMoney(), 750);
					JOptionPane.showMessageDialog(Money_text, "탄산음료를 구입하였습니다.");
					GS.Plus_Day_Sales(GS.getDay_Sales(), soda.getSoda());
				}
				// 잔액 부족
				else {
					JOptionPane.showMessageDialog(Money_text, "잔액이 부족합니다.");
				}
			}
		});
		Soda.setBackground(new Color(230, 230, 250));
		Soda.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Soda.setBounds(706, 287, 97, 48);
		Money_text.add(Soda);

		/*
		 * // 종료 버튼
		 */

		// 종료 버튼
		JButton Exit = new JButton("\uC885\uB8CC");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataTransfer dt = new DataTransfer();
				// 서버 종료
				dt.serverDisconnect();
				System.exit(0);
			}
		});
		Exit.setForeground(Color.BLACK);
		Exit.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Exit.setBackground(new Color(255, 228, 225));
		Exit.setBounds(790, 20, 81, 48);
		Money_text.add(Exit);

		/*
		 * 투입금액 확인 TextField
		 */

		// 투입금액 확인 Label
		JLabel Input_Amount = new JLabel("\uD22C\uC785\uAE08\uC561 : ");
		Input_Amount.setFont(new Font("배달의민족 주아", Font.PLAIN, 32));
		Input_Amount.setBounds(12, 427, 165, 75);
		Money_text.add(Input_Amount);

		// 투입금액 확인
		InputMoney = new JTextField();
		InputMoney.setFont(new Font("배달의민족 주아", Font.PLAIN, 32));
		InputMoney.setText(String.valueOf(money.getMoney()) + " 원");
		InputMoney.setBounds(157, 427, 178, 75);
		Money_text.add(InputMoney);
		InputMoney.setColumns(10);

		/*
		 * 재고수량 확인 TextField
		 */

		// 물 재고 수량 확인
		WaterNum = new JTextField();
		WaterNum.setText("품절");
		WaterNum.setText("수량 : " + water.getNumber());
		WaterNum.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		WaterNum.setColumns(10);
		WaterNum.setBounds(105, 347, 81, 21);
		Money_text.add(WaterNum);

		// 커피 재고 수량 확인
		CoffeeNum = new JTextField();
		CoffeeNum.setText("수량 : " + coffee.getNumber());
		CoffeeNum.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		CoffeeNum.setColumns(10);
		CoffeeNum.setBounds(247, 348, 81, 21);
		Money_text.add(CoffeeNum);

		// 이온음료 재고 수량 확인
		SportNum = new JTextField();
		SportNum.setText("수량 : " + ion.getNumber());
		SportNum.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		SportNum.setColumns(10);
		SportNum.setBounds(400, 348, 81, 21);
		Money_text.add(SportNum);

		// 고급 커피 재고 수량 확인
		HighCoffeeNum = new JTextField();
		HighCoffeeNum.setText("수량 : " + high_coffee.getNumber());
		HighCoffeeNum.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		HighCoffeeNum.setColumns(10);
		HighCoffeeNum.setBounds(560, 348, 81, 21);
		Money_text.add(HighCoffeeNum);

		// 탄산음료 재고 수량 확인
		SodaNum = new JTextField();
		SodaNum.setText("수량 : " + soda.getNumber());
		SodaNum.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		SodaNum.setColumns(10);
		SodaNum.setBounds(716, 347, 81, 21);
		Money_text.add(SodaNum);

		/*
		 * Money 입력 버튼
		 */

		// 10원짜리 버튼
		JButton M10_BT = new JButton("10\uC6D0");
		M10_BT.setBounds(699, 434, 67, 21);
		Money_text.add(M10_BT);
		M10_BT.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		M10_BT.setBackground(new Color(211, 211, 211));
		M10_BT.addActionListener(new ActionListener() {
			// 10원 버튼을 누르면 현재금액 증가
			public void actionPerformed(ActionEvent e) {
				if (money10.getCount() != 0) {
					if (money.getMoney() <= 4990) {
						money.setMoney(money.getMoney(), money10.getMoney_10());
						// money10.delete();
						InputMoney.setText(String.valueOf(money.getMoney()) + " 원");
						// Money10_Num.setText(String.valueOf(money10.getCount()) + " 개");
					} else {

					}
				} else {
					JOptionPane.showMessageDialog(Money_text, "10원 화폐가 없습니다.");

				}
			}
		});

		// 50원짜리 버튼
		JButton M50_BT = new JButton("50\uC6D0");
		M50_BT.setBounds(778, 434, 67, 21);
		Money_text.add(M50_BT);
		M50_BT.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		M50_BT.setBackground(new Color(211, 211, 211));
		M50_BT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money50.getCount() != 0) {
					if (money.getMoney() <= 4950) {
						money.setMoney(money.getMoney(), money50.getMoney_50());
						// money50.delete();
						InputMoney.setText(String.valueOf(money.getMoney()) + " 원");
						// Money50_Num.setText(String.valueOf(money50.getCount()) + " 개");
					} else {
						JOptionPane.showMessageDialog(Money_text, "5000원 이상 입력 받을 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(Money_text, "50원 화폐가 없습니다.");
				}
			}
		});

		// 100원짜리 버튼
		JButton M100_BT = new JButton("100\uC6D0");
		M100_BT.setBounds(657, 465, 67, 21);
		Money_text.add(M100_BT);
		M100_BT.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		M100_BT.setBackground(new Color(211, 211, 211));
		M100_BT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money100.getCount() != 0) {
					if (money.getMoney() <= 4900) {
						money.setMoney(money.getMoney(), money100.getMoney_100());
						// money100.delete();
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						// Money100_Num.setText(String.valueOf(money100.getCount()) + " 개");
					} else {
						JOptionPane.showMessageDialog(Money_text, "5000 원 이상 입력 받을 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(Money_text, "100원 화폐가 없습니다.");
				}
			}
		});

		// 500원짜리 버튼
		JButton M500_BT = new JButton("500\uC6D0");
		M500_BT.setBounds(736, 465, 67, 21);
		Money_text.add(M500_BT);
		M500_BT.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		M500_BT.setBackground(new Color(211, 211, 211));
		M500_BT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money500.getCount() != 0) {
					if (money.getMoney() <= 4500) {
						money.setMoney(money.getMoney(), money500.getMoney_500());

						// money500.delete();
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						// Money500_Num.setText(String.valueOf(money500.getCount()) + " 개");
					} else {
						JOptionPane.showMessageDialog(Money_text, "5000원 이상 입력 받을 수 없습니다.");
					}
				} else {
					JOptionPane.showMessageDialog(Money_text, "500원 화폐가 없습니다.");
				}
			}
		});

		// 1000원짜리 버튼
		JButton M1000_BT = new JButton("1000\uC6D0");
		M1000_BT.setBounds(815, 465, 70, 21);
		Money_text.add(M1000_BT);
		M1000_BT.setFont(new Font("배달의민족 주아", Font.PLAIN, 12));
		M1000_BT.setBackground(new Color(211, 211, 211));
		M1000_BT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (money1000.getCount() != 0) {

					if (money.getMoney() <= 2000) {
						money.setMoney(money.getMoney(), money1000.getMoney_1000());
						// money1000.delete();
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						// Money1000_Num.setText(String.valueOf(money1000.getCount()) + " 개");
					} else {
						JOptionPane.showMessageDialog(Money_text, "화폐 입력 최대단위는 3000원 입니다.");
					}
				} else {
					JOptionPane.showMessageDialog(Money_text, "1000원 화폐가 없습니다.");
				}
			}
		});

		/*
		 * // 잔돈의 갯수 표시되는 TextField
		 */

		// 10원
		Money10_Num = new JTextField();
		Money10_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Money10_Num.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Money10_Num.setColumns(10);
		Money10_Num.setBounds(485, 585, 67, 21);
		Money10_Num.setText(String.valueOf(money10.getCount()) + " 개");
		Money_text.add(Money10_Num);

		// 50원
		Money50_Num = new JTextField();
		Money50_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Money50_Num.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Money50_Num.setColumns(10);
		Money50_Num.setBounds(564, 585, 67, 21);
		Money50_Num.setText(String.valueOf(money50.getCount()) + " 개");
		Money_text.add(Money50_Num);

		// 100원
		Money100_Num = new JTextField();
		Money100_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Money100_Num.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Money100_Num.setColumns(10);
		Money100_Num.setBounds(643, 585, 67, 21);
		Money100_Num.setText(String.valueOf(money100.getCount()) + " 개");
		Money_text.add(Money100_Num);

		// 500원
		Money500_Num = new JTextField();
		Money500_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Money500_Num.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Money500_Num.setColumns(10);
		Money500_Num.setBounds(722, 585, 67, 21);
		Money500_Num.setText(String.valueOf(money500.getCount()) + " 개");
		Money_text.add(Money500_Num);

		// 1000원
		Money1000_Num = new JTextField();
		Money1000_Num.setHorizontalAlignment(SwingConstants.CENTER);
		Money1000_Num.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		Money1000_Num.setColumns(10);
		Money1000_Num.setBounds(801, 586, 70, 21);
		Money1000_Num.setText(String.valueOf(money1000.getCount()) + " 개");
		Money_text.add(Money1000_Num);

		/*
		 * 반환 버튼
		 */

		JButton ReturnButton = new JButton("\uBC18\uD658");
		ReturnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (money.getMoney() != 0) {
					// 1000원 갯수
					if (money.getMoney() >= 1000) {
						money.MinusMoney(money.getMoney(), 1000);
						InputMoney.setText(String.valueOf(money.getMoney()) + " 원");
						money1000.PlusCount(money1000.getCount(), 1);
						Money1000_Num.setText(String.valueOf(money1000.getCount()) + " 개");
					}
					// 500원 갯수
					else if (money.getMoney() >= 500) {
						money.MinusMoney(money.getMoney(), 500);
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						money500.PlusCount(money500.getCount(), 1);
						Money500_Num.setText(String.valueOf(money500.getCount()) + " 개");
					}
					// 100원 갯수
					else if (money.getMoney() >= 100) {
						money.MinusMoney(money.getMoney(), 100);
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						money100.PlusCount(money100.getCount(), 1);
						Money100_Num.setText(String.valueOf(money100.getCount()) + " 개");
					}
					// 50원 갯수
					else if (money.getMoney() >= 50) {
						money.MinusMoney(money.getMoney(), 50);
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						money50.PlusCount(money50.getCount(), 1);
						Money50_Num.setText(String.valueOf(money50.getCount()) + " 개");
					}
					// 10원 갯수
					else if (money.getMoney() >= 10) {
						money.MinusMoney(money.getMoney(), 10);
						InputMoney.setText(String.valueOf(money.getMoney()) + "원");
						money10.PlusCount(money10.getCount(), 1);
						Money10_Num.setText(String.valueOf(money10.getCount()) + " 개");
					}
				}
			}
		});
		ReturnButton.setFont(new Font("배달의민족 주아", Font.PLAIN, 15));
		ReturnButton.setBackground(new Color(250, 235, 215));
		ReturnButton.setBounds(196, 512, 97, 48);
		Money_text.add(ReturnButton);

		JLabel label = new JLabel("10\uC6D0");
		label.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		label.setBounds(495, 538, 50, 40);
		Money_text.add(label);

		JLabel label_1 = new JLabel("50\uC6D0");
		label_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		label_1.setBounds(574, 538, 50, 40);
		Money_text.add(label_1);

		JLabel label_2 = new JLabel("100\uC6D0");
		label_2.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		label_2.setBounds(644, 538, 63, 40);
		Money_text.add(label_2);

		JLabel label_3 = new JLabel("500\uC6D0");
		label_3.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		label_3.setBounds(726, 540, 63, 40);
		Money_text.add(label_3);

		JLabel label_4 = new JLabel("1000\uC6D0");
		label_4.setFont(new Font("배달의민족 주아", Font.PLAIN, 23));
		label_4.setBounds(801, 538, 84, 40);
		Money_text.add(label_4);

		JLabel label_5 = new JLabel("\uAE08\uC561 \uC785\uB825");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("배달의민족 주아", Font.PLAIN, 32));
		label_5.setBounds(699, 386, 132, 48);
		Money_text.add(label_5);

		SportDrink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Coffee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}