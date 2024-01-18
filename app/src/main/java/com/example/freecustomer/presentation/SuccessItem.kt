package com.example.freecustomer.presentation

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.model.Item
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun SuccessItem(
    item: Item
) {
    val context = LocalContext.current

    val format = SimpleDateFormat("dd-MM-yyyy", Locale.ROOT)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp),
        shape = CardDefaults.elevatedShape,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    ) {
        Text(
            text = item.title,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            modifier = Modifier.padding(6.dp)
        )
        Text(
            text = item.description,
            fontSize = 15.sp,
            modifier = Modifier.padding(6.dp)
        )
        Row {
            Text(
                text = "Type:",
                fontSize = 11.sp,
                modifier = Modifier.padding(6.dp),
                fontStyle = FontStyle.Italic
            )
            Text(
                text = item.type.title,
                fontSize = 11.sp,
                modifier = Modifier.padding(6.dp),
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            text = "Tags:",
            modifier = Modifier.padding(start = 6.dp),
            fontSize = 11.sp,
            fontStyle = FontStyle.Italic,
        )
        LazyRow(
            modifier = Modifier.padding(6.dp),
        ) {
            items(item.tags) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(6.dp),
                    shape = CardDefaults.elevatedShape,
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 10.dp
                    ),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(6.dp),
                    )
                }
            }
        }
        ClickableText(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color.Blue)) {
                    append("Click to see more")
                }
            },
            onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
                context.startActivity(intent)
            },
            modifier = Modifier.padding(start = 16.dp, bottom = 6.dp)
        )
        val date = format.format(item.dateTimestamp)
        val start = format.format(item.startDateTimestamp)
        val end = format.format(item.endDateTimestamp)
        Row(
            modifier = Modifier.padding(6.dp),
        ) {
            Text(text = "Date: ")
            Text(text = date)
        }
        Row(
            modifier = Modifier.padding(6.dp),
        ) {
            Text(text = "Start Date: ")
            Text(text = start)
        }
        Row(
            modifier = Modifier.padding(6.dp),
        ) {
            Text(text = "End Date: ")
            Text(text = end)
        }
    }
}