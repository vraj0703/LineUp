package raj.lineup

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import raj.lineup.adapter.TestRecyclerAdapter
import raj.lineup.databinding.ActivityTestBinding
import raj.lineup.interfaces.TestCallback
import raj.lineup.observable.TestObservable


class TestActivity : AppCompatActivity(), TestCallback {

    lateinit var binding: ActivityTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_test)
        val observable = TestObservable(this)
        binding.observable = observable

        setUpRecyclerView()

    }

    private fun setUpRecyclerView() {
        if (binding.list.adapter == null) {
            binding.list.adapter = TestRecyclerAdapter(ArrayList())
        }
        if (binding.list.layoutManager == null) {
            binding.list.layoutManager = LinearLayoutManager(this)
        }
    }

    override fun onCallback(text: String?) {
        val adapter = binding.list.adapter as TestRecyclerAdapter
        if (text != null) {
            adapter.update(text)
        }
    }
}
