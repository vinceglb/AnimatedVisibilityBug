package com.example.animatedvisibilitybug

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animatedvisibilitybug.ui.theme.AnimatedVisibilityBugTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedVisibilityBugTheme {

                var show by remember { mutableStateOf(true) }

                Scaffold(
                    topBar = {
                        //! Strange behavior here
                        AnimatedVisibility(visible = show) {
                            TopAppBar(title = { Text("Title") })
                        }
                    },
                    bottomBar = {
                        //! Strange behavior here
                        AnimatedVisibility(visible = show) {
                            BottomAppBar {
                                Text("Bottom")
                            }
                        }
                    },
                ) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .padding(paddingValues)
                            .fillMaxSize()
                    ) {
                        Text("Hello World!")
                        Text(text = stringResource(id = R.string.lorem))
                        AnimatedVisibility(visible = show) {
                            Text("Visible")
                        }
                        Button(
                            onClick = { show = !show },
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Text("Button")
                        }
                    }
                }

            }
        }
    }

}
