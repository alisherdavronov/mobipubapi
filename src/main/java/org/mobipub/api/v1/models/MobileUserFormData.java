package org.mobipub.api.v1.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.UUID;

public class MobileUserFormData extends Entity {
    private final int userId;
    private final int baseId;
    @NotNull
    @Size(max=255)
    private final String formName;
    @NotNull
    private final UUID dataGuid;
    @NotNull
    @Size(max=255)
    private final String dataKey;
    @NotNull
    @Size(max=255)
    private final String dataValue;

    public MobileUserFormData(
            int id,
            int userId,
            int baseId,
            String formName,
            UUID dataGuid,
            String dataKey,
            String dataValue,
            Timestamp createdAt,
            Timestamp updatedAt
    ) {
        super(id, createdAt, updatedAt);
        this.userId = userId;
        this.baseId = baseId;
        this.formName = formName;
        this.dataGuid = dataGuid;
        this.dataKey = dataKey;
        this.dataValue = dataValue;
    }

    public int getUserId() {
        return userId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getFormName() {
        return formName;
    }

    public UUID getDataGuid() {
        return dataGuid;
    }

    public String getDataKey() {
        return dataKey;
    }

    public String getDataValue() {
        return dataValue;
    }
}
