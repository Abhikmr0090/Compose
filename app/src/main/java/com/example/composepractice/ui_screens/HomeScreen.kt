package com.example.composepractice

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ConnectUpBG
import com.example.composepractice.ui.theme.N100

@Composable
fun HomeScreen() {
    Box {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 120.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(305.dp)
            ) {
                Image(
                    modifier = Modifier
                        .height(305.dp)
                        .fillMaxSize(),
                    contentScale = ContentScale.Crop,
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                )

                Column(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
                    Image(
                        modifier = Modifier
                            .size(135.dp)
                            .align(alignment = Alignment.CenterHorizontally)
                            .clip(RoundedCornerShape(26.dp)),
                        painter = painterResource(id = R.drawable.ic_person_search),
                        contentDescription = null
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                        text = "Pushpendra Kumar Pal",
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        textAlign = TextAlign.Center
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                        text = "SDE 1",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        textAlign = TextAlign.Center
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
            Text(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
                text = "Looking For",
                fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(start = 12.dp, end = 12.dp),
                text = "Looking For a long long text to be placed here.",
                fontFamily = FontFamily(Font(R.font.montserrat_medium)),
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(32.dp))

            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(12.dp)),
            ) {
                Column(
                    modifier = Modifier
                        .background(color = N100)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        text = "About",
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = Color.Transparent)
                            .padding(start = 24.dp, top = 16.dp, end = 24.dp, bottom = 16.dp),
                        text = "This Section will Show about the user",
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                    .clip(RoundedCornerShape(12.dp)),
            ) {
                Column(
                    modifier = Modifier
                        .background(color = N100)
                        .fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier
                            .background(color = Color.Transparent)
                            .padding(start = 24.dp, top = 24.dp, end = 24.dp)
                            .align(alignment = Alignment.CenterHorizontally),
                        text = "Ideal Contacts",
                        fontFamily = FontFamily(Font(R.font.montserrat_semibold)),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                    IndustriesList(modifier = Modifier.padding(12.dp))
                    IndustriesList(modifier = Modifier.padding(12.dp))
                }
            }
        }

        Row(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(bottom = 56.dp)
                .background(color = Color.White)
                .clip(RoundedCornerShape(topStart = 92.dp, topEnd = 92.dp)),
        ) {
            Image(
                modifier = Modifier
                    .size(48.dp)
                    .align(alignment = Alignment.CenterVertically)
                    .padding(start = 16.dp),
                painter = painterResource(id = R.drawable.cross_icon_svg),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(6.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 4.dp, bottom = 4.dp, end = 16.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = ConnectUpBG
                ),
                shape = RoundedCornerShape(18.dp),
                onClick = { /*TODO*/ }) {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Connect",
                    fontFamily = MontserratBold()
                )
            }
        }

    }
}

@Composable
fun IndustriesList(modifier: Modifier) {
    Box(
        modifier = modifier
            .wrapContentHeight()
            .wrapContentWidth()
            .clip(RoundedCornerShape(28.dp))
    ) {
        Row(
            modifier = Modifier
                .background(color = Color.White)
                .padding(6.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .align(alignment = Alignment.CenterVertically),
                imageVector = Icons.Default.Face,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = ConnectUpBG),
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                modifier = Modifier
                    .padding(end = 3.dp)
                    .align(alignment = Alignment.CenterVertically),
                text = "Artificial Intelligence",
                fontFamily = MontserratMedium(),
                fontSize = 14.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

fun MontserratMedium(): FontFamily {
    return FontFamily(Font(R.font.montserrat_medium))
}

fun MontserratBold(): FontFamily {
    return FontFamily(Font(R.font.montserrat_bold))
}