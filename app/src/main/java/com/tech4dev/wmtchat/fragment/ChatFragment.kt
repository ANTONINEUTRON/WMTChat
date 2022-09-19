package com.tech4dev.wmtchat.fragment

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tech4dev.wmtchat.NewGroupActivity
import com.tech4dev.wmtchat.adapter.ListOfFriendsAdapter
import com.tech4dev.wmtchat.R
import com.tech4dev.wmtchat.adapter.ListOfMessagesAdapter

class ChatFragment : Fragment() {
    private lateinit var chatRecycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Declaration that this fragment will contain a menu
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        chatRecycler = view.findViewById(R.id.chatRecycler)

        chatRecycler.adapter = ListOfMessagesAdapter(requireContext())
        chatRecycler.layoutManager = LinearLayoutManager(requireContext())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.app_bar_search -> {
                Toast.makeText(requireContext(), "Search click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.new_group ->{
                goToNewGroupActivity()
                return true
            }
            R.id.new_broadcast ->{
                Toast.makeText(requireContext(), "New Broadcast click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.linked_devices -> {
                Toast.makeText(requireContext(), "Linked Devices click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.starred_messages ->{
                Toast.makeText(requireContext(), "Starred Messages click", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.settings ->{
                Toast.makeText(requireContext(), "Settings click", Toast.LENGTH_LONG).show()
                return true
            }
            else -> {
                return false
            }
        }
    }


    private fun goToNewGroupActivity(){
        val i = Intent(requireContext(), NewGroupActivity::class.java)
        startActivity(i)
    }
}