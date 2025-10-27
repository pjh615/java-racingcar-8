# 2주차 프리코스 - 자동차 경주

- [학습 목표](#학습-목표)
- [과제 진행 요구 사항](#과제-진행-요구-사항)
- [기능 요구 사항](#기능-요구-사항)
    - [입출력 요구 사항](#입출력-요구-사항)
- [프로그래밍 요구 사항](#프로그래밍-요구-사항)
    - [라이브러리](#라이브러리)
- [기능 목록](#기능-목록)
    - [정상 입력](#정상-입력)
    - [예외 처리](#예외-처리)
    - [잘못된 입력](#잘못된-입력)
    - [기능 명세](#기능-명세)
- [Commit convention](#commit-convention)

## 학습 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- 1주 차 공통 피드백(디스코드 참고)을 최대한 반영한다.

## 과제 진행 요구 사항

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-8)저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
      메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

**입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```
pobi,woni,jun
```

- 시도할 횟수

```
5
```

**출력**

- 차수별 실행 결과

```
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```
최종 우승자 : pobi, jun
```

**실행 결과 예시**

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 프로그래밍 요구 사항

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://docs.junit.org/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```
Randoms.pickNumberInRange(0, 9);
```

<!-- TODO -->

## 기능 목록

### 정상 입력

- 경주할 자동차 이름은 쉼표(,)를 기준으로 구분하여 입력한다.
- 자동차 이름은 5자 이하로 입력한다.
- 시도할 횟수는 정수로 입력한다.

### 예외 처리

잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션이 종료된다.

#### 잘못된 입력

- 구분자인 쉼표(,)를 기준으로 자동차 이름이 5자 초과인 입력
- 중복된 자동차 이름을 입력
- 시도할 횟수의 입력이 음수로 입력

### 기능 명세

|         Class         |        Method         |    Input     |    Output     |                Description                 |
|:---------------------:|:---------------------:|:------------:|:-------------:|:------------------------------------------:|
|       InputView       |     inputCarNames     |      -       |    String     |    유저로부터 차의 이름과 쉼표(,)로 이루어진 문자열을 입력받는다.    |
|           -           |   inputAttemptCount   |      -       |    String     |            유저로부터 시도 횟수를 입력 받는다.            |
|      OutputView       |     displayStart      |      -       |       -       |              경주 시작 메시지를 출력한다.              |
|           -           | displayResultsByOrder |              |       -       |              경주 진행 상황을 출력한다.               |
|           -           |     displayWinner     |              |       -       |               최종 우승자를 출력한다.                |
|       Validator       |   isOver5Characters   | List<String> |       -       |           차의 이름이 5자를 초과하는지 검사한다.           |
|           -           |    isDuplicateName    | List<String> |       -       |          차의 이름중 중복되는 것이 있는지 검사한다.          |
|           -           |      isNegative       |     int      |       -       |             시도 횟수가 음수인지 검사한다.              |
|        Parser         |   parseByDelimiter    |    String    | List<String>  |            쉼표를 기준으로 차 이름을 파싱한다.            |
|       Converter       |      stringToInt      |    String    |      int      |             입력된 문자를 정수로 변환한다.              |
| RandomNumberGenerator | randomNumberGenerate  |      -       |      int      |           [0,9]의 정수를 랜덤으로 생성한다.            |
|          Car          |        getName        |      -       |    String     |                차의 이름을 가져온다.                |
|           -           |         move          |     int      |       -       |           입력된 수가 4이상이면 한 칸 전진한다.           |
|           -           |      getPosition      |      -       |      int      |              차의 현재 위치를 가져온다.               |
|         Cars          |     moveByNumber      |      -       |       -       | 차마다 난수를 생성하여 Car.move(randomNumber)를 호출한다. |
|           -           |        getCars        |      -       |   List<Car>   |                차 배열을 반환한다.                 |
|           -           |      findWinners      |      -       |   List<Car>   |                 우승자를 반환한다.                 |
|    GameController     |       gameStart       |      -       |       -       |             경주를 실행하는 주요 로직이다.              |
|      RaceService      |         init          | List<String> |       -       |           RaceService의 초기화를 한다.            |
|           -           |       playRace        |      -       |       -       |             차를 움직이는 로직을 실행한다.              |
|           -           |     getRaceResult     |      -       | StringBuilder |               경주의 결과를 반환한다.                |
|           -           |    getWinnerResult    |      -       |    String     |               경주의 우승자를 반환한다.               |

## Commit convention

[AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고하여 커밋 메시지 작성할
것.

|   Type   |    Description    |
|:--------:|:-----------------:|
|   feat   |     새로운 기능 추가     |
|   fix    |       버그 수정       |
|   docs   |     문서 관련 작업      |
|  style   | 코드 형식, 놓친 세미 콜론 등 |
| refactor |       리팩토링        |
|   test   |    테스트 수정 및 보완    |
|  chore   |     maintain      |

## 체크리스트

### 과제 진행 요구 사항

- [ ] 자동차 경주 저장소를 포크하고 클론하는 것으로 시작한다.
- [ ] 기능을 구현하기 전 README.md에 구현할 기능 목록을 정리해 추가한다.
- [ ] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다. (AngularJS Git Commit Message Conventions을 참고해 커밋 메시지를 작성한다.)

### 기능 요구 사항

- [ ] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [ ] 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [ ] 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- [ ] 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- [ ] 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- [ ] 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

#### 입출력 요구 사항

**입력**

- [ ] 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
- [ ] 시도할 횟수

**출력**

- [ ] 차수별 실행 결과
- [ ] 단독/공동 우승자 안내 문구

### 프로그래밍 요구 사항

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - [ ] 기본적으로 Java Style Guide를 원칙으로 한다.

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

#### 라이브러리

- [ ] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - [ ] Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
    - [ ] 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.

