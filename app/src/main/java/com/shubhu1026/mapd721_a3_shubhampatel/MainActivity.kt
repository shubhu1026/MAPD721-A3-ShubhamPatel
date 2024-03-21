package com.shubhu1026.mapd721_a3_shubhampatel

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.shubhu1026.mapd721_a3_shubhampatel.ui.theme.MAPD721A3ShubhamPatelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MAPD721A3ShubhamPatelTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = Screen.MainScreen.route) {
                    composable(Screen.MainScreen.route) {
                        MainScreen(navController)
                    }
                    composable(Screen.TransitionAnimation.route) {
                        TransitionAnimationScreen(navController)
                    }
                    composable(Screen.ScaleAnimation.route) {
                        ScaleAnimationScreen(navController)
                    }
                    composable(Screen.InfiniteAnimation.route) {
                        InfiniteAnimationScreen(navController)
                    }
                    composable(Screen.EnterExitAnimation.route) {
                        EnterExitAnimationScreen(navController)
                    }
                }
            }
        }
    }
}

sealed class Screen(val route: String) {
    object MainScreen : Screen("main_screen")
    object TransitionAnimation : Screen("transition_animation")
    object ScaleAnimation : Screen("scale_animation")
    object InfiniteAnimation : Screen("infinite_animation")
    object EnterExitAnimation : Screen("enter_exit_animation")
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Main Screen") }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { navController.navigate(Screen.TransitionAnimation.route) }) {
                Text("Transition Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.ScaleAnimation.route) }) {
                Text("Scale Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.InfiniteAnimation.route) }) {
                Text("Infinite Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.navigate(Screen.EnterExitAnimation.route) }) {
                Text("Enter Exit Animation")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TransitionAnimationScreen(navController: NavHostController) {
    var rocketDirection by remember { mutableStateOf(0f) }
    var isRocketLanded by remember { mutableStateOf(true) }

    val buttonTitle = if (isRocketLanded) "Launch Rocket" else "Land Rocket"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transition Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .offset(
                        y = animateFloatAsState(
                            targetValue = rocketDirection * 600f,
                            animationSpec = tween(durationMillis = 1000)
                        ).value.dp
                    )

                    .size(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rocket),
                    contentDescription = "Rocket",
                    modifier = Modifier.fillMaxSize()
                )
            }

            Button(
                onClick = {
                    isRocketLanded = !isRocketLanded
                    rocketDirection = if (isRocketLanded) 0f else -1f
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(buttonTitle)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaleAnimationScreen(navController: NavHostController) {
    var buttonScale by remember { mutableStateOf(1f) }

    val animatedButtonScale = animateFloatAsState(
        targetValue = buttonScale,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioHighBouncy,
            stiffness = Spring.StiffnessLow
        ),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scale Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    buttonScale = if (buttonScale == 1f) 2f else 1f
                },
                modifier = Modifier.scale(animatedButtonScale.value)
            ) {
                Text("Click Me", fontSize = 20.sp)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun InfiniteAnimationScreen(navController: NavHostController) {
    val infiniteAnimationSpec = rememberInfiniteTransition()
    val scale by infiniteAnimationSpec.animateFloat(
        initialValue = 1f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Reverse
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Infinite Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sharingan),
                contentDescription = "Pulsating Image",
                modifier = Modifier
                    .size(200.dp)
                    .scale(scale),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterExitAnimationScreen(navController: NavHostController) {
    var isEntering by remember { mutableStateOf(false) }

    val animatedAlpha by animateFloatAsState(
        targetValue = if (isEntering) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    val animatedX by animateDpAsState(
        targetValue = if (isEntering) 0.dp else -200.dp,
        animationSpec = tween(durationMillis = 1000)
    )
    val animatedY by animateDpAsState(
        targetValue = if (isEntering) 0.dp else -200.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Enter Exit Animation") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.naruto),
                contentDescription = "Image",
                modifier = Modifier
                    .offset(x = animatedX, y = animatedY)
                    .alpha(animatedAlpha)
            )

            Button(
                onClick = { isEntering = !isEntering },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text(
                    text = if (isEntering) "Press for Exit Animation" else "Press for Enter Animation",
                    fontSize = 18.sp
                )
            }
        }
    }
}

