package raj.lineup.fragments

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import raj.lineup.adapter.EventListAdapter
import raj.lineup.database.entity.Event
import raj.lineup.databinding.FragmentHomeBinding
import raj.lineup.fragments.parent.BaseFragment
import raj.lineup.ui_handler.UiEvent
import raj.lineup.ui_handler.UiEventGenerator
import raj.lineup.ui_handler.UiEventType
import raj.lineup.viewModel.MainViewModel
import raj.lineup.backgroundTask.EventTask.InsertEvent
import raj.lineup.backgroundTask.EventTask.InsertLineUp
import raj.lineup.database.entity.LineUp


/**
 * Created by vraj0 on 3/22/2018.
 */
class HomeFragment : BaseFragment() {


    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: MainViewModel
    lateinit var radapter: EventListAdapter


    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater!!, container, false)
        viewModel = ViewModelProviders.of(activity).get(MainViewModel::class.java)
        radapter = EventListAdapter()
        binding.list.apply {
            layoutManager = LinearLayoutManager(activity)
            //itemAnimator = SlideInDownAnimator()
            this.adapter = radapter
        }
        return binding.root
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.next.setOnClickListener({ if (binding.head.text.toString().isNotEmpty()) UiEventGenerator.generateEvent(viewModel.getAddButtonEventTpe()) })
    }

    override fun animationEnd(id: Boolean) {
        if (id) {
            UiEventGenerator.generateEvent(UiEventType.initHome)
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: UiEvent) {
        when (event.type) {
            UiEventType.lineUpCreation -> createLineup()
            UiEventType.eventCreation -> insertEvent()
            UiEventType.linupSaving -> saveLineUp()
        }
    }

    private fun saveLineUp() {
        InsertLineUp(activity as AppCompatActivity, LineUp(binding.head.text.toString(), radapter.idList))
    }

    private fun createLineup() {
        binding.title.text = binding.head.text.toString()
        binding.head.hint = "Make Event"
        binding.head.text = null
        binding.time.visibility = View.VISIBLE
    }

    private fun insertEvent() {
        val event = Event(binding.head.text.toString(), binding.time.text.toString(), false)
        InsertEvent(activity as AppCompatActivity, event).start()
        radapter.update(event)
        binding.head.hint = "Make Next Event"
        binding.head.text = null
        binding.time.text = null
        binding.time.visibility = View.VISIBLE
    }
}