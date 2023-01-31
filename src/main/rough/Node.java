package com.rough;

import java.util.*;

public class Node {
    private List<Node> children;
    private String prefix;
    private String allocationCode;
    private RegistrationProcess registrationProcess;
    private List<IdentifierRegistration> identifierRegistrations;
    private int digits;

    public Node(String prefix,String allocationCode,int digits) {
        this.digits = digits;
        this.children = new ArrayList<>();
        this.prefix = prefix;
        this.registrationProcess = new RegistrationProcess(prefix, allocationCode, digits);
        this.identifierRegistrations = new ArrayList<>();
        this.allocationCode = allocationCode;
    }
    public void addChild(Node node){
        children.add(node);
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getPrefix() {
        return prefix;
    }
    public boolean hasChild(){
        return children.size() > 0;
    }

    public RegistrationProcess getRegistrationProcess() {
        return registrationProcess;
    }

    public List<IdentifierRegistration> getIdentifierRegistrations() {
        return identifierRegistrations;
    }

    public String getAllocationCode() {
        return allocationCode;
    }

    public int getDigits() {
        return digits;
    }
}
