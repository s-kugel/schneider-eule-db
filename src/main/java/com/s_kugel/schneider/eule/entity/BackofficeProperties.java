package com.s_kugel.schneider.eule.entity;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Version;
import io.micronaut.data.model.naming.NamingStrategies;
import java.time.LocalDateTime;
import lombok.Builder;

@MappedEntity(namingStrategy = NamingStrategies.Raw.class)
@Builder(toBuilder = true)
public record BackofficeProperties(
    @Id @NonNull String propertyName,
    @Nullable String propertyValue,
    @Nullable LocalDateTime createdAt,
    @Nullable String createdBy,
    @Nullable LocalDateTime updatedAt,
    @Nullable String updatedBy,
    @Version @NonNull Integer version) {}
