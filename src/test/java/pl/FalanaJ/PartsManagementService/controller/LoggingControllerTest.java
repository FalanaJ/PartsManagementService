package pl.FalanaJ.PartsManagementService.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import pl.FalanaJ.PartsManagementService.controller.LoggingController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoggingController.class)
public class LoggingControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testReturnStringMessage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string("Howdy! Check out the Logs to see the output..."));
    }
}
