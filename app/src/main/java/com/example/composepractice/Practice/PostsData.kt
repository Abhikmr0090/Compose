package com.example.composepractice

data class PostsData(
    val userName: String,
    val position: String,
    val profile: Int? = null,
    val post: String,
    val isLiked: Boolean
)

data class Users(
    val userName: String
)

class dummyData {
    val userList = listOf(
        Users("Abhishek"),
        Users("Pushpendra Kumar"),
        Users("Vivek"),
        Users("Sumit"),
        Users("Ashutosh"),
        Users("Abhishek Jha"),
    )

    val list = listOf(
        PostsData(
            "Pushpendra Kumar Pal",
            "SDE - 1 (Android)",
           2,
            "This the testing post",
            false
        ),
        PostsData(
            "Ashutosh Kumar Pandey",
            "SDE - 1 (Android)",
          1,
            R.string.post.toString(),
            true
        ),
        PostsData("Sumit Sharma", "SDE - 1 (Android)", null, "This is the testing post which contains some random text and will be available for testing", false),
        PostsData(
            "Vivek",
            "SDE - 1 (Android)",
            R.drawable.ic_launcher_foreground,
            "This is the testing post which contains some random text and will be available for testing",
            true
        ),
        PostsData("Nitin Sharma", "SDE - 1 (Android)", null, "This is the testing post which contains some random text and will be available for testing", true)
    )
}