package xyz.xiaolinz.demo.state.tv;

/**
 * 状态设计模式 - 抽象状态角色
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 */
public interface TvState {

    /**
     * 打开
     *
     * @author huangmuhong
     * @date 2024/02/26
     * @since 1.0.0
     */
    void turnOn();

    /**
     * 关
     *
     * @author huangmuhong
     * @date 2024/02/26
     * @since 1.0.0
     */
    void turnOff();

    /**
     * 调节音量
     *
     * @param volume 体积
     * @author huangmuhong
     * @date 2024/02/26
     * @since 1.0.0
     */
    void adjustVolume(int volume);

}
