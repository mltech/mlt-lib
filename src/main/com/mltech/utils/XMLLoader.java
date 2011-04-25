package com.mltech.utils;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLLoader {
	private XPath _xpath;
	private DocumentBuilder _loader;

	public XMLLoader() {
		XPathFactory xpfactory = XPathFactory.newInstance();
		_xpath = xpfactory.newXPath();
		DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();
		try {
			_loader = docfactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

	public Document parseFile(URL file) {
		Document document = null;
		try {
			document = _loader.parse(file.getFile());
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return document;
	}
}
