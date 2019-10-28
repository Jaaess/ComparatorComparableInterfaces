import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Jaaess
 * @Date: 28.10.2019, Mo
 **/
public class MyCode {

    /*
    please create a comparator and use it to sort a given set of goods.
    A good is defined by 2 properties:
     a name and an integer value representing the weight of this good.
    Given a set of good objects,

     write a comparator that sorts them in order of decreasing weight;
     if 2 or more goods have the same weight, sort those goods
     alphabetically by name.

     To do this, you must create a Checker class that implements the
     Comparator interface, then write an int compare(Good a, Good b) method
     implementing the Comparator.compare(T o1, T o2) method.

     throw exceptions in case of that the given set is empty or the given
     set is null or at least on good has a negative weight.
     */
    public static void main(String[] args) {

        //simple test
        //List<Good> goods = new ArrayList<Good>();
        Set<Good> goods = new HashSet<Good>();
        Good good1 = new Good("g12", 10);
        goods.add(good1);
        Good good2 = new Good("g3", 10);
        goods.add(good2);
        Good good3 = new Good("g1", 10);
        goods.add(good3);
        Good good4 = new Good("g4", 4);
        goods.add(good4);
        Good good5 = new Good("z", 12);
        goods.add(good5);
        Good good6 = new Good("a", 12);
        goods.add(good6);
        Good good7 = new Good("a", 12);
        goods.add(good7);
        Good good8 = new Good("z", 12);
        goods.add(good8);

        Good[] sortedGoods = sortGoods(goods);
        if (sortedGoods != null) {
            System.out.println("Size is: " + goods.size());
            for (int i = 0; i < sortedGoods.length; i++) {
                System.out.println(sortedGoods[i].getName() + " ");
            }
        } else {
            System.out.println("No goods sorted.");
        }
    }


    public static Good[] sortGoods(Set<Good> goods) {
        //TODO: write your code here
        //final Checker checker = new Checker();
        //Collections.sort((List<Good>) goods, new Checker());
        // Collections.sort(goods);
        return goods.toArray(new Good[goods.size()]);
    }

    public static class Checker implements Comparator<Good> {
        @Override
        public int compare(Good o1, Good o2) {
            Integer weight1 = o1.getWeight();
            Integer weight2 = o2.getWeight();
            if (weight1 > weight2) {
                return -1;
            } else if (weight1 < weight2) {
                return 1;
            } else {
                String name1 = o1.getName();
                String name2 = o2.getName();
                if (name1.compareTo(name2) > 0) {
                    return 1;
                } else if (name1.compareTo(name2) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }

        }
    }

    public static class Good implements Comparable<Good> {
        private String name;
        private int weight;

        public Good(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int compareTo(Good g) {
            Integer weight1 = this.getWeight();
            Integer weight2 = g.getWeight();
            if (weight1 > weight2) {
                return -1;
            } else if (weight1 < weight2) {
                return 1;
            } else {
                String name1 = this.getName();
                String name2 = g.getName();
                if (name1.compareTo(name2) > 0) {
                    return 1;
                } else if (name1.compareTo(name2) < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Good good = (Good) o;

            if (weight != good.weight) return false;
            return name.equals(good.name);
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + weight;
            return result;
        }
    }
}