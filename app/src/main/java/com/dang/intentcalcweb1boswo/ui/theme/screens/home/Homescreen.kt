package com.dang.intentcalcweb1boswo.ui.theme.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.compose.rememberNavController
import com.dang.intentcalcweb1boswo.navigation.ROUTE_CALC
import com.dang.intentcalcweb1boswo.navigation.ROUTE_INTENT
import com.dang.intentcalcweb1boswo.navigation.ROUTE_WEB

@Composable
fun Home_Screen(navcontroller: NavHostController) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            text = "Home screen",
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.Cyan
        )
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { navcontroller.navigate(ROUTE_INTENT)},
            modifier = Modifier.width(300.dp)
        ) {
            Text(
                text = "Intent",
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                color = Color.Red
            )}
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {navcontroller.navigate(ROUTE_CALC)},
                modifier = Modifier.width(300.dp)
            ) {
                Text(
                    text = "Calc",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.Serif,
                    color = Color.Red
                )}
                Spacer(modifier = Modifier.height(50.dp))
                Button(
                    onClick = { navcontroller.navigate(ROUTE_WEB)},
                    modifier = Modifier.width(300.dp)
                ) {
                    Text(
                        text = "Web",
                        fontSize = 30.sp,
                        fontFamily = FontFamily.Serif,
                        color = Color.Red
                    )
                }



    }
}

@Preview
@Composable
private fun Homepre() {
    Home_Screen(rememberNavController())

}