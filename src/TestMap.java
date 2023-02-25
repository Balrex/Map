public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> test_map = new Map<>();
        test_map.AddEl(3, "Adel");
        test_map.AddEl(5, "Back");
        test_map.AddEl(1, "Lily");
        test_map.AddEl(9, "Janny");
        test_map.AddEl(8, "Sam");
        test_map.AddEl(2, "Madam");
        test_map.AddEl(6, "Jerry");
        //test_map.AddEl(5, "Error");
        test_map.AddEl(10, "Rodger");
        Map<Integer, String> copy_map = new Map<>(test_map);
        node el = copy_map.ElemetnPoinet(2);
        if (el != null)
            System.out.println(el.data);
        copy_map.clear();
    }
}
