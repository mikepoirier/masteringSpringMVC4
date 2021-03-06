package masterSpringMvc.search;

import org.springframework.social.twitter.api.SearchParameters;

/**
 * SearchParamsBuilder
 *
 * @author Mike Poirier
 */
public class SearchParamsBuilder {
	public static SearchParameters createSearchParameters(String searchType, String taste)
	{
		SearchParameters.ResultType resultType = getResultType(searchType);
		SearchParameters searchParameters = new SearchParameters(taste);
		searchParameters.resultType(resultType);
		searchParameters.count(3);
		return searchParameters;
	}

	private static SearchParameters.ResultType getResultType(
			String searchType) {
		for(SearchParameters.ResultType knownType : SearchParameters.ResultType.values())
		{
			if(knownType.name().equalsIgnoreCase(searchType))
			{
				return knownType;
			}
		}
		return SearchParameters.ResultType.RECENT;
	}
}
