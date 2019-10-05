package br.com.shrobo.service;

import java.util.Date;
import java.util.List;

import br.com.shrobo.domain.Opcionais;

public interface SHService {
	
	public String getChave(String ESerial, Date EValidade, List<Opcionais> opcionais) throws Exception;
}
