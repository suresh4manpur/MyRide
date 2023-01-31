import com.rough.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World!");

       // List<String []> prefixes = Arrays.asList({"1",""}, "22", "23", "212", "221", "222", "231", "313", "331");
        List<String []> prefixes = new ArrayList<>();
        String [] prefix = new String[2];
        prefix[0] = "1";
        prefix[1] = "5DIGITPROFEIX";
        prefixes.add(prefix);

        String [] prefix1 = new String[2];
        prefix[0] = "22";
        prefix[1] = "5DIGITPROFEIX22";
        prefixes.add(prefix1);

        String [] prefix3 = new String[2];
        prefix[0] = "23";
        prefix[1] = "5DIGITPROFEIX23";
        prefixes.add(prefix3);

        String [] prefix4 = new String[2];
        prefix[0] = "212";
        prefix[1] = "5DIGITPROFEIX212";
        prefixes.add(prefix4);

        String [] prefix5 = new String[2];
        prefix[0] = "221";
        prefix[1] = "5DIGITPROFEIX221";
        prefixes.add(prefix5);

        PrefixTree tree = new PrefixTree(new Node("1", "5DIGITPROFEIX", 5));
        prefixes.forEach(data ->
                {
                    if (!"1".equals(data[0])) {
                        RegistrationProcess registrationProces1 = new RegistrationProcess(data[0], data[1], 5);

                        tree.addChild(new Node(data[0], data[1], 5));
                    }

                }
        );
        System.out.println("Traversing the tree");
        System.out.println(tree.dfs(tree.getRoot()).getPrefix());


    }
}
