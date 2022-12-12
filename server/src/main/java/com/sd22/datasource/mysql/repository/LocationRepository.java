package com.sd22.datasource.mysql.repository;

import com.sd22.datasource.mysql.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
