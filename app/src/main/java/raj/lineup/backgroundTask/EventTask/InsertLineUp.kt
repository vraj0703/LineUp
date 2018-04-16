package raj.lineup.backgroundTask.EventTask

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import raj.lineup.backgroundTask.BackgroundTask
import raj.lineup.database.database.LineupDb
import raj.lineup.database.entity.Event
import raj.lineup.database.entity.LineUp
import raj.lineup.utils.Constant

class InsertLineUp (private val activity: AppCompatActivity, private val lineUp: LineUp) : BackgroundTask(activity, null) {

    override fun doTask(): String {
        val db = Room.databaseBuilder(activity, LineupDb::class.java!!, Constant.dbName).build()
        db.daoAccess().insertLineUp(lineUp)
        return ""
    }
}

