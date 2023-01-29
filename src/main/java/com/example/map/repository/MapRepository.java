package com.example.map.repository;

import com.example.map.entity.EntityI;
import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MapRepository extends JpaRepository<EntityI, Long> {

    @Query(value = "select feature_info from features", nativeQuery = true)
    List<JSONObject> findMap();

    @Query(value = "select feature_info from features where id=:id", nativeQuery = true)
    JSONObject findByIdCustom(@Param("id") Long id);
}
