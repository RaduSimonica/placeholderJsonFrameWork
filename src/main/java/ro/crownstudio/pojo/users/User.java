package ro.crownstudio.pojo.users;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class User {

	@SerializedName("website")
	private String website;

	@SerializedName("address")
	private Address address;

	@SerializedName("phone")
	private String phone;

	@SerializedName("name")
	private String name;

	@SerializedName("company")
	private Company company;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return id == user.id &&
				Objects.equals(website, user.website) &&
				Objects.equals(address, user.address) &&
				Objects.equals(phone, user.phone) &&
				Objects.equals(name, user.name) &&
				Objects.equals(company, user.company) &&
				Objects.equals(email, user.email) &&
				Objects.equals(username, user.username);
	}

	@Override
	public int hashCode() {
		return Objects.hash(website, address, phone, name, company, id, email, username);
	}
}