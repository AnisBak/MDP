package com.anis.lesson7_8_cv_builder.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anis.lesson7_8_cv_builder.R
import com.anis.lesson7_8_cv_builder.data.Work
import com.anis.lesson7_8_cv_builder.ui.dialog.WorkDialog
import com.anis.lesson7_8_cv_builder.adapter.WorkAdapter

class WorkFragment : Fragment(R.layout.fragment_work) {

    private var workList = mutableListOf<Work>()
    private lateinit var adapter: WorkAdapter
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerView = view.findViewById(R.id.recycler_view)
        if (context != null) {
            workList = mutableListOf(
                Work(
                    getString(R.string.collabera),
                    getString(R.string.senior_android_developer),
                    getString(R.string._2022_present),
                    R.drawable.collabera
                ),
                Work(
                    getString(R.string.resux),
                    getString(R.string.android_developer),
                    getString(R.string._2019_2021),
                    R.drawable.resux
                ),
                Work(
                    getString(R.string.four_points),
                    getString(R.string.it_coordinator),
                    getString(R.string._2018_2019),
                    R.drawable.fourpoints
                ),
                Work(
                    getString(R.string.resux),
                    getString(R.string.sr_full_stack_engineer),
                    getString(R.string._2016_2018),
                    R.drawable.resux
                )
            )
            setupRecyclerView()
        }

        val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener { showWorkDialog() }
    }

    private fun setupRecyclerView() {
        if (::recyclerView.isInitialized) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter = WorkAdapter(requireContext(), workList)
            recyclerView.adapter = adapter
        }
    }

    private fun showWorkDialog() {
        val dialog = WorkDialog()
        dialog.show(parentFragmentManager, WorkDialog::class.java.name)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun onAddWOrk(work: Work) {
        workList.add(work)
        if (::adapter.isInitialized) {
            adapter.notifyDataSetChanged()
        } else {
            setupRecyclerView()
        }
    }

}