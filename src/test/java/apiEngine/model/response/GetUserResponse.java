package apiEngine.model.response;

import java.util.Objects;

public class GetUserResponse {

  private Integer id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
  private String phone;
  private Integer userStatus;

  /**
   * No args constructor for use in serialization
   */
  public GetUserResponse() {
  }

  /**
   * @param firstName
   * @param lastName
   * @param password
   * @param userStatus
   * @param phone
   * @param id
   * @param email
   * @param username
   */
  public GetUserResponse(Integer id, String username, String firstName, String lastName, String email, String password,
    String phone, Integer userStatus) {
    super();
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
    this.phone = phone;
    this.userStatus = userStatus;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(GetUserResponse.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
      .append('[');
    sb.append("id");
    sb.append('=');
    sb.append(((this.id == null) ? "<null>" : this.id));
    sb.append(',');
    sb.append("username");
    sb.append('=');
    sb.append(((this.username == null) ? "<null>" : this.username));
    sb.append(',');
    sb.append("firstName");
    sb.append('=');
    sb.append(((this.firstName == null) ? "<null>" : this.firstName));
    sb.append(',');
    sb.append("lastName");
    sb.append('=');
    sb.append(((this.lastName == null) ? "<null>" : this.lastName));
    sb.append(',');
    sb.append("email");
    sb.append('=');
    sb.append(((this.email == null) ? "<null>" : this.email));
    sb.append(',');
    sb.append("password");
    sb.append('=');
    sb.append(((this.password == null) ? "<null>" : this.password));
    sb.append(',');
    sb.append("phone");
    sb.append('=');
    sb.append(((this.phone == null) ? "<null>" : this.phone));
    sb.append(',');
    sb.append("userStatus");
    sb.append('=');
    sb.append(((this.userStatus == null) ? "<null>" : this.userStatus));
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
    result = ((result * 31) + ((this.firstName == null) ? 0 : this.firstName.hashCode()));
    result = ((result * 31) + ((this.lastName == null) ? 0 : this.lastName.hashCode()));
    result = ((result * 31) + ((this.password == null) ? 0 : this.password.hashCode()));
    result = ((result * 31) + ((this.userStatus == null) ? 0 : this.userStatus.hashCode()));
    result = ((result * 31) + ((this.phone == null) ? 0 : this.phone.hashCode()));
    result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
    result = ((result * 31) + ((this.email == null) ? 0 : this.email.hashCode()));
    result = ((result * 31) + ((this.username == null) ? 0 : this.username.hashCode()));
    return result;
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof GetUserResponse)) {
      return false;
    }
    GetUserResponse rhs = ((GetUserResponse) other);
    return ((((((((Objects.equals(this.firstName, rhs.firstName)) && (Objects.equals(this.lastName, rhs.lastName))) && (Objects.equals(this.password, rhs.password))) && (Objects.equals(this.userStatus, rhs.userStatus))) && (Objects.equals(this.phone, rhs.phone))) && (Objects.equals(this.id, rhs.id))) && (Objects.equals(this.email, rhs.email))) && (Objects.equals(this.username, rhs.username)));
  }

}