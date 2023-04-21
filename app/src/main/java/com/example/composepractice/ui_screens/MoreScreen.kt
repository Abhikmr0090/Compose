package com.example.composepractice.ui_screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.example.composepractice.R
import com.example.composepractice.models.IndustriesListItem

data class IndustriesList(
    var isSelected: Boolean = false,
    val industry: String
)

val industriesList = listOf(
    IndustriesList(false, "First"),
    IndustriesList(false, "Second"),
    IndustriesList(false, "Third"),
    IndustriesList(false, "Fourth"),
    IndustriesList(false, "Fifth"),
    IndustriesList(false, "Sixth"),
    IndustriesList(false, "Seventh"),
    IndustriesList(false, "Eighth")
)

val mldIndustries = mutableStateOf(industriesList)

@Composable
fun MoreScreen(navController: NavController?) {
    val showDialog = remember {
        mutableStateOf(false)
    }

    if (showDialog.value)
        ShowDialog()

    Button(onClick = { showDialog.value = true }) {
        Text(text = "Select Industries")
    }
}

@Composable
fun ShowDialog() {

    val selectedIndustries = remember {
        mutableStateOf(mutableListOf<IndustriesListItem>())
    }

    var isSelected by remember {
        mutableStateOf(false)
    }

    Dialog(
        onDismissRequest = { /*TODO*/ }, properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = true
        )
    ) {
        Column {
            LazyRow(modifier = Modifier
                .wrapContentSize()
                .padding(6.dp)) {
                items(selectedIndustries.value.size) { pos ->
                    if (isSelected){
                        Log.d("TAG", "ShowDialog: ${selectedIndustries.value}")
                        SelectedIndustries(selectedIndustries.value[pos].name.toString())
                    }
                }
            }

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(Color.Black)
            ) {}

            LazyColumn {
                items(industriesList.size) { pos ->
                    IndustriesItem({ selected,industry ->
                        isSelected = selected
                        selectedIndustries.value.add(IndustriesListItem(name = industry, id = 1, imageUrl = null))
                    }, industriesList[pos].industry)
                }
            }
        }
    }
}

@Composable
fun IndustriesItem(isChecked: (Boolean,String) -> Unit, industry: String) {
    var isIndustryChecked by remember {
        mutableStateOf(false)
    }

    Row(modifier = Modifier.fillMaxWidth()) {
        ConstraintLayout {
            val (checkbox, industryName) = createRefs()
            Checkbox(
                modifier = Modifier.constrainAs(checkbox) {

                },
                checked = isIndustryChecked, onCheckedChange = {

                     isChecked.invoke(isIndustryChecked,industry)
                     isIndustryChecked = !isIndustryChecked
                },
            )
            Spacer(modifier = Modifier.width(12.dp))
            Text(modifier = Modifier.constrainAs(industryName) {
                start.linkTo(checkbox.end)
                bottom.linkTo(checkbox.bottom)
                top.linkTo(checkbox.top)
            }, text = industry)
        }
    }
}

@Composable
fun SelectedIndustries(industry: String) {
    Card(modifier = Modifier
        .clip(RoundedCornerShape(15.dp))
        .padding(3.dp)) {
        Row {
            Text(modifier = Modifier.padding(4.dp), text = "Industries")
            Image(
                modifier = Modifier
                    .size(20.dp)
                    .padding(start = 4.dp, end = 4.dp)
                    .align(alignment = Alignment.CenterVertically),
                painter = painterResource(id = R.drawable.cross_icon_svg),
                contentDescription = null
            )
        }
    }
}

@Preview(device = Devices.PIXEL_4_XL, showBackground = true)
@Composable
fun Prev() {
    //  MoreScreen(navController = null)
    ShowDialog()
}