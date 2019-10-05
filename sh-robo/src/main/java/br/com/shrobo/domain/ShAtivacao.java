package br.com.shrobo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "sh_vw_ativacao")
public class ShAtivacao implements Serializable {

	private static final long serialVersionUID = 8314723755571216287L;

	@Id
	private Long maquina;
	@Column(name = "sig_cad_id")
	private Long sigCad;
	@Column(name = "serial")
	private String serial;
	@Column(name = "dt_validade")
	private Date dtValidade;

	@OneToMany(mappedBy = "shAtivacao", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Opcionais> opcionais;

	@Transient
	private String ativacao;

	public Long getMaquina() {
		return maquina;
	}

	public void setMaquina(Long maquina) {
		this.maquina = maquina;
	}

	public Long getSigCad() {
		return sigCad;
	}

	public void setSigCad(Long sigCad) {
		this.sigCad = sigCad;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Date getDtValidade() {
		return dtValidade;
	}

	public void setDtValidade(Date dtValidade) {
		this.dtValidade = dtValidade;
	}

	public List<Opcionais> getOpcionais() {
		return opcionais;
	}

	public void setOpcionais(List<Opcionais> opcionais) {
		this.opcionais = opcionais;
	}

	public String getAtivacao() {
		return ativacao;
	}

	public void setAtivacao(String ativacao) {
		this.ativacao = ativacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ativacao == null) ? 0 : ativacao.hashCode());
		result = prime * result + ((dtValidade == null) ? 0 : dtValidade.hashCode());
		result = prime * result + ((maquina == null) ? 0 : maquina.hashCode());
		result = prime * result + ((opcionais == null) ? 0 : opcionais.hashCode());
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		result = prime * result + ((sigCad == null) ? 0 : sigCad.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShAtivacao other = (ShAtivacao) obj;
		if (ativacao == null) {
			if (other.ativacao != null)
				return false;
		} else if (!ativacao.equals(other.ativacao))
			return false;
		if (dtValidade == null) {
			if (other.dtValidade != null)
				return false;
		} else if (!dtValidade.equals(other.dtValidade))
			return false;
		if (maquina == null) {
			if (other.maquina != null)
				return false;
		} else if (!maquina.equals(other.maquina))
			return false;
		if (opcionais == null) {
			if (other.opcionais != null)
				return false;
		} else if (!opcionais.equals(other.opcionais))
			return false;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		if (sigCad == null) {
			if (other.sigCad != null)
				return false;
		} else if (!sigCad.equals(other.sigCad))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ShAtivacao [maquina=" + maquina + ", sigCad=" + sigCad + ", serial=" + serial + ", dtValidade="
				+ dtValidade + ", opcionais=" + opcionais + ", ativacao=" + ativacao + "]";
	}

}
