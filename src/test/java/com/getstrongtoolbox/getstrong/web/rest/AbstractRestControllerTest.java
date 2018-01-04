package com.getstrongtoolbox.getstrong.web.rest;

import com.fasterxml.jackson.databind.ObjectMapper;

abstract class AbstractRestControllerTest {

    static String asJsonString(final Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        }
        catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
