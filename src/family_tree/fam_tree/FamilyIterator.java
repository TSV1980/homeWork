package family_tree.fam_tree;

import family_tree.human.Human;

import java.util.List;
import java.util.Iterator;


public class FamilyIterator implements Iterator<Human> {
    private int index;
    private List<Human> humanListList;

    public FamilyIterator(List<Human> humanListList) {
        this.humanListList = humanListList;
    }

    @Override
    public boolean hasNext() {
        return index < humanListList.size();
    }

    @Override
    public Human next() {
        return humanListList.get(index++);
    }
}