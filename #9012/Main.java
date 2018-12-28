import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int i;
        while(n-->0) {
            boolean isVPS = true;
            String input = br.readLine();
            Stack<Character> stack = new Stack<Character>();
            
            char temp;
            for(i=0; i<input.length(); i++) {
                temp = input.charAt(i);
                
                if(temp == '(') {
                    // 여는 괄호는 스택에 push하여 담는다.
                    stack.push(temp);
                }else if(temp == ')') {
                    // 닫는 괄호가 나온경우 스택의 맨 위의 값이 여는괄호인지 비교한다.
                    if(!stack.isEmpty()) {
                        // 스택이 비어있지 않고 맨위값이 여는 괄호라면 스택의 맨 위값을 pop한다. 
                        stack.pop();
                    }else {
                        isVPS = false;
                        break;
                    }
                }
            }
            
            if(!stack.isEmpty()) isVPS = false;
 
            if(isVPS) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }// end while
    }
}
