package com.anderson.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_belonging")
public class Belonging {
    
    @EmbeddedId
    private BelongingPK id = new BelongingPK();
    private Integer position;

    public Belonging() {
    }

    public Belonging(Game game, GameList gameList, Integer position) {
        this.id.setGame(game);
        this.id.setGameList(gameList);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Belonging other = (Belonging) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
    
    
}
