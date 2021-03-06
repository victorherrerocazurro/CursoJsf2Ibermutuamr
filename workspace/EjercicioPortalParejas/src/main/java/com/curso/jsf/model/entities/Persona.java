package com.curso.jsf.model.entities;
// Generated 29-may-2018 12:47:26 by Hibernate Tools 4.3.5.Final

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Personas generated by hbm2java
 */
@Entity
@Table(name = "PERSONAS", schema = "PUBLIC", catalog = "MEM")
public class Persona implements java.io.Serializable {

	private Integer id;
	@NotEmpty
	private String login;
	@NotEmpty
	private String password;
	@NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "{validation.nombre.no.numbers}")
	private String nombre;
	@NotEmpty
    @Pattern(regexp = "[^0-9]*", message = "{validation.nombre.no.numbers}")
	private String apellido;
	@Min(18)
	private int edad;
	@NotNull
	private Double altura;

	public Persona() {
	}

	public Persona(int id, String login, String password, String nombre, String apellido, int edad, Double altura) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.altura = altura;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "LOGIN", nullable = false, length = 24)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD", nullable = false, length = 24)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "NOMBRE", length = 26)
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "APELLIDO", length = 26)
	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Column(name = "EDAD", nullable = false)
	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Column(name = "ALTURA", precision = 17, scale = 0)
	public Double getAltura() {
		return this.altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

}
