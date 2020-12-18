package network_term_project;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DataTransfer {
	private final static int BUFFER_SIZE = 1024;
	// 소켓 선언
	public static Socket socket = null;

	public static OutputStream outputStream = null;
	public static DataOutputStream dataOutputStream = null;

	public static InputStream inputStream = null;
	public static DataInputStream dataInputStream = null;
	public static String SQLresult;

	// TODO : DB에서 가져오는 작업 필요
	
	DataTransfer() {
	}
	
	public void StatusTransfer(String status) throws IOException{
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Main Communication Server Connect");

			// 출력 스트림 생성
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			// 입력 스트림 생성
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			// 서버 측으로 데이터 전송
			dataOutputStream.writeUTF(status);
			dataOutputStream.flush(); // 버퍼 완전히 비움

			// Server측에서 return 받을 메세지
			String receviedMessage = dataInputStream.readUTF();
			SQLresult = receviedMessage;
			System.out.println("Return Message : " + receviedMessage);

		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
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
	
	public String dataTransfer(String data) throws IOException {
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Main Communication Server Connect");

			// 출력 스트림 생성
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			// 입력 스트림 생성
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			// 서버 측으로 데이터 전송
			dataOutputStream.writeUTF(data);
			dataOutputStream.flush(); // 버퍼 완전히 비움

			// Server측에서 return 받을 메세지
			SQLresult = dataInputStream.readUTF();
			System.out.println("Return Message : " + SQLresult);

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
		return SQLresult;
	}

	public void serverDisconnect() {
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Dis서버 연결 됨");
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			System.out.println("자판기를 종료합니다.");
			// 서버 측으로 데이터 전송
			dataOutputStream.writeUTF("stop\r\n");
			dataOutputStream.flush(); // 버퍼 완전히 비움

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
