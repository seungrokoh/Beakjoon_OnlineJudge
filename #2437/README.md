# :page_facing_up: 저울 [백준 2437번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%232437/2437.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/2437)
***
# __문제 풀이__
문제는 **그리디 알고리즘으로 해결하였습니다.** N개의 저울추가 주어질 때 **측정할 수 없는 최소값을 찾는 문제**입니다. 최소값을 찾는 문제이므로 **가장 무게가 적은 저울추부터 올려가며 잴 수 없는 무게를 찾아내면 문제를 해결할 수 있습니다.** 먼저 문제 조건부터 살펴보겠습니다.

# __문제 조건__
1. 무게가 양의 정수인 N개의 저울추가 주어진다.
2. 저울추의 무게는 중복될 수 있다.
3. 주어진 저울추들로 측정할 수 없는 최소값을 구하여라.

# __문제 접근__
위에서 설명했던 것처럼 **잴 수 없는 최소값**을 구하는 문제이므로 1부터 무게를 올려가며 잴 수 없는 최소값을 구하면 문제를 해결할 수 있습니다. **먼저 저울추를 적은 무게부터 오름차순으로 정렬한 뒤** 하나씩 올려보며 가장 적은 무게부터 차례대로 무게를 확인합니다. 만약 **현재 올리려는 저울추의 무게**가 **지금까지 올린 저울추의 총 합 + 1** 보다 커지는 순간 **저울추의 총 합 + 1이 측정할 수 없는 최소값이 됩니다.** 간단한 예시를 들어보며 설명해보면 다음과 같습니다.

# __예제 1__

    입력 : 주어진 저울추
    1 1 3 7 8

    출력 : 측정할 수 없는 최솟값
    6

간단하게 설명하기 위해 저울추를 오름차순으로 정렬한 값으로 시작하겠습니다.  

저울추의 총 합을 재는 변수는 sum이라 하겠습니다. sum의 초기값은 0이며 **이제 저울추를 하나씩 올려보며 주어진 저울추로 무게는 측정할 수 있는지 검사합니다.**  

__sum 상태 = 0__
**첫 번째로,** 무게가 1인 저울추는 sum + 1보다 크지 않기 때문에 무게 1까지는 측정할 수 있는 무게입니다. 따라서 sum에 첫 번째 저울추의 무게(1)를 더해줍니다. **여기서 살펴보아야 할 점은 sum이 나타내는 건 sum까지 무게를 측정할 수 있다는 의미라는 겁니다.** 다음 단계를 확인할 수록 이해하기 수월해집니다.

__sum 상태 = 1__
**두 번째로,** 무게가 1인 저울추는 sum + 1보다 크지 않기 때문에 무게 2까지는 측정할 수 있는 무게 입니다. 따라서 sum에 두 번째 저울추의 무게(1)를 더해줍니다. **여기까지 보면 무게 1은 무게추 1개로 만들 수 있으며, 무게 2는 무게추 2개로 만들 수 있습니다.**

__sum 상태 = 2__
**세 번째로,** 무게가 3인 저울추는 sum + 1보다 크지 않기 때문에 무게 3까지는 측정할 수 있는 무게 입니다. 따라서 sum에 세번째 저울추의 무게(3)을 더해줍니다.

__sum 상태 = 5__
**네 번재로,** 무게가 7인 저울추는 **sum + 1보다 크기 때문에 sum + 1의 무게는 측정할 수 없습니다.** 왜냐하면 **지금까지 sum의 상태가 5기 때문에 무게 5까지는 측정할 수 있습니다.** 다음으로 **무게6을 재야 하지만 무게 7이 들어오면 더 이상 무게 6을 잴 수 있는 방법이 없기 때문**입니다. 따라서 문제의 답은 sum + 1인 6이 됩니다.

# __이해하고 넘어가기__
먼저 위에서 **sum의 의미는 sum까지 무게를 측정할 수 있다는 의미**라고 하였습니다. 그렇다면 지금까지 가지고 있는 저울추로 1 ~ sum까지는 어떠한 방법으로도 만들 수 있다는 의미가 됩니다. 이제 sum + 1인 값을 만들 수 없다면 그 값이 최솟값이 되는 겁니다. 만약 **sum = 5인 상태에서** 다음 추가할 저울추가 6이라면 해당 저울추로 6도 만들 수 있고 **현재 저울추 무게 + sum 까지의 모든 무게를 만들 수 있습니다.** (6 + 1, 6 + 2, ..., 6 + 5) **하지만 다음 추가할 저울추가 7이라면??? 6을 만들 수 없기 때문에 6이 답이 됩니다.**  


글보단 코드를 보면 더 이해하기 쉽습니다.  

***
### __:seedling: main 함수__

```java
public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());
    int[] weight = getWeights(n);

    System.out.println(solve(weight, n));
}
```

### __:seedling: solve 함수__

```java
private static int solve(int[] weight, int n) {
    Arrays.sort(weight);
    if (weight[0] != 1) return 1;

    int sum = weight[0];

    for (int i = 1; i < n; i++) {
        if (weight[i] > sum + 1) return sum + 1;
        sum += weight[i];
    }
    return sum + 1;
}
```

### __:seedling: getWeights 함수__

```java
private static int[] getWeights(int n) throws IOException {
    String[] input = br.readLine().split(" ");
    int[] temp = new int[n];
    for (int i = 0; i < n; i++) {
        temp[i] = Integer.parseInt(input[i]);
    }
    return temp;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
