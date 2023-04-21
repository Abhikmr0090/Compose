package com.example.composepractice

import android.content.Intent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.composepractice.bottomNav.BottomNavItems
import com.example.composepractice.ui.theme.N100

@Composable
fun ProfileScreen(navController: NavController?) {
    fun openCamera () {
        val intent  = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            
        }
    }
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(bottom = 120.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(305.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.primary,
                            MaterialTheme.colors.onSecondary
                        )
                    )
                )
        ) {
            Image(
                modifier = Modifier
                    .align(alignment = Alignment.TopEnd)
                    .padding(top = 22.dp, end = 22.dp)
                    .clickable {
                        navController?.navigate(BottomNavItems.EditProfile.route)
                    },
                imageVector = Icons.Filled.Edit,
                contentDescription = null,
            )

            Image(
                modifier = Modifier
                    .height(305.dp)
                    .fillMaxSize(),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = null,
            )

            Column(modifier = Modifier.align(alignment = Alignment.BottomCenter)) {
                Image(
                    modifier = Modifier
                        .size(135.dp)
                        .align(alignment = Alignment.CenterHorizontally)
                        .clip(RoundedCornerShape(26.dp))
                        .clickable { openCamera() },
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
}

@Preview(showBackground = true)
@Composable
fun PreviewProfile() {
      ProfileScreen(null)
}