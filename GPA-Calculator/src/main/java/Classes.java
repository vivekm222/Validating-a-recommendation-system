public class Classes {
    String grade;
    String name;
    int credits;
    String honorsap;
    
    public Classes(String grade, String name, int credits, String honorsap) {
        this.grade = grade;
        this.name = name;
        this.credits = credits;
        this.honorsap = honorsap;
    }

    public String getName() {
        return this.name;
    }

    public String getGrade() {
        return this.grade;
    }

    public int getCredits() {
        return this.credits;
    }

    public String getHonorsap() {
        return this.honorsap;
    }
}
