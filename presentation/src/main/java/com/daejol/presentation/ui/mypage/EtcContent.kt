package com.daejol.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.daejol.presentation.R
import com.daejol.presentation.ui.home.Title
import com.daejol.presentation.ui.theme.CatdogcupTheme
import com.daejol.presentation.ui.theme.Typography

@Composable
fun EtcContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = dimensionResource(id = R.dimen.space_l))
    ) {
        Title(text = stringResource(id = R.string.my_page_title_etc))
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.space_m)))
        Text(
            text = stringResource(id = R.string.my_page_etc_sign_in),
            style = Typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun EtcContentPreview() {
    CatdogcupTheme {
        EtcContent(
            modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
        )
    }
}
