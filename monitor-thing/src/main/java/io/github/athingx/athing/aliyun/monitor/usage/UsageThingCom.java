package io.github.athingx.athing.aliyun.monitor.usage;

import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.component.annotation.ThCom;
import io.github.athingx.athing.standard.component.annotation.ThProperty;

/**
 * 设备使用率组件
 */
@ThCom(id = UsageThingCom.THING_COM_ID, name = "thing usage monitor", desc = "usage of thing")
public interface UsageThingCom extends ThingCom {

    String THING_COM_ID = "athing_monitor_usage";

    @ThProperty
    Usage.Cpu getCpu();

    @ThProperty
    Usage.Memory getMemory();

    @ThProperty
    Usage.Network[] getNetworks();

    @ThProperty
    Usage.Power[] getPowers();

    @ThProperty
    Usage.Store[] getStores();

}
