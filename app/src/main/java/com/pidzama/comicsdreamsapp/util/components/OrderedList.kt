package com.pidzama.comicsdreamsapp.util.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.pidzama.comicsdreamsapp.ui.theme.EXTRA_SMALL_PADDING_6
import com.pidzama.comicsdreamsapp.ui.theme.WIDTH_ORDER_LIST_COLUMN
import com.pidzama.comicsdreamsapp.ui.theme.titleColor

@Composable
fun OrderedList(
    title: String,
    items: List<String>,
    textColor: Color
) {
    Column {
        Text(
            modifier = Modifier
                .padding(bottom = EXTRA_SMALL_PADDING_6),
            text = title,
            color = textColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )
        items.forEachIndexed { index, item ->
            Column(modifier = Modifier.width(WIDTH_ORDER_LIST_COLUMN)) {
                Text(
                    modifier = Modifier.alpha(ContentAlpha.medium),
                    text = "${index + 1}. $item ",
                    color = textColor,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    softWrap = true
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrderListPreview() {
    OrderedList(
        title = "Friends",
        items = listOf("Batman", "Superman", "Spider-Man"),
        textColor = MaterialTheme.colors.titleColor
    )
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OrderDarkListPreview() {
    OrderedList(
        title = "Friends",
        items = listOf("Batman", "Superman", "Spider-Man"),
        textColor = MaterialTheme.colors.titleColor
    )
}