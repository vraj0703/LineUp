package raj.lineup.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import raj.lineup.database.entity.Event;
import raj.lineup.database.entity.LineUp;

/**
 * Created by vraj0 on 4/9/2018.
 */

@Dao
public interface LineupDao {

    @Insert
    void insertLineUp(LineUp lineUp);

    @Delete
    void deleteLinup(LineUp lineUp);

    @Insert
    void insertEvent(Event event);

   /* @Delete
    void deleteEvent();*/

    @Query("SELECT * FROM line_up")
    LiveData<List<LineUp>> fetchLineUps();
}
