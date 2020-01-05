package com.develop.guestbook.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
public class HomeControllerTest {
	@Autowired
	private WebApplicationContext wac;
	
    private MockMvc mockMvc;
   
    @BeforeEach
    public void setUp() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
	@Test
	@DisplayName("Test")
	public void testHomeController() throws Exception {
		mockMvc
		.perform(get("/"))
		.andExpect(status().isOk())
		.andExpect(forwardedUrl("/WEB-INF/views/home.jsp"));
	}

}
