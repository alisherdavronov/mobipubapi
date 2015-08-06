package org.mobipub.api.v1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class ContentAttribute extends Entity {
    @Min(1)
    private final int contentId;
    @NotNull
    @Size(max=255)
    private final String name;
    @NotNull
    @Size(max=255)
    private final String fullName;
    private final int orderNumber;
    @NotNull
    @Size(max=255)
    private final String lang;
    @NotNull
    @Size(max=255)
    private final String value;

    public ContentAttribute(
            int id,
            int contentId,
            String name,
            String fullName,
            int orderNumber,
            String lang,
            String value,
            Timestamp createdAt,
            Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.contentId = contentId;
        this.name = name;
        this.fullName = fullName;
        this.orderNumber = orderNumber;
        this.lang = lang;
        this.value = value;
    }

    public int getContentId() {
        return contentId;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getLang() {
        return lang;
    }

    public String getValue() {
        return value;
    }
}
