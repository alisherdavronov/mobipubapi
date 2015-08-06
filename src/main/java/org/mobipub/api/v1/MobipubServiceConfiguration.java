package org.mobipub.api.v1;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class MobipubServiceConfiguration extends Configuration {
    @JsonProperty
    @NotNull
    @Valid
    private DatabaseConfiguration database = new DatabaseConfiguration();

    @JsonProperty
    @NotNull
    private int tokenTimeout = 15;

    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }

    public int getTokenTimeout() {
        return tokenTimeout;
    }
}
