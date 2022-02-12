package io.github.athingx.athing.thing.monitor.general.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 科学计算工具类
 */
public class MathUtils {

    /**
     * 计算百分率
     *
     * @param numerator   分子
     * @param denominator 分母
     * @return 百分率
     */
    public static float percent(double numerator, double denominator) {
        if (0 == denominator) {
            return 0;
        }
        return BigDecimal.valueOf(100d * numerator / denominator)
                .setScale(2, RoundingMode.HALF_UP)
                .floatValue();
    }


    /**
     * 对分数精度进行四舍五入修正，保留小数点后两位
     *
     * @param fraction 分数
     * @return 精度修正值
     */
    public static float scale(float fraction) {
        return BigDecimal.valueOf(fraction)
                .setScale(2, RoundingMode.HALF_UP)
                .floatValue();
    }

    /**
     * 对分数精度进行四舍五入修正，保留小数点后两位
     *
     * @param fraction 分数
     * @return 精度修正值
     */
    public static float scale(double fraction) {
        return BigDecimal.valueOf(fraction)
                .setScale(2, RoundingMode.HALF_UP)
                .floatValue();
    }

}
