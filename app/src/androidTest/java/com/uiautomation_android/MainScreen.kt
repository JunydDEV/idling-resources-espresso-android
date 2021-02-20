package com.uiautomation_android

import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton

class MainScreen : Screen<MainScreen>(){
    val buttonGoToListing = KButton{ withId(R.id.buttonGoToListing) }
    val buttonGoToDetails = KButton{ withId(R.id.buttonGoToDetails) }
    val buttonGoToHome = KButton{ withId(R.id.buttonGoToHome) }


    fun goToListingScreen(){
        buttonGoToListing{
            isVisible()
            click()
        }
    }

    fun goToDetails(){
        buttonGoToDetails {
            isVisible()
            click()
        }
    }

    fun assertDetails(){
        buttonGoToHome{
            isVisible()
        }
    }
}