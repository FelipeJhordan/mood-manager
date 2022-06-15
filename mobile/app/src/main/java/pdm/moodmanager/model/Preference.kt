package pdm.moodmanager.model

data class Preference(
        var cherring_up: Boolean = false,
        var song_sugestion: Boolean = false,
        var self_improvment: Boolean = false,
        var id: Long? = null
) {
    fun setPreference(c:Boolean,s:Boolean,i:Boolean){
        cherring_up = c
        song_sugestion = s
        self_improvment = i
    }

    override fun toString(): String {
        return "Cheering_up: ${cherring_up}, song_sugest: ${song_sugestion}, self_improv: ${self_improvment}, id: ${id}"
    }
}