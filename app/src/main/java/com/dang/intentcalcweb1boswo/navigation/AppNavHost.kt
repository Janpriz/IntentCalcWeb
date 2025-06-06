import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dang.intentcalcweb1boswo.navigation.ROUTE_CALC
import com.dang.intentcalcweb1boswo.navigation.ROUTE_HOME
import com.dang.intentcalcweb1boswo.navigation.ROUTE_INTENT
import com.dang.intentcalcweb1boswo.navigation.ROUTE_WEB
import com.dang.intentcalcweb1boswo.ui.theme.screens.home.Home_Screen
import com.dang.intentcalcweb1boswo.ui.theme.screens.intent.Intent_Screen
import com.dang.intentcalcweb1boswo.ui.theme.screens.web.Web_Screen


@Composable
fun AppNavHost(modifier: Modifier = Modifier,
               navController:NavHostController = rememberNavController(),
               startDestination:String = ROUTE_HOME) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_HOME) {
            Home_Screen(navController)
        }
        composable(ROUTE_INTENT) {
            Intent_Screen(navController)
        }
        composable(ROUTE_WEB) {
            Web_Screen(navController)
        }
        composable(ROUTE_CALC) {
            Calc_Screen(navController)
        }
    }
}

//