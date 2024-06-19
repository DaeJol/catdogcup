import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.daejol.presentation.worldcup.TopSectionCatImageWidget
import com.daejol.presentation.worldcup.WorldCupPreviewParameterProvider
import com.daejol.presentation.worldcup.WorldCupType

@Preview
@Composable
fun TopSectionWidget(
    @PreviewParameter(WorldCupPreviewParameterProvider::class) type: WorldCupType
) {
    return Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Spacer(modifier = Modifier
            .width(50.dp)
            .height(50f.dp))
        TopSectionCatImageWidget(type = type)
    }
}