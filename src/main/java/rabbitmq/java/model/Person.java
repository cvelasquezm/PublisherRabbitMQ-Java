package rabbitmq.java.model;

import java.util.Date;

public class Person {
	
	private String nombre;
	private String apellido;
	private String email;
	private Date hora;
	
	public Person() {
		hora = new Date();
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

}
