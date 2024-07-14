package com.s_kugel.schneider.eule.repository;

import com.s_kugel.schneider.eule.entity.BackofficeProperties;
import io.micronaut.data.jdbc.annotation.JdbcRepository;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.repository.CrudRepository;

@JdbcRepository(dialect = Dialect.MYSQL, dataSource = "eule")
public interface BackofficePropertiesRepository
    extends CrudRepository<BackofficeProperties, String> {}
