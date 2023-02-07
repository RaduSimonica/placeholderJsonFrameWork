package ro.crownstudio.pojo.users;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Address {

	@SerializedName("zipcode")
	private String zipcode;

	@SerializedName("geo")
	private Geo geo;

	@SerializedName("suite")
	private String suite;

	@SerializedName("city")
	private String city;

	@SerializedName("street")
	private String street;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Address address = (Address) o;
		return Objects.equals(zipcode, address.zipcode) &&
				Objects.equals(geo, address.geo) &&
				Objects.equals(suite, address.suite) &&
				Objects.equals(city, address.city) &&
				Objects.equals(street, address.street);
	}

	@Override
	public int hashCode() {
		return Objects.hash(zipcode, geo, suite, city, street);
	}
}