public class node<T1, T2>{
    T1 key;
    T2 data;

    node prev;
    node left;
    node right;
    public node (T1 key, T2 data, node<T1, T2> prev, node<T1, T2> left, node<T1, T2> right){
        this.key=key;
        this.data=data;
        this.prev=prev;
        this.left=left;
        this.right=right;
    }
}
