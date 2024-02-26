package xyz.xiaolinz.demo.state.tv;

/**
 * 状态设计模式 - 具体状态角色 - 只负责关闭行为
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 * @see TvState
 */
public class TvOffState implements TvState {
    @Override
    public void turnOn() {
        System.out.println("Turning on the TV.");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is already off.");
    }

    @Override
    public void adjustVolume(int volume) {
        System.out.println("Cannot adjust volume, TV is off.");
    }
}
