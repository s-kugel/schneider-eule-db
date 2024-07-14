package com.s_kugel.schneider.eule.repository;

import com.s_kugel.schneider.eule.entity.Staff;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL, dataSource = "eule")
public interface StaffRepository extends CrudRepository<Staff, String> {

  @Query("DELETE FROM Staff LIMIT :limit")
  Integer deleteAllWithLimit(Integer limit);

  @Override
  @NonNull
  Optional<Staff> findById(@NonNull String id);
}
