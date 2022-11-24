package com.example.coveragetest

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

class RobolectricRunner<T>(clazz: Class<T>) : RobolectricTestRunner(clazz) {

    override fun buildGlobalConfig(): Config = Config.Builder()
        .setSdk(28)
        .build()

}