package org.xiaofei.cloudscal.agent;
import org.hyperic.sigar.cmd.CpuInfo;
public class sigar {
	public static void main(String[] args){
		CpuInfo cpuinfo = new CpuInfo();
		System.out.println(cpuinfo.getUsageShort());
	}
}
