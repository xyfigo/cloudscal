package org.xiaofei.cloudscal.testnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {
	
	Socket in;
	public ThreadedEchoHandler(Socket incoming){
		this.in=incoming;
	}

	public void run() {
		// TODO Auto-generated method stub
		try{
		try {
			InputStream ins=in.getInputStream();
			OutputStream ots=in.getOutputStream();
			PrintWriter out = new PrintWriter(ots,true);
			Scanner in=new Scanner(ins);
			boolean done= false;
			
			while(!done&&in.hasNextLine()){
				String line = in.nextLine();
				out.println("ECHO"+line);
				if(line.equals("BYE"))
					done=true;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}finally{try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	}

	

}
