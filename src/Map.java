public class Map<T1 extends Comparable<T1>, T2> implements Comparable<T1> {
    private node<T1, T2> head;
    private int count;

    private void updateHeight(node n) {
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(node n) {
        return n == null ? -1 : n.height;
    }
    //балансировка
    private int getBalance(node n) {
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }
    //поворот направо
    private node rotateRight(node y) {
        node x = y.left;
        node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    //поворот налево
    private node rotateLeft(node y) {
        node x = y.right;
        node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
    //перебалансировка
    node rebalance(node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }

    //конструктор по умолчанию
    public Map() {
    }

    //конструктор копирования
    public Map(Map<T1, T2> original) {
        this.head=CopeMap(original.head);
    }

    private node CopeMap(node root){
        if (root == null)
            return null;
        System.out.println(root.key);

        node newNode = new node(root.key, root.data, null, null);
        newNode.left = CopeMap(root.left);
        newNode.right = CopeMap(root.right);
        return newNode;
    }

    //добавление элемента
    public  void AddEl (T1 key, T2 data){
        head=insert(head, key, data);
    }
    private node insert(node root, T1 key, T2 data){
        if (root == null) {
            return new node(key, data, null, null);
        } else if (key.compareTo((T1) root.key)<0) {
            root.left = insert(root.left, key, data);
        } else if (key.compareTo((T1) root.key)>0) {
            root.right = insert(root.right, key, data);
        } else {
            throw new RuntimeException("Значению '"+data+"' нужно подобрать другой ключ, т.к. даныый - "+key+" - уже присутсвует в дереве!");
        }
        return rebalance(root);
    }
    //удаление всех элементов
    public void clear() {
        if (head == null)
            System.out.println("Сипсок и так уже псут!");
        else {
            ClearTree(head);
            System.out.println("Список очищен.");
        }
    }
    private void ClearTree(node root){
        if (root.left!=null)
            ClearTree(root.left);
        if (root.right!=null)
            ClearTree(root.right);
        //System.out.println(root.key);
        root.data=null;
        root.key=null;
        root.right=null;
        root.left=null;
        count--;
    }
    //возвращает элемент по ключу
    public node ElemetnPoinet(T1 key){
        node tmp_node = head;
        boolean marker = true;
        do{
            if (key.compareTo((T1) tmp_node.key)<0 && tmp_node.left != null)
                tmp_node = tmp_node.left;
            else if (key.compareTo((T1) tmp_node.key)>0 && tmp_node.right != null)
                tmp_node = tmp_node.right;
            else
                marker = false;
        }while (marker);
        if (key.compareTo((T1) tmp_node.key)==0)
            return tmp_node;
        else {
            System.out.println("Значения с ключом - "+key+" - нет в дереве!");
            return null;
        }
    }

    //изменение значения по ключу
    public void ChangeEl (T1 key, T2 data){
        node tmp_node = head;
        boolean marker = true;
        do{
            if (key.compareTo((T1) tmp_node.key)<0 && tmp_node.left != null)
                tmp_node = tmp_node.left;
            else if (key.compareTo((T1) tmp_node.key)>0 && tmp_node.right != null)
                tmp_node = tmp_node.right;
            else
                marker = false;
        }while (marker);
        if (key.compareTo((T1) tmp_node.key)==0)
            tmp_node.data=data;
        else
            System.out.println("Значения с ключом - "+key+" - нет в дереве!");
    }
    // возвращает колличество элементов в дереве
    public void Size(){
        System.out.println("Элементов в дереве: "+count);
    }

    @Override
    public int compareTo(T1 o) {
        return 0;
    }
}
