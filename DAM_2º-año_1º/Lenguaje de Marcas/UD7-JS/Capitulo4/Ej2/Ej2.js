function calculadora(a, b, ope){
    switch(ope){
        case "suma":
            return a + b;
        case "resta":
            return a - b;
        case "multiplicacion":
            return a * b;
        case "division":
            if(b == 0){
                return "ERROR"
            }else{
                return a/b;
            }
    }
}