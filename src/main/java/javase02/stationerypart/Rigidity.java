package javase02.stationerypart;

public enum Rigidity {

    H6(1),
    H5(2),
    H4(3),
    H3(4),
    H2(5),
    H(6),

    F(7),
    HB(8),

    B(9),
    B2(10),
    B3(11),
    B4(12),
    B5(13),
    B6(14),
    B7(15),
    B8(16);


    int index;

    Rigidity(int index){ this.index = index; }
}
