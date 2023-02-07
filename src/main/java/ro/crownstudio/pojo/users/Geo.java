package ro.crownstudio.pojo.users;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Geo {

	@SerializedName("lng")
	private String lng;

	@SerializedName("lat")
	private String lat;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Geo geo = (Geo) o;
		return Objects.equals(lng, geo.lng) && Objects.equals(lat, geo.lat);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lng, lat);
	}
}