# Union Find 

Union : 서로 다른 두 개의 집합을 하나의 집합으로 만드는 것. 

Find : 하나의 원소가 어느 집합에 속해있는지 찾는 것.

즉, Graph에서 두 노드가 같은 집합에 속해있는지 확인하는 것이다.

<img src="../youngjoon/imgs/Union_find-1.png" alt="Union_find-1" width="300"/>

<img src="../youngjoon/imgs/Union_find-2.png" alt="Union_find-2" width="300"/>

이를 구현하기 위해서는 Parent vector, rank(depth) vector 가 필요하다. 

