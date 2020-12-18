package network_term_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Vending_init {
	// ���� ����
	public static Socket socket = null;

	public static OutputStream outputStream = null;
	public static DataOutputStream dataOutputStream = null;

	public static InputStream inputStream = null;
	public static DataInputStream dataInputStream = null;

	public void init() {
		try {
			socket = new Socket("localhost", 9000);
			System.out.println("���� ���� ��");

			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			System.out.println("���Ǳ⸦ �ʱ�ȭ �մϴ�.");
			// �ʱ�ȭ Insert ��
			String initData = "INSERT INTO `vending` (`vending_index`, `water_num`, `coffee_num`, "
					+ "`sport_num`, `highcoffee_num`, `soda_num`, `money`) "
					+ "VALUES (NULL, '3', '3', '3', '3', '3', '0')";


			dataOutputStream.flush();
			
			// ���� ������ ������ ����
			dataOutputStream.writeUTF(initData);
			dataOutputStream.flush(); // ���� ������ ���

			// Server������ return ���� �޼���
			String receviedMessage = dataInputStream.readUTF();
			System.out.println("Return Message : " + receviedMessage);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // ���� ����
			try {
				if (dataOutputStream != null)
					dataOutputStream.close();
				if (outputStream != null)
					outputStream.close();
				if (dataInputStream != null)
					dataInputStream.close();
				if (inputStream != null)
					inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
