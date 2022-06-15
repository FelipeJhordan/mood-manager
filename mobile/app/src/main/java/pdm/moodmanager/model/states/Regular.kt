package com.example.moodmanager.states

class Regular(override var score: Long): State() {

    override fun ToPositive(): State {
        score++
        return Positive(score)
    }

    override fun ToRegular(): State {
        return Regular(score)
    }

    override fun ToNegative(): State {
        score--
        return Negative(score)
    }
}