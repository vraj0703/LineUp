package raj.lineup

import android.databinding.DataBindingUtil
import android.graphics.drawable.Animatable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import raj.lineup.databinding.ActivityMainBinding
import raj.lineup.fragments.HomeFragment
import raj.lineup.fragments.LineupFragment
import raj.lineup.fragments.MenuFragment
import android.transition.Explode
import android.view.Window
import android.view.WindowManager


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    var which: Int = 0
    lateinit var homeFragment: HomeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        if (savedInstanceState == null) {
            loadInitFragment()
        }

    }

    @Synchronized
    private fun changeFragment() {
        when (which) {
            0 -> homeToMenuFragment()
            1 -> menuToHomeFragment()
            2 -> lineUpToHomeFragment()
        }
    }


    private fun loadInitFragment() {
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_bottom, R.anim.exit_to_right)
                .add(R.id.fragment, homeFragment, "home")
                .commit()
        which = 0
    }

    fun homeToMenuFragment() {
        binding.menu.setImageResource(R.drawable.menu_hamburger_arrow)
        animateMenuIcon()
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left)
                .replace(R.id.fragment, MenuFragment.newInstance(), "menu")
                .addToBackStack("menu")
                .commit()
        which = 1
    }

    fun homeToLineUpFragment() {
        binding.menu.setImageResource(R.drawable.menu_hamburger_plus)
        animateMenuIcon()

        /*   val changeTransform = TransitionInflater.from(this).inflateTransition(R.transition.change_image_transform)
           val explodeTransform = TransitionInflater.from(this).inflateTransition(android.R.transition.explode)

           // Setup exit transition on first fragment
           homeFragment.sharedElementReturnTransition = changeTransform
           homeFragment.exitTransition = explodeTransform

           // Setup enter transition on second fragment
           val lineupFragment = LineupFragment.newInstance()
           lineupFragment.sharedElementEnterTransition = changeTransform
           lineupFragment.enterTransition = explodeTransform

           // Find the shared element (in Fragment A)
           val ivProfile = findViewById<TextView>(R.id.head)
           ViewCompat.setTransitionName(ivProfile, "1")
           // Add second fragment by replacing first*/
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, LineupFragment.newInstance(), "lineup")
                .addToBackStack("lineup")
                .commit()
        which = 2
    }

    private fun menuToHomeFragment() {
        binding.menu.setImageResource(R.drawable.menu_arrow_hamburger)
        animateMenuIcon()
        supportFragmentManager.popBackStack()
        which = 0
    }

    private fun lineUpToHomeFragment() {
        binding.menu.setImageResource(R.drawable.menu_plus_hamburger)
        animateMenuIcon()
        supportFragmentManager.popBackStack()
        which = 0
    }

    fun init() {
        binding.menu.setOnClickListener({ _ -> changeFragment() })
    }

    fun showMenuIcon() {
        binding.menu.visibility = View.VISIBLE
    }

    fun animateMenuIcon() {
        (binding.menu.drawable as Animatable).start()
    }

    override fun onBackPressed() {
        if (which != 0)
            changeFragment()
    }

}
