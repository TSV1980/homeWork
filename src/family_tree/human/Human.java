package family_tree.human;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс "Человек". Определяет всех в любом дереве.
 */
public class Human {

    /**
     * Поле ID
     */
    private long id;

    /**
     * Имя человека
     */
    private String name;

    /**
     * Пол - Мужской или Женский. Задаётся через ENUM.
     */
    private Gender gender;

    /**
     * Дата Рождения
     */
    private LocalDate dateOfBirth;

    /**
     * Дата смерти
     */
    private  LocalDate dateOfDeath;

    /**
     * Ссылка на аналогичный класс человека - Мать
     */
    private  Human mother;

    /**
     * Ссылка на аналогичный класс человека - Отец
     */
    private  Human father;

    /**
     * Перечень ссылок на классы человек - Дети
     */
    private List<Human> children;

    /**
     * Ссылка на аналогичный класс человека - Муж/Жена
     */
    private Human spouse;


    /**
     * Конструктор
     */
    public Human(String name, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human mother, Human father) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate dateOfBirth, Human mother, Human father) {
        this(name, gender, dateOfBirth, null, mother, father);
    }

    /**
     * Добвить ребёнка
     * @param child Указатель на класс ребёнка
     * @return True если добавление прошло удачно
     */
    public  boolean addChild(Human child){
        if (children!= null){
            children.add(child);
            return true;
        }
        return false;
    }

    /**
     * Указать супруга
     * @param human Указатель на класс супруга(-и)
     */
    public void setSpouse(Human human)
    {
        spouse = human;
    }

    /**
     * Добавить родителя
     * @param parent Родитель
     * @return True если добавление прошло удачно
     */
    public boolean addParent(Human parent){
        if (parent!=null && parent.getGenderInfo().equals(Gender.Male)){
            setFather(parent);
            return true;
        } else if (parent!=null && parent.getGenderInfo().equals(Gender.Female)){
            setMother(parent);
            return true;
        }
        return false;
    }

    /**
     * Получить ID
     * @return ID
     */
    public long getId()
    {
        return id;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender(){
        return gender;
    }
    public String getGenderInfo() {
        switch (gender){
            case Male -> {
                return "МУЖ.";
            }
            case Female -> {
                return "ЖЕН.";
            }
        }
        return "Нет Данных";
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public List<Human> getParents(){
        List<Human> parents = new ArrayList<>(2);
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        return parents;
    }

    public int getAge(){
        if (dateOfDeath == null){
            return getPeriod(dateOfBirth, LocalDate.now());
        }else {
            return getPeriod(dateOfBirth, dateOfDeath);
        }
    }

    private int getPeriod(LocalDate dateOfBirth, LocalDate dateOfDeath){
        Period period = Period.between(dateOfBirth, dateOfDeath);
        return  period.getYears();
    }

    @Override
    public String toString() {
        String str = "id: "+ id + " Имя:" + name +
                "   Пол: " + getGenderInfo() + "  " + getBirthdayInfo() + "  " + getMotherInfo() + "  " + getFatherInfo() + "   " + getChildrenInfo() +
                getSpouseInfo() + "\r\n";

        return  str;
    }

    public String getBirthdayInfo()
    {
        return getDateOfBirth().toString();
    }

    public String getSpouseInfo(){

        if (gender == Gender.Male && spouse != null)
        {
             return " Жена: " + spouse.getName();
        }
        if (gender == Gender.Female && spouse != null)
        {
            return " Муж: " + spouse.getName();
        }
        return  "";
    }

    public String getMotherInfo(){
        if (mother != null){
            return "Мать: " + mother.getName();
        }
        else {
            return "Мать: неизвестна";
        }
    }

    public String getFatherInfo(){
        if (father != null){
            return "Отец: " + father.getName();
        }
        else {
            return "Отец: неизвестна";
        }
    }

    public List<Human> getChildren(){
        return  children;
    }

    public String getChildrenInfo(){
        StringBuilder str = new StringBuilder("Дети: ");
        if (children != null && !children.isEmpty()){
            for (Human child : children){
                str.append(child.getName());
                str.append(" ");
            }
        } else {
            str.append(" Отсутствуют");
        }
        return str.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (!(obj instanceof  Human)){
            return false;
        }

        return ((Human) obj).getId() == getId();
    }
}

