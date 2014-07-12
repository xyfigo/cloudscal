package org.xiaofei.cloudscal.monitor;

import java.util.Collection;


public interface IMonitor<T> {
	
	public void run();
	
	public Collection<T> getOverLoadInstances(); 

}
