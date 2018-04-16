package raj.lineup.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by vraj0 on 3/21/2018.
 */

abstract class RecyclerViewAdapterLayoutId(@param:LayoutRes @field:LayoutRes
                                     private val layoutId: Int) : RecyclerView.Adapter<RecyclerViewAdapterLayoutId.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapterLayoutId.ViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layoutId, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val binding = holder.binding
        updateBinding(binding, position)
    }

    protected abstract fun updateBinding(binding: ViewDataBinding, position: Int)

    inner class ViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)
}
