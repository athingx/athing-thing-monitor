package com.github.athingx.athing.aliyun.monitor.api;

import com.github.athingx.athing.aliyun.monitor.api.info.*;
import com.github.athingx.athing.aliyun.monitor.api.usage.*;
import com.github.athingx.athing.standard.component.ThingCom;
import com.github.athingx.athing.standard.component.annotation.ThCom;
import com.github.athingx.athing.standard.component.annotation.ThProperty;

/**
 * 设备组件
 */
@ThCom(id = "athing_monitor", name = "athing device monitor", desc = "device monitor for athing")
public interface MonitorThingCom extends ThingCom {

    /**
     * 获取CPU信息
     *
     * @return CPU信息
     */
    @ThProperty
    CpuInfo getCpuInfo();

    /**
     * 获取内存信息
     *
     * @return 内存信息
     */
    @ThProperty
    MemoryInfo getMemoryInfo();

    /**
     * 获取网络信息
     *
     * @return 网络信息
     */
    @ThProperty
    NetworkInfo[] getNetworkInfo();

    /**
     * 获取电源信息
     *
     * @return 电源信息
     */
    @ThProperty
    PowerInfo[] getPowerInfo();

    /**
     * 获取存储信息
     *
     * @return 存储信息
     */
    @ThProperty
    StoreInfo[] getStoreInfo();

    /**
     * 获取CPU使用率
     *
     * @return CPU使用率
     */
    @ThProperty
    CpuUsage getCpuUsage();

    /**
     * 获取内存使用率
     *
     * @return 内存使用率
     */
    @ThProperty
    MemoryUsage getMemoryUsage();

    /**
     * 获取网络使用率
     *
     * @return 网络使用率
     */
    @ThProperty
    NetworkUsage[] getNetworkUsage();

    /**
     * 获取电源使用率
     *
     * @return 电源使用率
     */
    @ThProperty
    PowerUsage[] getPowerUsage();

    /**
     * 获取存储使用率
     *
     * @return 存储使用率
     */
    @ThProperty
    StoreUsage[] getStoreUsage();

}
