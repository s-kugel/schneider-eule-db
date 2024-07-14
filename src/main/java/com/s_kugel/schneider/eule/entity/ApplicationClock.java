package com.s_kugel.schneider.eule.entity;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.EmbeddedId;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.model.naming.NamingStrategies;
import lombok.Builder;

import java.time.LocalDateTime;

@MappedEntity(namingStrategy = NamingStrategies.Raw.class)
@Builder(toBuilder = true)
public record ApplicationClock(
    @EmbeddedId ApplicationClockPK id,
    @Nullable LocalDateTime createdAt,
    @Nullable LocalDateTime updatedAt) {}
