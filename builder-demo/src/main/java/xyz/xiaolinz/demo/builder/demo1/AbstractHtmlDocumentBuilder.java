package xyz.xiaolinz.demo.builder.demo1;

import lombok.Getter;

/**
 * 抽象 html 文档生成器 - 抽象创建者
 *
 * <p>定义了创建产品的抽象方法
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/3
 */
@Getter
public abstract class AbstractHtmlDocumentBuilder {

  protected HtmlDocument htmlDocument;

  public void createHtmlDocument() {
    htmlDocument = new HtmlDocument();
  }

  public abstract void buildHeader();

  public abstract void buildBody();

  public abstract void buildFooter();

}
