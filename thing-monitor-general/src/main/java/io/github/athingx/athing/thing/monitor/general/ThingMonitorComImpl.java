package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.thing.monitor.ThingMonitorCom;
import io.github.athingx.athing.thing.monitor.info.Info;
import io.github.athingx.athing.thing.monitor.info.ThingInfoCom;
import io.github.athingx.athing.thing.monitor.usage.Usage;
import io.github.athingx.athing.thing.monitor.usage.ThingUsageCom;
import io.github.athingx.athing.standard.component.Identifier;
import io.github.athingx.athing.standard.thing.Thing;
import io.github.athingx.athing.standard.thing.ThingFuture;
import io.github.athingx.athing.standard.thing.boot.Inject;
import io.github.athingx.athing.standard.thing.op.OpReply;
import io.github.athingx.athing.standard.thing.op.ThingOpFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import static io.github.athingx.athing.standard.thing.op.executor.ScheduleType.FIX_DELAY;
import static java.util.Arrays.stream;

public class ThingMonitorComImpl implements ThingMonitorCom {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private ThingInfoCom info;

    @Inject
    private ThingUsageCom usage;

    @Inject
    private Thing thing;

    @Override
    public ThingOpFuture<OpReply<Set<Identifier>>> reportInfo(Info.Item... items) {
        return thing.getThingOp()
                .postProperties(stream(items).map(Info.Item::getIdentifier).toArray(Identifier[]::new));
    }

    @Override
    public ThingFuture<Void> scheduleReportUsage(long interval, TimeUnit unit, Usage.Item... items) {
        return thing.getThingOp().getThingExecutor()
                .schedule(interval, unit, FIX_DELAY, () ->
                        thing.getThingOp()
                                .postProperties(stream(items).map(Usage.Item::getIdentifier).toArray(Identifier[]::new))
                                .onSuccess(v -> logger.info("{}/monitor report usage success, items={}", thing, items))
                                .onFailure(e -> logger.warn("{}/monitor report usage failure, items={}", thing, items, e))
                                .awaitUninterruptible()
                                .future());
    }

}
