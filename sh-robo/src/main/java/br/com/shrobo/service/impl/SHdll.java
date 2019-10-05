package br.com.shrobo.service.impl;

import com.sun.jna.Library;

public interface SHdll extends Library {

	public String getChaveIndex(String ESecret1, String ESecret2, String ESerial, String EValidade, String EModulos,
			String EModulos2, int index);
}