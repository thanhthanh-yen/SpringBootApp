package miniProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import miniProject.service.StorageService;
import miniProject.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	StorageService storageService;

	@RequestMapping("/help")
	public String defectDetails() {
		return "help";
	}

	@GetMapping("/home")
	public String getUser(Model model, @Param("keyword") String keyword) {
		List<UserDto> userDtos = userService.getUserList();
		if (keyword == null || keyword.isEmpty()) {
			userDtos = userService.getUserList();
		} else {
			userDtos = userService.searchUser(keyword);
		}
		model.addAttribute("users", userDtos);
		return "home";
	}

	@RequestMapping(value = "/add-user", method = RequestMethod.POST)
	public ResponseEntity<UserDto> insertUser(@RequestBody UserDto userDto) {

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

	@RequestMapping(value = "/update-user", method = RequestMethod.POST)
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {

		UserDto result = userService.updateUser(userDto);
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(result, HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@RequestMapping(value = "/update-user1", method = RequestMethod.POST)
	public String updateUser1(@ModelAttribute UserDto userDto) {

		UserDto result = userService.updateUser(userDto);
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
