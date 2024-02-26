package xyz.xiaolinz.demo.state.tv;

import java.util.Map;
import lombok.AllArgsConstructor;

/**
 * 状态设计模式 - 环境角色 - 维护状态
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 */
public class TvContext {

    private final Map<TvStateEnum, TvState> stateMap =
        Map.of(TvStateEnum.ON, new TvOnState(), TvStateEnum.OFF, new TvOffState());

    private TvState tvState;

    /**
     * 设置电视状态
     *
     * @param type 类型
     * @author huangmuhong
     * @date 2024/02/26
     * @since 1.0.0
     */
    public void setTvState(TvStateEnum type) {
        this.tvState = stateMap.get(type);
    }

    public TvContext() {
        this.tvState = stateMap.get(TvStateEnum.OFF);
    }

    /**
     * 打开
     *
     * @author huangmuhong
     * @date 2024/02/26
     * @since 1.0.0
     */
    public void turnOn() {
        tvState.turnOn();
        tvState = stateMap.get(TvStateEnum.ON);
    }

    /**
     * 关
     *
     * @return void
     * @date 2024/02/26
     * @since 1.0.0
     */
    public void turnOff() {
        tvState.turnOff();
        tvState = stateMap.get(TvStateEnum.OFF);
    }

    /**
     * 调节音量
     *
     * @param volume 体积
     * @return void
     * @date 2024/02/26
     * @since 1.0.0
     */
    public void adjustVolume(int volume) {
        tvState.adjustVolume(volume);
    }

    /**
     * 电视状态枚举
     *
     * @author huangmuhong
     * @version 1.0.0
     * @date 2024/02/26
     * @see Enum
     */
    @AllArgsConstructor
    public static enum TvStateEnum {

        /**
         * 开
         */
        ON,

        /**
         * 关
         */
        OFF;

    }
}
