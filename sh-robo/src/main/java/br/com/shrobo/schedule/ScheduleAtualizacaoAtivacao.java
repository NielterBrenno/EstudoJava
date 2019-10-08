package br.com.shrobo.schedule;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ScheduleAtualizacaoAtivacao {

	@Value("${url.atualizacao}")
	private String url;
	
	@Value("${server.port}")
	private String port;
	
	@Scheduled(fixedRateString = "${schedule.rate}")
	public void atualizaAtivacao() {
		final String uri = url.concat(":").concat(port.concat("/shrobo/private/shAtivacao/atualizacao"));
		System.out.println("INICIOU ATUALIZACAO ...............");
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
		System.out.println("FINZALIZOU ATUALIZACAO ............");
	}
}
