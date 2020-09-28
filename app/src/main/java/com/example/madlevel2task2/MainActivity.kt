package com.example.madlevel2task2


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.example.madlevel2task2.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val quizzes = arrayListOf<Quiz>()
    private val quizAdapter = QuizAdapter(quizzes)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
        createItemTouchHelper().attachToRecyclerView(recycleQuiz)
    }

    private fun initViews() {
        // Initialize the recycler view with a linear layout manager, adapter
        binding.recycleQuiz.layoutManager =
            LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        binding.recycleQuiz.adapter = quizAdapter
        for (i in Quiz.QUIZ_QUESTIONS.indices) {
            quizzes.add(Quiz(Quiz.QUIZ_QUESTIONS[i],        Quiz.QUIZ_BOOLEAN[i]))
        }
        quizAdapter.notifyDataSetChanged()
    }

    private fun createItemTouchHelper(): ItemTouchHelper {

        // Callback which is used to create the ItemTouch helper. Only enables left swipe.
        // Use ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) to also enable right swipe.
        val callback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

            // Enables or Disables the ability to move items up and down.
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }


            // Callback triggered when a user swiped an item.
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val falsedirection = 4
                val truedirection = 8

                if (Quiz.QUIZ_BOOLEAN[position] == direction){
                    Snackbar.make(recycleQuiz, "That was not true please try again", Snackbar.LENGTH_SHORT).show()
                }else{
                    quizzes.removeAt(position)
                }
                quizAdapter.notifyDataSetChanged()
            }
        }
        return ItemTouchHelper(callback)
    }
}