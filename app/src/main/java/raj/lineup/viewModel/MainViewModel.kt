package raj.lineup.viewModel

import android.arch.lifecycle.ViewModel
import raj.lineup.ui_handler.UiEventType

/**
 * Created by vraj0 on 3/24/2018.
 */

class MainViewModel : ViewModel() {
    var screen: Int = 0 // 0-> lineup list 1 -> menu screen 2 -> event creation

    fun getNavButtonEventTpe(): UiEventType {
        when (screen) {
            0 -> return UiEventType.fragmentChangeHomeToMenu
            1 -> return UiEventType.fragmentChangrMenuToHome
            2 -> return UiEventType.linupSaving
        }
        return UiEventType.initHome
    }

    fun getAddButtonEventTpe(): UiEventType {
        when (screen) {
            0 -> return UiEventType.lineUpCreation
            2 -> return UiEventType.eventCreation
        }
        return UiEventType.initHome
    }
}
