package raj.lineup.adapter

import android.databinding.ViewDataBinding
import raj.lineup.R
import raj.lineup.databinding.LayoutTestBinding

/**
 * Created by vraj0 on 3/21/2018.
 */
class TestRecyclerAdapter(val list: ArrayList<String>) : RecyclerViewAdapterLayoutId(R.layout.layout_test) {

    override fun updateBinding(binding: ViewDataBinding, position: Int) {
        binding as LayoutTestBinding
        binding.text = list[position]
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun update(item: String) {
        list.add(item)
        notifyDataSetChanged()
    }
}