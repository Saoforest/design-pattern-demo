package xyz.xiaolinz.demo.factory.simpleFactory;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 资源加载类
 *
 * <p>这里只是模拟，实际上应该是一个复杂的类，比如加载图片资源，加载音频资源等等
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/07/27
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

  private String url;
}
