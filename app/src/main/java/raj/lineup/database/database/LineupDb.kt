package raj.lineup.database.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

import raj.lineup.database.dao.LineupDao
import raj.lineup.database.entity.Event
import raj.lineup.database.entity.LineUp

/**
 * Created by vraj0 on 4/9/2018.
 */
@Database(entities = [(LineUp::class), (Event::class)], version = 3, exportSchema = false)
abstract class LineupDb : RoomDatabase() {
    abstract fun daoAccess(): LineupDao
}

