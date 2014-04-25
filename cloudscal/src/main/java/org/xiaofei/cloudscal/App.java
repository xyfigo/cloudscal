package org.xiaofei.cloudscal;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.SigarException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SigarException
    {
    	Sigar sigar = new Sigar();
    	
    	CpuInfo cpuinfo[] = sigar.getCpuInfoList();
    	String str = System.getProperty("java.library.path");
    	System.out.println(str);
		/* for(int i=0;i<cpuinfo.length;i++){
			 CpuInfo info = cpuinfo[i];
			 System.out.println("mhz=" + info.getMhz());//CPU的总量MHz
			 System.out.println("vendor=" + info.getVendor());//获得CPU的卖主，如：Intel
			 System.out.println("model=" + info.getModel());//获得CPU的类别，如：Celeron
			 System.out.println("cache size=" + info.getCacheSize());//缓冲存储器数量 
		 }*/
    	
    	CpuPerc cpu;
        try {
            cpu = sigar.getCpuPerc();
            printCpuPerc(cpu);
        } catch (SigarException e) {
            e.printStackTrace();
        }
        
        Mem mem = sigar.getMem();
    }
    
    private static void printCpuPerc(CpuPerc cpu) {
    	System.out.println("User :" + CpuPerc.format(cpu.getUser()));// 用户使用率
    	System.out. println("Sys :" + CpuPerc.format(cpu.getSys()));// 系统使用率
    	System.out.println("Wait :" + CpuPerc.format(cpu.getWait()));// 当前等待率
    	System.out.println("Nice :" + CpuPerc.format(cpu.getNice()));//
    	System.out.println("Idle :" + CpuPerc.format(cpu.getIdle()));// 当前空闲率
    	System.out.println("Total :" + CpuPerc.format(cpu.getCombined()));// 总的使用率
}
    private static void printCpuMem(Mem mem){
    	System.out.println("Total = " + mem.getTotal() / (1024L*1024L) + "M av");
        // 当前内存使用量
        System.out.println("Used = " + mem.getUsed() / (1024L*1024L) + "M used");
        // 当前内存剩余量
    }
    
}
