package br.com.alura.forum.controller.dto.output;

import java.util.List;

import br.com.alura.forum.model.Category;

public class DashboardOutputDto {
	
	private String categoryName;
	private	List<Category> subcategories;
	private int allTopics;
	private int lastWeekTopics;
	private int unansweredTopics;

}