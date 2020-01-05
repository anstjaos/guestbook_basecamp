package com.develop.guestbook.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration()
public class WriteGuestbookControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void emailTest() throws Exception {
		this.mockMvc.perform(
				post("/write")
					.param("email", "awserasd")
					.param("password", "1234567")
					.param("contents", "This is test!"))
				.andExpect(view().name("redirect"));
		
		this.mockMvc.perform(
				post("/write")
					.param("email", "test@")
					.param("password", "1234567")
					.param("contents", "This is test!"))
				.andExpect(view().name("redirect"));
		
		this.mockMvc.perform(
				post("/write")
					.param("email", "test@asdf")
					.param("password", "1234567")
					.param("contents", "This is test!"))
				.andExpect(view().name("redirect"));
	}
	/*
	@Test
	public void writeGuestbook() throws Exception {
		this.mockMvc.perform(
				post("/write")
					.param("email", "test@test.com")
					.param("password", "1234567")
					.param("contents", "This is test!"))
				.andExpect(redirectedUrl("/"));
	}
	*/
	@Test
	public void testWriteguestbookPage() throws Exception {
		this.mockMvc.perform(get("/writeGuestbook"))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/writeGuestbook.jsp"));
	}
	
}
