package org.xiaofei.cloudscal.monitor;

import java.util.Collection;

import org.xiaofei.cloudscal.monitor.executor.IExecutor;
import org.xiaofei.cloudscal.monitor.executor.OpenstackExecutor;

public class CeilometerMonitor implements IMonitor<Object>{
	
	private IExecutor executor;
	
	public CeilometerMonitor(){
		this.executor=new OpenstackExecutor();
	}

	public void run() {
		
		
	}

	public IExecutor getExecutor() {
		return executor;
	}

	public void setExecutor(IExecutor executor) {
		this.executor = executor;
	}

	public Collection getOverLoadInstances() {
		
		return null;
	}

}
