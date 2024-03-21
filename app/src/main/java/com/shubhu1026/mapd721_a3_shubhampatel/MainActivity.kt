import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
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
            Button(onClick = { /* No action */ }) {
                Text("Transition Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* No action */ }) {
                Text("Scale Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* No action */ }) {
                Text("Infinite Animation")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { /* No action */ }) {
                Text("Enter Exit Animation")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TransitionAnimationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transition Animation") }
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
                    .size(100.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rocket),
                    contentDescription = "Rocket"
                )
            }

            Button(
                onClick = { /* No action */ },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text("Launch Rocket")
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaleAnimationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scale Animation") }
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
                onClick = { /* No action */ }
            ) {
                Text("Click Me", fontSize = 20.dp)
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteAnimationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Infinite Animation") }
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
                modifier = Modifier.size(200.dp)
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterExitAnimationScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Enter Exit Animation") }
            )
        }
    ) {
        Box(
         g   modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.naruto),
                contentDescription = "Image"
            )

            Button(
                onClick = { /* No action */ },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(16.dp)
            ) {
                Text("Press for Exit Animation", fontSize = 18.dp)
            }
        }
    }
}
