package family_tree.fam_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.human.comparators.HumanCompareByAge;
import family_tree.human.comparators.HumanCompareByBirthday;
import family_tree.human.comparators.HumanCompareByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class FamilyTree implements Serializable , Iterable<Human>  {

    private List<Human> humanList;

    public FamilyTree() {
        this.humanList = new ArrayList<>();
    }

    public  boolean add(Human human)
    {
        if (human != null){
            humanList.add(human);
            return  true;
        }
        return  false;
    }

    public void FindChildrens()
    {
        for (Human child : humanList){
            for (Human parent : child.getParents()){
                parent.addChild(child);
            }
        }
    }

    public List<Human> findGrandMather(Human h)
    {
        List<Human> grandmather = new ArrayList<>(0);
        for (Human par : h.getParents()){
            for (Human grandp : par.getParents()){
                if (grandp.getGender() == Gender.Female){
                    grandmather.add(grandp);
                }
            }
        }
        return grandmather;
    }

    public List<Human> findGrandFather(Human h)
    {
        List<Human> grandfather = new ArrayList<>(0);
        for (Human par : h.getParents()){
            for (Human grandp : par.getParents()){
                if (grandp.getGender() == Gender.Male){
                    grandfather.add(grandp);
                }
            }
        }
        return grandfather;
    }



    public  List<Human> getByName(String name){
        List<Human> res = new ArrayList<>();
        for (Human human : humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return  res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Human human : humanList){
            sb.append(human);
            sb.append("\r\n");
        }
        return sb.toString();
    }

    public void sortByAge(){
        humanList.sort(new HumanCompareByAge());
    }

    public void sortByName(){
        humanList.sort(new HumanCompareByName());
    }

    public void sortByBirthday(){
        humanList.sort(new HumanCompareByBirthday());
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Human> iterator() {
        return new FamilyIterator(humanList);
    }

}

