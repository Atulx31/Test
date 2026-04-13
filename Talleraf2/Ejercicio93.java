import java.util.Stack;

public class Ejercicio93{

        
        Stack<Character> pila = new Stack<>();
        String cadString = "((a+b)*5) - 7";
        Boolean correcta = true;

        public void Validarcad(){
        for (int i = 0; i < cadString.length(); i++){
            char c = cadString.charAt(i);

            switch (c) {
                case '(':
                    pila.push(c);
                    break;
                case '[':
                    pila.push(c);
                    break;
                case '{':
                    pila.push(c);
                    break;
                case ')':
                    if(!pila.isEmpty() && pila.lastElement() == '('){
                        pila.pop();
                    }else{
                        correcta = false;
                    }
                    break;
                case ']':
                    if(!pila.isEmpty() && pila.lastElement() == '['){
                        pila.pop();
                    }else{
                        correcta = false;
                    }
                    break;
                case '}':
                    if(!pila.isEmpty() && pila.lastElement() == '{'){
                        pila.pop();
                    }else{
                        correcta = false;
                    }
                    break;
            }

            }
        }
        
        public void Imprimir(){
            Validarcad();
        if (correcta && pila.size() == 0){
            System.out.println("La cadena es correcta");
        } else {
            System.out.println("La cadena es incorrecta");
        }
    }

    
}