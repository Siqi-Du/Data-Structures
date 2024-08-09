public class Array2 {
    private int[] data;
    private int size;

    public Array2(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void add(int index, int e) {
        // 都要先check index
        if (index < 0 || index > size)
            throw new IllegalArgumentException("add failed, illegal index");
        if (size == data.length)
            throw new IllegalArgumentException("add failed, array is already full");
        // or 扩容resize(capacity:2*data.length);
        for (int i = index + 1; i <= size; i++) data[i] = data[i - 1];
        data[index] = e;
        size++;
    }

    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("illegal index");
        int res = data[index];
        for (int i = index; i < size - 1; i++) data[i] = data[i + 1];
        size--;
        data[size] = 0;
        //or 缩容 size == data.length/2 => resize(data.length/2)
        return res;
    }

    //removeDuplicates 见27
    // getSize, getCapacity, isEmpty, toString
    //resize: new int[] newData, for 赋值, data = newData. java 数组名表示reference, 可=


    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i=0; i<data.length; i++){
            sb.append(data[i]+"");
            if(i != data.length-1) sb.append(",");
        }
        sb.append("]");
        return sb.toString();
    }
}




