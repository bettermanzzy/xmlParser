/*
   DOM Parse XML document
   author Zhongyuan Zhou;
 */
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class xmlDomParse {

    public static void main(String[] args) throws Exception {

        //创建解析器工厂实例，并生成解析器
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        //创建文件对象流
        File fptr = new File("books.xml");
        //解析文档，并返回一个Dom对象，此时xml文档已加载到内存中
        Document doc = builder.parse(fptr);

        //获取文档根元素
        Element root = doc.getDocumentElement();

        //获取根元素子节点列表
        NodeList listNode = root.getChildNodes();

        //开始遍历子节点列表
        for ( int i = 1;i<listNode.getLength();i++){
            System.out.println("*******************");
            Node n = listNode.item(i);
            //输出子节点的文本值
            for (int x = 1; x < n.getChildNodes().getLength();x++){
                Node childNode = n.getChildNodes().item(x);
                System.out.println(childNode.getNodeName() + ":" + childNode.getTextContent());
                if (childNode.hasAttributes()) {
                    System.out.println(
                        childNode.getAttributes().item(0).getNodeName() + ":" + childNode.getAttributes().item(0)
                            .getNodeValue());
                }
                x = x + 1;
            }
            //输出对象中的属性值
            NamedNodeMap node = n.getAttributes();
            for (int j = 0; j < node.getLength(); j++) {
                Node nn = node.item(j);
                System.out.println(nn.getNodeName() + ": " + nn.getNodeValue());
            }
            i++;
        }
    }
}