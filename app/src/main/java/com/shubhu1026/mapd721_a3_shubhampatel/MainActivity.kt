import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
                        Text("Transition Animation")
                    }
                    composable(Screen.ScaleAnimation.route) {
                        Text("Scale Animation")
                    }
                    composable(Screen.InfiniteAnimation.route) {
                        Text("Infinite Animation")
                    }
                    composable(Screen.EnterExitAnimation.route) {
                        Text("Enter Exit Animation")
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
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
