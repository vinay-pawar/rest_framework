package apiEngine.model.response;

import java.util.Objects;

public class CreateUserResponse {

  private Integer code;
  private String type;
  private String message;

  /**
   * No args constructor for use in serialization
   */
  public CreateUserResponse() {
  }

  /**
   * @param code
   * @param type
   * @param message
   */
  public CreateUserResponse(Integer code, String type, String message) {
    super();
    this.code = code;
    this.type = type;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(CreateUserResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
      .append('[');
    sb.append("code");
    sb.append('=');
    sb.append(((this.code == null) ? "<null>" : this.code));
    sb.append(',');
    sb.append("type");
    sb.append('=');
    sb.append(((this.type == null) ? "<null>" : this.type));
    sb.append(',');
    sb.append("message");
    sb.append('=');
    sb.append(((this.message == null) ? "<null>" : this.message));
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
    result = ((result * 31) + ((this.code == null) ? 0 : this.code.hashCode()));
    result = ((result * 31) + ((this.type == null) ? 0 : this.type.hashCode()));
    result = ((result * 31) + ((this.message == null) ? 0 : this.message.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof CreateUserResponse)) {
      return false;
    }
    CreateUserResponse rhs = ((CreateUserResponse) other);
    return (((Objects.equals(this.code, rhs.code)) && (Objects.equals(this.type, rhs.type))) && (Objects.equals(this.message, rhs.message)));
  }

}