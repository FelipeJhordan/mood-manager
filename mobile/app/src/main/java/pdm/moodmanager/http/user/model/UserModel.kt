package pdm.moodmanager.http.user.model

import com.google.gson.annotations.SerializedName


class UserModel {
    @SerializedName("username")
    var username: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("password")
    var password: String = ""

    @SerializedName("geralScore")
    var geralScore: Long = 0

    @SerializedName("id")
    var id: Int = 0

    @SerializedName("preference")
    var preference: PreferenceModel? = null

    @SerializedName("registers")
    var registers: ArrayList<RegistersModel> = ArrayList()

    @SerializedName("interests")
    var interests: ArrayList<InterestModel> = ArrayList()

    override fun toString(): String {
        return "User: ${username},Email: ${email} Password: ${password}, Score: ${geralScore},Id: ${id}"
    }
}

class UserLoginModel {
    @SerializedName("user")
    var user: UserModel? = null
    @SerializedName("phrases")
    var phrase: ArrayList<PhraseModel> = ArrayList()
}