package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.thing.monitor.general.info.ThingInfoComImpl;
import io.github.athingx.athing.thing.monitor.general.usage.ThingUsageComImpl;
import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.thing.boot.ThingBoot;
import io.github.athingx.athing.standard.thing.boot.ThingBootArgument;

import java.io.InputStream;
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
        final Properties prop = ThingBoot.super.getProperties();
        try (final InputStream in = ThingMonitorBoot.class.getResourceAsStream("/io/github/athingx/athing/thing/monitor/general/thing-boot.properties")) {
            if (null != in) {
                prop.load(in);
            }
        } catch (Exception cause) {
            // ignore...
        }
        return prop;
    }

}
