package org.techforumist.jwt.jpa;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class AppUser implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userid;

	@Column
	private String firstname;

	@Column(unique = true)
	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;


	@ElementCollection
	private List<String> roles = new ArrayList<>();

	@OneToMany(mappedBy = "userid", cascade=CascadeType.MERGE)
	private List<Purchase> orders;

	public AppUser() { }

	public AppUser(int userid) {
		this.userid = Long.valueOf(userid);
	}

	public AppUser(int userid, String username, String password, boolean enabled, String firstname) {
		this.userid = Long.valueOf(userid);
		this.username = username;
		this.password = password;
		this.firstname = firstname;
	}

	public AppUser(Long userid) {
		this.userid = userid;
	}

	public Long getUserid() { return userid; }

	public void setUserid(Long userid) { this.userid = userid; }

	public String getFirstname() { return firstname; }

	public void setFirstname(String firstname) { this.firstname = firstname; }

	public List<String> getRoles() { return roles; }

	public void setRoles(List<String> roles) { this.roles = roles; }

	public void setUsername(String username) { this.username = username; }

	public void setPassword(String password) { this.password = password; }

	public List<Purchase> getOrders() { return orders; }

	public void setOrders(List<Purchase> orders) { this.orders = orders; }

	@JsonIgnore
	@Override
	public boolean isEnabled() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

}
