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
	// ���� ����
	public static Socket socket = null;

	public static OutputStream outputStream = null;
	public static DataOutputStream dataOutputStream = null;

	public static InputStream inputStream = null;
	public static DataInputStream dataInputStream = null;
	public static String SQLresult;

	// TODO : DB���� �������� �۾� �ʿ�
	
	DataTransfer() {
	}
	
	public void StatusTransfer(String status) throws IOException{
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Main Communication Server Connect");

			// ��� ��Ʈ�� ����
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			// �Է� ��Ʈ�� ����
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			// ���� ������ ������ ����
			dataOutputStream.writeUTF(status);
			dataOutputStream.flush(); // ���� ������ ���

			// Server������ return ���� �޼���
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

			// ��� ��Ʈ�� ����
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			// �Է� ��Ʈ�� ����
			inputStream = socket.getInputStream();
			dataInputStream = new DataInputStream(inputStream);

			// ���� ������ ������ ����
			dataOutputStream.writeUTF(data);
			dataOutputStream.flush(); // ���� ������ ���

			// Server������ return ���� �޼���
			SQLresult = dataInputStream.readUTF();
			System.out.println("Return Message : " + SQLresult);

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
		return SQLresult;
	}

	public void serverDisconnect() {
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("Dis���� ���� ��");
			outputStream = socket.getOutputStream();
			dataOutputStream = new DataOutputStream(outputStream);

			System.out.println("���Ǳ⸦ �����մϴ�.");
			// ���� ������ ������ ����
			dataOutputStream.writeUTF("stop\r\n");
			dataOutputStream.flush(); // ���� ������ ���

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
