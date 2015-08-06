package org.mobipub.api.v1.forms;

import javax.validation.constraints.Size;
import java.util.Map;

public class MobileUserFormDataForm {
    private final Integer mobileUserId;
    private final int baseId;
    private final String formName;
    private final Map<String, String> data;

    public MobileUserFormDataForm(Integer mobileUserId, int baseId, String formName, Map<String, String> data) {
        this.mobileUserId = mobileUserId;
        this.baseId = baseId;
        this.formName = formName;
        this.data = data;
    }

    public Integer getMobileUserId() {
        return mobileUserId;
    }

    public int getBaseId() {
        return baseId;
    }

    public String getFormName() {
        return formName;
    }

    public Map<String, String> getData() {
        return data;
    }
}
