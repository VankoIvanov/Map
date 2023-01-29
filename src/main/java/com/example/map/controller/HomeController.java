package com.example.map.controller;

import com.example.map.service.picture.PictureService;
import com.example.map.util.db;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class HomeController {

    private final PictureService pictureService;
//    public com.example.map.util.db db;

    public HomeController(PictureService pictureService) {
        this.pictureService = pictureService;
    }

    @GetMapping("/")
    String index(Model model){
        model.addAttribute("pictures", this.pictureService.findAllUrls());
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }


//    @GetMapping("/map")
//    public String map(){
//        //db.readFile();
//        return "map";
//    }

//    @PostMapping("/map")
//    public String send(){
//        return db.readFile();
//    }
}