import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SAXHandler extends DefaultHandler {
  int bookIndex = 0;

  /**
   * 开始解析xml文件
   */
  @Override
  public void startDocument() throws SAXException {
    super.startDocument();

    System.out.println("开始解析xml文件");
  }

  /**
   * 解析xml文件结束
   */
  @Override
  public void endDocument() throws SAXException {
    super.endDocument();

    System.out.println("解析xml文件结束");
  }

  /**
   * 开始解析xml元素
   */
  @Override
  public void startElement(String uri, String localName, String qName,
      Attributes attributes) throws SAXException {
    super.startElement(uri, localName, qName, attributes);

    //qName为标签名称
    if("book".equals(qName)) {
      bookIndex++;
      System.out.println("======开始解析第" + bookIndex + "本书======");

      //如果不知道标签的属性，则需要遍历Attributes分别获取属性名与属性值
      int len = attributes.getLength();
      System.out.println("book元素有" + len + "个属性");
      for(int i = 0; i < len; i++) {
        //通过Attributes.getQName(int index)获取属性名称
        System.out.print("获取book属性" + attributes.getQName(i));
        //通过Attributes.getValue(int index)获取属性值
        System.out.println("，属性值-->" + attributes.getValue(i));
      }
    } else if(!"books".equals(qName) && !"bookstore".equals(qName)) {
      System.out.print("解析到节点" + qName);
    }
  }

  /**
   * 解析xml元素结束
   */
  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(uri, localName, qName);

    if("book".equals(qName)) {
      System.out.println("======解析第" + bookIndex + "本书结束======");
    }
  }

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    super.characters(ch, start, length);
    //ch为整个xml文档的内容，start为当前标签内容所在位置，length为当前标签内容的长度
    //需要过滤掉空格和换行，SAX解析也会把空格和换行当做xml文档的内容
    String str = new String(ch, start, length);
    if(!"".equals(str.trim())) {
      System.out.println("-->节点值：" + str);
    }
  }
}
