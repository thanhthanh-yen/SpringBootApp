package miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import miniProject.commons.FileResponse;
import miniProject.dto.UserDto;
import miniProject.form.LoginForm;
import miniProject.service.StorageService;
import miniProject.service.UserService;

@Controller
public class LoginController {

	@Autowired
	UserService userService;

	@Autowired
	StorageService storageService;

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
			return "redirect:/home";
		} else {
			model.addAttribute("invalidCredentials", true);
			return "login";
		}
	}

	@RequestMapping("/help")
	public String defectDetails() {
		return "help";
	}

	@GetMapping("/home")
	public String getUser(Model model) {
		List<UserDto> userDtos = userService.getUserList();
		model.addAttribute("users", userDtos);
		return "home";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public ResponseEntity<UserDto> insertUser(@Validated(UserDto.New.class) @RequestBody UserDto userDto) {

		UserDto result = userService.insertUser(userDto);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "/add-user1", method = RequestMethod.POST)
	public String insertUser1(@ModelAttribute UserDto userDto) {

		UserDto result = userService.insertUser(userDto);
		return "redirect:/home";
	}

	@PostMapping("/upload-file")
	@ResponseBody
	public FileResponse uploadFile(@RequestParam("file") MultipartFile file) {
		String name = storageService.store(file);

		String uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/uploads/").path(name).toUriString();
		return new FileResponse(name, uri, file.getContentType(), file.getSize());
	}

}
