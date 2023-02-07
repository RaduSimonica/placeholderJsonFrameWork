package ro.crownstudio.pojo.photo;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Photo {

	@SerializedName("albumId")
	private int albumId;

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("thumbnailUrl")
	private String thumbnailUrl;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Photo photo = (Photo) o;
		return albumId == photo.albumId &&
				id == photo.id &&
				Objects.equals(title, photo.title) &&
				Objects.equals(url, photo.url) &&
				Objects.equals(thumbnailUrl, photo.thumbnailUrl);
	}

	@Override
	public int hashCode() {
		return Objects.hash(albumId, id, title, url, thumbnailUrl);
	}
}