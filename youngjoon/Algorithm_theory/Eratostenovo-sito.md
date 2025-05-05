# 에라토스 테네스의 체 

소수를 효율적으로 구하는 방법 


소수를 판별할 범위만큼 배열을 할당하여, 

해당하는 값을 넣어주고, 이후에 하나씩 지워나가는 방법을 이용


1. 배열을 생성하여 초기화한다.
2. 2부터 시작해서 특정 수의 배수에 해당하는 수를 모두 지운다.
(지울 때 자기자신은 지우지 않고, 이미 지워진 수는 건너뛴다.)
3. 2부터 시작하여 남아있는 수를 모두 출력한다.

```cpp
#include <iostream>
#include <vector>
using namespace std;

// 에라토스테네스의 체 함수
void sieveOfEratosthenes(int n) {
    // 소수를 체크하기 위한 boolean 배열 생성
    vector<bool> isPrime(n + 1, true);

    // 0과 1은 소수가 아님
    isPrime[0] = isPrime[1] = false;

    for (int i = 2; i * i <= n; i++) {
        if (isPrime[i]) {
            // i의 배수를 모두 소수가 아니라고 표시
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
        }
    }

    // 소수 출력
    cout << "소수: ";
    for (int i = 2; i <= n; i++) {
        if (isPrime[i]) {
            cout << i << " ";
        }
    }
    cout << endl;
}

// 메인 함수
int main() {
    int n;

    cout << "n을 입력하세요: ";
    cin >> n;

    sieveOfEratosthenes(n);

    return 0;
}
```