package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun ListTest() {
    val itemsCount = 10

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        repeat(itemsCount) { iteration ->
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            ) {
                Text(
                    "ITEM -> $iteration", modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}