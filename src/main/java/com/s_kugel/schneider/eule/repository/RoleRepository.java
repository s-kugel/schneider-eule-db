package com.s_kugel.schneider.eule.repository;

import com.s_kugel.schneider.eule.entity.Role;
import io.micronaut.core.annotation.NonNull;
import io.micronaut.data.annotation.Query;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

import java.util.Optional;

@JdbcRepository(dialect = Dialect.MYSQL, dataSource = "eule")
public interface RoleRepository extends CrudRepository<Role, String> {

  @Query("DELETE FROM Role LIMIT :limit")
  Integer deleteAllWithLimit(Integer limit);

  @Override
  @NonNull
  Optional<Role> findById(@NonNull String id);
}
