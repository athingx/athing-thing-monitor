package io.github.athingx.athing.thing.monitor;

import io.github.athingx.athing.thing.monitor.info.Info;
import io.github.athingx.athing.thing.monitor.usage.Usage;
import io.github.athingx.athing.standard.component.Identifier;
import io.github.athingx.athing.standard.component.ThingCom;
import io.github.athingx.athing.standard.thing.ThingFuture;
import io.github.athingx.athing.standard.thing.op.OpReply;
import io.github.athingx.athing.standard.thing.op.ThingOpFuture;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 监控组件
 */
public interface MonitorThingCom extends ThingCom {

    /**
     * 上报信息
     *
     * @param items 信息项
     * @return Future
     */
    ThingOpFuture<OpReply<Set<Identifier>>> reportInfo(Info.Item... items);

    /**
     * 周期上报使用率
     *
     * @param interval 间隔时长
     * @param unit     时长单位
     * @param items    上报项
     * @return Future
     */
    ThingFuture<Void> scheduleReportUsage(long interval, TimeUnit unit, Usage.Item... items);

}
