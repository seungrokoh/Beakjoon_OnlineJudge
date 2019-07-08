# :page_facing_up: 배열 합치기 [백준 11728번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2311728/11728.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/11728)
***
문제는 **정렬을 이용해 해결하였습니다.** 문제가 쉬운 관계로 간단하게 설명 드리겠습니다.

먼저 문제의 조건을 보면 **주어지는 두 배열을 합친 뒤 정렬하여 출력하라.** 입니다. 즉, 주어지는 **두 배열을 합친 길이 만큼의 새로운 배열을 생성** 한 뒤 두 배열의 값을 모두 넣습니다. 이 후 **Arrays.sort()를** 이용해 정렬 한 뒤 출력하면 문제를 해결할 수 있습니다.

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int sizeA = Integer.parseInt(input[0]);
    int sizeB = Integer.parseInt(input[1]);
    int[] arrA = getArray(sizeA);
    int[] arrB = getArray(sizeB);

    solve(arrA, arrB, sizeA, sizeB);
}
```

### __:seedling: solve 함수__

```java
private static void solve(int[] arrA, int[] arrB, int sizeA, int sizeB) {
    int[] temp = new int[sizeA + sizeB];

    int index = 0;
    for (int i = 0; i < sizeA; i++) {
        temp[index++] = arrA[i];
    }
    for (int i = 0; i < sizeB; i++) {
        temp[index++] = arrB[i];
    }
    Arrays.sort(temp);
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < temp.length; i++) {
        builder.append(temp[i]).append(" ");
    }
    System.out.println(builder.toString());
}
```

### __:seedling: getArray 함수__

```java
private static int[] getArray(int size) throws IOException {
    int[] temp = new int[size];
    String[] input = br.readLine().split(" ");
    for (int i = 0; i < size; i++) {
        temp[i] = Integer.parseInt(input[i]);
    }
    return temp;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
