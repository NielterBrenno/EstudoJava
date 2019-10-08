package br.com.shrobo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.shrobo.dto.OpcionaisDTO;
import br.com.shrobo.dto.ShAtivacaoDTO;
import br.com.shrobo.service.ShAtivacaoService;
import io.swagger.annotations.Api;

@RestController
@Api(value = "/shAtivacao", description = "shAtivacao", produces = "application/json")
public class ShAtivacaoController {

	@Autowired
	private ShAtivacaoService shAtivacaoService;

	@GetMapping("/private/shAtivacao/all")
	public ResponseEntity<List<ShAtivacaoDTO>> getAllNames() {
		List<ShAtivacaoDTO> shAtivacao = new ArrayList<>();
		shAtivacaoService.getListAtivacao().forEach(f -> {
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
			dto.setAtivacao(f.getAtivacao());
			shAtivacao.add(dto);
		});
		return new ResponseEntity<List<ShAtivacaoDTO>>(shAtivacao, HttpStatus.OK);
	}
	
	@GetMapping("/private/shAtivacao/atualizacao")
	public ResponseEntity<String> atualiza() {
		return new ResponseEntity<String>(shAtivacaoService.executaAtualizacaoDeSerial(), HttpStatus.OK);
	}

}
