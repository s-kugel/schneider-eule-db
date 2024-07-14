package com.s_kugel.schneider.eule.repository;

import com.s_kugel.schneider.eule.entity.ApplicationClock;
import com.s_kugel.schneider.eule.entity.ApplicationClockPK;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL, dataSource = "eule")
public interface ApplicationClockRepository
    extends CrudRepository<ApplicationClock, ApplicationClockPK> {

  @Override
  @NonNull
  Optional<ApplicationClock> findById(@NonNull ApplicationClockPK id);
}
