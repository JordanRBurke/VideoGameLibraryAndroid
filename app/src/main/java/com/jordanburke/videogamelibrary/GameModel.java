package com.jordanburke.videogamelibrary;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Date;

/**
 * Created by jordanburke on 4/12/18.
 */

@Entity
public class GameModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String gameTitle;
    private String gameDetails;
    private boolean isCheckedOut;
    private Date date;

    public GameModel(String gameTitle, String gameDetails, boolean isCheckedOut, Date date) {
        this.gameTitle = gameTitle;
        this.gameDetails = gameDetails;
        this.isCheckedOut = isCheckedOut;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGameTitle(String gameTitle) {
        this.gameTitle = gameTitle;
    }

    public void setGameDetails(String gameDetails) {
        this.gameDetails = gameDetails;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getGameDetails() {
        return gameDetails;
    }
}
