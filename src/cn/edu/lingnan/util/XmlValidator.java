package cn.edu.lingnan.util;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {
	
	public static boolean validate(String xsdPath,String xmlPath) {
		boolean flag = false;
		try {
			//1.����ģʽ����SchemaFactory
			SchemaFactory sf = SchemaFactory.newInstance
					("http://www.w3.org/2001/XMLSchema");
			//2.ͨ��XSD�ļ�����ģʽSchema
			File f = new File(xsdPath);
			Schema s = sf.newSchema(f);
			//3.��ģʽ������֤��Validator
			Validator v = s.newValidator();
			//4.ʹ����֤����֤XML�ļ�
			Source sc = new StreamSource(xmlPath);
			v.validate(sc);
			flag = true;
		} catch (SAXException e) {
			System.out.println("����Schemaʱʧ��");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("��֤XML�ļ�ʱʧ��");
			e.printStackTrace();
		}
		return flag;
	}
	
//	public static void main(String[] args) {
//		String xsdPath = "bin//database.conf.xsd";
//		String xmlPath = "bin//database.conf.xml";
//		if(XmlValidator.validate(xsdPath, xmlPath))
//			System.out.println("��֤�ɹ�");
//		else
//			System.out.println("��֤ʧ��");
//		
//	}

}
