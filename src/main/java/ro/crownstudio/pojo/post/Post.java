package ro.crownstudio.pojo.post;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ro.crownstudio.pojo.BasePojo;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Post extends BasePojo {

	@SerializedName("id")
	private int id;

	@SerializedName("title")
	private String title;

	@SerializedName("body")
	private String body;

	@SerializedName("userId")
	private int userId;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Post post = (Post) o;
		return id == post.id &&
				userId == post.userId &&
				Objects.equals(title, post.title) &&
				Objects.equals(body, post.body);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, body, userId);
	}
}