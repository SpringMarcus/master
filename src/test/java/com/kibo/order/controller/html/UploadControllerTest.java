package com.kibo.order.controller.html;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kibo.order.app.AppInitializer;
import com.kibo.order.controller.json.AjaxResponse;
import com.kibo.order.controller.json.UploadController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@RunWith(SpringJUnit4ClassRunner.class)
//@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppInitializer.class})
//@WebAppConfiguration not needed because AppInitializer.class implements WebApplicationInitializer
public class UploadControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UploadController uploadControllerUnderTest;

    @Before
    public void setup() {

        // this must be called for the @Mock annotations above to be processed
        // and for the mock interfaces to be injected into the controller under
        // test.
        // or just uncomment @RunWith(MockitoJUnitRunner.class)
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(uploadControllerUnderTest).build();
    }

    @Test
    public void testGiftCertificateUpload() throws Exception {

        // start setup
        String name = "file"; // must match the @RequestParam("file")
        String fileName = "sample_gift_certificates.csv";
        String contentType = "text/csv";
        String fileContent = "giftcertificate,pin,manufacturerid,catalogid,mode,type\n" +
                "6006496960499900121,7288,16036,0,insert,return\n" +
                "6006496960499900139,4487,16036,0,insert,purchase⏎    ";
        MockMultipartFile mockMultipartFile = new MockMultipartFile(name, fileName, contentType, fileContent.getBytes());
        // end setup

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.fileUpload("/upload/").file(mockMultipartFile))
                .andExpect(status().isOk());

        MvcResult mvcResult = resultActions.andReturn();
        String ajaxResponseString = mvcResult.getResponse().getContentAsString();
        AjaxResponse ajaxResponse = decode(ajaxResponseString);

        ////////////
        // ASSERT //
        ////////////

        assertEquals(ajaxResponse.getFileName(), fileName);
        assertEquals(ajaxResponse.getSuccess(), true);
    }

    private static AjaxResponse decode(String s) {
        AjaxResponse example = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            example = mapper.readValue(s, AjaxResponse.class);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return example;
    }

    private static String encode(AjaxResponse example) {
        String s = "";

        try {
            ObjectMapper mapper = new ObjectMapper();
            s = mapper.writeValueAsString(example);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return s;
    }
}