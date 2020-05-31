package dev.abhi.userservice.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "addressLine1")
	private String addressLine1;

	@Column(name = "addressLine2")
	private String addressLine2;

	@Column(name = "addressLine3")
	private String addressLine3;

	// not needed right now
	/* private AddressType addressType; */

	/**
	 * whoever owns the foreign key column gets the @JoinColumn annotation
	 */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "city_id", referencedColumnName = "id")
	private City city;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "longitude")
	private Double longitude;

	@Column(name = "latitude")
	private Double latitude;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "is_primary")
	private boolean isPrimary;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createDateTime;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updateDateTime;

	@Transient
	private String addressFull;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPrimary() {
		return isPrimary;
	}

	public void setPrimary(boolean isPrimary) {
		this.isPrimary = isPrimary;
	}

	public String getAddressFull() {
		return addressFull;
	}

	public void setAddressFull(String addressFull) {
		this.addressFull = addressFull;
	}

	public Long getId() {
		return id;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

}
