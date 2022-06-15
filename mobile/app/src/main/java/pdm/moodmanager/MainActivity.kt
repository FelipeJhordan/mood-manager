package pdm.moodmanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.moodmanager.states.User
import kotlinx.android.synthetic.main.signin_activity.*
import pdm.moodmanager.helper.ShowToast
import pdm.moodmanager.helper.helperSave
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.user.UserRequest
import pdm.moodmanager.http.user.model.PhraseModel
import pdm.moodmanager.http.user.model.UserLoginModel
import pdm.moodmanager.http.user.model.UserModel
import pdm.moodmanager.model.Interest
import pdm.moodmanager.model.Phrase
import pdm.moodmanager.model.Preference
import pdm.moodmanager.model.Register

class MainActivity : AppCompatActivity() {

    val userRequest: UserRequest = UserRequest()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signin_activity)
    }

    fun OnSigninSubmit(view: View){

        var email: TextView = edLoginEmail
        var password: TextView = edLoginPassword

        val body = HashMap<String, Any>()

        body.put("email",email.text.toString())
        body.put("password",password.text.toString())
        val passwordApp = password.text.toString()
        userRequest.login(body, object : APIListener {
            override fun onSuccess(model: Any) {
                val output = model as UserLoginModel
                val user = model.user as UserModel
                if(user?.email.equals("")) {
                    ShowToast( applicationContext,"Wrong credentials")
                    return
                } else if(user!=null || user?.username.equals("")){
                    ShowToast( applicationContext,"User Logged")

                    var toHome = Intent(applicationContext,HomeActivity::class.java)

                    theUser = User(user.id,user.username,user.email,passwordApp,user.geralScore)
                    user.registers.forEach {
                        theUser.registers.add(Register(it.date,it.description,it.score,it.id))
                    }

                    user.interests.forEach {
                        theUser.interests.add(Interest(it.name,it.description,it.id,it.score))
                    }

                    theUser.preference = Preference(user.preference?.cherring_up as Boolean,
                            user.preference?.song_sugestion as Boolean, user.preference?.self_improvment as Boolean, user.preference?.id?.toLong())

                    model.phrase.forEach {
                        phrases.add(Phrase(it.id,it.type,it.content))
                    }

                    startActivity(toHome)
                    println("POR ENQUANTO OK")
                }else{
                    ShowToast(applicationContext,"There is no  user to be worked with")
                }
            }

            override fun onFailure(str: String) {
                ShowToast( applicationContext,"Error Conection")
            }
        })
    }

    fun wishSignUp(view: View){
        println("ENTROU EM OnSignUp")
        var signUp = Intent(this, SignUpActivity::class.java)
        startActivity(signUp)
    }

    companion object {
        lateinit var theUser:User
        var phrases: MutableList<Phrase> = arrayListOf()
        fun saveUser() {
            val userRequest: UserRequest = UserRequest()
            userRequest.save(helperSave(theUser), object: APIListener {
                override fun onSuccess(model: Any) {
                    clearUser()
                }

                override fun onFailure(str: String) {
                }

            })
        }
        fun clearUser() {
            this.theUser = User(0,"","","",0)
            this.phrases.clear()
        }
    }
}