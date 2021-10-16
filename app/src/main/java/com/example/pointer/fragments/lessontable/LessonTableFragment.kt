package com.example.pointer.fragments.lessontable

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.fragment.findNavController
import com.example.pointer.R
import com.example.pointer.adapters.TableRecyclerAdapter
import com.example.pointer.databinding.FragmentLessonTableBinding
import com.example.pointer.models.Table
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialSharedAxis

class LessonTableFragment : Fragment() {

    private lateinit var binding: FragmentLessonTableBinding
    private lateinit var adapter: TableRecyclerAdapter
    private lateinit var list: ArrayList<Table>

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLessonTableBinding.inflate(inflater, container, false)


        val days:ArrayList<String> = arguments?.getStringArrayList("list") as ArrayList<String>
        val dayOfWeek = arguments?.getInt("week", 0)

        binding.back.setOnClickListener{
            findNavController().popBackStack()
        }

        binding.day1.text = days[0]
        binding.day2.text = days[1]
        binding.day3.text = days[2]
        binding.day4.text = days[3]
        binding.day5.text = days[4]
        binding.day6.text = days[5]
        binding.day7.text = days[6]

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }
        var activeWeek: LinearLayout? = null

        val weekClickListen = View.OnClickListener{

            if (activeWeek != it) {
                when (it.id) {
                    R.id.yetti -> {

                        Toast.makeText(requireContext(), "Dam olish kuni", Toast.LENGTH_SHORT)
                            .show()
                        adapter = TableRecyclerAdapter(requireContext(), initList5())
                    }
                    R.id.bir -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList2())
                    }
                    R.id.ikki -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList3())
                    }
                    R.id.uch -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList())
                    }
                    R.id.tort -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList3())
                    }
                    R.id.besh -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList2())
                    }
                    R.id.olti -> {
                        adapter = TableRecyclerAdapter(requireContext(), initList())
                    }
                }

                binding.rv.adapter = adapter
                (it as LinearLayout).setBackgroundResource(R.drawable.back_style)
                if (activeWeek!=null) {
                    activeWeek?.setBackgroundResource(R.color.purple_200)
                    (activeWeek?.getChildAt(0) as TextView).setTextColor(Color.GRAY)
                    (activeWeek?.getChildAt(1) as TextView).setTextColor(Color.GRAY)
                }
                (it.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                (it.getChildAt(1) as TextView).setTextColor(Color.WHITE)
                binding.rv.visibility = View.VISIBLE
                activeWeek = it
            }
        }

        binding.yetti.setOnClickListener(weekClickListen)
        binding.bir.setOnClickListener(weekClickListen)
        binding.ikki.setOnClickListener(weekClickListen)
        binding.uch.setOnClickListener(weekClickListen)
        binding.tort.setOnClickListener(weekClickListen)
        binding.besh.setOnClickListener(weekClickListen)
        binding.olti.setOnClickListener(weekClickListen)


        when (dayOfWeek) {
            1 -> {
                binding.yetti.callOnClick()
            }
            2 -> {
                binding.bir.callOnClick()
            }
            3 -> {
                binding.ikki.callOnClick()
            }
            4 -> {
                binding.uch.callOnClick()
            }
            5 -> {
                binding.tort.callOnClick()
            }
            6 -> {
                binding.besh.callOnClick()
            }
            7 -> {
                binding.olti.callOnClick()
            }
        }

        return binding.root
    }

    private fun initList(): ArrayList<Table> {

        list = ArrayList<Table>()

        list.add(Table("11:00", "13:00", "Java", "313-19", "4-201",R.drawable.click3, "Bektayev Asadbek"))
        list.add(Table("15:00", "17:00", "Kotlin", "312-18", "2-200",R.drawable.click1, "Qosimov Shahrizod"))
        list.add(Table("17:00", "19:00", "C++", "310-17", "4-208",R.drawable.click2, "Bozorov Bobur"))
        return list
    }

    private fun initList2(): ArrayList<Table> {

        list = ArrayList<Table>()

        list.add(Table("15:00", "17:00", "Kotlin", "312-18", "2-200",R.drawable.click1, "Qosimov Shahrizod"))
        list.add(Table("17:00", "19:00", "C++", "310-17", "4-208",R.drawable.click2, "Bozorov Bobur"))

        return list
    }
    private fun initList5(): ArrayList<Table> {

        list = ArrayList<Table>()


        return list
    }

    private fun initList3(): ArrayList<Table> {

        list = ArrayList<Table>()

        list.add(Table("15:00", "17:00", "Kotlin", "312-18", "2-200",R.drawable.click1, "Qosimov Shahrizod"))
        return list
    }

}