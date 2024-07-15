package com.s_kugel.schneider.eule.entity;

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Version;
import io.micronaut.data.model.naming.NamingStrategies;
import io.micronaut.serde.annotation.Serdeable;
import java.time.LocalDateTime;
import lombok.Builder;

@MappedEntity(namingStrategy = NamingStrategies.Raw.class)
@Serdeable
@Builder(toBuilder = true)
public record Role(
    @Id @NonNull String id,
    @Nullable String roleName,
    @Nullable LocalDateTime createdAt,
    @Nullable String createdBy,
    @Nullable LocalDateTime updatedAt,
    @Nullable String updatedBy,
    @Version @NonNull Integer version) {}
