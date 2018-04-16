package raj.lineup.database.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*
import java.util.Collections.emptyList


/**
 * Created by vraj0 on 4/12/2018.
 */

class EventTypeConventor {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Int> {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<Int>>() {
        }.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Int>): String {
        return gson.toJson(someObjects)
    }
}
