package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName

class PreferenceModel {
    @SerializedName("id")
    var id: Int = 0

    @SerializedName("cherring_up")
    var cherring_up: Boolean = false

    @SerializedName("song_sugestion")
    var song_sugestion: Boolean = false

    @SerializedName("self_improvment")
    var self_improvment: Boolean = false
}