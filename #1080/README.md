# :page_facing_up: 행렬 [백준 1080번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231080/1080.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1080)
***
# __문제 해설__

문제는 **단순 비교 연산으로** 해결하였습니다. 문제에서 주어지는 행렬을 비교와 변환(toggle)을 간편하게 하기 위해 boolean[][]으로 정의하였습니다.

문제는 어렵게 보이면서 쉬운? 문제입니다. 풀이는 **문제에 접근하는 방법**과 **예외처리**에 관한 내용 순으로 진행하겠습니다.

### __문제 조건__

1. 행렬A를 변환하는 연산은 행렬A의 3*3크기의 부분행렬의 모든 원소를 뒤집는 것이다.
2. 행렬A를 행렬B로 바꾸는데 필요한 연산(부분행렬 변환)의 최솟값을 구하여라
3. 행렬A를 행렬B로 변환할 수 없다면 -1을 출력

### __문제 접근 방법__
문제의 조건을 보면 행렬A의 부분 행렬(3 by 3)을 변환해 행렬B를 만들 수 있는지 확인해야 하기 때문에 어려워보일 수 있습니다. **하지만** 문제를 조금 간단하게 생각한다면 **행렬의 가장 왼쪽 위 부분 (0,0)부터 오른쪽 아래로 내려가며 비교를 한다면 문제에 접근하는게 쉬워집니다.** 왜냐하면 **부분행렬을 변환해야 하는데 부분행렬의 가장 왼쪽 위 원소는 비교하는 그 순간만 변환할 수 있기 때문입니다.** 말로 풀어쓰기가 조금 힘들지만 그림을 그려보면 쉽게 이해하실 수 있습니다.

행렬A의 (0, 0)을 시작으로 **행렬A와 행렬B의 (i, j)원소가 다를 경우 (i, j)를 부분 행렬의 왼쪽 위로 기준을 잡고 3 by 3행렬을 변환 시킵니다.** 표를 그려보면 아래와 같습니다.

### __예제 1__
문제에 있는 예제를 표로 그려보면 다음과 같습니다.

__행렬 A__
|index|0|1|2|3|
|:---:|-|-|-|-|
|0|0|0|0|0|
|1|0|0|1|0|
|2|0|0|0|0|

__행렬 B__
|index|0|1|2|3|
|:---:|-|-|-|-|
|0|1|0|0|1|
|1|1|0|1|1|
|2|1|0|0|1|

__행렬A의 (0, 0)부터 행렬B와 같은지 비교를 합니다.__

### __Step 1__
행렬A (0,0)과 행렬B (0,0)의 값이 다르기 때문에 (0, 0)기준으로 부분행렬을 만들어 변환합니다.

__변환 후 행렬A__
|index|0|1|2|3|
|:---:|-|-|-|-|
|0|1|1|1|0|
|1|1|1|0|0|
|2|1|1|1|0|

### __Step 2__
행렬A (0,1)과 행렬B (0,1)의 값이 다르기 때문에 (0, 1)기준으로 부분행렬을 만들어 변환합니다.

__변환 후 행렬A__
|index|0|1|2|3|
|:---:|-|-|-|-|
|0|1|0|0|1|
|1|1|0|1|1|
|2|1|0|0|1|

### __Step 3__
이 후 **더 이상 부분행렬을 만들 수 없기 때문에 비교를 중단합니다.** 비교를 중단 한 뒤 배열A와 배열B가 동일한지 검사합니다. **여기서 주의깊게 봐야 할 점은 행렬의 (i, j)의 원소만을 비교한 뒤 변환하는 것입니다.** 이유는 오른쪽 아래로 내려가며 비교하기 때문에 **(i, j)번째 원소를 검사하는 순간에만 변환될 수 있기 때문입니다.**

### __예외 사항__
주의 해야 할 사항은 **주어지는 행렬이 3 by 3 보다 작은 경우** 입니다. 이 경우 변환을 할 수 없기 때문에 배열이 같은지만 확인하면 됩니다. 간단하게 확인하는 방법은 아래와 같습니다.

    input
    1 1
    1
    1

    answer
    0

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    height = Integer.parseInt(input[0]);
    width = Integer.parseInt(input[1]);

    boolean[][] matrixA = getMatrix();
    boolean[][] matrixB = getMatrix();

    System.out.println(solve(matrixA, matrixB));
}
```

### __:seedling: solve 함수__
두 행렬이 같은지 확인하는 함수입니다.
```java
private static int solve(boolean[][] matrixA, boolean[][] matrixB) {
    int ans = 0;
    if (width < 3 || height < 3) {
        return isSameMatrix(matrixA, matrixB) ? ans : -1;
    }

    for (int i = 0; i < height - 2; i++) {
        for (int j = 0; j < width - 2; j++) {
            if (matrixA[i][j] ^ matrixB[i][j]) {
                ans += togglePartialMatrix(matrixA, i, j);
            }
        }
    }
    return isSameMatrix(matrixA, matrixB) ? ans : -1;
}
```

### __:seedling: togglePartialMatrix 함수__
부분 행렬을 변환하는 함수입니다.
```java
private static int togglePartialMatrix(boolean[][] matrixA, int row, int col) {
    for (int i = row; i < row + 3; i++) {
        for (int j = col; j < col + 3; j++) {
            matrixA[i][j] = !matrixA[i][j];
        }
    }
    return 1;
}
```

### __:seedling: isSameMatrix 함수__
두 행렬이 같은지 확인하는 함수입니다.
```java
private static boolean isSameMatrix(boolean[][] matrixA, boolean[][] matrixB) {
    for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
            if (matrixA[i][j] != matrixB[i][j]) return false;
        }
    }
    return true;
}
```

### __:seedling: getMatrix 함수__
행렬을 입력받아 boolean[][]으로 변환하는 함수입니다.
```java
private static boolean[][] getMatrix() throws IOException {
    boolean[][] matrix = new boolean[height][width];
    for (int i = 0; i < height; i++) {
        String row = br.readLine();
        for (int j = 0; j < width; j++) {
            if (row.charAt(j) == '1') {
                matrix[i][j] = true;
            } else {
                matrix[i][j] = false;
            }
        }
    }

    return matrix;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
