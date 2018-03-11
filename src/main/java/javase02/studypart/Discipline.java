package javase02.studypart;

class Discipline {
    private String name;
    private boolean isIntegerMark = true;

    Discipline(String name){
        this.name = name;
    }

    Discipline(String name, boolean isIntegerMark){
        this.name = name;
        this.isIntegerMark = isIntegerMark;
    }

    public boolean isIntegerMark(){
        return this.isIntegerMark;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
