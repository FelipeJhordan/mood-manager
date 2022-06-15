package pdm.moodmanager.helper

import com.example.moodmanager.states.User
import com.google.gson.annotations.SerializedName
import pdm.moodmanager.model.Register
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
class registers {
    @SerializedName("")
    var registers:List<Register> = ArrayList()
}
fun helperSave(user: User): HashMap<String, Any> {
    val parser: DateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")
    val body = HashMap<String, Any>()
    val registerToEndPoint = user.registers.map {
        register: Register ->
        var newRegister = register
        var local: String?
        if(register.date?.length!! >17) {
             local = LocalDateTime.parse(newRegister.date, parser).toString().replace(" ", "T")
        } else {
             local = register.date
        }
        newRegister.date = local
        newRegister
    }
    val register = registers()
    register.registers = registerToEndPoint
    println(registerToEndPoint.toString())
    body.put("id",user.id)
    body.put("username",user.username)
    body.put("password",user.password)
    body.put("email",user.email)
    body.put("geralScore",user.geralScore)
    body.put("preference",user.preference as Any)
    body.put("interests",user.interests)
    body.put("registers",  register.registers)
    return body
}