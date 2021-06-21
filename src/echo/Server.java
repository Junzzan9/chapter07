package echo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket=new ServerSocket();
		serverSocket.bind(new InetSocketAddress("192.168.0.166",10001)); //IP 포트번호
		
		System.out.println("서버시작");
		System.out.println("==============================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		
		//반복구간
		while(true) {
			Socket socket=serverSocket.accept();
			System.out.println("클라이언트가 연결되었습니다.");
			
			Thread thread=new ServerThread(socket);
			thread.start();
			
			//탈출조건 생략.
			
		}
		
		
		
		
		
		/*
		OutputStream out=System.out;
		OutputStreamWriter sosw=new OutputStreamWriter(out);
		BufferedWriter sbw=new BufferedWriter(sosw);
		
		sbw.write("<클라이언트 종료>");
		sbw.newLine();
		sbw.flush();
		*/
		/*
		System.out.println("[서버종료]");
		
		socket.close();
		serverSocket.close();
		*/
	}
}
