package masterSpringMvc.controller;

import masterSpringMvc.profile.UserProfileSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by blindweasel on 9/29/15.
 */
@Controller
public class HomeController
{
    private UserProfileSession userProfileSession;

    @Autowired
    public HomeController(UserProfileSession userProfileSession)
    {
        this.userProfileSession = userProfileSession;
    }

    @RequestMapping("/")
    public String home()
    {
        List<String> tastes = userProfileSession.getTastes();
        if(tastes.isEmpty())
        {
            return "redirect:/profile";
        }

        return "redirect:/search/mixed;keywords=" + StringUtils.join(tastes, ",");
    }
}
