import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class xmlSaxParse {

  public static void main(String[] args) {
    //1、创建SAXParserFactory实例
    SAXParserFactory factory = SAXParserFactory.newInstance();
    try {
      //2、创建SAXParser实例
      SAXParser parser = factory.newSAXParser();
      //3、新建一个类SAXHandler继承DefaultHandler，重写其中的一些方法用来进行业务处理。再创建一个SAXHandler对象
      SAXHandler handler = new SAXHandler();
      //4、进行解析，传入SAXHandler对象作为解析xml的处理类
      parser.parse("books.xml", handler);

    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    } catch (SAXException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

