package pdm.moodmanager.http.user

import android.widget.Toast
import pdm.moodmanager.helper.ShowToast
import pdm.moodmanager.http.APIListener
import pdm.moodmanager.http.RetrofitClient
import pdm.moodmanager.http.user.model.UserLoginModel
import pdm.moodmanager.http.user.model.UserModel
import pdm.moodmanager.http.user.service.UserService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRequest {
    private val remote = RetrofitClient.createService(UserService::class.java)
    constructor() {}
    fun register(objs: HashMap<String, Any>, listener: APIListener) {
        val call: Call<UserModel> = remote.register(objs)
        call.enqueue(object : Callback<UserModel> {
            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                response.body()?.let { listener.onSuccess(it) } // verifica se é nulo, retorna ele mesmo para dentro a callback {}

            }

        })
    }

    fun login(objs: HashMap<String, Any>, listener: APIListener) {
        val call: Call<UserLoginModel> = remote.login(objs)
        call.enqueue(object : Callback<UserLoginModel> {
            override fun onFailure(call: Call<UserLoginModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<UserLoginModel>, response: Response<UserLoginModel>) {
                response.body()?.let {
                    listener.onSuccess(it)
                } // verifica se é nulo, retorna ele mesmo para dentro a callback {}
                false
            }

        })
    }

    fun save(objs: HashMap<String, Any>, listener: APIListener) {
        val call: Call<UserLoginModel> = remote.save(objs)
        call.enqueue(object : Callback<UserLoginModel> {
            override fun onFailure(call: Call<UserLoginModel>, t: Throwable) {
                listener.onFailure(t.message.toString())
            }

            override fun onResponse(call: Call<UserLoginModel>, response: Response<UserLoginModel>) {
                response.body()?.let { listener.onSuccess(it) } // verifica se é nulo, retorna ele mesmo para dentro a callback {}
            }

        })
    }
}