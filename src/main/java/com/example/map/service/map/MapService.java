package com.example.map.service.map;

import com.example.map.dto.Feature;
import com.example.map.repository.MapRepository;
import org.json.simple.JSONObject;

import java.util.*;

public interface MapService {
   List<JSONObject> getDataGeojson();

    JSONObject findPedestrianSectionById(Long id);
}
