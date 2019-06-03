# __:bulb: [BOJ #1463번] (1로 만들기) 문제 풀이__

### :link: [[소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231463/1463.java)
***

다이나믹 프로그래밍의 기본적인 문제라고 말합니다. 하지만 `다이나믹 프로그래밍`을 접해보지 않은 사람들에게는 너무 어렵게 느껴집니다. 문제를 어떻게 접근하는지에 대해 살펴봅시다.

`다이나믹 프로그래밍`은 `점화식`을 세우는 것에서 부터 시작합니다. 그리고 문제를 푸는 방식은 `두 가지`가 존재하는데 `재귀 호출`을 이용하는 방법과 `반복문`을 이용하는 방법이 있습니다. 전자의 경우 `Top-Down`방식이라고 하며 가장 먼저 호출하는 문제가 가장 큰 문제이기 때문이며, 후자의 경우 `Bottom-Up` 방식이라고 하며 가장 작은 문제부터 차례대로 답을 쌓아 올려가기 때문입니다. 두 접근법 모두 `이미 구해진 문제`를 재활용 한다는 개념이 내포되어 있습니다.

##### :seedling: Top-Down 과 Bottom-Up
    * Top-Down 방식 : 가독성이 좋으며 본래 점화식을 이해하기 쉽다.
    * Bottom-Up 방식 : 함수를 별개로 부르지 않아 시간과 메모리를 소량 더 절약할 수 있다.

##### :seedling: 문제 조건
    정수 X에 사용할 수 있는 연산은 총 3가지 이다.
        1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
        2. X가 2로 나누어 떨어지면, 2로 나눈다.
        3. 1을 뺀다.

가장 먼저 `점화식`을 세워보는 연습을 해보자. 숫자 X를 1로 만드는 함수를 f(X)라고 가정해보자. 그럼 다음과 같은 점화식이 나오게 됩니다.

    f(x) = f(x / 3) + 1      if (x % 3 == 0)
         = f(x / 2) + 1      if (x % 2 == 0)
         = f(x - 1) + 1      always

위의 점화식을 보면 `만약 x가 3으로 나누어 떨어진다면` 3으로 나눈 값에 + 1(연산 횟수)를 더해주면 된다. 2로 나누어 떨어진다면 마찬가지 이며, 1을 뺄 수 있는건 항상 있기 때문에 항상 연산을 해주면 됩니다. 여기서 `중요한 점`은 dp로 계산하기 때문에 `어떤 수에서` 3으로 나누는 연산과 2로 나누는 연산, 1을 빼는 연산 중 `가장 작은 값`을 확인해봐야 한다는 점입니다. 표를 보면서 확인해보죠.

##### :seedling: dp 초기값

dp배열을 선언해주고 `초기값`을 모두 -1로 해줍니다.  dp값이 -1이라면 값을 구하지 않은 상태라고 볼 수 있습니다.

x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|-1|-1|-1|-1|-1|-1|-1|-1|-1|-1

##### :seedling: x가 1일 때

먼저 x가 1일 때부터 확인해 봅니다.  
x가 1일 때 `1로 만드는 방법`은 0번의 연산으로 바꿀 수 있습니다. 따라서 dp[1]은 0으로 바뀝니다.

x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|0|-1|-1|-1|-1|-1|-1|-1|-1|-1

##### :seedling: x가 2일 때

x가 2일 경우는 `조건 2`에 걸리기 때문에 2로 나누면 바로 1이 됩니다. 그리고 `조건 3`의 경우는 항상 가능하기 때문에 `조건 2`와 `조건 3`중 최소값을 비교할 수 있습니다. 둘 다 1번의 연산으로 1을 만들 수 있기 때문에 x가 2일 때는 1입니다.

x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|0|1|-1|-1|-1|-1|-1|-1|-1|-1

##### :seedling: x가 3일 때

이제 `x가 3일 때`를 확인해봅시다. 가장 먼저 `조건 1`에 해당하기 때문에 `1번의 연산`으로 1을 만들 수 있습니다.

    조건 3 : 가능 -> 1번의 연산
    조건 2 : 불가능
    조건 1 : 가능 -> f(2) 호출 -> dp[2] + 1 == 2

위의 내용을 보면 먼저 `조건 1`이 가능하기 때문에 연산 시 `1번의 연산`으로 1을 만들 수 있습니다. 다음 `조건 3`이 가능한데 `조건 3`의 경우 f(n - 1) + 1의 연산을 진행할 수 있습니다. 따라서 `f(2)`를 다시 진행하게 되는데 앞에서 `f(2)`의 값은 이미 구해져 있습니다. 결과는 `f(2) + 1 == 2`가 되어 `조건 1`의 연산 결과보다 크므로 `조건 3`의 결과가 저장됩니다.  

x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|0|1|1|-1|-1|-1|-1|-1|-1|-1

##### :seedling: x가 9일때 까지의 연산 결과
이렇게 계속 진행되어 x의 값이 10일 때를 확인해보면 이미 x가 9일때 까지의 값이 구해져 있습니다.

x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|0|1|1|2|3|2|3|3|2|-1

10을 1로 만드는 방법은 2가지의 조건으로 시작할 수 있는데, `2로 나누어 5를 만드는 방법`과 `1을 빼서 9를 만드는 방법`이 존재 합니다. 이렇게만 보면 작은수인 5로 만들어 시작하는 방법을 사용하는게 더 효율적일 것 같지만 9로 만드는 방법은 총 3번의 연산으로 가장 빨리 1로 만들 수 있습니다. 이러한 내용을 `dp표`를 보면 따라가 봅시다.

2로 나누는 시작과 1을 빼는 시작의 flow를 한 번 나열해 보겠습니다.

    2로 나누는 시작
        f(10) -> f(5) + 1
    1을 빼는 시작
        f(10) -> f(9) + 1

여기서 중요한 점은 `이미 앞에서 f(5)와 f(9)의 값을 구했다는 점`입니다. 따라서 2로 나누는 시작은 f(5)의 값인 3 + 1 = 4가 되고 1을 빼는 시작은 f(9)의 값인 2 + 1 = 3이 되어 더 작은 값이 3이 최종 답이 됩니다.

##### :seedling: x가 10일 때
x(index)|1|2|3|4|5|6|7|8|9|10
:----:|-|-|-|-|-|-|-|-|-|-
dp 값|0|1|1|2|3|2|3|3|2|3

> `다이나믹 프로그래밍`의 가장 중요한 점은 `이미 앞에서 계산 한 것의 재사용`입니다.