package com.ui.espresso

import com.ui.espresso.bases.TestBase
import com.ui.espresso.constants.People
import com.ui.espresso.datamodels.Person
import com.ui.espresso.screens.MainScreen
import com.ui.espresso.screens.PersonDetailScreen
import com.ui.espresso.screens.PersonListScreen
import org.junit.Before
import org.junit.Test

/**
 *   WORK HERE AND CODE AS MUCH TESTING AS YOU WANT
 *   - verify like "Code Master" is displayed
 *   - verify like flaticon is in view.
 *   - verify age or message for "tester"
 */
class PersonListTest : TestBase() {
    // WORK HERE test-c

    @Before
    fun navigateToPersonList(){
        MainScreen.tapPersonListButton()
    }

    @Test
    fun testOpenPersonById(){
        PersonListScreen.person = People.codeMaster
        PersonListScreen.tapPerson()

        PersonDetailScreen.person = People.codeMaster

        PersonDetailScreen.verifyPersonNameText
        PersonDetailScreen.verifyPersonMessageText
    }

    @Test
    fun testPersonDisplayed(){
        PersonListScreen.person = People.tester

        PersonListScreen.verifyIconDisplayed
        PersonListScreen.verifyAgeText
        PersonListScreen.verifyMessageText
    }
}
