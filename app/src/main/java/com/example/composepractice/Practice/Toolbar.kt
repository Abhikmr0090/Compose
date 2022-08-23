package com.example.composepractice

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

@Composable
fun Toolbar(modifier: Modifier = Modifier) {
    val switchState = remember {
        mutableStateOf(false)
    }
    Card(modifier = modifier.fillMaxWidth(), elevation = 14.dp) {
        Row(
            modifier = Modifier
                .height(72.dp)
                .background(color = Color.LightGray)
        ) {
            Icon(
                modifier = Modifier
                    .width(42.dp)
                    .fillMaxHeight()
                    .weight(.2f),
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Spacer(Modifier.width(12.dp))
            Text(
                modifier = Modifier
                    .weight(1f)
                    .align(alignment = Alignment.CenterVertically),
                text = "Compose",
                style = MaterialTheme.typography.h1,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            Switch(modifier = Modifier.align(alignment = Alignment.CenterVertically), checked = switchState.value,
                onCheckedChange = { 
                    switchState.value = it 
                })
        }
    }
    
}

@Preview(showBackground = true)
@Composable
fun ToolbarPreview() {
    ComposePracticeTheme {
        Toolbar()
    }
}
