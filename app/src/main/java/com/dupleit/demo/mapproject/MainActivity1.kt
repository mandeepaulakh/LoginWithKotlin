package com.dupleit.demo.mapproject

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.util.TypedValue
import android.view.View.VISIBLE
import android.widget.Toast
import com.dupleit.demo.kotlintest.Network.ApiService
import com.dupleit.demo.mapproject.HelperClasses.GridSpacingItemDecoration
import com.dupleit.demo.mapproject.HelperClasses.checkInternetState
import com.dupleit.demo.mapproject.Model.Subject
import com.dupleit.demo.mapproject.Model.UserUImodel
import com.dupleit.demo.mapproject.Network.ApiClient1
import com.dupleit.demo.mapproject.adapter.subjectsAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_performance.*
import kotlinx.android.synthetic.main.card_quiz.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       hitApi()
    }

    private fun hitApi() {

        val dialog= ProgressDialog(this)
        dialog.setMessage("Please wait...")
        dialog.setTitle("Fetch Data")
        dialog.setCancelable(false)
        dialog.isIndeterminate=true
        dialog.show()
        if (!checkInternetState.getInstance(applicationContext).isOnline()) run {
            dialog.hide()
            Toast.makeText(applicationContext, "Please Check Your Internet Connection.", Toast.LENGTH_LONG).show()
        } else {
            val service = ApiClient1.getClient()!!.create(ApiService::class.java)
            val userCall = service.getUidata("")
            userCall.enqueue(object : Callback<UserUImodel> {
                override fun onResponse(call: Call<UserUImodel>, response: Response<UserUImodel>) {
                    dialog.hide()
                    if (response.isSuccessful) {

                        Toast.makeText(this@MainActivity1,"true1",Toast.LENGTH_LONG).show()

                        if (response.body().status!!) {
                            Toast.makeText(this@MainActivity1, "status true", Toast.LENGTH_LONG).show()
                            if ((response.body().userData?.subject?.equals(("1")) ?: (("1") == null))) {
                                val SubjectList = ArrayList<Subject>()
                                val mLayoutManager = GridLayoutManager(applicationContext, 3)
                                recyclerView.layoutManager = mLayoutManager
                                recyclerView.addItemDecoration(GridSpacingItemDecoration(3, dpToPx(10), true))
                                recyclerView.itemAnimator = DefaultItemAnimator()
                                val adapter = subjectsAdapter(SubjectList)
                                recyclerView.adapter = adapter

                                var i = 0
                                var numIterations = response.body().userData?.subject!!.size
                                while (i < numIterations) {
                                    val oth = Subject(response.body().userData?.subject!![i].sub_id, response.body().userData?.subject!![i].sub_img, response.body().userData?.subject!![i].sub_name, response.body().userData?.subject!![i].status)
                                    SubjectList.add(oth)
                                    i++
                                }
                            }

                            if ((response.body().userData?.performance?.equals(("1")) ?: (("1") == null))) {
                                layoutPerformance.visibility= VISIBLE
                                var i = 0
                                var numIterations = response.body().userData?.performance!!.size
                                while (i < numIterations) {

                                    textLine.text ="You have shown "+response.body().userData?.performance!![i].performance+"% improvement in score over last 5 test"
                                    tvPerformanceInPercent.text = response.body().userData?.performance!![i].performance+"%"
                                    i++


                                }
                            }

                            if((response.body().userData?.quizShow?.equals(("4")) ?: (("4") == null))){
                                var i = 0
                                var numItrations =response.body().userData?.quizShow!!.size
                                while (i<numItrations){
                                    quiz_subject_name.text=response.body().userData?.quizShow!![i].subjectName
                                    quizQus.text=response.body().userData?.quizShow!![i].question
                                    radioButton1.text=response.body().userData?.quizShow!![i].option1
                                    radioButton2.text=response.body().userData?.quizShow!![i].option2
                                    radioButton3.text=response.body().userData?.quizShow!![i].option3
                                    radioButton4.text=response.body().userData?.quizShow!![i].option4
                                    i++
                                }
                            }
                        } else {
                            Toast.makeText(this@MainActivity1, response.body().message, Toast.LENGTH_LONG).show()

                        }

                    } else {

                    }
                }

                override fun onFailure(call: Call<UserUImodel>, t: Throwable) {
                    Log.d("onFailure", t.toString())
                }
            })
        }
    }

    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}