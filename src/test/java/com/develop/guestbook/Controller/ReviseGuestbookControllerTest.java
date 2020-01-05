package com.develop.guestbook.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

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
public class ReviseGuestbookControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
    private MockMvc mockMvc;
    
    @BeforeEach
    public void setUp() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
	@Test
	public void correctRevise() throws Exception {
		this.mockMvc.perform(post("/reviseGuestbook")
				.param("id", "7")
				.param("email", "test@test.com")
				.param("contents", "This is test!")
				.param("inputPwd", "1234567")
				.param("password", "14f46d77ea836347705366011f4e25c17d2521f156b4227d0f7db1b96ecfb08b"))
			.andExpect(forwardedUrl("/WEB-INF/views/reviseGuestbook.jsp"));
	}

	@Test
	public void wrongRevise() throws Exception {
		this.mockMvc.perform(post("/reviseGuestbook")
				.param("id", "7")
				.param("email", "test@test.com")
				.param("contents", "This is test!")
				.param("inputPwd", "1234567")
				.param("password", "wrongPwd"))
			.andExpect(forwardedUrl("/WEB-INF/views/redirect.jsp"));
	}
	
	@Test
	public void updateGuestbook() throws Exception {
		this.mockMvc.perform(post("/update")
				.param("id", "7")
				.param("contents", "Change contents!"))
			.andExpect(redirectedUrl("/"));
	}
}
