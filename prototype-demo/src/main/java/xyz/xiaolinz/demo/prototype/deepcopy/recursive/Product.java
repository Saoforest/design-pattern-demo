package xyz.xiaolinz.demo.prototype.deepcopy.recursive;

import lombok.Data;

/**
 * 产品
 *
 * @author huangmuhong
 * @date 2023/08/08
 */
@Data
public class Product implements Cloneable {
  private String name;

  private Double price;

  private Integer stock;

  @Override
  protected Product clone() throws CloneNotSupportedException {
    return ((Product) super.clone());
  }
}
