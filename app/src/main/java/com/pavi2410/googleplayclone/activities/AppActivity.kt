package com.pavi2410.googleplayclone.activities

import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.pavi2410.googleplayclone.R
import com.pavi2410.googleplayclone.adapters.AppReviewsAdapter
import com.pavi2410.googleplayclone.adapters.AppScreenshotsAdapter
import com.pavi2410.googleplayclone.models.AppReviewItemModel
import kotlinx.android.synthetic.main.activity_app.*
import kotlinx.android.synthetic.main.activity_app_content.*
import kotlinx.android.synthetic.main.activity_app_reviews.*
import kotlinx.android.synthetic.main.nav_header_main.*

class AppActivity : AppCompatActivity() {

    private val handler = Handler()
    private lateinit var appScreenshotsRecyclerView: RecyclerView
    private lateinit var appReviewsRecyclerView: RecyclerView
    private var progressStatus = 0
    private lateinit var downloadSize: TextView
    private lateinit var downloadPercent: TextView
    private lateinit var downloadProgress: ProgressBar
    private lateinit var downloadLayout: RelativeLayout
    private lateinit var openAppLayout: LinearLayout
    private lateinit var installButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_app)

        window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE)

        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val profileImageView = profile_image
        Glide.with(this)
                .load(R.drawable.profile_image)
                .into(profileImageView)

        appScreenshotsRecyclerView = rv_app_screenshots
        appScreenshotsRecyclerView.run {
            layoutManager = LinearLayoutManager(this@AppActivity, RecyclerView.HORIZONTAL, false)
            setHasFixedSize(true)
        }
        loadScreenshotsDataAndSetAdapter()

        appReviewsRecyclerView = rv_app_reviews
        appReviewsRecyclerView.run {
            layoutManager = LinearLayoutManager(this@AppActivity, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
        }
        loadAppReviewsDataAndSetAdapter()

        downloadLayout = rl_download
        openAppLayout = ll_open_app
        downloadSize = tv_download_size
        downloadPercent = tv_download_percent
        downloadProgress = pb_app_download

        installButton = btn_install
        installButton.setOnClickListener { DownloadApp().execute("") }

        val openAppButton = btn_open
        openAppButton.setOnClickListener {
            packageManager.getLaunchIntentForPackage("com.udacity.android")?.let {
                startActivity(it)
            }
                    ?: Toast.makeText(this, "You forgot this is a clone! Udacity App is not installed in your device!", Toast.LENGTH_LONG).show()
        }
    }

    private fun loadScreenshotsDataAndSetAdapter() {
        val screenshotImages = arrayListOf(
                "screenshot_1",
                "screenshot_2",
                "screenshot_3",
                "screenshot_4",
                "screenshot_5",
                "screenshot_6"
        )

        appScreenshotsRecyclerView.adapter = AppScreenshotsAdapter(screenshotImages)
    }

    private fun loadAppReviewsDataAndSetAdapter() {
        val appReviews = arrayListOf(
                AppReviewItemModel("John Butler", "This clone is one of the best and has good ux/ui but it lacks on content downloads for pls add resume/pause support for the active download", 4, "02/04/18", R.drawable.john_butler),
                AppReviewItemModel("David Gilmour", "Great app! Loved it as much as I loved Pink Floyd.", 5, "09/04/18", R.drawable.david_gilmour),
                AppReviewItemModel("Steven Wilson", "", 5, "02/04/18", R.drawable.steven_wilson)
        )

        appReviewsRecyclerView.adapter = AppReviewsAdapter(appReviews)
    }

    private inner class DownloadApp : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            installButton.isVisible = false
            openAppLayout.isVisible = false
            downloadLayout.isVisible = true
        }

        override fun doInBackground(vararg params: String): String {

            while (progressStatus < 100) {
                progressStatus += 1

                try {
                    Thread.sleep(25)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }

                handler.post {
                    downloadProgress.progress = progressStatus
                    downloadPercent.text = "$progressStatus %"
                    downloadSize.text = "${"%.2f".format(progressStatus * (28.81 / 100))}MB/28.81MB"
                }
            }

            return ""
        }

        override fun onPostExecute(result: String) {
            downloadLayout.isVisible = false
            openAppLayout.isVisible = true
        }
    }
}
