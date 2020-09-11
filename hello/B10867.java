import java.util.*;public class B10867 {
    public  static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i<n; i++ ) {
            list.add(sc.nextInt());
        }

        List<Integer> RemoveDupli = new ArrayList<Integer>(new LinkedHashSet<Integer>(list));
        Collections.sort(RemoveDupli);
        for(int i=0; i<RemoveDupli .size(); i++) {
            System.out.print(RemoveDupli .get(i)+ " ");
        }
        System.out.println();
       }
    
}
