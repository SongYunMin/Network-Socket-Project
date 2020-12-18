package network_term_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Gross_UI extends JFrame {
	private JPanel contentPane;
	private JTextField Day_sales;
	/**
	 * Create the frame.
	 */
	
	/*
	 * 	 총 매출 현황 UI
	 */
	public Gross_UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Main_text = new JLabel("\uCD1D \uB9E4\uCD9C \uD604\uD669");
		Main_text.setFont(new Font("서울남산체 EB", Font.PLAIN, 38));
		Main_text.setBounds(139, 10, 213, 78);
		contentPane.add(Main_text);
		
		JLabel label = new JLabel(" \uCD1D\uB9E4\uCD9C : ");
		label.setFont(new Font("서울남산체 EB", Font.PLAIN, 38));
		label.setBounds(65, 115, 151, 78);
		contentPane.add(label);
		
		Day_sales = new JTextField();
		Day_sales.setFont(new Font("서울남산체 B", Font.PLAIN, 25));
		Day_sales.setBounds(224, 127, 195, 49);

		contentPane.add(Day_sales);
		Day_sales.setColumns(10);
		
		JButton Sales_Update = new JButton("\uB9E4\uCD9C Update");
		Sales_Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Day_sales.setText(String.valueOf(UI.GS.getDay_Sales()) + " 원");
			}
		});
		Sales_Update.setFont(new Font("서울남산체 EB", Font.PLAIN, 22));
		Sales_Update.setBounds(168, 203, 160, 49);
		contentPane.add(Sales_Update);
	}
}
