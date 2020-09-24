package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class XmlParser {
	
	public static HashMap<String,String> parser(String xmlPath) {
		HashMap<String,String> hm = new HashMap<String,String>();
		try {
			//1.实例化一个SAXParserFactory对象
			SAXParserFactory factory = SAXParserFactory.newInstance();
			//2.通过factory获得一个SAXParser对象，即SAX解析器
			SAXParser saxParser;
			saxParser = factory.newSAXParser();
			//3.saxParser对象调用parser方法解析XML文件
			File f = new File(xmlPath);
			XmlHandler xh = new XmlHandler();
			saxParser.parse(f, xh);
			hm = xh.getHashMap();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hm;
	}
	
//	public static void main(String[] args) {
//		String xmlPath = "bin//database.conf.xml";
//		HashMap<String,String> hm = XmlParser.parser(xmlPath);
//		System.out.println(hm.get("driver"));
//		System.out.println(hm.get("url"));
//		System.out.println(hm.get("user"));
//		System.out.println(hm.get("password"));
//	}
	
}
