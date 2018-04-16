package raj.lineup.adapter

import android.databinding.ViewDataBinding
import raj.lineup.R
import raj.lineup.databinding.LayoutTestBinding

/**
 * Created by vraj0 on 3/21/2018.
 */
class TestRecyclerAdapter : RecyclerViewAdapterLayoutId(R.layout.layout_test) {

    val list: ArrayList<String> = ArrayList()

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