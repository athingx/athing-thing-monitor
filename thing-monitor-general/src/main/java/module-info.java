module io.github.athingx.athing.thing.monitor.general {

    requires transitive io.github.athingx.athing.thing.monitor;
    requires io.github.athingx.athing.standard.thing;
    requires com.github.oshi;
    requires org.slf4j;

    exports io.github.athingx.athing.thing.monitor.general;

}