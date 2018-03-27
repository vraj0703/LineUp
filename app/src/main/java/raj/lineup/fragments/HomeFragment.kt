package raj.lineup.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import raj.lineup.MainActivity
import raj.lineup.databinding.FragmentHomeBinding
import raj.lineup.fragments.parent.BaseFragment


/**
 * Created by vraj0 on 3/22/2018.
 */
class HomeFragment : BaseFragment() {


    lateinit var binding: FragmentHomeBinding

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater!!, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.next.setOnClickListener(View.OnClickListener { _ -> raj.lineup.utils.AnimationUtils.moveAtoB(activity as AppCompatActivity, binding.head, binding.title) })
    }

    override fun animationEnd(id: Boolean) {
        if (id) {
            (activity as MainActivity).showMenuIcon()
            (activity as MainActivity).animateMenuIcon()
            (activity as MainActivity).init()
        }
    }


}