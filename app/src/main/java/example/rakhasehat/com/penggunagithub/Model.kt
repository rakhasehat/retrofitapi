package example.rakhasehat.com.penggunagithub

object Model {
    data class Photo(
        val albumId : Int,
        val id : Int,
        val title : String,
        val thumbnailUrl : String
    )
}