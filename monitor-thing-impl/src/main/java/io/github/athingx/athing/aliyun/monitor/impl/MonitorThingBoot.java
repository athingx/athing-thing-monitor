package io.github.athingx.athing.aliyun.monitor.impl;

import io.github.athingx.athing.aliyun.monitor.impl.info.InfoThingComImpl;
import io.github.athingx.athing.aliyun.monitor.impl.usage.UsageThingComImpl;
import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.thing.boot.ThingBoot;
import io.github.athingx.athing.standard.thing.boot.ThingBootArgument;
import org.kohsuke.MetaInfServices;

import java.io.InputStream;
import java.util.Properties;

/**
 * 设备监控组件引导程序
 */
@MetaInfServices
public class MonitorThingBoot implements ThingBoot {

    @Override
    public ThingCom[] boot(String productId, String thingId, ThingBootArgument arguments) {
        return new ThingCom[]{
                new InfoThingComImpl(),
                new UsageThingComImpl(),
                new MonitorThingComImpl()
        };
    }

    @Override
    public Properties getProperties() {
        final Properties prop = ThingBoot.super.getProperties();
        try (final InputStream in = MonitorThingBoot.class.getResourceAsStream("/io/github/athingx/athing/aliyun/monitor/impl/monitor-thing-boot.properties")) {
            if (null != in) {
                prop.load(in);
            }
        } catch (Exception cause) {
            // ignore...
        }
        return prop;
    }

}
