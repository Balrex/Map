public class Map<T1 extends Comparable<T1>, T2> implements Comparable<T1> {
    private node<T1, T2> head;
    private int count;

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

        node newNode = new node(root.key, root.data, root.prev, null, null);
        newNode.left = CopeMap(root.left);
        newNode.right = CopeMap(root.right);
        return newNode;
    }

    //добавление элемента
    public  void AddEl (T1 key, T2 data){
        boolean marker = true;
        node tmp_node = new node(key, data, head, null, null);
        if (head == null) {
            head=tmp_node;
            count++;
        } else {
            tmp_node=head;
            do {
                if (key.compareTo((T1) tmp_node.key)<0 && tmp_node.left != null)
                    tmp_node = tmp_node.left;
                else if (key.compareTo((T1) tmp_node.key)>0 && tmp_node.right != null)
                    tmp_node = tmp_node.right;
                else
                    marker = false;
            } while (marker);
            node new_node = new node (key, data, tmp_node, null, null);
            if (key.compareTo((T1) tmp_node.key)<0) {
                tmp_node.left = new_node;
                this.count++;
            }
            else if (key.compareTo((T1) tmp_node.key)>0) {
                tmp_node.right = new_node;
                this.count++;
            }
            else
                System.out.println("Значению '"+data+"' нужно подобрать другой ключ, т.к. даныый - "+key+" - уже присутсвует в дереве!");
        }
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
        System.out.println(root.key);
        root.data=null;
        root.key=null;
        root.prev=null;
        root.right=null;
        root.left=null;
        count--;
    }


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

    public void Size(){
        System.out.println("Элементов в дереве: "+count);
    }



    @Override
    public int compareTo(T1 o) {
        return 0;
    }
}
