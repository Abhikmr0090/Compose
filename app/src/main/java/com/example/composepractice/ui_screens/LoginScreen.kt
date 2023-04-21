package com.example.composepractice.ui_screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.composepractice.R
import com.example.composepractice.ScreenRoutes
import com.example.composepractice.models.LoginRequest
import com.example.composepractice.network.ApiResult
import com.example.composepractice.ui.theme.ConnectUpBG
import com.example.composepractice.ui.theme.GMAILBTN
import com.example.composepractice.ui.theme.N200
import com.example.composepractice.ui.theme.N400
import com.example.composepractice.viewmodels.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = viewModel()) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isEmailEmpty by remember { mutableStateOf(false) }
    var isPasswordEmpty by remember { mutableStateOf(false) }
    var loadingProgressBar by remember {
        mutableStateOf(false)
    }

    val coroutineScope = rememberCoroutineScope()

    Scaffold {

        Column {

            TopAppBar(
                modifier = Modifier.background(color = ConnectUpBG),
                backgroundColor = ConnectUpBG,
                elevation = 22.dp
            ) {
                Text(
                    modifier = Modifier.padding(start = 12.dp),
                    text = "Connect Up",
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.montserrat_semibold))
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = ConnectUpBG)
                    .verticalScroll(rememberScrollState())
            ) {

                Surface(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .background(color = ConnectUpBG)
                        .clip(RoundedCornerShape(bottomStart = 18.dp, bottomEnd = 18.dp))
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Spacer(modifier = Modifier.height(22.dp))
                        Text(
                            modifier = Modifier
                                .fillMaxWidth(.95f),
                            text = "Welcome Back",
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Start,
                            fontFamily = FontFamily(
                                Font(R.font.montserrat_semibold)
                            )
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(.95f),
                            text = "Login to continue",
                            fontSize = 16.sp
                        )

                        Spacer(modifier = Modifier.height(32.dp))

                        TextField(
                            modifier = Modifier.fillMaxWidth(.95f),
                            value = email,
                            onValueChange = { email = it },
                            placeholder = { Text(text = "Email", color = N400) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_email),
                                    contentDescription = null
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = N200,
                                unfocusedIndicatorColor = N200,
                                backgroundColor = Color.Transparent
                            ),
                            isError = isEmailEmpty
                        )
                        Spacer(modifier = Modifier.height(24.dp))
                        TextField(
                            modifier = Modifier.fillMaxWidth(.95f),
                            value = password,
                            onValueChange = { password = it },
                            placeholder = { Text(text = "Password", color = N400) },
                            leadingIcon = {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_lock_black_32dp),
                                    contentDescription = null
                                )
                            },
                            colors = TextFieldDefaults.textFieldColors(
                                focusedIndicatorColor = N200,
                                unfocusedIndicatorColor = N200,
                                backgroundColor = Color.Transparent
                            ),
                            isError = isPasswordEmpty
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Text(
                            modifier = Modifier
                                .align(alignment = Alignment.End)
                                .padding(end = 12.dp),
                            text = "Forgot Password ?",
                            fontWeight = FontWeight.SemiBold
                        )

                        Spacer(modifier = Modifier.height(12.dp))


                        if (loadingProgressBar)
                          ShowLoader()

                        Button(
                            onClick = {

                                isEmailEmpty    = email.isEmpty()
                                isPasswordEmpty = password.isEmpty()

                                viewModel.login(LoginRequest(email, password))

                                callLoginApi(viewModel,navController,coroutineScope) {
                                    loadingProgressBar = it
                                }

                                Log.d("TAG", "Login: ${viewModel.loginResponse.value}")

                            },
                            modifier = Modifier
                                .fillMaxWidth(.9f)
                                .padding(12.dp),
                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = ConnectUpBG
                            )
                        ) {
                            Text(
                                modifier = Modifier.padding(3.dp),
                                text = "Log in",
                                fontSize = 16.sp,
                                color = Color.Black,
                                fontFamily = FontFamily(Font(R.font.montserrat_bold))
                            )
                        }


                    }
                }

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    buildAnnotatedString {
                        append("Don't have an account ? ")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                textDecoration = TextDecoration.Underline,
                            )
                        ) {
                            append("Sign Up")
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium))
                )

                Spacer(modifier = Modifier.height(40.dp))

                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "or Sign in with",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.montserrat_medium))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Button(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(38.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = GMAILBTN
                        ),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("G")
                            }
                        }, textAlign = TextAlign.Center)
                    }

                    Spacer(modifier = Modifier.width(12.dp))

                    Button(
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(38.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Blue
                        ),
                        onClick = { /*TODO*/ },
                    ) {
                        Text(text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White,
                                    fontWeight = FontWeight.ExtraBold,
                                    fontSize = 16.sp
                                )
                            ) {
                                append("f")
                            }
                        }, textAlign = TextAlign.Center)
                    }
                }


            }
        }
    }

}

fun callLoginApi(
    viewModel: LoginViewModel,
    navController: NavController,
    coroutineScope: CoroutineScope,
    progressBar: (Boolean) -> Unit,
) {
    coroutineScope.launch {
        viewModel.loginResponse.collect {
            when (it) {
                is ApiResult.Loading -> {
                   progressBar.invoke(true)
                }

                is ApiResult.Success -> {
                    progressBar.invoke(false)

                    navController.navigate(ScreenRoutes.HomeRoute.route) {
                        popUpTo(ScreenRoutes.OnBoardingRoute.route) {
                            inclusive = true
                        }
                    }
                }

                is ApiResult.Error -> {
                    progressBar.invoke(false)
                }
                else -> {}
            }
        }
    }
}

@Composable
fun ShowLoader() {
    CircularProgressIndicator(modifier = Modifier.size(60.dp), strokeWidth = 5.dp, color = ConnectUpBG)
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ShowLoader()
}