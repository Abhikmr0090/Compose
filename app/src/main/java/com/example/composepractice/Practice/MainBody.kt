package com.example.composepractice

import android.util.Log
import androidx.compose.animation.Animatable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Composable
//fun MessagesList(value: List<MessageModel>) {
//
//    val messagesList = remember { mutableStateOf(value)}
//
//    val recyclerViewState = rememberLazyListState()
//    LazyColumn(modifier = Modifier
//        .fillMaxWidth()
//        .padding(8.dp),
//            state = recyclerViewState,
//            reverseLayout = true) {
//
//           items(messagesList.value){ msg ->
//               MessageLayout(message = msg.msg)
//           }
//
//        }
//    }

//@Composable
//fun MessageLayout(message : String) {
//    Log.d("TAG", "MessageLayout: $message")
//    Row(modifier = Modifier
//        .background(color = Color.Gray)
//        .clip(RoundedCornerShape(18.dp))) {
//        Text(text = message)
//    }
//}

//@Composable
//fun EditMessageLayout(sendMessage: (MessageModel) -> Unit = {}) {
//
//    val message           = remember{ mutableStateOf("") }
//    val rememberLikeIcon  = remember{ mutableStateOf(false) }
//    val rememberHeartIcon = remember{ mutableStateOf(false) }
//
//
//    Column(modifier = Modifier
//        .fillMaxWidth(),
//    verticalArrangement = Arrangement.Bottom) {
//
//        TextField(modifier = Modifier.fillMaxWidth(),
//            value = message.value,
//            onValueChange =  {message.value = it},
//            colors = TextFieldDefaults.textFieldColors(
//                backgroundColor = Color.White,
//                cursorColor = Color.Black,
//                errorIndicatorColor = Color.Red,
//                focusedIndicatorColor = Color.Transparent,
//                unfocusedIndicatorColor = Color.Transparent,
//            ),
//            placeholder = { Text(
//            text = "Write Something"
//        )})
//
//        Row(modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .background(color = Color.White),
//            horizontalArrangement = Arrangement.SpaceEvenly,
//            verticalAlignment = Alignment.CenterVertically) {
//            IconButton(onClick = { rememberLikeIcon.value = !rememberLikeIcon.value }) {
//                if (rememberLikeIcon.value) {
//                    Icon(imageVector = Icons.Filled.ThumbUp, contentDescription = null, tint = Color.Blue)
//                }else{
//                    Icon(imageVector = Icons.Outlined.ThumbUp, contentDescription = null)
//                }
//            }
//
//
//            Icon(imageVector = Icons.Outlined.Email , contentDescription = null)
//            Icon(imageVector = Icons.Outlined.Call, contentDescription = null)
//            Icon(imageVector = Icons.Outlined.Warning , contentDescription = null)
//            IconButton(onClick = {rememberHeartIcon.value = !rememberHeartIcon.value}) {
//                if (rememberHeartIcon.value) {
//                    Icon(
//                        imageVector = Icons.Filled.Favorite,
//                        contentDescription = null,
//                        tint = Color.Red
//                    )
//                } else
//                    Icon(imageVector = Icons.Outlined.Favorite, contentDescription = null)
//            }
//
//            SendButton(message.value,onClick = {
//                sendMessage(MessageModel(message.value))
//                message.value = ""
//            })
//        }
//
//    }
//}

//@Composable
//fun SendButton(message : String,onClick : () -> Unit) {
//    Button(onClick = { onClick.invoke()  }, enabled = message.isNotEmpty()) {
//        Text(text = "Send")
//    }
//}





@Preview(showBackground = true)
@Composable
fun ShowPreview(){
 // Animation()
}