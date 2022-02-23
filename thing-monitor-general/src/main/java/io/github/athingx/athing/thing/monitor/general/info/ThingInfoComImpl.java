package io.github.athingx.athing.thing.monitor.general.info;

import io.github.athingx.athing.thing.monitor.info.Info;
import io.github.athingx.athing.thing.monitor.info.ThingInfoCom;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.OperatingSystem;

import java.util.Arrays;

public class ThingInfoComImpl implements ThingInfoCom {

    private final SystemInfo info = new SystemInfo();
    private final OperatingSystem os = info.getOperatingSystem();
    private final HardwareAbstractionLayer hardware = info.getHardware();

    @Override
    public Info.Os getOs() {
        return new Info.Os(
                os.getManufacturer(),
                os.getFamily(),
                os.getBitness(),
                os.getVersionInfo().toString()
        );
    }

    @Override
    public Info.Jvm getJvm() {
        return new Info.Jvm(
                System.getProperty("java.version"),
                System.getProperty("java.home"),
                Runtime.getRuntime().maxMemory(),
                Runtime.getRuntime().totalMemory(),
                Runtime.getRuntime().freeMemory()
        );
    }

    @Override
    public Info.Computer getComputer() {
        final ComputerSystem system = hardware.getComputerSystem();
        return new Info.Computer(
                system.getManufacturer(),
                system.getModel(),
                system.getSerialNumber()
        );
    }

    @Override
    public Info.Baseboard getBaseboard() {
        final Baseboard baseboard = hardware.getComputerSystem().getBaseboard();
        return new Info.Baseboard(
                baseboard.getManufacturer(),
                baseboard.getModel(),
                baseboard.getVersion(),
                baseboard.getSerialNumber()
        );
    }

    @Override
    public Info.Firmware getFirmware() {
        final Firmware firmware = hardware.getComputerSystem().getFirmware();
        return new Info.Firmware(
                firmware.getManufacturer(),
                firmware.getName(),
                firmware.getVersion(),
                firmware.getDescription()
        );
    }

    @Override
    public Info.Cpu getCpu() {
        final CentralProcessor processor = hardware.getProcessor();
        return new Info.Cpu(
                processor.getProcessorIdentifier().getIdentifier(),
                processor.getProcessorIdentifier().getProcessorID(),
                processor.getLogicalProcessorCount(),
                processor.getPhysicalProcessorCount(),
                processor.getPhysicalPackageCount()
        );
    }

    @Override
    public Info.Memory getMemory() {
        final GlobalMemory memory = hardware.getMemory();
        return new Info.Memory(
                memory.getPhysicalMemory().stream().mapToLong(PhysicalMemory::getCapacity).sum(),
                memory.getVirtualMemory().getSwapTotal()
        );
    }

    @Override
    public Info.Disk[] getDisks() {
        return hardware.getDiskStores().stream()
                .map(disk ->
                        new Info.Disk(
                                disk.getSerial(),
                                disk.getName(),
                                disk.getModel(),
                                disk.getSize()
                        )
                )
                .toArray(Info.Disk[]::new);
    }

    // 计算一个网络的IP地址，包含掩码
    private String[] computeIPv4s(NetworkIF network) {
        final String[] ips = network.getIPv4addr();
        final Short[] masks = network.getSubnetMasks();
        assert ips.length == masks.length;
        final String[] ipv4s = new String[ips.length];
        Arrays.setAll(ipv4s, index -> String.format("%s/%s", ips[index], masks[index]));
        return ipv4s;
    }

    @Override
    public Info.Network[] getNetworks() {
        return hardware.getNetworkIFs().stream()
                .map(network ->
                        new Info.Network(
                                network.getName(),
                                network.getMacaddr(),
                                network.getMTU(),
                                network.getSpeed(),
                                computeIPv4s(network),
                                network.getIPv6addr()
                        )
                )
                .toArray(Info.Network[]::new);
    }

    @Override
    public Info.Power[] getPowers() {
        return hardware.getPowerSources().stream()
                .map(power ->
                        new Info.Power(
                                power.getName(),
                                power.getMaxCapacity(),
                                power.getCapacityUnits().name()
                        )
                )
                .toArray(Info.Power[]::new);
    }

    @Override
    public Info.Store[] getStores() {
        return os.getFileSystem().getFileStores().stream()
                .map(store ->
                        new Info.Store(
                                store.getName(),
                                store.getMount(),
                                store.getType(),
                                store.getUsableSpace(),
                                store.getTotalSpace()
                        )
                )
                .toArray(Info.Store[]::new);
    }

}
