package com.github.athingx.athing.aliyun.monitor.boot;

import com.github.athingx.athing.aliyun.monitor.api.MonitorThingCom;
import com.github.athingx.athing.aliyun.monitor.component.DefaultMonitorThingCom;
import com.github.athingx.athing.standard.component.ThingCom;
import com.github.athingx.athing.standard.thing.boot.BootArguments;
import com.github.athingx.athing.standard.thing.boot.ThingComBoot;
import org.kohsuke.MetaInfServices;

import java.util.Properties;

@MetaInfServices
public class BootImpl implements ThingComBoot {

    private final MonitorThingCom monitor = new DefaultMonitorThingCom();

    @Override
    public Specifications getSpecifications() {
        return () -> new Properties() {{
            put("AUTHOR", "oldmanpushcart@gmail.com");
            put("DATE", "2020-12-02");
        }};
    }

    @Override
    public ThingCom bootUp(String productId, String thingId, BootArguments arguments) {
        return monitor;
    }

}
