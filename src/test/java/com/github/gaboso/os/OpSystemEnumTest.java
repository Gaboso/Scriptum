package com.github.gaboso.os;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OpSystemEnumTest {

    @Test
    void windows_GetOption_AssertTrue() {
        String result = OpSystemEnum.WINDOWS.getOption();
        Assertions.assertEquals("/c", result);
    }

    @Test
    void windows_GetRunner_AssertTrue() {
        String result = OpSystemEnum.WINDOWS.getRunner();
        Assertions.assertEquals("cmd.exe", result);
    }

    @Test
    void linux_GetOption_AssertTrue() {
        String result = OpSystemEnum.LINUX.getOption();
        Assertions.assertEquals("-c", result);
    }

    @Test
    void linux_GetRunner_AssertTrue() {
        String result = OpSystemEnum.LINUX.getRunner();
        Assertions.assertEquals("/bin/bash", result);
    }


}