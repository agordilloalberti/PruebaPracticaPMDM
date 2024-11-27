import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebapracticapmdm.navigation.AppScreen
import com.example.pruebapracticapmdm.navigation.AppScreen.Form.info
import com.example.pruebapracticapmdm.screens.Form
import com.example.pruebapracticapmdm.screens.Salute

//Apartado encargado de la navegación entre pantallas
@Composable
fun AppNavigation(modifier: Modifier) {
    val navControlador = rememberNavController()
    NavHost(navController = navControlador, startDestination = AppScreen.Form.route){
        composable(AppScreen.Form.route) {
            Form(navControlador, modifier)
        }
        composable(
            AppScreen.Salute.route)
        {
            Salute(
                navControlador,
                modifier
            )
        }
    }
}