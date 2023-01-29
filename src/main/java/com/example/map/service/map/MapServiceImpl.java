package com.example.map.service.map;

import com.example.map.dto.Feature;
import com.example.map.repository.MapRepository;
import org.geotools.data.store.EmptyFeatureCollection;
import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

@Service
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;

    public MapServiceImpl(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    @Override
    public List<JSONObject> getDataGeojson() {
        List<JSONObject> geojson =this.mapRepository.findMap();

        return geojson;



//        FeatureJSON featureJSON = new FeatureJSON(new GeometryJSON(15));
//        featureJSON.
//        FeatureCollection featureCollection = new EmptyFeatureCollection();
//        try {
//            featureCollection.;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//       return null;
    }

    @Override
    public JSONObject findPedestrianSectionById(Long id) {
        return this.mapRepository.findByIdCustom(id);
    }
}
