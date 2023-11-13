package com.hobbyprojects.tinkeringwithcode.mock;

import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class LoggingExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        System.out.println("Find the usecase of actually implementing beforeEach in LAMF skeleton");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.out.println("Find the usecase of actually implementing afterEach in LAMF skeleton");
    }
}
