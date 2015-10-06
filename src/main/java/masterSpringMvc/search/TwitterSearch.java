package masterSpringMvc.search;

import java.util.List;

/**
 * Created by michael.poirier on 10/6/2015.
 */
public interface TwitterSearch {
	List<LightTweet> search(String searchType, List<String> keywords);
}
