package org.xiaofei.cloudscal.testnet;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;

public class EchoServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			int i=1;
			ServerSocket s= new ServerSocket(8189);
			/*Socket incoming=s.accept();*/
			while(true){
				Socket incoming=s.accept();
				System.out.println("Spawning"+i);
				Runnable r = new ThreadedEchoHandler(incoming);
				
				Thread t= new Thread(r);
				t.start();
				i++;
			}
			
			
			/*InputStream ins=incoming.getInputStream();
			OutputStream ots=incoming.getOutputStream();
			PrintWriter out = new PrintWriter(ots,true);
			out.println("Hello!Enter BYE to exit.");
			Scanner in = new Scanner(ins);
			boolean done=false;
			while(!done){
				String line=in.next();
				System.out.println("ECHO:"+line);
				if(line.equals("BYE"))
					done=true;
			}*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
