package masterSpringMvc.search;

import masterSpringMvc.search.cache.SearchCache;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by blindweasel on 9/29/15.
 */
@Service
@Profile("!async")
public class SearchService implements TwitterSearch
{
    private SearchCache searchCache;

    @Autowired
    public SearchService(SearchCache searchCache)
    {
        this.searchCache = searchCache;
    }

    public List<LightTweet> search(String searchType, List<String> keywords)
    {
        return keywords.stream()
                .flatMap(keyword -> searchCache.fetch(searchType, keyword).stream())
                .collect(Collectors.toList());
    }
}
