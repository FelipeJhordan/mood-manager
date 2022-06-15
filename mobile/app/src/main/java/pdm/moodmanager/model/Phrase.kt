package pdm.moodmanager.model

import moodmanager.api.model.Type

class Phrase(
        var id:Long,
        var type: Type,
        var content:String
        ) {
    override fun toString(): String {
        return "Phrase(id=$id, type=$type, content='$content')"
    }
}