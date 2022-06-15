package com.example.moodmanager.states

import pdm.moodmanager.MainActivity
import pdm.moodmanager.model.Interest
import pdm.moodmanager.model.Preference
import pdm.moodmanager.model.Register
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class User(
        var id: Int,
        var username:String,
        var email:String,
        var password:String,
        var geralScore:Long,
        var state:State = Regular(geralScore)
){
    var preference: Preference = Preference()
    var registers: MutableList<Register> = arrayListOf<Register>()
    val interests: MutableList<Interest> = arrayListOf<Interest>()

//    init{
//       var state: State = Regular(geralScore)
//    }

    fun ToPositive(){
        DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
        MainActivity.theUser.registers.add(Register(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")).toString(),"More happy",state.score))
        state = state.ToPositive()
    }
    fun ToNegative(){
        MainActivity.theUser.registers.add(Register(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")).toString(),"More sad",state.score))
        state = state.ToNegative()
    }
    fun ToRegular(){
        MainActivity.theUser.registers.add(Register(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")).toString(),"More normal",state.score))
        state = state.ToRegular()
    }

    override fun toString(): String {
        return "User: ${username},Email: ${email} Password: ${password}, Score: ${state.score}, Preference: ${preference},Registers: ${registers}, Interests: ${interests}"
    }
}