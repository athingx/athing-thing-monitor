package io.github.athingx.athing.thing.monitor.usage;

import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.component.annotation.ThCom;
import io.github.athingx.athing.standard.component.annotation.ThProperty;

/**
 * 设备使用率组件
 */
@ThCom(id = ThingUsageCom.THING_COM_ID, name = "thing usage monitor", desc = "usage of thing")
public interface ThingUsageCom extends ThingCom {

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
