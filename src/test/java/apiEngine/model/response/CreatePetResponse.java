package apiEngine.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL) @JsonPropertyOrder({ "id", "category", "name", "photoUrls", "tags",
  "status" }) public class CreatePetResponse {

  @JsonProperty("id") private Integer id;
  @JsonProperty("category") private Category category;
  @JsonProperty("name") private String name;
  @JsonProperty("photoUrls") private List<String> photoUrls = null;
  @JsonProperty("tags") private List<Tag> tags = null;
  @JsonProperty("status") private String status;

  /**
   * No args constructor for use in serialization
   */
  public CreatePetResponse() {
  }

  /**
   * @param photoUrls
   * @param name
   * @param id
   * @param category
   * @param tags
   * @param status
   */
  public CreatePetResponse(Integer id, Category category, String name, List<String> photoUrls, List<Tag> tags,
    String status) {
    super();
    this.id = id;
    this.category = category;
    this.name = name;
    this.photoUrls = photoUrls;
    this.tags = tags;
    this.status = status;
  }

  @JsonProperty("id")
  public Integer getId() {
    return id;
  }

  @JsonProperty("id")
  public void setId(Integer id) {
    this.id = id;
  }

  @JsonProperty("category")
  public Category getCategory() {
    return category;
  }

  @JsonProperty("category")
  public void setCategory(Category category) {
    this.category = category;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("name")
  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty("photoUrls")
  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  @JsonProperty("photoUrls")
  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = photoUrls;
  }

  @JsonProperty("tags")
  public List<Tag> getTags() {
    return tags;
  }

  @JsonProperty("tags")
  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  @JsonProperty("status")
  public String getStatus() {
    return status;
  }

  @JsonProperty("status")
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(CreatePetResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
      .append('[');
    sb.append("id");
    sb.append('=');
    sb.append(((this.id == null) ? "<null>" : this.id));
    sb.append(',');
    sb.append("category");
    sb.append('=');
    sb.append(((this.category == null) ? "<null>" : this.category));
    sb.append(',');
    sb.append("name");
    sb.append('=');
    sb.append(((this.name == null) ? "<null>" : this.name));
    sb.append(',');
    sb.append("photoUrls");
    sb.append('=');
    sb.append(((this.photoUrls == null) ? "<null>" : this.photoUrls));
    sb.append(',');
    sb.append("tags");
    sb.append('=');
    sb.append(((this.tags == null) ? "<null>" : this.tags));
    sb.append(',');
    sb.append("status");
    sb.append('=');
    sb.append(((this.status == null) ? "<null>" : this.status));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = ((result * 31) + ((this.photoUrls == null) ? 0 : this.photoUrls.hashCode()));
    result = ((result * 31) + ((this.name == null) ? 0 : this.name.hashCode()));
    result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
    result = ((result * 31) + ((this.category == null) ? 0 : this.category.hashCode()));
    result = ((result * 31) + ((this.tags == null) ? 0 : this.tags.hashCode()));
    result = ((result * 31) + ((this.status == null) ? 0 : this.status.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof CreatePetResponse)) {
      return false;
    }
    CreatePetResponse rhs = ((CreatePetResponse) other);
    return ((((((Objects.equals(this.photoUrls, rhs.photoUrls)) && (Objects.equals(this.name, rhs.name))) && (Objects.equals(this.id, rhs.id))) && (Objects.equals(this.category, rhs.category))) && (Objects.equals(this.tags, rhs.tags))) && (Objects.equals(this.status, rhs.status)));
  }

}