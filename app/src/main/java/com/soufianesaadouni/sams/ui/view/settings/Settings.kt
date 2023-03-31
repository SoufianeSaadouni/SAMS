package com.soufianesaadouni.sams.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.soufianesaadouni.sams.ui.theme.SAMSTheme

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Settings() {
    var switchValue: Boolean by remember {
        mutableStateOf(true)
    }

    SAMSTheme {
        Scaffold(
            topBar = {
                CenterAlignedTopAppBar(
                    title = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = "Settings")
                        }
                    },
                )
            },
            content = {
                it
                Box(
                    modifier = Modifier.padding(it).fillMaxSize(),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .verticalScroll(rememberScrollState())
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.fillMaxWidth().padding(8.dp),
                        ) {
                            Text(text = "Change theme", modifier = Modifier.padding(16.dp))
                            Switch(checked = switchValue,
                                onCheckedChange = { switchValue = !switchValue })
                        }
                    }
                }
            }
        )
    }
}