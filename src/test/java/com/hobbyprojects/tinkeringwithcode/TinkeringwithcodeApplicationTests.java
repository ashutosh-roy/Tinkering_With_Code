package com.hobbyprojects.tinkeringwithcode;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TinkeringwithcodeApplicationTests {

  @Test
  void contextLoads() {}

  @Test
  void testApplication() {
    try (final MockedStatic<SpringApplication> utilities = mockStatic(SpringApplication.class)) {
      utilities
          .when(
              (MockedStatic.Verification) SpringApplication.run(TinkeringwithcodeApplication.class))
          .thenReturn(null);
      TinkeringwithcodeApplication.main(new String[] {});
      assertNull(SpringApplication.run(TinkeringwithcodeApplication.class));
    }
  }
}
