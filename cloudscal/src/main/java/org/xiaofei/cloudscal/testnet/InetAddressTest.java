package org.xiaofei.cloudscal.testnet;
import java.net.*;

public class InetAddressTest {
	public static void main(String args[]) throws UnknownHostException{
		InetAddress address = InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
		byte[] addressBytes=address.getAddress();
		System.out.println(address);
		for(){
			System.out.println(addressBytes[i]);
		}
	}

}
