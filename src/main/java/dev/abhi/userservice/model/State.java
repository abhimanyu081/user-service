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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "state")
@Indexed
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	@Field
	private String name;

	/*
	 * @OneToMany(mappedBy = "state") private Set<District> districts;
	 */
	@JsonBackReference
	@OneToMany(mappedBy = "state")
	private Set<City> cities;

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

	/*
	 * public Set<District> getDistricts() { return districts; }
	 * 
	 * public void setDistricts(Set<District> districts) { this.districts =
	 * districts; }
	 */

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

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}

	
}
