package ro.crownstudio.pojo.comment;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Builder
public class Comment {

	@SerializedName("name")
	private String name;

	@SerializedName("postId")
	private int postId;

	@SerializedName("id")
	private int id;

	@SerializedName("body")
	private String body;

	@SerializedName("email")
	private String email;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Comment comment = (Comment) o;
		return postId == comment.postId &&
				id == comment.id &&
				Objects.equals(name, comment.name) &&
				Objects.equals(body, comment.body) &&
				Objects.equals(email, comment.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, postId, id, body, email);
	}
}