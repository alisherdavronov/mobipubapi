package org.mobipub.api.v1.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public class Category extends Entity {
    @Min(1)
    private final int baseId;
    @NotNull
    private final String name;
    @NotNull
    private final String fullName;
    private final String description;
    private final boolean published;
    private final Integer parentId;
    private final Integer lft;
    private final Integer rgt;
    private final Integer depth;

    public Category(
            int id,
            int baseId,
            String name,
            String fullName,
            String description,
            boolean published,
            Integer parentId,
            Integer lft,
            Integer rgt,
            Integer depth,
            Timestamp createdAt,
            Timestamp updatedAt) {
        super(id, createdAt, updatedAt);
        this.baseId = baseId;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.published = published;
        this.parentId = parentId;
        this.lft = lft;
        this.rgt = rgt;
        this.depth = depth;
    }
    public int getBaseId() {
        return baseId;
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

    public boolean isPublished() {
        return published;
    }

    public Integer getParentId() {
        return parentId;
    }

    public Integer getLft() {
        return lft;
    }

    public Integer getRgt() {
        return rgt;
    }

    public Integer getDepth() {
        return depth;
    }
}
