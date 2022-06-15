package pdm.moodmanager

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.home_activity.*
import pdm.moodmanager.helper.ShowToast
import java.util.*

class HomeActivity : AppCompatActivity() {
    val images: Array<Int> = arrayOf(R.drawable.ic_happy, R.drawable.ic_angry, R.drawable.ic_bored, R.drawable.ic_cool, R.drawable.ic_sad)
    var moodSelected: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        val gallery: LinearLayout = llHomeGalery // deixa eu falar

        val inflater: LayoutInflater = LayoutInflater.from(this)

        for (i: Int in 0..4) {
            var view: View = inflater.inflate(R.layout.scroll_bar_image, gallery, false)
            println(i)
            var imageView: ImageView = view.findViewById(R.id.ivMood)
            imageView.setImageResource(images[i])
            imageView.setTag(images[i], i)
            imageView.setOnClickListener { v ->
                this.moodSelected = v.getTag(images[i]) as Int
                println(this.moodSelected)

                if (this.moodSelected == 0 || this.moodSelected == 3) {
                    MainActivity.theUser.ToPositive()
                } else if (this.moodSelected == 2) {
                    MainActivity.theUser.ToRegular()
                } else {
                    MainActivity.theUser.ToNegative()
                }
                ShowToast(applicationContext, "Mood save")
            }
            // Criar um objeto registro com a hora e adicionar
            gallery.addView(view)
        }
    }

    fun toHistory(view: View) {
        println("ENTROU EM TOHISTORY")
        var history = Intent(this, HistoryActivity::class.java)
        startActivity(history)
    }

    fun toPreferences(view: View) {
        println("CHAMANDO PREFERENCES")
        var prefs = Intent(this, PreferenceActivity::class.java)
        startActivity(prefs)
    }

    fun toLogin() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    fun closeApp(view: View) {
        MainActivity.saveUser()
        toLogin()
        finish()
    }
}

