package raj.lineup.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import raj.lineup.R
import raj.lineup.databinding.FragmentHomeBinding
import raj.lineup.databinding.FragmentLineupBinding

/**
 * Created by vraj0 on 3/22/2018.
 */

class LineupFragment : Fragment() {

    lateinit var binding: FragmentLineupBinding

    companion object {
        fun newInstance(): LineupFragment {
            return LineupFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentLineupBinding.inflate(inflater!!, container, false)
        return binding.root
    }

}
