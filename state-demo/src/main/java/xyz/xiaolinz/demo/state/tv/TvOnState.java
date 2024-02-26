package xyz.xiaolinz.demo.state.tv;

/**
 * 状态设计模式 - 具体状态角色 - 只负责打开行为
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 * @see TvState
 */
public class TvOnState implements TvState {
    @Override
    public void turnOn() {
        System.out.println("TV is already on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the TV.");
    }

    @Override
    public void adjustVolume(int volume) {
        System.out.println("Adjusting volume to: " + volume);
    }
}
