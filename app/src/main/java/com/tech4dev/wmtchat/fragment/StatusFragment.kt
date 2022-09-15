package com.tech4dev.wmtchat.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.tech4dev.wmtchat.CameraActivity
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.adapter.StatusAdapter

class StatusFragment : Fragment() {
    private lateinit var statusRecyclerView: RecyclerView
    private lateinit var cameraBtn: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_status, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initRecyclerview(view)

        //setup the camera button
        cameraBtn = view.findViewById(R.id.cameraBtn)
        cameraBtn.setOnClickListener {
            val intent = Intent(requireContext(), CameraActivity::class.java)
            requireContext().startActivity(intent)
        }
    }

    private fun initRecyclerview(view: View) {
        statusRecyclerView = view.findViewById(R.id.statusRV)
        statusRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        statusRecyclerView.adapter = StatusAdapter(requireContext())
    }
}