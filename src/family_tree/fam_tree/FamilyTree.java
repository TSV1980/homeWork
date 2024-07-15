package family_tree.fam_tree;

import family_tree.human.Gender;
import family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;


public class FamilyTree {

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
        }
        return sb.toString();
    }
}
