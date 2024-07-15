package com.s_kugel.schneider.eule.entity;

import io.micronaut.data.annotation.Embeddable;
import io.micronaut.serde.annotation.Serdeable;
import java.time.LocalDateTime;

@Embeddable
@Serdeable
public record ApplicationClockPK(String timeZone, LocalDateTime baseTime) {}
