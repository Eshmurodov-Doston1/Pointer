package com.example.pointer

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.AnimationUtils
import android.view.animation.RotateAnimation
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.pointer.databinding.ActivityMainBinding
import com.example.pointer.models.interfaceMy.ButtonClick

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val overlay = binding.container
        overlay.systemUiVisibility = (View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or  View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.parseColor("#F7F7FC")
        window.navigationBarColor = Color.parseColor("#F7F7FC")

        val navigation = findNavController(R.id.nav_host_fragment)
        binding.apply {
            mainMenuBtn.setOnClickListener {
                val viewPager = findViewById<ViewPager2>(R.id.main_viewPager)
                var handlerThread =  Handler(Looper.getMainLooper())
                if (navigation.currentDestination?.id==R.id.mainFragment){
                    handlerThread.postDelayed({
                        mainMenuBtn.setImageResource(R.drawable.ic_vector_3)
                        mainMenuBtn.setPadding(0,0,0,9)
                    },490)
                    var rotateAnimation = RotateAnimation(0F, 180F,RotateAnimation.RELATIVE_TO_SELF,.5f,RotateAnimation.RELATIVE_TO_SELF,.5f)
                    rotateAnimation.duration = 450
                    mainMenuBtn.startAnimation(rotateAnimation)

                    when(viewPager.currentItem){
                        0->{
                            val myCard = findViewById<ConstraintLayout>(R.id.button)
                            val extras = FragmentNavigatorExtras(myCard to "view")
                            navigation.navigate(R.id.myCourceFragment, null, null, extras)
                        }
                        1->{
                            val myCard = findViewById<ConstraintLayout>(R.id.card_my)
                            val extras = FragmentNavigatorExtras(myCard to "My_cardView")
                                navigation.navigate(R.id.videoCourcesFragment, null, null, extras)
                        }
                        2->{
                            val myCard = findViewById<ConstraintLayout>(R.id.view_button)
                            val extras = FragmentNavigatorExtras(myCard to "view_my")
                                navigation.navigate(R.id.newsFragment, null, null, extras)
                        }
                        3->{
                            val myCard = findViewById<ConstraintLayout>(R.id.cons_training)
                            val extras = FragmentNavigatorExtras(myCard to "cons")
                                navigation.navigate(R.id.trainingMainFragment, null, null, extras)
                        }
                        4->{
                            val myCard = findViewById<ConstraintLayout>(R.id.view_item)
                            val extras = FragmentNavigatorExtras(myCard to "my_view")
                                navigation.navigate(R.id.myGroupFragment, null, null, extras)
                        }
                        5->{
                            val myCard = findViewById<ConstraintLayout>(R.id.cons1)
                            val extras = FragmentNavigatorExtras(myCard to "my_calendar")
                                navigation.navigate(R.id.calendarFragment, null, null, extras)
                        }
                        6->{
                            val myCard = findViewById<ConstraintLayout>(R.id.my_cons_chat)
                            val extras = FragmentNavigatorExtras(myCard to "chat")
                                navigation.navigate(R.id.chatFragment,null,null,extras)
                        }
                        7->{
                            val myCard = findViewById<ConstraintLayout>(R.id.my_cons1)
                            val extras = FragmentNavigatorExtras(myCard to "payme")
                                navigation.navigate(R.id.paymeFragment, null, null, extras)
                        }
                        8->{
                            val myCard = findViewById<LinearLayout>(R.id.my_cons_settings)
                            val extras = FragmentNavigatorExtras(myCard to "settings")
                                navigation.navigate(R.id.settingsFragment, null, null, extras)
                        }

                    }
                }else{
                    navigation.popBackStack()

                    handlerThread.postDelayed({
                        mainMenuBtn.setImageResource(R.drawable.ic_group_4)
                        mainMenuBtn.setPadding(0,0,0,0)
                    },490)
                    var rotateAnimation = RotateAnimation(0F, 180F,RotateAnimation.RELATIVE_TO_SELF,.5f,RotateAnimation.RELATIVE_TO_SELF,.5f)
                    rotateAnimation.duration = 450
                    mainMenuBtn.startAnimation(rotateAnimation)

                }
            }
        }

    }

    override fun onNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp()
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