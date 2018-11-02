package com.lsorm.funkocollectiongifs.controller;

import com.lsorm.funkocollectiongifs.data.GifRepository;
import com.lsorm.funkocollectiongifs.model.Gif;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GifController {
    @Autowired
    private GifRepository gifRepository;

    @RequestMapping(value = "/")
    public String listGifs(ModelMap modelMap) {
        List<Gif> allGifs = gifRepository.getAllGifs();
        modelMap.put("gifs", allGifs);
        return "home";
    }

    @RequestMapping("/gif/{name}")
    public String gifDetails(@PathVariable String name, ModelMap modelMap) {
        Gif gif = gifRepository.findByName(name);
        modelMap.put("gif", gif);
        return "gif-details";
    }

    @RequestMapping("/favorites")
    public String listFavorites(ModelMap modelMap) {
        List<Gif> gifs = gifRepository.findByFavoriteMark();
        modelMap.put("gifs", gifs);
        return "favorites";
    }

    @RequestMapping(value="/", params="q")
    public String listSearch(@RequestParam("q") String q, ModelMap modelMap) {
        List<Gif> gifs= gifRepository.findBySearch(q);
        modelMap.put("gifs", gifs);
        return "search";
    }


}
