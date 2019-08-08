package com.ssafy.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class NewsDAODOMImpl implements INewsDAO {

	private List<News> list;

	public List<News> getNewList(String url) {
		connectNews(url);

		return list;
	}

	public News search(int index) {
		return list.get(index);
	}

	private void connectNews(String url) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder parser = factory.newDocumentBuilder();

			Document doc = parser.parse(url);
			NodeList itemlist = doc.getElementsByTagName("item");

			list = new LinkedList<News>();

			String word;
			for (int i = 0, len = itemlist.getLength(); i < len; i++) {// location의 갯수만큼
				News n = new News();
				Node node = itemlist.item(i);
				for (Node child = node.getFirstChild(); child != null; child = child.getNextSibling()) {
					if (child.getNodeType() == Node.ELEMENT_NODE) {
						word = child.getTextContent();

						if (child.getNodeName().equals("title")) {
							n.setTitle(word);
						} else if (child.getNodeName().equals("link")) {
							n.setLink(word);
						} else if (child.getNodeName().equals("description")) {
							n.setDesc(word);
						}

					}
				}
				list.add(n);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
