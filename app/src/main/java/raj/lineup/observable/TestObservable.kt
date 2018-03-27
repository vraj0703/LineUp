package raj.lineup.observable

import android.databinding.BaseObservable
import android.view.View

import raj.lineup.interfaces.TestCallback

/**
 * Created by vraj0 on 3/21/2018.
 */

class TestObservable(private val callback: TestCallback) : BaseObservable() {
    var text: String? = ""

    fun onClick(v: View) {
        callback.onCallback(text)
    }
}
