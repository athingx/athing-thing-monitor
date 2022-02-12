package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.aliyun.thing.runtime.ThingRuntime;
import io.github.athingx.athing.aliyun.thing.runtime.specs.DumpTo;
import io.github.athingx.athing.standard.component.Identifier;
import io.github.athingx.athing.standard.thing.boot.ThingBoot;
import io.github.athingx.athing.standard.thing.op.OpReply;
import io.github.athingx.athing.standard.thing.op.ThingOpFuture;
import io.github.athingx.athing.thing.monitor.MonitorThingCom;
import io.github.athingx.athing.thing.monitor.info.Info;
import io.github.athingx.athing.thing.monitor.info.InfoThingCom;
import io.github.athingx.athing.thing.monitor.usage.Usage;
import io.github.athingx.athing.thing.monitor.usage.UsageThingCom;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import static java.util.concurrent.TimeUnit.SECONDS;

public class MonitorThingComTestCase extends ThingSupport {

    @Ignore
    @Test
    public void debug$thing$monitor$schedule_report_usage$success() throws Exception {
        thing.getUniqueThingCom(MonitorThingCom.class).scheduleReportUsage(30, SECONDS, Usage.Item.values())
                .sync();
    }

    @Test
    public void test$thing$monitor$boot() {
        final ThingBoot boot = new MonitorThingBoot();
        Assert.assertEquals("${project.groupId}", boot.getProperties().getProperty(ThingBoot.PROP_GROUP));
        Assert.assertEquals("${project.artifactId}", boot.getProperties().getProperty(ThingBoot.PROP_ARTIFACT));
        Assert.assertEquals("${project.version}", boot.getProperties().getProperty(ThingBoot.PROP_VERSION));
    }

    @Test
    public void test$thing$tsl$success() throws Exception {
        final Map<String, String> map = thing.getUniqueThingCom(ThingRuntime.class).getThingSpec()
                .dump(new DumpTo.ToMap())
                .toMap();
        Assert.assertTrue(map.containsKey(InfoThingCom.THING_COM_ID));
        Assert.assertTrue(map.containsKey(UsageThingCom.THING_COM_ID));
        System.out.println(map);

        thing.getUniqueThingCom(ThingRuntime.class).getThingSpec()
                .dump(new DumpTo.ToZip())
                .toZip(new File("dump.zip"));

    }

    @Test
    public void test$thing$monitor$report_info$success() throws Exception {
        final ThingOpFuture<OpReply<Set<Identifier>>> future = thing.getUniqueThingCom(MonitorThingCom.class).reportInfo(Info.Item.values())
                .sync()
                .future();
        Arrays.stream(Info.Item.values()).forEach(item ->
                Assert.assertTrue(
                        item.getIdentifier().getIdentity(),
                        future.getSuccess().getData().contains(item.getIdentifier())
                )
        );
    }


}
