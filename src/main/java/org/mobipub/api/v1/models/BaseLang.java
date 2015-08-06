package org.mobipub.api.v1.models;


public class BaseLang extends LangEntity {
    private final String name;
    private final String fullName;
    private final String description;

    public BaseLang(
            int entityId,
            int languageId,
            String name,
            String fullName,
            String description
            ) {
        super(entityId, languageId);
        this.name = name;
        this.fullName = fullName;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDescription() {
        return description;
    }
}
