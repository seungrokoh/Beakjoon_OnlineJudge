# __:bulb: [BOJ #11945번 JAVA] (뜨거운 붕어빵) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2311945/11945.java)
***

__단순 swap 문제__ 입니다. 붕어빵 모양이 2차원 배열로 주어지는데 __각 행을 역순으로 바꿔주기만 하면 되는 문제__ 입니다. __문자열 역순으로 출력__ 등의 문제와 같은 문제라고 볼 수 있습니다. 여기서 확인해야 할 점은 각 행을 역순으로 바꿀 때 __모든 index를 확인하는 것이 아닌 열(col)의 1/2만 확인하며 역순으로 변경할 수 있다는 점__ 입니다.


### __:seedling: 붕어빵의 모양을 입력받는 함수__
```java
public static void inputShapeOfBoong(int[][] shapeOfBoong, int n, int m) throws IOException{
    for (int i = 0; i < n; i++) {
        String inputMap = br.readLine();
        for (int j = 0; j < m; j++) {
            shapeOfBoong[i][j] = inputMap.charAt(j) - '0';
        }
    }
}
```
### __:seedling: 붕어빵의 모양을 뒤집는 함수__
```java
public static void solve(int[][] map, int n, int m) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m/2; j++) {
            int temp = map[i][j];
            map[i][j] = map[i][m - 1 - j];
            map[i][m - 1 - j] = temp;
        }
    }
}
```
