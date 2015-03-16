#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Álvaro Rungue
 * @since 04/01/15.
 */
@Entity
@Table(name = "users")
public class User implements Serializable{

	private static final long serialVersionUID = 3717393129861721996L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid2")
	@Column(name = "user_id")
	private String id;

	@Column(name = "user_name")
	private String name;

	@Column(name = "user_cpf")
	private String cpf;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_login")
	private String login;

	@Column(name = "user_password")
	@JsonIgnore
	private String password;

	@Column(name = "enabled")
	private Boolean enabled;

	@Column(name = "last_login")
	private Date lastLogin;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "authorities",
			joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
	private List<Group> authorities;

	@OneToOne
	@JoinColumn(name = "instance_id")
	private Instance instance;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<Group> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<Group> authorities) {
		this.authorities = authorities;
	}

	public Instance getInstance() {
		return instance;
	}

	public void setInstance(Instance instance) {
		this.instance = instance;
	}
}//fim class User
