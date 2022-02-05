package io.github.athingx.athing.aliyun.monitor.info;

import io.github.athingx.athing.standard.component.Identifier;

/**
 * 计算机信息
 */
public class Info {

    /**
     * 操作系统信息
     */
    public static class Os {

        /**
         * 操作系统厂商
         */
        private final String manufacturer;

        /**
         * 操作系统系列
         */
        private final String family;

        /**
         * 操作系统位数
         */
        private final int bit;

        /**
         * 操作系统版本
         */
        private final String version;

        public Os(String manufacturer, String family, int bit, String version) {
            this.manufacturer = manufacturer;
            this.family = family;
            this.bit = bit;
            this.version = version;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getFamily() {
            return family;
        }

        public int getBit() {
            return bit;
        }

        public String getVersion() {
            return version;
        }

    }

    /**
     * JVM信息
     */
    public static class Jvm {

        /**
         * JVM版本号
         */
        private final String version;

        /**
         * JVM路径
         */
        private final String home;

        /**
         * JVM允许被使用的最大内存(bytes)
         */
        private final long memoryMax;

        /**
         * JVM当前已使用内存(bytes)
         */
        private final long memoryUsed;

        /**
         * JVM当前未使用内存(bytes)
         */
        private final long memoryFree;


        public Jvm(String version, String home, long memoryMax, long memoryUsed, long memoryFree) {
            this.version = version;
            this.home = home;
            this.memoryMax = memoryMax;
            this.memoryUsed = memoryUsed;
            this.memoryFree = memoryFree;
        }

        public String getVersion() {
            return version;
        }

        public String getHome() {
            return home;
        }

        public long getMemoryMax() {
            return memoryMax;
        }

        public long getMemoryUsed() {
            return memoryUsed;
        }

        public long getMemoryFree() {
            return memoryFree;
        }

    }

    /**
     * 主板信息
     */
    public static class Baseboard {

        /**
         * 主板厂商
         */
        private final String manufacturer;

        /**
         * 主板型号
         */
        private final String model;

        /**
         * 主板版本
         */
        private final String version;

        /**
         * 主板序号
         */
        private final String serial;

        public Baseboard(String manufacturer, String model, String version, String serial) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.version = version;
            this.serial = serial;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public String getVersion() {
            return version;
        }

        public String getSerial() {
            return serial;
        }
    }

    /**
     * 设备信息
     */
    public static class Computer {

        /**
         * 设备厂商
         */
        private final String manufacturer;

        /**
         * 设备型号
         */
        private final String model;

        /**
         * 设备序列号
         */
        private final String serial;


        public Computer(String manufacturer, String model, String serial) {
            this.manufacturer = manufacturer;
            this.model = model;
            this.serial = serial;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getModel() {
            return model;
        }

        public String getSerial() {
            return serial;
        }
    }

    /**
     * 处理器信息
     */
    public static class Cpu {

        /**
         * CPU 标识信息
         */
        private final String identifier;

        /**
         * CPU ID
         */
        private final String processorID;

        /**
         * 逻辑核数
         */
        private final int logicCnt;

        /**
         * 物理核数
         */
        private final int phyCnt;

        /**
         * 物理芯片数
         */
        private final int phyPkgCnt;

        public Cpu(String identifier, String processorID, int logicCnt, int phyCnt, int phyPkgCnt) {
            this.identifier = identifier;
            this.processorID = processorID;
            this.logicCnt = logicCnt;
            this.phyCnt = phyCnt;
            this.phyPkgCnt = phyPkgCnt;
        }

        public String getIdentifier() {
            return identifier;
        }

        public String getProcessorID() {
            return processorID;
        }

        public int getLogicCnt() {
            return logicCnt;
        }

        public int getPhyCnt() {
            return phyCnt;
        }

        public int getPhyPkgCnt() {
            return phyPkgCnt;
        }

    }

    /**
     * 磁盘信息
     */
    public static class Disk {

        /**
         * 序列号
         */
        private final String serial;

        /**
         * 磁盘名称
         */
        private final String name;

        /**
         * 产品系列
         */
        private final String model;

        /**
         * 存储容量(bytes)
         */
        private final long size;

