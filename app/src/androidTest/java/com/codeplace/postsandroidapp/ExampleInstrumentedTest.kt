package com.codeplace.postsandroidapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.codeplace.postsandroidapp", appContext.packageName)
    }
}

//@RunWith(AndroidJUnit4::class)
//class CommentsScreenTest{
//
//
////    @get:Rule
////    val composeTestRule = createComposeRule()
////
////    @Test
////    fun testEmptyCommentsListShowsEmptyMessage(){
////
////        val sampleCommentsList = listOf(Comment(
////            postId = 1,
////            name = "Leonardo",
////            id = 1,
////            email = "leonardoconsanivaleriano@gmail.com",
////            body = "Lorem ipsum test comment"
////        ))
////
////        composeTestRule.setContent {
////            CommentsScreen(
////                comments = sampleCommentsList
////            )
////        }
////        // Check what screen will be displayed when the list of comments be empty.
////        composeTestRule.onNodeWithTag("filledList")
////            .assertIsDisplayed()
////
////        composeTestRule.onNodeWithTag("emptyListMessage")
////            .assertDoesNotExist()
////    }
//
//
//}