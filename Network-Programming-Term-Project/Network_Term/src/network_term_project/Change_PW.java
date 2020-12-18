package network_term_project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Change_PW extends JFrame {

	private JPanel Change_PW_Layout;
	private JTextField PW_curr;
	private JTextField PW_change;
	public static String PW_Change;

	/**
	 * Create the frame.
	 */
	
	/*
	 * 	비밀번호 변경 UI
	 */
	
	public Change_PW() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Change_PW_Layout = new JPanel();
		Change_PW_Layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Change_PW_Layout);
		Change_PW_Layout.setLayout(null);
		
		JLabel Change_Lable = new JLabel("\uD604\uC7AC \uBE44\uBC00\uBC88\uD638 : ");
		Change_Lable.setHorizontalAlignment(SwingConstants.LEFT);
		Change_Lable.setFont(new Font("배달의민족 주아", Font.PLAIN, 22));
		Change_Lable.setBounds(59, 22, 149, 33);
		Change_PW_Layout.add(Change_Lable);
		
		JLabel label = new JLabel("\uBCC0\uACBD\uD560 \uBE44\uBC00\uBC88\uD638 : ");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setFont(new Font("배달의민족 주아", Font.PLAIN, 22));
		label.setBounds(59, 73, 162, 33);
		Change_PW_Layout.add(label);
		
		// 현재 비밀번호
		PW_curr = new JTextField();
		PW_curr.setForeground(Color.GRAY);
		PW_curr.setFont(new Font("서울남산체 L", Font.PLAIN, 12));
		PW_curr.setColumns(10);
		PW_curr.setBounds(223, 21, 139, 41);
		Change_PW_Layout.add(PW_curr);
		
		
		// 변경할 비밀번호

		PW_change = new JTextField();
		PW_change.setForeground(Color.GRAY);
		PW_change.setFont(new Font("서울남산체 L", Font.PLAIN, 12));
		PW_change.setColumns(10);
		PW_change.setBounds(223, 72, 139, 41);
		PW_Change = PW_change.getText();
		Change_PW_Layout.add(PW_change);
		
		JLabel label_1 = new JLabel("\uC870\uAC74 : 8\uC790\uB9AC\uC774\uC0C1, \uD2B9\uC218\uBB38\uC790 1\uAC1C\uC774\uC0C1, \uC22B\uC790 1\uAC1C\uC774\uC0C1");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
		label_1.setBounds(122, 218, 300, 33);
		Change_PW_Layout.add(label_1);
		
		
		// 비밀번호 변경 버튼 클릭시  이벤트
		JButton Button_PWChange = new JButton("\uBE44\uBC00\uBC88\uD638 \uBCC0\uACBD");
		Button_PWChange.setBackground(new Color(250, 240, 230));
		Button_PWChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String PW_change = new String();
				PW_change = PW_curr.getText();
				// 현재 비밀번호와 입력한 현재 비밀번호가 같을때 동작
				if(Main.ID_PW.getPW().equals(PW_change) == true) {
					Main.ID_PW.setPW(PW_change);
					Main.ID_PW.setPW_Start(PW_change);
					JOptionPane.showMessageDialog(Change_PW_Layout, "비밀번호가 변경되었습니다");
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(Change_PW_Layout, "입력하신 현재 비밀번호가 다릅니다");
				}
			}
		});
		Button_PWChange.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
		Button_PWChange.setBounds(95, 151, 116, 43);
		Change_PW_Layout.add(Button_PWChange);
		
		JButton Exit = new JButton("\uC885\uB8CC");
		Exit.setBackground(new Color(240, 248, 255));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Exit.setFont(new Font("배달의민족 주아", Font.PLAIN, 14));
		Exit.setBounds(223, 151, 116, 43);
		Change_PW_Layout.add(Exit);
	}
}
