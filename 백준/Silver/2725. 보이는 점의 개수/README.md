# [Silver II] 보이는 점의 개수 - 2725 

[문제 링크](https://www.acmicpc.net/problem/2725) 

### 성능 요약

메모리: 33240 KB, 시간: 184 ms

### 분류

유클리드 호제법, 수학, 정수론, 누적 합

### 제출 일자

2024년 10월 4일 21:14:45

### 문제 설명

<p>A lattice point (x, y) in the first quadrant (x and y are integers greater than or equal to 0), other than the origin, is visible from the origin if the line from (0, 0) to (x, y) does not pass through any other lattice point. For example, the point (4, 2) is not visible since the line from the origin passes through (2, 1). The figure below shows the points (x, y) with 0 ≤ x, y ≤ 5 with lines from the origin to the visible points.</p>

<p><img alt="" src="https://www.acmicpc.net/upload/images/qqwq.png" style="height:208px; opacity:0.9; width:221px"></p>

<p>Write a program which, given a value for the size, N, computes the number of visible points (x,y) with 0 ≤ x, y ≤ N. </p>

### 입력 

 <p>The first line of input contains a single integer C, (1 ≤ C ≤ 1000) which is the number of datasets that follow. </p>

<p>Each dataset consists of a single line of input containing a single integer N, (1 ≤ N ≤ 1000), which is the size. </p>

### 출력 

 <p>For each dataset, there is to be one line of output consisting of: the dataset number starting at 1, a single space, the size, a single space and the number of visible points for that size. </p>

