package com.example.composepractice

sealed class OnBoardingPageData(val image: Int, val mainContent: String, val content: String) {
    object FirstScreen : OnBoardingPageData(
        R.drawable.ic_connect_up,
        "Create Your Profile",
        "Add about yourself, what you\\'re looking for and your ideal contacts."
    )

    object SecondScreen :
        OnBoardingPageData(
            R.drawable.ic_create_profile,
            "Search People",
            "Search your ideal contacts with a range of filters including skill set and industries."
        )

    object ThirdScreen :
        OnBoardingPageData(
            R.drawable.ic_search_people,
            "Connect Up",
            "View profiles, connect up and collaborate! "
        )
}

val onBoardingScreens = listOf(
    OnBoardingPageData.FirstScreen,
    OnBoardingPageData.SecondScreen,
    OnBoardingPageData.ThirdScreen
)