package geb.pages

import geb.Page

/**
 * Created by blindweasel on 10/6/15.
 */
class SearchResultPage extends Page {
    static url = '/search'
    static at = { $('h2', 0).text().startsWith('Tweet results for') }
    static content = {
        resultList { $('ul.collection') }
        results { resultList.find('li') }
    }
}
