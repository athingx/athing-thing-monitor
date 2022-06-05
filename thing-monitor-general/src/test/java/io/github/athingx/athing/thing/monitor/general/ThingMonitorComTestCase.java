package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.aliyun.thing.runtime.ThingRuntime;
import io.github.athingx.athing.aliyun.thing.runtime.specs.DumpTo;
import io.github.athingx.athing.standard.component.Identifier;
import io.github.athingx.athing.standard.thing.op.OpReply;
import io.github.athingx.athing.standard.thing.op.ThingOpFuture;
import io.github.athingx.athing.thing.monitor.info.Info;
import io.github.athingx.athing.thing.monitor.info.ThingInfoCom;
import io.github.athingx.athing.thing.monitor.usage.ThingUsageCom;
import io.github.athingx.athing.thing.monitor.usage.Usage;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ThingMonitorComTestCase extends ThingSupport {

    @Test
    public void test$thing$tsl$success() throws Exception {
        final ThingRuntime runtime = ThingRuntime.getInstance(thing);
        final Map<String, String> map = runtime.getThingSpec()
                .dump(new DumpTo.ToMap())
                .toMap();
        Assert.assertTrue(map.containsKey(ThingInfoCom.THING_COM_ID));
        Assert.assertTrue(map.containsKey(ThingUsageCom.THING_COM_ID));
        System.out.println(map);

        runtime.getThingSpec()
                .dump(new DumpTo.ToZip())
                .toZip(new File("dump.zip"));

    }

    @Test
    public void test$thing$monitor$report_info$success() throws Exception {
        final Identifier[] identifiers = Stream.of(Info.Item.values()).map(Info.Item::getIdentifier).toArray(Identifier[]::new);
        final ThingOpFuture<OpReply<Set<Identifier>>> future = thing.getOp()
                .postProperties(identifiers)
                .sync()
                .future();
        Stream.of(identifiers).forEach(identifier ->
                Assert.assertTrue(
                        identifier.getIdentity(),
                        future.getSuccess().getData().contains(identifier)
                )
        );
    }

    @Test
    public void test$thing$monitor$report_usage$success() throws Exception {
        final Identifier[] identifiers = Stream.of(Usage.Item.values()).map(Usage.Item::getIdentifier).toArray(Identifier[]::new);
        final ThingOpFuture<OpReply<Set<Identifier>>> future = thing.getOp()
                .postProperties(identifiers)
                .sync()
                .future();
        Stream.of(identifiers).forEach(identifier ->
                Assert.assertTrue(
                        identifier.getIdentity(),
                        future.getSuccess().getData().contains(identifier)
                )
        );
    }


}
