import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pruebapracticapmdm.navigation.AppScreen
import com.example.pruebapracticapmdm.screens.Form
import com.example.pruebapracticapmdm.screens.Salute

//Apartado encargado de la navegación entre pantallas
@Composable
fun AppNavigation(modifier: Modifier) {
    val navControlador = rememberNavController()
    var name by rememberSaveable { mutableStateOf("") }
    var surname by rememberSaveable { mutableStateOf("") }
    var dni by rememberSaveable { mutableStateOf("") }
    var age by rememberSaveable { mutableIntStateOf(0) }
    var password by rememberSaveable { mutableStateOf("") }
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
                //,name,surname,dni,age,password
            )
        }
    }
}

fun setValues(pname:String,psurname:String,pdni:String,page:String,ppassword:String,name:String,surname:String,dni:String,age:String,password:String){
    //name=pname
}