package com.example.composepractice

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.composepractice.ui.theme.N200
import com.example.composepractice.ui.theme.N400
import com.example.composepractice.viewmodels.EditProfileViewModel

@Composable
fun EditProfileScreen(
    navController: NavController? = null,
    viewModel: EditProfileViewModel = EditProfileViewModel()
) {

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White
            ) {
                Image(
                    modifier = Modifier.clickable { navController?.popBackStack() },
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    fontFamily = MontserratBold(),
                    text = "Edit Your Profile",
                    textAlign = TextAlign.Center
                )
            }
        }
    ) {

        EditProfileSection(viewModel)

    }

}

@Composable
fun EditProfileSection(viewModel: EditProfileViewModel) {
    //  var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }

    val firstName = viewModel.firstName
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)
    }
    val imageUri = remember { mutableStateOf<Uri?>(null) }

    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri ->
            imageUri.value = uri
            Log.d("uri", "${imageUri.value}")
        }

    imageUri.let {
        if (Build.VERSION.SDK_INT > 28) {
            val source = it.value?.let { it1 ->
                ImageDecoder.createSource(
                    LocalContext.current.contentResolver,
                    it1
                )
            }
            bitmap.value = source?.let { it1 -> ImageDecoder.decodeBitmap(it1) }
        }
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .align(alignment = Alignment.CenterHorizontally)
        ) {

            Image(
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(26.dp)),
                painter = painterResource(id = R.drawable.ic_person_search),
                contentDescription = null
            )

            bitmap.value?.let {
                Image(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(26.dp)),
                    bitmap = it.asImageBitmap(),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
            }

            Image(
                modifier = Modifier
                    .size(22.dp)
                    .align(alignment = Alignment.Center)
                    .clickable {
                        launcher.launch("image/*")
                    },
                imageVector = Icons.Filled.Edit,
                contentDescription = null
            )


        }

        TextField(
            modifier = Modifier.fillMaxWidth(.95f),
            value = firstName.value,
            onValueChange = { firstName.value = it },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
            },
            placeholder = { Text(text = "First Name") },
            label = { Text(text = "First Name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = N400,
                unfocusedIndicatorColor = N200
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(.95f),
            value = lastName,
            onValueChange = { lastName = it },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Person, contentDescription = null)
            },
            label = { Text(text = "Last Name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = N400,
                unfocusedIndicatorColor = N200
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(.95f),
            value = lastName,
            onValueChange = { lastName = it },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Email, contentDescription = null)
            },
            label = { Text(text = "Email Name") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = N400,
                unfocusedIndicatorColor = N200
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        TextField(
            modifier = Modifier.fillMaxWidth(.95f),
            value = lastName,
            onValueChange = { lastName = it },
            leadingIcon = {
                Icon(imageVector = Icons.Outlined.Phone, contentDescription = null)
            },
            label = { Text(text = "Phone") },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = N400,
                unfocusedIndicatorColor = N200
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewEditProfile() {
    EditProfileScreen()
}