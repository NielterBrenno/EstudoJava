package br.com.shrobo.service;

import br.com.shrobo.domain.ShAtivacao;
import br.com.shrobo.domain.exception.ShAtivacaoException;
import br.com.shrobo.repository.ShAtivacaoRepository;

public interface ShAtivacaoService extends PersistenceService<ShAtivacao, Long, ShAtivacaoException, ShAtivacaoRepository> {

}
