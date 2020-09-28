package com.example.madlevel2task2

class Quiz (
        var quizText: String,
        var quizBoolean: Int
    ) {
    companion object {
        val QUIZ_QUESTIONS = arrayOf(
            "A 'val' and 'var' are the same.",
            "Mobile Application Development grants 12 ETCS.",
            "A Unit in Kotlin corresponds to a void in Java.",
            "In Kotlin 'when' replaces the 'switch'operator in Java."
        )
        val QUIZ_BOOLEAN = arrayOf(
            8,
            4,
            8,
            4
        )

    }
}