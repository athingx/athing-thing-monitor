package com.github.athingx.athing.aliyun.monitor.thing.boot;

import com.github.athingx.athing.aliyun.monitor.thing.component.impl.MonitorThingComImpl;
import com.github.athingx.athing.standard.api.ThingCom;
import com.github.athingx.athing.standard.thing.boot.BootArguments;
import com.github.athingx.athing.standard.thing.boot.ThingComBoot;

/**
 * 设备监控组件引导程序
 */
public class MonitorThingComBoot implements ThingComBoot {

    @Override
    public ThingCom[] boot(String productId, String thingId, BootArguments arguments) {
        return new ThingCom[]{
                new MonitorThingComImpl()
        };
    }

}