        public Disk(String serial, String name, String model, long size) {
            this.serial = serial;
            this.name = name;
            this.model = model;
            this.size = size;
        }

        public String getSerial() {
            return serial;
        }

        public String getName() {
            return name;
        }

        public String getModel() {
            return model;
        }

        public long getSize() {
            return size;
        }

    }

    /**
     * 固件信息
     */
    public static class Firmware {

        /**
         * 固件厂商
         */
        private final String manufacturer;

        /**
         * 固件名称
         */
        private final String name;

        /**
         * 固件版本
         */
        private final String version;

        /**
         * 固件描述
         */
        private final String description;

        public Firmware(String manufacturer, String name, String version, String description) {
            this.manufacturer = manufacturer;
            this.name = name;
            this.description = description;
            this.version = version;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String getVersion() {
            return version;
        }

    }

    /**
     * 内存信息
     */
    public static class Memory {

        /**
         * 物理内存容量
         */
        private final long phyCap;

        /**
         * 虚拟内存容量
         */
        private final long virCap;


        public Memory(long phyCap, long virCap) {
            this.phyCap = phyCap;
            this.virCap = virCap;
        }

        public long getPhyCap() {
            return phyCap;
        }

        public long getVirCap() {
            return virCap;
        }

    }

    /**
     * 电源信息
     */
    public static class Power {

        /**
         * 电源名称
         */
        private final String name;

        /**
         * 电源容量
         */
        private final int cap;

        /**
         * 容量单位
         */
        private final String unit;


        public Power(String name, int cap, String unit) {
            this.name = name;
            this.cap = cap;
            this.unit = unit;
        }

        public String getName() {
            return name;
        }

        public int getCap() {
            return cap;
        }

        public String getUnit() {
            return unit;
        }

    }

    /**
     * 网络信息
     */
    public static class Network {

        /**
         * 网卡名
         */
        private final String name;

        /**
         * Mac地址
         */
        private final String mac;

        /**
         * 最大传输单元(bytes)
         */
        private final long mtu;

        /**
         * 最大传输速率(bytes)
         */
        private final long speed;

        /**
         * IPv4地址列表
         */
        private final String[] ipv4s;

        /**
         * IPv6地址列表
         */
        private final String[] ipv6s;

        public Network(String name, String mac, long mtu, long speed, String[] ipv4s, String[] ipv6s) {
            this.name = name;
            this.mac = mac;
            this.mtu = mtu;
            this.speed = speed;
            this.ipv4s = ipv4s;
            this.ipv6s = ipv6s;
        }

        public String getName() {
            return name;
        }

        public String getMac() {
            return mac;
        }

        public long getMtu() {
            return mtu;
        }

        public long getSpeed() {
            return speed;
        }

        public String[] getIpv4s() {
            return ipv4s;
        }

        public String[] getIpv6s() {
            return ipv6s;
        }

    }

    /**
     * 存储信息
     */
    public static class Store {

        /**
         * 存储名称
         */
        private final String name;

        /**
         * 挂载点
         */
        private final String mount;

        /**
         * 存储格式
         */
        private final String format;

        /**
         * 可用容量(bytes)
         */
        private final long usable;

        /**
         * 整体容量(bytes)
         */
        private final long capacity;


        public Store(String name, String mount, String format, long usable, long capacity) {
            this.name = name;
            this.mount = mount;
            this.format = format;
            this.usable = usable;
            this.capacity = capacity;
        }

        public String getName() {
            return name;
        }

        public String getMount() {
            return mount;
        }

        public String getFormat() {
            return format;
        }

        public long getUsable() {
            return usable;
        }

        public long getCapacity() {
            return capacity;
        }

    }

    /**
     * 信息项
     */
    public enum Item {

        OS("os"),
        JVM("jvm"),
        COMPUTER("computer"),
        BASEBOARD("baseboard"),
        FIRMWARE("firmware"),
        MEMORY("memory"),
        CPU("cpu"),
        DISK("disks"),
        POWER("powers"),
        NETWORK("networks"),
        STORE("stores");

        private final Identifier identifier;

        Item(String propertyId) {
            this.identifier = Identifier.toIdentifier(InfoThingCom.THING_COM_ID, propertyId);
        }

        public Identifier getIdentifier() {
            return identifier;
        }

    }

}
