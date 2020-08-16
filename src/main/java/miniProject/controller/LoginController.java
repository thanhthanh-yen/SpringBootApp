package miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import miniProject.dto.UserDto;
import miniProject.form.LoginForm;
import miniProject.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	// get login form page
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		return "login";
	}

	// checking for login credentials
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {

		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		if ("admin".equals(username) && "admin".equals(password)) {
			return "home";
		}
		model.addAttribute("invalidCredentials", true);
		return "login";
	}

	@RequestMapping("/help")
	public String defectDetails() {
		return "help";
	}

	@GetMapping("/list")
	public ResponseEntity<List<UserDto>> getUser() {
		List<UserDto> userDtos = userService.getUserList();
		if (userDtos != null) {
			return new ResponseEntity<>(userDtos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(userDtos, HttpStatus.NOT_FOUND);
		}
	}
}
