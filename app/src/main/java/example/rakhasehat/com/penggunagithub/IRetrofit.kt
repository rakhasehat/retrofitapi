package example.rakhasehat.com.penggunagithub

import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface IRetrofit {
    @GET("albums/1/photos")
    fun getPhotos() : Observable<MutableList<Model.Photo>> }