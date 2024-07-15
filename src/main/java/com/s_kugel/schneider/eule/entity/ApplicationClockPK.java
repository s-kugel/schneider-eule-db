package com.s_kugel.schneider.eule.entity;

import io.micronaut.data.annotation.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public record ApplicationClockPK(String timeZone, LocalDateTime baseTime) {}
