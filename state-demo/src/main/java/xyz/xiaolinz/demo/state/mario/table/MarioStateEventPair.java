package xyz.xiaolinz.demo.state.mario.table;

import xyz.xiaolinz.demo.state.mario.MarioEvent;
import xyz.xiaolinz.demo.state.mario.MarioState;

/**
 * 马里奥状态事件对 - 存储状态转移表的键
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2024/02/26
 */
public record MarioStateEventPair(MarioState state, MarioEvent event) {

}
