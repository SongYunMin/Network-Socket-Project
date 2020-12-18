package network_term_project;

import java.awt.EventQueue;
import java.io.IOException;
import java.net.Socket;

public class Main {
	public static ID_PassWord ID_PW = new ID_PassWord();
	public static DataTransfer a = new DataTransfer();
	public static Socket socket = null;
	public Main() {
	} // »ý¼ºÀÚ

	public static void main(String[] args) throws IOException{
		Vending_init init = new Vending_init();
		init.init();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI frame = new UI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		//a.Transfer("data");
	}
}