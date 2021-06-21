package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerThread extends Thread {

	private Socket socket;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	// 출장관련(독립적인 프로세서) 부모쪽에 구현되어있다.

	// run

	@Override
	public void run() {
		// 메시지 받기용 스트림
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			// 보내기용
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			while (true) {
				// 메세지 받기
				String msg = br.readLine();
				System.out.println("받은메시지: " + msg);

				if (msg == null) {
					System.out.println("클라이언트 접속 종료");
					break;
				}

				// 메세지보내기
				bw.write(msg);
				bw.newLine();
				bw.flush();
			}
		} catch (IOException e) {

		}
	}

}
