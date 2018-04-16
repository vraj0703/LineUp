package raj.lineup.adapter

import android.databinding.ViewDataBinding
import raj.lineup.R
import raj.lineup.database.database.LineupDb
import raj.lineup.database.entity.Event
import raj.lineup.databinding.LayoutEventBinding

/**
 * Created by vraj0 on 3/30/2018.
 */

class EventListAdapter : RecyclerViewAdapterLayoutId(R.layout.layout_event) {

    val list: ArrayList<Event> = ArrayList()
    val idList: ArrayList<Int> = ArrayList()

    override fun updateBinding(binding: ViewDataBinding, position: Int) {
        binding as LayoutEventBinding
        binding.event = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update(item: Event) {
        list.add(0, item)
        idList.add(item.key)
        notifyItemInserted(0)
    }

    fun getEventsId(): List<Int> {
        return idList
    }
}
