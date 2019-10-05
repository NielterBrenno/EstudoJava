package br.com.shrobo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shrobo.domain.exception.ShAtivacaoException;
import br.com.shrobo.dto.OpcionaisDTO;
import br.com.shrobo.dto.ShAtivacaoDTO;
import br.com.shrobo.service.SHService;
import br.com.shrobo.service.ShAtivacaoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "/shAtivacao", description = "shAtivacao", produces = "application/json")
public class ShAtivacaoController {

	@Autowired
	private ShAtivacaoService shAtivacaoService;
	
	@Autowired
	private SHService shService;

	@GetMapping("/private/shAtivacao/all")
	public ResponseEntity<List<ShAtivacaoDTO>> getAllNames() {
		List<ShAtivacaoDTO> shAtivacao = new ArrayList<>();
		try {
			shAtivacaoService.findAll().forEach(f -> {
				final ShAtivacaoDTO dto = new ShAtivacaoDTO();
				List<OpcionaisDTO> listOpcionais = new ArrayList<>();
				
				dto.setMaquina(f.getMaquina());
				dto.setSerial(f.getSerial());
				dto.setSigCad(f.getSigCad());
				dto.setDtValidade(f.getDtValidade());
				
				f.getOpcionais().forEach(o -> {
					final OpcionaisDTO oDto = new OpcionaisDTO();
					oDto.setCodigoModulo(o.getCodigoModulo());
					oDto.setId(o.getId());
					listOpcionais.add(oDto);
				});
				dto.setOpcionais(listOpcionais);
				
				try {
					String ativacao = shService.getChave(dto.getSerial(), dto.getDtValidade(), f.getOpcionais());
					dto.setAtivacao(ativacao);
				} catch (Exception e) {
					e.printStackTrace();
				}
				shAtivacao.add(dto);
			});
		} catch (ShAtivacaoException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<ShAtivacaoDTO>>(shAtivacao, HttpStatus.OK);
	}

}
