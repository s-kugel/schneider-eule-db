package com.s_kugel.schneider.eule.entity;

import com.s_kugel.schneider.enums.StaffStatus;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Version;
import io.micronaut.data.model.naming.NamingStrategies;
import lombok.Builder;

import java.time.LocalDateTime;

@MappedEntity(namingStrategy = NamingStrategies.Raw.class)
@Builder(toBuilder = true)
public record Staff(
    @Id @NonNull String id,
    @Nullable StaffStatus staffStatus,
    @Nullable String email,
    @Nullable String staffName,
    @Nullable String password,
    @Nullable String oldPassword,
    @Nullable LocalDateTime passwordLastUpdatedAt,
    @Nullable Integer loginFailureCount,
    @Nullable LocalDateTime createdAt,
    @Nullable String createdBy,
    @Nullable LocalDateTime updatedAt,
    @Nullable String updatedBy,
    @Version @NonNull Integer version) {}
