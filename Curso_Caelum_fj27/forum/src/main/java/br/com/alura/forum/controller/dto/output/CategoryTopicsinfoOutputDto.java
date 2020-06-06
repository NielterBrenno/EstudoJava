package br.com.alura.forum.controller.dto.output;

import java.util.List;

import br.com.alura.forum.model.Category;
import br.com.alura.forum.model.topic.domain.Topic;

public class CategoryTopicsinfoOutputDto {
	
	private String categoryName;
	private	List<String> subcategories;
	private long allTopics;
	private long lastWeekTopics;	
	private long unansweredTopics;
	
	
	public	CategoryTopicsinfoOutputDto(Category category, List<Topic> topics) {
		this.categoryName =	category.getName();
		this.subcategories	=	category.getSubcategoryNames();
		this.allTopics	=	topics.size();
		this.lastWeekTopics	=	topics.stream().filter(topic -> topic.isOneWeekOld()).count();
		this.unansweredTopics	=	topics.stream().filter(topic -> topic.isUnanswered()).count();
	}

	public	static	List<CategoryTopicsinfoOutputDto> listFromDashboard(List<CategoryTopicsinfoOutputDto> dashboard) {
		return	null;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<String> getSubcategories() {
		return subcategories;
	}

	public void setSubcategories(List<String> subcategories) {
		this.subcategories = subcategories;
	}

	public long getAllTopics() {
		return allTopics;
	}

	public void setAllTopics(long allTopics) {
		this.allTopics = allTopics;
	}

	public long getLastWeekTopics() {
		return lastWeekTopics;
	}

	public void setLastWeekTopics(long lastWeekTopics) {
		this.lastWeekTopics = lastWeekTopics;
	}

	public long getUnansweredTopics() {
		return unansweredTopics;
	}

	public void setUnansweredTopics(long unansweredTopics) {
		this.unansweredTopics = unansweredTopics;
	}



}
