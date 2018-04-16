package raj.lineup.backgroundTask

import android.app.LoaderManager
import android.content.AsyncTaskLoader
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import raj.first.AppActivity

/**
 * Created by vraj0 on 4/12/2018.
 */

abstract class BackgroundTask constructor(private val activity: AppCompatActivity, private val args: Bundle?) : LoaderManager.LoaderCallbacks<String> {

    fun start() {
        activity.loaderManager.initLoader(0, args, this).forceLoad()
    }

    abstract fun doTask(): String

    override fun onCreateLoader(id: Int, args: Bundle?): android.content.Loader<String> {
        //show progress bar here
        Toast.makeText(activity, "start", Toast.LENGTH_SHORT).show()
        return Task(activity, Implementor())
    }

    override fun onLoadFinished(loader: android.content.Loader<String>, data: String) {
        //hide progress bar here
        Toast.makeText(activity, "end", Toast.LENGTH_SHORT).show()
    }

    override fun onLoaderReset(loader: android.content.Loader<String>) {

    }


    /*-------------------------------------------Task-------------------------------------------------------*/
    class Task(context: Context, private val _interface: Interface) : AsyncTaskLoader<String>(context) {
        override fun loadInBackground(): String {
            return _interface.implementTask()
        }
    }

    /*--------------------------------------------Interface-------------------------------------------------*/
    interface Interface {
        fun implementTask(): String
    }

    /*--------------------------------------------Implementor-----------------------------------------------*/
    internal inner class Implementor : Interface {
        override fun implementTask(): String {
            return doTask()
        }
    }
}
