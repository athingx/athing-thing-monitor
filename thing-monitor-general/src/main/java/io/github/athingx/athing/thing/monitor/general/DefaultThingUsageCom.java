package io.github.athingx.athing.thing.monitor.general;

import io.github.athingx.athing.thing.monitor.general.util.MathUtils;
import io.github.athingx.athing.thing.monitor.usage.Usage;
import io.github.athingx.athing.thing.monitor.usage.ThingUsageCom;
import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.CentralProcessor.TickType;
import oshi.hardware.GlobalMemory;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public class DefaultThingUsageCom implements ThingUsageCom {

    private final SystemInfo info = new SystemInfo();
    private final OperatingSystem os = info.getOperatingSystem();
    private final HardwareAbstractionLayer hardware = info.getHardware();

    /*
     * 初始CPU-TICKS
     */
    private final AtomicReference<long[]> ticksRef =
            new AtomicReference<>(hardware.getProcessor().getSystemCpuLoadTicks());

    // 计算CPU使用率
    private float[] calculateCpuUsage(CentralProcessor processor) {

        // 计算ticks
        final int length = TickType.values().length;
        final long[] bTicks = ticksRef.get();
        final long[] cTicks = processor.getSystemCpuLoadTicks();

        assert length == bTicks.length;
        assert length == cTicks.length;

        // 计算diff
        final long[] dTicks = new long[length];
        Arrays.stream(TickType.values())
                .mapToInt(TickType::getIndex)
                .forEach(index -> dTicks[index] = bTicks[index] - cTicks[index]);

        // 求和diff
        final long total = Arrays.stream(dTicks).sum();

        // 计算比率
        final float[] dRates = new float[length];
        Arrays.stream(TickType.values())
                .mapToInt(TickType::getIndex)
                .forEach(index -> dRates[index] = MathUtils.percent(dTicks[index], total));

        return dRates;
    }

    @Override
    public Usage.Cpu getCpu() {
        final CentralProcessor processor = hardware.getProcessor();
        final float[] usages = calculateCpuUsage(processor);
        final double[] loads = processor.getSystemLoadAverage(3);
        return new Usage.Cpu(
                usages[TickType.USER.getIndex()],
                usages[TickType.NICE.getIndex()],
                usages[TickType.SYSTEM.getIndex()],
                usages[TickType.IDLE.getIndex()],
                usages[TickType.IOWAIT.getIndex()],
                usages[TickType.IRQ.getIndex()],
                usages[TickType.SOFTIRQ.getIndex()],
                usages[TickType.STEAL.getIndex()],
                MathUtils.scale(loads[0]),
                MathUtils.scale(loads[1]),
                MathUtils.scale(loads[2]),
                processor.getContextSwitches(),
                processor.getInterrupts()
        );
    }

    @Override
    public Usage.Memory getMemory() {
        final GlobalMemory memory = hardware.getMemory();
        return new Usage.Memory(
                memory.getAvailable(),
                MathUtils.percent(memory.getAvailable(), memory.getTotal()),
                memory.getVirtualMemory().getSwapUsed(),
                MathUtils.percent(memory.getVirtualMemory().getSwapUsed(), memory.getVirtualMemory().getSwapTotal())
        );
    }

    @Override
    public Usage.Network[] getNetworks() {
        return hardware.getNetworkIFs().stream()
                .map(network ->
                        new Usage.Network(
                                network.getMacaddr(),
                                network.getName(),
                                network.getBytesRecv(),
                                network.getBytesSent(),
                                network.getPacketsRecv(),
                                network.getPacketsSent(),
                                network.getInDrops(),
                                network.getInErrors(),
                                network.getOutErrors()
                        )
                )
                .toArray(Usage.Network[]::new);
    }

    @Override
    public Usage.Power[] getPowers() {
        return hardware.getPowerSources().stream()
                .map(power ->
                        new Usage.Power(
                                power.getName(),
                                MathUtils.scale(power.getRemainingCapacityPercent())
                        )
                )
                .toArray(Usage.Power[]::new);
    }

    @Override
    public Usage.Store[] getStores() {
        return os.getFileSystem().getFileStores().stream()
                .map(store ->
                        new Usage.Store(
                                store.getMount(),
                                store.getUsableSpace(),
                                MathUtils.percent(store.getUsableSpace(), store.getTotalSpace())
                        )
                )
                .toArray(Usage.Store[]::new);
    }

}
