# :page_facing_up: 신입 사원 [백준 1946번]

:link: [[전체 소스 코드]](https://github.com/seungrokoh/Beakjoon_OnlineJudge/blob/master/%231946/1946.java)
:link: [[문제 풀러 가기]](https://www.acmicpc.net/problem/1946)
***
# __문제 해설__
문제는 **신입 사원의 정보를 저장하는 클래스(Employee)를 만들고 정렬하여 문제를 해결하였습니다.** 문제의 조건을 잘 살펴봐야지 헷갈리지 않기 때문에 먼저 **문제의 조건**을 살펴보겠습니다.

### __문제 핵심 조건__

    다른 모든 지원자와 비교했을 때 서류 성적과 면접 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다.

문제의 조건은 **한 가지 이지만 핵심적인 내용을 모두 담고 있습니다.** 또한 조건에서 힌트 아닌 힌트? 도 제공해주고 있습니다. **적어도 하나가 다른 지원자보다 떨어지지지 않아야 한다.** 라는 조건을 살펴보면 **두 성적 중 하나는 무조건 다른 사람보다 높아야** 합니다. 그렇다면 **두 성적 중 한 가지를 기준으로 잡고 정렬을 했을 때** 다른 성적이 **최저 기준만 넘으면 선발이 될 수 있습니다.** 말로 풀어쓰면 조금 어렵게 느껴질 수 있는데 예제를 살펴보면 쉽게이해할 수 있습니다.

### __예제 1__
문제에서 제시한 5명의 지원자를 **서류 성적이 높은 순**으로 정렬을 한 뒤 데이터 입니다.

    1 4
    2 3
    3 2
    4 1
    5 5

이렇게 정렬을 했을 경우 **가장 첫 번째 지원자는 무조건 합격하게 됩니다.** 왜냐하면 **다른 지원자보다 적어도 1개 이상 높아야 하는데 서류 성적에서 1등이기 때문입니다** 그렇다면 이 후 지원자들은 **무조건 첫 번째 지원자의 서류 성적보다 낮기 때문에 첫 번째 지원자의 면접 성적보다 높다면 합격할 수 있는 조건이 됩니다.**

첫 번째 지원자의 면접 성적이 4등 이기 때문에 **두 번째 면접자는 면접 성적이 4등보다 작기만 하면 합격할 수 있습니다.** 따라서 두 번째 지원자는 면접에 합격 할 수 있습니다. 여기서 주의해야 할 점은 **세 번째 합격자를 선발하기 위해 면접 성적 최저 기준을 두 번째 합격자의 면접 성적으로 바꿔야합니다.**

글보단 코드를 보면 더 이해하기 쉽습니다.
***
### __:seedling: main 함수__
`테스트케이스`만큼 입력을 받고 solve함수를 호출하는 함수입니다.
```java
public static void main(String[] args) throws IOException {
    int testCycle = Integer.parseInt(br.readLine());
    for (int i = 0; i < testCycle; i++) {
        List<Employee> employeeList = inputSortedEmployees();
        System.out.println(solve(employeeList));
    }
}
```

### __:seedling: Employee 클래스__
각 지원자의 `서류 순위` 및 `면접 순위`를 저장하는 함수입니다. `Comparable`을 상속하여 서류 순위가 낮은 순으로 정렬 조건을 설정합니다.
```java
static class Employee implements Comparable<Employee>{
    int documentRank;
    int interviewRank;

    public Employee(int documentRank, int interviewRank) {
        this.documentRank = documentRank;
        this.interviewRank = interviewRank;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.documentRank - employee.documentRank;
    }
}
```

### __:seedling: solve 함수__
지원자가 선발 될 수 있는지 확인하여 결괏값을 내는 함수입니다.
```java
private static int solve(List<Employee> employeeList) {
    int cnt = 0;
    int minInterViewRank = Integer.MAX_VALUE;

    for (Employee employee : employeeList) {
        if (employee.interviewRank < minInterViewRank) {
            cnt++;
            minInterViewRank = employee.interviewRank;
        }
    }
    return cnt;
}
```

### __:seedling: inputSortedEmployees 함수__
신입 사원의 정보를 입력받은 뒤 `서류 성적이 낮은 순`으로 정렬하여 반환하는 함수입니다.
```java
private static List<Employee> inputSortedEmployees() throws IOException {
    int num = Integer.parseInt(br.readLine());
    List<Employee> employeeList = new ArrayList<>();
    for (int j = 0; j < num; j++) {
        String[] rankInput = br.readLine().split(" ");
        employeeList.add(new Employee(Integer.parseInt(rankInput[0]), Integer.parseInt(rankInput[1])));
    }
    Collections.sort(employeeList);
    return employeeList;
}
```
***
# __:bulb: Github에 더 많은 문제 풀이가 있습니다.__
[Programmers 문제 풀이 ](https://github.com/seungrokoh/TIL/Algorithm)

[BaekJoon Online Judge 문제 풀이](https://github.com/seungrokoh/Beakjoon_OnlineJudge)
