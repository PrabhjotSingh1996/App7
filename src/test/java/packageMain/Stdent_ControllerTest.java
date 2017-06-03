package packageMain;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=App7Application.class,webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Stdent_ControllerTest {

	@LocalServerPort
	private int port;
	private String actualResponse;
	private String expectedResponse;
	private String url="http://localhost:";
	TestRestTemplate testRestTemplate = new TestRestTemplate();
	
	
	@Test
	public void getTest_present() {
		url=url+port+"/student/1";
		actualResponse = testRestTemplate.getForObject(url, String.class);
		expectedResponse = "{name:A,age:13,roll:1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		System.err.println(actualResponse);	
	}
	
	@Test(expected=NullPointerException.class)
	public void getTest_notPresent(){
		url=url+port+"/student/45";
		actualResponse=testRestTemplate.getForObject(url, String.class);
		JSONAssert.assertEquals(null, actualResponse, false);
	}
	
	@Test
	public void getAllTest_present(){
		url=url+port+"/student";
		actualResponse=testRestTemplate.getForObject(url, String.class);
		expectedResponse="[{name:A,age:13.0,roll:1},{name:B,age:14.0,roll:2},{name:C,age:15.0,roll:3},{name:D,age:13.0,roll:4},{name:E,age:12.0,roll:5}]";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		System.err.println(actualResponse);
	}
	
	@Test
	public void getAllTest_notPresent(){
		url=url+port+"/student";
		assertEquals("[]", testRestTemplate.getForObject(url, String.class));
	}
	
	@Test
	public void postTest(){
		url=url+port+"/student";
		actualResponse=testRestTemplate.postForObject(url,new Students("F",19.1) , String.class);
		expectedResponse="{name:F,age:19.1}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
	}
	

	@Test(expected=NullPointerException.class)
	public void putTest_present(){
		
		actualResponse = testRestTemplate.getForObject("http://localhost:"+port+"/student/1",String.class);
		expectedResponse = "{name:A}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
		testRestTemplate.put("http://localhost:"+port+"/student/1", new Students("Prabhjot Singh",20.8));
		
		actualResponse = testRestTemplate.getForObject("http://localhost:"+port+"/student/6",String.class);
		expectedResponse = "{name:Prabhjot Singh}";
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		System.err.println(actualResponse);
		
		actualResponse = testRestTemplate.getForObject("http://localhost:"+port+"/student/1",String.class);
		JSONAssert.assertEquals(null, actualResponse, false);
	}
}
