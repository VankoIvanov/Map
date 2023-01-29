package com.example.map.util;

import org.geotools.feature.FeatureCollection;
import org.geotools.geojson.GeoJSON;
import org.geotools.geojson.feature.FeatureJSON;
import org.geotools.geojson.geom.GeometryJSON;
import org.opengis.feature.simple.SimpleFeatureType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class db {
    //File inFile = new File("src/main/resources/db/peshehodna_mreja_website.geojson");
//    var geojsonStore = new GeoJSONDataStore(inFile);
//    SimpleFeatureSource source = geojsonStore;

    public /*void*/ String readFile(){
        File inFile = new File("src/main/resources/db/peshehodna_mreja_website.geojson");
//        Map<String, Object> params = new HashMap<>();
//        params.put(GeoJSONDataStoreFactory.URLP.key,URLs.fileToUrl(inFile));
//
//        DataStore newDataStore = DataStoreFinder.getDataStore(params);
//        String pt = "POINT (-107 42)";
//
//        FilterFactory2 ff = CommonFactoryFinder.getFilterFactory2();
//        SimpleFeatureSource featureSource = newDataStore.getFeatureSource(newDataStore.getTypeNames()[0]);
//        Filter f = ff.contains(ff.property(featureSource.getSchema().getGeometryDescriptor().getLocalName()),
//                ff.literal(pt));
//        SimpleFeatureCollection collection = featureSource.getFeatures(f);
//        if(collection.size()>0)
//
//        {
//            try (SimpleFeatureIterator itr = collection.features()) {
//                while (itr.hasNext()) {
//                    System.out.println(itr.next());
//                }
//            }
//        }
//------------------------------------

        FeatureJSON featureJSON = new FeatureJSON(new GeometryJSON(15));
        FeatureCollection featureCollection = null;
        try {
            featureCollection = featureJSON.readFeatureCollection(inFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SimpleFeatureType simpleFeatureType = (SimpleFeatureType) featureCollection.getSchema();
        System.out.println(simpleFeatureType.getGeometryDescriptor().getLocalName());
        OutputStream ostream = new ByteArrayOutputStream();
        try {
            GeoJSON.write(featureCollection, ostream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //System.out.println(ostream);
        return featureCollection.toString();
    }

}
