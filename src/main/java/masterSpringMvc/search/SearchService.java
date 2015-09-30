package masterSpringMvc.search;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
public class SearchService
{
    private Twitter twitter;

    @Autowired
    public SearchService(Twitter twitter)
    {
        this.twitter = twitter;
    }

    public List<Tweet> search(String searchType, List<String> keywords)
    {
        List<SearchParameters> searches = keywords.stream().map(taste -> createSearchParam(searchType, taste)).collect(
                Collectors.toList());
        List<Tweet> results = searches.stream().map(params -> twitter.searchOperations().search(params))
                                      .flatMap(searchResults -> searchResults.getTweets().stream())
                                      .collect(Collectors.toList());
        return results;
    }

    private SearchParameters.ResultType getResultType(String searchType)
    {
        for(SearchParameters.ResultType knownType : SearchParameters.ResultType.values())
        {
            if(StringUtils.equalsIgnoreCase(knownType.name(), searchType))
            {
                return knownType;
            }
        }

        return SearchParameters.ResultType.RECENT;
    }

    private SearchParameters createSearchParam(String searchType, String taste)
    {
        SearchParameters.ResultType resultType = getResultType(searchType);
        SearchParameters searchParameters = new SearchParameters(taste);
        searchParameters.resultType(resultType);
        searchParameters.count(3);
        return searchParameters;
    }
}
