package com.example.pointer

import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.viewpager2.widget.ViewPager2
import at.markushi.ui.CircleButton
import com.example.pointer.databinding.ActivityMainBinding
import com.example.pointer.models.interfaceMy.ButtonClick
import com.example.pointer.utils.SharedPref
import java.util.*

lateinit var navLine: ImageView
lateinit var navButton: CircleButton

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var mySharedPreference: SharedPref
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mySharedPreference = SharedPref(this)
        setLocale()

//        if (mySharedPreference.getBoolean() == true) {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
//        } else {
//            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
//        }
        val overlay = binding.container
        overlay.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.parseColor("#F7F7FC")
        window.navigationBarColor = Color.parseColor("#F7F7FC")

        navLine = binding.line
        navButton = binding.mainMenuBtn


        val navigation = findNavController(R.id.nav_host_fragment)
        binding.apply {
            mainMenuBtn.setOnClickListener {
                val viewPager = findViewById<ViewPager2>(R.id.main_viewPager)
                var handlerThread = Handler(Looper.getMainLooper())
                if (navigation.currentDestination?.id == R.id.mainFragment) {
                    handlerThread.postDelayed({
                        mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
                        mainMenuBtn.setPadding(0, 0, 0, 9)
                    }, 490)
                    var rotateAnimation = RotateAnimation(
                        0F,
                        180F,
                        RotateAnimation.RELATIVE_TO_SELF,
                        .5f,
                        RotateAnimation.RELATIVE_TO_SELF,
                        .5f
                    )
                    rotateAnimation.duration = 450
                    mainMenuBtn.startAnimation(rotateAnimation)

                    when (viewPager.currentItem) {
                        0 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.button)
                            val extras = FragmentNavigatorExtras(myCard to "view")
                            navigation.navigate(R.id.myCourceFragment, null, null, extras)
                        }
                        1 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.card_my)
                            val extras = FragmentNavigatorExtras(myCard to "My_cardView")
                            navigation.navigate(R.id.videoCourcesFragment, null, null, extras)
                        }
                        2 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.view_button)
                            val extras = FragmentNavigatorExtras(myCard to "view_my")
                            navigation.navigate(R.id.newsFragment, null, null, extras)
                        }
                        3 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.cons_training)
                            val extras = FragmentNavigatorExtras(myCard to "cons")
                            navigation.navigate(R.id.trainingMainFragment, null, null, extras)
                        }
                        4 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.view_item)
                            val extras = FragmentNavigatorExtras(myCard to "my_view")
                            navigation.navigate(R.id.myGroupFragment, null, null, extras)
                        }
                        5 -> {
                            val myCard = findViewById<ConstraintLayout>(R.id.cons1)
                            val extras = FragmentNavigatorExtras(myCard to "my_calendar")
                            navigation.navigate(R.id.calendarFragment, null, null, extras)
                        }
//                        6 -> {
//                            val myCard = findViewById<ConstraintLayout>(R.id.my_cons_chat)
//                            val extras = FragmentNavigatorExtras(myCard to "chat")
//                            navigation.navigate(R.id.chatListFragment, null, null, extras)
//                        }
//                        7 -> {
//                            val myCard = findViewById<ConstraintLayout>(R.id.my_cons1)
//                            val extras = FragmentNavigatorExtras(myCard to "payme")
//                            navigation.navigate(R.id.paymentFragment, null, null, extras)
//                        }
//                        8 -> {
//                            val myCard = findViewById<LinearLayout>(R.id.my_cons_settings)
//                            val extras = FragmentNavigatorExtras(myCard to "settings")
//                            navigation.navigate(R.id.settingsFragment, null, null, extras)
//                        }

                    }
                } else {
                    navigation.popBackStack()

                    handlerThread.postDelayed({
                        mainMenuBtn.setImageResource(R.drawable.ic_group_4)
                        mainMenuBtn.setPadding(0, 0, 0, 0)
                    }, 490)
                    var rotateAnimation = RotateAnimation(
                        0F,
                        180F,
                        RotateAnimation.RELATIVE_TO_SELF,
                        .5f,
                        RotateAnimation.RELATIVE_TO_SELF,
                        .5f
                    )
                    rotateAnimation.duration = 450
                    mainMenuBtn.startAnimation(rotateAnimation)

                }
            }
        }

    }

    private fun setLocale() {
        val locale = Locale(mySharedPreference.getLang())
        Locale.setDefault(locale)
        val config: Configuration = resources.configuration
        config.locale = locale
        resources.updateConfiguration(config, resources.displayMetrics)
    }

    override fun onNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
    }

    override fun onResume() {
        super.onResume()
        val overlay = binding.container
        overlay.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)
    }
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) {
//            window.decorView.systemUiVisibility = (
//                    View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                    or View.SYSTEM_UI_FLAG_FULLSCREEN
//                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
    }
}