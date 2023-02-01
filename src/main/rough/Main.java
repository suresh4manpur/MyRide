import com.rough.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        // List<String []> prefixes = Arrays.asList({"1",""}, "22", "23", "212", "221", "222", "231", "313", "331");
        List<AllocationCode> prefixes = new ArrayList<>();
        //prefixes.add(new AllocationCode("null", "5DIGITPROFEIX"));
        prefixes.add(new AllocationCode("212", "5DIGITPROFEIX212"));
        prefixes.add(new AllocationCode("333", "5DIGITPROFEIX333"));
        prefixes.add(new AllocationCode("221", "5DIGITPROFEIX221"));
        prefixes.add(new AllocationCode("23", "5DIGITPROFEIX23"));
        prefixes.add(new AllocationCode("331", "5DIGITPROFEIX331"));
        prefixes.add(new AllocationCode("33", "5DIGITPROFEIX33"));
        prefixes.add(new AllocationCode("22", "5DIGITPROFEIX22"));



        //prefixes.sort(Comparator.comparing(prefix[0]));
        Collections.sort(prefixes, Comparator.comparing(AllocationCode::getPrefix));
        PrefixTree tree = new PrefixTree(new Node("null", "5DIGITPROFEIX", 5));
        prefixes.forEach(allocationCode ->
                {
                    RegistrationProcess registrationProces1 = new RegistrationProcess(allocationCode.getPrefix(), allocationCode.getCode(), 5);

                    tree.addChild(new Node(allocationCode.getPrefix(), allocationCode.getCode(), 5));


                }
        );
        System.out.println("Traversing the tree");

        Node node = tree.dfs(tree.getRoot());

        for(IdentifierRegistration identifierRegistration : node.getIdentifierRegistrations()){
            System.out.println(identifierRegistration);
        }
        //System.out.println(tree.dfs(tree.getRoot()).getPrefix());


    }
}
class AllocationCode{
    private String prefix;
    private String code;

    public AllocationCode(String prefix, String code) {
        this.prefix = prefix;
        this.code = code;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getCode() {
        return code;
    }
}