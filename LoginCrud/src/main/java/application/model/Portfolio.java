package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import application.controller.TesteController;

@Entity
public class Portfolio {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nomeProjeto;
	private String descProjeto;
	private String desafioProjeto;
	private int tempoProjeto;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeProjeto() {
		return nomeProjeto;
	}
	public void setNomeProjeto(String nomeProjeto) {
		this.nomeProjeto = nomeProjeto;
	}
	public String getDescProjeto() {
		return descProjeto;
	}
	public void setDescProjeto(String descProjeto) {
		this.descProjeto = descProjeto;
	}
	public String getDesafioProjeto() {
		return desafioProjeto;
	}
	public void setDesafioProjeto(String desafioProjeto) {
		this.desafioProjeto = desafioProjeto;
	}
	public int getTempoProjeto() {
		return tempoProjeto;
	}
	public void setTempoProjeto(int tempoProjeto) {
		this.tempoProjeto = tempoProjeto;
	}
	
	
}
