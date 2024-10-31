# [Silver III] 한동이는 공부가 하기 싫어! - 3182 

[문제 링크](https://www.acmicpc.net/problem/3182) 

### 성능 요약

메모리: 31148 KB, 시간: 88 ms

### 분류

브루트포스 알고리즘, 그래프 이론, 그래프 탐색

### 제출 일자

2024년 10월 31일 18:10:05

### 문제 설명

<p>Luke does not like studying, but he really wants to pass the extremely hard exam from the first year.</p>

<p>Somebody has told him that all the students from the second year know the answers from the exam, but that is far from real truth. In fact, no one from the second year knows the answers but they all think that somebody else knows.</p>

<p>Luke chooses some student A and asks him about the answers. Student A says that he/she doesn't know, but that he/she thinks that student B knows the answers. After that, Luke is asking student B, and so on...</p>

<p>When he finally realizes that this method will give him no useful results, he is very sad, but then he realizes that he can meet many older students this way, which could be useful some day.</p>

<p>Write a program to find the student which Luke must ask first, so that the total number of students Luke meets in the process is as high as possible. </p>

### 입력 

 <p>First line of input contains an integer N, 2 ≤ N ≤ 1000, the number of students. Students are designated with numbers from 1 to N.</p>

<p>Each of the following N lines contains one number. First line contains the number denoting the answer of student 1, second line contains the number denoting the answer of student 2, and so on...</p>

### 출력 

 <p>First and only line of output should contain the designation of the student that Luke should ask first.</p>

<p>If there is more than one solution, output the one with the smallest designation. </p>

