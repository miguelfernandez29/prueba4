package com.example.app.repository;

import com.example.app.entity.GenericData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenericDataRepository extends JpaRepository<GenericData, Long> {

    List<GenericData> findByDataType(String dataType);

    Optional<GenericData> findByDataTypeAndDataCode(String dataType, String dataCode);
}