package com.example.searchviewa11ybug

import android.graphics.Color
import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_first).setOnClickListener {
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment("From FirstFragment")
            findNavController().navigate(action)
        }

        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        menu.clear()
        inflater.inflate(R.menu.menu_main, menu)

        (menu.findItem(R.id.search).actionView as SearchView?)?.apply {
            setOnSearchClickListener {
                findViewById<SearchView.SearchAutoComplete?>(androidx.appcompat.R.id.search_src_text)?.apply {
                    hint = "Search"
                    setAdapter(
                        ArrayAdapter<String>(
                            context, android.R.layout.simple_spinner_item, android.R.id.text1,
                            listOf("aaaa", "aaab", "aaac")
                        )
                    )
                    setOnItemClickListener { parent, _, position, _ ->
                        setText(parent.getItemAtPosition(position) as String)
                    }
                }
            }
        }
    }
}
