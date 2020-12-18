package network_term_project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	private JPanel Login_Layout;
	public JTextField ID_textField;
	public JPasswordField PW_textField;

	
	/*
	 * 	������ �޴��� �α��� �ϴ� ui CLASS
	 * 
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Login_Layout = new JPanel();
		Login_Layout.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Login_Layout);
		Login_Layout.setLayout(null);
		
		ID_textField = new JTextField();
		ID_textField.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 12));
		ID_textField.setBounds(180, 74, 139, 41);
		ID_textField.setForeground(Color.GRAY);
		Login_Layout.add(ID_textField);
		ID_textField.setColumns(10);

		
		JLabel ID_Label = new JLabel("ID :");
		ID_Label.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 36));
		ID_Label.setBounds(111, 67, 57, 48);
		Login_Layout.add(ID_Label);
		
		JLabel PW_Label = new JLabel("PW :");
		PW_Label.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 36));
		PW_Label.setBounds(94, 125, 74, 48);
		Login_Layout.add(PW_Label);
		
		PW_textField = new JPasswordField();
		PW_textField.setBounds(180, 129, 139, 41);
		Login_Layout.add(PW_textField);
		
		// ��ư Ŭ���� �̺�Ʈ ����
		JButton btnNewButton = new JButton("\uB85C\uADF8\uC778");
		btnNewButton.setBackground(new Color(255, 235, 205));
		btnNewButton.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ID_Data = new String();
				String PW_Data = new String();
				// �ؽ�Ʈ �ʵ忡�� �Է��� ��й�ȣ �о��
				ID_Data = ID_textField.getText();
				PW_Data = PW_textField.getText();
				Main.ID_PW.setID(ID_Data);
				Main.ID_PW.setPW(PW_Data);
				// ID,  PW �˻�
				if(Main.ID_PW.getID().equals(Main.ID_PW.getID_Start()) == true && 
						Main.ID_PW.getPW().equals(Main.ID_PW.getPW_Start()) == true) {
				JOptionPane.showMessageDialog(Login_Layout, "�α��� �Ǿ����ϴ�.\n������ �޴��� �̵��մϴ�.");
				Manager manager = new Manager();
				manager.setVisible(true);
				dispose();
				}
				else {
					JOptionPane.showMessageDialog(Login_Layout, "���̵� Ȥ�� �н����尡 �ٸ��ϴ�.");
				}

			}
		});
		btnNewButton.setBounds(113, 217, 97, 34);
		Login_Layout.add(btnNewButton);
		
		JLabel Login_Label = new JLabel("\uAD00\uB9AC\uC790\uBA54\uB274 \uB85C\uADF8\uC778");
		Login_Label.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 28));
		Login_Label.setBounds(106, 10, 220, 34);
		Login_Layout.add(Login_Label);
		
		JLabel lblId = new JLabel("\uCD08\uAE30 ID : manager");
		lblId.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 15));
		lblId.setBounds(64, 173, 133, 48);
		Login_Layout.add(lblId);
		
		JLabel lblPw = new JLabel("\uCD08\uAE30 PW : manager@1234");
		lblPw.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 15));
		lblPw.setBounds(190, 173, 185, 48);
		Login_Layout.add(lblPw);
		
		JButton Exit = new JButton("\uC885\uB8CC");
		Exit.setBackground(new Color(255, 245, 238));
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Exit.setFont(new Font("����ǹ��� �־�", Font.PLAIN, 16));
		Exit.setBounds(222, 217, 97, 34);
		Login_Layout.add(Exit);
	}
}
