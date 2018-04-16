package raj.lineup.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import raj.lineup.database.database.EventTypeConventor

/**
 * Created by vraj0 on 3/24/2018.
 */

@Entity(tableName = "line_up")
data class LineUp(@ColumnInfo(name = "name") var name: String, @ColumnInfo(name = "events") @TypeConverters(EventTypeConventor::class) var events: ArrayList<Int>) {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var key: Int = 0

}
