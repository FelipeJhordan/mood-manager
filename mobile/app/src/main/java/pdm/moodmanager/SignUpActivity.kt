package pdm.moodmanager

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuView
import com.example.moodmanager.states.User
import kotlinx.android.synthetic.main.signup_activity.*
import pdm.moodmanager.helper.ShowToast
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.UserModel

class SignUpActivity:AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()
    lateinit var user:User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("ENTROU NO ONCREATE DO SIGNUP")
        setContentView(R.layout.signup_activity)
    }

    fun OnSignupSubmit(view: View){

        var email:TextView = edTxtEmail
        var username:TextView = edTxtName
        var password:TextView = edTxtPassword


        println("Starting action...")
        lateinit var p: UserModel
        val body = HashMap<String, Any>()
        body.put("email",email.text.toString())
        body.put("username",username.text.toString())
        body.put("password",password.text.toString())
        if(email.text.toString().isBlank()||username.text.toString().isEmpty() || password.text.toString().isBlank()) {
            ShowToast( applicationContext,"Fill all inputs")
            return
        }
        userRequest.register(body, object : APIListener {
            override fun onSuccess(model: Any) {
                println(model as UserModel)
                ShowToast( applicationContext,"User Save")
                finish()
            }

            override fun onFailure(str: String) {
                ShowToast( applicationContext,"Error Conection")
            }
            })
    }
    fun wishSignIn(view: View){
        var signIn = Intent(this, MainActivity::class.java)
        startActivity(signIn)
    }

}