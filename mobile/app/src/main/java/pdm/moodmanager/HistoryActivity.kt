package pdm.moodmanager

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.history_activity.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class HistoryActivity: AppCompatActivity() {

    lateinit var linelist: ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData: LineData
    lateinit var tip: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO history")
        setContentView(R.layout.history_activity)
        println("NO HISTORY ACTIVITY")
        println(MainActivity.theUser)

        var regs = MainActivity.theUser.registers

        var limit = 0
        if (regs.size < 6)
            limit = regs.size
        else
            limit = 6

        println("QTDE DE REGS: ${regs.size}")
        linelist = ArrayList()
//        var i:Int = 1
        for (i in 1..(limit)) {
            println("i: ${i}, limit: ${limit}, regsize: ${regs.size}, invert: ${regs.size - i}")
            linelist.add(Entry(i.toFloat(), regs.get(regs.size - i).score.toFloat()))
            println("Adicionando: ${regs.get(regs.size - i).score.toFloat()}")
        }


        lineDataSet = LineDataSet(linelist, "Count")
        lineData = LineData(lineDataSet)
        lineChart.data = lineData
//        lineDataSet.color = Color.BLACK
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet.valueTextColor = Color.YELLOW
        lineDataSet.valueTextSize = 20f
        lineDataSet.setDrawFilled(true)

        MainActivity.phrases.forEach {
            println(it)
        }

        tip = findViewById(R.id.txtTip)
        if (MainActivity.phrases.size != 0) {
            val nextValues = Random.nextInt(0, MainActivity.phrases.size)
            tip.text = MainActivity.phrases.get(nextValues).content
        } else {
            tip.text = "Do not pray for an easy life, pray for the strength to endure a difficult on"
        }
    }

    fun backHome(view: View) {
        startActivity(Intent(this, HomeActivity::class.java))
    }

}