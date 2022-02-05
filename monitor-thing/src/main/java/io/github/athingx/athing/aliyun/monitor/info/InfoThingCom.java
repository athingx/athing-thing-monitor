package io.github.athingx.athing.aliyun.monitor.info;

import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.component.annotation.ThCom;
import io.github.athingx.athing.standard.component.annotation.ThProperty;

/**
 * 设备信息组件
 */
@ThCom(id = InfoThingCom.THING_COM_ID, name = "thing info monitor", desc = "information of thing")
public interface InfoThingCom extends ThingCom {

    String THING_COM_ID = "athing_monitor_info";

    @ThProperty
    Info.Os getOs();

    @ThProperty
    Info.Jvm getJvm();

    @ThProperty
    Info.Computer getComputer();

    @ThProperty
    Info.Baseboard getBaseboard();

    @ThProperty
    Info.Firmware getFirmware();

    @ThProperty
    Info.Cpu getCpu();

    @ThProperty
    Info.Memory getMemory();

    @ThProperty
    Info.Disk[] getDisks();

    @ThProperty
    Info.Network[] getNetworks();

    @ThProperty
    Info.Power[] getPowers();

    @ThProperty
    Info.Store[] getStores();

}
