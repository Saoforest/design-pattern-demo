package xyz.xiaolinz.demo.builder.demo1;
/**
 * 文章 html 文档生成器 - 具体创建者
 *
 * <p>实现了抽象创建者定义的方法，完成产品的创建
 *
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/3
 */
public class ArticleHtmlDocumentBuilder extends AbstractHtmlDocumentBuilder {

  @Override
  public void buildHeader() {
    htmlDocument.setHeader("Article Header");
  }

  @Override
  public void buildBody() {
    htmlDocument.setBody("Article Body");
  }

  @Override
  public void buildFooter() {
    htmlDocument.setFooter("Article Footer");
  }
}
