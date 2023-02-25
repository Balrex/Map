public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> test_map = new Map<>();
        test_map.AddEl(3, "Addel");
        test_map.AddEl(5, "Back");
        test_map.AddEl(1, "Lily");
        test_map.AddEl(9, "Janny");
        test_map.AddEl(8, "Sam");
        test_map.AddEl(2, "Madam");
        test_map.AddEl(6, "Jerry");
        //test_map.AddEl(5, "Error");
        test_map.AddEl(10, "Rodger");
        Map<Integer, String> copy_map = new Map<>(test_map);
        copy_map.ChandeEl(2, "Sir");
        node copy_el = copy_map.ElemetnPoinet(2);
        node orig_el = test_map.ElemetnPoinet(2);
        if (copy_el != null && orig_el!=null) {
            System.out.println("В орегинале под ключом "+orig_el.key+" хранится значение: "+orig_el.data);
            System.out.println("А в копии по этим же ключом уже: "+copy_el.data);
            System.out.println("-----------------------------------------------------------");
        }
        copy_map.clear();
    }
}
