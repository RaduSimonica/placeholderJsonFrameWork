package ro.crownstudio.pojo.users;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Company {

	@SerializedName("bs")
	private String bs;

	@SerializedName("catchPhrase")
	private String catchPhrase;

	@SerializedName("name")
	private String name;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Company company = (Company) o;
		return Objects.equals(bs, company.bs) &&
				Objects.equals(catchPhrase, company.catchPhrase) &&
				Objects.equals(name, company.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bs, catchPhrase, name);
	}
}