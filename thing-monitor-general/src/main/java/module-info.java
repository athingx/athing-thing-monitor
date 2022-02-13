import io.github.athingx.athing.thing.monitor.general.ThingMonitorBoot;

module io.github.athingx.athing.thing.monitor.aliyun {
    requires io.github.athingx.athing.thing.monitor;
    requires io.github.athingx.athing.standard.thing;
    requires org.slf4j;
    requires static metainf.services;
    requires com.github.oshi;
    exports io.github.athingx.athing.thing.monitor.general;

    provides io.github.athingx.athing.standard.thing.boot.ThingBoot with ThingMonitorBoot;

}