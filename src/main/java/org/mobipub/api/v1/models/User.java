package org.mobipub.api.v1.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class User extends Entity {
    @NotNull
    @Size(min=3, max=255)
    private final String email;
    @NotNull
    @Size(max=255)
    private final String encryptedPassword;
    private final Boolean admin;
    @Size(max=255)
    private final String resetPasswordToken;
    private final Timestamp resetPasswordSentAt;
    private final Timestamp rememberCreatedAt;
    private final int signInCount;
    private final Timestamp currentSignInAt;
    private final Timestamp lastSignInAt;
    @Size(max=255)
    private final String currentSignInIp;
    @Size(max=255)
    private final String lastSignInIp;
    @Size(max=255)
    private final String accessToken;
    private final Integer baseId;
    private final String guid;
    @Size(max=255)
    private final String appId;
    private final Timestamp expireAt;
    @Size(max=255)
    private final String confirmationToken;
    @Size(max=255)
    private final String unconfirmedEmail;
    private final Timestamp confirmedAt;
    private final Timestamp confirmationSentAt;
    @NotNull
    @Size(max=255)
    private final String locale;

    public User(
            int id,
            String email,
            String encryptedPassword,
            Boolean admin,
            String resetPasswordToken,
            Timestamp resetPasswordSentAt,
            Timestamp rememberCreatedAt,
            int signInCount,
            Timestamp currentSignInAt,
            Timestamp lastSignInAt,
            String currentSignInIp,
            String lastSignInIp,
            String accessToken,
            Integer baseId,
            String guid,
            String appId,
            Timestamp expireAt,
            Timestamp createdAt,
            Timestamp updatedAt,
            String confirmationToken,
            String unconfirmedEmail,
            Timestamp confirmedAt,
            Timestamp confirmationSentAt,
            String locale
    ) {
        super(id, createdAt, updatedAt);
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.admin = admin;
        this.resetPasswordToken = resetPasswordToken;
        this.resetPasswordSentAt = resetPasswordSentAt;
        this.rememberCreatedAt = rememberCreatedAt;
        this.signInCount = signInCount;
        this.currentSignInAt = currentSignInAt;
        this.lastSignInAt = lastSignInAt;
        this.currentSignInIp = currentSignInIp;
        this.lastSignInIp = lastSignInIp;
        this.accessToken = accessToken;
        this.baseId = baseId;
        this.guid = guid;
        this.appId = appId;
        this.expireAt = expireAt;
        this.confirmationToken = confirmationToken;
        this.unconfirmedEmail = unconfirmedEmail;
        this.confirmedAt = confirmedAt;
        this.confirmationSentAt = confirmationSentAt;
        this.locale = locale;
    }

    public String getEmail() {
        return email;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public String getResetPasswordToken() {
        return resetPasswordToken;
    }

    public Timestamp getResetPasswordSentAt() {
        return resetPasswordSentAt;
    }

    public Timestamp getRememberCreatedAt() {
        return rememberCreatedAt;
    }

    public int getSignInCount() {
        return signInCount;
    }

    public Timestamp getCurrentSignInAt() {
        return currentSignInAt;
    }

    public Timestamp getLastSignInAt() {
        return lastSignInAt;
    }

    public String getCurrentSignInIp() {
        return currentSignInIp;
    }

    public String getLastSignInIp() {
        return lastSignInIp;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Integer getBaseId() {
        return baseId;
    }

    public String getGuid() {
        return guid;
    }

    public String getAppId() {
        return appId;
    }

    public Timestamp getExpireAt() {
        return expireAt;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public String getUnconfirmedEmail() {
        return unconfirmedEmail;
    }

    public Timestamp getConfirmedAt() {
        return confirmedAt;
    }

    public Timestamp getConfirmationSentAt() {
        return confirmationSentAt;
    }

    public String getLocale() {
        return locale;
    }
}
