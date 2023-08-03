package xyz.xiaolinz.demo.builder.demo2;

import lombok.Getter;
import lombok.Setter;

/**
 * 在我们的 demo1 中，我们的使用的创建者模式是标准的，需要通过抽象创建者、具体创建者、产品角色三个角色来完成。
 * 但是我们在实际的开发中，往往会将抽象创建者和具体创建者合并成一个角色，这样做的好处是可以减少类的数量，但是缺点是不符合设计原则。
 * 但是一切脱离实际的设计模式都是耍流氓，所以我们在这里也给出了一个合并后的创建者模式的 demo。 该例子通过构造函数传入参数，然后通过静态内部类创建对象，最后通过 build 方法返回对象。
 * 实现了不可变对象，且防止了并发问题。
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/3
 */
@Getter
@Setter
public class HtmlDocument {
  private String header = "";
  private String body = "";
  private String footer = "";

  // 私有化构造函数，防止外部创建对象,且只能通过 Builder 创建对象
  // 这样子可以防止并发问题，防止对象创建不完整
  private HtmlDocument(Builder builder) {
    this.header = builder.header;
    this.body = builder.body;
    this.footer = builder.footer;
  }

  // 内部静态类，用于创建对象
  // 且拷贝了外部类的属性，防止并发问题
  public static class Builder {
    private String header = "";
    private String body = "";
    private String footer = "";

    public Builder header(String header) {
      this.header = header;
      return this;
    }

    public Builder body(String body) {
      this.body = body;
      return this;
    }

    public Builder footer(String footer) {
      this.footer = footer;
      return this;
    }

    public HtmlDocument build() {
      HtmlDocument htmlDocument = new HtmlDocument(this);

      return htmlDocument;
    }
  }
}
