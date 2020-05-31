package dev.abhi.userservice.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "state")
	private Set<District> districts;

	/**
	 * 
	 * As per JPA specification, It's a good practice to mark many-to-one side as
	 * the owning side In other words State will be the owning side and Country will
	 * be the inverse side. By including the mappedBy attribute in the Country
	 * class, we marked it as the inverse side, at the same time marking the class
	 * State with @ManyToOne makes it as owning side.
	 * 
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "country_id", nullable = false)
	private Country country;

	public Set<District> getDistricts() {
		return districts;
	}

	public void setDistricts(Set<District> districts) {
		this.districts = districts;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
