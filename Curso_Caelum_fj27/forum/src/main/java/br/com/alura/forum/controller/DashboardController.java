package br.com.alura.forum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.forum.controller.dto.input.TopicSearchInputDto;
import br.com.alura.forum.controller.dto.output.DashboardOutputDto;
import br.com.alura.forum.controller.dto.output.TopicBriefOutputDto;
import br.com.alura.forum.model.topic.domain.Topic;
import br.com.alura.forum.repository.DashBoardRepository;
import br.com.alura.forum.repository.TopicRepository;

public class DashboardController {
	
	@Autowired
	private	DashBoardRepository	dashboardRepository;
	
	@GetMapping(value = "/api/topics/dashboard",	produces = MediaType.APPLICATION_JSON_VALUE)
	public	Page<DashboardOutputDto> listTopicsDashbord(@PageableDefault(sort="creationInstant",
		direction = Sort.Direction.DESC) Pageable pageRequest) {
		
		//Specification<Topic> topicSearchSpecification = topicSearch.build();
		Page<DashboardOutputDto> dashBoard = this.dashboardRepository);
		
		return	TopicBriefOutputDto.listFromTopics(topics);

	}


}
