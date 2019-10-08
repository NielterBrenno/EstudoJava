package br.com.shrobo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import br.com.shrobo.domain.ShAtivacao;
import br.com.shrobo.repository.ShAtivacaoRepository;
import br.com.shrobo.service.SHService;
import br.com.shrobo.service.ShAtivacaoService;

@Service
public class ShAtivacaoManager implements ShAtivacaoService{

    @Autowired
    private ShAtivacaoRepository repository;
    
	@Autowired
	private SHService shService;
	
	@Override
	public ShAtivacaoRepository getDAO() {
		return repository;
	}
	
	@Override
	public List<ShAtivacao> getListAtivacao(){
		List<ShAtivacao> shAtivacao = new ArrayList<>();
		try {
			repository.findAll().forEach(f -> {
				try {
					String ativacao = shService.getChave(f.getSerial(), f.getDtValidade(), f.getOpcionais());
					f.setAtivacao(ativacao);
					shAtivacao.add(f);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shAtivacao;
	}

	@Override
	@Async
	public String executaAtualizacaoDeSerial() {
		try {
			this.getListAtivacao().forEach(f -> {
				this.atualizaAtivacao(f.getAtivacao(), f.getCtrlId(), f.getMaquina());
			});
			return "Atualizacao realizada com sucesso !";
		}catch(Exception e) {
			return "Erro ao executar atualizacao !";
		}
	}
	
	private void atualizaAtivacao(String serial, Long id, Long maquinaId) {
		try {
			repository.atualizaAtivacao(serial, id, maquinaId);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}