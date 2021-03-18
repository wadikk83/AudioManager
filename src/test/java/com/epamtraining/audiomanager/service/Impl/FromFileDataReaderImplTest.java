package com.epamtraining.audiomanager.service.Impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class FromFileDataReaderImplTest {

    @Test
    public void testReadFromFileWithEmptyPath() {
        Assertions.assertTrue(new FromFileDataReaderImpl().readFromFile("").isEmpty());
    }

}