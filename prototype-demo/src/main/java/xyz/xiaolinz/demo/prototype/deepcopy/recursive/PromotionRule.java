package xyz.xiaolinz.demo.prototype.deepcopy.recursive;

import lombok.Data;

/**
 * 促销规则
 *
 * @author huangmuhong
 * @date 2023/08/08
 * @see Cloneable
 */
@Data
public class PromotionRule implements Cloneable {
  private String type;

  private Double discount;

  private Product product;

  @Override
  protected PromotionRule clone() throws CloneNotSupportedException {
    final var promotionRule = (PromotionRule) super.clone();

    // 在这里，我们需要将product也进行深拷贝
    promotionRule.setProduct(product.clone());
    return promotionRule;
  }
}
