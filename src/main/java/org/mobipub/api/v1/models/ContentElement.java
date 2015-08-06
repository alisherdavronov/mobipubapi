package org.mobipub.api.v1.models;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

public class ContentElement extends Entity {
    @Min(1)
    private final int content_id;
    private final int order_number;
    @NotNull
    @Size(max=255)
    private final String lang;
    @NotNull
    @Size(max=255)
    private final String name;
    @NotNull
    @Size(max=255)
    private final String fullName;
    private final String contentText;
    @NotNull
    @Size(max=255)
    private final String contentType;
    @Size(max=255)
    private final String contentPath;
    @Size(max=255)
    private final String iconPath;
    private final String tags;
    @Size(max=255)
    private final String url;
    @Size(max=255)
    private final String localPath;

    public ContentElement(
            int id,
            int content_id,
            int order_number,
            String lang,
            String name,
            String fullName,
            String contentText,
            String contentType,
            String contentPath,
            String iconPath,
            String tags,
            Timestamp createdAt,
            Timestamp updatedAt,
            String url,
            String localPath) {
        super(id, createdAt, updatedAt);
        this.content_id = content_id;
        this.order_number = order_number;
        this.lang = lang;
        this.name = name;
        this.fullName = fullName;
        this.contentText = contentText;
        this.contentType = contentType;
        this.contentPath = contentPath;
        this.iconPath = iconPath;
        this.tags = tags;
        this.url = url;
        this.localPath = localPath;
    }

    public int getContent_id() {
        return content_id;
    }

    public int getOrder_number() {
        return order_number;
    }

    public String getLang() {
        return lang;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContentText() {
        return contentText;
    }

    public String getContentType() {
        return contentType;
    }

    public String getContentPath() {
        return contentPath;
    }

    public String getIconPath() {
        return iconPath;
    }

    public String getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public String getLocalPath() {
        return localPath;
    }
}
