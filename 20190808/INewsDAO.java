package com.ssafy.news;

import java.util.List;

public interface INewsDAO {

	public List<News> getNewList(String url);

	public News search(int index);
}
