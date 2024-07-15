package com.s_kugel.schneider.eule;

import com.google.common.collect.Lists;
import com.s_kugel.schneider.enums.StaffStatus;
import com.s_kugel.schneider.eule.entity.Staff;
import com.s_kugel.schneider.eule.repository.StaffRepository;
import de.huxhorn.sulky.ulid.ULID;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@MicronautTest(environments = "eule-db")
@Slf4j
class StaffRepositoryTest {

  @Inject //
  StaffRepository staffRepository;

  ULID ulid = new ULID();

  @BeforeEach
  void insert() {
    var deleted = 0;
    do {
      deleted = staffRepository.deleteAllWithLimit(150);
      log.info("delete Staff: rows={}", deleted);
    } while (deleted > 0);

    List<Staff> rows = Lists.newArrayList();
    for (var i = 0; i < 1000; i++) {
      var id = ulid.nextULID();
      var row =
          Staff.builder()
              .id(id)
              .staffStatus(StaffStatus.ENABLED)
              .email("%s@example.com".formatted(id.toLowerCase()))
              .staffName("name-%s".formatted(id))
              .createdAt(LocalDateTime.now())
              .createdBy("test")
              .version(0)
              .build();
      rows.add(row);
    }

    staffRepository.saveAll(rows);
  }

  @Test
  void test_findAll() {
    staffRepository
        .findAll() //
        .stream() //
        .map(Record::toString) //
        .forEach(log::info);
  }
}
