package com.jordanburke.videogamelibrary;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by jordanburke on 4/12/18.
 */
@Dao
public interface VideoGameDao {

    //Allow us to get all video game
    @Query("SELECT * FROM gamemodel")
    List<GameModel> getVideoGames();

    // allows us to get a single game to the list
    @Insert
    void addVideoGame(GameModel gameMode);

    //Allows us to update the values of an existing game
    @Update
    void updateVideoGame(GameModel gameModel);


    //Allows us to delete a game from the library

    @Delete
    void deleteVideoGame(GameModel gameModel);

}
