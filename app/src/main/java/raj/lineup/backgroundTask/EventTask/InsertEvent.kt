package raj.lineup.backgroundTask.EventTask

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity

import raj.first.AppActivity
import raj.lineup.backgroundTask.BackgroundTask
import raj.lineup.database.database.LineupDb
import raj.lineup.database.entity.Event
import raj.lineup.utils.Constant

/**
 * Created by vraj0 on 4/12/2018.
 */

class InsertEvent(private val activity: AppCompatActivity, private val event: Event) : BackgroundTask(activity, null) {

    override fun doTask(): String {
        val db = Room.databaseBuilder(activity, LineupDb::class.java!!, Constant.dbName).build()
        db.daoAccess().insertEvent(event)
        return ""
    }
}
