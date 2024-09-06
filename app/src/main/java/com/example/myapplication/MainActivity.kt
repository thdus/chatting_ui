package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chatList = mutableListOf<Chat>()
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))
        chatList.add(Chat("안녕하세요", false))

        val adapter = ChatRecyclerAdapter(
            chatList = chatList,
            inflater = LayoutInflater.from(this@MainActivity))
        with(findViewById<RecyclerView>(R.id.chatRecyclerView)) {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter

        }

    }
}
class ChatRecyclerAdapter(
    val chatList : MutableList<Chat>,
    val inflater: LayoutInflater
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class RightViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val righttextView: TextView
        init {
            righttextView = itemView.findViewById(R.id.chatTextRight)
        }
    }

    class LeftViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val lefttextView: TextView
        init {
            lefttextView = itemView.findViewById(R.id.chatTextleft)
        }
    }

    override fun getItemViewType(position: Int): Int {
        when (chatList.get(position).is_right) {
            true -> return 1
            false -> return 0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            1 -> return RightViewHolder(inflater.inflate(R.layout.chatitem_right, parent, false))
            else -> return LeftViewHolder(inflater.inflate(R.layout.chatitem_left, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList.get(position)
        when(chat.is_right){
            true-> (holder as RightViewHolder).righttextView.text = chat.message
            false-> (holder as LeftViewHolder).lefttextView.text = chat.message
        }
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}

class Chat(val message : String, val is_right : Boolean)