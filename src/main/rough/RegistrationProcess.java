package com.rough;

import org.apache.commons.lang.StringUtils;

import java.util.*;

public class RegistrationProcess {
    private String prefix;
    private String allocationCode;
    private int digits;
    private List<IdentifierRegistration> identifierRegistrations;

    public RegistrationProcess( String prefix, String allocationCode, int digits) {

        this.prefix = prefix;
        this.allocationCode = allocationCode;
        this.digits = digits;
        this.identifierRegistrations = new ArrayList<>();
    }

    public List<IdentifierRegistration> createRegistration(String prefix, int digits, String allocationCode){
        long startNumber = getStartNumber(prefix, digits);
        long endNumber = getEndNumber(prefix, digits);
        IdentifierRegistration identifierRegistration = new IdentifierRegistration(startNumber, endNumber, allocationCode, digits);
        identifierRegistrations.add(identifierRegistration);
        return  identifierRegistrations;
    }

    private long getStartNumber(String prefix, int digits){
        return Long.valueOf(StringUtils.rightPad(prefix, digits, '0'));
    }

    private long getEndNumber(String prefix, int digits){
        return Long.valueOf(StringUtils.rightPad(prefix, digits, '9'));
    }
}
