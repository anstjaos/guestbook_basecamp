package com.develop.guestbook.Controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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
public class HomeControllerTest {
	@Mock
    GuestbookService guestbookService;
	@InjectMocks
    private HomeController homeController;

	@Autowired
	private WebApplicationContext wac;
	
    private MockMvc mockMvc;
    
    @Before
    public void setUp() throws Exception {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }
    
	@Test
	public void testHomeController() throws Exception {
		mockMvc.perform(get("/")).andExpect(status().isOk());
	}

}
