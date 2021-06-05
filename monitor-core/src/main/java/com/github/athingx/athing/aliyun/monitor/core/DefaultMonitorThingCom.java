package com.github.athingx.athing.aliyun.monitor.core;

import com.github.athingx.athing.aliyun.monitor.api.MonitorThingCom;
import com.github.athingx.athing.aliyun.monitor.api.info.*;
import com.github.athingx.athing.aliyun.monitor.api.usage.*;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.GlobalMemory;

/**
 * 设备监控实现
 */
public class DefaultMonitorThingCom implements MonitorThingCom {

    private final SystemInfo systemInfo = new SystemInfo();
    private final DeviceUsageCalculator deviceUsageCalculator = new DeviceUsageCalculator(systemInfo);

    @Override
    public CpuInfo getCpuInfo() {
        final CentralProcessor processor = systemInfo.getHardware().getProcessor();
        final CpuInfo cpuInfo = new CpuInfo();
        cpuInfo.setId(processor.getProcessorIdentifier().getProcessorID());
        cpuInfo.setIdentity(processor.getProcessorIdentifier().getIdentifier());
        cpuInfo.setLogicCnt(processor.getLogicalProcessorCount());
        cpuInfo.setPhyCnt(processor.getPhysicalProcessorCount());
        cpuInfo.setPhyPkgCnt(processor.getPhysicalPackageCount());
        return cpuInfo;
    }

    @Override
    public MemoryInfo getMemoryInfo() {
        final GlobalMemory memory = systemInfo.getHardware().getMemory();
        final MemoryInfo memoryInfo = new MemoryInfo();
        memoryInfo.setPhyCap(memory.getTotal());
        memoryInfo.setVirCap(memory.getVirtualMemory().getSwapTotal());
        return memoryInfo;
    }

    @Override
    public PowerInfo[] getPowerInfo() {
        return systemInfo.getHardware().getPowerSources().stream()
                .map(power -> {
                    final PowerInfo powerInfo = new PowerInfo();
                    powerInfo.setName(power.getName());
                    powerInfo.setCap(power.getMaxCapacity());
                    powerInfo.setUnit(power.getCapacityUnits().name());
                    return powerInfo;
                })
                .toArray(PowerInfo[]::new);
    }

    @Override
    public NetworkInfo[] getNetworkInfo() {
        return systemInfo.getHardware().getNetworkIFs().stream()
                .map(network -> {
                    final NetworkInfo networkInfo = new NetworkInfo();
                    networkInfo.setMac(network.getMacaddr());
                    networkInfo.setName(network.getName());
                    return networkInfo;
                })
                .toArray(NetworkInfo[]::new);
    }

    @Override
    public StoreInfo[] getStoreInfo() {
        return systemInfo.getOperatingSystem().getFileSystem().getFileStores().stream()
                .map(store -> {
                    final StoreInfo storeInfo = new StoreInfo();
                    storeInfo.setCapacity(store.getTotalSpace());
                    storeInfo.setFormat(store.getType());
                    storeInfo.setMount(store.getMount());
                    return storeInfo;
                })
                .toArray(StoreInfo[]::new);
    }

    @Override
    public CpuUsage getCpuUsage() {
        return deviceUsageCalculator.calculateCpuUsage();
    }

    @Override
    public MemoryUsage getMemoryUsage() {
        return deviceUsageCalculator.calculateMemoryUsage();
    }

    @Override
    public NetworkUsage[] getNetworkUsage() {
        return deviceUsageCalculator.calculateNetworkUsage();
    }

    @Override
    public PowerUsage[] getPowerUsage() {
        return deviceUsageCalculator.calculatePowerUsage();
    }

    @Override
    public StoreUsage[] getStoreUsage() {
        return deviceUsageCalculator.calculateStoreUsage();
    }


}
