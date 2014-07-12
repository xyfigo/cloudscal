package org.xiaofei.cloudscal.monitor;

import java.util.HashMap;


public interface IMonitor {
	
	public void run();
	
	public HashMap<String ,OverloadServer> getOverloadInstances(); 

}
