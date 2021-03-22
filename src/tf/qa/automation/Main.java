package tf.qa.automation;


import java.util.Iterator;

public class Main {

    public static void main(final String[] args) {

        MyCollection<Integer> collection = new MyCollection<>();
        collection.add(11);
        collection.add(12);
        collection.add(13);
        collection.add(14);
        collection.add(15);

        Iterator<Integer> it = collection.iterator();

        Object result;

        //1.реализация public void remove() для MyIterator  !!! не работает пока
       /* System.out.println("\nbefore: ");
        for (Object o : collection) {
            System.out.println(o);
        }

        if (it.next().equals(12)) {
        it.remove();
        }

        System.out.println("result: ");
        for (Object o : collection) {
            System.out.println(o);
        }*/

        //2.реализация toArray()

        System.out.println("result: ");
        collection.toArray();
        for (Object o : collection) {
            System.out.println(o + " ");
        }

        //3. реализация public <T> T[] toArray(T[] a) :
        /*Object[] b = new Object[22];

        result = collection.toArray(b);

        System.out.println("result: " + result);
        Object[] arrObj = (Object[]) result;
        for (Object o : arrObj) {
            System.out.println(o + " ");
            }*/


        //4.реализация boolean remove(Object o)
        /*System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        boolean resIfFalse=collection.remove(a);
        System.out.println("result: " + resIfFalse);


        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }*/

        //5.реализация removeAll(Collection<?> c)
/*
        System.out.println("\n before: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        MyCollection<Integer> collection2 = new MyCollection<>();
        collection2.add(11);
        collection2.add(12);

        resIfFalse = collection.removeAll(collection2);
        System.out.println("result: " + resIfFalse);

        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }*/


        //6.реализация boolean contains(Object o)

        /*System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        resIfFalse=collection.contains(a);
System.out.println("result: " + resIfFalse);

*/
        //7.реализация containsAll(Collection<?> c)
/*
        System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        MyCollection<Integer> collection2 = new MyCollection<>();
        collection2.add(11);
        collection2.add(12);

        resIfFalse = collection.containsAll(collection2);
        System.out.println("result: " + resIfFalse);

        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }*/

        //8.реализация  boolean addAll(Collection<?> c)
        /*System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        MyCollection<Integer> collection2 = new MyCollection<>();
        collection2.add(11);
        collection2.add(12);
        collection2.add(13);
        collection2.add(14);
        collection2.add(15);


        resIfFalse = collection.addAll(collection2);
        System.out.println("result: " + resIfFalse);

        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }
*/
        //9.реализация  boolean retainAll(Collection<?> c)
       /* System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        MyCollection<Integer> collection2 = new MyCollection<>();
        collection2.add(11);
        collection2.add(12);


        boolean resIfFalse = collection.retainAll(collection2);
        System.out.println("result: " + resIfFalse);

        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }*/
        //10.реализация  clear
        /*System.out.println("\nbefore: ");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        collection.clear();

        System.out.println("after: ");
        for (Object o : collection) {

            System.out.println(o + " ");
        }*/
    }
}


