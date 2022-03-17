package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.thing.boot.ThingBoot;
import io.github.athingx.athing.standard.thing.boot.ThingBootArgument;
import io.github.athingx.athing.thing.monitor.general.info.ThingInfoComImpl;
import io.github.athingx.athing.thing.monitor.general.usage.ThingUsageComImpl;

import java.util.Properties;

/**
 * 设备监控组件引导程序
 */
public class ThingMonitorBoot implements ThingBoot {

    @Override
    public ThingCom[] boot(String productId, String thingId, ThingBootArgument arguments) {
        return new ThingCom[]{
                new ThingInfoComImpl(),
                new ThingUsageComImpl(),
                new ThingMonitorComImpl()
        };
    }

    @Override
    public Properties getProperties() {
        return new Properties(){{
           put(PROP_GROUP, "io.github.athingx.athing.thing.monitor");
           put(PROP_ARTIFACT, "thing-monitor-general");
        }};
    }

}
