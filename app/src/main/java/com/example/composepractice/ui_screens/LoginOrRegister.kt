package com.example.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composepractice.ui.theme.ConnectUpBG
import com.example.composepractice.ui.theme.N600

@Composable
fun LoginNavigation(navController: NavController?= null) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = ConnectUpBG)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Row {
                Text(
                    text = "ConnectUp",
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(
                        Font(R.font.montserrat_semibold)
                    )
                )
                Spacer(modifier = Modifier.width(12.dp))
                Image(
                    modifier = Modifier.size(48.dp),
                    painter = painterResource(id = R.drawable.connectup_white_bg),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "Connect with people move up in the world", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = { navController?.navigate( ScreenRoutes.LoginRoute.route) },
                modifier = Modifier
                    .fillMaxWidth(.9f),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = N600
                )
            ) {
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = "Login",
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold))
                )
            }
            
            Spacer(modifier = Modifier.height(4.dp))

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth(.9f),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White
                )
            ) {
                Text(
                    modifier = Modifier.padding(3.dp),
                    text = "Register",
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.montserrat_bold))
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewLogin() {
    LoginNavigation()
}