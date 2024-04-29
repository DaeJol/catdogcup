package com.daejol.data

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.daejol.data.api.CatRetrofitClient
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@RunWith(AndroidJUnit4::class)
class RetrofitTest {
    private lateinit var server: MockWebServer
    private lateinit var retrofit: Retrofit

    @Before
    fun setUp() {
        server = MockWebServer()
        server.start()

        retrofit = CatRetrofitClient.instance
    }

    @After
    fun tearDown(){
        server.shutdown()
    }

    @Test
    fun getCatImageSearchApi() {
        val response = """
            [
                {
                    "id":"ebv",
                    "url":"https://cdn2.thecatapi.com/images/ebv.jpg",
                    "width":176,"height":540,
                    "breeds":[],
                    "favourite":{}
                }
            ]
        """.trimIndent()

        server.enqueue(MockResponse().setBody(response))
    }
}