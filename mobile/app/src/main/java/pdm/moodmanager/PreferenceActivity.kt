package pdm.moodmanager

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity


class PreferenceActivity : AppCompatActivity() {
    lateinit var cheers: CheckBox
    lateinit var habits: CheckBox
    lateinit var songs: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preference)

        cheers =  findViewById(R.id.cbPreferenceCheerMeUp)
        habits = findViewById(R.id.cbPreferenceHelpImprove)
        songs = findViewById(R.id.cbPreferenceSugestSome)

        if(MainActivity.theUser.preference.cherring_up){
            cheers.isChecked = true
        }

        if(MainActivity.theUser.preference.self_improvment){
            habits.isChecked = true
        }

        if(MainActivity.theUser.preference.song_sugestion){
            songs.isChecked = true
        }
    }

    fun onCheckListener(view: View){
        println("ENTROU ON CHECKLISTENER")
        var checks = view as CheckBox
        println(checks.id.toString())
        println(checks.text)
        if(checks.text == "Cheer me up"){
            MainActivity.theUser.preference.cherring_up = checks.isChecked
        }else if(checks.text == "Help me improve my habits"){
            MainActivity.theUser.preference.self_improvment = checks.isChecked
        }else if(checks.text == "Sugest me some music"){
            MainActivity.theUser.preference.song_sugestion= checks.isChecked
        }
        println("FEITO")
    }

    fun toHome(view: View) {
        println("CHAMANDO HOME")
        var prefs = Intent(this, HomeActivity::class.java)
        startActivity(prefs)
    }

}