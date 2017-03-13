package application.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

import application.controller.UsuarioController;

@Entity
public class Funcionario {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String nomeFuncionario;
	private String setorFuncionario;
	private String funcaoFuncionario;
	private int idadeFuncionario;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}
	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}
	public String getSetorFuncionario() {
		return setorFuncionario;
	}
	public void setSetorFuncionario(String setorFuncionario) {
		this.setorFuncionario = setorFuncionario;
	}
	public String getFuncaoFuncionario() {
		return funcaoFuncionario;
	}
	public void setFuncaoFuncionario(String funcaoFuncionario) {
		this.funcaoFuncionario = funcaoFuncionario;
	}
	public int getIdadeFuncionario() {
		return idadeFuncionario;
	}
	public void setIdadeFuncionario(int idadeFuncionario) {
		this.idadeFuncionario = idadeFuncionario;
	}
	
	
}
