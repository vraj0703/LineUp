package raj.lineup

import android.databinding.DataBindingUtil
import android.graphics.drawable.Animatable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import raj.lineup.databinding.ActivityMainBinding
import raj.lineup.fragments.HomeFragment
import raj.lineup.fragments.MenuFragment
import android.view.WindowManager
import raj.lineup.viewModel.MainViewModel
import android.arch.lifecycle.ViewModelProviders
import android.support.annotation.DrawableRes
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import raj.lineup.ui_handler.UiEvent
import raj.lineup.ui_handler.UiEventGenerator
import raj.lineup.ui_handler.UiEventType


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    lateinit var homeFragment: HomeFragment
    lateinit var menuFragment: MenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        if (savedInstanceState == null) {
            loadInitFragment()
        }
    }

    public override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    public override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEvent(event: UiEvent) {
        when (event.type) {
            UiEventType.initHome -> init()
            UiEventType.fragmentChangeHomeToMenu -> homeToMenuFragment()
            UiEventType.fragmentChangrMenuToHome -> menuToHomeFragment()
            UiEventType.lineUpCreation -> homeToLineUpFragment()
        }
    }

    fun navButtonClicked(view: View) {
        UiEventGenerator.generateEvent(viewModel.getNavButtonEventTpe())
    }

    private fun loadInitFragment() {
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_right)
                .add(R.id.fragment, homeFragment, "home")
                .commit()
        viewModel.screen = 0
    }

    private fun init() {
        showMenuIcon()
        animateMenuIcon(R.drawable.menu_null_hamburger)
        menuFragment = MenuFragment.newInstance()
    }

    private fun showMenuIcon() {
        binding.menu.visibility = View.VISIBLE
    }

    private fun animateMenuIcon(@DrawableRes image: Int) {
        binding.menu.setImageResource(image)
        (binding.menu.drawable as Animatable).start()
    }


    private fun homeToMenuFragment() {
        animateMenuIcon(R.drawable.menu_hamburger_arrow)
        this.supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
                .add(R.id.fragment, menuFragment, "menu")
                .addToBackStack("menu")
                .commit()
        viewModel.screen = 1
    }

    private fun menuToHomeFragment() {
        animateMenuIcon(R.drawable.menu_arrow_hamburger)
        supportFragmentManager.popBackStack()
        viewModel.screen = 0
    }

    fun homeToLineUpFragment() {
        animateMenuIcon(R.drawable.menu_hamburger_plus)
        viewModel.screen = 2
    }

    private fun lineUpToHomeFragment() {
        animateMenuIcon(R.drawable.menu_plus_hamburger)
        supportFragmentManager.popBackStack()
        viewModel.screen = 0
    }

    override fun onBackPressed() {

        //changeFragment()
    }

}
