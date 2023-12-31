package com.pidzama.comicsdreamsapp.util.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.pidzama.comicsdreamsapp.R
import com.pidzama.comicsdreamsapp.ui.theme.EXTRA_SMALL_PADDING_6
import com.pidzama.comicsdreamsapp.ui.theme.SIZE_IMAGE_INFO_BOX
import com.pidzama.comicsdreamsapp.ui.theme.titleColor

@Composable
fun InfoBox(
    icon: Painter,
    iconColor: Color,
    bigText: String,
    smallText: String,
    textColor: Color
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .padding(end = EXTRA_SMALL_PADDING_6)
                .size(SIZE_IMAGE_INFO_BOX),
            painter = icon,
            contentDescription = stringResource(R.string.info_icon),
            tint = iconColor
        )
        Column {
            Text(
                text = bigText,
                color = textColor,
                fontSize = MaterialTheme.typography.h6.fontSize,
                fontWeight = FontWeight.Black
            )
            Text(
                modifier = Modifier.alpha(ContentAlpha.medium),
                text = smallText,
                color = textColor,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInfoBox() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_position),
        iconColor = MaterialTheme.colors.primary,
        bigText = "Evil",
        smallText = "Position",
        textColor = MaterialTheme.colors.titleColor
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewDarkInfoBox() {
    InfoBox(
        icon = painterResource(id = R.drawable.ic_position),
        iconColor = MaterialTheme.colors.primary,
        bigText = "Evil",
        smallText = "Position",
        textColor = MaterialTheme.colors.titleColor
    )
}