package family_tree.human.comparators;

import family_tree.human.Human;

import java.util.Comparator;

public class HumanCompareByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
