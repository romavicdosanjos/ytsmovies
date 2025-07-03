package ytsmovies.romavicdosanjos.com

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ytsmovies.romavicdosanjos.com.features.downloads.presentation.DownloadsScreen
import ytsmovies.romavicdosanjos.com.features.list_movies.presentation.ListMoviesScreen
import ytsmovies.romavicdosanjos.com.ui.theme.YtsMoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            YtsMoviesTheme {
                val navController = rememberNavController()

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController)
                    }
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = BottomNavItem.Movies.route,
                        modifier = Modifier.padding(0.dp)
                    ) {
                        composable(BottomNavItem.Movies.route) {
                            ListMoviesScreen()
                        }
                        composable(BottomNavItem.Downloads.route) {
                            DownloadsScreen()
                        }
                        composable(BottomNavItem.Licenses.route) {
                            LicensesScreen()
                        }
                    }
                }
            }
        }
    }
}

sealed class BottomNavItem(val route: String, val label: String, val icon: ImageVector) {
    object Movies : BottomNavItem("movies", "Movies", Icons.Filled.Info)
    object Downloads : BottomNavItem("downloads", "Downloads", Icons.Default.Info)
    object Licenses : BottomNavItem("licenses", "Licenses", Icons.Default.Info)
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.Movies,
        BottomNavItem.Downloads,
        BottomNavItem.Licenses
    )
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                }
            )
        }
    }
}


@Composable
fun LicensesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text("Licenses Screen")
    }
}
