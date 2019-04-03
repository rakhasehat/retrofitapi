package example.rakhasehat.com.penggunagithub

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPhotos.layoutManager = LinearLayoutManager(this)

        val mAPICilent by lazy{
            APICilent.create()
        }

        mAPICilent.getPhotos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ it ->
                Log.d("size", it.size.toString())
                setDataInRecyclerView(it)
            }, {it ->
                Log.d("error", "errors")
            })
    }

    private fun setDataInRecyclerView(it: MutableList<Model.Photo>?) {
        rvPhotos.adapter = PhotoAdapter(it!!, this)
    }
}
