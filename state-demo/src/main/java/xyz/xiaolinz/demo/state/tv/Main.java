package xyz.xiaolinz.demo.state.tv;

/**
 * @author huangmuhong
 * @date 2024/2/26
 */
public class Main {
    public static void main(String[] args) {
        TvContext context = new TvContext();
        context.turnOn();
        context.turnOn();
        context.adjustVolume(10);
        context.turnOff();
        context.turnOff();
    }
}
