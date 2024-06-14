package com.daejol.data

import com.daejol.domain.repository.CatImagesRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@HiltAndroidTest
class ApiUnitTest {
    @get:Rule
    var hilt = HiltAndroidRule(this)

    @Inject
    lateinit var repository: CatImagesRepository

    @Before
    fun setup() {
        hilt.inject()
    }

    @Test
    fun getCatImagesList  () {
        CoroutineScope(Dispatchers.IO).launch {
            val images = repository.getCatRandomImages(10)
            assert(images.toList().isNotEmpty())
        }
    }
}

