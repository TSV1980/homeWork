//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
Реализовать, с учетом ооп подхода, приложение.
Для проведения исследований с генеалогическим древом.
Идея: описать некоторое количество компонент, например:
модель человека и дерева
Под “проведением исследования” можно понимать например получение всех детей выбранного человека.
Более детальное описание проекта и как его реализовать обсуждали в конце семинара
Сделать PR к проекту: https://github.com/Liberate520/homeWork
В качестве ответа указать ссылку на PR
Ссылка на то как сделать пулреквест смотри в материалах к уроку
Если PR все таки не дается, то можно и ссылкой на гит репозиторий
*/


import family_tree.fam_tree.FamilyTree;
import family_tree.human.Gender;
import family_tree.human.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Human m = new Human("Ольга", Gender.Female, LocalDate.of(1953,6,7));
        Human f = new Human("Владимир", Gender.Male, LocalDate.of(1956,6,7));

        m.setSpouse(f);
        f.setSpouse(m);

        Human s1 = new Human("Сергей", Gender.Male, LocalDate.of(1981,9,9),m,f);
        Human s2 = new Human("Алексей", Gender.Male, LocalDate.of(1983,10,7),m,f);


        Human w1 = new Human("Лена", Gender.Female, LocalDate.of(1982,11,11),null,null);
        Human w2= new Human("Яна", Gender.Female, LocalDate.of(1982,9,9),null,null);

        s1.setSpouse(w1); w1.setSpouse(s1);
        s2.setSpouse(w2); w2.setSpouse(s2);


        Human d1 = new Human("Настя", Gender.Female, LocalDate.of(2006,11,11),w1,s1);
        Human d2 = new Human("Лиза", Gender.Female, LocalDate.of(2005,11,11),w2,s2);



        FamilyTree familyTree = new FamilyTree();
        familyTree.add(m);
        familyTree.add(f);
        familyTree.add(s1);
        familyTree.add(s2);
        familyTree.add(w1);
        familyTree.add(w2);
        familyTree.add(d1);
        familyTree.add(d2);

        familyTree.FindChildrens();

        System.out.println(familyTree);

        System.out.println("Бабушки у " + d1.getName());
        System.out.println(familyTree.findGrandMather(d1));
        System.out.println("Дедушки у " + d1.getName());
        System.out.println(familyTree.findGrandFather(d1));

        System.out.println("Бабушки у " + d2.getName());
        System.out.println(familyTree.findGrandMather(d2));
        System.out.println("Дедушки у " + d2.getName());
        System.out.println(familyTree.findGrandFather(d2));

    }
}
