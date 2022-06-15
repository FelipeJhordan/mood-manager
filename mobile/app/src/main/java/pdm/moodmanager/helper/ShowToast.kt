package pdm.moodmanager.helper

import android.content.Context
import android.text.Html
import android.view.Gravity
import android.widget.Toast


class ShowToast(context: Context?, info: String) {
    init {
        val toast = Toast.makeText(
            context,
            Html.fromHtml("<font color='#D79052' ><b style='color: #fff'>$info</b></font>",0),
            Toast.LENGTH_SHORT
        )
        toast.setGravity(Gravity.TOP, 0, 0)
        toast.show()
    }
}