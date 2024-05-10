package com.daejol.data

import com.google.android.gms.analytics.AnalyticsService
import dagger.hilt.android.scopes.ActivityScoped
import org.junit.Test
import javax.inject.Inject

@ActivityScoped
class AnalyticsAdapter @Inject constructor(
    private val service: AnalyticsService
) {

}

class AnalyticsAdapterTest {

}