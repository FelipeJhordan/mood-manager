package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName

class InterestModel {
    @SerializedName("id")
    var id: Int = 0
    @SerializedName("description")
    var description: String = ""
    @SerializedName("name")
    var name: String = ""
    @SerializedName("score")
    var score: Int = 0
    @SerializedName("iduser")
    var iduser: Int = 0
}