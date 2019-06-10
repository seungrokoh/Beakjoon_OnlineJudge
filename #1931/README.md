# :page_facing_up: 회의실 배정 [백준 1931번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231931/1931.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1931)
***
문제는 **회의실 정보를 저장하는 Conference 클래스를 만들고 정렬하여 해결하였습니다** 문제를 해결할 때 **정렬 기준**이 중요합니다. 문제를 보며 풀어보겠습니다.

먼저 회의의 **시작시간과 종료시간**이 주어지고 **한 개의 회의실 안에서 최대한 많은 회의가 진행될 수 있도록 회의를 배정해야 하는 문제**입니다. 여기서 가장 많은 회의를 배정할 수 있는 방법은 **회의가 빨리 끝나는 시간 순서대로 정렬**하는 방법입니다. 회의가 빨리 끝나는 순서대로 진행함으로써 앞에서부터 최대한 많은 회의를 진행할 수 있습니다. 다만 **주의해야할 점은 회의가 끝나는 시간이 같다면 회의 시작시간이 빠른 순으로 정렬**을 해야합니다. 이와 같은 이유는 **시작시간과 종료시간이 같은 경우가 존재하기 때문입니다.** 설명은 다음과 같습니다.

### __예제 1__
    (0, 1), (1, 1), (1, 2), (2, 2), (2, 2)

위와 같이 문제가 주어졌을 때 **회의가 끝나는 시간만으로 정렬을 진행 한다면 (1, 2), (2, 2), (2, 2)의 순서가 보장되지 않습니다.** 만약 (2, 2), (1, 2), (2, 2)와 같이 정렬이 된다고 가정하면 쉽게 이해하실 수 있습니다. 따라서 **끝나는 시간이 같다면 시작시간이 빠른 순으로 정렬을 진행해야 문제를 해결할 수 있습니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.

### __:seedling: main 함수__
회의 정보를 입력받고 solve함수를 호출합니다.
```java
public static void main(String[] args) throws IOException {
    int n = Integer.parseInt(br.readLine());

    List<Conference> conferences = getSortedConferenceInfo(n);

    System.out.println(solve(conferences));
}
```
### __:seedling: solve 함수__
최대 회의 갯수를 찾는 함수입니다.
```java
private static int solve(List<Conference> conferences) {
    int ret = 0;
    int start = 0;
    for (int i = 0; i < conferences.size(); i++) {
        if (start <= conferences.get(i).startTime) {
            ret++;
            start = conferences.get(i).endTime;
        }
    }

    return ret;
}
```

### __:seedling: getSortedConferenceInfo 함수__
회의실 정보를 입력받고 정렬한 뒤 반환하는 함수입니다.
```java
static List<Conference> getSortedConferenceInfo(int n) throws IOException {
    List<Conference> temp = new ArrayList<>();
    for (int i = 0; i < n; i++) {
        String[] inputTime = br.readLine().split(" ");
        temp.add(new Conference(Integer.parseInt(inputTime[0]), Integer.parseInt(inputTime[1])));
    }
    Collections.sort(temp);
    return temp;
}
```

### __:seedling: Conference 클래스__
회의실 정보를 저장하고 Comparable을 구현하여 종료시간 기준으로 정렬을 할 수 있는 클래스 입니다.
```java
static class Conference implements Comparable<Conference> {
    int startTime;
    int endTime;

    public Conference(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Conference conference) {
        if (this.endTime < conference.endTime) return -1;
        if (this.endTime == conference.endTime) {
            return this.startTime - conference.startTime;
        }
        return 1;
    }
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
