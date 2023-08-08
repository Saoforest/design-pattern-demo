package xyz.xiaolinz.demo.prototype.deepcopy.recursive;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * 促销活动
 * 
 *
 * @author huangmuhong
 * @date 2023/08/08
 */
@Data
public class PromotionEvent implements Cloneable {
  private String name;

  private Date startDate;

  private Date endDate;

  private List<PromotionRule> rules;

  @Override
  protected PromotionEvent clone() throws CloneNotSupportedException {
    final var clone = ((PromotionEvent) super.clone());

    // Date 默认实现了 Cloneable，可以直接调用以实现拷贝
    clone.setStartDate((Date) startDate.clone());
    clone.setEndDate((Date) endDate.clone());

    // rules 需要递归拷贝
    if (rules != null) {
      for (int i = 0; i < rules.size(); i++) {
        rules.add(i,rules.get(i).clone());
      }
    }
    return clone;
  }
}
