package xyz.xiaolinz.demo.builder.demo1;
/**
 * @author huangmuhong
 * @version 1.0.0
 * @date 2023/8/3
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
