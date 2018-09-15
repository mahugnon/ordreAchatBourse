package fr.equensWorldline.ordreAchatBourse.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idRole;
	private String roleName;
	@ManyToMany(mappedBy="roles")
	private Collection<AppUser> users=new ArrayList<>();
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Collection<AppUser> getUsers() {
		return users;
	}

	public void setUsers(Collection<AppUser> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
	}

	
	
}
