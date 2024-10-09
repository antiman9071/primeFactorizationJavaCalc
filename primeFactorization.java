import java.util.*;
public class primeFactorization {
    public static void main(String[] args) {
        int number;
        if(args.length > 0){
            number = Integer.parseInt(args[0]);
        } else {
            Scanner input = new Scanner(System.in);
            System.out.println("What number do you need factored");
            number = input.nextInt();
        }
        ArrayList<Integer> ans = solve(number);
        System.out.println(primeFactorizationToString(ans));
    }
    public static ArrayList<Integer> solve(int number){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int div = 2;
        int test = number;
        while(number > 1){
            test = number/div;
            if(number == (test*div)){
                number = test;
                ans.add(div);
            } else {
                div++;
            }
        }
        return ans;
    }
    public static String primeFactorizationToString(ArrayList<Integer> ans){
        Map<Integer,Integer> test = new HashMap<>();
        for (int i = 0; i < ans.size(); i++) {
            test.putIfAbsent(ans.get(i), Collections.frequency(ans, ans.get(i)));
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Your prime factoriztion is \n");
        for(Map.Entry<Integer, Integer> entry : test.entrySet()){
            sb.append("(" + entry.getKey() + "^" + entry.getValue() + ")");
        }
        sb.append(" or\n");
        sb.append(ans);
        return sb.toString();
    }
}
