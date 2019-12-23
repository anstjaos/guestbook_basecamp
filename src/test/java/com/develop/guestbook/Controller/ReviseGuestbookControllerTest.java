package com.develop.guestbook.Controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.develop.guestbook.Service.GuestbookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml", "file:src/main/webapp/WEB-INF/spring/root-context.xml"})
@WebAppConfiguration
public class ReviseGuestbookControllerTest {
	@Mock
    GuestbookService guestbookService;
	@InjectMocks
    private ReviseGuestbookController reviseGuestbookController;

	@Autowired
	private WebApplicationContext wac;
	
    private MockMvc mockMvc;
    
    @Before
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
