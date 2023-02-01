package com.rough;

import org.apache.commons.lang.*;

import java.util.*;

public class PrefixTree {
    private Node root;

    public PrefixTree(Node root) {
        this.root = root;
    }

    public void addChild(Node target) {
        Node parent = findPredecessor(root, target);
        parent.addChild(target);
    }

    public Node findPredecessor(Node parent, Node target) {

        for (Node child : parent.getChildren()) {
            if (target.getPrefix().startsWith(child.getPrefix())) {
                return findPredecessor(child, target);
            }
        }
        return parent;
    }

    public Node dfs(Node node) {
        if(!node.hasChild()){
            System.out.println("Processing node with prefix : "+node.getPrefix());
            List<IdentifierRegistration> identifierRegistrations = node.getRegistrationProcess().createRegistration(node.getPrefix(), node.getDigits(), node.getAllocationCode());
            node.getIdentifierRegistrations().addAll(identifierRegistrations);
            return node;
        }
        List<IdentifierRegistration> identifierRegistrationList = new ArrayList<>();
        if(node.getChildren().size() > 0){
            long prevEndNumber = 0;
            if(node.equals(root)){
                prevEndNumber = getStartNumber(node.getPrefix(), node.getDigits())-1;

            }else{
                prevEndNumber = getStartNumber(node.getPrefix(), node.getDigits());

            }

            for (Node child : node.getChildren()) {
                Node  currentNode = dfs(child);
                identifierRegistrationList.addAll(currentNode.getIdentifierRegistrations()) ;

                //for(IdentifierRegistration identifierRegistration : currentNode.getIdentifierRegistrations()){
                if(prevEndNumber + 1 != getStartNumber(child.getPrefix(), child.getDigits())){
                    long startNumber = prevEndNumber + 1;
                    long endNumber = getStartNumber(child.getPrefix(), child.getDigits()) -1;
                    IdentifierRegistration identifierRegistration1 = new IdentifierRegistration(startNumber, endNumber, node.getAllocationCode(),node.getDigits());
                    identifierRegistrationList.add(identifierRegistration1);
                }
                prevEndNumber = getEndNumber(child.getPrefix(), child.getDigits());
                // }
            }
            System.out.println("Processing node with prefix : "+node.getPrefix());

            long endNumber = getEndNumber(node.getPrefix(), node.getDigits());
            if(prevEndNumber + 1 != endNumber){
                long startNumber = prevEndNumber + 1;
                IdentifierRegistration identifierRegistration1 = new IdentifierRegistration(startNumber, endNumber, node.getAllocationCode(),node.getDigits());
                identifierRegistrationList.add(identifierRegistration1);
            }
            node.getIdentifierRegistrations().addAll(identifierRegistrationList);
        }
        return node;
    }

    public Node getRoot() {
        return root;
    }
    private long getStartNumber(String prefix, int digits){
        if("null".equals(prefix)){
            return Long.valueOf(StringUtils.rightPad("1", digits, '0'));
        }else{
            return Long.valueOf(StringUtils.rightPad(prefix, digits, '0'));
        }
    }
    private long getEndNumber(String prefix, int digits){
        if("null".equals(prefix)) {
            return Long.valueOf(StringUtils.rightPad("9", digits, '9'));
        }else {
            return Long.valueOf(StringUtils.rightPad(prefix, digits, '9'));

        }
    }
}
