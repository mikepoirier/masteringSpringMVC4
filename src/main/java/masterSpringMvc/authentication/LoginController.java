package masterSpringMvc.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * LoginController
 *
 * @author Mike Poirier
 */
@Controller
public class LoginController {
	@RequestMapping("/login")
	public String authenticate()
	{
		return "login";
	}
}
