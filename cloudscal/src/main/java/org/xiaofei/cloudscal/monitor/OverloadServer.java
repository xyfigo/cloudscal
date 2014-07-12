package org.xiaofei.cloudscal.monitor;

import org.openstack4j.model.compute.Server;

public class OverloadServer {
	
	private Server server;
	private Float cpu_util;
	public Server getServer() {
		return server;
	}
	public void setServer(Server server) {
		this.server = server;
	}
	public Float getCpu_util() {
		return cpu_util;
	}
	public void setCpu_util(Float cpu_util) {
		this.cpu_util = cpu_util;
	}
	
	
	

}
