package xyz.xiaolinz.demo.enjoy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 坐标
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/11/30
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Coordinates {

    private Integer x;

    private Integer y;
}
