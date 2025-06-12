package com.karn.adoption;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@WebMvcTest(JoshlongAiPetDemoApplication.class)
class JoshlongAiPetDemoApplicationTests {

	@Test
	void contextLoads() {
		var modules = ApplicationModules.of(JoshlongAiPetDemoApplication.class);
		modules.verify();
		new Documenter(modules).writeDocumentation();
	}

}
