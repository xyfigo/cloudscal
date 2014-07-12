package org.xiaofei.cloudscal.monitor;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Server;
import org.openstack4j.openstack.OSFactory;
import org.xiaofei.cloudscal.monitor.executor.IExecutor;
import org.xiaofei.cloudscal.monitor.executor.OpenstackExecutor;
 

public class CeilometerMonitor implements IMonitor{
	
	private IExecutor executor;
	private HashMap<String, OverloadServer> overloadServers;
	
	public CeilometerMonitor(){
		this.executor=new OpenstackExecutor();
		this.overloadServers=null;
	}

	public void run() {
		
		
	}

	public IExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(IExecutor executor) {
		this.executor = executor;
	}

	public HashMap<String, OverloadServer> getOverloadInstances() {
		HashMap<String, OverloadServer> servers= new HashMap<String, OverloadServer>();
		Properties properties = System.getProperties();
		properties.setProperty("org.openstack4j.core.transport.internal.HttpLoggingFilter", "true");
		OSClient os = OSFactory.builder()
                .endpoint("http://10.10.19.254:5000/v2.0")
                .credentials("admin","sbsmsbsm")
                .tenantName("demo")
                .authenticate();
		
		
		return null;
	}

}
