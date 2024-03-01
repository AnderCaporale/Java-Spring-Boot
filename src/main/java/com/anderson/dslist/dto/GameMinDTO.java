
package com.anderson.dslist.dto;

import com.anderson.dslist.entities.Game;
import com.anderson.dslist.projections.GameMinProjection;


public class GameMinDTO {

    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {
    }

    public GameMinDTO(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }
    
    public GameMinDTO(GameMinProjection gameProjection) {
        this.id = gameProjection.getId();
        this.title = gameProjection.getTitle();
        this.year = gameProjection.getYear();
        this.imgUrl = gameProjection.getImgUrl();
        this.shortDescription = gameProjection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
    
    
    
    

}
