package org.xiaofei.cloudscal;

import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.openstack4j.api.OSClient;
import org.openstack4j.api.telemetry.MeterService;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.identity.User;
import org.openstack4j.model.image.Image;
import org.openstack4j.model.telemetry.Meter;
import org.openstack4j.model.telemetry.Sample;
import org.openstack4j.model.telemetry.Statistics;
import org.openstack4j.openstack.OSFactory;
import org.openstack4j.openstack.telemetry.internal.MeterServiceImpl;

public class Openstack4j {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Properties properties = System.getProperties();
		properties.setProperty("org.openstack4j.core.transport.internal.HttpLoggingFilter", "true");
		OSClient os = OSFactory.builder()
                .endpoint("http://10.10.19.254:5000/v2.0")
                .credentials("admin","sbsmsbsm")
                .tenantName("demo")
                .authenticate();
		// Find all Users
		/*List<? extends User> users = os.identity().users().list();
		for (User user : users) {
			System.out.println(user.getUsername()+"**"+user.getTenantId());
		}*/

		// List all Tenants
		/*List<? extends Tenant> tenants = os.identity().tenants().list();

		// Find all Compute Flavors
		List<? extends Flavor> flavors = os.compute().flavors().list();*/

		//Find all running Servers
		/*List<? extends Server> servers = os.compute().servers().list();
		for (Server server : servers) {
			System.out.println(server.getName()+"**"+server.getId());
		}*/

		// Suspend a Server
		//ActionResponse response=os.compute().servers().action("2c1a8a25-ec53-47e0-a16d-d3863b83f5c9", Action.START);
		//System.out.println(response.isSuccess());
		
		
		
		
		
		/*for (Statistics statistics : stats) {
			System.out.println(statistics.toString());
		}*/
		//Meters
		//List<? extends Meter> meters = os.telemetry().meters().list();
		
		
		MeterService meterService=os.telemetry().meters();
		/*List<? extends Sample> s= meterService.samples("cpu_util","limit","2");
		System.out.println(s.size());
		float mean=0;
		for (Sample sample : s) {
			mean+=sample.getCounterVolume();
			System.out.println(sample.getCounterVolume());
		}
		System.out.println(mean/s.size());
		System.out.println("Name: "+s.get(0).getCounterName());
		System.out.println("Count: "+s.get(0).getCounterVolume()+s.get(0).getCounterUnit());
		Sample s1=s.get(0);*/
		//Date date =s1.getTimestamp();
		//System.out.println(date.toGMTString());
		
		
		//meterService list
		
		List<? extends Meter> s = os.telemetry().meters().list();
		System.out.println(s.size());
		for (Meter meter : s) {
			System.out.println(meter.toString());
		}
		
		
		
		//System.out.println(System.getProperty("HttpLoggingFilter"));
		
		//List<? extends Statistics> stats = os.telemetry().meters().statistics("cpu_util");
		
		/*List<? extends Sample> samples = os.telemetry().meters().samples("cpu_util");
		for (Sample sample : samples) {
			System.out.println(sample.getCounterName()+"*****"+sample.getCounterUnit());
		}*/

		// List all Networks
		/*List<? extends Network> networks = os.networking().network().list();
		for (Network network : networks) {
			System.out.println(network.getName()+"*****"+network.getId());
		}

		
		// List all Subnets
		List<? extends Subnet> subnets = os.networking().subnet().list();

		// List all Routers
		List<? extends Router> routers = os.networking().router().list();

		// List all Images (Glance)
		List<? extends Image> images = (List<? extends Image>) os.images().list();

		// Download the Image Data
		InputStream is = os.images().getAsStream("imageId");*/
		
		// List all Images (Glance)
				/*List<? extends Image> images = (List<? extends Image>) os.images().list();
				for (Image image : images) {
					System.out.println(image.getName()+"****"+image.getId());
				}*/

	}

}
