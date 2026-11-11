package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpackcompose.CounterApp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
             JetpackComposeTheme(){
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "counter",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("counter") {
                            CounterApp(
                                onNextClick = {
                                    navController.navigate("data_diri")
                                }
                            )
                        }
                        composable("data_diri") {
                            DataDiriScreen()
                        }
                    }
                }
            }
        }
    }
}