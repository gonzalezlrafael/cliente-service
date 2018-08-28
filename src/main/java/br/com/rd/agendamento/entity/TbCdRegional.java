package br.com.rd.agendamento.entity;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CD_REGIONAL")
@NamedQueries(value = {@NamedQuery(name = "findAllCentroDistribuicao", query = "SELECT c FROM TbCdRegional c ORDER BY c.cdRegional")})
@Cacheable(false)
public class TbCdRegional implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CD_REGIONAL", unique = true, nullable = false, precision = 4)
	private Long cdRegional;

	@Column(name = "NM_CD_REGIONAL", nullable = false, length = 50)
	private String nmCDRegional;
	
	@Column(name = "DS_DB_LINK", nullable = true, length = 50)
	private String dsDbLink;
	
    public TbCdRegional() {
    	
    }

	public Long getCdRegional() {
		return cdRegional;
	}

	public void setCdRegional(Long cdRegional) {
		this.cdRegional = cdRegional;
	}

	public String getNmCDRegional() {
		return nmCDRegional;
	}

	public void setNmCDRegional(String nmCDRegional) {
		this.nmCDRegional = nmCDRegional;
	}

	public String getDsDbLink() {
		return dsDbLink;
	}

	public void setDsDbLink(String dsDbLink) {
		this.dsDbLink = dsDbLink;
	}
	
}