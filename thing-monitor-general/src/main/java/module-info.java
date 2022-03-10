module io.github.athingx.athing.thing.monitor.aliyun {

    requires io.github.athingx.athing.thing.monitor;
    requires io.github.athingx.athing.standard.thing;
    requires com.github.oshi;
    requires static org.slf4j;

    exports io.github.athingx.athing.thing.monitor.general;

    provides io.github.athingx.athing.standard.thing.boot.ThingBoot
            with io.github.athingx.athing.thing.monitor.general.ThingMonitorBoot;

}