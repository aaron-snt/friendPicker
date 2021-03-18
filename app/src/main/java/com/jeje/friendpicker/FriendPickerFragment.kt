package com.jeje.friendpicker

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_friend_picker.*

/**
 * A simple [Fragment] subclass.
 * Use the [FriendPickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FriendPickerFragment : Fragment() {

    // RecyclerView.adapter에 지정할 Adapter
    private lateinit var pickerAdapter: FriendPickerAdapter

    var dataList: ArrayList<Friend> = arrayListOf(
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan"),
        Friend("https://img.hankyung.com/photo/201903/AA.19067065.1.jpg", "Ryan")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_friend_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var list: ArrayList<Friend> = requireActivity().intent!!.extras!!.get("DataList") as ArrayList<Friend>
        Log.e("FirstFragment", "Data List: ${list}")

        pickerAdapter = FriendPickerAdapter(context!!)
        recyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        recyclerView.adapter = pickerAdapter
        pickerAdapter.data = dataList
        pickerAdapter.notifyDataSetChanged()
    }

}

data class Friend(
    var profileImage: String? = null,
    var nickName: String? = null
)