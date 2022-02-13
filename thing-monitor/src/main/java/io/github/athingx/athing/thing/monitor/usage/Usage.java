package io.github.athingx.athing.thing.monitor.usage;

import io.github.athingx.athing.standard.component.Identifier;

public class Usage {

    /**
     * CPU使用率
     */
    public static class Cpu {

        /**
         * 使用率: user(%)
         */
        private final float user;

        /**
         * 使用率: nice(%)
         */
        private final float nice;

        /**
         * 使用率: system(%)
         */
        private final float system;

        /**
         * 使用率: idle(%)
         */
        private final float idle;

        /**
         * 使用率: iowait(%)
         */
        private final float iowait;

        /**
         * 使用率: irq(%)
         */
        private final float irq;

        /**
         * 使用率: soft-irq(%)
         */
        private final float sirq;

        /**
         * 使用率: steal(%)
         */
        private final float steal;

        /**
         * LOAD系列：1
         */
        private final float load01;

        /**
         * LOAD系列：5
         */
        private final float load05;

        /**
         * LOAD系列：15
         */
        private final float load15;

        /**
         * 上下文切换次数
         */
        private final long cs;

        /**
         * 中断发生次数
         */
        private final long interrupts;

        public Cpu(float user,
                   float nice,
                   float system,
                   float idle,
                   float iowait,
                   float irq,
                   float sirq,
                   float steal,
                   float load01,
                   float load05,
                   float load15,
                   long cs,
                   long interrupts) {
            this.user = user;
            this.nice = nice;
            this.system = system;
            this.idle = idle;
            this.iowait = iowait;
            this.irq = irq;
            this.sirq = sirq;
            this.steal = steal;
            this.load01 = load01;
            this.load05 = load05;
            this.load15 = load15;
            this.cs = cs;
            this.interrupts = interrupts;
        }

        public float getUser() {
            return user;
        }

        public float getNice() {
            return nice;
        }

        public float getSystem() {
            return system;
        }

        public float getIdle() {
            return idle;
        }

        public float getIowait() {
            return iowait;
        }

        public float getIrq() {
            return irq;
        }

        public float getSirq() {
            return sirq;
        }

        public float getSteal() {
            return steal;
        }

        public float getLoad01() {
            return load01;
        }

        public float getLoad05() {
            return load05;
        }

        public float getLoad15() {
            return load15;
        }

        public long getCs() {
            return cs;
        }

        public long getInterrupts() {
            return interrupts;
        }

    }

    /**
     * 内存使用率
     */
    public static class Memory {

        /**
         * 内存可用容量(bytes)
         * phyUsable
         */
        private final long usable;

        /**
         * 内存可用率(%)
         */
        private final float usableRate;

        /**
         * 交换分区已用容量(bytes)
         */
        private final long swapUsed;

        /**
         * 交换分区使用率(%)
         */
        private final float swapUseRate;

        public Memory(long usable, float usableRate, long swapUsed, float swapUseRate) {
            this.usable = usable;
            this.usableRate = usableRate;
            this.swapUsed = swapUsed;
            this.swapUseRate = swapUseRate;
        }

        public long getUsable() {
            return usable;
        }

        public float getUsableRate() {
            return usableRate;
        }

        public long getSwapUsed() {
            return swapUsed;
        }

        public float getSwapUseRate() {
            return swapUseRate;
        }

    }

    /**
     * 网络使用率
     */
    public static class Network {

        /**
         * Mac地址
         */
        private final String mac;

        /**
         * 网络名称
         */
        private final String name;

        /**
         * 已接收(bytes)
         */
        private final long recv;

        /**
         * 已发送(bytes)
         */
        private final long sent;

        /**
         * 已接收包
         */
        private final long recvPkt;

        /**
         * 已发送包
         */
        private final long sentPkt;

        /**
         * 收包丢包数量
         */
        private final long inDropPkt;

        /**
         * 收包错误数量
         */
        private final long inErrPkt;

        /**
         * 发包错误数量
         */
        private final long outErrPkt;


        public Network(String mac,
                       String name,
                       long recv,
                       long sent,
                       long recvPkt,
                       long sentPkt,
                       long inDropPkt,
                       long inErrPkt,
                       long outErrPkt) {
            this.mac = mac;
            this.name = name;
            this.recv = recv;
            this.sent = sent;
            this.recvPkt = recvPkt;
            this.sentPkt = sentPkt;
            this.inDropPkt = inDropPkt;
            this.inErrPkt = inErrPkt;
            this.outErrPkt = outErrPkt;
        }

        public String getMac() {
            return mac;
        }

        public String getName() {
            return name;
        }

        public long getRecv() {
            return recv;
        }

        public long getSent() {
            return sent;
        }

        public long getRecvPkt() {
            return recvPkt;
        }

        public long getSentPkt() {
            return sentPkt;
        }

        public long getInDropPkt() {
            return inDropPkt;
        }

        public long getInErrPkt() {
            return inErrPkt;
        }

        public long getOutErrPkt() {
            return outErrPkt;
        }

    }

    /**
     * 电源使用率
     */
    public static class Power {

        /**
         * 电源名
         */
        private final String name;

        /**
         * 剩余电量比率(%)
         */
        private final float remainingRate;

        public Power(String name, float remainingRate) {
            this.name = name;
            this.remainingRate = remainingRate;
        }

        public String getName() {
            return name;
        }

        public float getRemainingRate() {
            return remainingRate;
        }

    }

    /**
     * 存储使用率
     */
    public static class Store {

        /**
         * 挂载点
         */
        private final String mount;

        /**
         * 可用空间(bytes)
         */
        private final long usable;

        /**
         * 可用率(%)
         */
        private final float usableRate;

        public Store(String mount, long usable, float usableRate) {
            this.mount = mount;
            this.usable = usable;
            this.usableRate = usableRate;
        }

        public String getMount() {
            return mount;
        }

        public long getUsable() {
            return usable;
        }

        public float getUsableRate() {
            return usableRate;
        }

    }

    /**
     * 使用率项目
     */
    public enum Item {

        CPU("cpu"),
        MEMORY("memory"),
        POWER("powers"),
        NETWORK("networks"),
        STORE("stores");

        private final Identifier identifier;

        Item(String propertyId) {
            this.identifier = Identifier.toIdentifier(ThingUsageCom.THING_COM_ID, propertyId);
        }

        public Identifier getIdentifier() {
            return identifier;
        }

    }
}
