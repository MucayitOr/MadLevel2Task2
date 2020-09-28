package com.example.madlevel2task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.madlevel2task2.databinding.ItemQuizBinding

class QuizAdapter(private val quizzes: List<Quiz>) : RecyclerView.Adapter<QuizAdapter.ViewHolder>(){

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding = ItemQuizBinding.bind(itemView)

        fun dbind(quiz: Quiz) {
            binding.tvQuiz.text = quiz.quizText
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_quiz, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return quizzes.size
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.dbind(quizzes[position])
        }
    }