package com.example.week2_taskviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.week2_taskviewmodel.ui.HomeScreen
import com.example.week2_taskviewmodel.ui.theme.Week2taskviewmodelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Week2taskviewmodelTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    HomeScreen()
                }
            }
        }
    }
}
