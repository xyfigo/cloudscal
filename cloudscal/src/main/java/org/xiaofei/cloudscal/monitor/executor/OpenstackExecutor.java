package org.xiaofei.cloudscal.monitor.executor;

public class OpenstackExecutor implements IExecutor{
	
	static int SUCCESS=0;
	static int EXCEPTION=2;
	static int FAIL=1;

	public int executor() {
		
		return SUCCESS;
	}

}
