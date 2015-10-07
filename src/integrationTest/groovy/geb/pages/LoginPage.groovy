package geb.pages

import geb.Page

/**
 * Created by blindweasel on 10/6/15.
 */

class LoginPage extends Page
{
    static url = '/login'
    static at = { $('h2', 0).text() == 'Login' }
    static content = {
        twitterSignin { $('button', name: 'twitterSignin') }
    }

    void loginWithTwitter() {
        twitterSignin.click()
    }
}
