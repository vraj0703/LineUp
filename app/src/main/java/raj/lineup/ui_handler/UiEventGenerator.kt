package raj.lineup.ui_handler

import org.greenrobot.eventbus.EventBus

/**
 * Created by vraj0 on 4/9/2018.
 */

class UiEventGenerator {
    companion object {
        fun generateEvent(event: UiEventType) {
            EventBus.getDefault().post(UiEvent(event))
        }
    }
}
