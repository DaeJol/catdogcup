package com.daejol.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.daejol.data.api.CatImagesApi
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit


@RunWith(AndroidJUnit4::class)
class RetrofitTest {
    private lateinit var server: MockWebServer
    private lateinit var retrofit: Retrofit

    private lateinit var catImagesApi: CatImagesApi

    @Before
    fun setUp() {
        server = MockWebServer()
        server.start()
    }

    @After
    fun tearDown(){
        server.shutdown()
    }

    @Test
    fun getCatImageSearchApi() {
    }
}