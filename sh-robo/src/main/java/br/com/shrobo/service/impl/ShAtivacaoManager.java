package br.com.shrobo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.shrobo.repository.ShAtivacaoRepository;
import br.com.shrobo.service.ShAtivacaoService;

@Service
public class ShAtivacaoManager implements ShAtivacaoService{

    @Autowired
    private ShAtivacaoRepository repository;
	
	@Override
	public ShAtivacaoRepository getDAO() {
		return repository;
	}
	
	
//	public List<ShAtivacao> getListAtivacao(){
//		List<ShAtivacao> ativacoes = new ArrayList<ShAtivacao>();
//		ativacoes = repository.findAll();
//		
//		Map<ShAtivacao, List<ShAtivacao>> postsPerType = ativacoes.stream()
//				  .collect(Collectors.groupingBy(ShAtivacao::serial));
//		
//		
//		
//		return ativacoes;
//	}
	
}