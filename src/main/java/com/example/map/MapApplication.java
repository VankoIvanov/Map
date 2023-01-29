package com.example.map;

import com.example.map.util.db;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapApplication.class, args);
        db d=new db();
        d.readFile();
    }


}
