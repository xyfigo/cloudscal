package org.xiaofei.cloudscal.testnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketTest {
	public static void main(String args[]) {
		try {
			Socket s = new Socket("time-A.timefreq.bldrdoc.gov", 13);
			try {
				InputStream inStream = s.getInputStream();
				s.setSoTimeout(10);

				Scanner in = new Scanner(inStream);

				while (in.hasNextLine()) {
					String line = in.nextLine();
					System.out.println(line);
				}
			}catch(InterruptedIOException e)
			{
				System.out.println(e);
			}
				
			finally {
				s.close();
			}
		 

	}catch (IOException e) {
		System.out.println(e);
	}
  }
}
