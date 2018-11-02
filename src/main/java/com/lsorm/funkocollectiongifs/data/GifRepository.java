package com.lsorm.funkocollectiongifs.data;

import com.lsorm.funkocollectiongifs.model.Gif;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GifRepository {
    private static final List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("nycc-batman", 1, LocalDate.of(2018,10,4), "pop-collector-1909", true),
            new Gif("nycc-killerfrost", 1, LocalDate.of(2018,10,4), "pop-collector-8273", false),
            new Gif("nycc-okoye", 1,  LocalDate.of(2018,10,4), "pop-collector-8263", true)
    );

    public Gif findByName(String name) {
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().equals(name)) {
                return gif;
            }
        }
        return null;
    }

    public List<Gif> getAllGifs() {
        return ALL_GIFS;
    }

    public List<Gif> findByCategoryId(int id){
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS){
            if(gif.getCategoryId() == id){
                gifs.add(gif);
            }
        }
        return gifs;
    }

    public List<Gif> findByFavoriteMark() {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.isFavorite()) {
                gifs.add(gif);
            }
        }
        return gifs;
    }

    public List<Gif> findBySearch(String search) {
        List<Gif> gifs = new ArrayList<>();
        for(Gif gif : ALL_GIFS) {
            if(gif.getName().toLowerCase().contains(search)) {
                gifs.add(gif);
            }
        }
        return gifs;
    }


}
