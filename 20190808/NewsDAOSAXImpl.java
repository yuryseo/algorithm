package com.ssafy.news;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class NewsDAOSAXImpl implements INewsDAO {
	private List<News> list;

	class SAXHandler extends DefaultHandler {

		private boolean flag;
		private News n;
		private String data;

		public SAXHandler() {
			list = new LinkedList<News>();
		}

		public List<News> getNews() {
			return list;
		}

		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			if (qName.equals("item")) {
				n = new News("", "", "");
				list.add(n);
			}

		}

		@Override
		public void characters(char[] ch, int start, int length) throws SAXException {

			data = new String(ch, start, length);
		}

		@Override
		public void endElement(String uri, String localName, String qName) throws SAXException {
			if (n != null) {
				if (qName.equals("title")) {
					n.setTitle(data);
				} else if (qName.equals("link")) {
					n.setLink(data);
				} else if (qName.equals("description")) {
					n.setDesc(data);
				}
			}
		}

	}

	public List<News> getNewList(String url) {

		connectNews(url);
		return list;
	}

	@Override
	public News search(int index) {

		return list.get(index);
	}

	private void connectNews(String url) {

		try {
			SAXParserFactory fac = SAXParserFactory.newInstance();
			SAXParser parser = fac.newSAXParser();
			SAXHandler handler = new SAXHandler();
			parser.parse(url, handler);
			// return handler.getNews();

		} catch (Exception e) {
			e.printStackTrace();
		}

		// return null;

	}
}
