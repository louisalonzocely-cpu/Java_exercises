import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BurbbleSort {

    public static void burbble(List<Integer> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            boolean change = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (list.get(j) > list.get(j+1)) {
                    int temporal = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temporal);
                    change = true;
                }
            }
            
            if (!change) break;
        }
    }

    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>(Arrays.asList(32, 92, 12, 11, 42, 19, 33));

        System.out.println("Antes: " + number);
        burbble(number);
        System.out.println("Despues: " + number);
    }
}
