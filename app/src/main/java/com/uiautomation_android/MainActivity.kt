package com.uiautomation_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.test.espresso.IdlingResource
import androidx.annotation.NonNull
import androidx.annotation.VisibleForTesting

class MainActivity : AppCompatActivity() {

    public var mIdlingResource: SimpleIdlingResource? = getIdlingResource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * Only called from test, creates and returns a new [SimpleIdlingResource].
     */
    @VisibleForTesting
    fun getIdlingResource(): SimpleIdlingResource {
        if (mIdlingResource == null) {
            mIdlingResource = SimpleIdlingResource()
        }
        return mIdlingResource as SimpleIdlingResource
    }
}
