package raj.lineup.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by vraj0 on 3/24/2018.
 */

@Entity(tableName = "event")
data class Event(@ColumnInfo(name = "name") var name: String?, @ColumnInfo(name = "duration") var duration: String?, @ColumnInfo(name = "flag") var flag: Boolean) {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var key: Int = 0
}
