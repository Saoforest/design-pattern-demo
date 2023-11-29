package xyz.xiaolinz.demo.builder.demo1;

/**
 * 指挥者（Director）类 - HtmlDirector
 *
 * @author huangmuhong
 * @date 2023/11/23
 * @version 1.0.0
 *
 */
public class HtmlDirector {

  private final AbstractHtmlDocumentBuilder htmlDocumentBuilder;

  public HtmlDirector(AbstractHtmlDocumentBuilder htmlDocumentBuilder) {
    this.htmlDocumentBuilder = htmlDocumentBuilder;
  }

  public HtmlDocument construct() {
    htmlDocumentBuilder.createHtmlDocument();
    htmlDocumentBuilder.buildHeader();
    htmlDocumentBuilder.buildBody();
    htmlDocumentBuilder.buildFooter();
    return htmlDocumentBuilder.getHtmlDocument();
  }

  public HtmlDocument getDocument() {
    return htmlDocumentBuilder.getHtmlDocument();
  }

}
