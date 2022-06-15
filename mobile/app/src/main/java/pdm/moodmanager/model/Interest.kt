package pdm.moodmanager.model

data class Interest(
        var name: String,
        var description: String,
        var id: Int,
        var score: Int
) {
    override fun toString(): String {
        return "Interest(name='$name', description='$description', id=$id, score=$score)"
    }
}