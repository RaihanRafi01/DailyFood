package com.example.dailyfood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dailyfood.adapter.NotificationAdapter
import com.example.dailyfood.databinding.FragmentNotificationBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class NotificationFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)
        dummyData()
        return binding.root
    }

    private fun dummyData() {
        val notificationText = listOf("Notification 1","Notification 2","Notification 3")
        val notificationImg = listOf(R.drawable.sademoji,R.drawable.truck,R.drawable.congrats)
        val adapter = NotificationAdapter(
            ArrayList(notificationText),
            ArrayList(notificationImg)
        )
        binding.recylerViewNotification.layoutManager = LinearLayoutManager(requireContext())
        binding.recylerViewNotification.adapter = adapter
    }

    companion object {

    }
}