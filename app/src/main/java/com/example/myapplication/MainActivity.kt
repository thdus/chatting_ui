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

        with(findViewById<RecyclerView>(R.id.chatRecyclerView)) {
            this.layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = ChatRecyclerAdapter(
                chatList = chatList,
                inflater = LayoutInflater.from(this@MainActivity)
            )
        }

    }
}
class ChatRecyclerAdapter(
    val chatList : MutableList<Chat>,
    val inflater: LayoutInflater
):RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val textView: TextView
        init {
            textView = itemView.findViewById(R.id.chatTextRight)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = inflater.inflate(R.layout.chatitem_right, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList.get(position)
        (holder as ViewHolder).textView.text = chat.message
    }

    override fun getItemCount(): Int {
        return chatList.size
    }
}

class Chat(val message : String, val is_right : Boolean)