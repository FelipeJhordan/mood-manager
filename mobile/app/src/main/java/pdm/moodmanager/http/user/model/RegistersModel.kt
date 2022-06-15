package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class RegistersModel {

    @SerializedName("id")
    var id: Long = 0
    @SerializedName("date")
    var date: String? = null
    get() {
        var localdate = LocalDateTime.parse(field)
        return localdate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"))
    }
    @SerializedName("score")
    var score: Long = 0
    @SerializedName("description")
    var description: String? = null

    override fun toString(): String {
        return "${id},${date},${score},${description}"
    }
}