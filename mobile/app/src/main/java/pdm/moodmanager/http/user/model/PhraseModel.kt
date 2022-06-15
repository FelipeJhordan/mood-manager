package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName
import moodmanager.api.model.Type

class PhraseModel {
    @SerializedName("content")
    var content: String = ""

    @SerializedName("type")
    var type: Type = Type.HABIT

    @SerializedName("habit")
    var habit: String = ""

    @SerializedName("id")
    var id: Long = 0
}