# :page_facing_up: 방 배정 [백준 13300번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%2313300/13300.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/13300)
***
# __문제 풀이__
문제는 **2차원 배열을 이용해 해결하였습니다.** 성별이 0, 1로 주어지는 점과 총 학년은 6학년 밖에 되지 않기 때문에 2차원 배열로 쉽게 해결할 수 있습니다. 먼저 문제의 조건을 살펴보겠습니다.

# __문제 조건__
1. 1학년부터 6학년 까지 학생들이 묵을 방을 배정한다.
2. **남학생은 남학생끼리, 여학생은 여학생끼리** 방을 배정한다.
3. 한 방에는 **같은 학년의 학생들만 배정**해야 한다.
4. 한 방에 **수용할 수 있는 최대 인원수 K가 주어지며 한 방에 한 명만 배정하는 것도 가능하다.**
5. 모든 학생을 배정하기 위해 **필요한 방의 최소 개수를 구하여라.**

# __문제 접근__
먼저 **성별이 0, 1로 주어지기 때문에** 2차원 배열을 만들어 **0번째 행은 여학생, 1번째 행은 남학생으로 설정**합니다. 또한, **각 열의 번호는 학년을 나타냄**으로 성별과 학년을 쉽게 구분할 수 있게 만듭니다.  

문제의 조건 중 **같은 성별끼리 방을 사용할 수 있으며 학년 또한 나누어야 하기 때문에** 2차원 배열을 탐색하며 방에 수용할 수 있는 최대 인원을 채우면서 필요한 방의 개수를 세어줍니다. **필요한 방의 최소 개수를 구하는 것이 목표이기 때문에 최대한 꽉 채워야지 최소의 방 개수를 구할 수 있습니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    String[] input = br.readLine().split(" ");
    int studentNum = Integer.parseInt(input[0]);
    int capacity = Integer.parseInt(input[1]);
    int[][] students = getStudents(studentNum);

    System.out.println(solve(students, capacity));
}
```

### __:seedling: solve 함수__

```java
private static int solve(int[][] students, int capacity) {
    int roomCount = 0;
    for (int i = 0; i < students.length; i++) {
        for (int j = 1; j < students[0].length; j++) {
            if (students[i][j] != 0) roomCount += calcNeedRoom(students[i][j], capacity);
        }
    }
    return roomCount;
}
```

### __:seedling: calcNeedRoom 함수__

```java
private static int calcNeedRoom(int numberOfStudent, int capacity) {
    return numberOfStudent % capacity == 0 ? numberOfStudent / capacity : (numberOfStudent / capacity) + 1;
}
```
### __:seedling: getStudents 함수__

```java
private static int[][] getStudents(int studentNum) throws IOException {
    int[][] temp = new int[2][7];
    for (int i = 0; i < studentNum; i++) {
        String[] input = br.readLine().split(" ");
        int sex = Integer.parseInt(input[0]);
        int grade = Integer.parseInt(input[1]);
        temp[sex][grade] += 1;
    }
    return temp;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
