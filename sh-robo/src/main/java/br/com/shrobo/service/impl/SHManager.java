package br.com.shrobo.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import com.sun.jna.Native;

import br.com.shrobo.domain.Opcionais;
import br.com.shrobo.service.SHService;

@Service
@RequestScope
public class SHManager implements SHService {
	
	private final SHdll dll = Native.loadLibrary("C:\\wba\\api\\config\\application\\dll\\SHdll.dll", SHdll.class);
	private final String secret1 = "gutinho@conseguiu@na@gambi";
	private final String secret2 = "mortal#da#mesa#hailton#fera";
	private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private byte[] ativos1 = new byte[32];
	private byte[] ativos2 = new byte[16];
	
	@Override
	public String getChave(String ESerial, Date EValidade, List<Opcionais> opcionais) throws Exception {
		String chave = "";
		String chaveok = "";
		
		for (Opcionais opcional : opcionais) {
			setAtivo(opcional.getCodigoModulo(), true);
		}
		
		String m1 = String.valueOf(getAtivos(ativos1));
		String m2 = String.valueOf(getAtivos(ativos2));
		
		for (int i = 0; i <= 23; i++) {
			chave += dll.getChaveIndex(secret1, secret2, ESerial, sdf.format(EValidade), m1, m2, i);
		}
		
		chaveok += chave.substring(14, 16) + chave.substring(4, 6) + "-";
		chaveok += chave.substring(20, 22) + chave.substring(18, 20) + "-";
		chaveok += chave.substring(10, 12) + chave.substring(0, 2) + "-";
		chaveok += chave.substring(2, 4) + chave.substring(12, 14) + "-";
		chaveok += chave.substring(22, 24) + chave.substring(8, 10) + "-";
		chaveok += chave.substring(6, 8) + chave.substring(16, 18);
		
		return chaveok;
	};
	
	public long getAtivos(byte[] array) {
		String bin = "";
		
		for (int i = array.length - 1; i >= 0; i--)
			bin += String.valueOf(array[i]);
		
		return Long.parseLong(bin, 2);
	}
	
	public void setAtivo(int index, boolean ativo) throws Exception {
		if (index < 32)
			ativos1[index] = (byte) (ativo ? 1 : 0);
		else if(index < 48)
			ativos2[index - 32] = (byte) (ativo ? 1 : 0);
		else
			throw new Exception("Modulo com codigo superior a 47");
	}
}