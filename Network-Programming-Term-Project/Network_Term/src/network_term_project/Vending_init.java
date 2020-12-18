package network_term_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Vending_init {
	// 소켓 선언
	public static Socket socket = null;

	public static OutputStream outputStream = null;
	public static DataOutputStream dataOutputStream = null;

	public static InputStream inputStream = null;
	public static DataInputStream dataInputStream = null;

	public void init() {
		try {
			socket = new Socket("localhost", 9000);
			System.out.println("서버 연결 됨");

			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			System.out.println("자판기를 초기화 합니다.");
			// 초기화 Insert 문
			String initData = "INSERT INTO `vending` (`vending_index`, `water_num`, `coffee_num`, "
					+ "`sport_num`, `highcoffee_num`, `soda_num`, `money`) "
					+ "VALUES (NULL, '3', '3', '3', '3', '3', '0')";


			dataOutputStream.flush();
			
			// 서버 측으로 데이터 전송
			dataOutputStream.writeUTF(initData);
			dataOutputStream.flush(); // 버퍼 완전히 비움

			// Server측에서 return 받을 메세지
			String receviedMessage = dataInputStream.readUTF();
			System.out.println("Return Message : " + receviedMessage);

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // 소켓 닫음
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
