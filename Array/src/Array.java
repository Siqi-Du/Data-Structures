public class Array<E> {

    private E[] data;  // E 表示一种type
    private int size; // 数组中有多少个元素，并指向首个没有元素的index-> 方便append

    public Array(){this(10);}
    public Array(int capacity){
        data = (E[])new Object[capacity]; // need to initiate an Object[] and cast to E[]
        size = 0;
    }

    public int getSize(){return size;}
    public int getCapacity(){return data.length;}
    public boolean isEmpty(){return size == 0;}

    // 在index位置插入新元素e
    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("add failed, illegal index");
        }
        if(size == data.length){
            //throw new IllegalArgumentException("add failed, array is already full");
            //or 动态扩容
            resize(2*data.length);
        }
        // 从后往前挪(从前往后的话会覆盖)
        for (int i = size-1; i >= index; i--) 
            data[i+1] = data[i];
        data[index] = e;
        size ++ ;
    }
    // append -> add(size,e) , addFirst -> add(0,e);
    // 分析: O(n)
    // 均摊时间复杂度-> assume capacity=n, n+次addLast触法resize，共2n+1次/n ～2
    // 平均addLst -> O(1)
    public void appendLast(E e){
//        if(size == data.length)
//            throw new IllegalArgumentException("append failed, Array is full")
//        data[size] = e;
//        size ++;
        add(size, e); //直接用add
    }
    public void addFirst(E e){
        add(0, e); //直接用add
    }

     //删除,返回删除元素(为什么要return: 因为不一定知道index位置元素类型是什么)
    public E remove(int index){
        if(index <0 || index >= size)
            throw new IllegalArgumentException("remove failed, illegal index");

        E ret = data[index];
        for(int i=index+1; i< size; i ++){
            data[i-1] = data[i];
        }
        size --;
        //!!!!将原来的size所指对象设为null，可以被垃圾回收了 --> loitering游荡 objs != memory leak
        data[size] = null;

        //动态缩容 --> lazy (size == capacity/4)
        // 为什么不是/2 -> 这样会频繁扩容/所容 -> lazy
        if(size == data.length /4 && data.length/2 != 0)
            resize(data.length /2); // length/2 不能=0

        return ret;
    }

    // 动态数组
    private void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity];
        for(int i=0; i<size; i++)
            newData[i] = data[i];
        data = newData;
    }

    // 查询和修改元素
    public E get(int index){
        if(index <0 || index >= size)
            throw new IllegalArgumentException("Get failed, illegal index");
        return data[index];
    }
    public void set(int index, E e){
        if(index <0 || index >= size)
            throw new IllegalArgumentException("Set failed, illegal index");
        data[index] = e;
    }
    public boolean contains(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e)) // equals 是值比较
                return true;
        }
        return false;
    }
    //判断是否存在e，找到返回index，否则返回-1
    public int find(E e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }
    public E pop(){return remove(0);}
    public E removeLast(){return remove(size-1);}
    //从数组中删除首个e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
       StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append('[');

        for(int i=0; i< size; i++){
            res.append(data[i]);
            if(i != size-1)
                res.append(",");
        }
        res.append("]");
        return res.toString();
    }
}
