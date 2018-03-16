package javase02.studypart;

@EnumArgument(argument = "isIntegerMark")
enum Discipline {
    MATH(false),
    ENGLISH(true),
    JAVA(false),
    ALGORITHMS(true),
    ECONOMICS(true);

    private boolean isIntegerMark;

    Discipline(boolean isIntegerMark){
        this.isIntegerMark = isIntegerMark;
    }

    public boolean isIntegerMark() {
        return this.isIntegerMark;
    }
}
