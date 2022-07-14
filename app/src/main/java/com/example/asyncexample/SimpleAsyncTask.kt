package com.example.asyncexample

import android.os.AsyncTask
import android.widget.TextView
import java.lang.ref.WeakReference
import kotlin.random.Random

class SimpleAsyncTask(tv:TextView): AsyncTask<Void, Void, String>() {
    var textView:WeakReference<TextView> = WeakReference<TextView>(tv)

    override fun doInBackground(vararg p0: Void?): String {
        var r:Random = Random
        var randomInt = r.nextInt(11)

        var waitTime = randomInt*200

        try {
            Thread.sleep(waitTime.toLong())
        }catch(e:Exception){
            e.printStackTrace()
        }
        var message:String = "Awake at last after sleeping for " + waitTime + " milliseconds"
        return message
    }

    override fun onPostExecute(result: String?) {
        textView.get()?.text = result
    }
}