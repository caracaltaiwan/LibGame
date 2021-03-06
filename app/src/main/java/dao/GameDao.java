package dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import entity.Game;

@Dao
public interface GameDao {

    /* ==== INSERT ==== */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Game game);

    /* ==== GET ==== */
    @Query("SELECT * FROM game_table")
    List<Game> getAllGames();

    @Query("SELECT * FROM game_table WHERE id = :idGame")
    Game getGameById(int idGame);

    /* ==== UPDATE ==== */
    @Query("UPDATE game_table SET name = :name, description = :description WHERE id = :id")
    void update(int id, String name, String description);

    /* ==== DELETE ==== */
    @Query("DELETE FROM game_table")
    void deleteAll();

    @Query("DELETE FROM game_table WHERE id = :idGame")
    void deleteGame(int idGame);
}
