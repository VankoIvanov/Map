package com.example.map.controller;

import com.example.map.service.map.MapService;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/map")
public class MapController {
    private final MapService mapService;

    public MapController(MapService mapService) {
        this.mapService = mapService;
    }

    @GetMapping()
    public String map() {
        return "map";
    }

    @PostMapping()
    public @ResponseBody
    List<?> send() {
        List<JSONObject> str = this.mapService.getDataGeojson();
        return str;
    }

    @GetMapping("/pedestriansection/{id}")
    public String details(@PathVariable Long id, Model model){
        model.addAttribute("location",this.mapService.findPedestrianSectionById(id));
        System.out.println(model);
        return "route-details";
    }
}
