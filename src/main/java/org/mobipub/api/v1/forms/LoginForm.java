package org.mobipub.api.v1.forms;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class LoginForm {

    @NotEmpty
    @Size(min=3, max=255)
    @JsonProperty
    private final String email;

    @Size(max=255)
    @JsonProperty
    private final String password;

    @Min(1)
    @JsonProperty
    private final int baseId;

    public LoginForm(@JsonProperty("email") String email, @JsonProperty("password") String password, @JsonProperty("base_id") int baseId) {
        this.email = email;
        this.password = password;
        this.baseId = baseId;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getBaseId() {
        return baseId;
    }
}
